#include<stdio.h>

/**
 *
 * @author ShijunDeng ����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
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
