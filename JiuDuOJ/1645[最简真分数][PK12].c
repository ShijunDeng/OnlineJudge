#include<stdio.h>
//#include<string.h>
//����״̬��
#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0
typedef int Status;
typedef int Boolean;
#define N 1000
/*
��Ŀ������
����n������������ȡ�������ֱ���Ϊ���Ӻͷ�ĸ�������������������м�����������ϡ�
���룺
�����ж��飬ÿ�����n��n<=600����n����ͬ����������������1��С�ڵ���1000��
��n=0ʱ���������������Ҫ�����������ݡ�
�����
ÿ���������������ϵĸ�����
�������룺
7
3 5 7 9 11 13 15
3 
2 4 5
0
���������
17 
2

*/
//շת����������Լ��
int gcd(int a,int b)
{
	int temp,x=a,y=b;
	if(a<b)
	{
		x=b;
		y=a;
	}
	while(x%y!=0)
	{
		temp=x%y;
		x=y;
		y=temp;
	}

	return y;
}
int search(int data[N],int n)
{
	int sum=0;
	int i=0,j=0;
	for(i=0;i<n;i++)
	{
		for(j=0;j<n;j++)
		{
			if(j!=i&&data[i]&&data[j])
			{
				if((data[i]==1 ||data[i]==-1 )||(data[i]<data[j]&&gcd(data[j],data[i])==1))
				{
					sum++;
				}
			}
		}
	}

	return sum;
}


//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{

	int data[N];
	int n=0;
	int i=0;
	scanf("%d",&n);
	while(n!=0)
	{
		for(i=0;i<n;i++)
		{
			scanf("%d",data+i);
		}
		printf("%d\n",search(data,n));	
		scanf("%d",&n);
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