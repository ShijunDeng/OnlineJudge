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

#define M 32
#define N 128

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1066���ַ�������
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��5086�����2064
��Ŀ������
 ����һ�����Ȳ�����20���ַ���������������ַ���������ASCII��Ĵ�С��С���������������������Ľ��
���룺
 һ���ַ������䳤��n<=20
�����
 �������������ж��飬����ÿ�����������
����ASCII��Ĵ�С��������ַ�����С�������������������Ľ��
�������룺
dcba
���������
abcd
��Դ��
2001���廪��ѧ������о�����������(��II��)
*/

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int data[N];
	char str[M];
	int i=0;

	while(gets(str)!=NULL)//while 1#
	{
		memset(data,0,N*sizeof(int));
		i=0;
		while(str[i]!='\0')
		{
			data[str[i]]++;
			i++;
		}
		for(i=0;i<N;i++)
		{	
			while(data[i]>0)
			{
				printf("%c",i);
				data[i]--;
			}	
		}
		printf("\n");
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