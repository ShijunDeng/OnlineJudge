#include<stdio.h>
#include<string.h>
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
��Ŀ1129��Skew��
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��653�����496
��Ŀ������
�� skew binary��ʾ��, �� k λ��ֵxk��ʾxk*(2k+1-1)�� 
ÿ��λ�ϵĿ���������0 �� 1�������һ������λ������2, 
����, 10120(skew) = 1*(25-1) + 0*(24-1) + 1*(23-1) + 2*(22-1) + 0*(21-1) = 31 + 0 + 7 + 6 + 0 = 44. 
ǰʮ��skew���� 0��1��2��10��11��12��20��100��101���Լ�102��
���룺
�������һ�л���У�ÿ�а���һ������n����� n = 0 ��ʾ�������������n��һ��skew��
�����
�����ж���������ݣ�����ÿһ�����룬
�������ʮ���Ʊ�ʾ��ת����ʮ���ƺ� n ������ 231-1 = 2147483647
�������룺
10120
200000000000000000000000000000
10
1000000000000000000000000000000
11
100
11111000001110000101101102000
0
���������
44
2147483646
3
2147483647
4
7
1041110737
��Դ��
2008�걱����ѧ����ʵ���Ҽ�����о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7852-1-1.html
�Ŷ�Online Judge�޸���HUSTOJ | ��ICP��09099636�� | �Ŷ�Online Judge��Ȩ����
*/
long skew(char *p)
{
	int strLen=strlen(p);
	long k=1<<strLen;

	long sum=0;	 
	while(*p!='\0')
	{
		if(*p=='1')
		{
			sum=sum+k-1;
		}
		else if(*p=='2')
		{
			sum=sum+(k<<1)-2;
		}
		k=k>>1;
		p++;
	}
	return sum;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	char str[N];
	scanf("%s",str);
	while(strcmp(str,"0"))//while 1#
	{
		printf("%d\n",skew(str));
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