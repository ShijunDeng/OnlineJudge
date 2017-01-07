#include<stdio.h>
//#include<string.h>
//#include<malloc.h>
#include<math.h>
//����״̬��
#define OK 1
#define ERROR 0

#define TRUE 1
#define FALSE 0

typedef int Status;
typedef int Boolean;

#define M 10000
#define N 200
#define INF 0xffffffff
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1144��Freckles
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��1136�����570
��Ŀ������
    In an episode of the Dick Van Dyke show, little Richie connects the freckles on his Dad's back to form a picture of the Liberty Bell.
	Alas, one of the freckles turns out to be a scar, so his Ripley's engagement falls through. 
    Consider Dick's back to be a plane with freckles at various (x,y) locations. Your job is to tell Richie how to connect the dots 
	so as to minimize the amount of ink used. Richie connects the dots by drawing straight lines between pairs, 
	possibly lifting the pen between lines. When Richie is done there must be a sequence of connected lines from 
	any freckle to any other freckle. 
���룺
    The first line contains 0 < n <= 100, the number of freckles on Dick's back. For each freckle, a line follows; 
	each following line contains two real numbers indicating the (x,y) coordinates of the freckle.
�����
    Your program prints a single real number to two decimal places: the minimum total length of ink lines that can 
	connect all the freckles.
�������룺
3
1.0 1.0
2.0 2.0
2.0 4.0
���������
3.41
��Դ��
2009�걱����ѧ������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7867-1-1.html

*/

double points[N][2];//��
double lines[M][3];//ֱ��
Boolean visitedL[M];
Boolean visitedV[N];
Status handleFunction(int num)
{
	int i=0,j=0,k=0,l=0;
	int linesNum=0;
	int vNum=0;
	double sum=0.0;
	double minLen=0.0;
	int minLIndex=0;
	int x1=0,x2=0;
	int mx1=0,mx2=0;
	for(i=0;i<num-1;i++)
	{
		visitedV[i]=FALSE;
		for(j=i+1;j<num;j++)
		{
			//��¼ֱ�ߵ�����
			lines[linesNum][0]=i;
			lines[linesNum][1]=j;
			//��ֱ�ߵĳ���
			lines[linesNum][2]=sqrt((points[i][0]-points[j][0])*(points[i][0]-points[j][0])+(points[i][1]-points[j][1])*(points[i][1]-points[j][1]));
		//	printf("%lf\n",lines[linesNum][2]);
			visitedL[linesNum]=FALSE;//���ʱ��
			linesNum++;
		}
	}	

	visitedV[i]=FALSE;
	k=0;//��һ�����ʽڵ�
	visitedV[k]=TRUE;
	vNum=1;
	while(vNum<num)//while 1#
	{
		minLen=INF;
		minLIndex=-1;
		for(l=0;l<linesNum;l++)
		{
			if(visitedL[l]==TRUE||lines[l][2]>minLen)
				continue;
			x1=(int)lines[l][0];
			x2=(int)lines[l][1];
			if( (visitedV[x1]==FALSE&&visitedV[x2]==TRUE)||(visitedV[x1]==TRUE&&visitedV[x2]==FALSE) )
			{
				minLen=lines[l][2];//ѡ����С�ı�
				minLIndex=l;
				mx1=x1;
				mx2=x2;
			}
		}
		if(minLIndex!=-1)
		{
			sum+=minLen;	
			//����Ѿ�����
			visitedL[minLIndex]=TRUE;
			visitedV[mx1]=visitedV[mx2]=TRUE;
			vNum++;
		}
		
	}//end:while 1#

	printf("%.2lf\n",sum);
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	int i=0;
	while(scanf("%d",&n)!=EOF)//while 1#
	{
		for(i=0;i<n;i++)
		{
			scanf("%lf %lf",&points[i][0],&points[i][1]);
		}
		handleFunction(n);
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