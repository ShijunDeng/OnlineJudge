#include<stdio.h>
#include<malloc.h>
#include<stdlib.h>
//����״̬��
#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0
#define N 256
typedef int ElemType;
typedef int Status;
typedef int Boolean;

/*
��Ŀ������
    ����һ��ip��ַ�����ж��Ƿ�Ϸ���
���룺
    ����ĵ�һ�а���һ������n(1<=n<=500)�������������ֵ�IP��ַ�ĸ�����
    ��������n��ÿ����һ��IP��ַ��IP��ַ����ʽΪa.b.c.d������a��b��c��d����������
�����
    �����ж���������ݣ�����ÿ�����ݣ����IP��ַ�Ϸ������"Yes!"���������"No!"��
�������룺
2
255.255.255.255
512.12.2.3
���������
Yes!
No!
��ʾ��
�Ϸ���IP��ַΪ��
a��b��c��d����0-255��������


*/

Boolean check(char ip[N])
{
	int n=strlen(ip);
	int i=0;
	int sum=0;
	while(ip[i]!='\0')
	{
		if(ip[i]=='.')
		{
			if(sum>255||sum<0)
			{
				return FALSE;
			}
			sum=0;
			
		}
		else if(ip[i]>='0'&&ip[i]<='9')
		{
			sum=10*sum+ip[i]-'0';
		}
		else
		{
			return FALSE;
		}
		i++;
	}

	if(sum>255||sum<0)
	{
		return FALSE;
	}
	return TRUE;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	char ip[N];
	int n=0;
	while(scanf("%d",&n)!=EOF)
	{
		while((n--)>0)
		{	
			scanf("%s",ip);
			if(check(ip)==TRUE)
			{
				printf("Yes!\n");
			}
			else
			{
				printf("No!\n");
			}
			ip[0]='\0';
		}	
	}

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