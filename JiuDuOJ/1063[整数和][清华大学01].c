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
#define N 1000

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1063��������
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��3112�����2025
��Ŀ������
��д���򣬶���һ������N��
��NΪ�Ǹ����������N��2N֮��������ͣ�
��NΪһ������������2N��N֮���������
���룺
һ������N,N�ľ���ֵС�ڵ���1000
�����
�������ݿ����ж��飬����ÿһ�����ݣ�
�����ĿҪ���ֵ
�������룺
1
-1
���������
3
-3
��Դ��
2001���廪��ѧ������о�����������(��I��)
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7787-1-1.html

*/
Status handleFunction(int n)
{
	int sum=0;
	int k=2*n;
	int i=0;
	if(n<0)
	{
		for(i=k;i<=n;i++)
		{
			sum+=i;
		}
	}
	else
	{
		for(i=k;i>=n;i--)
		{
			sum+=i;
		}
	}
	return sum;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	while(scanf("%d",&n)!=EOF)//while 1#
	{
		printf("%d\n",handleFunction(n));
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