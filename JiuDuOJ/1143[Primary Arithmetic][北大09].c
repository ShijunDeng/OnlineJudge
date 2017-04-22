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

//#define M 1000
#define N 20

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��543�����223
��Ŀ������
    Children are taught to add multi-digit numbers from right-to-left one digit at a time. 
	Many find the "carry" operation - in which a 1 is carried from one digit position to be 
	added to the next - to be a significant challenge. Your job is to count the number of carry 
	operations for each of a set of addition problems so that educators may assess their difficulty. 
���룺
    Each line of input contains two unsigned integers less than 10 digits. The last line of input contains 0 0.
�����
    For each line of input except the last you should compute and print the number of carry operations that 
	would result from adding the two numbers, in the format shown below.
�������룺
123 456
555 555
123 594
0 0
���������
NO carry operation.
3 carry operations.
1 carry operation.
��Դ��
2009�걱����ѧ������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7866-1-1.html


*/
Status handleFunction(char ad1[N],char ad2[N])
{
	int sum=0;
	int c=0;
	int adLen1=strlen(ad1)-1;
	int adLen2=strlen(ad2)-1;

	int count =0;

	while(adLen1>=0&&adLen2>=0)
	{
		sum=ad1[adLen1]+ad2[adLen2]-'0'-'0'+c;
		c=sum/10;
		sum/=10;
		count+=c; 
		adLen1--;
		adLen2--;
	}
	
	while(adLen1>=0)
	{
		sum=ad1[adLen1]-'0'+c;
		c=sum/10;
		sum/=10;
		count+=c;
		adLen1--;
	}
	
	while(adLen2>=0)
	{
		sum=ad2[adLen2]-'0'+c;
		c=sum/10;
		sum/=10;
		count+=c;
		adLen2--;
	}
	

	if(count==0)
	{
		printf("NO carry operation.\n");
	}
	else if(count==1)
	{
		printf("1 carry operation.\n");
	}
	else
	{
		printf("%d carry operations.\n",count);
	}
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	char ad1[N],ad2[N];

	scanf("%s %s",ad1,ad2);
	while(strcmp(ad1,"0")||strcmp(ad2,"0"))//while 1#
	{
		handleFunction(ad1,ad2);
		scanf("%s %s",ad1,ad2);
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