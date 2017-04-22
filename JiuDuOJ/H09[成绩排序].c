#include<stdio.h>
//#include<string.h>
//����״̬��
#define OK 0
#define ERROR -1
#define TRUE 1
#define FALSE 0
typedef int Status;
typedef int Boolean;
#define N 1000
/*
��Ŀ1196���ɼ�����
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��3806�����1263
��Ŀ������
��һά����洢ѧ�źͳɼ���Ȼ�󣬰��ɼ����������
���룺
�����һ�а���һ������N(1<=N<=100)������ѧ���ĸ�����
��������N��ÿ�а�����������p��q���ֱ����ÿ��ѧ����ѧ�źͳɼ���
�����
����ѧ���ĳɼ���С����������򣬲���������ѧ����Ϣ��ӡ������
���ѧ���ĳɼ���ͬ������ѧ�ŵĴ�С���д�С��������
�������룺
3
1 90
2 87
3 92
���������
2 87
1 90
3 92
*/

typedef struct Stu
{
	int id;
	int score;
}Stu;

Status sort(Stu stu[N],int n)
{
	int i=0,j=0;
	Boolean finished=FALSE;
	Stu temp;

	for(i=0;i<n&&finished==FALSE;i++)
	{
		finished=TRUE;
		for(j=0;j<n-i-1;j++)
		{
			if(stu[j].score>stu[j+1].score)
			{
				finished=FALSE;
				temp=stu[j];
				stu[j]=stu[j+1];
				stu[j+1]=temp;

			}
			else if(stu[j].score==stu[j+1].score&&stu[j].id>stu[j+1].id)
			{
				finished=FALSE;
				temp=stu[j];
				stu[j]=stu[j+1];
				stu[j+1]=temp;
			}
		}
	}

	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{

	int n=0;
	Stu stu[N];
	int i=0;
	while(scanf("%d",&n)!=EOF)
	{
		for(i=0;i<n;i++)
		{
			scanf("%d %d",&stu[i].id,&stu[i].score);
		}
		sort(stu,n);
		for(i=0;i<n;i++)
		{
			printf("%d %d\n",stu[i].id,stu[i].score);
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