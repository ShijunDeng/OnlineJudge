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
#define N 200

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1177������
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��5786�����1709
��Ŀ������
    ����һ���ַ������������ģ����ٶ���һ��int n��¼�������м�������ܹ���2�����
	1����ת  ���±�Ϊi���ַ���ʼ��i+len-1֮����ַ�������
	2���滻  ���������һλΪ1��������ĵ���λ��ʼ�������ַ����滻ԭ������ַ����±� i �� i+len-1���ַ�����
	   ÿ��ִ��һ��������µ��ַ�������ɵ��ַ���������һ�������������ڵõ������ַ����ϣ���
    �����ʽ����һλ0����ת��1�����滻���ڶ�λ������������ַ�������ʼ�±�int i������λ��ʾ��Ҫ�������ַ�������int len��
���룺
�����ж������ݡ�
ÿ������һ���ַ�����������100��Ȼ������n��������n��ָ�ָ��һ����Ч����
�����
����ָ����ַ�����������������
�������룺
bac
2
003
112as
���������
cab
cas
��Դ��
2011�걱���ʵ��ѧ��Ժ�о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7900-1-1.html
abcdefg
4
002
12544444
025

*/
Status handleFunction(char str[N],char command[N])
{
	int startIndex,endIndex;
	int i,mid,j;
	char c;	
	int length=strlen(str);

	if(command[0]=='0')//1����ת 
	{
		startIndex=command[1]-'0';
		endIndex=startIndex+command[2]-'0'-1;
		//printf("%d %d\n",startIndex,endIndex);
		mid=(startIndex+endIndex)/2;//��ȡ��ת���м�λ��
		while(startIndex<endIndex)
		{
			c=str[startIndex];
			str[startIndex]=str[endIndex];
			str[endIndex]=c;
			startIndex++;
			endIndex--;
		}
		printf("%s\n",str);		
	}
	else//2���滻 
	{	
		startIndex=command[1]-'0';
		endIndex=startIndex+command[2]-'0'-1;
		i=startIndex;
		j=3;
	//	printf("%d %d\n",startIndex,endIndex);
		while(i<=endIndex)
		{
			str[i]=command[j];
			i++;
			j++;
		}
		if(i>length)
		{
			str[i]='\0';
		}
		printf("%s\n",str);		
	}
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	int i=0,j=0;
	char str[N];
	char command[N];
	while(scanf("%s",str)!=EOF)//while 1#
	{
		scanf("%d",&n);
		for(i=0;i<n;i++)
		{
			scanf("%s",command);
			handleFunction(str,command);
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