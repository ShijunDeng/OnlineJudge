#include<stdio.h>
#include<malloc.h>
#include<math.h>
#include<stdlib.h>
//#include<string.h>
//����״̬��
#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0
#define N 200
typedef int ElemType;
typedef int Status;
typedef int Boolean;
int count=0;
/*
��Ŀ1201������������
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��3613�����1540
��Ŀ������
    ����һϵ������������������������������ǰ�����򣬺��������
���룺
    �����һ�а���һ������n(1<=n<=100)��
    ��������һ�а���n��������
�����
    �����ж���������ݣ�����ÿ�����ݣ�����Ŀ�������ݽ���һ�����������������Զ�������������ǰ������ͺ��������
    ÿ�ֱ���������һ�С�ÿ�����һ������֮����һ���ո�
�������룺
6
1 6 5 9 8 8
���������
1 6 5 9 8 
1 5 6 8 9 
5 8 9 6 1 
��ʾ��
�����п������ظ�Ԫ�أ���������Ķ����������������ظ�Ԫ�ز��������

*/
typedef struct BSTNode
{
	ElemType data;
	struct BSTNode *lchild,*rchild;
}BSTNode,*BSTree;

//�ڶ���������T��Ѱ��ֵΪkey�Ľڵ� �����ҳɹ� parentָ��ýڵ� ������TRUE 
//����parentָ�����·���ϵ����һ���ڵ� ����FALSE
Status searchBST(BSTree T,ElemType key,BSTNode *f,BSTNode **parent)
{		//printf("**%d ",key);
	if(T==NULL)
	{
		*parent=f;
		return FALSE;//���Ҳ��ɹ�
	}
	else if(T->data==key)
	{
	
		return TRUE;//���ҳɹ�
	}
	else if(T->data>key)
	{
		return searchBST(T->lchild,key,T,parent);//���������ϼ�������
	}
	else
	{
		return searchBST(T->rchild,key,T,parent);//���������ϼ�������
	}
}

//��data�е����ݽ�������������
Status createBST(BSTree *T,ElemType data[N],int n)
{

	int i=0;
	BSTNode * parent=NULL;
	BSTNode *s=NULL;
	while(i<n)//while 1#
	{
		if(searchBST(*T,data[i],NULL,&parent)==FALSE)//����ʧ��
		{
			count++;
			s=(BSTNode *)malloc(sizeof(BSTNode));
			s->data=data[i];
			s->lchild=NULL;
			s->rchild=NULL;
		
			if(parent==NULL)//�������ڵ�
			{
				*T=s;
			}
			else if(parent->data>data[i])
			{
				parent->lchild=s;
			}
			else
			{
				parent->rchild=s;
			}
		}
		i++;			
	}//end:while 1#

	return OK;
}
//�������������
Status preOrderTraverse(BSTree T,ElemType printStr[N],int *i)
{
	if(T!=NULL)
	{
		//printf("%c",T->data);
		printStr[*i]=T->data;
		(*i)++;
	}
	if(T->lchild!=NULL)
	{
		preOrderTraverse(T->lchild,printStr,i);
	}
	if(T->rchild!=NULL)
	{
		preOrderTraverse(T->rchild,printStr,i);
	}
	return OK;
}
//�������������
Status inOrderTraverse(BSTree T,ElemType printStr[N],int *i)
{
	if(T->lchild!=NULL)
	{
		inOrderTraverse(T->lchild,printStr,i);
	}
	if(T!=NULL)
	{
		//printf("%c",T->data);
		printStr[*i]=T->data;
		(*i)++;
	}
	if(T->rchild!=NULL)
	{
		inOrderTraverse(T->rchild,printStr,i);
	}
	return OK;
}

//�������������
Status postOrderTraverse(BSTree T,ElemType printStr[N],int *i)
{
	if(T->lchild!=NULL)
	{
		postOrderTraverse(T->lchild,printStr,i);
	}	
	if(T->rchild!=NULL)
	{
		postOrderTraverse(T->rchild,printStr,i);
	}
	if(T!=NULL)
	{
		//printf("%c",T->data);
		printStr[*i]=T->data;
		(*i)++;
	}
	return OK;
}
void DestroyBiTree(BSTree *T)
 { /* ��ʼ����: ������T���ڡ��������: ���ٶ�����T */
   if(*T) /* �ǿ��� */
   {
     if((*T)->lchild) /* ������ */
       DestroyBiTree(&(*T)->lchild); /* ������������ */
     if((*T)->rchild) /* ���Һ��� */
       DestroyBiTree(&(*T)->rchild); /* �����Һ������� */
     free(*T); /* �ͷŸ���� */
     *T=NULL; /* ��ָ�븳0 */
   }
 }
//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	ElemType data[N];
	ElemType printStr[N];
	BSTree T=NULL;
	int n=0;
	int i=0;
	int k=0;
	int i1,i2,i3;
	while(scanf("%d",&n)!=EOF)
	{	
		count=0;
		i1=i2=i3=0;
		for(i=0;i<n;i++)
		{
			scanf("%d",data+i);
		}
		createBST(&T,data,n);	
		preOrderTraverse(T,printStr,&i1);
		for(k=0;k<count;k++)
		{
			printf("%d ",printStr[k]);
		}
		printf("\n");

		inOrderTraverse(T,printStr,&i2);
		for(k=0;k<count;k++)
		{
			printf("%d ",printStr[k]);
		}
		printf("\n");

		postOrderTraverse(T,printStr,&i3);
		for(k=0;k<count;k++)
		{
			printf("%d ",printStr[k]);
		}
		printf("\n");

		DestroyBiTree(&T);
		
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