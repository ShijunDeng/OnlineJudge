#include<stdio.h>
#include<string.h>
//����״̬��
#define OK 0
#define ERROR -1

#define TRUE 1
#define FALSE 0

typedef int Status;
typedef int Boolean;

#define N 1000

/*************************��Ŀ˵��********************/
/*

��Ŀ1471���ϲ�����
ʱ�����ƣ�1 ���ڴ����ƣ�128 ���������⣺���ύ��1195�����525
��Ŀ������
���������ַ���S1��S2���ϲ���һ���µ��ַ���S��
�ϲ�����Ϊ��S1�ĵ�һ���ַ�ΪS�ĵ�һ���ַ�����S2�����һ���ַ���ΪS�ĵڶ����ַ���
��S1�ĵڶ����ַ���ΪS�ĵ������ַ�����S2�ĵ����ڶ����ַ���ΪS�ĵ��ĸ��ַ����Դ����ơ�
���룺
��������������ݣ�ÿ��������ݰ������У���������ȵ������ַ���S1��S2������Сд��ĸ��ɣ����Ȳ�����100����
�����
�ϲ�������ַ���S
�������룺
abc
def
���������
afbecd
��Դ��
2011��������ҵ��ѧ������о�����������

*/
Status specialStract(char str1[N],char str2[N],char str3[N])
{
	int len1=strlen(str1);
	int len2=strlen(str2);
	int i=0,j=len2-1,k=0;

	while(str1[i]!='\0'&&j>=0)
	{
		str3[k++]=str1[i++];
		str3[k++]=str2[j--];
	}

	while(str2[i]!='\0')
	{
		str3[k++]=str1[i++];
	}

	while(j>=0)
	{
		str3[k++]=str2[j--];
	}
	str3[k]='\0';
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	int i=0,j=0;
	char str1[N],str2[N],str3[N];
	while(scanf("%s %s",str1,str2)!=EOF)//while 1#
	{
		specialStract(str1,str2,str3);
		printf("%s\n",str3);
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