#include<stdio.h>
#include<stdlib.h>
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

//#define M 1000
#define N 1000

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1116���Ӽ��˳�
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��1284�����797
��Ŀ������
����������������������������м򵥵��������㡣
�����ֻ���Ǽ�+����-����*����/������%���׳ˣ����������֮һ��
�������Ľ����������ֳ���Ϊ�㣬�����"error",�����������ĵڶ���������Ϊ0��Ҳ���"error"��
���룺
����Ϊһ�С��������һ���������ո������������Ȼ���ٿո�����ڶ����������س������������롣
��������Ϊ�׳ˣ����ţ�������ڶ���������ֱ�ӻس������������롣
�����
�����ж���������ݣ�����ÿ�����ݣ�
���һ�С�������������������һ��������������������������Ľ��������"error"��
�������룺
12 + 34
54 - 25
3 * 6
45 / 0
5 !
34 % 0
���������
46
29
18
error
120
error
��ʾ��
���㲻�ᳬ���������ݵķ�Χ��0!=1; ���������ж��顣
��Դ��
2008�걱����ѧͼ��ʵ���Ҽ�����о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7839-1-1.html
*/

int nMti(int n)
{
	int sum=1;
	while(n>0)
	{
		sum*=n;
		n--;
	}
	return sum;
}
Status calculate(char str[N])
{
	char paStr[N];
	char pbStr[N];
	int pa=0;
	int pb=0;
	char *operat;
	if((operat=strchr(str,'+'))!=NULL)
	{	
		strncpy(paStr,str,operat-str);
		strcpy(pbStr,operat+1);
		pa=atoi(paStr);
		pb=atoi(pbStr);
		printf("%d\n",pa+pb);
	}
	else if((operat=strchr(str,'-'))!=NULL)
	{	
		strncpy(paStr,str,operat-str);
		strcpy(pbStr,operat+1);
		pa=atoi(paStr);
		pb=atoi(pbStr);
		printf("%d\n",pa-pb);
	}
	else if((operat=strchr(str,'*'))!=NULL)
	{	
		strncpy(paStr,str,operat-str);
		strcpy(pbStr,operat+1);
		pa=atoi(paStr);
		pb=atoi(pbStr);
		printf("%d\n",pa*pb);
	}
	else if((operat=strchr(str,'/'))!=NULL)
	{	
		strncpy(paStr,str,operat-str);
		strcpy(pbStr,operat+1);
		pa=atoi(paStr);
		pb=atoi(pbStr);
		if(pb==0)
		{
			printf("error\n");
		}
		else
		{
			printf("%d\n",pa/pb);
		}
	}
	else if((operat=strchr(str,'%'))!=NULL)
	{	
		strncpy(paStr,str,operat-str);
		strcpy(pbStr,operat+1);
		pa=atoi(paStr);
		pb=atoi(pbStr);
		if(pb==0)
		{
			printf("error\n");
		}
		else
		{
			printf("%d\n",pa%pb);
		}
	}
	else if((operat=strchr(str,'!'))!=NULL)
	{	
		strncpy(paStr,str,operat-str);
		pa=atoi(paStr);
		printf("%d\n",nMti(pa));
	
	}
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	char str[N];

	while(gets(str)!=NULL)//while 1#
	{
		calculate(str);
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