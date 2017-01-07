#include<stdio.h>

int function(int m) {
    if(m>5) {
        return function(m-5)+function(m-3);
    } else if(m==5||m==3) {
        return 1;
    }
    return 0;
}

int main() {

    int m;
    scanf("%d",&m);
    for(int i=0; i<m; i++) {
        printf("%d %d \n",i,function(i));

    }
    // while(scanf("%d",&m)!=EOF) {
    //     printf("%d\n",function(m));
    //}
    return 0;
}
