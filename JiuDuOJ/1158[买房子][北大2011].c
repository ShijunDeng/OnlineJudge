#include<stdio.h>
//#include<string.h>
//#include<malloc.h>
//#include<math.h>
//����״̬��
#define OK 0
#define ERROR -1

#define TRUE 1
#define FALSE 0

typedef int Status;
typedef int Boolean;


//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1158������
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��1638�����986
��Ŀ������
    ĳ����Ա��ʼ��������нN����ϣ�����йش幫����һ��60ƽ�׵ķ��ӣ����ڼ۸���200�򣬼��跿�Ӽ۸���ÿ��ٷ�֮K������
	���Ҹó���Աδ����н���䣬�Ҳ��Բ��ȣ����ý�˰��ÿ������N��ȫ�������������ʵڼ����ܹ��������׷��ӣ���һ�귿��200������N��
���룺
    �ж��У�ÿ����������N��10<=N<=50��, K��1<=K<=20��
�����
    ���ÿ�����ݣ�����ڵ�20�����֮ǰ�����������׷��ӣ������һ������M����ʾ������Ҫ�ڵ�M�������£��������Impossible�������Ҫ����
�������룺
50 10
40 10
40 8
���������
8
Impossible
10
��Դ��
2011�걱����ѧ������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7881-1-1.html

*/
Status handleFunction(int n,int k)
{
	double sum=n;
	double cost=200.0;
	double rate=k/100.0;
	int i=1;
	while(sum<cost&&i<=20)
	{
		sum+=n;
		cost+=cost*rate;
		//printf("%.2lf %.2lf\n",sum,cost);
		i++;
	}
	if(i<=20)
	{
		printf("%d\n",i);
	}
	else
	{
		printf("Impossible\n");
	}
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0,k=0;
	while(scanf("%d %d",&n,&k)!=EOF)//while 1#
	{
		handleFunction(n,k);
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