#include<stdio.h>
#include<malloc.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
//����״̬��
#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0
#define N 256
#define LENGTH 1024
typedef int ElemType;
typedef int Status;
typedef int Boolean;

/*
��Ŀ������
��N��������ɴﵽ1000������������
���룺
�����һ��Ϊһ������N��(1<=N<=100)��
��������N��ÿ����һ���������ĳ��ȷ�ΧΪ1<=len<=1000��
ÿ��������һ�����������ұ�֤������ǰ׺�㡣
�����
�����ж���������ݣ�����ÿ�����ݣ���������N������С�������������������Ľ����ÿ����ռһ�С�
�������룺
3
11111111111111111111111111111
2222222222222222222222222222222222
33333333
���������
33333333
11111111111111111111111111111
2222222222222222222222222222222222

*/

int comp(const void *stra,const void *strb)
{
	char *str1=(char*)stra;
	char *str2=(char*)strb;

	int len1=strlen((char*)str1);
	int len2=strlen((char*)str2);
	if(len1==len2)
		return strcmp(str1,str2);
	return len1-len2;
}

Status bSort(char str[N][LENGTH],int n)
{
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	char str[N][LENGTH];
	int n=0;
	int i=0;
	while(scanf("%d",&n)!=EOF)
	{

		for(i=0;i<n;i++)
		{
			scanf("%s",str+i);
		}

		qsort(str,n,sizeof(str[0]),comp);
		
		for(i=0;i<n;i++)
		{
			printf("%s\n",*(str+i));
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