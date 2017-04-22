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

#define N 110
const int MAXINT=((unsigned int)-1)>>1;
const int MININT=~(((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1139������Ӿ���
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��902�����323
��Ŀ������
��֪����Ĵ�С����Ϊ����������Ԫ�صĺ͡�����һ����������������ҵ����ķǿ�(��С������1 * 1)�Ӿ���
���磬����4 * 4�ľ���

0 -2 -7 0
9 2 -6 2
-4 1 -4 1
-1 8 0 -2

������Ӿ�����

9 2
-4 1
-1 8

����Ӿ���Ĵ�С��15��
���룺
������һ��N * N�ľ�������ĵ�һ�и���N (0 < N <= 100)��
�ٺ�����������У����Σ����ȴ����Ҹ�����һ�е�N���������ٴ����Ҹ����ڶ��е�N���������������������е�N2������������֮���ɿհ��ַ��ָ����ո���߿��У���
��֪�����������ķ�Χ����[-127, 127]��
�����
�������ݿ����ж��飬����ÿ��������ݣ��������Ӿ���Ĵ�С��
�������룺
4
0 -2 -7 0
9 2 -6 2
-4 1 -4  1
-1 8  0 -2
���������
15
��Դ��
2008�걱����ѧ�����������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7862-1-1.html
*/

int matrixSum[N][N][N];//matrixSum[i][j][k]��ʾ��i��Ԫ�ص�j��Ԫ�ص���k��Ԫ�صĺ�
/*
��̬�滮�������ֶκ�����

*/
int maxSubSum(int data[N],int size)
{
	int maxSum=MININT;//��ǰ��õ�����ֶκ�
	int thisSum=0;
	//����ǰλ��,����Ԫ�صĺ�,����ĳһλ��thisSum<0,��Ӹ�λ�ÿ�ʼ�����ۼƼ���
	int i=0,j=0;

	for(j=0;j<size;j++)//for 1#
	{
		if(thisSum>=0)
		{
			thisSum=thisSum+data[j];
		}
		else
		{
			thisSum=data[j];
		}		
		if(thisSum>maxSum)
		{//�µ�����Ӷκ� ��������
			maxSum=thisSum;
		}	
	}//end:for 1#
	return maxSum;
}

int maxSummatrix(int matrix[N][N],int size)
{
	int i=0,j=0,k=0;
	int maxSum=MININT,sum=0;
	int data[N];

	for(i=0;i<size;i++)//for 1#
	{
		for(j=0;j<size;j++)//for 2#	
		{
			//��i��Ԫ�ص�j��Ԫ�ص���k��Ԫ�صĺ�
			matrixSum[i][j][j]=matrix[i][j];
			for(k=j+1;k<size;k++)//for 3#
			{
				matrixSum[i][j][k]=	matrixSum[i][j][k-1]+matrix[i][k];
			}//end:for 3#
		}//end:for 2#
	}//end:for 1#

	for(i=0;i<size;i++)//for 1#
	{
		for(j=i;j<size;j++)//for 2#	
		{
			for(k=0;k<size;k++)//for 3#
			{
				data[k]=matrixSum[k][i][j];
			}//end:for 3#
			sum=maxSubSum(data,size);
			if(sum>maxSum)
				maxSum=sum;
		}//end:for 2#
	}//end:for 1#

	return maxSum;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int size=0;
	int i=0,j=0;
	int matrix[N][N];
	while(scanf("%d",&size)!=EOF)//while 1#
	{
		for(i=0;i<size;i++)
		{
			for(j=0;j<size;j++)
			{
				scanf("%d",*(matrix+i)+j);
			}	
		}	
		printf("%d\n",maxSummatrix(matrix,size));
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