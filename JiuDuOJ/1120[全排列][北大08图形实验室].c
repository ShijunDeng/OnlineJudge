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

//#define M 1000
#define N 7

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1120��ȫ����
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��3530�����881
��Ŀ������
����һ���ɲ�ͬ��Сд��ĸ��ɵ��ַ������������ַ���������ȫ���С�
���Ǽ������Сд��ĸ��'a' < 'b' < ... < 'y' < 'z'�����Ҹ������ַ����е���ĸ�Ѿ����մ�С�����˳�����С�
���룺
����ֻ��һ�У���һ���ɲ�ͬ��Сд��ĸ��ɵ��ַ�������֪�ַ����ĳ�����1��6֮�䡣
�����
�������ַ������������з�ʽ��ÿ��һ�����С�Ҫ����ĸ��Ƚ�С��������ǰ�档��ĸ�����¶��壺
��֪S = s1s2...sk , T = t1t2...tk����S < T �ȼ��ڣ�����p (1 <= p <= k)��ʹ��
s1 = t1, s2 = t2, ..., sp - 1 = tp - 1, sp < tp������
�������룺
abc
���������
abc
acb
bac
bca
cab
cba
��ʾ��
ÿ���������������Ҫ�����һ���س���
��Դ��
2008�걱����ѧͼ��ʵ���Ҽ�����о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7843-1-1.html

*/
Boolean visited[N];
int strLen;

//�����õ�λ���Ƿ�Ϸ�
//���ú����ᳬʱ
Boolean check(int k)
{
	if(visited[k]==TRUE)
		return FALSE;
	return TRUE;
}
Status permutation(char str[N])
{
	int index[N];
	int i=0,k=0;
	char pstr[N];

	strLen=strlen(str);
	for(i=0;i<strLen;i++)
	{
		visited[i]=FALSE;
		index[i]=-1;
	}

	while(k>=0)
	{
		index[k]++;
		while(index[k]<=strLen-1&&visited[index[k]]==TRUE)//���ú����ᳬʱ
		{
			index[k]++;
		}

		if(index[k]<=strLen-1)
		{
			if(k==strLen-1)//�ҵ�һ���
			{
				for(i=0;i<strLen;i++)
				{
					pstr[i]=str[index[i]];	
				}
				pstr[i]='\0';
				printf("%s\n",pstr);
			}
			else
			{
				visited[index[k]]=TRUE;
				k++;
				index[k]=-1;
			}
		}
		else
		{
			k--;//��˷
			visited[index[k]]=FALSE;
		}

	}
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	char str[N];

	while(scanf("%s",str)!=EOF)//while 1#
	{
		permutation(str);
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
