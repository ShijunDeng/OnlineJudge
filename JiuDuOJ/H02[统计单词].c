#include<stdio.h>
#include<malloc.h>
//#include<stdlib.h>
//����״̬��
#define OK 0
#define ERROR -1
#define TRUE 1
#define FALSE 0
#define N 1024
#define NUM 256
typedef int Status;
typedef int Boolean;

/*
��һ�����򣬶����û�����ģ��ԡ�.����β��һ�����֣�ͳ��һ���ж��ٸ����ʣ����ֱ����ÿ�����ʺ��ж��ٸ��ַ���
��������һ�������ո�����Ĳ��־�Ϊһ�����ʣ�
���룺
�������1���ַ������ԡ�.���������ַ����а���������ʣ�����֮����һ�������ո������
�����
�����ж���������ݣ�����ÿ�����ݣ�
����ַ�����ÿ�����ʰ�������ĸ�ĸ�����
�������룺
hello how are you.
���������
5 3 3 3
*/

/*
str ��������ַ���
counts ���ͳ�ƵĽ��
num ���ʵ�����
*/
Status count(char str[N],int counts[NUM],int *num)
{
	int i=0;//�������ʵ��±�
	int j=0;//���ʵĸ���
	int k=0;//ÿ�����ʵ���ĸ��
	while(str[i]!='.'&&str[i]!='\0')//while #1
	{
		if(str[i]==' ')//һ�����ʽ���
		{
			counts[j]=k;
			j++;
			k=0;//������ĸ������������
			while(str[i]==' ')//while #2 ����һ�����ʽ��������еĿո�
			{
				i++;
			}//end:while #2 
		}
		else
		{
			i++;
			k++;//���ʵ���ĸ����һ
		}			
	}//end:while #1

	if(i>0&&str[i-1]!=' ')
	{
		counts[j]=k;//�������һ������
		j++;
	}

	*num=j;//���ʵĸ���
	return OK;
}


//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int num=0;
	char str[N];
	int counts[NUM];
	int i=0;

	while( gets(str) != EOF)
	{
	
		count(str,counts,&num);

		for(i=0;i<num-1;i++)
		{
			printf("%d ",counts[i]);
		}	
		//�������һ������ո�
		if(num>0)
			printf("%d\n",counts[i]);
		str[0]='\0';
		num=0;
		
	}

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