#include<stdio.h>

/**
 *
 * @author ShijunDeng һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n���������������һ��n����̨���ܹ��ж�����������
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
