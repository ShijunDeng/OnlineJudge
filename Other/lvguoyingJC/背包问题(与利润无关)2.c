//��������:�������޹�����
#include<stdio.h>
#include<malloc.h>
#include<math.h>

/* �������״̬���� */
#define TRUE 1
#define FALSE 0
#define OK 1
#define ERROR 0
#define INFEASIBLE -1
 

/* #define OVERFLOW -2 ��Ϊ��math.h���Ѷ���OVERFLOW��ֵΪ3,��ȥ������ */
typedef int Status; /* Status�Ǻ���������,��ֵ�Ǻ������״̬���룬��OK�� */
typedef int Boolean; /* Boolean�ǲ�������,��ֵ��TRUE��FALSE */


//ҵ���߼�:�������� ������⺯�� ������
int service()
{
	double i1,i2,i3,i4,i5,i6;
	double mi1,mi2,mi3,mi4,mi5,mi6;
	double sum=0.0;
	double maxSize=0.0;
	double size=10;

	for(i1=0;i1<=5;i1+=5)//#1
	{
		for(i2=0;i2<=2;i2+=2)//#2
		{
			for(i3=0;i3<=3.5;i3+=3.5)//#3
			{
				for(i4=0;i4<=1.7;i4+=1.7)//#4
				{
					for(i5=0;i5<=1;i5+=1)//#5
					{
						for(i6=0;i6<=5.1;i6+=5.1)//#6
						{
							sum=i1+i2+i3+i4+i5+i6;
						
							if(sum<size&&sum>maxSize)
							{
								maxSize=sum;
								mi1=i1;
								mi2=i2;
								mi3=i3;
								mi4=i4;
								mi5=i5;
								mi6=i6;
							}
						}//end:for #6
					}//end:for #5
				}//end:for #4
			}//end:for #3
		}//end:for #2
	}//end:for #1

	printf("maxWeight:%.2lf=%.2lf+%.2lf+%.2lf+%.2lf+%.2lf+%.2lf\n",maxSize,mi1,mi2,mi3,mi4,mi5,mi6);
	return OK;
}


/*
��������
 5 500
 300 400 500 600 700
*/
int main()
{
	if(ERROR==service())
	{
		printf("REEOR!\n");
	}
	return OK;
}