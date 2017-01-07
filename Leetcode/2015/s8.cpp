#include<stdio.h>
#include<string.h>
int main() {
    char str[101];
    int mark[100];
    int nums[100];
    scanf("%s",str);
    for(int i=0; i<100; i++) {
        mark[i]=0;
    }
    int len=strlen(str);
    int n=(len-9)/2+9;
    int index=0;
    int count=0;
    int lastIndex[100][2];
    int lastCount=0;
    int flag=1;
    while(index<len) {
        if(mark[str[index]-'0']==0&&str[index]-'0'!=0&&flag==1) {
            nums[count]=str[index]-'0';
            mark[nums[count]]=1;
            lastIndex[lastCount][0]=index;
            lastIndex[lastCount][1]=count;
            lastCount++;
            count++;
            index++;
            flag=1;
        } else if(mark[(str[index]-'0')*10+str[index+1]-'0']==0&&str[index]-'0'!=0&&(str[index]-'0')*10+str[index+1]-'0'<=n) {
            nums[count]=(str[index]-'0')*10+str[index+1]-'0';
            mark[nums[count]]=1;
            count++;
            index+=2;
            flag=1;
        } else {
            while(flag) {
                for(int i=lastIndex[lastCount-1][1]; i<count; i++) {
                    mark[nums[i]]=0;
                }
                index=lastIndex[lastCount-1][0];
                count=lastIndex[lastCount-1][1];
                lastCount--;
                if(mark[(str[index]-'0')*10+str[index+1]-'0']==0&&str[index]-'0'!=0&&(str[index]-'0')*10+str[index+1]-'0'<=n) {
                    nums[count]=(str[index]-'0')*10+str[index+1]-'0';
                    mark[nums[count]]=1;
                    count++;
                    index+=2;
                    flag=0;
                }
            }//while
            flag=1;
        }
    }
    int k=0;
    for( k=0; k<count-1; k++) {
        printf("%d ",nums[k]);
    }
    printf("%d",nums[k]);
    return 0;
}
