#include<stdio.h>
#include<math.h>
//����״̬��
#define OK 1
#define ERROR 0

#define TRUE 1
#define FALSE 0

typedef int Status;
typedef int Boolean;

typedef int ElemType;

#define N 10005

/*************************��Ŀ˵��********************/
/*
��Ŀ1167����������
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��4625�����1483
��Ŀ������
����һ�������ֵ,�������ֵ��С���������Ĵ���
���룺
�����ж������ݡ�
ÿ������ĵ�һ����Ϊ����ĳ���n(1<=n<=10000),�������Ϊ�����е�ֵ,�Կո�ָ
�����
�������ֵ����С�������еĴ���(���һ�����ֺ���û�пո�)��
�������룺
4
-3 75 12 -3
���������
1 3 2 1
��Դ��
2009�걱�����պ����ѧ������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7890-1-1.html
*/	

ElemType data1[N];
ElemType data2[N][2];
int n;
Status handleFunction()
{
	int i=0,j=0;
	int count=1;
	int temp=0;
	Boolean flag=TRUE; 
	for(i=0;i<n&&flag==TRUE;i++)
	{
		flag=FALSE;
		for(j=0;j<n-i-1;j++)
		{
			if(data2[j][0]>data2[j+1][0])
			{
				temp=data2[j][0];
				data2[j][0]=data2[j+1][0];
				data2[j+1][0]=temp;
				flag=TRUE;
			}
		}
	}
	
	for(i=0;i<n;i++)
	{	
		if(data2[i][0]==data2[i+1][0])
		{
			while(data2[i][0]==data2[i+1][0])
			{
				data2[i][1]=count;
				i++;
			}
		}
		data2[i][1]=count;
		count++;
	}
	for(i=0;i<n-1;i++)
	{
		for(j=0;j<n;j++)
		{
			if(data1[i]==data2[j][0])
			{
				printf("%d ",data2[j][1]);
				break;
			}
		}
	
	}

	for(j=0;j<n;j++)
	{
		if(data1[i]==data2[j][0])
		{
			printf("%d\n",data2[j][1]);
			break;
		}
	}
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int i=0;

	while(scanf("%d",&n)!=EOF)//while 1#
	{
		for(i=0;i<n;i++)
		{
			scanf("%d",data1+i);
			data2[i][0]=data1[i];
		}
		handleFunction();
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