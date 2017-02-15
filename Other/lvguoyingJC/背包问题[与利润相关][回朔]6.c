//背包问题:与利润相关问题 回朔法解决
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

//采用回朔法 为减少递归的栈空间 相关变量设计为全局变量

double* comms;//存放货物的重量
double* bonus;//利润表
int* selected;//当前选择装入的货物记录表  select[i]=1表示第i件货物选入 select[i]=0表示第i件货物不选入
int* optSelected;//当前已求得的获利最大的时候选择情况 optSelected[i]=1表示第i件货物选入 optSelected[i]=0表示第i件货物不选入
double capacity;//限重
int number;//货物的件数
double maxBonus=0;//获得的最大利润 初始值为0
double weight=0;//已装入的货物的重量 初始值为0


 double tryKnap(int sequence)
 {
	int i=0;
	double partSum=0;

	if(number==sequence)//if #1搜索到最后一件货物(叶节点)
	{
		for(i=0;i<number;i++)
		{
			partSum+=bonus[i]*selected[i];//计算获利情况
		}
		if(partSum>maxBonus)
		{
			for(i=0;i<number;i++)
			{
				optSelected[i]=selected[i];//记录当前的货物选择情况
			}					
			maxBonus=partSum;//记录当前获得最大的利润
		}
		return maxBonus;
	}//end: if #1

	selected[sequence]=0;//第sequence件货物不选
	tryKnap(sequence+1);//进行下一件货物试探

	if(weight+comms[sequence] <=capacity)//可以装入当前的货物
	{
		selected[sequence]=1;//第sequence件货物入选
		weight+=comms[sequence];
		tryKnap(sequence+1);//进行下一件货物试探
		
		
		//回朔 清理现场
		selected[sequence]=0;
		weight-=comms[sequence];
	}
	return maxBonus;
 }

//业务逻辑:数据输入 调用求解函数 输出结果
int service()
{
	int i;
	double s=0;

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

	if(s<capacity)//可以全部装完
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
	tryKnap(0);//从第0件货物开始尝试

	printf("selected:");
	for(i=0;i<number;i++)//利润表
	{
		if(optSelected[i]==1)
		 printf("%d ",i);
	}

	printf("%.2lf\n",maxBonus);

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