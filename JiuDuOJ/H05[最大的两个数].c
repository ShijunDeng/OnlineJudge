#include<stdio.h>
#include<malloc.h>
#include<math.h>
#include<stdlib.h>
//#include<string.h>
//����״̬��
#define OK 0
#define ERROR -1
#define TRUE 1
#define FALSE 0
#define MININT -32768

typedef int ElemType;
typedef int Status;
typedef int Boolean;

/*
��Ŀ1200������������
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��2566�����661
��Ŀ������
    ����һ���������еľ����ҳ�ÿ��������������
���룺
    �����һ�а���һ������n(1<=n<=1000)��������������ÿ�а����������������һ���������еľ��󣬾���Ԫ��ȫ����������
�����
    �����ж���������ݣ�����ÿ�����ݣ�������������ĸ�ʽ��ÿ�������������������������������е�һ��������һ�����ж����ͬ��ֵ������ֵȡ��ֵС����һ����
    ���ʱҪ����ԭ���������˳�򣬼���ԭ��������ֵС�ģ�����������е���ֵ��ȻС��
�������룺
1
1  2   4  9  8
-1  4  9  8  8
12  9  8  7  0
7   8  9  7  0
���������
12 9 9 9 8 
7 8 9 8 8 
��ʾ��
ÿ�����ֺ��涼Ҫ���һ���ո�

*/

Status searchMax(int data[4][5])
{
	int i=0,j=0; 
	int maxs[5][2];
	for(j=0;j<5;j++)//for #1
	{
		maxs[j][0]=maxs[j][1]=MININT;
		for(i=0;i<4;i++)//end:for #2
		{	
			if(data[i][j]>maxs[j][0]&&data[i][j]>maxs[j][1])
			{
				if(maxs[j][1]>maxs[j][0])
				{
					maxs[j][0]=maxs[j][1];	
					maxs[j][1]=data[i][j];
				}
				else if(maxs[j][1]==maxs[j][0]&&maxs[j][1]==MININT)
				{
					maxs[j][0]=data[i][j];
				}
				else
				{
					maxs[j][1]=data[i][j];
				}
			}
			else if(data[i][j]>maxs[j][0]||data[i][j]>maxs[j][1])
			{
				if(data[i][j]>maxs[j][0])
				{
					maxs[j][0]=maxs[j][1];
					maxs[j][1]=data[i][j];
				}
				else //if(data[i][j]>maxs[j][1])
				{
					maxs[j][1]=data[i][j];
				}
			}
			
			//printf("%d ",data[i][j]);
		
		}//end:for #2	
	}//end:for #1

	for(i=0;i<2;i++)
	{
		for(j=0;j<5;j++)
		{
			printf("%d ",maxs[j][i]);
		}
		//printf("%d\n",maxs[j][i]);
	}
	return OK;
}


//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{

	int data[4][5];
	int n=0;
	int i=0,j=0;
	scanf("%d",&n);
	while(n>0)
	{
		for(i=0;i<4;i++)
		{
			for(j=0;j<5;j++)
			{
				scanf("%d",&data[i][j]);
			}
		}

		searchMax(data);
		n--;
	}
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