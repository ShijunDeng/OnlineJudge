//�� �ݹ��������ճ̱�����
#include<stdio.h>
#define MAXSIZE 32
#define OK 1
#define ERROR 0
int table [MAXSIZE+1][MAXSIZE+1];//�����ճ̱�

int dimidiate(int size)
{
	int i,j,row,column;
	 
	if(size >MAXSIZE)
		return ERROR;

	for(i=1;i<=size;i++)
	{
		table[1][i]=i;//��ʼ����һ��
	}

	for(i=1;i<size;i*=2)//���ƹ�ģ
	{
		for(j=1;j<size;j+=2*i)
		{
			for(row=i+1;row<=2*i;row++)
			{
				for(column=j;column<j+i;column++)
				{
					table[row][column]=table[row-i][column+i];
					table[row][column+i]=table[row-i][column];	
				}
			}
		}
	}

	return OK;
}
int service()
{
	int i,j,size;

	printf("size:");
	scanf("%d",&size);

	if(OK== dimidiate(size))
	{
		for(i=1;i<=size;i++)
		{
			for(j=1;j<=size;j++)
			{
				printf("%6d",table[i][j]);
			}
			printf("\n");
		}
		return OK;
	}
	else
		return ERROR;

}

int main()
{
	service();
	return OK;
}