#include<stdio.h>
#include<malloc.h>
//#include<stdlib.h>
//����״̬��
#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0

typedef int Status;
typedef int Boolean;

//�ж��Ƿ���������
Boolean judge(int number)
{

	int num=number*number;
	if((num%10==number||num%100==number||num%1000==number)&&number>1&&number<100)
		return TRUE;
	return FALSE;

}


//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int number=0;
	while(scanf("%d",&number)!=EOF)
	{
		if(TRUE==judge(number))
		{
			printf("Yes!\n");
		}
		else
		{
			printf("No!\n");
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