//���Ʒ���������ճ̱�����
#include<stdio.h>
#define MAXSIZE 32
#define OK 1
#define ERROR 0
int table [MAXSIZE+1][MAXSIZE+1];//�����ճ̱�

int dimidiate(int size)
{
	int n,i1,i2,i3,j1,j2,j3;
	 
	if(size<0 ||size >MAXSIZE)//�����Ĳ������  �����쳣
		return ERROR;

	table[1][1]=1;//����ֵ

	for(n=1;n<size;n*=2)//��������Ĺ�ģ
	{
		for(i1=n+1;i1<=2*n;i1++)//�������½�����
		{
			for(j1=1;j1<=n;j1++)
			{
				table[i1][j1]=table[i1-n][j1]+n;
			}
		}

		for(i2=1;i2<=n;i2++)//�������Ͻ�����
		{
			for(j2=n+1;j2<=2*n;j2++)
			{
				table[i2][j2]=table[i2][j2-n]+n;
			}
		}

		for(i3=n+1;i3<=2*n;i3++)//�������½�����
		{
			for(j3=n+1;j3<=2*n;j3++)
			{
				table[i3][j3]=table[i3-n][j3]-n;
			}
		}
	}


	return OK;
}
//ҵ���߼�:�������� ������⺯�� ������
int service()
{
	int i,j,size;

	printf("size:");
	scanf("%d",&size);

	if(OK== dimidiate(size))//������⺯���ɹ�
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
		return ERROR;//��⺯���г��ִ��� �����������

}

int main()
{
	service();
	return OK;
}