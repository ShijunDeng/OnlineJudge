#include<stdio.h>
#include<ctype.h>
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

//#define M 1000
#define N 100

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1105���ַ����ķ���
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��4443�����1363
��Ŀ������
    һ����������������ÿһλȡ������֮Ϊ������ķ��롣�������Ƕ���һ���ַ��ķ��롣�������һ��Сд�ַ����������ַ�'a���ľ�����
	���ķ�����ַ�'z���ľ�����ͬ�������һ����д�ַ����������ַ�'A���ľ��������ķ�����ַ�'Z���ľ�����ͬ����������������������
	���ķ������������
    �ټ������ӣ�'a���ķ�����'z����'c���ķ�����'x����'W���ķ�����'D����'1���ķ��뻹��'1����'$'�ķ��뻹��'$'��
    һ���ַ����ķ��붨��Ϊ�������ַ��ķ��롣���ǵ�������Ǽ���������ַ����ķ��롣
���룺
    ����ÿ�ж���һ���ַ������ַ������Ȳ����� 80 ���ַ����������ֻ��!����ʾ�������������Ҫ����
�����
���������ÿ���ַ���������䷴�룬ÿ������ռһ�С�
�������룺
Hello 
JLU-CCST-2011 
!
���������
Svool 
QOF-XXHG-2011
��Դ��
2011�꼪�ִ�ѧ������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7828-1-1.html
*/
Status handleFunction(char *str)
{
	while(*str!='\0')
	{
		if(islower(*str))
		{
			*str='z'-(*str-'a');
		}
		else if(isupper(*str))
		{
			*str='Z'-(*str-'A');
		}
		str++;
	}
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	char str[N];
	gets(str);
	while(strcmp("!",str))//while 1#
	{
		handleFunction(str);
		printf("%s\n",str);
		gets(str);
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