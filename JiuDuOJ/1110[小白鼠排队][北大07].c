#include<stdio.h>
//#include<string.h>
//#include<malloc.h>
#include<math.h>
//����״̬��
#define OK 1
#define ERROR 0

#define TRUE 1
#define FALSE 0

typedef int Status;
typedef int Boolean;

typedef int ElemType;

#define M 200
#define N 20

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1110��С�����Ŷ�
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��1526�����926
��Ŀ������
NֻС����(1 <= N <= 100)��ÿֻ��ͷ�ϴ���һ������ɫ��ñ�ӡ����ڳƳ�ÿֻ�����������Ҫ���հ��������Ӵ�С��˳���������ͷ��ñ�ӵ���ɫ��
ñ�ӵ���ɫ��"red"��"blue"���ַ�������ʾ����ͬ��С������Դ���ͬ��ɫ��ñ�ӡ������������������ʾ��
���룺
�స�����룬ÿ�������������һ��Ϊһ������N����ʾС�������Ŀ��
������N�У�ÿ����һֻ�������Ϣ����һ��Ϊ������100������������ʾ��������������ڶ���Ϊ�ַ�������ʾ�����ñ����ɫ���ַ������Ȳ�����10���ַ���
ע�⣺���������������ͬ��
�����
ÿ���������հ���������Ӵ�С��˳����������ñ����ɫ��
�������룺
3
30 red
50 blue
40 green
���������
blue
green
red
��Դ��
2007�걱����ѧ������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�

*/
typedef struct Mouse
{
	int weight;
	char color[N];
}Mouse;
Mouse mice[M];
int count=0;
int comp(const void *A,const void *B)
{
	return (*((Mouse*)B)).weight-(*((Mouse*)A)).weight;
}

Status sortM()
{
	int i=0;
	qsort(mice,count,sizeof(Mouse),comp);
	for(i=0;i<count;i++)
	{
		printf("%s\n",mice[i].color);
	}
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int i=0;
	while(scanf("%d",&count)!=EOF)//while 1#
	{
		for(i=0;i<count;i++)
		{
			scanf("%d%s",&(mice[i].weight),&(mice[i].color));
		}
		sortM();
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