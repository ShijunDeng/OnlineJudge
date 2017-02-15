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
#define MAXINT 65535

/* #define OVERFLOW -2 因为在math.h中已定义OVERFLOW的值为3,故去掉此行 */
typedef int Status; /* Status是函数的类型,其值是函数结果状态代码，如OK等 */
typedef int Boolean; /* Boolean是布尔类型,其值是TRUE或FALSE */



/*
data[]:存放size个重量数据
weight:参照数据
*/
 Status knap(int data[],int weight,int size)
 {
	 int i,j,k;
	 int mi,mj,mk;//存放最符合的结果时选取的三件物品的序号
	 int diff;
	 int minDiff=MAXINT;//存放当前试探与weight的最小差值
	 for(i=0;i<size;i++)//#1
	 {
		 for(j=i+1;j<size;j++)//#2
		 {
			 for(k=j+1;k<size;k++)//#3
			 {
				 diff=fabs(weight-data[i]-data[j]-data[k]);//求选取的物件与weight的差值
				if(diff<minDiff)
				{
					minDiff=diff;
					mi=i;
					mj=j;
					mk=k;
				}

			 }//end:for #3
		 }//end:for #2
	 }//end:for #1

	 printf("minDiff=%d sequence:%d %d %d\n",minDiff,mi,mj,mk);
	 return OK;
 }

//业务逻辑:数据输入 调用求解函数 输出结果
int service()
{
	int *data,size,i,weight;

	printf("input size,reference weight:");
	scanf("%d %d",&size,&weight);

	data=(int *)malloc((size+1)*sizeof(int));
	if(data==NULL)//申请内存失败
	{
		printf("ERROR!\n");
		return ERROR;
	}



	printf("input %d integers:\n",size);
	for(i=0;i<size;i++)//输入size个数据
	{
		scanf("%d",data+i);
	}

	knap(data,weight,size);

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