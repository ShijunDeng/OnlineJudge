//����Ӷκ����⣺ö�ٷ�
#include<stdio.h>
#include<malloc.h>

#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0
 
//������data������ֶκ�,a��bΪ����ֶκ͵���ʼ�±�,sizeΪ����Ĵ�С
int maxSubSum(int data[],int *a,int *b,int size)
{ 
	int maxSubSum=-1,sum=0;
	int i,j,k;

	for(i=0;i<size;i++)//#1
	{
		sum=0;//ÿ��ö��֮ǰ sum����
		for(j=i;j<size;j++)//#2
		{
		//	sum=0;//ÿ��ö��֮ǰ sum����
		//	for(k=j;k<size;k++)//#3
		//	{
				//sum+=data[k];
				sum+=data[j];
				if(sum>maxSubSum)//��̽��һ��������ֶκ� ���µ�ǰ����Ϣ
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

//ҵ���߼�:�������� ������⺯�� ������
int service()
{
	int *data,size,i,max;
	int a,b;//��õ�����ֶκͶ�Ӧ���±���ʼλ��

	printf("input size:");
	scanf("%d",&size);

	data=(int *)malloc(size*sizeof(int));
	 
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