#include<stdio.h>
//#include<string.h>
#include<malloc.h>
//����״̬��
#define OK 0
#define ERROR -1
#define TRUE 1
#define FALSE 0
typedef int Status;
typedef int Boolean;
#define N 5000
/*
��Ŀ������
����һ������Ϊ21�����飬���δ���1��21��
����һ������Ϊ21�ĵ������������������е��������δ�������ÿ������У�
�����������Ϊ������(ѭ��)������ͷ��㿪ʼ��������17�����ɾ������������һ�������Ϊ�µ�ͷ��㣻
�ظ��������̣�ֱ����������ֻʣһ����㣬��ʾ�ý���д�������֡�
���룺
û���κ��������ݡ�
�����
���������Ŀ���������ʣ�µĽڵ��д�������֡�
�������룺
���������
��ʾ��
�벻Ҫֱ���������ˮ��ȥ�������ﲻ�������Լ���Ŀ�ģ�
�밴����ĿҪ�������⣬��������������ʱ����Ӧ�����硣
*/

typedef struct LNode
{
	int data;
	struct LNode* next;
}LNode,*LinkList;


Status choose()
{
	int i=1;
	LNode *p;
	LinkList L;
	LinkList tail;
	LNode *last,*current;
	int data=0;

	L=(LNode*)malloc(sizeof(LNode));
	if(L==NULL)
	{
		return ERROR;
	}


//	tail->next=L;
	L->data=i;
	L->next=L;//��β�ɻ�
	tail=L;

	while(i<21)
	{
		i++;
		p=(LNode*)malloc(sizeof(LNode));
		if(p==NULL)
		{
			return ERROR;
		}
		p->data=i;
		p->next=tail->next;
		tail->next=p;
		tail=p;		
	}


	i=1;
	last=tail;
	current=L;
	while(current!=last)
	{
		
		if(i==17)
		{
			last->next=current->next;
			p=current;
			
			current=current->next;
			free(p);
			i=1;
		}
		else
		{
			last=current;
			current=current->next;
			i++;
		}
		
	}
	data=current->data;
	printf("%d\n",data);
	free(current);
	return OK;
}


//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	return choose();
}

int main()
{
	choose();
	return OK;
}