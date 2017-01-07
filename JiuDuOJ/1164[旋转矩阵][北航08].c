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
#define N 9

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1164����ת����
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��2757�����1072
��Ŀ������
������������9�����¾���Ҫ���жϵڶ����Ƿ��ǵ�һ������ת��������ǣ������ת�Ƕȣ�0��90��180��270����������ǣ����-1��
Ҫ����������������Ȼ��������������ÿ��������֮�������������ո�ָ�����֮���ûس��ָ������������������Ļس��ָ���
���룺
�����ж������ݡ�
ÿ�����ݵ�һ������n(1<=n<=9)���ӵڶ��п�ʼ��������n�׾���
�����
�жϵڶ����Ƿ��ǵ�һ������ת��������ǣ������ת�Ƕȣ�0��90��180��270����������ǣ����-1��
�����ת�ǶȵĽ���ж�����������С���Ǹ���
�������룺
3
1 2 3
4 5 6
7 8 9
7 4 1
8 5 2
9 6 3
���������
90
��Դ��
2008�걱�����պ����ѧ������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7887-1-1.html
*/

//������matrix��תarc�Ⱥ�����rMatrix��
Status rotate(int matrix[N][N],int rMatrix[N][N],int n,int arc)
{
	int i1=0,j1=0;
	int i2=0,j2=0;
	if(arc==0||arc%360==0)//��ת0
	{
		for(i1=0;i1<n;i1++)
		{
			for(j1=0;j1<n;j1++)
			{
				rMatrix[i1][j1]=matrix[i1][j1];
			}
		}
	}
	else if(arc==90)
	{
		for(i1=0,j2=0;i1<n&&j2<n;i1++,j2++)
		{
			for(j1=0,i2=n-1;j1<n&&i2>-1;j1++,i2--)
			{
				rMatrix[i1][j1]=matrix[i2][j2];
			}
		}

	}
	else if(arc==180)
	{
		for(i1=0,i2=n-1;i1<n&&i2>-1;i1++,i2--)
		{
			for(j1=0,j2=n-1;j1<n&&j2>-1;j1++,j2--)
			{
				rMatrix[i1][j1]=matrix[i2][j2];
			}
		}

	}
	else if(arc==270)
	{
		for(i1=0,j2=n-1;i1<n&&j2>-1;i1++,j2--)
		{
			for(j1=0,i2=0;j1<n&&i2<n;j1++,i2++)
			{
				rMatrix[i1][j1]=matrix[i2][j2];
			}
		}

	}
	return OK;
}

Status printMatrix(int matrix[N][N],int n)
{
	int i=0,j=0;
	for(i=0;i<n;i++)
	{
		for(j=0;j<n-1;j++)
		{
			printf("%d ",matrix[i][j]);
		}
		printf("%d\n",matrix[i][j]);
	}
	return OK;
}

Boolean equal(int matrix[N][N],int rMatrix[N][N],int n)
{
	int i=0,j=0;
	for(i=0;i<n;i++)
	{
		for(j=0;j<n;j++)
		{
			if(matrix[i][j]!=rMatrix[i][j])
			{
				return FALSE;
			}
		}
	}
	return TRUE;
}
//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	int i=0,j=0;
	int matrix1[N][N],matrix2[N][N],rMatrix[N][N];
	Boolean flag=FALSE;
	while(scanf("%d",&n)!=EOF)//while 1#
	{
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				scanf("%d",&matrix1[i][j]);
			}
		}
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				scanf("%d",&matrix2[i][j]);
			}
		}

		flag=FALSE;

		if(TRUE==equal(matrix1,matrix2,n))
		{
			printf("0\n");
			flag=TRUE;
		}

		rotate(matrix1,rMatrix,n,90);
	//	printMatrix(rMatrix,n);
		if(FALSE==flag&&TRUE==equal(rMatrix,matrix2,n))
		{
			printf("90\n");
			flag=TRUE;
		}

		rotate(matrix1,rMatrix,n,180);
	//	printMatrix(rMatrix,n);
		if(FALSE==flag&&TRUE==equal(rMatrix,matrix2,n))
		{
			printf("180\n");
			flag=TRUE;
		}

		rotate(matrix1,rMatrix,n,270);
	//	printMatrix(rMatrix,n);
		if(FALSE==flag&&TRUE==equal(rMatrix,matrix2,n))
		{
			printf("270\n");
			flag=TRUE;
		}
		if(FALSE==flag)
			printf("-1\n");
	
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