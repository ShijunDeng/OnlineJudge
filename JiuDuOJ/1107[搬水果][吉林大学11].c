#include<stdio.h>
#include<math.h>
//����״̬��
#define OK 1
#define ERROR 0

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
��Ŀ1107����ˮ��
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��4328�����1421
��Ŀ������
    ��һ����԰�С���Ѿ������е�ˮ����������������ˮ���Ĳ�ͬ����ֳ������ɶѣ�С�����������е�ˮ���ϳ�һ�ѡ�
	ÿһ�κϲ���С�����԰�����ˮ���ϲ���һ�����ĵ�������������ˮ��������֮�͡���Ȼ���� n�\1 �κϲ�֮�󣬾ͱ��һ���ˡ�
	С���ںϲ�ˮ��ʱ�ܹ����ĵ���������ÿ�κϲ���������֮�͡�
    �ٶ�ÿ��ˮ��������Ϊ 1��������֪ˮ������������ÿ��ˮ������Ŀ�������������Ƴ��ϲ��Ĵ��򷽰���ʹС���ķѵ��������٣�
	����������С�������ķ�ֵ�������� 3 ��ˮ������Ŀ����Ϊ 1��2��9�������Ƚ� 1��2 �Ѻϲ����¶���ĿΪ3���ķ�����Ϊ 3��
	Ȼ���¶���ԭ�ȵĵ����Ѻϲ��õ��µĶѣ��ķ�����Ϊ 12������С���ܹ��ķ�����=3+12=15������֤�� 15 Ϊ��С�������ķ�ֵ��
���룺
    ÿ�����������������,��һ����һ������ n(1<=n<=10000),��ʾˮ��������������� n ���� 0 ��ʾ����������Ҳ��ô���
	�ڶ��а��� n ���������ÿո�ָ����� i ������(1<=ai<=1000)�ǵ� i ��ˮ������Ŀ��
�����
����ÿ�����룬���һ�����������У����ֵҲ������С�������ķ�ֵ���������ݱ�֤���ֵС�� 2^31��
�������룺
3
9 1 2
0
���������
15
��Դ��
2011�꼪�ִ�ѧ������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7830-1-1.html
9
12 234 34 5 56 654 3 6 5
*/

int data[N];
int num=0;
int comp(const void *a,const void *b)
{
	return *(int*)a-*(int*)b;
}

Status selectSort(int *a,int n)
{
	int i=0;
	int e=a[0];
	int temp=0;
	while(i<n-1&&a[i+1]<e)
	{
		a[i]=a[i+1];
		i++;
	}
	a[i]=e;
	return OK;
}
int handleFunction()
{
	int i=0;
	int sum=0;
	if(num==1)
		return data[0];
	qsort(data,num,sizeof(int),comp);
	while(i<num-1)
	{
		data[i+1]=data[i]+data[i+1];
		sum+=data[i+1];	
		i++;
		selectSort(data+i,num-i);
	}
	return sum;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int i=0;
	while(scanf("%d",&num),num)//while 1#
	{
		for(i=0;i<num;i++)
		{
			scanf("%d",data+i);
		}
		printf("%d\n",handleFunction());
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