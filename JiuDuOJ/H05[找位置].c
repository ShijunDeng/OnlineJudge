#include<stdio.h>
#include<malloc.h>
#include<stdlib.h>
#include<string.h>
//����״̬��
#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0

#define N 1000

typedef int ElemType;
typedef int Status;
typedef int Boolean;

/*
��Ŀ1199����λ��
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺�� �ύ��1752�����863
��Ŀ������
�Ը�����һ���ַ������ҳ����ظ����ַ�����������λ�ã��磺abcaaAB12ab12
�����a��1��a��4��a��5��a��10��b��2��b��11��1��8��1��12�� 2��9��2��13��
���룺
�������һ������ĸ��������ɵ��ַ������䳤�Ȳ�����100��
�����
�����ж���������ݣ�����ÿ�����ݣ�
������������ĸ�ʽ���ַ����ֵ�λ�ñ����
�������룺
abcaaAB12ab12
���������
a:0,a:3,a:4,a:9
b:1,b:10
1:7,1:11
2:8,2:12
��ʾ��
1���±��0��ʼ��
2����ͬ����ĸ��һ�б�ʾ������ֹ���λ�á�

*/


Status search(char str[N],int n)
{
	int i=0,j=0;
	Boolean mark=TRUE;//ÿ����ĸ��һ�ε��������
	for(i=0;i<n;i++)//for #1
	{
		mark=TRUE;
		//mark=FLASE;
		if(str[i]=='\0')
			continue;
		for(j=i+1;j<n;j++)//end:for #2
		{	
			if(str[j]=='\0')
				continue;
			if(str[i]==str[j])
			{
				if(mark==TRUE)
				{
					printf("%c:%d",str[i],i);
					mark=FALSE;
				}
				printf(",%c:%d",str[j],j);
				str[j]='\0';//�����ٴα��ѵ�
			}		
		}//end:for #2
		if(FALSE==mark)
			printf("\n");
	}//end:for #1
	return OK;
}


//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{

	char str[N];
	int n=0;

	while(gets(str) != NULL)
	{
		search(str,strlen(str));
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