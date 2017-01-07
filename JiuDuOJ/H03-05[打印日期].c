#include<stdio.h>
#include<malloc.h>
#include<stdlib.h>
//����״̬��
#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0
typedef int ElemType;
typedef int Status;
typedef int Boolean;

/*
��Ŀ1186����ӡ����
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��4634�����1633
��Ŀ������
�������m��һ���еĵ�n�죬�����n���Ǽ��¼��š�
���룺
���������������y(1<=y<=3000)��n(1<=n<=366)��
�����
�����ж���������ݣ�����ÿ�����ݣ�
�� yyyy-mm-dd�ĸ�ʽ�������ж�Ӧ�����ڴ�ӡ������
�������룺
2000 3
2000 31
2000 40
2000 60
2000 61
2001 60
���������
2000-01-03
2000-01-31
2000-02-09
2000-02-29
2000-03-01
2001-03-01

*/


//�ж����year�Ƿ�������
Boolean isLeapYear(int year)
{
	if( (year%100!=0&&year%4==0) || year%400==0)
		return TRUE;
	return FALSE;
}

Status covert(int year,int days)
{
	int monthDay[2][12]={  {31,28,31,30,31,30,31,31,30,31,30,31},
						{31,29,31,30,31,30,31,31,30,31,30,31}};
	int N=isLeapYear(year);
	int month=1,day=0;

	while(days>0)
	{
		if(days-monthDay[N][month-1]>0)
		{
			days-=monthDay[N][month-1];
			month++;
		}
		else
		{
			day=days;
			break;
		}
	}

	printf("%04d-%02d-%02d\n",year,month,day);
	return OK;
}
//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int year=0;
	int days=0;
	while(scanf("%d %d",&year,&days) != EOF)
	{
		covert(year,days);
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