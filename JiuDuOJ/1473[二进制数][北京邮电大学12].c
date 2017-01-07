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
#define N 1000

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1473����������
ʱ�����ƣ�1 ���ڴ����ƣ�128 ���������⣺���ύ��5498�����1523
��Ŀ������
������Ҷ�֪���������ڼ�������д洢���Զ����Ƶ���ʽ�洢�ġ�
������һ�죬С��ѧ��C����֮������֪��һ������Ϊunsigned int ���͵����֣��洢�ڼ�����еĶ����ƴ���ʲô���ӵġ�
�������ܰ��С���𣿲��ң�С������Ҫ�����ƴ���ǰ���û�������0������Ҫȥ��ǰ��0��
���룺
��һ�У�һ������T��T<=1000������ʾ����Ҫ������ֵĸ�����
��������T�У�ÿ����һ������n��0<=n<=10^8������ʾҪ��Ķ����ƴ���
�����
�����T�С�ÿ�������õĶ����ƴ���
�������룺
5
23
535
2624
56275
989835
���������
10111
1000010111
101001000000
1101101111010011
11110001101010001011
��Դ��
2012�걱���ʵ��ѧ������о�����������


*/
Status dTob(unsigned int n,char str[N])
{
	int k=0;
	int low=0,high=0;
	char c;
	if(n==0)
	{
		str[0]='0';
		str[1]='\0';
		return OK;
	}
	while(n>0)//��ʮ������nת��Ϊ��������  ����ת����Ľ�������str��
	{
		str[k]=n%2+'0';
		n=n>>1;
		k++;
	}
	str[k]='\0';
	//����˳��
	high=k-1;
	while(low<high)
	{
		c=str[low];
		str[low]=str[high];
		str[high]=c;
		low++;
		high--;
	}
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	int i=0,D=0;
	char str[N];
	while(scanf("%d",&n)!=EOF)//while 1#
	{
		for(i=0;i<n;i++)
		{
			scanf("%d",&D);
			dTob(D,str);
			printf("%s\n",str);
		}
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