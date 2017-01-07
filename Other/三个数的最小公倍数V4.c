//利用求两个数的最小公倍数嵌套调用解决三个数的最小公倍数
#include<stdio.h>
#define MAXSIZE 32
#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0

//辗转相除法求最大公因数
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

//业务逻辑:数据输入 调用求解函数 输出结果
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