#include<stdio.h>
//#include<string.h>
//#include<malloc.h>
//#include<math.h>
//����״̬��
#define OK 1
#define ERROR 0

#define TRUE 1
#define FALSE 0

typedef int Status;
typedef int Boolean;

typedef char ElemType;

#define M 100
#define N 100

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1168���ַ����Ĳ���ɾ��
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��3294�����1294
��Ŀ������
����һ�����ַ����������ո񣩣��ٸ��������ַ���������Щ�ַ�����ɾ�������еĶ��ַ�����
���룺
����ֻ��1�����ݡ�
����һ�����ַ����������ո񣩣������������ַ���ֱ���ļ�����Ϊֹ��
�����
ɾ������Ķ��ַ���(�����ִ�Сд)��ȥ���ո�,�����
�������룺
in
#include 
int main()
{

printf(" Hi ");
}
���������
#clude
tma()
{

prtf("Hi");
}
��ʾ��
ע:���ַ����е�In��IN��iN��inɾ����
��Դ��
2009�걱�����պ����ѧ������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7891-1-1.html
*/

//ɾ��str�ַ���������ֵΪc���ַ�
Status deleteChar(ElemType *str,char c)
{
	int i=0,k=0;
	while(str[k]!='\0')
	{
		if(str[k]!=c)
		{
			str[i]=str[k];
			i++;
		}
		k++;
	}
	str[i]='\0';
	return OK;
}

//ɾ��str�еĿո� �Լ� ��sStr��ȵ��ַ���
Status deleteStr(ElemType str[N],ElemType sStr[N])
{
	int i=0,j=0,k=0;
	while(str[i]!='\0')
	{
	
		if(str[i]==sStr[k])
		{	
			j=i;
			while(str[i]==sStr[k]&&str[i]!='\0'&&sStr[k]!='\0')
			{
				i++;
				k++;
			}
			if(sStr[k]=='\0')
			{
				while(j<i)
				{
					str[j]=' ';
					j++;
				}
			}
			else
			{
				i=j+1;
			}	
			k=0;
		}
		else
		{
			i++;
		}
	}
	deleteChar(str,' ');
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	char str[M][N],sStr[N];
	int i=0,j=0;
	while(scanf("%s",sStr)!=EOF)//while 1#
	{
		getchar();
		while(gets(str[i]))
		{
			deleteStr(str[i],sStr);	
			i++;
		}
		while(j<i)
		{
			printf("%s\n",str[j++]);
		}
	}//end:while 1#

	return OK;
}

int main()
{


	if(ERROR==service())//�����������
	{
		printf("ERROR!\n");
		return ERROR;
	}

	return OK;

}