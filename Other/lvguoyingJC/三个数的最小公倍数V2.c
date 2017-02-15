//短除法解决三个数的最小公倍数
#include<stdio.h>
#define MAXSIZE 32
#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0

//返回三个数中最大的数
int max(int x,int y,int z)
{
	if(x>y&&x>z)
	{
		return x;
	}
	if(z<y)
	{
		return y;
	}
	return z;
}

int lcm(int x,int y,int z)
{ 
	int maxNum=max(x,y,z);//找出三个数中的最大值
	int flag=TRUE;
	int i;
	int lcm=1;

	if(x==0 || y==0 || z==0)
		return 0;

	for(i=2;i<=maxNum;i++)
	{
		flag=TRUE;
		while(TRUE==flag)
		{
			flag=FALSE;

			if(x%i==0)
			{
				x/=i;
				flag=TRUE;
			}

			if(y%i==0)
			{
				y/=i;
				flag=TRUE;
			}

			if(z%i==0)
			{
				z/=i;
				flag=TRUE;
			}

			if(TRUE==flag)
			{
				lcm*=i;
			}
		}//end:while
		
		maxNum=max(x,y,z);//重新计算最大值
	}//end:for
	
	return lcm;
}

//业务逻辑:数据输入 调用求解函数 输出结果
int service()
{
	int x,y,z;

	printf("input x,y,z:");
	scanf("%d %d %d",&x,&y,&z);

	printf("The least commen multiple:%d\n",lcm(x,y,z));

}

int main()
{
	service();
	return OK;
}