#include<stdio.h>
//#include<string.h>
//#include<malloc.h>
//#include<math.h>
//����״̬��
#define OK 0
#define ERROR -1

#define TRUE 1
#define FALSE 0

typedef int Status;
typedef int Boolean;

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��2089�����1340
��Ŀ������
����һ��������a���Լ������5���������������ǣ���5�������У�С��a�������ĺ��Ƕ��٣�
���룺
����һ�У�ֻ����6��С��100�������������е�һ������������a��
�����
�����ж���������ݣ�����ÿ�����ݣ�
���һ�У�����һ������������5������С��a�����ĺ͡�
�������룺
10 1 2 3 4 11
���������
10
��Դ��
2008�걱����ѧͼ��ʵ���Ҽ�����о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7838-1-1.html
�Ŷ�Online Judge�޸���HUSTOJ | ��ICP��09099636�� | �Ŷ�Online Judge��Ȩ����
*/

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	int i=0,k,sum=0;
	
	scanf("%d",&n);
	for(i=0;i<5;i++)
	{
		scanf("%d",&k);	
		if(k<n)
			sum+=k;
	}
	printf("%d\n",sum);
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