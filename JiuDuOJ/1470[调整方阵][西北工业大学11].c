#include<stdio.h>
#include<string.h>
#include<malloc.h>
#include<math.h>
//����״̬��
#define OK 0
#define ERROR -1

#define TRUE 1
#define FALSE 0

typedef int Status;
typedef int Boolean;

#define N 100

const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*

��Ŀ1470����������
ʱ�����ƣ�1 ���ڴ����ƣ�128 ���������⣺���ύ��1679�����685
��Ŀ������
����һ��N��N<=10���׷��󣬰������·�ʽ��������
1.����һ������������ڵ������һ�жԵ���
2.���ڶ����дӵڶ��е���N����������ڵ�����ڶ��жԵ���
��������...
N-1.����N-1���дӵ�N-1�е���N����������ڵ������N-1�жԵ���
N.����������
���룺
���������������,ÿ��������ݵ�һ��Ϊһ������N,��ʾ����Ľ���.
�������������N�׷���.
�����
������ķ���
�������룺
4
3 6 8 7
6 7 5 3
8 6 5 3
9 8 7 2
���������
9 8 7 2
6 7 5 3
3 6 8 7
8 6 5 3
��Դ��
2011��������ҵ��ѧ������о�����������

*/
//���������е�����
int exchangeRows(int matrix[N][N],int rowa,int rowb,int n)
{
	int temp=0;
	int i=0;
	for(i=0;i<n;i++)
	{
		temp=matrix[rowa][i];
		matrix[rowa][i]=matrix[rowb][i];
		matrix[rowb][i]=temp;
	}
	return 0;
}
Status adjust(int matrix[N][N],int n)
{
	int i=0,j=0;
	int max=MININT;
	int maxRowIndex=0;

	for(i=0;i<n;i++)
	{
		max=-MININT;
		for(j=i;j<n;j++)
		{
			if(matrix[j][i]>max)
			{
				max=matrix[j][i];
				maxRowIndex=j;
			}
		}
		//������������ڵ������Ӧ�жԵ�
		exchangeRows(matrix,i,maxRowIndex,n);
	}
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	int i=0,j=0;
	int matrix[N][N];
	while(scanf("%d",&n)!=EOF)//while 1#
	{
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				scanf("%d",*(matrix+i)+j);
			}
		}
		adjust(matrix,n);
		for(i=0;i<n;i++)
		{
			for(j=0;j<n-1;j++)
			{
				printf("%d ",matrix[i][j]);
			}
			printf("%d\n",matrix[i][j]);
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