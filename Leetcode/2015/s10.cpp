#include<stdio.h>
#include<string.h>
#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0
typedef int Status;
typedef int Boolean;
#define N 1000
Status handleFunction(int cars[N][2],int m,int questions[N][3],int n) {
    for(int i=0; i<n; i++) {
        int count=0;
        for(int j=0; j<m; j++) {
            int len=cars[j][1]-cars[j][0];
            int circles=questions[i][2]/len;
            int dif=questions[i][2]%len;
            int pos;
            if(circles%2==0) {
                pos=cars[j][0]+dif;
            } else {
                pos=cars[j][1]-dif;
            }
            if(pos<=questions[i][1]&&pos>=questions[i][0]) {
                count++;
            }
        }//for m
        printf("%d\n",count);

    }//for n
    return OK;
}
//业务处理函数:输入数据 调用相关函数完成任务 返回处理结果
Status service() {
    int m,n;
    int cars[N][2];
    int questions[N][3];
    scanf("%d %d",&m,&n);
    for(int i=0; i<m; i++) {
        scanf("%d %d",cars[i],cars[i]+1);
    }
    for(int i=0; i<n; i++) {
        scanf("%d %d %d",questions[i],questions[i]+1,questions[i]+2);
    }
    return handleFunction(cars,m,questions,n);
}

int main() {
    if(ERROR==service()) { //解决方案出错
        printf("ERROR!\n");
        return ERROR;
    }
    return OK;
}
