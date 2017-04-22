#include<stdio.h>
#include<ctype.h>
//#include<malloc.h>
//#include<math.h>
//����״̬��
#define OK 0
#define ERROR -1

#define TRUE 1
#define FALSE 0

typedef int Status;
typedef int Boolean;

typedef char ElemType;

//#define M 1000
#define N 1000

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*

��Ŀ1475��IP���ݰ�����
ʱ�����ƣ�1 ���ڴ����ƣ�128 ���������⣺���ύ��3044�����394
��Ŀ������
���Ƕ�ѧϰ����������磬֪�������IPЭ�����ݰ���ͷ����ʽ���£�
���� 
��������IHL��ʾIPͷ�ĳ��ȣ���λ��4�ֽڣ��ܳ���ʾ�������ݰ��ĳ��ȣ���λ��1�ֽڡ�
����������TCPЭ�����ݶε�ͷ����ʽ���£�
���� 
����ͷ�����ȵ�λΪ4�ֽڡ�
������������ǣ���Ҫ�������������е����ɸ�TCP���ݶε�ͷ���� ��ϸҪ���������������ֵ�˵����
���룺
��һ��Ϊһ������T������������ݵ�������
������T�У�ÿ�ж���һ��TCP���ݰ���ͷ���֣��ֽ���16���Ʊ�ʾ���Կո���������ݱ�֤�ֽ�֮�����һ���ո���������βû�ж���Ŀհ��ַ���
��֤�������ݶ��ǺϷ��ġ�
�����
����ÿ��TCP���ݰ������������Ϣ��
Case #x��x�ǵ�ǰ�������ݵ���ţ���1��ʼ��
Total length = L bytes��L������IP���ݰ��ĳ��ȣ���λ��1�ֽڡ�
Source = xxx.xxx.xxx.xxx���õ��ʮ�������ԴIP��ַ�����������в�����IPV6���ݷ��顣
Destination = xxx.xxx.xxx.xxx���õ��ʮ�������ԴIP��ַ�����������в�����IPV6���ݷ��顣
Source Port = sp��sp��Դ�˿ںš�
Destination Port = dp��dp��Ŀ��˿ںš�
����ÿ��TCP���ݰ���������һ������Ŀհ��С�
�����ʽ�μ�������
��ע�⣬�������Ϣ�У����еĿո񡢴�Сд������š����о�Ҫ��������ʽ����һ�£����Ҳ�Ҫ���κ�����ǰ��������ǰ��0��
Ҳ��Ҫ����κβ���Ҫ�Ŀհ��ַ���
�������룺
2
45 00 00 34 7a 67 40 00 40 06 63 5a 0a cd 0a f4 7d 38 ca 09 cd f6 00 50 b4 d7 ae 1c 9b cf f2 40 80 10 ff 3d fd d0 00 00 01 01 08 0a 32 53 7d fb 5e 49 4e c8
45 00 00 c6 56 5a 40 00 34 06 e0 45 cb d0 2e 01 0a cd 0a f4 00 50 ce 61 e1 e9 b9 ee 47 c7 37 34 80 18 00 b5 81 8f 00 00 01 01 08 0a 88 24 fa c6 32 63 cd 8d

���������
Case #1
Total length = 52 bytes
Source = 10.205.10.244
Destination = 125.56.202.9
Source Port = 52726
Destination Port = 80

Case #2
Total length = 198 bytes
Source = 203.208.46.1
Destination = 10.205.10.244
Source Port = 80
Destination Port = 52833
��Դ��
2012�걱���ʵ��ѧ������о�����������

*/

//ɾ��str�ַ���������ֵΪc���ַ�
Status deleteChar(ElemType *str,char c)
{
	int i=0,k=0;
	while(str[k]!='\0')
	{
		if(str[k]!=c)
		{
			str[i]=str[k];
			i++;
		}
		k++;
	}
	str[i]='\0';
	return OK;
}
//��ʮ�������ַ�ת��Ϊ��Ӧ��ʮ������
int xTodC(char c)
{
	if(isdigit(c))
	{
		return c-'0';
	}
	else if(isxdigit(c))
	{
		if(islower(c))
		{
			return c-'a'+10;
		}
		else if(isupper(c))
		{
			return c-'A'+10;
		}
	}
}

//��ָ���±귶ΧstartIndex��endIndex��ʮ�������ַ���ת��Ϊ��Ӧ��ʮ������
int xTodRange(const char *str,const int startIndex,const int endIndex)
{
	int sum=0;
	int k=0;
	int i=endIndex;
	while(i>=startIndex)
	{
		sum+=xTodC(str[i])<<k;
		k+=4;
		i--;
	}
	return sum;
}
Status analyseIP(ElemType str[N])
{
	int i=0,j=0;
	int headLen=0;//�ײ�����
	int totalLen=0;//����IP���ݰ��ĳ���
	deleteChar(str,' ');//ɾ�������ַ��������еĿո�

	headLen=xTodC(str[1])*4;//���ײ�����,��λΪ�ֽڹʳ���4
	totalLen=xTodRange(str,4,7);//���ܳ���
	printf("Total length = %d bytes\n",totalLen);
	printf("Source = %d.%d.%d.%d\n",xTodRange(str,24,25),xTodRange(str,26,27),xTodRange(str,28,29),xTodRange(str,30,31));
	printf("Destination = %d.%d.%d.%d\n",xTodRange(str,32,33),xTodRange(str,34,35),xTodRange(str,36,37),xTodRange(str,38,39));
	printf("Source Port = %d\n",xTodRange(str,headLen*2,headLen*2+3));
	printf("Destination Port = %d\n",xTodRange(str,headLen*2+4,headLen*2+7));
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	int i=0;
	ElemType str[N];
	scanf("%d",&n);//while 1#
	getchar();
	for(i=0;i<n;i++)
	{			
		gets(str);			
		printf("Case #%d\n",i+1);			
		analyseIP(str);
		printf("\n");
	}
	//	getchar();

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
