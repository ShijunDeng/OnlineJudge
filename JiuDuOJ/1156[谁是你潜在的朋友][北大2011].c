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

//#define M 1000
#define N 300

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1156��˭�����Ǳ������
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��4383�����2030
��Ŀ������
    "��ζ��Ͷ"--����������������ʱϲ���õĴʻ㡣������������ͨ����ζ�����Ǵ�������๲ͬ����Ȥ��Ȼ����Ϊһ��լ�У�
	�㷢���Լ��������໥�˽�Ļ��Ტ��̫�ࡣ���˵��ǣ�������õ���һ�ݱ���ͼ��ݵ�ͼ����ļ�¼�����������ư�ҹ�ر�̣�
	����з���Ǳ�ڵ����ѡ�
    ������Խ��ļ�¼������һ��������N���������α��Ϊ1,2,��,N����M�������α��Ϊ1,2,��,M��ͬʱ������"��ζ��Ͷ"��ԭ��
	����ϲ����ͬһ������ˣ��������Ǳ�����ѡ������ڵ������Ǵ���ݽ��ļ�¼�м����ÿ�����м���Ǳ�����ѡ�
���룺
    ÿ��������һ����������N,M��2 <= N ��M<= 200����������N�У���i(i = 1,2,��,N)��ÿһ����һ��������ʾ����i-1��ϲ����ͼ��ı��P(1<=P<=M)
�����
    ÿ����������N�У�ÿ��һ��������i�е�����ʾ����i�м���Ǳ�����ѡ����i���κ��˶�û�й�ͬϲ�����飬�����"BeiJu"�������磬^ ^��
�������룺
4  5
2
3
2
1
���������
1
BeiJu
1
BeiJu
��Դ��
2011�걱����ѧ������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7879-1-1.html
*/
Status searchFriend(int data[N],int num)
{
	int count[N];
	int i=0;

	memset(count,0,N);

	for(i=0;i<num;i++)
	{
		count[data[i]]++;
	}
	for(i=0;i<num;i++)
	{
		if(count[data[i]]>1)
		{
			printf("%d\n",count[data[i]]-1);
		}
		else
		{
			printf("BeiJu\n");
		}
	}
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int m,n=0;
	int i=0;
	int data[N];
	while(scanf("%d %d",&n,&m)!=EOF)//while 1#
	{
		memset(data,0,N);
		for(i=0;i<n;i++)
		{
			scanf("%d",data+i);
		}
		searchFriend(data,n);
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