#include<stdio.h>
//#include<string.h>
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
#define N 2000

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ������
��һ������һ������Ϊn���ڶ�������n��������n�����У����ż���������࣬���NO���������YES��
���룺
�����ж������ݡ�
ÿ������n��Ȼ������n��������1<=n<=1000����
�����
���ż���������࣬���NO���������YES��
�������룺
5
1 5 2 4 3
���������
YES
��Դ��
2010�걱���ʵ��ѧ������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7892-1-1.html


*/
Status countOE(int data[N],int n)
{
	int i=0;
	int count=0;
	for(i=0;i<n;i++)
	{
		if(data[i]%2==0)
			count++;
		else
			count--;
	}
	if(count>0)
		printf("NO\n");
	else
		printf("YES\n");
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{

	int n=0;
	int i=0,j=0;
	int data[N];
	int k=0;
	while(scanf("%d",&n)!=EOF)//while 1#
	{
		for(i=0;i<n;i++)
		{
			scanf("%d",data+i);
		}
		countOE(data,n);
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