#include<stdio.h>

//����״̬��
#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0
typedef int Status;
typedef int Boolean;
/*

��Ŀ������
����һ������������ת���ɰ˽����������
���룺
�������һ������N(0<=N<=100000)��
�����
�����ж���������ݣ�����ÿ�����ݣ�
���N�İ˽��Ʊ�ʾ����
�������룺
7
8
9
���������
7
10
11

*/


//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{

	int n=0;
	while(scanf("%d",&n)!=EOF)
	{
		printf("%o\n",n);
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