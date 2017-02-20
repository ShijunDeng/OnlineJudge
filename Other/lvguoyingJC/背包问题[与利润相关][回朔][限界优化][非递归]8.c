//背包问题:与利润相关问题 回朔法解决  非递归方法
#include<stdio.h>
#include<malloc.h>
#include<math.h>
//#include<stdlib.h>

/* 函数结果状态代码 */
#define TRUE 1
#define FALSE 0
#define OK 1
#define ERROR 0
#define INFEASIBLE -1
#define PRESISION 1E-4//精度范围，绝对值小于precision的近似认为是0

// #define OVERFLOW -2 因为在math.h中已定义OVERFLOW的值为3,故去掉此行
typedef int Status; //Status是函数的类型,其值是函数结果状态代码，如OK等 
typedef int Boolean; // Boolean是布尔类型,其值是TRUE或FALSE 
 
//将利润表从大到小排序  并将相应的货物顺序作调整  使其顺序和利润表一致
Status sortT(double* comms,double* bonus,int number)
{
	int i,j;
	int mark=1;
	double temp;
	double *bonusRates;

	bonusRates=(double *)malloc (number*sizeof(double));//存放利润率

	if(bonusRates==NULL)
	{
		return ERROR;
	}

	for(i=0;i<number;i++)
	{
		bonusRates[i]=bonus[i]/comms[i];
	}
	
	for(i=0;i<number&&mark;i++)//for #1
	{
		mark=0;
		for(j=1;j<number-i;j++)//for #2
		{	
			if(bonusRates[j-1]<bonusRates[j]) 
			{
				mark=1;

				temp=bonus[j];
				bonus[j]=bonus[j-1];
				bonus[j-1]=temp;

				temp=comms[j];
				comms[j]=comms[j-1];
				comms[j-1]=temp;

			}
		}//end:for #2
	}//end:for #1
	free(bonusRates);
	return OK;
}


//qsort(bonus,number,sizeof(double),comp);//从大到小排序
int comp(const void *a,const void *b)
{
	return *(double*)b>*(double*)a? 1:-1;
}

//计算在该分支上最多可以获利多少
double maxBo(double* comms,double* bonus,int* selected,double capacity,int number,int sequence,double weight,double partBonus)
{
	double partWeight=weight;
	int i=0;

	for(i=sequence+1;i<number;i++)
	{
		partWeight+=comms[i];	
		if(partWeight<=capacity)
		{
			partBonus+=bonus[i];
		}
		else
		{	 
			return partBonus+bonus[i]*(1- (partWeight-capacity)/comms[i] );//(capacity-partWeight+comms[i])/comms[i]
		}
	}
	return partBonus;
}
//非递归 回朔 限界优化策略解决背包问题

double tryKnap(double* comms,double* bonus,int* selected,int* optSelected,double capacity,int number)
{
	int i=0,j;
	double maxBonus=0;//当前所有探测到的获得的最大利润 初始值为0
	double partBonus=0;//当前探测路径上获得的利润
	double partWeight=0;//已装入的货物的重量 初始值为0
	while(TRUE)// while #1
	{
		while(i<number && partWeight+comms[i]<=capacity)// while #2
		{
			selected[i]=1;
			partWeight+=comms[i];
			partBonus+=bonus[i];		
			i++;
		}//end:while #2

		if(i==number && partBonus>maxBonus)//if #1探测到新的装入方式可以获得更大的利润
		{
			i=number-1;
			for(j=0;j<number;j++)
			{
				optSelected[j]=selected[j];				
			}
            maxBonus=partBonus;
		}//end:if #1
		else//else#1 if#1 
		{
			selected[i]=0;//不选第i件货物
		}//end:else #1 if#1	
		
		while(maxBo(comms,bonus,selected,capacity,number,i,partWeight,partBonus) <= maxBonus)//while #2
		{
			
			while(i>=0 && selected[i]==0)//while #3 找到最后一件选取的货物
			{
				i--;
			}//end:while #3
			if(i==-1)
			{
				
				return maxBonus;
			}

			selected[i]=0;
			partBonus-=bonus[i];
			partWeight-=comms[i];
		}//end:while #2	

		i++;		
	}//end:while #1
}

//业务逻辑:数据输入 调用求解函数 输出结果
int service()
{
	int i;
	double s=0;
	double* comms;//存放货物的重量
	double* bonus;//利润表
	int* selected;//当前选择装入的货物记录表  select[i]=1表示第i件货物选入 select[i]=0表示第i件货物不选入
	int* optSelected;//当前已求得的获利最大的时候选择情况 optSelected[i]=1表示第i件货物选入 optSelected[i]=0表示第i件货物不选入
	double capacity;//限重
	int number;//货物的件数
	double maxBonus=0;//获得的最大利润 

	printf("input number, capacity:");
	scanf("%d %lf",&number,&capacity);

	comms=(double *)malloc(number*sizeof(double));
	if(comms==NULL)
		return ERROR;

	bonus=(double *)malloc(number*sizeof(double));
	if(bonus==NULL)
	{
		free(comms);//申请内存失败 清理前面申请的空间
		return ERROR;
	}

	selected=(int *)malloc(number*sizeof(int));
	if(selected==NULL)
	{
		free(comms);//申请内存失败 清理前面申请的空间
		free(bonus);
		return ERROR;
	}

	optSelected=(int *)malloc(number*sizeof(int));
	if(optSelected==NULL)
	{
		free(comms);//申请内存失败 清理前面申请的空间
		free(bonus);
		free(selected);
		return ERROR;
	}


	printf("commodity table:");
	for(i=0;i<number;i++)//货物数量表
	{
		scanf("%lf",comms+i);
		s+=comms[i];
	}

	if(s<=capacity)//可以全部装完
	{
		free(comms);
		free(bonus);
		free(selected);
		free(optSelected);
		printf("All selected!\n");
		return OK;
	}

	printf("bonus table:");
	for(i=0;i<number;i++)//利润表
	{
		scanf("%lf",bonus+i);
	} 

	for(i=0;i<number;i++)//初始化selected optSelected选择列表
	{
		optSelected[i]=selected[i]=0;
	} 


	if(ERROR==sortT(comms,bonus,number))
	{
		free(comms);
		free(bonus);
		free(selected);
		free(optSelected);
		return ERROR;
	}

	maxBonus=tryKnap(comms,bonus,selected,optSelected,capacity,number);

	printf("selected(comms[bonus]):");
	for(i=0;i<number;i++)//利润表
	{
		if(optSelected[i]==1)
		 printf("%.2lf[%.2lf] ",comms[i],bonus[i]);
	}

	printf(" S:%.2lf\n",maxBonus);

	free(comms);
	free(bonus);
	free(selected);
	free(optSelected);
	return OK;
}


/*
测试数据
5 10
1 2 3 4 5
5 6 18 4 20
*/
int main()
{
	if(ERROR==service())
	{
		printf("REEOR!\n");
	}
	return OK;
}