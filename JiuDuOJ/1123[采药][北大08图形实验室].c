#include<stdio.h>
//#include<string.h>
//#include<malloc.h>
#include<math.h>
//����״̬��
#define OK 1
#define ERROR 0

#define TRUE 1
#define FALSE 0

typedef int Status;
typedef int Boolean;

#define M 1000
#define N 1005

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1123����ҩ
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��2111�����1031
��Ŀ������
�����Ǹ�����Ǳ�ܡ����ʴ�ӱ�ĺ��ӣ����������ǳ�Ϊ��������ΰ���ҽʦ��
Ϊ�ˣ�����ݸ�������������ҽʦΪʦ��ҽʦΪ���ж��������ʣ���������һ�����⡣
ҽʦ�����������������ǲ�ҩ��ɽ�������˵��
"���ӣ����ɽ������һЩ��ͬ�Ĳ�ҩ����ÿһ�궼��ҪһЩʱ�䣬ÿһ��Ҳ��������ļ�ֵ��
�һ����һ��ʱ�䣬�����ʱ�������Բɵ�һЩ��ҩ���������һ�������ĺ��ӣ���Ӧ�ÿ����òɵ��Ĳ�ҩ���ܼ�ֵ���"
������ǳ���������������������
���룺
����ĵ�һ������������T��1 <= T <= 1000����M��1 <= M <= 100����T�����ܹ��ܹ�������ҩ��ʱ�䣬M����ɽ����Ĳ�ҩ����Ŀ��
��������M��ÿ�а���������1��100֮�䣨����1��100���ĵ��������ֱ��ʾ��ժĳ���ҩ��ʱ��������ҩ�ļ�ֵ��
�����
�����ж���������ݣ�����ÿ�����ݣ�
���ֻ����һ�У���һ��ֻ����һ����������ʾ�ڹ涨��ʱ���ڣ����Բɵ��Ĳ�ҩ������ܼ�ֵ�� 
�������룺
70 3
71 100
69 1
1 2
���������
3
��Դ��
2008�걱����ѧͼ��ʵ���Ҽ�����о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7846-1-1.html
*/
/*
int table[N][2]:��ժĳ���ҩ��ʱ��������ҩ�ļ�ֵ
int category:ҩ�������
int limit:ʱ������
*/
int handleFunction(int table[M][2],int category,int limit)
{
	int bonus[N];
	int i=0,j=0;
	for(i=0;i<N;i++)
	{
		bonus[i]=0;
	}
	for(j=0;j<category;j++)
	{
		for(i=limit;i>=table[j][0];i--)
		{
			if(bonus[i-table[j][0]]+table[j][1]>bonus[i])
				bonus[i]=bonus[i-table[j][0]]+table[j][1];
		}
	}
	return bonus[limit];
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int table[M][2];
	int category;
	int limit;
	int i=0;
	while(scanf("%d %d",&limit,&category)!=EOF)//while 1#
	{
		for(i=0;i<category;i++)
		{
			scanf("%d %d",&table[i][0],&table[i][1]);
		}
		printf("%d\n",handleFunction(table,category,limit));
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
