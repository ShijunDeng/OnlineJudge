#include<stdio.h>

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
��Ŀ������
����������֪���ȵıߣ�ȷ���Ƿ��ܹ�����һ�������Σ�����һ���򵥵ļ������⡣���Ƕ�֪������Ҫ������֮�ʹ��ڵ����ߡ�ʵ���ϣ�������Ҫ�����������ֿ��ܣ�ֻ��Ҫ������̵������߳�֮���Ƿ��������Ǹ��Ϳ����ˡ�
��ε�������ǣ�����������������������С�������ϴ�С������������֮�
���룺
ÿһ�а�����������a, b, c�����Ҷ�������������С��10000����aΪ0ʱ��־�����������ݽ�����
�����
���������ÿһ�У��ڵ���һ����������s��s=min(a,b,c)+mid(a,b,c)-max(a,b,c)����ʽ�У�minΪ��Сֵ��midΪ�м�ֵ��maxΪ���ֵ��
�������룺
1 2 3
6 5 4
10 20 15
1 1 100
0 0 0
���������
0
3
5
-98

*/
int min(int a,int b,int c)
{
	if(a<=b&&a<=c)
	{
		return a;
	}
	else if(b<=a&&b<=c)
	{
		return b;
	}
	return c;
}

int max(int a,int b,int c)
{
	if(a>=b&&a>=c)
	{
		return a;
	}
	else if(b>=a&&b>=c)
	{
		return b;
	}
	return c;
}
int mid(int a,int b,int c)
{
	if((b<=a&&a<=c)||(c<=a&&a<=b))
	{
		return a;
	}
	else if((a<=b&&b<=c)||(c<=b&&b<=a))
	{
		return b;
	}
	return c;
}
//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int a=0,b=0,c=0;
	scanf("%d %d %d",&a,&b,&c);
	while(a)//while 1#
	{
		printf("%d\n",min(a,b,c)+mid(a,b,c)-max(a,b,c));
		scanf("%d %d %d",&a,&b,&c);
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