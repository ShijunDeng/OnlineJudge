#include<stdio.h>
#include<string.h>
//#include<malloc.h>
#include<math.h>
//����״̬��
#define OK 0
#define ERROR -1

#define TRUE 1
#define FALSE 0

typedef int Status;
typedef int Boolean;

//#define M 1000
#define N 10100

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1157����λ��
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��1908�����1149
��Ŀ������
��λ�����壺һ�����ݰ���С�����˳���������У������м�λ�õ�һ�����������м��������ݵ�ƽ������.
����һ�����������������λ������������м���������ƽ����������ȡ�����ɣ�����Ҫʹ�ø�������
���룺
�ó����������������ݣ�ÿһ��������ݵĵ�һ��ΪN���������������ݰ��������ݸ�����1<=N<=10000.
����N��ΪN�����ݵ����룬N=0ʱ��������
�����
�����λ����ÿһ������������һ��
�������룺
4
10
30
20
40
3
40
30
50
4
1
2
3
4
0
���������
25
40
2
��Դ��
2011�걱����ѧ������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7880-1-1.html

*/

int cmp(const void *a,const void *b)
{
	return *(int *)a-*(int *)b;
}
Status middle(int data[N],int num)
{
	qsort(data,num,sizeof(int),cmp);
	if(num%2)
	{
		printf("%d\n",data[(int)num/2]);
	}
	else
	{
		printf("%d\n",(data[(int)num/2]+data[((int)num/2)-1])/2 );
	}
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	int i=0;
	int data[N];
	while(scanf("%d",&n),n)//while 1#
	{
		memset(data,0,N);
		for(i=0;i<n;i++)
		{
			scanf("%d",data+i);
		}
		middle(data,n);
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