#include<stdio.h>

/**
 *
 * @author ShijunDeng ��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n�
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
