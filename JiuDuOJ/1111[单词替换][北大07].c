#include<stdio.h>
#include<string.h>
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

//#define M 1000
#define N 1000

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1111�������滻
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��3580�����1015
��Ŀ������
����һ���ַ������Իس��������ַ�������<=100�������ַ��������ɸ�������ɣ�����֮����һ���ո���������е������ִ�Сд��
����Ҫ�����е�ĳ�������滻����һ�����ʣ�������滻֮����ַ�����
���룺
�������ݡ�ÿ�������������3�У�
��1���ǰ���������ʵ��ַ��� s��
��2���Ǵ��滻�ĵ���a��(����<=100)
��3����a�����滻�ĵ���b��(����<=100)
s, a, b ��ǰ�������涼û�пո�.
�����
ÿ�������������ֻ�� 1 �У�
��s�����е���a�滻��b֮����ַ�����
�������룺
You want someone to help you
You
I
���������
I want someone to help you
��Դ��
2007�걱����ѧ������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7834-1-1.html

*/
//��rStr�滻str��ֵΪsStr���ַ���

Boolean matchChar(char c,char mc)
{
	if(c==mc||c+32==mc||c-32==mc)//c��mc��� ���߽��Ǵ�Сд��ͬ
	{
		return TRUE;
	}
	return FALSE;
}
Status replaceStr(ElemType str[N],ElemType sStr[N],ElemType rStr[N])
{
	int i=0,j=0,k=0,m=0;
	int count=0;//Ҫ�滻�Ĵ���
	int rIndex[N];//Ҫ�滻���Ӵ�����ʼλ��
	int lenS=strlen(sStr);
	int lenR=strlen(rStr);
	int len=strlen(str);
	ElemType strTemp[N];
	while(len>i&&str[i]!='\0')
	{	
	
		if(matchChar(str[i],sStr[k])==TRUE)
		{	
			j=i;
			str[5];
			while(len>i&&matchChar(str[i],sStr[k])==TRUE&&str[i]!='\0'&&sStr[k]!='\0'&&(j==0||str[j-1]=='\0'||str[j-1]==' '))
			{
				i++;
				k++;
			}
			
			if(sStr[k]=='\0' && (str[i]=='\0'||str[i]==' ') )
			{
			
				rIndex[count++]=j;//�ҵ�һ��Ӧ���滻��λ��
			}
			else
			{
				i=j+1;//��˷
			}	
			k=0;
		}
		else
		{//printf("%c--%c\n",str[i],sStr[k]);
			i++;
		}
	}

	if(count==0)
		return OK;//û��Ҫ�滻��
	i=0,j=0,k=0,m=0;
	if(lenS==lenR)//���滻���ַ����������滻���ַ����ĳ������
	{
		for(i=0;i<count;i++)
		{
			j=rIndex[i];
			k=0;	
			while(k<lenS)
			{
				str[j]=rStr[k];
				j++;
				k++;
			}
		}
	}
	else if(lenS>lenR)//���滻���ַ������������滻���ַ����ĳ���
	{
		j=rIndex[i];
		for(i=0;i<count-1;i++)//for 1#
		{
		
			k=0;
			while(k<lenR)
			{
				str[j]=rStr[k];
				j++;
				k++;
			}
			k=rIndex[i+1]-1;
			m=rIndex[i]+lenS;
			while(m<=k)
			{
				str[j]=str[m];
				j++;
				m++;
			}
		}//end:for 1#

		k=0;
	
		while(k<lenR)
		{	
			str[j]=rStr[k];
			j++;
			k++;
		}
		m=rIndex[i]+lenS;
		while(str[m]!='\0')
		{
			str[j]=str[m];
			j++;
			m++;
		}
	
		str[j]='\0';
	}
	else//���滻���ַ���С�������滻���ַ����ĳ���
	{
		strcpy(strTemp,str);
	//	printf("%s\n",strTemp);
		j=rIndex[i];
		for(i=0;i<count-1;i++)//for 1#
		{
		
			k=0;
			while(k<lenR)
			{
				str[j]=rStr[k];
				j++;
				k++;
			}
			k=rIndex[i+1]-1;
			m=rIndex[i]+lenS;
			while(m<=k)
			{
				str[j]=strTemp[m];
				j++;
				m++;
			}
		}//end:for 1#

		k=0;
		while(k<lenR)
		{
			str[j]=rStr[k];
			j++;
			k++;
		}
		m=rIndex[i]+lenS;
		while(strTemp[m]!='\0')
		{
			str[j]=strTemp[m];
			j++;
			m++;
		}
		str[j]='\0';
	}
	return OK;
}
//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	int i=0,j=0;
	ElemType str[N];
	ElemType sStr[N];
	ElemType rStr[N];	
	while(gets(str)!=NULL)//while 1#
	{
		gets(sStr);
		gets(rStr);
		replaceStr(str,sStr,rStr);
		printf("%s\n",str);
		
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