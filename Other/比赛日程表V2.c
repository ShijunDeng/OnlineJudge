//���ַ� �� �ݹ��������ճ̱�����
#include<stdio.h>
#define MAXSIZE 32
#define OK 1
#define ERROR 0
int table [MAXSIZE][MAXSIZE];//�����ճ̱�

int dimidiate(int size)
{
	int i,j,n=1,row,column,step;

	n =size;
	 
	if(n > MAXSIZE)
		return ERROR;

	for(i=0;i<size;i++)
	{
		table[i][0]=i+1;//��ʼ����һ��
	}

	for(i=2;i<=n;i*=2)//���ƹ�ģ
	{
		step=i/2; //���ֲ���

		for(j=0;j<n;j+=i)
		{
			for(row=j;row<j+step;row++)
			{
				for(column=step;column<i;column++)
				{
					table[row][column]=table[row+step][column-step];
					table[row+step][column]=table[row][column-step];
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
		for(i=0;i<size;i++)
		{
			for(j=0;j<size;j++)
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