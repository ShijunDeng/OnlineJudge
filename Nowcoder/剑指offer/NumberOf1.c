#include<stdio.h>

/**
 *
 * @author ShijunDeng 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
int  NumberOf1(int n)
{
    int sum=0;
    while(n)
    {
        sum++;
        n=n&(n-1);
    }
    return sum;
}

int main()
{
    int  i=0;
    {
        printf("%d\n",NumberOf1(-8));

    }
    return 0;

}
