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
��Ŀ1155������ͬ��
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��1804�����1214
��Ŀ������
һ������������˼������ӣ�����2ֻ�ţ�������4ֻ�ţ�û�����⣩���Ѿ�֪������������ŵ�����a��
���������������ж���ֻ��������ж���ֻ���
���룺
��1���ǲ������ݵ�����n���������n�����롣ÿ���������ռ1�У�ÿ��һ��������a (a < 32768)
�����
�������n�У�ÿ�ж�Ӧһ������,������������������һ�������ٵĶ��������ڶ��������Ķ�������������������һ���ո�ֿ�
���û������Ҫ��Ĵ𰸣����������0��
�������룺
2
3
20
���������
0 0
5 10
��Դ��
2011�걱����ѧ������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7878-1-1.html

*/
Status handleFunction(int total)
{
	int sum1=0,sum2=0;
	int i=0,j=0;

	if(total&&total%2==0)
	{
		if(total%4)
		{
			sum1=total/4+1;
			sum2=total/2;
		}
		else
		{
			sum1=total/4;
			sum2=total/2;
		}
	}
	printf("%d %d\n",sum1,sum2);

	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	int i=0,total=0;
	scanf("%d",&n);
	for(i=0;i<n;i++)
	{
		scanf("%d",&total);
		handleFunction(total);		
	}
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