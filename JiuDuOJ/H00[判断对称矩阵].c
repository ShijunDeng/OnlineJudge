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
����һ��Nά�����ж��Ƿ�Գơ�
���룺
�����һ�а���һ������N(1<=N<=100)����ʾ�����ά����
��������N�У�ÿ�а���N��������ʾN*N�����Ԫ�ء�
�����
�����ж���������ݣ�����ÿ�����ݣ�
���"Yes!����ʾ����Ϊ�Գƾ���
���"No!����ʾ�����ǶԳƾ���
�������룺
4
16 19 16 6 
19 16 14 5 
16 14 16 3 
6 5 3 16 
2
1 2
3 4
���������
Yes!
No! 
*/

/*
n:����Ϊn*n
matrix:��������
����ǶԳƾ��󷵻�TRUE ���򷵻�FALSE
*/
Status symmetry(int n,int matrix[N][N])
{
	int i=0,j=0;
	for(i=0;i<n;i++)//for 1#
	{
		for(j=i+1;j<n;j++)//for 2#
		{
			if(matrix[i][j]!=matrix[j][i])
				return FALSE;
		}//end:for 2#
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

		if(TRUE==symmetry(n,matrix))
		{
			printf("Yes!\n");
		}
		else
		{
			printf("No!\n");
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