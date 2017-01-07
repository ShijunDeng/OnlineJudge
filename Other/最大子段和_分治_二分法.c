//����Ӷκ����⣺���η�
#include<stdio.h>
#include<malloc.h>

#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0
 
//������data������ֶκ�,a��bΪ����ֶκ͵���ʼ�±�,left,rightΪ�ֶε���ʼ�±�
int maxSubSum(int data[],int *a,int *b,int left,int right)
{ 
	int lMaxSum;//��˵�����ֶκ�
	int li,lj;//�������ֶκ͵���ʼ�±�
	int rMaxSum;//�Ҷ˵�����ֶκ�
	int ri,rj;//�Ҷ�����ֶκ͵���ʼ�±�

	int mid=(left+right)/2;

	//����ֶκͿ�Խ�������˵����
	int s1=-1,s2=-1;
	int i,j,k;

	int tempSum=0;

	if(left==right)
	{
		if(data[left]>0)
			return data[left];
		return 0;
	}

	//�ݹ������˺��Ҷ˵�����ֶκ�
	lMaxSum=maxSubSum(data,&li,&lj,left,mid);
	rMaxSum=maxSubSum(data,&ri,&rj,mid+1,right);

	//����ֶκͿ�Խ���˵����
	for(k=mid;k>=left;k--)
	{
		tempSum+=data[k];
		if(tempSum>s1)
		{
			s1=tempSum;
			i=k;
		}
	}

	tempSum=0;//����
	for(k=mid+1;k<=right;k++)
	{
		tempSum+=data[k];
		if(tempSum>s2)
		{
			s2=tempSum;
			j=k;
		}
	}

	//����ֶκͿ�Խ����
	if(s1+s2>lMaxSum && s1+s2>rMaxSum)
	{
		*a=i;
		*b=j;
		return s1+s2;
	}
	//����ֶκ����Ҷ�
	else if(lMaxSum<rMaxSum)
	{
		*a=ri;
		*b=rj;
		return rMaxSum;
	}
	//����ֶκ������
	*a=li;
	*b=lj;	
	return lMaxSum;
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

	max=maxSubSum(data,&a,&b,0,size-1);
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