#include<stdio.h>
//#include<string.h>
//#include<malloc.h>
//#include<math.h>
//����״̬��
#define OK 1
#define ERROR 0

#define TRUE 1
#define FALSE 0

typedef int Status;
typedef int Boolean;


//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1136��Number Steps
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��603�����371
��Ŀ������
Starting from point (0,0) on a plane, we have written all non-negative integers 0,1,2, ... as shown in the figure. 
For example, 1, 2, and 3 has been written at points (1,1), (2,0), and (3, 1) respectively and this pattern has continued.

You are to write a program that reads the coordinates of a point (x, y), and writes the number (if any) that has been written at that point.
x, y) coordinates in the input are in the range 0...5000.
���룺
The first line of the input is N, the number of test cases for this problem. In each of the N following lines, there is x, 
and y representing the coordinates (x, y) of a point.
�����
For each point in the input, write the number written at that point or write No Number if there is none.
�������룺
3
4 2
6 6
3 4
���������
6
12
No Number
��Դ��
2008�걱����ѧ�����������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7859-1-1.html
*/
int handleFunction(int x,int y)
{
	int xn=0,yn=0;
	xn=4*((int)x/2)+x%2;
	yn=4*((int)y/2)+x%2+2;
	if(x==y)
		return xn;
	if(x==(y+2))
		return yn;
	return -1;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	int i=0;
	int x=0,y=0;
	int num=0;
	while(scanf("%d",&n)!=EOF)//while 1#
	{
		for(i=0;i<n;i++)
		{
			scanf("%d %d",&x,&y);
			num=handleFunction(x,y);
			if(-1==num)
			{
				printf("No Number\n");
			}
			else
			{
				printf("%d\n",num);
			}
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