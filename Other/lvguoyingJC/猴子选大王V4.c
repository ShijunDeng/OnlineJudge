//猴子选大王:利用链表指出下一只猴子的坐标
#include<stdio.h>
#include<malloc.h>

#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0
#define STEP 3
typedef struct LNode
{
	int data;//存放猴子的下标信息
	struct LNode * next;
}LNode,*LinkList;


int choose(int number,int startIndex)
{ 

	LNode *head,*p,*q;//链表头结点
	int i;

	head=(LNode *)malloc(sizeof(LNode));

	if(NULL==head)
	{
		printf("malloc failed!\n");
		return ERROR;//内存申请失败
	}

	head->data=1;
	q=head;

	for(i=1;i<number;i++)//建立链表 并将下标信息存入
	{
		p=(LNode *)malloc(sizeof(LNode));
		p->data=i+1;//下标
		q->next=p;
		q=p;
	}

	p->next=head;//首位相连 成循环链表

	p=head;
//	q=head->next;

	i=1;
	while(i<startIndex)//找到起始位置
	{
		q=p;
		p=p->next;
		i++;
	}

	while(p!=q)
	{
		for(i=0;i<STEP-1;i++)//从1数到3
		{
			q=p;
			p=p->next;
		}
		//报3的猴子退出

		q->next=p->next;
		free(p);//释放p;
		p=q->next;
	}

	i=p->data;//暂存p的数据：最后一只猴子的编号
	free(p);//释放p;

	return i;
}

//业务逻辑:数据输入 调用求解函数 输出结果
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