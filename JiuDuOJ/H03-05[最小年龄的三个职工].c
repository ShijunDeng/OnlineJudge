#include<stdio.h>
#include<malloc.h>
#include<stdlib.h>
#include<string.h>
//����״̬��
#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0

#define N 30

typedef int ElemType;
typedef int Status;
typedef int Boolean;

/*
��Ŀ������
ְ����ְ���ţ�����������.����n��ְ������Ϣ���ҳ�3��������С��ְ����ӡ������
���룺
�����һ�а���1������N��1<=N<=30�������������ݵĸ�����
��������N����N��ְ������Ϣ��
����ְ����(����)�� ����(�ַ��������Ȳ�����10)�� ����(1<=age<=100)��
�����
�����ж���������ݣ�����ÿ�����ݣ�
����������ΪN��3�Ľ�Сֵ���ֱ�Ϊ������С��ְ������Ϣ��
�ؼ���˳������>����>��������С����
�������룺
5
501 Jack 6
102 Nathon 100
599 Lily 79
923 Lucy 15
814 Mickle 65
���������
501 Jack 6
923 Lucy 15
814 Mickle 65

*/


//�����ʾְ����Ϣ�Ľڵ�
typedef struct employee
{
	int id;
	char name[10];
	int age;
}employee,Employees[N];

int comp(const void *a,const void *b)
{
	int dage= (*(employee *)a).age-(*(employee *)b).age;	
	int did=(*(employee *)a).id-(*(employee *)b).id;
	int dname=strcmp((*(employee *)a).name,(*(employee *)b).name);

	if(dage==0)
	{
		if(did==0)
		{
			return dname;
		}
		else
		{
			return did;
		}
	}
	else
	{
		return dage;
	}
}



//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{

	int i=0;
	Employees ems;
	int id,age;
	char name[10];
	int n=0;

	while(scanf("%d",&n) != EOF)
	{
		i=0;
		while(i<n)
		{
			scanf("%d %s %d",&id,name,&age);
			ems[i].id=id;
			strcpy(ems[i].name,name);
			ems[i].age=age;
			i++;
		}

		qsort(ems,n,sizeof(employee),comp);

		for(i=0;i<3&&i<n;i++)
		{
			printf("%d %s %d\n",ems[i].id,ems[i].name,ems[i].age);
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