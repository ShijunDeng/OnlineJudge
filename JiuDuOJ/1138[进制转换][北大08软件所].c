#include<stdio.h>
#include<string.h>
//����״̬��
#define OK 0
#define ERROR -1

typedef int Status;
typedef int Boolean;

#define N 1000

/*************************��Ŀ˵��********************/
/*
��Ŀ1138������ת��
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��1808�����724
��Ŀ������
��һ���������Ϊ30λ���ֵ�ʮ���ƷǸ�����ת��Ϊ�������������
���룺
�������ݣ�ÿ��Ϊһ�����Ȳ�����30λ��ʮ���ƷǸ�������
��ע����10�������ֵĸ���������30��������30bits��������
�����
ÿ�������Ӧ�Ķ���������
�������룺
0
1
3
8
���������
0
1
11
1000
��Դ��
2008�걱����ѧ�����������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7861-1-1.html
*/

//��ʮ�����ַ���dStrת���ɶ������ַ���tStr
Status dTob(char dStr[N],char tStr[N])
{
	int i=0;
	int len=strlen(dStr);
	int n=0;
	int k=0;
	char strTemp[N];
	char c;
	for(i=0;i<len;i++)
	{
		strTemp[i]=dStr[i]-'0';//���ַ����е�ÿ���ַ���ֵת��Ϊ��ʮ�����ж�Ӧ��ֵ
	}
	n=0;
	while(n<len)
	{
		for(i=n;i<len-1;i++)
		{
			if(strTemp[i]%2==1)
			{
				strTemp[i+1]+=10;//��λģ2��1 �൱�ڴθ�λ��10	
			}			
			strTemp[i]/=2;
		}
		tStr[k++]=strTemp[len-1]%2+'0';
		strTemp[len-1]/=2;
		if(strTemp[n]==0)
		{
			n++;
		}	
	}

	//��õĽ����ʵ��˳��պ��෴
	i=0;
	tStr[k]='\0';
	k--;
	while(i<k)//��ת��
	{
		c=tStr[i];
		tStr[i]=tStr[k];
		tStr[k]=c;
		i++;
		k--;
	}
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	int i=0;
	char dStr[N];
	char tStr[N];
	while(scanf("%s",dStr)!=EOF)//while 1#
	{
		 dTob(dStr,tStr);
		 printf("%s\n",tStr);
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