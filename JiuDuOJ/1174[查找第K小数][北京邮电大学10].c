#include<stdio.h>
//#include<string.h>
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
#define N 1005

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1174�����ҵ�KС��
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��5288�����2136
��Ŀ������
����һ������ĵ�KС������ע��ͬ����С��һ���� 
��  2 1 3 4 5 2 ����С��Ϊ3��
���룺
�����ж������ݡ�
ÿ������n��Ȼ������n������(1<=n<=1000)��������k��
�����
�����kС��������
�������룺
6
2 1 3 5 2 2
3
���������
3
��Դ��
2010�걱���ʵ��ѧ��Ժ�о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7897-1-1.html

*/
int data[N];
int comp(const void * a,const void * b)
{
	return *((int*)a)-*((int*)b);
}
int search(int k,int n)
{
	int i=0;
	int count=0;

	qsort(data,n,sizeof(int),comp);

	while(i<n&&count<k)
	{	
		count++;
		while(i<n-1&&data[i]==data[i+1])
		{
			i++;
		}
		i++;
	}
	return data[i-1];//û�в�ѯ��
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	int i=0,k=0;
 
	while(scanf("%d",&n)!=EOF)//while 1#
	{
		for(i=0;i<n;i++)
		{
			scanf("%d",data+i);
		}
		scanf("%d",&k);
		printf("%d\n",search(k,n));
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