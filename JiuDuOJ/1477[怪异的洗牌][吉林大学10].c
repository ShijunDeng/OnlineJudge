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
#define N 1200

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1477�������ϴ��
ʱ�����ƣ�1 ���ڴ����ƣ�128 ���������⣺���ύ��540�����200
��Ŀ������
        ����һ���˿��ƣ������ж��ֲ�ͬ��ϴ�Ʒ�ʽ��һ�ַ����Ǵ��м�ĳ��λ�÷ֳ����룬Ȼ���ཻ�������ǳ�֮Ϊ��λ��shift����
		����ԭ���Ĵ�����123456���ӵ�4��λ�ý������������561234�������ʽ��ʵ���������ѭ����λ��Ϊ�˶�ν������������
		����ʹ��һ�־����ܿ�ķ��������ʵ�֡��ڱ���Ŀ�У�����������һ��ϴ�Ʒ�ʽ�����ǰ�ǰһ�루�������������������(n-1)/2���Ʒ�ת������
		���ֲ�����֮Ϊ��ת��flip������ǰ��shift�����Ľ���Ͻ���flip���������165234����Ȼ�������ʵ�ʵ��˿��ƣ�ֱ�ӷ�ת��������������һ��ģ����ǾͲ�����ô���ˡ�
        ����n���ƣ���ʼ����Ϊ��1��n���������ɴε�shift��flip�����󣬽������ʲô����
���룺
�����������������ݣ�ÿ�����ݵĵ�һ�а��������� n��k��n��ʾ�Ƶ���Ŀ��1<n<1000�����nΪ0��ʾ���������k��ʾ����Ҫ���еĲ�������������k�У�ÿ��һ������x��1<=x<=n����ʾ�ӵڼ���λ�ÿ�ʼ��λ����ÿһ��shift�����󶼽�һ��flip������
�����
���������ÿ�����ݣ����㾭��������k��shift��flip�����󣬸���λ�õ���ֵ������������һ��������������ŵ�ֵ��ÿ����ֵ���������һ����������һ���ո�
�������룺
6 1
4
0 0
���������
1 6 5 2 3 4
*/

Status reversal(int data[N],int begin,int end)
{
	int temp=0;
	while(begin<end)
	{
		temp=data[begin];
		data[begin]=data[end];
		data[end]=temp;
		begin++;
		end--;
	}
	return OK;
}
Status shift(int data[N],int num,int start)
{
	reversal(data,0,num-1);
	reversal(data,0,num-start-1);
	reversal(data,num-start,num-1);
	return OK;
}

Status flip(int data[N],int num)
{
	if(num%2==0)
	{
		reversal(data,0,(num-1)/2);
	}
	else
	{
		reversal(data,0,num/2-1);
	}
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0,k=0;
	int i=0;
	int x=0;
	int data[N];
	scanf("%d %d",&n,&k);
	while(n)//while 1#
	{
		for(i=0;i<n;i++)
		{
			data[i]=i+1;
		}
		for(i=0;i<k;i++)
		{
			scanf("%d",&x);
			shift(data,n,x);
			flip(data,n);
		
		}	
		for(i=0;i<n;i++)
		{
			printf("%d ",data[i]);
		}
		printf("\n");
		scanf("%d %d",&n,&k); 
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