//��������:�������޹�����
#include<stdio.h>
#include<malloc.h>
#include<math.h>

/* �������״̬���� */
#define TRUE 1
#define FALSE 0
#define OK 1
#define ERROR 0
#define INFEASIBLE -1
#define MAXINT 65535

/* #define OVERFLOW -2 ��Ϊ��math.h���Ѷ���OVERFLOW��ֵΪ3,��ȥ������ */
typedef int Status; /* Status�Ǻ���������,��ֵ�Ǻ������״̬���룬��OK�� */
typedef int Boolean; /* Boolean�ǲ�������,��ֵ��TRUE��FALSE */



/*
data[]:���size����������
weight:��������
*/
 Status knap(int data[],int weight,int size)
 {
	 int i,j,k;
	 int mi,mj,mk;//�������ϵĽ��ʱѡȡ��������Ʒ�����
	 int diff;
	 int minDiff=MAXINT;//��ŵ�ǰ��̽��weight����С��ֵ
	 for(i=0;i<size;i++)//#1
	 {
		 for(j=i+1;j<size;j++)//#2
		 {
			 for(k=j+1;k<size;k++)//#3
			 {
				 diff=fabs(weight-data[i]-data[j]-data[k]);//��ѡȡ�������weight�Ĳ�ֵ
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

//ҵ���߼�:�������� ������⺯�� ������
int service()
{
	int *data,size,i,weight;

	printf("input size,reference weight:");
	scanf("%d %d",&size,&weight);

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

	knap(data,weight,size);

	free(data);

	return OK;
}


/*
��������
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