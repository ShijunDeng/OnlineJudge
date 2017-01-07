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
#define N 1000

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1145��Candy Sharing Game
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��203�����163
��Ŀ������
    A number of students sit in a circle facing their teacher in the center. Each student initially has an even 
	number of pieces of candy. When the teacher blows a whistle, each student simultaneously gives half of his 
	or her candy to the neighbor on the right. Any student, who ends up with an odd number of pieces of candy, 
	is given another piece by the teacher. The game ends when all students have the same number of pieces of candy.
    Write a program which determines the number of times the teacher blows the whistle and the final number of 
	pieces of candy for each student from the amount of candy each child starts with. 
���룺
    The input may describe more than one game. For each game, the input begins with the number N of students,
	followed by N (even) candy counts for the children counter-clockwise around the circle. The input ends with 
	a student count of 0. Each input number is on a line by itself. 
�����
    For each game, output the number of rounds of the game followed by the amount of candy each child ends up with,both on one line. 
�������룺
6
36 2 2 2 2 2
11
22 20 18 16 14 12 10 8 6 4 2
4
2 4 6 8
0
���������
15 14
17 22
4 8
��ʾ��
The game ends in a finite number of steps because:
1. The maximum candy count can never increase.
2. The minimum candy count can never decrease.
3. No one with more than the minimum amount will ever decrease to the minimum.
4. If the maximum and minimum candy count are not the same, at least one student with the minimum amount must have their count increase 
��Դ��
2009�걱����ѧ������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7868-1-1.html

*/
Status handleFunction(int data[N],int num)
{
	int i=0,j=0;
	int rounds=0;
	Boolean roundAd=FALSE;
	Boolean doing=TRUE;
	int cData[N];
	int *cpData=cData;
	int *pData=data;

	doing=FALSE;
	for(j=0;j<num-1;j++)//���
	{
		if(pData[j]!=pData[j+1])
		{
			doing=TRUE;
			break;
		}
	}	//���
	if(doing==FALSE)
	{
		printf("%d %d\n",rounds,pData[0]);
		return OK;
	}
	
	for(i=0;i<num;i++)
	{
		cpData[i]=pData[i];
	}

	while(doing==TRUE)//while 1#
	{	
		for(i=0;i<num;i++)//for 1#
		{
			cpData[(i+1)%num]=(cpData[(i+1)%num]>>1)+(pData[i]>>1);
		}//end:for 1#
		rounds++;
		doing=FALSE;
		for(j=0;j<num-1;j++)//���
		{
			if(cpData[j]!=cpData[j+1])
			{
				doing=TRUE;
				break;
			}
		}	//���
		if(doing==FALSE)
		{
			printf("%d %d\n",rounds,cpData[0]);
			return OK;
		}

		roundAd=FALSE;
		for(i=0;i<num;i++)//for 1#
		{	
			if(cpData[i]%2!=0)
			{
				cpData[i]++;
				roundAd=TRUE;
			}
			pData[i]=cpData[i];
		}//
		doing=FALSE;
		for(j=0;j<num-1;j++)//���
		{
			if(cpData[j]!=cpData[j+1])
			{
				doing=TRUE;
				break;
			}
		}	//���
		if(doing==FALSE)
		{
			printf("%d %d\n",rounds,cpData[0]);
			return OK;
		}
		
	
	}//end:while 1#
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	int i=0;
	int data[N];
	scanf("%d",&n);
	while(n!=0)//while 1#
	{
		for(i=0;i<n;i++)
		{
			 scanf("%d",data+i);
		}
		handleFunction(data,n);
		scanf("%d",&n);
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