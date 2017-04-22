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
��Ŀ1131���ϳ�����
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��2216�����686
��Ŀ������
Nλͬѧվ��һ�ţ�������ʦҪ�����е�(N-K)λͬѧ���У�ʹ��ʣ�µ�Kλͬѧ������λ�þ����ųɺϳ����Ρ�
�ϳ�������ָ������һ�ֶ��Σ���Kλͬѧ���������α��Ϊ1, 2, ��, K�����ǵ���߷ֱ�ΪT1, T2, ��, TK��
�����ǵ��������T1 < T2 < �� < Ti , Ti > Ti+1 > �� > TK (1 <= i <= K)��
��������ǣ���֪����Nλͬѧ����ߣ�����������Ҫ��λͬѧ���У�����ʹ��ʣ�µ�ͬѧ�ųɺϳ����Ρ�
���룺
����ĵ�һ����һ������N��2 <= N <= 100������ʾͬѧ��������
��һ����n���������ÿո�ָ�����i������Ti��130 <= Ti <= 230���ǵ�iλͬѧ����ߣ����ף���
�����
���ܰ�������������ݣ�����ÿ�����ݣ�
�������һ�У���һ��ֻ����һ������������������Ҫ��λͬѧ���С�
�������룺
8
186 186 150 200 160 130 197 220
���������
4
��Դ��
2008�걱����ѧ����ʵ���Ҽ�����о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7854-1-1.html
�Ŷ�Online Judge�޸���HUSTOJ | ��ICP��09099636�� | �Ŷ�Online Judge��Ȩ����
*/
int bt[N];	
int lt[N];
//�����������������:startIndex~endIndex
Status maxAscSub(int data[N],int startIndex,int endIndex)
{	
	int next[N];
	int i=0,j=0;
	int btN=0,nextP=-1;
	int sum=0,max=0;
	for(i=startIndex;i<=endIndex;i++)
	{
		bt[i]=1;
		next[i]=-1;
	}

	for(i=startIndex+1;i<=endIndex;i++)
	{
		btN=0;
		nextP=-1;
		for(j=i-1;j>=startIndex;j--)
		{
			if(data[i]>data[j]&&bt[j]>btN)
			{
				nextP=j;
				btN=bt[j];
			}
		}
		if(nextP!=-1)
		{
			bt[i]=btN+1;
			next[i]=nextP;
		}		
	}
	return OK;
}

//������½���������:startIndex~endIndex
Status maxDescSub(int data[N],int startIndex,int endIndex)
{
	int next[N];
	int i=0,j=0;
	int ltN=0,nextP=-1;
	int sum=0,max=0;
	for(i=startIndex;i<=endIndex;i++)
	{
		lt[i]=1;
		next[i]=-1;
	}

	for(i=endIndex-1;i>=startIndex;i--)
	{
		ltN=0;
		nextP=-1;
		for(j=i+1;j<=endIndex;j++)
		{
			if(data[i]>data[j]&&lt[j]>ltN)
			{
				nextP=j;
				ltN=lt[j];
			}
		}
		if(nextP!=-1)
		{
			lt[i]=ltN+1;
			next[i]=nextP;
		}
		
	}
	return OK;
}
int handleFunction(int data[N],int size)
{
	int i=1;
	int num=0;
	int min=size;

	maxAscSub(data,0,size-1);
	maxDescSub(data,0,size-1);

	for(i=0;i<size;i++)
	{
		num=size+1-bt[i]-lt[i];
		if(num<min)
			min=num;
	}
	return min;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	int i=0;
	int data[N];
	while(scanf("%d",&n)!=EOF)//while 1#
	{
		for(i=0;i<n;i++)
		{
			scanf("%d",data+i);
		}
		printf("%d\n",handleFunction(data,n));
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