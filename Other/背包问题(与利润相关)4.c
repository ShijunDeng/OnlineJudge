//��������:�������������
#include<stdio.h>
#include<malloc.h>
#include<math.h>
//#include<algorithm>
/* �������״̬���� */
#define TRUE 1
#define FALSE 0
#define OK 1
#define ERROR 0
#define INFEASIBLE -1
#define PRESISION 1E-4//���ȷ�Χ������ֵС��precision�Ľ�����Ϊ��0

/* #define OVERFLOW -2 ��Ϊ��math.h���Ѷ���OVERFLOW��ֵΪ3,��ȥ������ */
typedef int Status; /* Status�Ǻ���������,��ֵ�Ǻ������״̬���룬��OK�� */
typedef int Boolean; /* Boolean�ǲ�������,��ֵ��TRUE��FALSE */

/*
comms:��Ż��������
bonus:�����
num:���������
weight:����
bestRates:װ����˳���
mNum:����װ��bestRates 0~mNum-1������
*/
Status knap(double comms[],double bonus[],int num,double weight,int bestRates[],int*mNum)
{
	int i=0,j=0,k=0;
	int maxIndex=0;
	double maxRate=0.0;
	double sum=0.0;
	
	for(i=0;i<num;i++)//�����Ƿ񶼿���װ��
	{
		sum+=comms[i];
		bestRates[i]=i;
	}
 
	if(sum<=weight)//ȫ�����Զ�װ��
	{
		*mNum=num;
		return OK;
	}	
	for(i=0;i<num;i++)//#1
	{
		maxRate=0.0;
		for(j=0;j<num;j++)//#2
		{	
			if(bonus[j]/comms[j]>maxRate)//���� ��ֵ/���� ��ֵ
			{
				maxRate=bonus[j]/comms[j];
				maxIndex=j;
			}		
		}//end:for #2
		bestRates[i]=maxIndex;
		bonus[maxIndex]=0.0;//���������Ӧ��Ŀ���� �����ٴα�����
	}//end:for #1
	
	sum=0.0;
	for(i=0;sum<=weight;i++)
	{
		sum+=comms[bestRates[i]];
	}


	*mNum=i-1;

	return OK;
}


int service()
{
	int size;
	double weight;//��������
	double *comms , *bonus,*bonusS;//bonusS����bonus�ڼ�����Ҫ������ �������bonusS����bonus��ֵ
	int  *bestRates ,i;
	int mNum;
	double sumBonus=0.0;//�ܻ���
	double sumWeight=0.0;//��װ��

	printf("size,weight limits:");
	scanf("%d %lf",&size,&weight);

	comms=(double *)malloc(size*sizeof(double));
	if(comms==NULL)
		return ERROR;
	bonus=(double *)malloc(size*sizeof(double));
	if(bonus==NULL)
	{
		free(comms);
		return ERROR;
	}

	bonusS=(double *)malloc(size*sizeof(double));
	if(bonusS==NULL)
	{
		free(comms);
		free(bonus);
		return ERROR;
	}

	bestRates=(int *)malloc(size*sizeof(int));
	if(bestRates==NULL)
	{
		free(comms);
		free(bonus);
		free(bonusS);
		return ERROR;
	}

	printf("commodity table:");
	for(i=0;i<size;i++)//����������
	{
		scanf("%lf",comms+i);
	}

	printf("bonus table:");
	for(i=0;i<size;i++)//�����
	{
		scanf("%lf",bonus+i);
		bonusS[i]=bonus[i];
	} 

	if(ERROR==knap(comms,bonus,size, weight, bestRates,&mNum))
	{
		free(comms);
		free(bonus);
		free(bonusS);
		free(bestRates);
		return ERROR;
	}
	if(mNum==size)
	{
		printf("All selected!\n");
		free(comms);
		free(bonus);
		free(bonusS);
		free(bestRates);
		return OK;
	}
	printf("Selected: ");
	 
	for(i=0;i<mNum;i++)
	{
		printf("%d ",bestRates[i]);
		sumBonus+=bonusS[bestRates[i]];
		sumWeight+=comms[bestRates[i]];
	}
	printf("%.2lf %.2lf\n",sumWeight,sumBonus);

	free(comms);
	free(bonus);
	free(bonusS);
	free(bestRates);
	return OK;
}


/*
��������
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