#include<stdio.h>
#include<string.h>
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
#define N 512

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
Ŀ1159��׹�������
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��1004�����246
��Ŀ������
    һ������Ϊ1�׵�ľ����������ֻ���������������ǵ��ٶ�Ϊÿ��һ���׻�ֹ����������ֻ�����֣�����������ҡ�
	�����ֻ������ͷ�����������������ٶȲ�������������ֻ������ͷ�������ߵ����Ͻ����ٶȣ��м��������Ȼ��ֹ��
	�������������ľ���ı�Ե��0��100���״�������ľ����׹����ȥ����ĳһʱ�����ϵ�λ�ø�����ͬ�Ҿ����������״�
	����1��2��3����99���ף�������ֻ��һֻ����A�ٶ�Ϊ0���������Ͼ������������������������ʱ��ľ���ϵ���������λ
	�úͳ�ʼ�ٶȣ��ҳ�����A�Ӵ�ʱ�̵�׹������Ҫ��ʱ�䡣
���룺
    ��һ�а���һ��������ʾ���ϵĸ���N��2<=N<=99����֮����N�У�ÿһ������һֻ���ϵĳ�ʼ״̬��ÿ����ʼ״̬������������ɣ�
	�м��ÿո��������һ�����ֱ�ʾ��ʼλ��������P��1<=P<=99�����ڶ������ֱ�ʾ��ʼ����,-1��ʾ����1��ʾ���ң�0��ʾ��ֹ��
�����
    ����A�ӿ�ʼ��׹���ʱ�䡣������׹�䣬���"Cannot fall!"
�������룺
4
10 1
90 0
95 -1
98 -1
���������
98
��Դ��
2011�걱����ѧ������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7882-1-1.html


*/
Status handleFunction(int data[N],int n)
{
	int zeroPos=0;
	int left[N];
	int right[N];
	int i=0,j=0,k1=0,k2=0;

	memset(left,-1,N);
	memset(right,-1,N);

	for(i=1;i<=100;i++)//Ѱ�Ҿ�ֹ������λ��
	{
		if(data[i]==0)
		{
			//printf("%d",i);
			zeroPos=i;		
			break;
		}
	}
	j=zeroPos+1;
	k1=1;
	while(j<=100)
	{
		if(data[j]==-1)
		{	//-1��ʾ����1��ʾ����
			right[k1++]=j;
		}
		j++;
	}

	j=zeroPos-1;
	k2=1;
	while(j>=1)
	{
		if(data[j]==1)
		{	//-1��ʾ����1��ʾ����
			left[k2++]=j;
		}
		j--;
	
	}
	if(k1==k2)
	{
		printf("Cannot fall!\n");
		return OK;
	}
	if(k1>k2)//�ұ߶�
	{
		printf("%d\n",right[k2]);
	}
	else
	{
		printf("%d\n",100-left[k1]);
	}
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	int i=0,status=0,j=0;
	int data[N];
	while(scanf("%d",&n)!=EOF)//while 1#
	{
		memset(data,3,N);
		for(i=0;i<n;i++)
		{
			scanf("%d %d",&j,&status);
			data[j]=status;
		}
		handleFunction(data,n);
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