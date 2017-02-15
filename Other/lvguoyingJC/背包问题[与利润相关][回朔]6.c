//��������:������������� ��˷�����
#include<stdio.h>
#include<malloc.h>
#include<math.h>

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

//���û�˷�� Ϊ���ٵݹ��ջ�ռ� ��ر������Ϊȫ�ֱ���

double* comms;//��Ż��������
double* bonus;//�����
int* selected;//��ǰѡ��װ��Ļ����¼��  select[i]=1��ʾ��i������ѡ�� select[i]=0��ʾ��i�����ﲻѡ��
int* optSelected;//��ǰ����õĻ�������ʱ��ѡ����� optSelected[i]=1��ʾ��i������ѡ�� optSelected[i]=0��ʾ��i�����ﲻѡ��
double capacity;//����
int number;//����ļ���
double maxBonus=0;//��õ�������� ��ʼֵΪ0
double weight=0;//��װ��Ļ�������� ��ʼֵΪ0


 double tryKnap(int sequence)
 {
	int i=0;
	double partSum=0;

	if(number==sequence)//if #1���������һ������(Ҷ�ڵ�)
	{
		for(i=0;i<number;i++)
		{
			partSum+=bonus[i]*selected[i];//����������
		}
		if(partSum>maxBonus)
		{
			for(i=0;i<number;i++)
			{
				optSelected[i]=selected[i];//��¼��ǰ�Ļ���ѡ�����
			}					
			maxBonus=partSum;//��¼��ǰ�����������
		}
		return maxBonus;
	}//end: if #1

	selected[sequence]=0;//��sequence�����ﲻѡ
	tryKnap(sequence+1);//������һ��������̽

	if(weight+comms[sequence] <=capacity)//����װ�뵱ǰ�Ļ���
	{
		selected[sequence]=1;//��sequence��������ѡ
		weight+=comms[sequence];
		tryKnap(sequence+1);//������һ��������̽
		
		
		//��˷ �����ֳ�
		selected[sequence]=0;
		weight-=comms[sequence];
	}
	return maxBonus;
 }

//ҵ���߼�:�������� ������⺯�� ������
int service()
{
	int i;
	double s=0;

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

	if(s<capacity)//����ȫ��װ��
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
	tryKnap(0);//�ӵ�0�����￪ʼ����

	printf("selected:");
	for(i=0;i<number;i++)//�����
	{
		if(optSelected[i]==1)
		 printf("%d ",i);
	}

	printf("%.2lf\n",maxBonus);

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