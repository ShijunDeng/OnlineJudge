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
#define N 100

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1133��ѧ�ּ���
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��1204�����630
��Ŀ������
������ѧ�Ա������ĳɼ�ʩ��ƽ��ѧ�ּ����ƣ�GPA�����Ƚ�ѧ����ʵ�ʿ��ָ��ݲ�ͬ��ѧ�ƵĲ�ͬѧ�ְ�һ���Ĺ�ʽ���м��㡣
��ʽ���£�
ʵ�ʳɼ� ����
90--100 4.0
85--89 3.7
82--84 3.3
78--81 3.0
75--77 2.7
72--74 2.3
68--71 2.0
64--67 1.5
60--63 1.0
60���� 0
1��һ�ſγ̵�ѧ�ּ���=�ÿμ���*�ÿ�ѧ��
2����������=����ѧ�Ƽ���֮��/���пγ�ѧ��֮��
��Ҫ�����д�������ĳ��A���������㣨GPA����
���룺
��һ�� �ܵĿγ���n��n<10����
�ڶ��� ��Ӧ�γ̵�ѧ�֣�����ѧ�ּ��ÿո��������
������ ��Ӧ�γ̵�ʵ�ʵ÷֣�
�˴�������������־�Ϊ������
�����
�����һ�У��������㣬��ȷ��С�����2λС������printf("%.2f",GPA);��
�������룺
5
4 3 4 2 3
91 88 72 69 56
���������
2.52
��Դ��
2008�걱����ѧ�����������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7856-1-1.html

*/
double singlePoint(int score)
{
	if(score>=90&&score<=100)
	{
		return 4.0;
	}
	else if(score>=85&&score<=89)
	{
		return 3.7;
	}
	else if(score>=82&&score<=84)
	{
		return 3.3;
	}
	else if(score>=78&&score<=81)
	{
		return 3.0;
	}
	else if(score>=75&&score<=77)
	{
		return 2.7;
	}
	else if(score>=72&&score<=74)
	{
		return 2.3;
	}
	else if(score>=68&&score<=71)
	{
		return 2.0;
	}
	else if(score>=64&&score<=67)
	{
		return 1.5;
	}
	else if(score>=60&&score<=63)
	{
		return 1.0;
	}
	else
		return 0.0;
}

double handleFunction(int data[N][2],int n)
{
	double sum=0.0;
	int total=0;
	int i=0;
	for(i=0;i<n;i++)
	{
		sum=sum+data[i][0]*singlePoint(data[i][1]);
		total=total+data[i][0];
	}
	return sum/total;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	int i=0;
	int data[N][2];
	while(scanf("%d",&n)!=EOF)//while 1#
	{
		for(i=0;i<n;i++)
		{
			scanf("%d",&data[i][0]);\
		}
		for(i=0;i<n;i++)
		{
			scanf("%d",&data[i][1]);
		}
		printf("%.2lf\n",handleFunction(data,n));
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