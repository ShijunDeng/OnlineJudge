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
#define N 100

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1126����ӡ��ֵ���±�
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��3437�����1261
��Ŀ������
��һ�����������ϣ������±�Ϊi��������������������������ڵ�������
����С�����������ڵ����������Ϊ������Ϊһ����ֵ�㣬��ֵ����±����i��
���룺
ÿ���������������£�
��2��n+1�����룺��һ����Ҫ���������ĸ���n��
������2��n�У���һ���Ǵ������Ԫ�ظ���k(4<k<80)���ڶ�����k��������ÿ��������֮���ÿո�ָ���
�����
ÿ���������Ϊn�У�ÿ�ж�Ӧ����Ӧ��������м�ֵ���±�ֵ���±�ֵ֮���ÿո�ָ���
�������룺
3
10
10 12 12 11 11 12 23 24 12 12
15
12 12 122 112 222 211 222 221 76 36 31 234 256 76 76 
15
12 14 122 112 222 222 222 221 76 36 31 234 256 76 73
���������
0 7
2 3 4 5 6 10 12
0 2 3 10 12 14
��Դ��
2008�걱����ѧ����ʵ���Ҽ�����о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7849-1-1.html
*/

Status mValue(int value[N],int k)
{
	int mIndex[N];
	int size=0;
	int i=0;

	if(value[0]!=value[1])
	{
		mIndex[size++]=0;
	}
	
	for(i=1;i<k-1;i++)
	{
		if((value[i]>value[i+1]&&value[i]>value[i-1])||
		   (value[i]<value[i+1]&&value[i]<value[i-1]))
		{
			mIndex[size++]=i;
		}
	}
	
	if(value[k-2]!=value[k-1])
	{
		mIndex[size++]=k-1;
	}

	if(size>0)
	{
		for(i=0;i<size-1;i++)
		{
			printf("%d ",mIndex[i]);
		}
		printf("%d",mIndex[i]);
	}
	printf("\n");
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	int i=0,k=0;
	int value[N];
	scanf("%d",&n);
	while(n>0)//while 1#
	{
		scanf("%d",&k);
		for(i=0;i<k;i++)
		{
			scanf("%d",value+i);		 
		}
		mValue(value,k);
		n--;
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