#include<stdio.h>

//����״̬��
#define OK 1
#define ERROR 0

#define TRUE 1
#define FALSE 0

typedef int Status;
typedef int Boolean;

//#define M 1000
#define N 10

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1058���������
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��7764�����2760
��Ŀ������
��������4���ַ�(�磺abcd)�� �����������(�磺dcba)
���룺
��Ŀ���ܰ�������������ÿ������ռһ�У�����4��������ַ���
�����
����ÿ������,�����һ�з������ַ�����
����ɼ�������
�������룺
Upin
cvYj
WJpw
cXOA
���������
nipU
jYvc
wpJW
AOXc
��Դ��
2000���廪��ѧ������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7782-1-1.html
*/
//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	char str[N];
	int i=0;
	while(scanf("%s",str)!=EOF)//while 1#
	{
		for(i=3;i>=0;i--)
		{
			printf("%c",str[i]);
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