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

//#define M 1000
#define N 20

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1474��������
ʱ�����ƣ�1 ���ڴ����ƣ�128 ���������⣺���ύ��2823�����1100
��Ŀ������
����һ��n*n�ľ�����þ����k���ݣ���P^k��
���룺
�����������������ݡ�
���ݵĵ�һ��Ϊһ������T(0<T<=10)����ʾҪ�����ĸ�����
��������T��������ݣ�ÿ�����ݸ�ʽ���£� 
��һ�У���������n��2<=n<=10����k��1<=k<=5������������֮����һ���ո����������������ʾ��
��������n�У�ÿ��n�������������У���i�е�j��������ʾ�����е�i�е�j�еľ���Ԫ��Pij�ң�0<=Pij<=10�������⣬���ݱ�֤��������ᳬ��10^8��
�����
����ÿ��������ݣ������������ʽΪ��
n��n�и�������ÿ����֮���ÿո������ע�⣬ÿ�����һ�������治Ӧ���ж���Ŀո�
�������룺
3
2 2
9 8
9 3
3 3
4 8 4
9 3 0
3 5 7
5 2
4 0 3 0 1
0 0 5 8 5
8 9 8 5 3
9 6 1 7 8
7 2 5 7 3
���������
153 96
108 81
1216 1248 708
1089 927 504
1161 1151 739
47 29 41 22 16
147 103 73 116 94
162 108 153 168 126
163 67 112 158 122
152 93 93 111 97
��Դ��
2012�걱���ʵ��ѧ������о�����������
*/

int matrix[N][N];
Status multiply(int matrix[N][N],int size,int k)
{
	int cpyMatrix[N][N];//�ݴ�matrix�е�����
	int rsMatrix[N][N];//�ݴ�matrix�е�����
	int i=0,j=0,t=0;
	int count=2;
	int sum=0;

	if(k==1)
		return OK;
	for(i=0;i<size;i++)//����matrix�е����ݵ�cpyMatrix��
	{
		for(j=0;j<size;j++)
		{
			cpyMatrix[i][j]=matrix[i][j];
		}
	}

	//����˷�
	while(k>=count)//while 1#
	{
		for(i=0;i<size;i++)
		{
			for(j=0;j<size;j++)
			{
				sum=0;
				for(t=0;t<size;t++)
				{
					sum+=cpyMatrix[i][t]*cpyMatrix[t][j];
				}
				rsMatrix[i][j]=sum;
			}
		}

		count=count<<1;//count*2

		for(i=0;i<size;i++)//����cpyMatrix�е����ݵ�rsMatrix��
		{
			for(j=0;j<size;j++)
			{
				cpyMatrix[i][j]=rsMatrix[i][j];
			}
		}
	}//end:while 1#

	if(k%2==1)//�����γ˷�  �������һ�γ˷�
	{
		for(i=0;i<size;i++)
		{
			for(j=0;j<size;j++)
			{
				sum=0;
				for(t=0;t<size;t++)
				{
					sum+=cpyMatrix[i][t]*matrix[t][j];
				}
				rsMatrix[i][j]=sum;
			}
		}
	}

	for(i=0;i<size;i++)//����cpyMatrix�е����ݵ�matrix��
	{
		for(j=0;j<size;j++)
		{
			matrix[i][j]=rsMatrix[i][j];
		}
	}
	
	return OK;
}
Status printMatrix(int matrix[N][N],int size)
{
	int i=0,j=0;
	for(i=0;i<size;i++)//����matrix�е����ݵ�cpyMatrix��
	{
		for(j=0;j<size-1;j++)
		{
			printf("%d ",matrix[i][j]);
		}
		printf("%d\n",matrix[i][j]);
	}
	return OK;
}
//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	int i=0,j=0,t=0;
	int p=0,k=0;
	int matrix[N][N];
	while(scanf("%d",&n)!=EOF)//while 1#
	{
		for(t=0;t<n;t++)
		{
			scanf("%d %d",&p,&k);
			for(i=0;i<p;i++)
			{
				for(j=0;j<p;j++)
				{
					scanf("%d",*(matrix+i)+j);
				}
			}
		//	printMatrix(matrix,p);
			multiply(matrix,p,k);
			printMatrix(matrix,p);
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