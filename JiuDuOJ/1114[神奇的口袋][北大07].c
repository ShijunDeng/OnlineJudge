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

typedef int ElemType;

#define M 40
#define N 1000

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1114������Ŀڴ�
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��788�����471
��Ŀ������
��һ������Ŀڴ����ܵ��ݻ���40��������ڴ����Ա��һЩ��Ʒ����Щ��Ʒ�������������40��John������n����Ҫ�õ�����Ʒ��
ÿ����Ʒ������ֱ���a1��a2����an��John���Դ���Щ��Ʒ��ѡ��һЩ�����ѡ����������������40����ô�����������Ŀڴ���
John�Ϳ��Եõ���Щ��Ʒ�����ڵ������ǣ�John�ж����ֲ�ͬ��ѡ����Ʒ�ķ�ʽ��
���룺
����ĵ�һ����������n (1 <= n <= 20)����ʾ��ͬ����Ʒ����Ŀ����������n�У�ÿ����һ��1��40֮������������ֱ����a1��a2����an��ֵ��
�����
�����ͬ��ѡ����Ʒ�ķ�ʽ����Ŀ��
�������룺
3
20
20
20
���������
3
��Դ��
2007�걱����ѧ������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7837-1-1.html
*/

int weights[N];
int count=0;
int trySelect(int sequence,int wayNum,int weight)
{
	int wayNum1=0;
	int wayNum2=0;
	if(sequence<count&&weight+weights[sequence]==M)
	{
		wayNum1=wayNum+1;
		wayNum2=trySelect(1+sequence,wayNum,weight);
		return wayNum1+wayNum2;
	}
	if(sequence==count)
	{
		return wayNum;
	}
	if(weight+weights[sequence]<M)
	{
		wayNum1=trySelect(1+sequence,wayNum,weight+weights[sequence]);
		wayNum2=trySelect(1+sequence,wayNum,weight);
		return wayNum1+wayNum2;
	}
	wayNum2=trySelect(1+sequence,wayNum,weight);
	return wayNum2;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int i=0;
	while(scanf("%d",&count)!=EOF)//while 1#
	{
		for(i=0;i<count;i++)
		{
			scanf("%d",weights+i);
		}
		printf("%d\n",trySelect(0,0,0));
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