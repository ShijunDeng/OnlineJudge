#include<stdio.h>

/**
 *
 * @author ShijunDeng 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
int jumpFloor(int number)
{
    int a=1,b=2;
    int counter=2;
    if(number<3){
        return number;
    }
    while(counter<number)
    {
        a=a+b;
        b=a+b;
        counter+=2;
    }
    return counter==number?b:a;


}

int main()
{

    printf("%d\n",jumpFloor(4));
    return 0;

}
