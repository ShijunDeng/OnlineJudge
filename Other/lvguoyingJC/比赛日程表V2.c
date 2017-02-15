//二分法 非 递归解决比赛日程表问题
#include<stdio.h>
#define MAXSIZE 32
#define OK 1
#define ERROR 0
int table [MAXSIZE][MAXSIZE];//比赛日程表

int dimidiate(int size)
{
	int i,j,n=1,row,column,step;

	n =size;
	 
	if(n > MAXSIZE)
		return ERROR;

	for(i=0;i<size;i++)
	{
		table[i][0]=i+1;//初始化第一列
	}

	for(i=2;i<=n;i*=2)//控制规模
	{
		step=i/2; //二分步长

		for(j=0;j<n;j+=i)
		{
			for(row=j;row<j+step;row++)
			{
				for(column=step;column<i;column++)
				{
					table[row][column]=table[row+step][column-step];
					table[row+step][column]=table[row][column-step];
				}
			}
		}
	}

	return OK;
}
int service()
{
	int i,j,size;

	printf("size:");
	scanf("%d",&size);

	if(OK== dimidiate(size))
	{
		for(i=0;i<size;i++)
		{
			for(j=0;j<size;j++)
			{
				printf("%6d",table[i][j]);
			}
			printf("\n");
		}
		return OK;
	}
	else
		return ERROR;

}

int main()
{
	service();
	return OK;
}