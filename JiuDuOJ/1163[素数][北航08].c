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

typedef int ElemType;

//#define M 1000
#define N 1000

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1163������
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��6679�����2273
��Ŀ������
����һ������n(2<=n<=10000)��Ҫ��������д�1���������֮��(������1���������)��λΪ1�����������û�������-1��
���룺
�����ж������ݡ�
ÿ��һ�У�����n��
�����
������д�1���������֮��(������1���������)��λΪ1������(����֮���ÿո���������һ����������û�пո�)�����û�������-1��
�������룺
100
���������
11 31 41 61 71
��Դ��
2008�걱�����պ����ѧ������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7886-1-1.html
*/

int data[N];
int count=0;
//���n����������TRUE���򷵻�FALSE
Boolean prime(int n)
{
	int i=2;
	int limit=(int)sqrt(n);
	if(n==1||n==2)
		return FALSE;

	for(i=2;i<=limit;i++)
	{
		if(n%i==0)
			return FALSE;
	}
	return TRUE;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	int i=0;
	while(scanf("%d",&n)!=EOF)//while 1#
	{
		count=0;
		for(i=0;i<n;i++)
		{
			if(i>2&&TRUE==prime(i)&&i%10==1)
				data[count++]=i;			
		}
		if(count==0)
		{
			printf("-1\n");
		}
		else
		{
			for(i=0;i<count-1;i++)
			{
				printf("%d ",data[i]);
			}
			printf("%d\n",data[i]);
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