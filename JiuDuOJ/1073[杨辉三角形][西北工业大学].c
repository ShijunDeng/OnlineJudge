#include<stdio.h>
//����״̬��
#define OK 0
#define ERROR -1

#define TRUE 1
#define FALSE 0

typedef int Status;
typedef int Boolean;

#define N 10000

/*************************��Ŀ˵��********************/
/*
��Ŀ1073�����������
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��3289�����1425
��Ŀ������
����nֵ��ʹ�õݹ麯����������������и���λ���ϵ�ֵ��
���룺
һ�����ڵ���2��������n
�����
��Ŀ�����ж��鲻ͬ�Ĳ������ݣ�����ÿ���������ݣ�
����Ŀ��Ҫ�������Ӧ����n����������Ρ�
�������룺
6
���������
1 1
1 2 1
1 3 3 1
1 4 6 4 1
1 5 10 10 5 1
*/

//�ݹ����(i,j)λ���ϵ�������ǵ���ֵ
int handleFunction(int i,int j)
{
	if(j==0||(i+1)==j)
		return 1;
	return handleFunction(i-1,j-1)+handleFunction(i-1,j);
	 
}

Status yanghui(int n)
{
	int data[N];
	int i=0,j=0,k=0;
	data[0]=data[1]=1;

	for(i=2;i<=n;i++)
	{
		data[0]=data[i-1]=1;
		for(j=i-2;j>=1;j--)
		{
			data[j]=data[j]+data[j-1];
		}
		for(k=0;k<i-1;k++)
		{
			printf("%d ",data[k]);
		}
		printf("%d\n",data[k]);
	}

	return OK;

}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	int i=0,j=0;
	while(scanf("%d",&n)!=EOF)//while 1#
	{
		yanghui(n);
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