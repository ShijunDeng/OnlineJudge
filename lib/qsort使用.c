#include<stdio.h>
#include<math.h>
//排序函数头文件
#include<stdlib.h>

int comp1(const void* a, const void* b)
{
    return *((int*)a) - *((int*)b);
}
int comp2(const void* a, const void* b)
{
    return ((int*)a)[1] - ((int*)b)[1] ;
}
int main()
{
    int data[][2] = {{1, 6}, {4, 7}, {2, 11}, {3, 1}, {17, 32}, {13, 16}, {21, 23}, {48, 14}, {16, 66}, {27, 15}};
    int i = 0;
    qsort(data, 10, sizeof(int[2]), comp2);
    for (i = 0; i < 10; i++)
    {
        printf("%d %d\n", data[i][0], data[i][1]);
    }
    return 0;
}
