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
��Ŀ1067��n�Ľ׳�
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��5914�����2236
��Ŀ������
����һ������n�����n�Ľ׳�
���룺
һ������n(1<=n<=20)
�����
n�Ľ׳�
�������룺
3
���������
6
��Դ��
2001���廪��ѧ������о�����������(��II��)
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7791-1-1.html
 
*/
long long factorial(int n)
{
    int i=2;
    long long sum=1;
    while(i<=n)
    {
        sum*=i;
        i++;
    }
    return sum;
}
 
//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
    int n=0;
    while(scanf("%d",&n)!=EOF)//while 1#
    {
        printf("%lld\n",factorial(n));
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
/**************************************************************
    Problem: 1067
    User: xiaodeng1992
    Language: C
    Result: Accepted
    Time:0 ms
    Memory:912 kb
****************************************************************/
