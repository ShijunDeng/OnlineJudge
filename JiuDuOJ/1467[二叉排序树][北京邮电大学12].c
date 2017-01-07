#include<stdio.h>
//#include<string.h>
#include<malloc.h>
//#include<math.h>
//����״̬��
#define OK 1
#define ERROR 0

#define TRUE 1
#define FALSE 0

typedef int Status;
typedef int Boolean;

typedef int ElemType;

//#define M 1000
#define N 1000

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1467������������
ʱ�����ƣ�1 ���ڴ����ƣ�128 ���������⣺���ύ��2499�����1024
��Ŀ������
        ������������Ҳ��Ϊ�����������������һ�ſ�����Ҳ������һ�ž����������Եķǿն�������

        1. ���������ǿգ��������������нڵ�ؼ���ֵ�������ڸ��ڵ�Ĺؼ���ֵ��
        2. ���������ǿգ��������������нڵ�ؼ���ֵ����С�ڸ��ڵ�Ĺؼ���ֵ��
        3. ������������Ҳ��һ�Ŷ�����������

�������ڸ���N���ؼ���ֵ������ͬ�Ľڵ㣬Ҫ���㰴˳�����һ����ʼΪ�����Ķ����������У�ÿ�β����ɹ�������Ӧ�ĸ��׽ڵ�Ĺؼ���ֵ�����û�и��׽ڵ㣬�����-1��
���룺
�����������������ݣ�ÿ������������С�
��һ�У�һ������N��N<=100������ʾ������Ľڵ�����
�ڶ��У�N��������ͬ������������ʾҪ˳�����ڵ�Ĺؼ���ֵ����Щֵ������10^8��
�����
�����N�У�ÿ�β���ڵ�󣬸ýڵ��Ӧ�ĸ��׽ڵ�Ĺؼ���ֵ��
�������룺
5
2 5 1 3 4
���������
-1
2
2
5
3
��Դ��
2012�걱���ʵ��ѧ������о�����������
*/

typedef struct BSTNode
{
	ElemType data;
	struct BSTNode *lchild, *rchild;
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
			s=(BSTNode *)malloc(sizeof(BSTNode));
			s->data=data[i];
			s->lchild=NULL;
			s->rchild=NULL;
		
			if(parent==NULL)//�������ڵ�
			{
				*T=s;
				printf("-1\n");
			}
			else if(parent->data>data[i])
			{
				parent->lchild=s;
				printf("%d\n",parent->data);
			}
			else
			{
				parent->rchild=s;
				printf("%d\n",parent->data);
			}
		}
		i++;			
	}//end:while 1#

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
	BSTree T=NULL;
	int n=0;
	int i=0;
	while(scanf("%d",&n)!=EOF)
	{	
		for(i=0;i<n;i++)
		{
			scanf("%d",data+i);
		}
		createBST(&T,data,n);	
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