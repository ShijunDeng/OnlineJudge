#include<stdio.h>
//����״̬��
#define OK 0
#define ERROR -1

#define TRUE 1
#define FALSE 0

typedef int Status;
typedef int Boolean;

#define N 1000

/*************************��Ŀ˵��********************/
/*
��Ŀ1173������
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��4281�����2383
��Ŀ������
�������鳤�� n 
��������      a[1...n] 
������Ҹ���m 
�����������b[1...m] 
 
��� YES or NO  ��������YES ����NO ��
���룺
�����ж������ݡ�
ÿ������n��Ȼ������n��������������m��Ȼ��������m��������1<=m<=n<=100����
�����
�����n�����������YES�������NO��
�������룺
5
1 5 2 4 3
3
2 5 6
���������
YES
YES
NO
��Դ��
2010�걱���ʵ��ѧ��Ժ�о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7896-1-1.html
*/

int data[N];
int length;
Boolean searchX(int x)
{
	int i=0;
	for(i=0;i<length;i++)
	{
		if(data[i]==x)
		{
			return TRUE;
		}
	}
	return FALSE;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int m=0,n=0;
	int i=0,j=0;
	int search[N];
	while(scanf("%d",&n)!=EOF)//while 1#
	{
		length=n;

		for(i=0;i<n;i++)
		{
			scanf("%d",data+i);
		}

		scanf("%d",&m);

		for(i=0;i<m;i++)
		{
			scanf("%d",search+i);
		}

		for(i=0;i<m;i++)
		{
			if(TRUE==searchX(search[i]))
				printf("YES\n");
			else 
				printf("NO\n");
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