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

#define N 40

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1125��������������
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��866�����428
��Ŀ������
��֪������k����2<=k<=9���ָ����������Ϊ30λ��ʮ���ƷǸ�����c��������������c��k.
���룺
���ɸ��Ǹ�����c��c��λ��<=30
ÿ��һ��c����c=-1ʱ��ֹ
����Ҫ��-1���м��㣡��
�����
ÿһ��c�Ľ��ռһ��
1) ���������� c%k == 0 ��k���������������k���м��ÿո���������һ��k����û�пո�
2) ��û��������k�����"none"
�������룺
30
72
13
-1
���������
2 3 5 6
2 3 4 6 8 9
none
��ʾ��
ע�������������
��Ҫ��-1���м���
��Դ��
2008�걱����ѧ����ʵ���Ҽ�����о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7848-1-1.html
*/
Status handleFunction(char str[N])
{	int divi[8];//�������
	int size=0;//���ӵĸ���
	
	int sum=0;
	int i=0,k=0,w=0;
	int strLen=strlen(str);
	
	k=2;
	while(k<=9)
	{
		sum=0;
		w=0;//����
		for(i=0;i<strLen;i++)
		{
			sum=str[i]-'0'+w*10;
			w=sum%k;
		}
		if(sum%k==0)
		{
			divi[size++]=k;
		}
		k++;
	}

	if(size==0)
	{
		printf("none\n");
		return OK;
	}
	for(i=0;i<size-1;i++)
	{
		printf("%d ",divi[i]);
	}
	printf("%d\n",divi[i]);
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	char str[N];
	scanf("%s",str);
	while(strcmp(str,"-1"))//while 1#
	{
		handleFunction(str);
		scanf("%s",str);
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