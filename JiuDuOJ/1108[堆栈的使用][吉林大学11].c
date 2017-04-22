#include<stdio.h>
//#include<string.h>
//#include<malloc.h>
//#include<math.h>
//����״̬��
#define OK 0
#define ERROR -1

#define TRUE 1
#define FALSE 0

typedef int Status;
typedef int Boolean;

//#define M 1000
#define N 10100

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1108����ջ��ʹ��
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��5448�����1594
��Ŀ������
    ��ջ��һ�ֻ��������ݽṹ����ջ�������ֻ���������ʽ��push �� pop��Pushһ��ֵ�Ὣ��ѹ��ջ������ pop ��Ὣջ����ֵ������
	�������Ǿ�����֤һ�¶�ջ��ʹ�á�
���룺
     ����ÿ��������ݣ���һ����һ�������� n��0<n<=10000(n=0 ����)������� n �У�
	 ÿ�еĵ�һ���ַ�������'P������'O������'A���������'P�������滹�����һ����������ʾ���������ѹ���ջ��
	 �����'O������ʾ��ջ����ֵ pop �����������ջ��û��Ԫ��ʱ�����Ա��β�����
	 �����'A������ʾѯ�ʵ�ǰջ����ֵ�������ʱջΪ�գ������'E'����ջ��ʼΪ�ա�
�����
    ����ÿ��������ݣ��������е������ַ��������ջ���������е�'A�������������ʱջ����ֵ��ÿ��ռ��һ�У�
	�����ʱջΪ�գ������'E������ÿ�����������ɺ����һ�����С�
�������룺
3
A
P 5
A
4
P 3
P 6
O 
A
0
���������
E
5

3
*/
int data[N];
int length=0;
Status handleFunction(char c,int n)
{
	if(c=='P')
	{
		data[length++]=n;
	}
	else if(c=='O')
	{
		if(length>0)
		{
			length--;
		}
	}
	else if(c=='A')
	{
		if(length>0)
		{
			printf("%d\n",data[length-1]);
		}
		else
		{
			printf("E\n");
		}
	}
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0,x;
	int i=0;
	char c;
	while(scanf("%d",&n),n)//while 1#
	{
		length=0;
		for(i=0;i<n;i++)
		{
			scanf("%s",&c);
			if(c=='P')
			{
				scanf("%d",&x);
			}
			handleFunction(c,x);
		}
		printf("\n");
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