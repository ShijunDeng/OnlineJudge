#include<stdio.h>

//����״̬��
#define OK 0
#define ERROR -1


typedef int Status;
/*
��Ŀ������
����n��
��y1=1!+3!+...m!(m��С�ڵ���n�����������
y2=2!+4!+...p!(p��С�ڵ���n�����ż��)��
���룺
ÿ���������1��������n
�����
�����ж���������ݣ�����ÿ�����ݣ�
�����ĿҪ���y1��y2
�������룺
4
���������
7 26
*/

/*
n:����ķ�Χn
oSum:y1=1!+3!+...m!(m��С�ڵ���n���������
eSum:y2=2!+4!+...p!(p��С�ڵ���n�����ż��)��
*/

Status factorial(int n,int *oSum,int*eSum)
{
	int y1=0,y2=0;//�����Ӧ�Ľ��
	int i=1;
	int sum=1;//����۳˽��


	while(i<n-1)
	{
		sum*=i;
		y1+=sum;

		i++;

		sum*=i;
		y2+=sum;

		i++;
	}

	if(n%2==0)//nΪż�� 
	{
		sum*=i;
		y1+=sum;

		i++;

		sum*=i;
		y2+=sum;
	}
	else//nΪ����
	{
		sum*=i;
		y1+=sum;
	}

	*oSum=y1;
	*eSum=y2;

	return OK;
}


//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	int oSum=0;
	int eSum=0;

	while(scanf("%d",&n)!=EOF)
	{
		factorial(n,&oSum,&eSum);
		printf("%d %d\n",oSum,eSum);
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