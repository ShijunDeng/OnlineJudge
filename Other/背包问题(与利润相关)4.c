//背包问题:与利润相关问题
#include<stdio.h>
#include<malloc.h>
#include<math.h>
//#include<algorithm>
/* 函数结果状态代码 */
#define TRUE 1
#define FALSE 0
#define OK 1
#define ERROR 0
#define INFEASIBLE -1
#define PRESISION 1E-4//精度范围，绝对值小于precision的近似认为是0

/* #define OVERFLOW -2 因为在math.h中已定义OVERFLOW的值为3,故去掉此行 */
typedef int Status; /* Status是函数的类型,其值是函数结果状态代码，如OK等 */
typedef int Boolean; /* Boolean是布尔类型,其值是TRUE或FALSE */

/*
comms:存放货物的重量
bonus:利润表
num:货物的种数
weight:限重
bestRates:装货的顺序表
mNum:依次装入bestRates 0~mNum-1的数据
*/
Status knap(double comms[],double bonus[],int num,double weight,int bestRates[],int*mNum)
{
	int i=0,j=0,k=0;
	int maxIndex=0;
	double maxRate=0.0;
	double sum=0.0;
	
	for(i=0;i<num;i++)//测试是否都可以装完
	{
		sum+=comms[i];
		bestRates[i]=i;
	}
 
	if(sum<=weight)//全部可以都装完
	{
		*mNum=num;
		return OK;
	}	
	for(i=0;i<num;i++)//#1
	{
		maxRate=0.0;
		for(j=0;j<num;j++)//#2
		{	
			if(bonus[j]/comms[j]>maxRate)//计算 价值/重量 比值
			{
				maxRate=bonus[j]/comms[j];
				maxIndex=j;
			}		
		}//end:for #2
		bestRates[i]=maxIndex;
		bonus[maxIndex]=0.0;//利润表中相应项目置零 避免再次被计算
	}//end:for #1
	
	sum=0.0;
	for(i=0;sum<=weight;i++)
	{
		sum+=comms[bestRates[i]];
	}


	*mNum=i-1;

	return OK;
}


int service()
{
	int size;
	double weight;//背包限重
	double *comms , *bonus,*bonusS;//bonusS由于bonus在计算中要被覆盖 因此先用bonusS保存bonus的值
	int  *bestRates ,i;
	int mNum;
	double sumBonus=0.0;//总获利
	double sumWeight=0.0;//总装载

	printf("size,weight limits:");
	scanf("%d %lf",&size,&weight);

	comms=(double *)malloc(size*sizeof(double));
	if(comms==NULL)
		return ERROR;
	bonus=(double *)malloc(size*sizeof(double));
	if(bonus==NULL)
	{
		free(comms);
		return ERROR;
	}

	bonusS=(double *)malloc(size*sizeof(double));
	if(bonusS==NULL)
	{
		free(comms);
		free(bonus);
		return ERROR;
	}

	bestRates=(int *)malloc(size*sizeof(int));
	if(bestRates==NULL)
	{
		free(comms);
		free(bonus);
		free(bonusS);
		return ERROR;
	}

	printf("commodity table:");
	for(i=0;i<size;i++)//货物数量表
	{
		scanf("%lf",comms+i);
	}

	printf("bonus table:");
	for(i=0;i<size;i++)//利润表
	{
		scanf("%lf",bonus+i);
		bonusS[i]=bonus[i];
	} 

	if(ERROR==knap(comms,bonus,size, weight, bestRates,&mNum))
	{
		free(comms);
		free(bonus);
		free(bonusS);
		free(bestRates);
		return ERROR;
	}
	if(mNum==size)
	{
		printf("All selected!\n");
		free(comms);
		free(bonus);
		free(bonusS);
		free(bestRates);
		return OK;
	}
	printf("Selected: ");
	 
	for(i=0;i<mNum;i++)
	{
		printf("%d ",bestRates[i]);
		sumBonus+=bonusS[bestRates[i]];
		sumWeight+=comms[bestRates[i]];
	}
	printf("%.2lf %.2lf\n",sumWeight,sumBonus);

	free(comms);
	free(bonus);
	free(bonusS);
	free(bestRates);
	return OK;
}


/*
测试数据
5 10
1 2 3 4 5
5 4 3 2 1
*/
int main()
{
	if(ERROR==service())
	{
		printf("REEOR!\n");
	}
	return OK;
}