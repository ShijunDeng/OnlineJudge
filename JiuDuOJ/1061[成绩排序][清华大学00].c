#include<stdio.h>
#include<string.h>
//#include<malloc.h>
#include<math.h>
//����״̬��
#define OK 1
#define ERROR 0

#define TRUE 1
#define FALSE 0

typedef int Status;
typedef int Boolean;

#define M 102
#define N 1005

//const int MAXINT =((unsigned int)-1)>>1;
//const int MININT= ~ (((unsigned int)-1)>>1);
/*************************��Ŀ˵��********************/
/*
��Ŀ1061���ɼ�����
ʱ�����ƣ�1 ���ڴ����ƣ�32 ���������⣺���ύ��13936�����3873
��Ŀ������
    ��N��ѧ�������ݣ���ѧ�����ݰ��ɼ��ߵ���������ɼ���ͬ�������ַ�����ĸ�����������������ĸ��Ҳ��ͬ����ѧ������������
	�����N��ѧ����������Ϣ��
���룺
    ���������ж��飬ÿ�������һ����һ������N��N<=1000������������N�а���N��ѧ�������ݡ�
    ÿ��ѧ�������ݰ������������Ȳ�����100���ַ����������䣨�����������ɼ���С�ڵ���100����������
�����
    ��ѧ����Ϣ���ɼ��������򣬳ɼ���ͬ������������ĸ���������
    Ȼ�����ѧ����Ϣ���������¸�ʽ��
    ���� ���� �ɼ�
�������룺
3
abc 20 99
bcd 19 97
bed 20 97
���������
bcd 19 97
bed 20 97
abc 20 99
��ʾ��
ѧ����������ĸ��������ĸ�Ĵ�Сд����AҪ��a����ĸ��ǰ(��ΪA��ASC���a��ASC��ҪС)��
��Դ��
2000���廪��ѧ������о�����������
���ɣ�
������������?��������ĵ�?���۱�������ʣ�http://t.jobdu.com/thread-7785-1-1.html
*/

typedef struct Student
{
	char name[M];
	int age;
	int score;
}Student;

Student data[N];
int stuNum;//ѧ������

int comp(const void *a,const void *b)
{
	Student *sa=(Student*)a;
	Student *sb=(Student*)b;

	if(sa->score!=sb->score)
	{
		return sa->score-sb->score;
	}	
	else if(strcmp(sa->name,sb->name))
	{
		return strcmp(sa->name,sb->name);	
	}
	return sa->age-sb->age;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	int i=0;
	while(scanf("%d",&stuNum)!=EOF)//while 1#
	{
		for(i=0;i<stuNum;i++)
		{
			scanf("%s %d %d",data[i].name,&data[i].age,&data[i].score);
		}
		qsort(data,stuNum,sizeof(Student),comp);
		for(i=0;i<stuNum;i++)
		{
			printf("%s %d %d\n",data[i].name,data[i].age,data[i].score);
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