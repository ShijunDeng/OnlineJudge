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

/*************************��Ŀ˵��********************/
/*
��Ŀ1132����7�޹ص���
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��1444�����929
��Ŀ������
һ��������,������ܱ�7����,��������ʮ���Ʊ�ʾ����ĳ��λ���ϵ�����Ϊ7,
�����Ϊ��7��ص���.��������С�ڵ���n(n<100)����7�޹ص���������ƽ���͡�
���룺
���������ж��顣����ÿ�����԰�������Ϊһ��,������n,(n<100)
�����
����ÿ�����԰������һ�У����С�ڵ���n����7�޹ص���������ƽ���͡�
�������룺
21
���������
2336
��Դ��
2008�걱����ѧ�����������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7855-1-1.html
*/
//n����7��ص��� ����TRUE ���򷵻�FALSE
Boolean judge(int n)
{
	if(n%7==0)
		return TRUE;
	while(n>0)
	{
		if(n%10==7)
		{
			return TRUE;
		}
		n=n/10;
	}
	return FALSE;
}
int handleFunction(int n)
{
	int i=1;
	int sum=0;
	while(i<=n)
	{
		if(judge(i)==FALSE)
		{
			sum=sum+i*i;
		}
		i++;
	}
	return sum;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	while(scanf("%d",&n)!=EOF)//while 1#
	{
		printf("%d\n",handleFunction(n));
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