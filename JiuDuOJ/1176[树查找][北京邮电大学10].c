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
#define N 1500

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1176��������
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��3849�����1648
��Ŀ������
��һ���������ĳһ��ȵ����нڵ㣬���������Щ�ڵ㣬�������EMPTY����������ȫ��������
���룺
�����ж������ݡ�
ÿ������һ��n(1<=n<=1000)��Ȼ�����е���n���ڵ��������룬������һ��d������ȡ�
�����
��������е�d������нڵ㣬�ڵ���ÿո���������һ���ڵ��û�пո�
�������룺
4
1 2 3 4
2
���������
2 3
��Դ��
2010�걱���ʵ��ѧ��Ժ�о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7899-1-1.html
*/

Status kLevel(int data[N],int n,int k)
{
	int limit= n>((int)pow(2,k)-1)?((int)pow(2,k)-1):n;
	int i=0;
	for(i=((int)pow(2,k-1));i<limit;i++)
	{
		printf("%d ",data[i]);
	}
	printf("%d\n",data[i]);
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	int i=0,j=0;
	int data[N];
	int k=0;
	while(scanf("%d",&n)!=EOF)//while 1#
	{
		for(i=1;i<=n;i++)
		{
			scanf("%d",data+i);
		}
		scanf("%d",&k);
		kLevel(data,n,k);
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