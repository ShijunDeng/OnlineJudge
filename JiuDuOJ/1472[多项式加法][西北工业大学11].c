#include<stdio.h>
#include<string.h>
#include<malloc.h>
#include<math.h>
//����״̬��
#define OK 1
#define ERROR 0

#define TRUE 1
#define FALSE 0

typedef int Status;
typedef int Boolean;

#define N 2500
#define OFFSET 1000

/*************************��Ŀ˵��********************/
/*
��Ŀ1472������������ʽ�ĺ�
ʱ�����ƣ�1 ���ڴ����ƣ�128 ���������⣺���ύ��1356�����247
��Ŀ������
������������ʽ���������ǵĺ͡�
ÿ������ʽ�����ɶ�������ʾ��ÿ�������У���һ��������ʾϵ������0�����ڶ���������ʾ����Ĵ�����
����3 3 5 -2 1 4 0��ʾ3x^5 - 2 * x + 4���е�һ��3��ʾ�ö���ʽ�����������Ա�ʾ��
���룺
����Ϊ���У��ֱ��ʾ��������ʽ����ʾÿ��������԰��մ�����С���������(��������ֵС��1000��ϵ������ֵС��10000)
�����
���ս���˳�������ʾ�Ͷ���ʽ�������ԣ�ϵ��Ϊ0�������Բ���������������ɿո�ָ������һ�������Ժ���ӿո�
�������룺
3 3 5 -2 1 4 0
4 2 3 -1 2 1 1 3 0
���������
3 5 2 3 -1 2 -1 1 7 0
��Դ��
2011��������ҵ��ѧ������о�����������
*/


int A[N],B[N],C[N];
//����ʽ�ӷ�

Status add( )
{
	int i=0,count=0;
	for(i=0;i<N;i++)
	{
		C[i]=A[i]+B[i];
	}

	for(i=N-1;i>=0;i--)
	{
		if(C[i]!=0)
			count++;
	}
	for(i=N-1;i>=0&&count>1;i--)
	{
		if(C[i]!=0)
		{
			printf("%d %d ",C[i],i-OFFSET);
			count--;
		}
	}

	while(i>=0)
	{
		if(C[i]!=0)
		{
			printf("%d %d\n",C[i],i-OFFSET);
		}
		i--;
	}

	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n1=0,n2=0;
	int i=0,j=0;
	int p=0,e=0;
	while(scanf("%d",&n1)!=EOF)//while 1#
	{
		for(i=0;i<N;i++)
		{
			A[i]=B[i]=C[i]=0;
		}

		for(i=0;i<n1;i++)
		{
			scanf("%d %d",&p,&e);
			A[e+OFFSET]=p;
		}

		scanf("%d",&n2);

		for(i=0;i<n2;i++)
		{
			scanf("%d %d",&p,&e);
			B[e+OFFSET]=p;
		}

		add();
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