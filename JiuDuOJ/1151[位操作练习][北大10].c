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
#define N 20

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1151��λ������ϰ
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��1524�����842
��Ŀ������
��������������65535�ķǸ��������ж�����һ����16λ�����Ʊ�ʾ��ʽ���Ƿ�������һ����16λ�����Ʊ�ʾ��ʽ����ѭ����������λ���õ���

ѭ�����ƺ���ͨ���Ƶ��������ڣ�����ߵ���һλ����ѭ������һλ��ͻᱻ�Ƶ����ұ�ȥ�����磺
1011 0000 0000 0001 ����ѭ������һλ�󣬱�� 0110 0000 0000 0011, ����ѭ������2λ������ 1100 0000 0000 0110
���룺
��һ���Ǹ�����n, 0 < n < 300000,��ʾ���滹��n������
������n�У�ÿ��������������65535�ķǸ�����
�����
����ÿһ�е��������������һ�У�����ΪYES��NO
�������룺
4
2 4
9 18
45057 49158
7 12
���������
YES
YES
YES
NO
��Դ��
2010�걱����ѧ������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7874-1-1.html

*/
Status judge(int a,int b)
{
	char str1[N];
	char str2[N];
	int len1=0;
	int len2=0;
	int i=0,n=0;

	char c;

	if(a==b)
	{
		printf("YES\n");
		return OK;
	}
	while(a>0)
	{
		str1[i++]=a%2+'0';
		a/=2;
	}
	while(i<16)
	{
		str1[i++]='0';
	}
	str1[i]='\0';
	len1=i;

	i=0;
	while(b>0)
	{
		str2[i++]=b%2+'0';
		b/=2;
	}
	while(i<16)
	{
		str2[i++]='0';
	}
	str2[i]='\0';
	len2=i;
	if(strcmp(str1,str2)==0)
	{
		printf("YES\n");	
		return OK;
	}
//	printf("%s\n%s\n",str1,str2);
	n=16;
	while(n>0)
	{
		i=15;
		c=str1[i];
		while(i>0)
		{
			str1[i]=str1[i-1];
			i--;
		}
		str1[i]=c;
		if(strcmp(str1,str2)==0)
		{
			printf("YES\n");	
			return OK;
		}
		n--;
	}

	printf("NO\n");	
	return OK;

}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	int i=0,a=0,b=0;
	while(scanf("%d",&n)!=EOF)//while 1#
	{
		for(i=0;i<n;i++)
		{
			scanf("%d %d",&a,&b);
			judge(a,b);
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