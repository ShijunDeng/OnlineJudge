//����Ӷκ�����:��̬�滮
#include<stdio.h>
#include<malloc.h>

#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0
 
//������data������ֶκ�,a��bΪ����ֶκ͵���ʼ�±�,sizeΪ����Ĵ�С
int maxSubSum(int data[],int *a,int *b,int size)
{ 
	int *thisSum;//thisSum[0]=0.��thisSum[i-1]>=0(thisSum[i]������Ӷκ��й���),thisSum[i]=thisSum[i-1]+a[i];
	//����(thisSum[i]������Ӷκ�û�й���)thisSum[i]=0;
	
	int *sum;//sum[i]:a[0]~a[i-1]������ֶκ�
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

		sum[i]=sum[i-1];//�Ƚ�sum[i]��Ϊsum[i-1]��������Ҫ�ٸ���

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

//ҵ���߼�:�������� ������⺯�� ������
int service()
{
	int *data,size,i,max;
	int a,b;//��õ�����ֶκͶ�Ӧ���±���ʼλ��

	printf("input size:");
	scanf("%d",&size);

	data=(int *)malloc((size+1)*sizeof(int));
	 
	if(data==NULL)//�����ڴ�ʧ��
	{
		printf("ERROR!\n");
		return ERROR;
	}

	printf("input %d integers:\n",size);

	for(i=0;i<size;i++)//����size������
	{
		scanf("%d",data+i);
	}

	max=maxSubSum(data,&a,&b,size);
	printf("Max:%d [%d,%d]\n",max,a,b);

	free(data);

	return OK;
}


/*
��������
6
-2 11 -4 13 -5 -2
*/
int main()
{
	service();

	return OK;
}