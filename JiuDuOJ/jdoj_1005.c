#include<stdio.h>
#include<stdlib.h>

#define TRUE 1
#define FALSE 0
#define NULL 0

typedef int BOOL;

typedef struct GradeNode
{
	float GE;
	float GI;
	float AVG;//(GE+GI)/2
}GradeNode,*PGrade;

typedef struct StuNode
{
	int ID;
	PGrade pG;
	int choices[3];
	struct StuNode *next;
}StuNode,*StuList;

typedef struct SchNode
{
	int ID;
	int P;//�ɽ��յ�����
	int V;//ʣ�������
	StuList stuList;//���յ�ѧ������Ϣ����
	GradeNode *LG;//��ǰ¼ȡѧ������ͷ�
}SchNode,*SchList;

//if a==b return TRUE
//else return false
BOOL EQ(GradeNode* a,GradeNode* b)
{
	if(a->AVG==b->AVG && a->GE==b->GE)
		return TRUE;
	return FALSE;
}

BOOL QT(GradeNode *a,GradeNode *b)
{
	if((a->AVG>b->AVG) ||(a->AVG==b->AVG && a->GE>b->GE))
		return TRUE;
	return FALSE;
}


int main()
{
	int N;//ѧ������
	int M;//ѧУ��
	int K;//ѧ����ѡ����
	int i=0;
	SchList schList;
	StuList stuList;
	StuNode *sp,*sq,*sL,*sr,*ss;
	GradeNode *pG;
	float GE,GI;
	int choices[3];
	while(scanf("%d %d %d",&N,&M,&K)!=EOF)
	{
		i=0;	
		
		schList=(SchNode *)malloc( sizeof(SchNode)*M );
		
		sq=sL=(StuNode*)malloc(sizeof(StuNode));
		sq->next=NULL;

		for(i=0;i<M;i++)//��ȡѧУ�������� ��ʼ��ѧУ����Ϣ
		{
			scanf("%d",&schList[i].V);
			schList[i].ID=i;
			schList[i].P=0;
			schList[i].stuList=(StuNode*)malloc(sizeof(StuNode));
			schList[i].stuList->next=NULL;
			schList[i].LG=(GradeNode*)malloc(sizeof(GradeNode));
			schList[i].LG->GE=100.0;
			schList[i].LG->GI=100.0;
			schList[i].LG->AVG=100.0;

		}
		
		for(i=0;i<N;i++)
		{
			scanf("%f %f %d %d %d",&GE,&GI,&choices[0],&choices[1],&choices[2]);
		
			//�ɼ��ڵ�
			pG=(GradeNode*)malloc(sizeof(GradeNode));
			pG->GE=GE;
			pG->GI=GI;
			pG->AVG=(GE+GI)/2;
			
			//ѧ����Ϣ�ڵ�
			sp=(StuNode*)malloc(sizeof(StuNode));
			sp->ID=i;
			sp->pG=pG;
			sp->choices[0]=choices[0];
			sp->choices[1]=choices[1];
			sp->choices[2]=choices[2];

			sq=sL;
			while(sq && sq->next && (QT(sp->pG,sq->next->pG)==FALSE))//�ǵݼ�˳�����
			{
				sq=sq->next;
			}
			sp->next=sq->next;
			sq->next=sp;
		}
		
		
		/* ---------test--------------------------------------
		sp=sL->next;
		while(sp)
		{
			printf("%d %.2f %.2f %.2f %d %d %d \n",sp->ID,sp->pG->GE,sp->pG->GI,sp->pG->AVG,sp->choices[0],sp->choices[1],sp->choices[2]);
			sp=sp->next;
		}
	
		----------------------------------------------------*/

		sq=sL->next;
		while(sq)
		{
			int loop=TRUE;
			for(i=0;i<3&&loop;i++)
			{
				if( (schList[sq->choices[i]].P<schList[sq->choices[i]].V) ||
					( (schList[sq->choices[i]].P>=schList[sq->choices[i]].P)&&EQ(schList[sq->choices[i]].LG,sq->pG)) )
				{
					schList[sq->choices[i]].P++;
					sr=schList[sq->choices[i]].stuList;
					while(sr && sr->next && sq->ID>sr->next->ID)
					{
						sr=sr->next;
					}

					if(i<3&&QT(schList[sq->choices[i]].LG,sq->pG))//���µ�ǰԺУ�����¼ȡ����
					{
						schList[sq->choices[i]].LG->GE=sq->pG->GE;
						schList[sq->choices[i]].LG->GI=sq->pG->GI;
						schList[sq->choices[i]].LG->AVG=sq->pG->AVG;
					}

					ss=sq->next;//������һ���������ѧ������Ϣ
					sq->next=sr->next;
					sr->next=sq;
					sq=ss;//�������ѧ���ڵ���Ϊ��һ��������Ľڵ�

					loop=FALSE;
				}//fi
			}//ed ..for
			if(sq&&loop==TRUE)
				sq=sq->next;//û�б�¼ȡ ֱ�ӽ�����һ��
		//	printf("=====\n");
		}//ed..while..sq

		for(i=0;i<M;i++)
		{
			
			if(schList[i].P==0)
			{
				printf("\n");
			}
			else
			{
				sp=schList[i].stuList->next;
				while(sp&&sp->next)
				{
					printf("%d ",sp->ID);
					sp=sp->next;
				}
				printf("%d\n",sp->ID);
			}
		}
		free(schList);
	}//1...while

	return 0;
}