#include<stdio.h>
//#include<string.h>
//#include<malloc.h>
//#include<math.h>
//����״̬��
#define OK 1
#define ERROR 0

#define TRUE 1
#define FALSE 0

typedef int Status;
typedef int Boolean;

//#define M 1000
#define N 1000

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*


*/
int judge(int money,int value)
{
	int total=0;
	int i=0;
	int limit=0;
	if(money==0||value==1)
	{
		return 1;
	}

	limit=money/value;
	if(value==5)
	{
		while(i<=limit)
		{
			total+=judge(money-i*5,2);
			i++;
		}

	}
	else if(value==2)
	{
		while(i<=limit)
		{
			total+=judge(money-i*2,1);
			i++;
		}
	}
	
	return total;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	while(scanf("%d",&n)!=EOF)//while 1#
	{
		printf("%d\n",judge(n,5));
		scanf("%d",&n);
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