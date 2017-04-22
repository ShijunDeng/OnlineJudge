#include<stdio.h>
#include<string.h>
//#include<malloc.h>
//#include<math.h>
//����״̬��
#define OK 0
#define ERROR -1

#define TRUE 1
#define FALSE 0


typedef int Status;
typedef int Boolean;

typedef int ElemType;

#define M 40

const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1154��Jungle Roads
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��652�����434
��Ŀ������
   
    The Head Elder of the tropical island of Lagrishan has a problem. A burst of foreign aid money was spent on 
	extra roads between villages some years ago. But the jungle overtakes roads relentlessly, so the large road 
	network is too expensive to maintain. The Council of Elders must choose to stop maintaining some roads. 
	The map above on the left shows all the roads in use now and the cost in aacms per month to maintain them. 
	Of course there needs to be some way to get between all the villages on maintained roads, even if the route 
	is not as short as before. The Chief Elder would like to tell the Council of Elders what would be the smallest 
	amount they could spend in aacms per month to maintain roads that would connect all the villages. The villages
	are labeled A through I in the maps above. The map on the right shows the roads that could be maintained most 
	cheaply, for 216 aacms per month. Your task is to write a program that will solve such problems.
���룺
    The input consists of one to 100 data sets, followed by a final line containing only 0. Each data set starts 
	with a line containing only a number n, which is the number of villages, 1 < n < 27, and the villages are labeled
	with the first n letters of the alphabet, capitalized. Each data set is completed with n-1 lines that start 
	with village labels in alphabetical order. There is no line for the last village. Each line for a village starts
	with the village label followed by a number, k, of roads from this village to villages with labels later in the 
	alphabet. If k is greater than 0, the line continues with data for each of the k roads. The data for each road 
	is the village label for the other end of the road followed by the monthly maintenance cost in aacms for the road.
	Maintenance costs will be positive integers less than 100. All data fields in the row are separated by single blanks.
	The road network will always allow travel between all the villages. The network will never have more than 75 roads.
	No village will have more than 15 roads going to other villages (before or after in the alphabet). In the sample input 
	below, the first data set goes with the map above.
�����
    The output is one integer per line for each data set: the minimum cost in aacms per month to maintain a 
	road system that connect all the villages. Caution: A brute force solution that examines every possible 
	set of roads will not finish within the one minute time limit.
�������룺
9
A 2 B 12 I 25
B 3 C 10 H 40 I 8
C 2 D 18 G 55
D 1 E 44
E 2 F 60 G 38
F 0
G 1 H 35
H 1 I 35
3
A 2 B 10 C 40
B 1 C 20
0
���������
216
30
��Դ��
2010�걱����ѧ������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7877-1-1.html

*/

ElemType adjMatrix[M][M];//�ڽӾ���
Boolean visited[M];//����Ƿ����
ElemType lowc[M]; //����ǰ�ڵ���۵���Сֵ
ElemType prime(ElemType cost[][M],int n)
{
	int i=0,j=0;
	ElemType minCost=MAXINT;//�ҵ�����С����ֵ
	int minp=-1;//��С����ֵ�Ķ���
	ElemType sum=0;//��ǰ��С���ۺ�

	for(j=0;j<n;j++)
	{
		lowc[j]=cost[0][j];//��ʼ����С����
		visited[j]=FALSE;//��ʼ�����нڵ�δ����memset(visited,FALSE,n);
	}

	visited[0]=TRUE;
	for(i=1;i<n;i++)//for 1#
	{
		minCost=MAXINT;
		minp=-1;
		for(j=0;j<n;j++)//for 2#
		{
			if(visited[j]==FALSE&&lowc[j]<minCost)
			{
				minCost=lowc[j];
				minp=j;
			}		
		}//end:for 2#

		if(minp==-1)
		{
			return ERROR;//���ڲ���ͨ�Ľڵ�
		}
	
		sum+=minCost;
		visited[minp]=TRUE;

		for(j=0;j<n;j++)
		{
			if(visited[j]==FALSE&&lowc[j]>cost[minp][j])
			{
				lowc[j]=cost[minp][j];
			}
		}
	}//end:for 1#
	return sum;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	int i=0,j=0,k;
	ElemType cos=0;
	int from=0,to=0;
	char villageF,villageT;
	while(scanf("%d",&n),n)//while 1#
	{
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				if(i==j)
				{
					adjMatrix[i][j]=0;
				}
				else
				{
					adjMatrix[i][j]=MAXINT;
				}
			}
		}
		for(i=0;i<n-1;i++)
		{
			getchar();
			scanf("%c %d",&villageF,&k);
			from=villageF-'A';
			for(j=0;j<k;j++)
			{
				getchar();
				scanf("%c %d",&villageT,&cos);
				adjMatrix[villageT-'A'][from]=adjMatrix[from][villageT-'A']=cos;
			}
		}
		printf("%d\n",prime(adjMatrix,n));
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