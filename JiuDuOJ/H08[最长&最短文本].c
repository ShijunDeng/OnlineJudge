#include<stdio.h>
#include<string.h>
//����״̬��
#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0
typedef int Status;
typedef int Boolean;
#define M 1000
#define N 1000
/*

��Ŀ������
    ��������ַ������밴��ԭ�ı��е�˳�����������̺�����ַ����������̺�����ַ�����ֹһ������ȫ�������
���룺
������������ַ������ַ����ĳ���len,(1<=len<=1000)��
�����
����ԭ�ı��е�˳�����������̺�����ַ����������̺�����ַ�����ֹһ������ȫ�������
�������룺
hello
she
sorry
he
���������
he
hello
sorry
*/

//char strs[M][N];

char maxStr[M][N];
int maxStrLen=0;
int maxNum=-1;

char minStr[M][N];
int minStrLen=10000;
int minNum=0;

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{

	int n=0;
	char s[N];
	int i=0;
	while(gets(s)!=NULL)
	{
		n=strlen(s);
		if(n>maxStrLen)
		{
			maxNum=0;
			strcpy(maxStr[maxNum],s);
			maxStrLen=n;
			maxNum++;
		}
		else if(n==maxStrLen)
		{
			strcpy(maxStr[maxNum],s);
			maxNum++;
		}

		if(n<minStrLen)
		{
			minNum=0;
			strcpy(minStr[minNum],s);
			minStrLen=n;
			minNum++;
		}
		else if(n==minStrLen)
		{
			strcpy(minStr[minNum],s);
			minNum++;
		}
		
	}
	for(i=0;i<minNum;i++)
	{
		printf("%s\n",minStr[i]);
	}

	for(i=0;i<maxNum;i++)
	{
		printf("%s\n",maxStr[i]);
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