#include<stdio.h>

#define OK 0
#define ERROR -1

typedef int Status;
/*

��Ŀ������
N��¥����¥���⣺һ�ο��������׻�һ�ף����ж�������¥��ʽ����Ҫ����÷ǵݹ飩
���룺
�������һ������N,(1<=N<90)��
�����
�����ж���������ݣ�����ÿ�����ݣ�
�����¥�ݽ�����Nʱ����¥��ʽ������
�������룺
4
���������
5

�Ķ�仰��ÿ�仰ռһ�С�

*/

long long  f(long long  n)
{
	long long  k=n;
	long long  a=1,b=2;

	if(n==1)
		return 1;
	if(n==2)
		return 2;
	while(n>2)
	{
		a=a+b;
		n--;
		if(n==2)
			return a;
		b=a+b;
		n--;
	}
	return b;
}
//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{

	long long n=0;
	while(scanf("%ld",&n)!=EOF)
	{
		printf("%ld\n",f(n));
	}
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