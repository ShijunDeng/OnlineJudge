#include<stdio.h>
#include<math.h>
typedef int Status;
typedef int Boolean;
#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0

//�ж�x�Ƿ���һ������
Boolean prime(int x)
{
	int limit=(int)sqrt(x);
	int i=2;
	if(x<=1)
	{
		return FALSE;
	}
	if(x==2)
	{
		return TRUE;
	}

	while(i<=limit)
	{
		if(x%i==0)
		{
			return FALSE;
		}
		i++;
	}
	return TRUE;
}
//�ҳ�m���ڵ������������
Status lprime(int m)
{
	int i=m;
	while(i>=4)
	{
		if(TRUE==prime(i)&&TRUE==prime(i-2))
		{
			printf("%d %d\n",i,i-2);
			return OK;
		}
		i--;
	}
	return OK;
}

//ҵ������
Status service()
{
	int m=0;

	while(scanf("%d",&m)!=EOF)
	{
		lprime(m);
	}
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