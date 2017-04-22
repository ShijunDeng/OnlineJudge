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

typedef int ElemType;

//#define M 1000
#define N 2000

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ������
    The digital root of a positive integer is found by summing the digits of the integer. 
	If the resulting value is a single digit then that digit is the digital root. 
	If the resulting value contains two or more digits, those digits are summed and the process is repeated.
	This is continued as long as necessary to obtain a single digit.

    For example, consider the positive integer 24. Adding the 2 and the 4 yields a value of 6. 
	Since 6 is a single digit, 6 is the digital root of 24. Now consider the positive integer 39. 
	Adding the 3 and the 9 yields 12. Since 12 is not a single digit, the process must be repeated.
	Adding the 1 and the 2 yeilds 3, a single digit and also the digital root of 39.
���룺
    The input file will contain a list of positive integers, one per line. 
    The end of the input will be indicated by an integer value of zero.
�����
    For each integer in the input, output its digital root on a separate line of the output.
�������룺
24
39
0
���������
6
3
��ʾ��
The integer may consist of a large number of digits.
��Դ��
2008�걱����ѧ����ʵ���Ҽ�����о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7847-1-1.html

*/

long handle(long data)
{
	int digits[N];
	int size=0;
	Boolean end=FALSE;
	long sum=0;
	int i=0;
	while(end==FALSE)
	{
		size=0;
		sum=0;	
		while(data>0)
		{
			digits[size++]=data%10;
			data=data/10;
		}
		for(i=0;i<size;i++)
		{
			sum+=digits[i];
		}
		if(sum<=9)
			end=TRUE;
		else
			data=sum;
	}

	return (int)sum;
}


int handleFunction(char str[N])
{
	long sum=0;
	int i=0;
	while(str[i]!='\0')
	{
		sum+=(str[i]-'0');
		i++;
	
	}
	if(sum<9)
		return sum;
	else
		return handle(sum);
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	char str[N];
	scanf("%s",str);
	while(strcmp(str,"0"))//while 1#
	{
		printf("%d\n",handleFunction(str));
		scanf("%s",str);
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