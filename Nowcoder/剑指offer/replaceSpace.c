#include<stdio.h>

/**
 *
 * @author ShijunDeng ��ʵ��һ����������һ���ַ����еĿո��滻�ɡ�%20�������磬���ַ���ΪWe Are
 *         Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy
 * 1.���ⲻ�ʺ��ù̶����Ⱦ�̬����,��̬����Ϊ��;
 * 2.spcace_count*2����spcace_count*3���������׳���
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
