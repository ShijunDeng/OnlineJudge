#include<stdio.h>
#include<string.h>
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
��Ŀ1464��Hello World for U
ʱ�����ƣ�1 ���ڴ����ƣ�128 ���������⣺���ύ��3896�����1087
��Ŀ������
Given any string of N (>=5) characters, you are asked to form the characters into the shape of U. For example, 
"helloworld" can be printed as:
h    d
e     l
l      r
lowo

That is, the characters must be printed in the original order, starting top-down from the left vertical line with n1 characters, 
then left to right along the bottom line with n2 characters, and finally bottom-up along the vertical line with n3 characters. 
And more, we would like U to be as squared as possible -- that is, it must be satisfied that
 n1 = n3 = max { k| k <= n2 for all 3 <= n2 <= N } with n1 + n2 + n3 - 2 = N.
���룺
There are multiple test cases.Each case contains one string with no less than 5 and no more than 80 characters in a line. 
The string contains no white space.
�����
For each test case, print the input string in the shape of U as specified in the description.
�������룺
helloworld!
ac.jobdu.com
���������
h   !
e   d
l   l
lowor
a    m
c    o
.    c
jobdu.
*/


Status printStr(char str[N])
{

	int i=0;
	int j=0;
	int k=0;
	int n=strlen(str);
	int vertical=(n+2)/3;//��ӡ���߿հ׵Ĵ���
	int space=n-2*vertical;

	//��ӡ����
	for(j=0;j<vertical-1;j++)
	{	
		printf("%c",str[i]);//��һ���ַ�
		for(k=0;k<space;k++)
		{
			printf(" ");//�м�Ŀհ�	
		}
		printf("%c\n",str[n-1-i]);//���һ���ַ�
		i++;
	}
	for(j=0;j<space+2;j++)
	{
		printf("%c",str[i++]);
	}
	printf("\n");
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	char str[N];
	while(scanf("%s",str)!=EOF)//while 1#
	{
		printStr(str);
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