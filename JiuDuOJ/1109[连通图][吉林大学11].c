#include<stdio.h>
#include<string.h>
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
#define N 1002

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1109����ͨͼ
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��2281�����1181
��Ŀ������
    ����һ������ͼ�����е����бߣ��ж����ͼ�Ƿ����ж��㶼����ͨ�ġ�
���룺
    ÿ�����ݵĵ�һ������������ n �� m��0<=n<=1000����n ��ʾͼ�Ķ�����Ŀ��m ��ʾͼ�бߵ���Ŀ��
	��� n Ϊ 0 ��ʾ�������������� m �����ݣ�ÿ��������ֵ x �� y��0<x, y <=n������ʾ���� x �� y ������
	����ı�Ŵ� 1 ��ʼ���㡣���벻��֤��Щ���Ƿ��ظ���
�����
    ����ÿ���������ݣ�������ж��㶼����ͨ�ģ����"YES"���������"NO"��
�������룺
4 3
1 2
2 3
3 2
3 2
1 2
2 3
0 0
���������
NO
YES
��Դ��
2011�꼪�ִ�ѧ������о�����������
*/

int data[N][N];
int vnum=0;	
int visited[N];//����Ƿ����	
int count=0;
Status DFS(int v)
{
	int k=0;
	count++;
	visited[v]=TRUE;

	if(count==vnum)
	{
		printf("YES\n");
		return OK;
	}

	for(k=1;k<=vnum;k++)
	{
		if(data[v][k]==1&&visited[k]==FALSE)
		{
			DFS(k);
		}
	}

	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0,m=0;
	int i=0;
	int x=0,y=0;
	while(scanf("%d %d",&n,&m),n)//while 1#
	{
		vnum=n;
		for(i=1;i<=n;i++)
		{
			memset(data[i],0,N);
		}
		memset(visited,FALSE,N);//���Ա�����ж���δ����
		count=0;
		for(i=1;i<=m;i++)
		{
			scanf("%d %d",&x,&y);
			data[x][y]=data[y][x]=1;
		}
		DFS(1);
		if(count<vnum)
		{
			printf("NO\n");
		}
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