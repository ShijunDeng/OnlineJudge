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
��Ŀ1476��ƽ������
ʱ�����ƣ�1 ���ڴ����ƣ�128 ���������⣺���ύ��635�����416
��Ŀ������
����һ����n���ж����Ƿ���һ����Ϊ1����ȫƽ�������ӡ�Ҳ����˵���Ƿ����ĳ��k��k>1��ʹ��k*k�ܹ�����n��
���룺
ÿ��һ������n��1<n<10000��n=0��־���������
�����
����ÿһ��������������ڵ�����һ��������������в�Ϊ1����ȫƽ�������ӣ������Yes���������No����ע���Сд��
�������룺
15
12
0
���������
No
Yes
*/
Boolean judge(int n)
{
	int limit=(int)sqrt(n);
	int i=0;
	for(i=2;i<=limit;i++)
	{
		if(n%i==0&&n%(i*i)==0)
		{
			return TRUE;
		}
	}
	return FALSE;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	while(scanf("%d",&n),n)//while 1#
	{
		if(TRUE==judge(n))
		{
			printf("Yes\n");
		}
		else
		{
			printf("No\n");
		}
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