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

#define M 120
#define N 1010

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1152���������
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��906�����472
��Ŀ������
    ��������ʵ���Ҿ����л��Ҫ�����򣬵���ÿ�ν�����ı������ѵ��ܶ����ΪCԪ����N�ֲ˿��Ե㣬������ʱ��ĵ�ˣ�
	����ʵ���Ҷ���ÿ�ֲ�i����һ�����������۷�������ʾ����˿ɿڳ̶ȣ���ΪVi��ÿ�ֲ˵ļ۸�ΪPi, �����ѡ����ֲˣ�
	ʹ���ڱ�����ȷ�Χ����ʹ�㵽�Ĳ˵������۷������
    ע�⣺������ҪӪ����������ÿ�ֲ�ֻ�ܵ�һ�Ρ�
���룺
    ����ĵ�һ������������C��1 <= C <= 1000����N��1 <= N <= 100����C�����ܹ��ܹ������Ķ�ȣ�N>�����ܵ�˵���Ŀ��
	��������N��ÿ�а���������1��100֮�䣨����1��100���ĵ��������ֱ��ʾ�˵�>�۸�Ͳ˵����۷�����
�����
    ���ֻ����һ�У���һ��ֻ����һ����������ʾ�ڱ�����ȷ�Χ�ڣ�����Ĳ˵õ���������۷�����
�������룺
90 4
20 25
30 20
40 50
10 18
40 2
25 30
10 8
���������
95
38
��Դ��
2010�걱����ѧ������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7875-1-1.html


*/
Status handleFunction(int data[M][2],int num,int limit)
{
	int i=0,j=0;
	int f[N];
	for(i=0;i<N;i++)
	{
		f[i]=0;
	}

	for(i=0;i<num;i++)
	{
		for(j=limit;j>=data[i][0];j--)
		{
			if(f[j-data[i][0]]+data[i][1]>f[j])
			{
				f[j]=f[j-data[i][0]]+data[i][1];
			}
		}
	}

	printf("%d\n",f[limit]);
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int i=0,j=0;
	int data[M][2];
	int num;
	int limit;
	while(scanf("%d %d",&limit,&num)!=EOF)//while 1#
	{
		for(i=0;i<num;i++)
		{
			scanf("%d %d",*(data+i),*(data+i)+1);
		}
		handleFunction(data,num,limit);
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