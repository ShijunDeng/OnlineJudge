#include<stdio.h>
#include<string.h>
//����״̬��
#define OK 0
#define ERROR -1
#define TRUE 1
#define FALSE 0
typedef int Status;
typedef int Boolean;
#define N 5000
/*
��Ŀ1188��Լɪ��
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��1660�����730
��Ŀ������
    N����Χ��һȦ˳���ţ���1�ſ�ʼ��1��2��3......˳��������p���˳�Ȧ�⣬��������ٴ�1��2��3��ʼ��������p�������˳�Ȧ�⣬�Դ����ơ�
    �밴�˳�˳�����ÿ���˳��˵�ԭ��š�
���룺
����һ������N(1<=N<=3000)��һ������p��
�����
�������ݿ����ж��飬����ÿһ�����ݣ�
���˳�˳�����ÿ���˳��˵�ԭ��š�
�������룺
7 3
���������
3 6 2 7 5 1 4

*/

int choose(int num,int step)
{
	int Q[N];//����
	int i=0;
	int current=0;//��ǰԪ�ص��±�
	int last=num-1;//���ʵ���һ��Ԫ�ص��±�
	int count=step;//��¼����
	//��ʼ������ ��ÿ��Ԫ�ص�ֵΪ���̵��±�
	if(num>N)
		return ERROR;
	for(i=0;i<num-1;i++)
	{
		Q[i]=i+1;
	}
	Q[num-1]=0;//��β�ɻ�

	while(last!=current)
	{
		count--;
		if(0==count)
		{	
			printf("%d ",current+1);
			Q[last]=Q[current];	
			count=step;
			current=Q[current];
		}
		else
		{
			last=current;
			current=Q[current];
		}
		
	}
	printf("%d\n",current+1);
	return current+1;//�����±��ʵ��˳�����1  
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{

	int num=0,step=0;
	while(scanf("%d %d",&num,&step)!=EOF)
	{
		choose(num,step);
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