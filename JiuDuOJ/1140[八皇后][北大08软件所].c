#include<stdio.h>
//#include<string.h>
//#include<malloc.h>
#include<math.h>
//����״̬��
#define OK 0
#define ERROR -1

#define TRUE 1
#define FALSE 0

typedef int Status;
typedef int Boolean;
#define M 9
#define N 8

/*************************��Ŀ˵��********************/
/*
��Ŀ1140���˻ʺ�
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��665�����427
��Ŀ������
���¹���������˶���������ʺ�����ںᡢ����б���ϲ��޲����سԵ��������ӡ���ν�8���ʺ���������ϣ���8 * 8�����񣩣�
ʹ����˭Ҳ���ܱ��Ե�������������İ˻ʺ����⡣ 
����ĳ������Ҫ���8�ʺ�İڷŷ���������һ���ʺ�a��֮��Ӧ����a=b1b2...b8������biΪ��Ӧ�ڷ��е�i�лʺ�������������
�Ѿ�֪��8�ʺ�����һ����92��⣨��92����ͬ�Ļʺ󴮣���
����һ����b��Ҫ�������b���������ıȽ��������ģ��ʺ�x���ڻʺ�y֮ǰ�����ҽ�����x��Ϊ����ʱ��yС��
���룺
��1���ǲ������ݵ�����n���������n�����롣ÿ���������ռ1�У�����һ��������b(1 <= b <= 92)
�����
�����n�У�ÿ�������Ӧһ�����롣���Ӧ��һ�����������Ƕ�Ӧ��b�Ļʺ󴮡�
�������룺
2
1
92
���������
15863724
84136275
��Դ��
2008�걱����ѧ�����������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7863-1-1.html

*/

int pos[M];//�����ʺ���õ�λ��

//�����õ�λ���Ƿ�Ϸ�
Boolean check(int k)
{
	int i=1;
	while(i<k)
	{
		if(abs(pos[i]-pos[k])==abs(i-k) || pos[i]==pos[k])
		{
			return FALSE;
		}
		i++;
	}
	return TRUE;
}

Status backdate(int n)
{
	int i=0,k=1;
	int count=0;

	for(i=1;i<=N;i++)
	{
		pos[i]=0;//��ʼ����λ��
	}
	while(count<n)
	{
		pos[k]=pos[k]+1;
		while(check(k)==FALSE&&pos[k]<=N)
		{
			pos[k]=pos[k]+1;
		}
		if(pos[k]<=N)
		{	
			if(k==N)
			{
				count++;
			}
			else
			{
				k++;
				pos[k]=0;
			}
		}
		else
		{
			k--;
		}
	
	}
	for(i=1;i<=N;i++)
		printf("%d",pos[i]);
	printf("\n");
	return OK;
}



//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	int i=0;
	scanf("%d",&n);
	while(n>0)//while 1#
	{
		scanf("%d",&i);
		backdate(i);
		n--;
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