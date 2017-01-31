#include<stdio.h>

/**
 *
 * @author ShijunDeng 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are
 *         Happy.则经过替换之后的字符串为We%20Are%20Happy
 * 1.此题不适合用固定长度静态数组,动态数组为宜;
 * 2.spcace_count*2还是spcace_count*3的问题容易出错
 */
void replaceSpace(char *str,int length)
{
    char *tmp=(char*)malloc( sizeof(char)*length*3 );
    int index=0;
    int spcace_count=0;
    while(index<length)
    {
        if(str[index]!=' ')
        {
            tmp[index+spcace_count*2]=str[index];
        }
        else
        {
            tmp[index+spcace_count*2]='%';
            tmp[index+spcace_count*2+1]='2';
            tmp[index+spcace_count*2+2]='0';
            spcace_count++;
        }
        index++;
    }
    index=index+spcace_count*2;
    str[index]='\0';
    while(index>0)
    {
        index--;
        str[index]=tmp[index];
    }
    free(tmp);
}

int main()
{
    char str[]=" d   3";
    replaceSpace(str,sizeof(str));

    printf("%s\n",str);
    return 0;

}
