//猴子选大王:利用数组信息指出下一只猴子的坐标
#include<stdio.h>
#define MAXSIZE 32
#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0
#define STEP 3

int choose(int number,int startIndex)
{ 
	int table[MAXSIZE];//数组中元素的值指向下一只猴子的位置
	int i=0;

	int last=-1;//记录上一只猴子的位置,初值置为-1
	int current=startIndex;//记录当前遍历的位置
	
	if(number > MAXSIZE)
		return ERROR;

	for(i=0;i<number;i++)
	{
		table[i]=i+1;//让数组中的元素指向下一只猴子的位置
	}

	table[number-1]=0;//最后一个元素的下个位置是0号元素

	while(last!=current)//队列中还有猴子
	{
		for(i=0;i<STEP-1;i++)
		{
			last=current;
			current=table[current];
		}

		table[last]=table[current];//被选中的猴子出队 并更新当前的信息
		current=table[current];
	}//end:while
	
	return current==0? number:current+1;

}

//业务逻辑:数据输入 调用求解函数 输出结果
int service()
{
	int number,startIndex,king;

	printf("input number,startIndex:");
	scanf("%d %d",&number,&startIndex);

	king=choose(number,startIndex-1);
	if(king==ERROR)
	{
		printf("ERROR!\n");
	}
	else
	{
		printf("KING:%d\n",king);
	}
	

}

int main()
{
	service();

	return OK;
}