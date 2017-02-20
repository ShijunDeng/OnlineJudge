//��������:������������� ��˷�����  �ǵݹ鷽��
#include<stdio.h>
#include<malloc.h>
#include<math.h>
//#include<stdlib.h>

/* �������״̬���� */
#define TRUE 1
#define FALSE 0
#define OK 1
#define ERROR 0
#define INFEASIBLE -1
#define PRESISION 1E-4//���ȷ�Χ������ֵС��precision�Ľ�����Ϊ��0

// #define OVERFLOW -2 ��Ϊ��math.h���Ѷ���OVERFLOW��ֵΪ3,��ȥ������
typedef int Status; //Status�Ǻ���������,��ֵ�Ǻ������״̬���룬��OK�� 
typedef int Boolean; // Boolean�ǲ�������,��ֵ��TRUE��FALSE 
 
//�������Ӵ�С����  ������Ӧ�Ļ���˳��������  ʹ��˳��������һ��
Status sortT(double* comms,double* bonus,int number)
{
	int i,j;
	int mark=1;
	double temp;
	double *bonusRates;

	bonusRates=(double *)malloc (number*sizeof(double));//���������

	if(bonusRates==NULL)
	{
		return ERROR;
	}

	for(i=0;i<number;i++)
	{
		bonusRates[i]=bonus[i]/comms[i];
	}
	
	for(i=0;i<number&&mark;i++)//for #1
	{
		mark=0;
		for(j=1;j<number-i;j++)//for #2
		{	
			if(bonusRates[j-1]<bonusRates[j]) 
			{
				mark=1;

				temp=bonus[j];
				bonus[j]=bonus[j-1];
				bonus[j-1]=temp;

				temp=comms[j];
				comms[j]=comms[j-1];
				comms[j-1]=temp;

			}
		}//end:for #2
	}//end:for #1
	free(bonusRates);
	return OK;
}


//qsort(bonus,number,sizeof(double),comp);//�Ӵ�С����
int comp(const void *a,const void *b)
{
	return *(double*)b>*(double*)a? 1:-1;
}

//�����ڸ÷�֧�������Ի�������
double maxBo(double* comms,double* bonus,int* selected,double capacity,int number,int sequence,double weight,double partBonus)
{
	double partWeight=weight;
	int i=0;

	for(i=sequence+1;i<number;i++)
	{
		partWeight+=comms[i];	
		if(partWeight<=capacity)
		{
			partBonus+=bonus[i];
		}
		else
		{	 
			return partBonus+bonus[i]*(1- (partWeight-capacity)/comms[i] );//(capacity-partWeight+comms[i])/comms[i]
		}
	}
	return partBonus;
}
//�ǵݹ� ��˷ �޽��Ż����Խ����������

double tryKnap(double* comms,double* bonus,int* selected,int* optSelected,double capacity,int number)
{
	int i=0,j;
	double maxBonus=0;//��ǰ����̽�⵽�Ļ�õ�������� ��ʼֵΪ0
	double partBonus=0;//��ǰ̽��·���ϻ�õ�����
	double partWeight=0;//��װ��Ļ�������� ��ʼֵΪ0
	while(TRUE)// while #1
	{
		while(i<number && partWeight+comms[i]<=capacity)// while #2
		{
			selected[i]=1;
			partWeight+=comms[i];
			partBonus+=bonus[i];		
			i++;
		}//end:while #2

		if(i==number && partBonus>maxBonus)//if #1̽�⵽�µ�װ�뷽ʽ���Ի�ø��������
		{
			i=number-1;
			for(j=0;j<number;j++)
			{
				optSelected[j]=selected[j];				
			}
            maxBonus=partBonus;
		}//end:if #1
		else//else#1 if#1 
		{
			selected[i]=0;//��ѡ��i������
		}//end:else #1 if#1	
		
		while(maxBo(comms,bonus,selected,capacity,number,i,partWeight,partBonus) <= maxBonus)//while #2
		{
			
			while(i>=0 && selected[i]==0)//while #3 �ҵ����һ��ѡȡ�Ļ���
			{
				i--;
			}//end:while #3
			if(i==-1)
			{
				
				return maxBonus;
			}

			selected[i]=0;
			partBonus-=bonus[i];
			partWeight-=comms[i];
		}//end:while #2	

		i++;		
	}//end:while #1
}

//ҵ���߼�:�������� ������⺯�� ������
int service()
{
	int i;
	double s=0;
	double* comms;//��Ż��������
	double* bonus;//�����
	int* selected;//��ǰѡ��װ��Ļ����¼��  select[i]=1��ʾ��i������ѡ�� select[i]=0��ʾ��i�����ﲻѡ��
	int* optSelected;//��ǰ����õĻ�������ʱ��ѡ����� optSelected[i]=1��ʾ��i������ѡ�� optSelected[i]=0��ʾ��i�����ﲻѡ��
	double capacity;//����
	int number;//����ļ���
	double maxBonus=0;//��õ�������� 

	printf("input number, capacity:");
	scanf("%d %lf",&number,&capacity);

	comms=(double *)malloc(number*sizeof(double));
	if(comms==NULL)
		return ERROR;

	bonus=(double *)malloc(number*sizeof(double));
	if(bonus==NULL)
	{
		free(comms);//�����ڴ�ʧ�� ����ǰ������Ŀռ�
		return ERROR;
	}

	selected=(int *)malloc(number*sizeof(int));
	if(selected==NULL)
	{
		free(comms);//�����ڴ�ʧ�� ����ǰ������Ŀռ�
		free(bonus);
		return ERROR;
	}

	optSelected=(int *)malloc(number*sizeof(int));
	if(optSelected==NULL)
	{
		free(comms);//�����ڴ�ʧ�� ����ǰ������Ŀռ�
		free(bonus);
		free(selected);
		return ERROR;
	}


	printf("commodity table:");
	for(i=0;i<number;i++)//����������
	{
		scanf("%lf",comms+i);
		s+=comms[i];
	}

	if(s<=capacity)//����ȫ��װ��
	{
		free(comms);
		free(bonus);
		free(selected);
		free(optSelected);
		printf("All selected!\n");
		return OK;
	}

	printf("bonus table:");
	for(i=0;i<number;i++)//�����
	{
		scanf("%lf",bonus+i);
	} 

	for(i=0;i<number;i++)//��ʼ��selected optSelectedѡ���б�
	{
		optSelected[i]=selected[i]=0;
	} 


	if(ERROR==sortT(comms,bonus,number))
	{
		free(comms);
		free(bonus);
		free(selected);
		free(optSelected);
		return ERROR;
	}

	maxBonus=tryKnap(comms,bonus,selected,optSelected,capacity,number);

	printf("selected(comms[bonus]):");
	for(i=0;i<number;i++)//�����
	{
		if(optSelected[i]==1)
		 printf("%.2lf[%.2lf] ",comms[i],bonus[i]);
	}

	printf(" S:%.2lf\n",maxBonus);

	free(comms);
	free(bonus);
	free(selected);
	free(optSelected);
	return OK;
}


/*
��������
5 10
1 2 3 4 5
5 6 18 4 20
*/
int main()
{
	if(ERROR==service())
	{
		printf("REEOR!\n");
	}
	return OK;
}