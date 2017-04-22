#include<stdio.h>
#include<malloc.h>
#include<stdlib.h>
//����״̬��
#define OK 0
#define ERROR -1
#define TRUE 1
#define FALSE 0
#define N 1000
typedef int ElemType;
typedef int Status;
typedef int Boolean;

/*
��Ŀ������
����һϵ������������������������������ʣ�µ�����������
���룺
�����һ�а���1������N��1<=N<=1000�������������ݵĸ�����
��������һ����N��������
�����
�����ж���������ݣ�����ÿ�����ݣ�
��һ�����һ������������N�������е����ֵ��������ֵ��������ȥ������ʣ�µ�����������
�ڶ��н�����Ľ�������
�������룺
4
1 3 4 2
���������
4
1 2 3
*/



ElemType data[N];

int comp(const void *a,const void *b)
{
	return  *((int*)a)-*((int*)b);
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	int i=0;
	while(scanf("%d",&n) != EOF)
	{
		for(i=0;i<n;i++)
		{
			scanf("%d",&data[i]);
		}
		if(n==1)
		{
			printf("%d\n%d",data[0],-1);
		}
		else
		{
			qsort(data,n,sizeof(ElemType),comp);

			printf("%d\n",data[n-1]);

			for(i=0;i<n-2;i++)
			{
				printf("%d ",data[i]);
			}
			printf("%d\n",data[i]);
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