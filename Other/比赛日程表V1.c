//二分法递归解决比赛日程表问题
#include<stdio.h>
#define MAXSIZE 32
#define OK 1
#define ERROR 0
int table [MAXSIZE][MAXSIZE];//比赛日程表

int dimidiate(int rowa,int rowb,int size)
{
	int i,j,k;
	if(rowa>MAXSIZE || rowb>MAXSIZE)
		return ERROR;
	if(size==2)
	{
		table[rowa][rowb]=rowa;
		table[rowa+1][rowb]=rowa+1;

		table[rowa][rowb+1]=rowa+1;
		table[rowa+1][rowb+1]=rowa;		
	}
	else
	{
		dimidiate(rowa,rowb,size/2);
		dimidiate(rowa+size/2,rowb,size/2);

		for(i=rowa;i<rowa+size/2;i++)
		{
			for(j=rowb;j<rowb+size/2;j++)
			{
				table[i][j+size/2]=table[i+size/2][j];
				table[i+size/2][j+size/2]=table[i][j];
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

	if(OK== dimidiate(0,0,size))
	{
		for(i=0;i<size;i++)
		{
			for(j=0;j<size;j++)
			{
				printf("%4d",table[i][j]);
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