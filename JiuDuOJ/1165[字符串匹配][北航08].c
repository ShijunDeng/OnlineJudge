#include<stdio.h>
//#include<string.h>
//#include<malloc.h>
//#include<math.h>
//����״̬��
#define OK 0
#define ERROR -1

#define TRUE 1
#define FALSE 0

typedef int Status;
typedef int Boolean;

typedef int ElemType;

#define M 1000
#define N 50

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1165���ַ���ƥ��
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��2821�����973
��Ŀ������
    ��������string[ ]��Ȼ�����һ�����ַ�����Ҫ�����string[ ]�кͶ��ַ���������ƥ�䣬����кš�ƥ���ַ�����ƥ��ʱ�����ִ�Сд�����ҿ�����һ���������ű�ʾ��ģʽƥ�䡣��"aa[123]bb"������˵aa1bb��aa2bb��aa3bb����ƥ�䡣
���룺
�����ж������ݡ�
ÿ�����ݵ�һ������n(1<=n<=1000)���ӵڶ��п�ʼ����n���ַ����������ո񣩣�����������һ��ƥ���ַ�����
�����
���ƥ�䵽���ַ������кź͸��ַ�����ƥ��ʱ�����ִ�Сд����
�������룺
4
Aab
a2B
ab
ABB
a[a2b]b
���������
1 Aab
2 a2B
4 ABB
��Դ��
2008�걱�����պ����ѧ������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7888-1-1.html
*/


//�ַ�ƥ��:���ƥ��ɹ�����TRUE ���򷵻�FALSE
Boolean matchChar(char c,char mc)
{
	if(c==mc||c+32==mc||c-32==mc)//c��mc��� ���߽��Ǵ�Сд��ͬ
	{
		return TRUE;
	}
	return FALSE;
}

//�ַ���ƥ��:���ƥ��ɹ�����TRUE ���򷵻�FALSE
Boolean matchStr(char *str,char *model)
{
	int i=0,j=0;
	while(*str!='\0'&&*model!='\0')
	{
		if(TRUE==matchChar(*str,*model))
		{
			str++;
			model++;
		}
		else if(*model=='[')
		{
			model++;
			while(*model!=']')
			{
				if(matchChar(*str,*model)==TRUE)
				{
					str++;
					while(*model!=']')
					{
						model++;
					}
				}
				else if(*model!=']')
				{
					model++;
				}
			}
			model++;
		}
		else
			return FALSE;
	}

	if(*str=='\0'&&*model=='\0')
		return TRUE;
	return FALSE;
}
//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	int i=0,j=0;
	char str[M][N];
	char model[N];
	while(scanf("%d",&n)!=EOF)//while 1#
	{
		for(i=0;i<n;i++)
		{
			scanf("%s",str[i]);
		}
		scanf("%s",model);
		for(i=0;i<n;i++)
		{
			if(matchStr(str[i],model)==TRUE)
				printf("%d %s\n",i+1,str[i]);
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