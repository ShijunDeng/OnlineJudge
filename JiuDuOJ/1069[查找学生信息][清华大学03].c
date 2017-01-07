#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include <string.h>

typedef int Status;
typedef int Boolean;

#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0

#define IDLENGTH 50
#define NAMELENGTH 100
#define SEXLENGTH 3
/************************************��Ŀ����*****************************
��Ŀ1069������ѧ����Ϣ
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��9978�����2658
��Ŀ������
 ����N��ѧ������Ϣ��Ȼ����в�ѯ��
���룺
 ����ĵ�һ��ΪN����ѧ���ĸ���(N<=1000)
��������N�а���N��ѧ������Ϣ����Ϣ��ʽ���£�
01 � �� 21
02 ���� �� 23
03 �ž� �� 19
04 ���� Ů 19
Ȼ������һ��M(M<=10000),����������M�У�����M�β�ѯ��ÿ������һ��ѧ�ţ���ʽ���£�
02
03
01
04
�����
 ���M�У�ÿ�а���һ����Ӧ�ڲ�ѯ��ѧ������Ϣ��
���û�ж�Ӧ��ѧ����Ϣ���������No Answer!��
�������룺
4
01 � �� 21
02 ���� �� 23
03 �ž� �� 19
04 ���� Ů 19
5
02
03
01
04
03
���������
02 ���� �� 23
03 �ž� �� 19
01 � �� 21
04 ���� Ů 19
03 �ž� �� 19
��Դ��
2003���廪��ѧ������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7793-1-1.html

**************************************************************************/
typedef struct StuNode
{
    char ID[IDLENGTH];
    char name[NAMELENGTH];
    char sex[SEXLENGTH];
    int age;
    struct StuNode *next;
}StuNode,*StuList;

Status initList(StuList* L)
{
    *L=(StuNode*)malloc(sizeof(StuNode));
    if(*L==NULL)
    {
        printf("Malloc failed!\n");
        return ERROR;
    }
    (*L)->next=NULL;
    return OK;
}
Status destroyList(StuList* L)
{
    StuNode* p=*L;
    while((*L)!=NULL)
    {
        p=*L;
        *L=(*L)->next;
        free(p);
    }
    *L=NULL;
    return OK;
}
Status insert(StuList *L,StuNode data)
{
    StuNode *p=(StuNode*)malloc(sizeof(StuNode));
    if(p==NULL)
    {
        printf("Malloc failed!\n");
        return ERROR;
    }

    strcpy(p->ID,data.ID);
    strcpy(p->name,data.name);
    strcpy(p->sex,data.sex);
    p->age=data.age;

    p->next=(*L)->next;
    (*L)->next=p;

    return OK;
}

StuNode * search(StuList L,char ID[IDLENGTH])
{
    StuNode *p=L->next;

    while(p!=NULL)
    {
        if(strcmp(ID,p->ID)!=0)
        {
            p=p->next;
        }
        else
        {
            return p;
        }
    }
    return p;
}

Status service()
{
    int m=0,n=0;
    int i=0;
    StuNode stu;
    StuNode *p=NULL;
    StuList L;
    initList(&L);
    char ID[IDLENGTH];
    scanf("%d",&n);
    for(i=0;i<n;i++)
    {
        scanf("%s %s %s %d",stu.ID,stu.name,stu.sex,&stu.age);
        insert(&L,stu);
    }

    scanf("%d",&m);
    for(i=0;i<m;i++)
    {
        scanf("%s",ID);
        p=search(L,ID);
        if(p!=NULL)
        {
            printf("%s %s %s %d\n",p->ID,p->name,p->sex,p->age);
        }
        else
        {
            printf("No Answer!\n");
        }
    }
    destroyList(&L);
    return OK;
}
int main()
{
    if(ERROR==service())
    {
        printf("ERROR!\n");
        return ERROR;
    }
    return OK;

}
