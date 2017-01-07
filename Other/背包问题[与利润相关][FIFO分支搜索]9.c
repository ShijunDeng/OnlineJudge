//��������:������������� ��˷�����  FIFO��֧�޽�
#include<stdio.h>
#include<malloc.h>
#include<math.h>

//�������״̬����
#define MAXSIZE 1024
#define TRUE 1
#define FALSE 0
#define OK 1
#define ERROR 0
#define INFEASIBLE -1

typedef int Status; //Status�Ǻ���������,��ֵ�Ǻ������״̬���룬��OK�� 
typedef int Boolean; // Boolean�ǲ�������,��ֵ��TRUE��FALSE 


typedef struct Node
{
	int level;//������ǵ�level������
	int visited;//�Ƿ񱻷���
	int parent;//���ڵ���±�
	double bonus;//��ǰ�Ѷ�·������ǰ�ڵ�ʱ������
	double weight;//��ǰ�Ѷ�·������ǰ�ڵ�ʱ������
}Node;
Node Q[MAXSIZE];//��������ڵ� ģ�����

//FIFO��֧�޽�����������
//����ȡ�����������һ֧��ͷ���
int tryKnap(double* comms,double* bonus,double capacity,int number)
{
	Node p,q;
	int front,rear;//��βָ��
	double maxBonus=0;//��ǰ̽�⵽���������ֵ
	int maxBoHead=0;//ȡ���������ķ�֧��ͷ��� 

	front=rear=-1;//���г�ʼ��Ϊ��

	//��ʼ�����ڵ�
	p.level=-1;	
	p.visited=0;	
	p.parent=-1;
	p.bonus=0;
	p.weight=0;
	
	//��p�ڵ����
	rear++;
	Q[rear]=p;

	while(rear != front)//while #1 ���в���
	{
		front++;
		q=Q[front];//����

		if(q.level+1<number)//if #1//δ�������һ��
		{
			//��������
			p.weight=q.weight+comms[q.level + 1];
			if(p.weight <= capacity)//if #2
			{
				p.bonus=q.bonus+bonus[q.level + 1];	
				p.visited=1;
				p.level=q.level+1;
				p.parent=front;
				//��p�ڵ����
				rear++;
				Q[rear]=p;
			//	printf("pb%.2f--pw%.2lf--b%.2lf--w%.2lf\n",p.bonus,p.weight,bonus[p.level],comms[p.level]);

				if(p.bonus>maxBonus)
				{
				
					maxBonus=p.bonus;
					maxBoHead=rear;
				}
			}//end:if #2	

			//�����Һ���
			p.weight=q.weight;
			p.bonus=q.bonus;
			p.visited=0;
			p.level=q.level+1;
			p.parent=front;
			//��p�ڵ����
			rear++;
			Q[rear]=p;
		}//end:if #1	
	}//end:while #1
	return maxBoHead;

}

//ҵ���߼�:�������� ������⺯�� ������
int service()
{
	int i;
	double s=0;
	double* comms;//��Ż��������
	double* bonus;//�����
	double capacity;//����
	int number;//����ļ���
	//double maxBonus=0;//��õ�������� 
	int maxBoHead=0;

	printf("input number, capacity:");
	scanf("%d %lf",&number,&capacity);

	if(MAXSIZE<pow(2,number+1))
	{
		return ERROR;//������������
	}

	comms=(double *)malloc(number*sizeof(double));
	if(comms==NULL)
		return ERROR;

	bonus=(double *)malloc(number*sizeof(double));
	if(bonus==NULL)
	{
		free(comms);//�����ڴ�ʧ�� ����ǰ������Ŀռ�
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
		printf("All selected!\n");
		return OK;
	}

	printf("bonus table:");
	for(i=0;i<number;i++)//�����
	{
		scanf("%lf",bonus+i);
	} 

	maxBoHead=tryKnap(comms,bonus,capacity,number);

	printf("selected(comms[bonus]):");
	i=maxBoHead;
	while(i>=0)
	{
		if(Q[i].visited==1)
		{
			printf("%.2lf[%.2lf] ",comms[Q[i].level],bonus[Q[i].level]);		
		}
		i=Q[i].parent;
	}

	printf(" maxBonus:%.2lf\n",Q[maxBoHead].bonus);

	free(comms);
	free(bonus);
	return OK;
}


/*
��������
5 10
1 2 3 4 5
5 6 18 4 20
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