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
    �������n�����������������
���룺
    ����ĵ�һ�а���һ������n(1<=n<=100)��
    ��������һ�а���n��������
�����
    �����ж���������ݣ�����ÿ�����ݣ���������n�����������ÿ�������涼��һ���ո�
    ÿ��������ݵĽ��ռһ�С�
�������룺
4
1 4 3 2
���������
1 2 3 4 

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
		
		qsort(data,n,sizeof(ElemType),comp);

		for(i=0;i<n;i++)
		{
			printf("%d ",data[i]);
		}
		printf("\n");
	
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