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

//#define M 1000
//#define N 1000

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1171��C��ת
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��3938�����1282
��Ŀ������
��������һ��5 * 5�����飬Ȼ������һ�У���һ�����ĸ�����ǰ��������������ͣ���������x y�������������Ϊ��x yΪ���Ͻǵ��Ǽ������ݡ�
�������������֣�  
1 2 ��ʾ��90�ȣ�˳ʱ�룬��ת4����  
1 3 ��ʾ��90�ȣ�˳ʱ�룬��ת9����  
2 2 ��ʾ��90�ȣ���ʱ�룬��ת4����  
2 3 ��ʾ��90�ȣ���ʱ�룬��ת9���� 
���룺
�����ж������ݡ�
ÿ������һ��5 * 5�����飬Ȼ������һ�У���һ�����ĸ�����ǰ��������������ͣ���������x y�������������Ϊ��x yΪ���Ͻǵ��Ǽ������ݡ�
�����
�����ת������顣
�������룺
1 2 3 4 5
6 7 8 9 10
11 12 13 14 15
16 17 18 19 20
21 22 23 24 25
1 3 1 1
���������
11 6 1 4 5
12 7 2 9 10
13 8 3 14 15
16 17 18 19 20
21 22 23 24 25
��Դ��
2010�걱���ʵ��ѧ������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7894-1-1.html


*/
Status transepose(int data[6][6],int p1,int p2,int x,int y)
{
	int i=0,j=0;
	int d1=0;
	if(p1==1&&p2==2)//1 2 ��ʾ��90�ȣ�˳ʱ�룬��ת4����  
	{
		d1=data[x][y];
		data[x][y]=data[x+1][y];
		data[x+1][y]=data[x+1][y+1];
		data[x+1][y+1]=data[x][y+1];
		data[x][y+1]=d1;

	}
	else if(p1==1&&p2==3)//1 3 ��ʾ��90�ȣ�˳ʱ�룬��ת9����  
	{
		d1=data[x][y+2];
		data[x][y+2]=data[x][y+1];
		data[x][y+1]=data[x][y];

		data[x][y]=data[x+1][y];
		data[x+1][y]=data[x+2][y];
		data[x+2][y]=data[x+2][y+1];
		data[x+2][y+1]=data[x+2][y+2];
		data[x+2][y+2]=data[x+1][y+2];
		data[x+1][y+2]=d1;

		d1=data[x][y+2];
		data[x][y+2]=data[x][y+1];
		data[x][y+1]=data[x][y];

		data[x][y]=data[x+1][y];
		data[x+1][y]=data[x+2][y];
		data[x+2][y]=data[x+2][y+1];
		data[x+2][y+1]=data[x+2][y+2];
		data[x+2][y+2]=data[x+1][y+2];
		data[x+1][y+2]=d1;
	}
	else if(p1==2&&p2==2)//2 2 ��ʾ��90�ȣ���ʱ�룬��ת4����  
	{
		d1=data[x][y];
		data[x][y]=data[x][y+1];
		data[x][y+1]=data[x+1][y+1];
		data[x+1][y+1]=data[x+1][y];
		data[x+1][y]=d1;
	}
	else//2 3 ��ʾ��90�ȣ���ʱ�룬��ת9���� 
	{
		d1=data[x][y+2];
		data[x][y+2]=data[x+1][y+2];
		data[x+1][y+2]=data[x+2][y+2];
		data[x+2][y+2]=data[x+2][y+1];
		data[x+2][y+1]=data[x+2][y];	
		data[x+2][y]=data[x+1][y];
		data[x+1][y]=data[x][y];
		data[x][y]=data[x][y+1];
		data[x][y+1]=d1;
		
		d1=data[x][y+2];
		data[x][y+2]=data[x+1][y+2];
		data[x+1][y+2]=data[x+2][y+2];
		data[x+2][y+2]=data[x+2][y+1];
		data[x+2][y+1]=data[x+2][y];	
		data[x+2][y]=data[x+1][y];
		data[x+1][y]=data[x][y];
		data[x][y]=data[x][y+1];
		data[x][y+1]=d1;			
	}

	for(i=1;i<=5;i++)
	{
		for(j=1;j<=4;j++)
		{
			printf("%d ",data[i][j]);
		}
		printf("%d\n",data[i][j]);
	}
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	int i=0,j=0,k=0;
	int data[6][6];
	int tempdata[25];
	int p1=0,p2=0,x=0,y=0;
	while(scanf("%d",&n)!=EOF)//while 1#
	{
		k=0;
		tempdata[0]=n;
		for(i=1;i<25;i++)
		{
			scanf("%d",tempdata+i);
		}
		for(i=1;i<=5;i++)
		{
			for(j=1;j<=5;j++)
			{
				data[i][j]=tempdata[k++];
			}
		}
		scanf("%d %d %d %d",&p1,&p2,&x,&y);

		transepose(data,p1,p2,x,y);
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