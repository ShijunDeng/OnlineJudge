#include<stdio.h>
#include<math.h>
#include<malloc.h>
//排序函数头文件
#include<stdlib.h>

int comp1(const void* a, const void* b)
{
    return *((int*)a) - *((int*)b);
}
int comp2(const void *a, const void *b)
{
    return ((int *)a)[0] - ((int *)b)[0];
}
int comp3(const void* a, const void* b)
{
    //这里不一定是2,还是要看具体的维度
    return ((int (*)[2])a)[0] - ((int (*)[2])b)[0];
}
int comp4(const void* a, const void* b)
{
    int *ap = *(int **)a;
    int *bp = *(int **)b;

    if (ap[0] == bp[0])
    {
        return ap[1] - bp[1];
    }
    else
    {
        return ap[0] - bp[0];
    }
}
int main()
{
    int data[][2] = {{1, 6}, {4, 7}, {2, 11}, {3, 1}, {17, 32}, {13, 16}, {21, 23}, {48, 14}, {16, 66}, {27, 15}};
    int i = 0;
    int *b, **a;
    a = (int**)malloc(10 * sizeof(int*)); //这里是对int*来分配。
    for (i = 0; i < 10; i++)
    {
        a[i] = malloc(2 * sizeof(int));
        a[i][0] = data[i][0];
        a[i][1] = data[i][1];
    }
    qsort(a, 10, sizeof(a[0]), comp3);
    for (i = 0; i < 10; i++)
    {
        printf("a %d %d\n", a[i][0], a[i][1]);
    }
    qsort(data, 10, sizeof(data[0]), comp2);
    for (i = 0; i < 10; i++)
    {
        printf("data %d %d\n", data[i][0], data[i][1]);
    }
    for (i = 0; i < 10; i++)
    {
        free(a[i]);
    }
    return 0;
}
