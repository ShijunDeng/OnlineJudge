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

//#define M 1000
#define N 10

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1117��������ż����
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��2861�����835
��Ŀ������
����10���������˴��Կո�ָ������������Ժ����(Ҳ���ո�ָ�)��Ҫ��:
1.��������е�����,�����Ӵ�С���У�
2.Ȼ��������е�ż��,������С�������С�
���룺
���������10��������0��100�����˴��Կո�ָ���
�����
�����ж���������ݣ�����ÿ�����ݣ�����Ҫ�������������ɿո�ָ���
�������룺
4 7 3 13 11 12 0 47 34 98
���������
47 13 11 7 3 0 4 12 34 98
��ʾ��
1. �������ݿ����кܶ��飬��ʹ��while(cin>>a[0]>>a[1]>>...>>a[9])���Ƶ�������ʵ��;
2. ��������������п�����ȡ�
��Դ��
2008�걱����ѧͼ��ʵ���Ҽ�����о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7840-1-1.html
*/

int comp1(const void *a,const void *b)
{
	return *((int*)a)-*((int*)b);
}
int comp2(const void *a,const void *b)
{
	return comp1(b,a);
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	int i=0,o=0,e=0;
	int Od[N];
	int Ev[N];
	while(scanf("%d",&n)!=EOF)//while 1#
	{
		o=e=0;
		if(n%2==0)
			Ev[e++]=n;
		else
			Od[o++]=n;
		for(i=0;i<9;i++)
		{
			scanf("%d",&n);
			if(n%2==0)
				Ev[e++]=n;
			else
				Od[o++]=n;
		}
		qsort(Od,o,sizeof(int),comp2);
		qsort(Ev,e,sizeof(int),comp1);

		for(i=0;i<o-1;i++)
		{
			printf("%d ",Od[i]);
		}
		if(o>0&&e>0)
			printf("%d ",Od[i]);
		else if(o>0)
			printf("%d\n",Od[i]);
		for(i=0;i<e-1;i++)
		{
			printf("%d ",Ev[i]);
		}
		if(e>0)
			printf("%d\n",Ev[i]);	
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