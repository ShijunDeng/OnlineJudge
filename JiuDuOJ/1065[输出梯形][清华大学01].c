#include<stdio.h>

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
��Ŀ1065���������
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��4359�����2377
��Ŀ������
����һ���߶�h�����һ����Ϊh���ϵױ�Ϊh�����Ρ�
���룺
һ������h(1<=h<=1000)��
�����
h����Ӧ�����Ρ�
�������룺
4
���������
      ****
    ******
  ********
**********
��ʾ��
����ÿ�ж����Ҷ���ģ�sample���ǽ�����ʾ����
��Դ��
2001���廪��ѧ������о�����������(��II��)
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7789-1-1.html
*/
Status handleFunction(int n)
{
	int space=2*n-2;//(n-1)*2
	int limit=3*n-2;
	int i=0,j=0;
	for(i=0;i<n;i++)
	{
		for(j=0;j<limit;j++)
		{
			if(j<space)
			{
				printf(" ");
			}
			else
			{
				printf("*");
			}
		}
		printf("\n");
		space-=2;
	}
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	while(scanf("%d",&n)!=EOF)
		handleFunction(n);
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