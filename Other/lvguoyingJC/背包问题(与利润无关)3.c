//背包问题:与利润无关问题
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
data[]:存放number个重量数据
capacity:背包剩余容量
n:放置物件的序号范围是[0:n-1]
*/
 Boolean knap(float data[],float capacity,int n)
 {
	if(fabs(capacity) <= PRESISION)//背包容量为零
	{
		return TRUE;
	}

	if(n<0  &&  fabs(capacity)>PRESISION)//物品已装完 但背包未满
	{
		return FALSE;
	}

	if(n>=0  &&  fabs(capacity)<=PRESISION)//物品未装完 但背包已满
	{
		return FALSE;
	}

	if(knap(data,capacity-data[n],n-1) == TRUE)//装入序号为n的物品后刚好合适
	{
		printf("%.2f ",data[n]);
		return TRUE;
	}

	return knap(data,capacity,n-1);//序号为n的物品不装入
 }

//业务逻辑:数据输入 调用求解函数 输出结果
int service()
{
	float *data ,capacity;
	int i,number;

	printf("input number, capacity:");
	scanf("%d %f",&number,&capacity);

	data=(float *)malloc((number+1)*sizeof(float));
	if(data==NULL)//申请内存失败
	{
		printf("ERROR!\n");
		return ERROR;
	}



	printf("input %d weight numbers:\n",number);
	for(i=0;i<number;i++)//输入number个数据
	{
		scanf("%f",data+i);
	}

	printf("%.2f:",capacity);
	knap(data,capacity,number-1);

	free(data);

	return OK;
}


/*
测试数据
 5 500
 300 400 500 600 700
*/
int main()
{
	if(ERROR==service())
	{
		printf("REEOR!\n");
	}
	return OK;
}