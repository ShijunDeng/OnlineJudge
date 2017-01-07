//����ѡ����:��������ָ����һֻ���ӵ�����
#include<stdio.h>
#include<malloc.h>

#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0
#define STEP 3
typedef struct LNode
{
	int data;//��ź��ӵ��±���Ϣ
	struct LNode * next;
}LNode,*LinkList;


int choose(int number,int startIndex)
{ 

	LNode *head,*p,*q;//����ͷ���
	int i;

	head=(LNode *)malloc(sizeof(LNode));

	if(NULL==head)
	{
		printf("malloc failed!\n");
		return ERROR;//�ڴ�����ʧ��
	}

	head->data=1;
	q=head;

	for(i=1;i<number;i++)//�������� �����±���Ϣ����
	{
		p=(LNode *)malloc(sizeof(LNode));
		p->data=i+1;//�±�
		q->next=p;
		q=p;
	}

	p->next=head;//��λ���� ��ѭ������

	p=head;
//	q=head->next;

	i=1;
	while(i<startIndex)//�ҵ���ʼλ��
	{
		q=p;
		p=p->next;
		i++;
	}

	while(p!=q)
	{
		for(i=0;i<STEP-1;i++)//��1����3
		{
			q=p;
			p=p->next;
		}
		//��3�ĺ����˳�

		q->next=p->next;
		free(p);//�ͷ�p;
		p=q->next;
	}

	i=p->data;//�ݴ�p�����ݣ����һֻ���ӵı��
	free(p);//�ͷ�p;

	return i;
}

//ҵ���߼�:�������� ������⺯�� ������
int service()
{
	int number,startIndex,king;

	printf("input number,startIndex:");
	scanf("%d %d",&number,&startIndex);

	king=choose(number,startIndex);
	if(king==ERROR)
	{
		printf("ERROR!\n");
	}
	else
	{
		printf("KING:%d\n",king);
	}
	

}

int main()
{
	service();

	return OK;
}