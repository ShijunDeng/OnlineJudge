#include<stdio.h>
//#include<string.h>
//#include<malloc.h>
#include<math.h>
//����״̬��
#define OK 0
#define ERROR -1

#define TRUE 1
#define FALSE 0

typedef int Status;
typedef int Boolean;

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
*/

Boolean isPrime(int x)
{
	int i=0;
	int limit=(int)sqrt(x);

	if(x<=1)
		return FALSE;

	for(i=2;i<=limit;i++)
	{
		if(x%i==0)
			return FALSE;
	}
	return TRUE;
}
Status handleFunction()
{
	int k=1000;
	int count=0;

	for(k=1000;k<=9999;k++)
	{
		if(TRUE==isPrime(k/1000)&&TRUE==isPrime(k/100)&&TRUE==isPrime(k/10)&&TRUE==isPrime(k))
		{
			count++;
			if(count<=5)
			{
				printf("%d ",k);
			}
			else
			{
				printf("%d\n",k);
				count=0;
			}
			
		}
	}
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	handleFunction();
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