 /*
[编程题] 构造回文
给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
输出需要删除的字符个数。
输入描述:
输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.
输出描述:
对于每组数据，输出一个整数，代表最少需要删除的字符个数。
输入例子:
abcda
google
输出例子:
2
2
*/
 
#include<stdio.h>
#include<string.h>

#define N 1024
#define max(x, y) (((x) > (y))? (x) : (y))
void reverse(char *str)
{
    int i, j;
    if (!str)
    {
        return ;
    }
    i = 0;
    j = strlen(str) - 1;
    while (i < j)
    {
        str[i] ^= str[j];
        str[j] ^= str[i];
        str[i] ^= str[j];
        i++;
        j--;
    }
}

int getMaxParDelCount(char *p)
{
    char cp_str[N];
    int c[N][N];
    int i = 0, j = 0;
    int str_len = 0;
    if (!p)
    {
        return str_len;
    }
    strcpy(cp_str, p);
    reverse(cp_str);
    str_len = strlen(p);
    memset(c, 0, sizeof c);
    for (i = 0; i < str_len; i++)
    {
        for (j = 0; j < str_len; j++)
        {
            c[i + 1][j + 1] = (cp_str[i] == p[j]) ? (c[i][j] + 1) : max(c[i][j + 1], c[i + 1][j]);
        }
    }
    return str_len - c[str_len][str_len];
}

int main()
{
    char str[N];
    while (scanf("%s", str) != EOF)
    {
        printf("%d\n", getMaxParDelCount(str));
    }
    return 0;
}
