#include<stdio.h>

/**
 *
 * @author ShijunDeng 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
n<=39
 */

int Fibonacci(int n)
{
    int a=1,b=1;
    int counter=2;
    if(n<=0)
    {
        return 0;
    }
    else if(n==1||n==2)
    {
        return 1;
    }
    else
    {
        while(counter<n)
        {
            a=a+b;
            b=a+b;
            counter+=2;
        }//1 1 2 3 5 8 13
    }
    return counter==n?b:a;
}

int main()
{

    return 0;

}
