//����������������С������Ƕ�׵��ý������������С������
#include<stdio.h>
#define MAXSIZE 32
#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0

//շת��������������
int gcd(int a,int b)
{
	int x,y;
	int temp;

	if(a>b)
	{
		x=a;
		y=b;
	}
	else
	{
		x=b;
		y=a;
	}

	while(x%y!=0)
	{
		temp=x%y;
		x=y;
		y=temp;
	}

	return y;
}

int lcm(int x,int y)
{ 
	if(x==0 || y==0)
		return 0;
	return x*y/gcd(x,y);
}

//ҵ���߼�:�������� ������⺯�� ������
int service()
{
	int x,y,z;

	printf("input x,y,z:");
	scanf("%d %d %d",&x,&y,&z);

	printf("The least commen multiple:%d\n",lcm(lcm(x,y),z));

}

int main()
{
	service();

	return OK;
}