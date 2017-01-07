//背包问题:与利润相关问题 回朔法解决  FIFO分支限界
#include<stdio.h>
#include<malloc.h>
#include<math.h>

//函数结果状态代码
#define MAXSIZE 1024
#define TRUE 1
#define FALSE 0
#define OK 1
#define ERROR 0
#define INFEASIBLE -1

typedef int Status; //Status是函数的类型,其值是函数结果状态代码，如OK等 
typedef int Boolean; // Boolean是布尔类型,其值是TRUE或FALSE 


typedef struct Node
{
	int level;//处理的是第level层数据
	int visited;//是否被访问
	int parent;//父节点的下标
	double bonus;//当前搜多路径到当前节点时的利润
	double weight;//当前搜多路径到当前节点时的重量
}Node;
Node Q[MAXSIZE];//存放搜索节点 模拟队列

//FIFO分支限界解决背包问题
//返回取得最大利润那一支的头结点
int tryKnap(double* comms,double* bonus,double capacity,int number)
{
	Node p,q;
	int front,rear;//首尾指针
	double maxBonus=0;//当前探测到的最大利润值
	int maxBoHead=0;//取得最大利润的分支的头结点 

	front=rear=-1;//队列初始化为空

	//初始化根节点
	p.level=-1;	
	p.visited=0;	
	p.parent=-1;
	p.bonus=0;
	p.weight=0;
	
	//将p节点入队
	rear++;
	Q[rear]=p;

	while(rear != front)//while #1 队列不空
	{
		front++;
		q=Q[front];//出队

		if(q.level+1<number)//if #1//未到达最后一层
		{
			//搜索左孩子
			p.weight=q.weight+comms[q.level + 1];
			if(p.weight <= capacity)//if #2
			{
				p.bonus=q.bonus+bonus[q.level + 1];	
				p.visited=1;
				p.level=q.level+1;
				p.parent=front;
				//将p节点入队
				rear++;
				Q[rear]=p;
			//	printf("pb%.2f--pw%.2lf--b%.2lf--w%.2lf\n",p.bonus,p.weight,bonus[p.level],comms[p.level]);

				if(p.bonus>maxBonus)
				{
				
					maxBonus=p.bonus;
					maxBoHead=rear;
				}
			}//end:if #2	

			//搜索右孩子
			p.weight=q.weight;
			p.bonus=q.bonus;
			p.visited=0;
			p.level=q.level+1;
			p.parent=front;
			//将p节点入队
			rear++;
			Q[rear]=p;
		}//end:if #1	
	}//end:while #1
	return maxBoHead;

}

//业务逻辑:数据输入 调用求解函数 输出结果
int service()
{
	int i;
	double s=0;
	double* comms;//存放货物的重量
	double* bonus;//利润表
	double capacity;//限重
	int number;//货物的件数
	//double maxBonus=0;//获得的最大利润 
	int maxBoHead=0;

	printf("input number, capacity:");
	scanf("%d %lf",&number,&capacity);

	if(MAXSIZE<pow(2,number+1))
	{
		return ERROR;//超过处理上限
	}

	comms=(double *)malloc(number*sizeof(double));
	if(comms==NULL)
		return ERROR;

	bonus=(double *)malloc(number*sizeof(double));
	if(bonus==NULL)
	{
		free(comms);//申请内存失败 清理前面申请的空间
		return ERROR;
	}

	printf("commodity table:");
	for(i=0;i<number;i++)//货物数量表
	{
		scanf("%lf",comms+i);
		s+=comms[i];
	}

	if(s<=capacity)//可以全部装完
	{
		free(comms);
		free(bonus);
		printf("All selected!\n");
		return OK;
	}

	printf("bonus table:");
	for(i=0;i<number;i++)//利润表
	{
		scanf("%lf",bonus+i);
	} 

	maxBoHead=tryKnap(comms,bonus,capacity,number);

	printf("selected(comms[bonus]):");
	i=maxBoHead;
	while(i>=0)
	{
		if(Q[i].visited==1)
		{
			printf("%.2lf[%.2lf] ",comms[Q[i].level],bonus[Q[i].level]);		
		}
		i=Q[i].parent;
	}

	printf(" maxBonus:%.2lf\n",Q[maxBoHead].bonus);

	free(comms);
	free(bonus);
	return OK;
}


/*
测试数据
5 10
1 2 3 4 5
5 6 18 4 20
5 10
1 2 3 4 5
5 4 3 2 1
*/
int main()
{
	if(ERROR==service())
	{
		printf("REEOR!\n");
	}
	return OK;
}