#include<stdio.h>
#include<string.h>
//#include<malloc.h>
//#include<math.h>
//����״̬��
#define OK 0
#define ERROR -1

#define TRUE 1
#define FALSE 0

typedef int Status;
typedef int Boolean;

typedef int ElemType;

//#define M 1000
#define N 100

const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1112�����ص���
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��2552�����1221
��Ŀ������
ĳ��Ϊ�˷����й��ĵ���Ϯ����������һ�ֵ�������ϵͳ���������ֵ�������ϵͳ��һ��ȱ�ݣ���Ȼ���ĵ�һ���ڵ��ܹ���������ĸ߶ȣ�
�����Ժ�ÿһ���ڵ������ܸ���ǰһ���ĸ߶ȡ�ĳ�죬�״ﲶ׽���й��ĵ�����Ϯ�����۲⵽�������η����ĸ߶ȣ����������ϵͳ���
�����ض��ٵ�����������Ϯ����ʱ�����밴��Ϯ����Ϯ����ʱ��˳�򣬲����������غ���ĵ�����������ǰ��ĵ����� 
���룺
ÿ�����������У�
��һ�У������״ﲶ׽���ĵй�����������k��k<=25����
�ڶ��У�����k������������ʾkö�����ĸ߶ȣ�����Ϯ������Ϯ��ʱ��˳��������Կո�ָ���
�����
ÿ�����ֻ��һ�У�����һ����������ʾ��������ض���ö������
�������룺
8
300 207 155 300 299 170 158 65
���������
6
��Դ��
2007�걱����ѧ������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7835-1-1.htm


*/
int data[N];//�����ĸ߶�����
int count=0;//������Ŀ

//��˷�����
int trySelect(int current,int last,int selectedNum)
{
	int max1=0;//��ǰ�ڵ㱻ѡ��ﵽ�����ֵ
	int max2=0;//��ѡ��ǰ�ڵ�Ĵﵽ�����ֵ
	if(current==count-1)//���������һ���ڵ�
	{
		if(data[current]<=data[last])
		{
			selectedNum++;
		}	
		return selectedNum;
	}

	if(data[current]<=data[last])
	{
		max1=trySelect(current+1,current,selectedNum+1);//��ǰ�ڵ㱻ѡ��ﵽ�����ֵ	
		max2=trySelect(current+1,last,selectedNum);//��ѡ��ǰ�ڵ�Ĵﵽ�����ֵ
		return max1>max2?max1:max2;
	}
	else
	{
		max2=trySelect(current+1,last,selectedNum);//��ѡ��ǰ�ڵ�Ĵﵽ�����ֵ
		return max2;
	}
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int i=0,j=0;
	while(scanf("%d",&count)!=EOF)//while 1#
	{
		data[N-1]=MAXINT;
		for(i=0;i<count;i++)
		{
			scanf("%d",data+i);
		}
		printf("%d\n",trySelect(0,N-1,0));
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