#include<stdio.h>
#include<malloc.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
//����״̬��
#define OK 0
#define ERROR -1
#define TRUE 1
#define FALSE 0
//#define M 256
#define N 2048
//#define MININT -32768
typedef char ElemType;
typedef int Status;
typedef int Boolean;

/*
��Ŀ������
����һ�����Ȳ�����1000���ַ������ж����ǲ��ǻ���(˳�����������ͬ)�ġ�
���룺
�������һ���ַ������䳤�Ȳ�����1000��
�����
�����ж���������ݣ�����ÿ�����ݣ�����ǻ����ַ��������"Yes!"���������"No!"��
�������룺
hellolleh
helloworld
���������
Yes!
No!

*/


Boolean check(ElemType str[N])
{

	int high=strlen(str)-1;
	int low=0;
	while(low<high)
	{
		if(str[low]!=str[high])
		{
			return FALSE;
		}
		low++;
		high--;
	}
	return TRUE;
}



//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	ElemType str[N];

	while(scanf("%s",str)!=EOF)
	{

		if(TRUE==check(str))
			printf("Yes!\n");
		else
			printf("No!\n");
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