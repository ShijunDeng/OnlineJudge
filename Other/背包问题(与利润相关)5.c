//��������:�������������
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



/*
comms:��Ż��������
bonus:�����
capacity:����
number:���������
*/
 double knap(double comms[],double bonus[],double capacity,int number)
 {
	 double max1;//װ�뵱ǰ�����õ�����
	 double max2;//��װ�뵱ǰ�����ȡ������
	 if(number==-1||capacity==0)//��װ��
	 {
		 return 0;
	 }

	max2=knap(comms,bonus,capacity,number-1);//�ݹ���ⲻװ�뵱ǰ�����������
	
	if(capacity-comms[number]>=0)//��ǰ�Ļ�����װ��
	{
		max1= knap(comms,bonus,capacity-comms[number],number-1)+bonus[number];
	}

	return max1 > max2 ? max1:max2;//���ػ�������������

 }

//ҵ���߼�:�������� ������⺯�� ������
int service()
{
	double *comms ,capacity , *bonus;
	int i,number;

	printf("input number, capacity:");
	scanf("%d %lf",&number,&capacity);

	comms=(double *)malloc(number*sizeof(double));
	if(comms==NULL)
		return ERROR;
	bonus=(double *)malloc(number*sizeof(double));
	if(bonus==NULL)
	{
		free(comms);
		return ERROR;
	}

	printf("commodity table:");
	for(i=0;i<number;i++)//����������
	{
		scanf("%lf",comms+i);
	}

	printf("bonus table:");
	for(i=0;i<number;i++)//�����
	{
		scanf("%lf",bonus+i);
	} 

	printf("Total bonus:%.2f\n",knap(comms,bonus, capacity,number-1));

	free(comms);
	free(bonus);

	return OK;
}


/*
��������
5 10
1 2 3 4 5
5 4 3 2 1

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

	return OK;
}