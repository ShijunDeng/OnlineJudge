//�������������ѡ��������
#include<stdio.h>
#define MAXSIZE 32
#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0
#define STEP 3

int choose(int number,int startIndex)
{ 
	int count=0;//��¼�Ѿ����ֵĺ��ӵ�����
	int table[MAXSIZE];//ģ����ӵ�λ��:1��ʾ��λ���к���,0��ʾ��λ���ǿյ�
	int i=0;
	
	if(number > MAXSIZE)
		return ERROR;

	for(i=0;i<number;i++)//��ʼ������ ��ʾÿ��λ�ö��к���
	{
		table[i]=1;
	}

	i=0;

	while(count<number)
	{
		if(table[startIndex]==1)//��λ���к���
			i++;//������ֵ��һ

		if(i==STEP)//����STEP�ĺ����˳�
		{
			table[startIndex]=0;//���˳����
			//printf("%d ",startIndex+1);
			i=0;//��������������
			count++;//��������һ
		}
		
		startIndex++;//�������±��һ

		if(startIndex>=number)//һȦ����,ѭ����ͷ��ʼ
			startIndex=0;
	}//end:while
	return startIndex==0 ?number:startIndex;
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