#include<stdio.h>
//#include<string.h>
//#include<malloc.h>
//#include<math.h>
//����״̬��
#define OK 1
#define ERROR 0

#define TRUE 1
#define FALSE 0

typedef int Status;
typedef int Boolean;

typedef int ElemType;

//#define M 1000
#define N 1200

//const int MAXINT =((unsigned int)-1)>>1;
const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1480��������������к�
ʱ�����ƣ�1 ���ڴ����ƣ�128 ���������⣺���ύ��1254�����480
��Ŀ������
һ����������bi����b1 < b2 < ... < bS��ʱ�����ǳ���������������ġ����ڸ�����һ������(a1, a2, ...,aN)��
���ǿ��Եõ�һЩ������������(ai1, ai2, ..., aiK)������1 <= i1 < i2 < ... < iK <= N�����磬
��������(1, 7, 3, 5, 9, 4, 8)��������һЩ���������У���(1, 7), (3, 4, 8)�ȵȡ���Щ�����������к����Ϊ18��Ϊ������(1, 3, 5, 9)�ĺ�.
������񣬾��Ƕ��ڸ��������У����������������к͡�
ע�⣬������������еĺͲ�һ�������ģ���������(100, 1, 2, 3)��������������к�Ϊ100���������������Ϊ(1, 2, 3)��
���룺
�����������������ݡ�
ÿ�����������������ɡ���һ�������еĳ���N (1 <= N <= 1000)���ڶ��и��������е�N����������Щ������ȡֵ��Χ����0��10000�������ظ�����
�����
����ÿ��������ݣ������������������к͡�
�������룺
7
1 7 3 5 9 4 8
���������
18
��Դ��
2012�걱����ѧ������о�����������
*/


int maxAscSum(int data[N],int size)
{
	int i=0,j=0,k=0;
	int bn[N];//bn[i]ָʾdata[i]��data[size-1]��������������еĺ�
	int next[N];//next[i]��¼i��������������еĺ�̵�
	int nextP=-1;
	int sum=0;
	int maxSum=MININT;

	if(size==1)
		return data[0];
	for(i=0;i<size;i++)
	{
		bn[i]=data[i];
		next[i]=-1;
	}

	for(i=size-2;i>=0;i--)//for 1#
	{
		nextP=-1;
		maxSum=MININT;
		for(j=i+1;j<size;j++)//for 2#
		{
			if(data[i]<data[j])//if 1#
			{
				sum=0;
				for(k=j;k<size&&k!=-1;k=next[k])//for 3#
				{
					sum+=data[k];
				}//end:for 3#
				if(sum>maxSum)
				{
					maxSum=sum;
					nextP=j;
				}			
			}//end:if 1#

			if(nextP!=-1)
			{
				bn[i]=maxSum+data[i];
				next[i]=nextP;
			}	
		}//end:for 2#			
	}//end:for 1#

	for(i=0;i<size;i++)
	{
		if(bn[i]>maxSum)
			maxSum=bn[i];
	}
	return maxSum;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int size=0;
	int i=0;
	int data[N];
	while(scanf("%d",&size)!=EOF)//while 1#
	{
		for(i=0;i<size;i++)
		{
			scanf("%d",data+i);
		}
		printf("%d\n",maxAscSum(data,size));
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