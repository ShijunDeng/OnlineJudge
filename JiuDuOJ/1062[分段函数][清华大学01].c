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

//#define M 1000
#define N 1000

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1062���ֶκ���
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��2984�����1752
��Ŀ������
��д���򣬼������зֶκ���y=f(x)��ֵ��
y=-x+2.5; 0<=x<2
y=2-1.5(x-3)(x-3); 2<=x<4
y=x/2-1.5; 4<=x<6
���룺
һ��������N
�����
�������ݿ����ж��飬����ÿһ�����ݣ�
���N��Ӧ�ķֶκ���ֵ��f(N)�����������λС��
�������룺
1
���������
1.500
��Դ��
2001���廪��ѧ������о�����������(��I��)
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7786-1-1.html

*/
double handleFunction(double x)
{
	if(0<=x&&x<2)
	{
		return -x+2.5;
	}
	else if(2<=x&&x<4)
	{
		return 2-1.5*(x-3)*(x-3);
	}
	else
	{
		return x/2-1.5;
	}
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	double x=0.0;
	while(scanf("%lf",&x)!=EOF)//while 1#
	{
		printf("%.3lf\n",handleFunction(x));
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