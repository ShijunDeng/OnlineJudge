#include<stdio.h>
#include<string.h>
#define N 1024

void move(char *str)
{
    int str_len = strlen(str);
    int low = 0;
    int i = 0;
    char tmp;
    while (low < str_len)
    {
        i = low;
        while(low < str_len && isupper(str[low]))
        {
            low++;
        }
        if(low == str_len)
        {
            break;
        }
        tmp = str[low];
        while (low > i)
        {
            str[low] = str[low - 1] ;
            low --;
        }
        str[low] = tmp;
        low++;
        while(low < str_len && islower(str[low]))
        {
            low ++;
        }
    }
}
int main()
{
    char str[N];
    while(scanf("%s",str) != EOF)
    {
        move(str);
        printf("%s\n",str);
    }
    return 0;
}
