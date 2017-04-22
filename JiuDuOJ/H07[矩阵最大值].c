#include<stdio.h>
#include<malloc.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
//����״̬��
#define OK 0
#define ERROR -1
#define TRUE 1
#define FALSE 0
#define M 256
#define N 256
#define MININT -32768
typedef int ElemType;
typedef int Status;
typedef int Boolean;

/*
��Ŀ������
��дһ����������һ��mXn�ľ���洢��������������ÿ�е����ֵ��ÿ�е��ܺ͡�
Ҫ���ÿ���ܺͷ���ÿ�����ֵ��λ�ã�����ж�����ֵ��ȡ�±�ֵ��С����һ����Ϊ���ֵ��
��󽫽�����������
���룺
����ĵ�һ�а�����������m��n(1<=m,n<=100)���ֱ���������к��е�ά����
��������m��ÿ����n��������������Ԫ�ء�
�����
�����ж���������ݣ�����ÿ�����ݣ��������ĿҪ��ִ�к�ľ���
�������룺
3 3
1 1 1
1 1 1
1 1 1
3 3
3 2 3
2 3 2
3 2 3
���������
3 1 1
3 1 1
3 1 1
8 2 3
2 7 2
8 2 3

*/


Status maxAndSum(ElemType matrix[M][N],int m,int n)
{
	int i=0,j=0;
	int sum=0;
	int maxValue=MININT;
	int maxIndex=0;

	for(i=0;i<m;i++)//for 1#
	{
		sum=0;
		maxValue=MININT;
		maxIndex=0;

		for(j=0;j<n;j++)//for 2#
		{
			if(matrix[i][j]>maxValue)
			{
				maxValue=matrix[i][j];
				maxIndex=j;
			}
			sum+=matrix[i][j];
		}//end:for 2#

		matrix[i][maxIndex]=sum;
	}//end:for 1#
	
	for(i=0;i<m;i++)//for 1#
	{
		for(j=0;j<n-1;j++)//for 2#
		{
			printf("%d ",matrix[i][j]);
		}//end:for 2#

		printf("%d\n",matrix[i][j]);
	}//end:for 1#

	return OK;
}



//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	ElemType matrix[M][N];
	int m=0,n=0;
	int i=0,j=0;
	while(scanf("%d %d",&m,&n)!=EOF)
	{

		for(i=0;i<m;i++)//for 1#
		{
			for(j=0;j<n;j++)//for 2#
			{
				scanf("%d",*(matrix+i)+j);
			}//end:for 2#
		}//end:for 1#
		maxAndSum(matrix,m,n);
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