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
#define N 1000

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1064��������
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��3123�����2331
��Ŀ������
��N��һ����λ��������9��ǡ�����䷴���������磺1234�ķ�������4321��
��N��ֵ
���룺
�������κ���������
�����
�����ĿҪ�����λ�����������ж��飬��ÿ����֮���Իس�����
�������룺
���������
��Դ��
2001���廪��ѧ������о�����������(��I��)
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7788-1-1.html

*/
Status handleFunction()
{
	int i=1111;
	for(i=1000;i<=9999;i++)
	{
		if((i%10*1000+i%100/10*100+i%1000/100*10+i/1000)==i*9)
		{
			printf("%d\n",i);
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