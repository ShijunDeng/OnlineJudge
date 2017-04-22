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
/*************************��Ŀ˵��********************/
/*
��Ŀ1166��������������
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��3100�����1416
��Ŀ������
�������ıƽ����������� y(n+1) = y(n)*2/3 + x/(3*y(n)*y(n)),����y0=x.�������x����n�ε�������������ֵ��
���룺
�����ж������ݡ�
ÿ��һ�У�����x n��
�����
����n�κ����������double����,����С���������λ��
�������룺
3000000 28
���������
144.224957
��Դ��
2009�걱�����պ����ѧ������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7889-1-1.html
*/

long double iteration(long double x,int n)
{
	long double y=x;
	long double t=1.0/3;
	if(x==0.0)
		return 0.0;
	while(n>0)
	{
		y=t*(2*y+x/(y*y));
		n--;
	}
	return y;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	long double x;
	while(scanf("%lf %d",&x,&n)!=EOF)//while 1#
	{
		printf("%.6lf\n",iteration(x,n));
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