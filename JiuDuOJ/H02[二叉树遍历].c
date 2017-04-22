#include<stdio.h>
#include<malloc.h>
//#include<stdlib.h>
//����״̬��
#define OK 0
#define ERROR -1
#define TRUE 1
#define FALSE 0
#define N 100
typedef char ElemType;
typedef int Status;
typedef int Boolean;

/*
��Ŀ������
��һ�����򣬶����û������һ����������ַ��������ݴ��ַ�������һ������������ָ�뷽ʽ�洢����
�������µ���������ַ�����
ABC##DE#G##F###
����"#"��ʾ���ǿո񣬿ո��ַ����������������˶������Ժ��ٶԶ������������������������������
���룺
�������1���ַ���������n������100��
�����
�����ж���������ݣ�����ÿ�����ݣ�
����������ַ���������������������������У�ÿ���ַ����涼��һ���ո�
ÿ��������ռһ�С�
�������룺
abc##de#g##f###
���������
c b e g d f a 

*/
//����������ڵ�
typedef struct BTNode
{
	ElemType data;
	struct BTNode *lchild,*rchild;
}BTNode,*BTree;

//����str�е��ַ���������������
Status createTreePreOrder(BTree*T,ElemType str[N],int *i)
{
	if(str[*i]!='\0')
	{
		if(str[*i]=='#')
		{
			*T=NULL;
			(*i)++;
			return OK;
		}
		else 
		{
			*T=(BTNode *)malloc(sizeof(BTNode));
			if(*T==NULL)
				return ERROR;
			(*T)->data=str[*i];
			(*i)++;	
			if( createTreePreOrder(&((*T)->lchild),str,i)==OK )
				if( createTreePreOrder(&((*T)->rchild),str,i)==OK )
					return OK;
		}
	}
	return OK;
}
//�������������
Status inOrderTraverse(BTree T,ElemType printStr[N],int *j)
{
	if(T->lchild!=NULL)
	{
		inOrderTraverse(T->lchild,printStr,j);
	}
	if(T!=NULL)
	{
		//printf("%c",T->data);
		printStr[*j]=T->data;
		(*j)++;	
	}
	if(T->rchild!=NULL)
	{
		inOrderTraverse(T->rchild,printStr,j);
	}
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	ElemType str[N];
	ElemType printStr[N];
	BTree T;
	int i=0;
	int j=0;
	int k=0;
	while(gets(str)!=NULL)
	{	
		if(strlen(str)>0)
		{
			i=0;
			createTreePreOrder(&T,str,&i);	
			inOrderTraverse(T,printStr,&j);
			for(k=0;k<j-1;k++)
			{
				printf("%c ",printStr[k]);
			}
			printf("%c\n",printStr[k]);
			str[0]='\0';
			j=0;
		}
		
	}

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