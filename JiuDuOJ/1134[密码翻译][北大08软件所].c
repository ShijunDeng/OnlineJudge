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
typedef char ElemType;

#define N 100

/*************************��Ŀ˵��********************/
/*
��Ŀ1134�����뷭��
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��1809�����732
��Ŀ������
    ���鱨���ݹ����У�Ϊ�˷�ֹ�鱨���ػ�������Ҫ���鱨��һ���ķ�ʽ���ܣ��򵥵ļ����㷨��Ȼ��������ȫ�����鱨�����룬
	����Ȼ�ܷ�ֹ�鱨�����׵�ʶ�����Ǹ���һ�����ĵļ��ܷ������Ը�����һ���ַ����������д�a-y,A-Y����ĸ��������ĸ�����
	��z��Z��a��A�������ɵõ�һ���򵥵ļ����ַ�����
���룺
        �����ж���������ݡ�ÿ��������ݵĵ�һ�����ַ�������Ŀn�� (ҲҪʹ��get(s)��ȡ�ַ���,����n=atoi(s)���������ֵ)��
		����n��ÿ��һ���ַ���,��gets(s)��ʽ��ȡ��һ���ַ���.ÿ���ַ�������С��80���ַ���
�����
    ����ÿ�����ݣ����ÿ���ַ����ļ����ַ�����
�������룺
1
Hello! How are you!
���������
Ifmmp! Ipx bsf zpv!
��Դ��
2008�걱����ѧ�����������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7857-1-1.html
*/
Status handleFunction(ElemType str[N])
{
	int i=0;
	while(str[i]!='\0')
	{
		if((str[i]>='a'&&str[i]<='y')||(str[i]>='A'&&str[i]<='Y'))
		{
			str[i]=str[i]+1;
		}
		else if(str[i]=='z')
		{
			str[i]='a';
		}
		else if(str[i]=='Z')
		{
			str[i]='A';
		}
		i++;
	}
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	int i=0;
	char str[N];

	while(gets(str)!=NULL)//while 1#
	{
		n=atoi(str);
		//printf("%d\n",n);
		for(i=0;i<n;i++)
		{
			gets(str);
			handleFunction(str);
			printf("%s\n",str);
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