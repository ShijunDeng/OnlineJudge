//蛮力法解决三个数的最小公倍数
#include<stdio.h>
#define MAXSIZE 32
#define OK 1
#define ERROR 0
#define TRUE 1

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
	int i=1;
	int maxNum=max(x,y,z);
	int multiMaxNum;

	if(x==0 || y==0 || z==0)
		return 0;

	while(i)
	{
		multiMaxNum=i*maxNum;
		i++;
		if(multiMaxNum%x==0 && multiMaxNum%y==0 && multiMaxNum%z==0)
		{
			return multiMaxNum;
		}
		
	}
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