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

//#define M 1000
#define N 1000

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1466�������������
ʱ�����ƣ�1 ���ڴ����ƣ�128 ���������⣺���ύ��832�����373
��Ŀ������
�������ѧ�У�����ѧ������������n����ͬԪ����ȡ��m��m<=n����Ԫ�ص��������еĸ�����������n��ȡm������������Ϊp(n, m)��
������㷽��Ϊp(n, m)=n(n-1)(n-2)����(n-m+1)= n!/(n-m)! (�涨0!=1).��n��m���Ǻ�Сʱ������������ǱȽϴ����ֵ��
����  p(10,5)=30240������ö����Ʊ�ʾΪp(10,5)=30240=( 111011000100000)b��Ҳ����˵���������5���㡣���ǵ�������ǣ�
����һ�������������������Ʊ�ʾ�ĺ����ж��ٸ��������㡣
���룺
�����������������ݣ�ÿ���������һ�С�
ÿ������������n��m��0<m<=n<=10000��n=0��־����������������ݲ��ô���
�����
����ÿ�����룬���������p(n, m)�Ķ����Ʊ�ʾ�����ж��ٸ��������㡣ÿ���������һ�С�
�������룺
10 5
6 1
0 0
���������
5
1
*/
int pnm(int n,int m)
{
	int limit=n-m+1;
	int sum=n;
	n--;
	while(n>=limit)
	{
		sum*=n;
		n--;
	}
	return sum;
}
int countTailZero(int n)
{
	int count=0;
	while(n%2==0)
	{
		count++;
		n/=2;
	}
	return count;
}

int all(int n,int m)
{
	int limit=n-m+1;
	int count=0;
	int temp=0;
	while(n>=limit)
	{
		temp=n;
		while(temp%2==0)
		{
			count++;
			temp/=2;
		}
		n--;
	}
	return count;
}
//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0,m=0;

	scanf("%d %d",&n,&m);
	while(n)//while 1#
	{
		printf("%d\n",all(n,m));
		scanf("%d %d",&n,&m);
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