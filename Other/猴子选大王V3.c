//����ѡ����:����������Ϣָ����һֻ���ӵ�����
#include<stdio.h>
#define MAXSIZE 32
#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0
#define STEP 3

int choose(int number,int startIndex)
{ 
	int table[MAXSIZE];//������Ԫ�ص�ֵָ����һֻ���ӵ�λ��
	int i=0;

	int last=-1;//��¼��һֻ���ӵ�λ��,��ֵ��Ϊ-1
	int current=startIndex;//��¼��ǰ������λ��
	
	if(number > MAXSIZE)
		return ERROR;

	for(i=0;i<number;i++)
	{
		table[i]=i+1;//�������е�Ԫ��ָ����һֻ���ӵ�λ��
	}

	table[number-1]=0;//���һ��Ԫ�ص��¸�λ����0��Ԫ��

	while(last!=current)//�����л��к���
	{
		for(i=0;i<STEP-1;i++)
		{
			last=current;
			current=table[current];
		}

		table[last]=table[current];//��ѡ�еĺ��ӳ��� �����µ�ǰ����Ϣ
		current=table[current];
	}//end:while
	
	return current==0? number:current+1;

}

//ҵ���߼�:�������� ������⺯�� ������
int service()
{
	int number,startIndex,king;

	printf("input number,startIndex:");
	scanf("%d %d",&number,&startIndex);

	king=choose(number,startIndex-1);
	if(king==ERROR)
	{
		printf("ERROR!\n");
	}
	else
	{
		printf("KING:%d\n",king);
	}
	

}

int main()
{
	service();

	return OK;
}