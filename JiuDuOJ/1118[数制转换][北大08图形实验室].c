#include<stdio.h>
#include<string.h>
#include<ctype.h>
//#include<malloc.h>
//#include<math.h>
//����״̬��
#define OK 1
#define ERROR 0

#define TRUE 1
#define FALSE 0

typedef int Status;
typedef int Boolean;

//#define M 1000
#define N 1000

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1118������ת��
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��2999�����1154
��Ŀ������
    ������������ͬ���ƷǸ�������ת����2���ơ�16���ƣ�������������long���ܱ��ķ�Χ֮�ڡ�
    ��ͬ���Ƶı�ʾ����Ϊ��0��1��...��9��a��b��...��f�����ߣ�0��1��...��9��A��B��...��F����
���룺
    ����ֻ��һ�У�������������a��n��b��a��ʾ����n ��a����������b��ʾ����a��������nת����b����������
	a��b��ʮ����������2 =< a��b <= 16��
    ���ݿ��ܴ��ڰ���ǰ����������
�����
    �����ж���������ݣ�����ÿ�����ݣ��������һ�У�������һ������Ϊת�����b�����������ʱ��ĸ����ȫ���ô�д��ʾ��
	����0��1��...��9��A��B��...��F����
�������룺
15 Aab3 7
���������
210306
��ʾ��
�������ַ�����ʾ��ͬ���Ƶ�������
��Դ��
2008�걱����ѧͼ��ʵ���Ҽ�����о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7841-1-1.html


*/
Status numericalSys(char strOrg[N],char strTo[N],int from,int to)
{
	int i=0,j=0,k=0;
	int strTemp[N];//����Ϊint Ҫ��Ȼ����̫��������  ��Ϊchar���Ϊ127
	int strOrgLen=strlen(strOrg);
	int n=0;
	char c;
	//��Ҫ��ת�����ַ�����ԭʼ�ַ���ת��Ϊ�Ͷ�Ӧ��ʮ������ȵ�ֵ����strTemp��
	while(strOrg[i]!='\0')
	{
		if(isdigit(strOrg[i]))
		{
			strTemp[j]=strOrg[i]-'0';
		}
		else if(isxdigit(strOrg[i]))
		{
			strTemp[j]=toupper(strOrg[i])-'A'+10;
		}
		j++;
		i++;
	}

	strTemp[j]='\0';

	while(n<strOrgLen)
	{
		for(i=n;i<strOrgLen-1;i++)
		{
			if(strTemp[i]%to)
			{
				strTemp[i+1]+=(strTemp[i]%to)*from;	
			}
			strTemp[i]/=to; 
		}
		strTo[k]=strTemp[strOrgLen-1]%to; 
		strTemp[strOrgLen-1]/=to;	
		if(strTo[k]<=9)
		{
			strTo[k]=strTo[k]+'0';
		}
		else
		{
			strTo[k]=strTo[k]+'A'-10;
		}
		k++;
		if(strTemp[n]==0)
		{
			n++;
		}	
	}
	//��õĽ����ʵ��˳��պ��෴
	i=0;
	strTo[k]='\0';
	k--;

	//����ǰ����
	while(strTo[k]=='0'&&k>0)
	{
		strTo[k]=strTo[k+1];
		k--;
	}

	while(i<k)//��ת��
	{
		c=strTo[i];
		strTo[i]=strTo[k];
		strTo[k]=c;
		i++;
		k--;
	}
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	char strOrg[N];
	char strTo[N];
	int from;
	int to;

	while(scanf("%d %s %d",&from,strOrg,&to)!=EOF)//while 1#
	{
		numericalSys(strOrg,strTo,from,to);
		printf("%s\n",strTo);
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