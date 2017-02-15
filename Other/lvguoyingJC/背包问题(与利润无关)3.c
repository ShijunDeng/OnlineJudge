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
#define PRESISION 1E-4//���ȷ�Χ������ֵС��precision�Ľ�����Ϊ��0

/* #define OVERFLOW -2 ��Ϊ��math.h���Ѷ���OVERFLOW��ֵΪ3,��ȥ������ */
typedef int Status; /* Status�Ǻ���������,��ֵ�Ǻ������״̬���룬��OK�� */
typedef int Boolean; /* Boolean�ǲ�������,��ֵ��TRUE��FALSE */



/*
data[]:���number����������
capacity:����ʣ������
n:�����������ŷ�Χ��[0:n-1]
*/
 Boolean knap(float data[],float capacity,int n)
 {
	if(fabs(capacity) <= PRESISION)//��������Ϊ��
	{
		return TRUE;
	}

	if(n<0  &&  fabs(capacity)>PRESISION)//��Ʒ��װ�� ������δ��
	{
		return FALSE;
	}

	if(n>=0  &&  fabs(capacity)<=PRESISION)//��Ʒδװ�� ����������
	{
		return FALSE;
	}

	if(knap(data,capacity-data[n],n-1) == TRUE)//װ�����Ϊn����Ʒ��պú���
	{
		printf("%.2f ",data[n]);
		return TRUE;
	}

	return knap(data,capacity,n-1);//���Ϊn����Ʒ��װ��
 }

//ҵ���߼�:�������� ������⺯�� ������
int service()
{
	float *data ,capacity;
	int i,number;

	printf("input number, capacity:");
	scanf("%d %f",&number,&capacity);

	data=(float *)malloc((number+1)*sizeof(float));
	if(data==NULL)//�����ڴ�ʧ��
	{
		printf("ERROR!\n");
		return ERROR;
	}



	printf("input %d weight numbers:\n",number);
	for(i=0;i<number;i++)//����number������
	{
		scanf("%f",data+i);
	}

	printf("%.2f:",capacity);
	knap(data,capacity,number-1);

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