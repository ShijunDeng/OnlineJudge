#include<stdio.h>
#include<string.h>
//����״̬��
#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0
typedef int Status;
typedef int Boolean;
#define N 2000
/*
��Ŀ1198��a+b
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��5199�����1805
��Ŀ������
ʵ��һ���ӷ�����ʹ���ܹ����a+b��ֵ��
���룺
�������������a��b������a��b��λ��������1000λ��
�����
�����ж���������ݣ�����ÿ�����ݣ�
���a+b��ֵ��
�������룺
2 6
10000000000000000000 10000000000000000000000000000000
���������
8
10000000000010000000000000000000

*/

Status add(char strA[N],char strB[N],char strC[N])
{
	int lenghA=strlen(strA)-1;
	int lenghB=strlen(strB)-1;
	int i=0;
	int c=0;//��λ
	int sum=0;//ÿһλ��ӵĺ�
	int low,high;
	char temp;
	
	while(lenghA>=0&&lenghB>=0)//��λ���
	{
		sum=strA[lenghA]+strB[lenghB]-'0'-'0'+c;
		c=sum/10;
		strC[i]=sum%10+'0';
		lenghA--;
		lenghB--;
		i++;
	}
//����ϳ����ַ������µ��ַ�
	while(lenghA>=0)
	{
		sum=strA[lenghA]-'0'+c;
		c=sum/10;
		strC[i]=sum%10+'0';
		lenghA--;
		i++;
	}
	while(lenghB>=0)
	{
		sum=strB[lenghB]-'0'+c;
		c=sum/10;
		strC[i]=sum%10+'0';
		lenghB--;
		i++;
	}
	while(c>0)//�״� ����5+8��λ����Ӿ�֪����
	{
		strC[i]=c%10+'0';
		i++;
		c/=10;
	}
	strC[i]='\0';
	low=0;
	high=i-1;
	while(low<high)//��strCת��
	{
		temp=strC[low];
		strC[low]=strC[high];
		strC[high]=temp;
		low++;
		high--;
	}

	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{

	char strA[N],strB[N],strC[N];
	while(scanf("%s %s",strA,strB)!=EOF)
	{
		add(strA,strB,strC);
		printf("%s\n",strC);
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