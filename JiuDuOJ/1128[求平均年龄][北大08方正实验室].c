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
#define N 110

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1128����ƽ������
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��1919�����996
��Ŀ������
������ѧ��������������ÿ��ѧ�������䣨�����������������ѧ����ƽ�����䣬������С�������λ��
���룺
��һ����һ������n��1<= n <= 100������ʾѧ�������������n��ÿ����1��������ȡֵΪ15��25��
�����
�����ж���������ݣ�����ÿ�����ݣ�
���һ�У����а���һ����������ΪҪ���ƽ�����䣬������С�������λ��
�������룺
2
18
17
���������
17.50
��ʾ��
Ҫ�����������˫������С�����2λ���֣�����������������ʽ�� 
printf("%.2f", num);
��Դ��
2008�걱����ѧ����ʵ���Ҽ�����о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7851-1-1.html
*/
float avgAge(int ages[N],int nums)
{
	int i=0;
	float sum=0.0;
	while(i<nums)
	{
		sum+=ages[i++];
	}
	return (float)sum/nums;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	int i=0;
	int ages[N];
	while (scanf("%d",&n)!=EOF)
	{
		for(i=0;i<n;i++)
		{
			scanf("%d",ages+i);
		}

		printf("%.2f\n",avgAge(ages,n));
	}
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