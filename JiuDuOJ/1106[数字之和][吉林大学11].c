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
��Ŀ1106������֮��
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��2250�����1528
��Ŀ������
���ڸ����������� n��������ʮ������ʽ������λ������֮�ͣ���������ƽ���ĸ�λ����֮�͡�
���룺
ÿ���������ݰ���һ��������n(0<n<40000)�����n=0 ��ʾ��������������ü��㡣
�����
����ÿ���������ݣ��������λ����֮�ͣ��Լ���ƽ��ֵ������֮�ͣ������һ���У�֮����һ���ո�ָ�������ĩ��Ҫ�пո�
�������룺
4
12
97
39999
0
���������
4 7
3 9
16 22
39 36
��Դ��
2011�꼪�ִ�ѧ������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7829-1-1.html

*/
int sumE(long n)
{
	int sum=0;
	while(n>0)
	{
		sum+=(n%10);
		n/=10;
	}
	return sum;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;

	while(scanf("%d",&n),n)//while 1#
	{
		printf("%d %d\n",sumE(n),sumE(n*n));
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