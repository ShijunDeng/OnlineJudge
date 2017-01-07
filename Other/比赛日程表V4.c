//递推法解决比赛日程表问题
#include<stdio.h>
#define MAXSIZE 32
#define OK 1
#define ERROR 0
int table [MAXSIZE+1][MAXSIZE+1];//比赛日程表

int dimidiate(int size)
{
	int n,i1,i2,i3,j1,j2,j3;
	 
	if(size<0 ||size >MAXSIZE)//给出的参数溢出  返回异常
		return ERROR;

	table[1][1]=1;//赋初值

	for(n=1;n<size;n*=2)//控制问题的规模
	{
		for(i1=n+1;i1<=2*n;i1++)//处理左下角问题
		{
			for(j1=1;j1<=n;j1++)
			{
				table[i1][j1]=table[i1-n][j1]+n;
			}
		}

		for(i2=1;i2<=n;i2++)//处理右上角问题
		{
			for(j2=n+1;j2<=2*n;j2++)
			{
				table[i2][j2]=table[i2][j2-n]+n;
			}
		}

		for(i3=n+1;i3<=2*n;i3++)//处理右下角问题
		{
			for(j3=n+1;j3<=2*n;j3++)
			{
				table[i3][j3]=table[i3-n][j3]-n;
			}
		}
	}


	return OK;
}
//业务逻辑:数据输入 调用求解函数 输出结果
int service()
{
	int i,j,size;

	printf("size:");
	scanf("%d",&size);

	if(OK== dimidiate(size))//调用求解函数成功
	{
		for(i=1;i<=size;i++)
		{
			for(j=1;j<=size;j++)
			{
				printf("%6d",table[i][j]);
			}
			printf("\n");
		}
		return OK;
	}
	else
		return ERROR;//求解函数中出现错误 不能正常求解

}

int main()
{
	service();
	return OK;
}