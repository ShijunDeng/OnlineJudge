//最大子段和问题：枚举法
#include<stdio.h>
#include<malloc.h>

#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0
 
//求数组data的最大字段和,a、b为最大字段和的起始下标,size为数组的大小
int maxSubSum(int data[],int *a,int *b,int size)
{ 
	int maxSubSum=-1,sum=0;
	int i,j,k;

	for(i=0;i<size;i++)//#1
	{
		sum=0;//每次枚举之前 sum置零
		for(j=i;j<size;j++)//#2
		{
		//	sum=0;//每次枚举之前 sum置零
		//	for(k=j;k<size;k++)//#3
		//	{
				//sum+=data[k];
				sum+=data[j];
				if(sum>maxSubSum)//试探到一个更大的字段和 更新当前的信息
				{
					maxSubSum=sum;
					*a=i;
					*b=j;
				}
		//	}//end:for #3
		}//end:for #2
	}//end:for #1
	
	return maxSubSum;
}

//业务逻辑:数据输入 调用求解函数 输出结果
int service()
{
	int *data,size,i,max;
	int a,b;//求得的最大字段和对应的下标起始位置

	printf("input size:");
	scanf("%d",&size);

	data=(int *)malloc(size*sizeof(int));
	 
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