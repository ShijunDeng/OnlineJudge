#include <iostream>
#include<stdio.h>
#include<algorithm>
#include<math.h>
#define MAX_POINTS_NUM 320
using namespace std;

struct point
{
    int x, y, vx, vy;
} p[MAX_POINTS_NUM];

int top, stack[MAX_POINTS_NUM];

double dis(const point &a, const point &b)
{
    return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
}
int max(int a, int b)
{
    return a > b ? a : b;
}
int xmult(const point &p1, const point &p2, const point &p0)
{
    return (p1.x - p0.x) * (p2.y - p0.y) - (p1.y - p0.y) * (p2.x - p0.x);
}

int cmp(const void * a, const void * b)
{
    struct point *p1 = (struct point *)a;
    struct point *p2 = (struct point *)b;
    int ans = xmult(*p1, *p2, p[0]);

    if (ans < 0)
        return 1;
    else if (ans == 0 && ( (*p1).x >= (*p2).x))
        return 1;
    else
        return -1;
}
void graham(int n)
{
    qsort(p + 1, n - 1, sizeof(point), cmp);
    int i;
    stack[0] = 0, stack[1] = 1;
    top = 1;

    for (i = 2 ; i < n ; ++i)
    {
        while (top > 0 && xmult( p[stack[top]], p[i], p[stack[top - 1]]) <= 0)
            top--;

        stack[++top] = i;
    }

    int temp = top;

    for (i = n - 2 ; i >= 0 ; --i)
    {
        while (top > temp && xmult(p[stack[top]], p[i], p[stack[top - 1]]) <= 0)
            top--;

        stack[++top] = i;    //新元素入栈
    }
}
int rotating_calipers()  //卡壳
{
    int i, q = 1;
    int ans = 0;
    stack[top] = 0;
    int point_i = 0, point_j = 0;

    for (i = 0 ; i < top ; i++)
    {
        while ( xmult( p[stack[i + 1]], p[stack[q + 1]], p[stack[i]] ) > xmult( p[stack[i + 1]], p[stack[q]], p[stack[i]] ) )
            q = (q + 1) % (top);

        if ( dis(p[stack[i]], p[stack[q]]) > dis(p[stack[i + 1]], p[stack[q + 1]]))
        {

            if (dis(p[stack[i]], p[stack[q]]) > ans)
            {
                point_i = i;
                point_j = q;
            }

        }
        else
        {
            if (dis(p[stack[i + 1]], p[stack[q + 1]]) > ans)
            {
                point_i = i + 1;
                point_j = q + 1;
            }
        }

        ans = max(ans, max( dis(p[stack[i]], p[stack[q]]), dis(p[stack[i + 1]], p[stack[q + 1]])));
    }

    int x = p[stack[point_i]].x - p[stack[point_j]].x;
    int y = p[stack[point_i]].y - p[stack[point_j]].y;
    int vx = p[stack[point_i]].vx - p[stack[point_j]].vx;
    int vy = p[stack[point_i]].vy - p[stack[point_j]].vy;
    int a = (vx * vx + vy * vy);
    int b = 2 * (x * vx + y * vy);
    int c = x * x + y * y;
    double t = -1.0 * b / (2 * a);
    double min_dis = sqrt((4 * a * c - b * b) * 1.0 / (4 * a));

    printf("%.2f %.2f\n", t, min_dis);
    return ans;
}

int main(void)
{
    int i, n, leftdown;

    while (scanf("%d", &n) != EOF)
    {
        leftdown = 0;
        top = 0;

        for (i = 0 ; i < n ; ++i)
        {
            scanf("%d %d %d %d", &p[i].x, &p[i].y, &p[i].vx, &p[i].vy);

            if (p[i].y < p[leftdown].y || (p[i].y == p[leftdown].y && p[i].x < p[leftdown].x)) //找到最左下角的点
                leftdown = i;
        }

        swap(p[0], p[leftdown]);
        graham(n);
        rotating_calipers();
    }

    return 0;
}
