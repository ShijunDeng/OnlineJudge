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

//#define M 1000
#define N 1100

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1170������С��
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��5387�����2383
��Ŀ������
��һ������һ����n��1 <= n <= 1000����������n�����ݣ�ÿһ�������������ֱ���x y�����һ��x y����������������������x��С��
����x��ȵ������y��С�ġ� 
���룺
�����ж������ݡ�
ÿ������n��Ȼ������n�������ԡ�
�����
�����С�������ԡ�
�������룺
5  
3 3  
2 2  
5 5  
2 1  
3 6
���������
2 1
��Դ��
2010�걱���ʵ��ѧ������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7893-1-1.html

*/

int data[N][2];
Status searchMin(int n)
{
	int i=0;
	int j=0;
	int temp=0;
	Boolean flag=TRUE;
	for(i=0;i<n&&TRUE==flag;i++)//����ð������
	{
		flag=FALSE;
		for(j=0;j<n-i-1;j++)
		{
			//�Ƚϣ����һ��x y����������������������x��С������x��ȵ������y��С�ġ� 
			if(data[j][0]>data[j+1][0] || ((data[j][0]==data[j+1][0])&&(data[j][1]>data[j+1][1])))
			{	//����Ԫ��
				temp=data[j][0];
				data[j][0]=data[j+1][0];
				data[j+1][0]=temp;

				temp=data[j][1];
				data[j][1]=data[j+1][1];
				data[j+1][1]=temp;
				//���ñ�־
				flag=TRUE;
			}
		}
	}
	printf("%d %d\n",data[0][0],data[0][1]);
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	int i=0,j=0;
	while(scanf("%d",&n)!=EOF)//while 1#
	{
		for(i=0;i<n;i++)
		{
			scanf("%d %d",*(data+i),*(data+i)+1);
		}

		searchMin(n);
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