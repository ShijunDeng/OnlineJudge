//最大子段和问题:动态规划
#include<stdio.h>
#include<malloc.h>

#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0
 
//求数组data的最大字段和,a、b为最大字段和的起始下标,size为数组的大小
int maxSubSum(int data[],int *a,int *b,int size)
{ 
	int *thisSum;//thisSum[0]=0.若thisSum[i-1]>=0(thisSum[i]对最大子段和有贡献),thisSum[i]=thisSum[i-1]+a[i];
	//否则(thisSum[i]对最大子段和没有贡献)thisSum[i]=0;
	
	int *sum;//sum[i]:a[0]~a[i-1]的最大字段和
	int maxSubSum=-1;
	int i,j;

	thisSum=(int *)malloc((1+size)*sizeof(int));
	if(thisSum==NULL)
	{
		return ERROR;
	}

	sum=(int *)malloc((1+size)*sizeof(int));
	if(sum==NULL)
	{
		return ERROR;
	}

	thisSum[0]=0;
	sum[0]=0;
	j=0;

	for(i=1;i<=size;i++)// #1
	{
		thisSum[i]=thisSum[i-1]+data[i-1];

		sum[i]=sum[i-1];//先将sum[i]置为sum[i-1]，如有需要再覆盖

		if(thisSum[i]>sum[i])
		{
			sum[i]=thisSum[i];
			*a=j;
			*b=i-1;

		}
		else if(thisSum[i]<0)
		{
			j=i;
			thisSum[i]=0;
		}

	}//end:for #1


	maxSubSum=sum[size];
	free(thisSum);
	free(sum);
	return maxSubSum;
}

//业务逻辑:数据输入 调用求解函数 输出结果
int service()
{
	int *data,size,i,max;
	int a,b;//求得的最大字段和对应的下标起始位置

	printf("input size:");
	scanf("%d",&size);

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

	max=maxSubSum(data,&a,&b,size);
	printf("Max:%d [%d,%d]\n",max,a,b);

	free(data);

	return OK;
}


/*
测试数据
6
-2 11 -4 13 -5 -2
*/
int main()
{
	service();

	return OK;
}