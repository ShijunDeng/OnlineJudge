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
#define N 210

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1127��������
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��1091�����637
��Ŀ������
Julius Caesar����ʹ�ù�һ�ֺܼ򵥵����롣
���������е�ÿ���ַ�������������ĸ���к�5λ��Ӧ���ַ������棬�����͵õ������ġ�
�����ַ�A��F�����档���������ĺ��������ַ��Ķ�Ӧ��ϵ��
����
A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
����
V W X Y Z A B C D E F G H I J K L M N O P Q R S T U 
��������ǶԸ��������Ľ��н��ܵõ����ġ�
����Ҫע����ǣ������г��ֵ���ĸ���Ǵ�д��ĸ��������Ҳ��������ĸ���ַ�������Щ�ַ����ý��н��롣
���룺
�����еĲ������ݲ�����100�顣ÿ�����ݶ������µ���ʽ�����Ҹ����������֮��û�пհ׵��С�
һ��������ݰ��������֣�
1.    ��ʼ�� - һ�У������ַ��� "START" 
2.    ���� - һ�У��������ģ����Ĳ�Ϊ�գ��������е��ַ���������200
3.    ������ - һ�У������ַ��� "END" 
�����һ���������֮����һ�У������ַ��� "ENDOFINPUT"��
�����
��ÿ�����ݣ�����һ��������������Ķ�Ӧ�����ġ�
�������룺
START
NS BFW, JAJSYX TK NRUTWYFSHJ FWJ YMJ WJXZQY TK YWNANFQ HFZXJX
END
START
N BTZQI WFYMJW GJ KNWXY NS F QNYYQJ NGJWNFS ANQQFLJ YMFS XJHTSI NS WTRJ
END
START
IFSLJW PSTBX KZQQ BJQQ YMFY HFJXFW NX RTWJ IFSLJWTZX YMFS MJ
END
ENDOFINPUT
���������
IN WAR, EVENTS OF IMPORTANCE ARE THE RESULT OF TRIVIAL CAUSES
I WOULD RATHER BE FIRST IN A LITTLE IBERIAN VILLAGE THAN SECOND IN ROME
DANGER KNOWS FULL WELL THAT CAESAR IS MORE DANGEROUS THAN HE
��Դ��
2008�걱����ѧ����ʵ���Ҽ�����о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7850-1-1.html

*/
Status explain(char str[N])
{
	int i=0,j=0;
	while(str[i]!='\0')
	{
		if((str[i]>='a'&&str[i]<='z')||(str[i]>='A'&&str[i]<='Z'))
		{
			str[i]=str[i]-5;
			if(str[i]<65)
			{
				str[i]+=26;
			}	
		}
		i++;
	}
	str[i]='\0';
	return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int n=0;
	int i=0,j=0;
	char str[N],strF[15];
	gets(strF);
	while(strcmp(strF,"ENDOFINPUT"))//while 1#
	{
		gets(str);
		explain(str);
		gets(strF);
		gets(strF);
		printf("%s\n",str);
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