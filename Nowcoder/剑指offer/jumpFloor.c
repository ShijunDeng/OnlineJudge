#include<stdio.h>

/**
 *
 * @author ShijunDeng һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж�����������
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
