#include<stdio.h>
//#include<string.h>
//����״̬��
#define OK 0
#define ERROR -1
#define TRUE 1
#define FALSE 0
typedef int Status;
typedef int Boolean;
#define N 1000
/*
��Ŀ1206���ַ�������
ʱ�����ƣ�1 ���ڴ����ƣ�128 ���������⣺���ύ��3582�����1693
��Ŀ������
�������κ��ַ����⺯��ʵ��������ؽ��������ַ�����Ȼ������������������������
���룺
ÿһ�а��������ַ��������Ȳ�����100��
�����
�����ж���������ݣ�����ÿ�����ݣ�
�������κ��ַ����⺯��ʵ��������ؽ��������ַ�����Ȼ������������������������
������Ӻ���ַ�����
�������룺
abc def
���������
abcdef
*/
int strUnion(char stra[N],char strb[N])
{
	int i=0,j=0;
	while(stra[i]!='\0')
	{
		i++;
	}
	while(strb[j]!='\0')
	{
		stra[i]=strb[j];
		i++;
		j++;
	}

	stra[i]='\0';
	return i;
}


//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{

	char stra[N],strb[N];
	//int len=0;
	while(scanf("%s %s",stra,strb)!=EOF)
	{
		strUnion(stra,strb);
		printf("%s\n",stra);		
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