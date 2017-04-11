/*模拟alloc函数*/

#include<stdio.h>
#define ALLOCSIZE 1000 /*可用空间的大小 字节数*/

static char allocbuf[ALLOCSIZE];/*共alloc函数分配用的存储空间*/
static char *allocp=allocbuf;/*下一个可用的存储空间*/

char * alloc(int n)
{
	if(allocbuf+ALLOCSIZE-allocp>=n)//剩余的空间足够分配
	{
		allocp+=n;
		return (allocp-n);//返回重新分配的空间指针
	}
	else //没有足够的空间
		return 0;//返回空指针
}

void afree(char *p)/*释放p指向的存储空间*/
{
	if(p>=allocbuf&&p<allocbuf+ALLOCSIZE)
	allocp=p;//使p成为下一个可用空间的指针
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