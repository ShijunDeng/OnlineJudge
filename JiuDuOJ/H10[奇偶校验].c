#include<stdio.h>
//#include<string.h>
//����״̬��
#define OK 0
#define ERROR -1
#define TRUE 1
#define FALSE 0
typedef int Status;
typedef int Boolean;
#define N 9
#define M 1000
/*
��Ŀ1197����żУ��
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��3037�����1285
��Ŀ������
����һ���ַ�����Ȼ���ÿ���ַ�������У�飬������У���Ķ�������(��'3'�������10110011)��
���룺
�������һ���ַ������ַ������Ȳ�����100��
�����
�����ж���������ݣ�����ÿ�����ݣ�
�����ַ����е�ÿһ���ַ����������Ŀ������żУ��������ÿ���ַ�У��Ľ��ռһ�С�
�������룺
3
3a
���������
10110011
10110011
01100001
*/

//У��һ���ַ�c����������vStr�� ��У��
Status verifyCharO(char c,char vStr[N])
{
	int cInt=c;
	int i=N-1;
	int num=0;//����c�Ķ���������1�ĸ���
	int n=0;

	vStr[i]='\0';
	i--;
	while(c>0)
	{
		n=c%2;
		vStr[i]=n+'0';
		if(n==1)//�ۼ�1�ĸ���
			num++;
		i--;
		c/=2;
	}

	while(i>0)
	{
		vStr[i]='0';
		i--;
	}

	if(num%2==0)
	{
		vStr[i]='1';
	}
	else
	{
		vStr[i]='0';
	}
	return OK;
}
//��У��һ���ַ����ĸ�λ�����
Status verifyStrO(char str[M])
{
	int i=0;
	char strV[N];
	while(str[i]!='\0')
	{
		verifyCharO(str[i],strV);
		printf("%s\n",strV);
		i++;
	}
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{

	char str[M];
	while(scanf("%s",str)!=EOF)
	{
		verifyStrO(str);
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