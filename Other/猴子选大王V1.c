//蛮力法解决猴子选大王问题
#include<stdio.h>
#define MAXSIZE 32
#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0
#define STEP 3

int choose(int number,int startIndex)
{ 
	int count=0;//记录已经出局的猴子的数量
	int table[MAXSIZE];//模拟猴子的位置:1表示该位置有猴子,0表示该位置是空的
	int i=0;
	
	if(number > MAXSIZE)
		return ERROR;

	for(i=0;i<number;i++)//初始化数组 表示每个位置都有猴子
	{
		table[i]=1;
	}

	i=0;

	while(count<number)
	{
		if(table[startIndex]==1)//该位置有猴子
			i++;//计数器值加一

		if(i==STEP)//数到STEP的猴子退出
		{
			table[startIndex]=0;//置退出标记
			//printf("%d ",startIndex+1);
			i=0;//遍历计数器清零
			count++;//计数器加一
		}
		
		startIndex++;//遍历的下标加一

		if(startIndex>=number)//一圈输完,循环从头开始
			startIndex=0;
	}//end:while
	return startIndex==0 ?number:startIndex;
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