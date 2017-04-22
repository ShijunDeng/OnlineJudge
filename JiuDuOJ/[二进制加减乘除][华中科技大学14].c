#include<stdio.h>
#include<string.h>
//#include<malloc.h>
#include<math.h>
//����״̬��
#define OK 0
#define ERROR -1

#define TRUE 1
#define FALSE 0

typedef int Status;
typedef int Boolean;

#define N 256

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*


*/
//���������ַ���ת��Ϊʮ�����޷�����
int bstrTodi(char *bstr)
{
	int strLen=strlen(bstr);
	int sum=0;
	int shift=1;
	int i=strLen-1;
	while(i>=0)
	{
		sum+=(*(bstr+i)-'0')*shift;
		shift=shift<<1;
		i--;
	}

	return sum;
}
//��ʮ������ת��Ϊ�������ַ���
Status diTobStr(int num,char str[N])
{	
	int i=0;
	int high=0,low=0;
	int fnum=(int)fabs(num);
	while(fnum>0)//��ʮ������ת��Ϊ�������ַ���
	{
		str[i++]=fnum%2+'0';
		fnum=fnum>>1;
	}
	if(num<0)
	{
		str[i++]='-';
	}
	str[i]='\0';
	high=i-1;
	//���ַ���ת��
	while(low<high)
	{
		i=str[low];
		str[low]=str[high];
		str[high]=i;
		low++;
		high--;
	}

	return OK;
}
Status handleFunction(char *opStr1,char *opStr2,char c)
{
	int op1=bstrTodi(opStr1);
	int op2=bstrTodi(opStr2);
	char reStr[N];
	int re=0;
	switch(c)
	{
		case '+':
			re=op1+op2;
			diTobStr(re,reStr);
			break;
		case '-':
			re=op1-op2;
			diTobStr(re,reStr);
			break;
		case '*':
			re=op1*op2;
			//printf("%d ",re);
			diTobStr(re,reStr);
			break;
		case '/':
			if(op2==0)
			{
				printf("parameter is illegal!\n");
				return ERROR;
			}
			re=(int)op1/op2;
			diTobStr(re,reStr);
			break;
		default:return OK;
	}
	printf("=%s\n",reStr);
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	char str1[N],str2[N],op[5];
	while(scanf("%s %s %s",str1,str2,op)!=EOF)//while 1#
	{
		handleFunction(str1,str2,op[0]);
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