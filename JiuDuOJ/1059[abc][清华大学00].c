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
��Ŀ1059��abc
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��3057�����2418
��Ŀ������
��a��b��c����0��9֮������֣�abc��bcc��������λ�������У�abc+bcc=532������������������a��b��c��ֵ��
���룺
��Ŀû���κ����롣
�����
���������������Ŀ������a��b��c��ֵ��
a��b��c֮���ÿո������
ÿ�����ռһ�С�
�������룺
���������
��Դ��
2000���廪��ѧ������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7783-1-1.html

*/
Status handleFunction()
{
	int a,b,c;
	for(a=3;a<=4;a++)
	{
		for(b=1;b<=2;b++)
		{
			for(c=1;c<=6;c+=5)
			{
				if(a*100+b*110+c*12==532)
				{
					printf("%d %d %d\n",a,b,c);
				}
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