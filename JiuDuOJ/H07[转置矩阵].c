#include<stdio.h>

//����״̬��
#define OK 0
#define ERROR -1
#define TRUE 1
#define FALSE 0

#define N 100

typedef int Status;
typedef int Boolean;
/*
��Ŀ������
����һ��N*N�ľ��󣬽���ת�ú������Ҫ�󣺲���ʹ���κ�����(�͵�����)��
���룺
����ĵ�һ�а���һ������N,(1<=N<=100)����������ά����
��������N��ÿ����N���������ֱ��������Ԫ�ء�
�����
�����ж���������ݣ�����ÿ�����ݣ�������ľ���ת�ú������
�������룺
3
1 2 3
4 5 6
7 8 9
���������
1 4 7
2 5 8
3 6 9

*/
Status transpose(int matrix[N][N],int n)
{
	int i=0,j=0;
	int temp;
	for(i=0;i<n;i++)//for 1#
	{
		for(j=i+1;j<n;j++)//for 2#
		{

			temp=matrix[i][j];
			matrix[i][j]=matrix[j][i];
			matrix[j][i]=temp;
		}//end:for 2#
	}//end:for 1#

	for(i=0;i<n;i++)//for 1#
	{
		for(j=0;j<n-1;j++)//for 2#
		{
			printf("%d ",matrix[i][j]);
		}//end:for 2#

		printf("%d\n",matrix[i][j]);
	}//end:for 1#
	return TRUE;
}


//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	int matrix[N][N];
	int i=0,j=0;

	while(scanf("%d",&n)!=EOF)//while 1#
	{
		for(i=0;i<n;i++)//for 1#
		{
			for(j=0;j<n;j++)//for 2#
			{
				scanf("%d",&matrix[i][j]);
			}//end:for 2#
		}//end:for 1#

		transpose(matrix,n);
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