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
#define N 60

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1060������VSӯ��
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��5105�����1898
��Ŀ������
һ�������ǡ�õ������ĸ�����(�����������)�Ӻͣ��磺6=3+2+1�������Ϊ����������������֮�ʹ��ڸ����������Ϊ��ӯ������
���2��60֮�����С��������͡�ӯ������
���룺
��Ŀû���κ����롣
�����
���2��60֮�����С��������͡�ӯ����������������ʽ�����
E: e1 e2 e3 ......(eiΪ����)
G: g1 g2 g3 ......(giΪӯ��)
����������֮��Ҫ�пո���β���ӿո�
�������룺
���������
��Դ��
2000���廪��ѧ������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7784-1-1.html

*/
Status handleFunction()
{
	int E[60];
	int G[60];
	int eLen=0;
	int gLen=0;
	int i=0,j=0;
	int sum=1;
	int limit=0;

	for(i=2;i<=60;i++)
	{
		limit=i/2;//���ﲻ��������	
		sum=1;
		for(j=2;j<=limit;j++)
		{
			if(i%j==0)
			{
				sum+=j;
			}
		}
		if(sum==i)
		{
			E[eLen++]=i;
		}
		else if(sum>i)
		{
			G[gLen++]=i;
		}
	
	}
	printf("E: ");
	for(i=0;i<eLen-1;i++)
	{
		printf("%d ",E[i]);
	}
	printf("%d\n",E[i]);

	printf("G: ");
	for(i=0;i<gLen-1;i++)
	{
		printf("%d ",G[i]);
	}
	printf("%d\n",G[i]);
	

	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	handleFunction();
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