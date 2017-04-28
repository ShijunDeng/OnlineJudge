/*
[编程题] 买帽子
时间限制：1秒
空间限制：32768K
度度熊想去商场买一顶帽子，商场里有N顶帽子，有些帽子的价格可能相同。度度熊想买一顶价格第三便宜的帽子，问第三便宜的帽子价格是多少？ 
输入描述:
首先输入一个正整数N（N <= 50），接下来输入N个数表示每顶帽子的价格（价格均是正整数，且小于等于1000）


输出描述:
如果存在第三便宜的帽子，请输出这个价格是多少，否则输出-1

输入例子:
10
10 10 10 10 20 20 30 30 40 40

输出例子:
30
*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
//#include<malloc.h>
#include<math.h>
#define N 256
//const int INT_MAX = ((unsigned int) - 1) >> 1;
//const int INT_MIN = ~(((unsigned int) - 1) >> 1);

int find_kth_num1(int nums[N], int length, int k)
{
    int low = 0, high;
    int pivot = 0;
    int flag = 1;
    int i = 0;
    while (i < length)
    {
        if (nums[++i] != nums[low])
        {
            nums[++low] = nums[i];
        }
    }
    length = low + 1;
    high = low;
    low = 0;
    if (length < k)
    {
        return -1;
    }
    if (length == k)
    {
        return nums[k - 1];
    }
    if (1 == k)
    {
        return nums[0];
    }
    while (flag)
    {
        while (low < high)
        {
            pivot = nums[low];
            while (low < high && nums[high] > pivot)
            {
                high --;
            }

            nums[low] = nums[high];
            while (low < high && nums[low] < pivot)
            {
                low ++;
            }
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        if (low == k - 1)
        {
            flag = 0;
        }
        else if (low < k - 1)
        {
            low ++;
            high = length - 1;
        }
        else
        {
            low = 0;
            high = low - 1;
        }
    }
    return pivot;
}
int comp(const void*a, const void*b)
{
    return *((int *)a) - *((int *)b);
}
int find_kth_num2(int nums[N], int length, int k)
{
    int counts[1001];
    int sum = 0;
    int i;
    memset(counts, 0, 1001 * sizeof(int));
    qsort(nums, length, sizeof(int), comp);
    for (i = 0; i < length; i++)
    {
        sum += (counts[nums[i]] == 0);
        counts[nums[i]] = 1;
        if (sum == k)
        {
            return nums[i];
        }
    }
    return -1;
}

int main()
{
    int n = 0;
    int i;
    int nums[N];

    scanf("%d", &n);
    for (i = 0; i < n; i++)
    {
        scanf("%d", nums + i);
    }
    printf("%d", find_kth_num2(nums, n, 3));
    return 0;
}
