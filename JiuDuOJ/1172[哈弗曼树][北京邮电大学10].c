#include<stdio.h>
//#include<string.h>
//#include<malloc.h>
#include<math.h>
//����״̬��
#define OK 1
#define ERROR 0

#define TRUE 1
#define FALSE 0

typedef int Status;
typedef int Boolean;

//#define M 1000
#define N 1100

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1172����������
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��5170�����2220
��Ŀ������
������������һ������һ����n����ʾҶ���ĸ�������Ҫ����ЩҶ������ɹ������������ݹ��������ĸ����Щ�����Ȩֵ����weight��
��Ŀ��Ҫ������н���ֵ��Ȩֵ�ĳ˻�֮�͡�
���룺
�����ж������ݡ�
ÿ���һ������һ����n����������n��Ҷ�ڵ㣨Ҷ�ڵ�Ȩֵ������100��2<=n<=1000����
�����
���Ȩֵ��
�������룺
5  
1 2 2 5 9
���������
37
��Դ��
2010�걱���ʵ��ѧ������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7895-1-1.html
*/
int data[N];
int comp(const void *a,const void *b)
{
	return *((int *)a)-*((int *)b);
}
int hfmWeight(int n)
{
	int sum=0;
	int i=0;
	for(i=0;i<n-1;i++)
	{
		qsort(data+i,n-i,sizeof(int),comp);
		data[i+1]=data[i]+data[i+1];	
		sum+=data[i+1];
	}
	return sum;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	int i=0;

	while(scanf("%d",&n)!=EOF)//while 1#
	{
		for(i=0;i<n;i++)
		{
			scanf("%d",data+i);
		}
		data[i]=0;
		printf("%d\n",hfmWeight(n));
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