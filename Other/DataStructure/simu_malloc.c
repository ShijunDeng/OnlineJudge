/*ģ��alloc����*/

#include<stdio.h>
#define ALLOCSIZE 1000 /*���ÿռ�Ĵ�С �ֽ���*/

static char allocbuf[ALLOCSIZE];/*��alloc���������õĴ洢�ռ�*/
static char *allocp=allocbuf;/*��һ�����õĴ洢�ռ�*/

char * alloc(int n)
{
	if(allocbuf+ALLOCSIZE-allocp>=n)//ʣ��Ŀռ��㹻����
	{
		allocp+=n;
		return (allocp-n);//�������·���Ŀռ�ָ��
	}
	else //û���㹻�Ŀռ�
		return 0;//���ؿ�ָ��
}

void afree(char *p)/*�ͷ�pָ��Ĵ洢�ռ�*/
{
	if(p>=allocbuf&&p<allocbuf+ALLOCSIZE)
	allocp=p;//ʹp��Ϊ��һ�����ÿռ��ָ��
}

void main()
{
	char *p=0;
	printf("p:%d\n",p);
	p=alloc(10);
	*p="dsfss";
	printf("p:%d\n",p);
	printf("sp:%s\n",*p);
	p=alloc(10);
	printf("p:%d\n",p);

}