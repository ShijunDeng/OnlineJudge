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
#define N 120

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1137���������ӷ�
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��2215�����628
��Ŀ������
��2����������ӵĺ�
��Ŀ����������г��ָ������������µ���ʽ��
P1P2...Pi.Q1Q2...Qj
�����������֣�P1P2...Pi��һ���Ǹ�����
����С�����֣�Qj������0
���룺
����ÿ�鰸������1���ǲ������ݵ�����n��ÿ���������ռ2�У��ֱ�������������
ÿ���������֮����һ�����У�ÿ�����ݲ�����100���ַ�
�����
ÿ�鰸����n�У�ÿ�����������һ���������Ӧ�ĺ͡�
�����֤һ����һ��С�����ֲ�Ϊ0�ĸ�����
�������룺
2
0.111111111111111111111111111111
0.111111111111111111111111111111
10000000.655555555555555555555555555555
1.444444444444444444444444444445
���������
0.222222222222222222222222222222
10000002.1
��Դ��
2008�걱����ѧ�����������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7860-1-1.html
*/
//��str1��str2�е�����ת��Ϊʮ����������ӣ���������str3��
Status add(char str1[N], char str2[N],char str3[N])
{
	int strLen1=strlen(str1);
	int strLen2=strlen(str2);
	char* pointP1=strchr(str1,'.');//�ַ�����С�����λ��
	char* pointP2=strchr(str2,'.');	
	char *p1=strchr(str1,'\0')-1;
	char *p2=strchr(str2,'\0')-1;
	
	int i1=p1-pointP1;//str1С����λ��
	int i2=p2-pointP2;//str2С����λ��
	int j1=strLen1-i1-1;//str1��������λ��
	int j2=strLen2-i2-1;//str2��������λ��
	int i=0;
	int j=0;
	int c=0;//��λ
	int sum=0;//ÿһλ��ӵĺ�

	//����͵�λ�������ֵ
	if(i1>i2)
	{
		i=i1;//
	}
	else
	{	
		i=i2;
	}
	if(j1>j2)
	{
		i+=j1;
	}
	else
	{	
		i+=j2;
	}

	i+=3;//��ֹ������� ��������һλ С��1λ ������һλ
	str3[i]='\0';
	i--;

	if(i1>i2)//���ַ���str1���ಿ��ֱ�Ӹ���str3
	{	
		while(i1>i2)
		{
			str3[i]=*p1;
			i1--;
			i--;
			p1--;
		}
	}
	else if(i1<i2)//���ַ���str2���ಿ��ֱ�Ӹ���str3
	{	
		while(i2>i1)
		{
			str3[i]=*p2;
			i2--;
			i--;
			p2--;
		}
	}
	while(p1!=pointP1)//����С������
	{
		sum=(*p1)+(*p2)-'0'-'0'+c;
		c=sum/10;
		str3[i]=sum%10+'0';
		p1--;
		p2--;
		i--;
	}

	str3[i]='.';//����С����
	i--;
	p1--;
	p2--;

	//while 1# �����������
	while(j2>=1&&j1>=1)
	{
		sum=(*p1)+(*p2)-'0'-'0'+c;
		c=sum/10;
		str3[i]=sum%10+'0';
		p1--;
		p2--;
		i--;
		j2--;
		j1--;
	}	
	//printf("%d %d %d\n",i,strLen1,strLen2);

	while(j1>=1)
	{
		sum=(*p1)-'0'+c;
		c=sum/10;
		str3[i]=sum%10+'0';
		p1--;
		i--;
		j1--;
	}

	while(j2>=1)
	{
		sum=(*p2)-'0'+c;
		c=sum/10;
		str3[i]=sum%10+'0';	
	
		p2--;	
		i--;
		j2--;
	}
	str3[i]=c+'0';
	i--;
	

	//printf("**%d %d %d\n",i,j1,j2);
	if(i==0)//����������� ��������һλ�����
	{
		i++;
		while(str3[i]!='\0')
		{
			str3[i-1]=str3[i];
			i++;
		}
		str3[i-1]=str3[i];	
	}
	i=strlen(str3)-1;
	 
	while(str3[i]=='0'&&(str3[i]!='.'))//����С�����ֶ���0�����
	{
		i--;
		
	}
	if(str3[i]=='.')
		str3[i+2]='\0';
	else
		str3[i+1]='\0';

	i=0;//�����ײ�����0�����
	while(str3[i]=='0')
	{
		i++;
	}
	j=0;
	if(str3[i]=='.')
		i--;
	while(str3[i]!='\0')
	{
		str3[j++]=str3[i++];
	}
	str3[j]='\0';
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	int i=0;
	char str1[N][N],str2[N],str3[N];
	while(scanf("%d",&n)!=EOF)//while 1#
	{
		for(i=0;i<n;i++)
		{
			scanf("%s%s",str1,str2);
			add(str1,str2,str3);
			printf("%s\n",str3);
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