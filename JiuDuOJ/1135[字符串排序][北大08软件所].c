#include<stdio.h>
#include<string.h>
//#include<malloc.h>
//#include<math.h>
//����״̬��
#define OK 0
#define ERROR -1

#define TRUE 1
#define FALSE 0

typedef int Status;
typedef int Boolean;

#define M 50
#define N 120

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1135���ַ�������
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��1376�����719
��Ŀ������
��������Ҫ������ַ����ĸ�����Ȼ������������ַ�����ÿ���ַ����Իس�������ÿ���ַ�������һ�ٸ��ַ���
�������������������һ���ַ���Ϊ"stop"��Ҳ�������롣
Ȼ��������ĸ����ַ�����ÿ���ַ����ĳ��ȣ���С�������򣬰�����������ַ�����
���룺
�ַ����ĸ������Լ������ַ�����ÿ���ַ�����'\n'��������������ַ���Ϊ"stop"��Ҳ��������.
�����
�����ж���������ݣ�����ÿ�����ݣ�
������������ַ�����������С�����������(�����"stop"�������"stop")��
�������룺
5
sky is grey
cold
very cold
stop
3
it is good enough to be proud of
good
it is quite good
���������
cold
very cold
sky is grey
good
it is quite good
it is good enough to be proud of
��ʾ��
����������ַ�����������̬����洢�ռ䣨����new()��������ÿ���ַ���������100���ַ���
���������ж��飬ע��ʹ��while()ѭ�����롣
��Դ��
2008�걱����ѧ�����������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7858-1-1.html
*/
char data[M][N];
int count=0;
int comp(const void * s1,const void * s2)
{
	return strlen((char*)s1)-strlen((char*)s2);
}
Status handleFunction()
{	
//	printf("%d\n",count);
	qsort(data,count,sizeof(data[0]),comp);
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int i=0;
	while(scanf("%d",&count)!=EOF)//while 1#
	{
		getchar();
		for(i=0;i<count;i++)
		{
			gets(data[i]);
			if(strcmp(data[i],"stop")==0)
			{
				count=i;
				break;
			}
		}
		handleFunction();
		for(i=0;i<count;i++)
		{
			printf("%s\n",data[i]);
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