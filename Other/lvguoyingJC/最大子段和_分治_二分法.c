//最大子段和问题：分治法
#include<stdio.h>
#include<malloc.h>

#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0
 
//求数组data的最大字段和,a、b为最大字段和的起始下标,left,right为分段的起始下标
int maxSubSum(int data[],int *a,int *b,int left,int right)
{ 
	int lMaxSum;//左端的最大字段和
	int li,lj;//左端最大字段和的起始下标
	int rMaxSum;//右端的最大字段和
	int ri,rj;//右端最大字段和的起始下标

	int mid=(left+right)/2;

	//最大字段和跨越左右两端的情况
	int s1=-1,s2=-1;
	int i,j,k;

	int tempSum=0;

	if(left==right)
	{
		if(data[left]>0)
			return data[left];
		return 0;
	}

	//递归求得左端和右端的最大字段和
	lMaxSum=maxSubSum(data,&li,&lj,left,mid);
	rMaxSum=maxSubSum(data,&ri,&rj,mid+1,right);

	//最大字段和跨越两端的情况
	for(k=mid;k>=left;k--)
	{
		tempSum+=data[k];
		if(tempSum>s1)
		{
			s1=tempSum;
			i=k;
		}
	}

	tempSum=0;//清零
	for(k=mid+1;k<=right;k++)
	{
		tempSum+=data[k];
		if(tempSum>s2)
		{
			s2=tempSum;
			j=k;
		}
	}

	//最大字段和跨越两端
	if(s1+s2>lMaxSum && s1+s2>rMaxSum)
	{
		*a=i;
		*b=j;
		return s1+s2;
	}
	//最大字段和在右端
	else if(lMaxSum<rMaxSum)
	{
		*a=ri;
		*b=rj;
		return rMaxSum;
	}
	//最大字段和在左端
	*a=li;
	*b=lj;	
	return lMaxSum;
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

	max=maxSubSum(data,&a,&b,0,size-1);
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