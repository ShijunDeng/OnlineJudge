#include<stdio.h>
#include<ctype.h>
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
��Ŀ1121������ĸ��д
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��2570�����887
��Ŀ������
��һ���ַ����е����е��ʣ�������ʵ�����ĸ���Ǵ�д��ĸ����ѵ��ʵ�����ĸ��ɴ�д��ĸ��
���ַ����У�����֮��ͨ���հ׷��ָ����հ׷��������ո�(' ')���Ʊ��('\t')���س���('\r')�����з�('\n')��
���룺
����һ�У���������ַ���������С��100����
�����
�����ж���������ݣ�����ÿ�����ݣ�
���һ�У�ת������ַ�����
�������룺
if so, you already have a google account. you can sign in on the right.
���������
If So, You Already Have A Google Account. You Can Sign In On The Right.
��Դ��
2008�걱����ѧͼ��ʵ���Ҽ�����о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7844-1-1.html
*/
Status handleFunction(char str[N])
{
	Boolean flag=TRUE;
	int i=0;
	while(str[i]!='\0')
	{
		if(flag==TRUE)
		{
			str[i]=toupper(str[i]);
		}
		if(str[i]==' '||str[i]=='\t'||str[i]=='\r'||str[i]=='\n'||str[i]=='.'||str[i]==',')
		{
			flag=TRUE;
		}
		else
		{
			flag=FALSE;
		}
		i++;
	}

	printf("%s\n",str);
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	char str[N];

	while(gets(str)!=NULL)//while 1#
	{
		handleFunction(str);
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