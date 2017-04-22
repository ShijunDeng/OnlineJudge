#include<stdio.h>
#include<string.h>
//#include<malloc.h>
#include<math.h>
//����״̬��
#define OK 0
#define ERROR -1

#define TRUE 1
#define FALSE 0

typedef int Status;
typedef int Boolean;

//#define M 1000
#define N 1500

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1178����������
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��7313�����1339
��Ŀ������
    һ��������x+iy�����ϣ����ֲ��������ڸü����ϣ�
    1��Pop ��ʾ���������и���ģֵ�����Ǹ��������缯��Ϊ�� ���  empty  ����Ϊ�վ���������Ǹ��������ҴӼ�����ɾ���Ǹ�������
		��������ϵĴ�СSIZE��
    2 Insert a+ib  ָ�a��b��ʾʵ�����鲿������a+ib���뵽������ ��������ϵĴ�СSIZE��
		�ʼҪ����һ��int n����ʾ��������n��ÿһ�ж���һ�����
���룺
�����ж������ݡ�
ÿ������һ��n(1<=n<=1000)��Ȼ��������n��ָ�
�����
����ָ����������
�������룺
3
Pop
Insert 1+i2
Pop
���������
empty
SIZE = 1
1+i2
SIZE = 0
��ʾ��
ģ��ȵ����b��С�ĸ�����
a��b���ǷǸ�����
��Դ��
2011�걱���ʵ��ѧ��Ժ�о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7901-1-1.html
20
Insert 4+i74
Insert 51+i74
Insert 41+i2
Insert 333+i27
Insert 7+i7
Insert 1+i11
Insert 10+i4

*/

//���帴���ڵ�
typedef struct Complex
{
	int a;
	int b;
}Complex;

typedef struct SQStack
{
	Complex data[N];
	int length;
}SQStack;
SQStack S;//���帴��ջ
char str[100];

int comp(const void* A,const void * B)
{
	int model= (*((Complex*)A)).a*(*((Complex*)A)).a+
		(*((Complex*)A)).b*(*((Complex*)A)).b-
		(*((Complex*)B)).a*(*((Complex*)B)).a-
		(*((Complex*)B)).b*(*((Complex*)B)).b;
	if(model==0)
	{
		return (*((Complex*)B)).b-(*((Complex*)A)).b;
	}
	else
	{
		return model;
	}
}

Status Pop()
{
	if(S.length<1)
	{
		printf("empty\n");
	}
	else
	{
		qsort(S.data,S.length,sizeof(Complex),comp);
		
		printf("%d+i%d\n",(S.data[S.length-1]).a,(S.data[S.length-1]).b);	
		S.length--;
		printf("SIZE = %d\n",S.length);
	}

	return OK;
}

Status Push(Complex e)//Insert a+ib
{
	S.data[S.length]=e;
	S.length++;
	printf("SIZE = %d\n",S.length);
	return OK;
}

Status handleFunction()
{
	int i=0,k=0,sum=0;
	int a=0,b=0;
	Complex e;
	if(str[0]=='P')
	{
		return Pop();
	}
	else if(str[0]=='I')//Insert 1+i2
	{
		
		while(str[i]<'0'||str[i]>'9')//���������ֲ���
		{
			i++;
		
		}
		while(str[i]>='0'&&str[i]<='9')//��ȡ�����и�����ʵ������
		{
			k=str[i]-'0';
			sum=10*sum+k;	
			i++;
		}
		a=sum;
		sum=0;
		while(str[i]<'0'||str[i]>'9')//���������ֲ���
		{
			i++;
		}
		while(str[i]>='0'&&str[i]<='9')//��ȡ�����и�������������
		{
			k=str[i]-'0';
			sum=10*sum+k;
			i++;
		}
		b=sum;
		sum=0;
		e.a=a;
		e.b=b;
		Push(e);//��ջ
		//printf("%d-- %d\n",a,b);
		return OK;
	}
	return OK;
	
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	int i=0;
//	char str[100];
	while(scanf("%d",&n)!=EOF)//while 1#
	{
		getchar();
		S.length=0;
		for(i=0;i<n;i++)
		{
			gets(str);
			handleFunction();
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