//背包问题:与利润相关问题
#include<stdio.h>
#include<malloc.h>
#include<math.h>

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
capacity:限重
number:货物的种数
*/
 double knap(double comms[],double bonus[],double capacity,int number)
 {
	 double max1;//装入当前货物获得的利润
	 double max2;//不装入当前货物获取的利润
	 if(number==-1||capacity==0)//已装完
	 {
		 return 0;
	 }

	max2=knap(comms,bonus,capacity,number-1);//递归求解不装入当前货物的总利润
	
	if(capacity-comms[number]>=0)//当前的货物能装下
	{
		max1= knap(comms,bonus,capacity-comms[number],number-1)+bonus[number];
	}

	return max1 > max2 ? max1:max2;//返回获利多的那种情况

 }

//业务逻辑:数据输入 调用求解函数 输出结果
int service()
{
	double *comms ,capacity , *bonus;
	int i,number;

	printf("input number, capacity:");
	scanf("%d %lf",&number,&capacity);

	comms=(double *)malloc(number*sizeof(double));
	if(comms==NULL)
		return ERROR;
	bonus=(double *)malloc(number*sizeof(double));
	if(bonus==NULL)
	{
		free(comms);
		return ERROR;
	}

	printf("commodity table:");
	for(i=0;i<number;i++)//货物数量表
	{
		scanf("%lf",comms+i);
	}

	printf("bonus table:");
	for(i=0;i<number;i++)//利润表
	{
		scanf("%lf",bonus+i);
	} 

	printf("Total bonus:%.2f\n",knap(comms,bonus, capacity,number-1));

	free(comms);
	free(bonus);

	return OK;
}


/*
测试数据
5 10
1 2 3 4 5
5 4 3 2 1

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

	return OK;
}