#include<stdio.h>

/**
 *
 * @author ShijunDeng 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
int jumpFloorII(int number)
{
    if(number<1)
        return 0;

    return 1<<(number-1);
}

int main()
{
    int  i=0;
    for(i=0; i<10; i++)
    {
        printf("%d\n",jumpFloorII(i));

    }
    return 0;

}
