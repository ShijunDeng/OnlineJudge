#include<stdio.h>
//#include<string.h>
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
#define N 1000

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1153������ƥ������
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��3689�����1647
��Ŀ������
    ��ĳ���ַ��������Ȳ�����100�����������š������źʹ�Сд��ĸ���涨���볣��������ʽ��һ����
	�κ�һ�������Ŷ����ڵ����������ұ��Ҿ��������������ƥ�䡣дһ�������ҵ��޷�ƥ��������ź������ţ�
	���ԭ���ַ�����������һ�б������ƥ������š�����ƥ�����������"$"��ע,����ƥ�����������"?"��ע.
���룺
    ��������������ݣ�ÿ������һ�У�����һ���ַ�����ֻ�����������źʹ�Сд��ĸ���ַ������Ȳ�����100��
    ע�⣺cin.getline(str,100)���ֻ������99���ַ���
�����
    ��ÿ��������ݣ�������У���һ�а���ԭʼ�����ַ����ڶ�����"$","?"�Ϳո���ɣ�"$"��"?"��ʾ��֮��Ӧ�������ź������Ų���ƥ�䡣
�������룺
)(rttyy())sss)(
���������
)(rttyy())sss)(
?            ?$
��Դ��
2010�걱����ѧ������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7876-1-1.html

*/

Status handleFunction(char str[N])
{
	int left[N];
	int right[N];
	int lsize=0;
	int rsize=0;
	int i=0;
	while(str[i]!='\0')
	{
		if(str[i]=='(')
		{			
			left[lsize]=i;
			lsize++;
		}
		else if(str[i]==')')
		{
			if(lsize>0)
			{
				lsize--;
			}
			else
			{
				right[rsize]=i;
				rsize++;
			}
		}
		i++;
	}

	i=0;
	while(str[i]!='\0')
	{
		str[i]=' ';
		i++;
	}
	lsize--;
	while(lsize>=0)
	{
		str[left[lsize]]='$';
		lsize--;
	}
	rsize--;
	while(rsize>=0)
	{
		str[right[rsize]]='?';
		rsize--;
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
		printf("%s\n",str);
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