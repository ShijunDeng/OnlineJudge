#include<stdio.h>
//#include<string.h>
//#include<malloc.h>
#include<math.h>
//����״̬��
#define OK 0
#define ERROR -1

#define TRUE 1
#define FALSE 0

typedef int Status;
typedef int Boolean;

typedef int ElemType;

//#define M 1000
#define N 1000

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1113��������
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��3859�����1137
��Ŀ������
 

    ������ʾ����������1��2��3���������һ�������������������֪��������������һ�������n�����ڵ������ǣ�
	���m���ڵ�������һ���������ٸ���㡣

    ���磬n = 12��m = 3��ô��ͼ�еĽ��13��14��15�Լ�����Ľ�㶼�ǲ����ڵģ����m���������а����Ľ����3��6��7��12��
	��˽��m�����������й���4����㡣
���룺
    �������ݰ������У�ÿ�и���һ��������ݣ�������������m��n (1 <= m <= n <= 1000000000)��
	���һ����������а�������0����ʾ����Ľ������������ݲ��ô���
�����
    ����ÿһ��������ݣ����һ�У����а���һ���������������m���������а����Ľ�����Ŀ��
�������룺
3 12
0 0
���������
4
��Դ��
2007�걱����ѧ������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7836-1-1.html


*/
int  handleFunction(int m,int n)
{
	int levelCount=0;//�ڵ�Ϊ����Ĳ���
	int li=m,ri=m;
	int sum=1;
	while(li<n&&ri<n)
	{
		li=li<<1;
		ri=1+(ri<<1);
		levelCount++;
	}
	
	sum=(int)pow(2,levelCount)-1;//ǰ������Ľڵ���
	//printf("%d--\n",li);
	if(li<=n)
	{
		sum=sum+(n-li+1);
	}
	return sum;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int m=0,n=0;
	scanf("%d %d",&m,&n);
	while(!(m==0&&n==0))//while 1#
	{
		printf("%d\n",handleFunction(m,n));
		scanf("%d %d",&m,&n);
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