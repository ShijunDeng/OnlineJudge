#include<stdio.h>
#include<malloc.h>
//#include<stdlib.h>
//����״̬��
#define OK 0
#define ERROR -1
#define TRUE 1
#define FALSE 0

typedef int Status;
typedef int Boolean;
typedef int ElemType;

/*
����һ�������������������
���룺
�����ÿ�������е�һ�а���1��������n(1<=n<=1000)����������һ�а���n��������
�����
�����ж���������ݣ�����ÿ�����ݣ�
��n������������������֮��������������
�������룺
4
3 5 7 9
���������
3 5 7 9
*/

//����ڵ�
typedef struct LNode
{
	ElemType data;
	struct LNode *next;
}LNode,*LinkList;

//��ʼ������
Status initList(LinkList*L)
{
	*L=(LNode*)malloc(sizeof(LNode));
	(*L)->next=NULL;
	if(*L==NULL)
		return ERROR;
	return OK;
}
//������data���뵽L��
Status insertListAsc(LinkList L,ElemType data)
{
	LNode * p=(LNode*)malloc(sizeof(LNode));
	LNode *q;
	if(L==NULL)
		return ERROR;
	p->data=data;
	q=L;
	while(q->next!=NULL && data>q->next->data)
	{
		q=q->next;
	}
	p->next=q->next;
	q->next=p;

	return OK;
}

//���δ�ӡ����L�е�Ԫ��
Status printList(LinkList L)
{
	LNode *p;
	if(NULL==L)
		return ERROR;
	p=L->next;
	while(p->next!=NULL)
	{
		printf("%d ",p->data);
		p=p->next;
	}
	printf("%d",p->data);
	return OK;
}


//��������L
Status destroyList(LinkList*L)
{
	LNode *p;
	if(*L==NULL)
		return ERROR;
	p=*L;
	while(p!=NULL)
	{
		*L=(*L)->next;
		free(p);
		p=*L;
	}
	return OK;
}
//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	LinkList L;
	int i=0,j=0;
	int data=0;

	while(scanf("%d",&n)!=EOF)//while 1#
	{
		initList(&L);
		for(i=0;i<n;i++)//for 1#
		{	
			scanf("%d",&data);	
			insertListAsc(L,data);
		}//end:for 1#

		printList(L);
		
		printf("\n");
		destroyList(&L);
	}//end:while 1#

	return OK;
}

int main()
{
	if(ERROR==service())//�����������
	{
		printf("ERROR!\n");
		return ERROR;
	}

	return OK;

}