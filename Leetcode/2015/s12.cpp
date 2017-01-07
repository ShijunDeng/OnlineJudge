#include<stdio.h>
#include<malloc.h>
#include<string.h>
int* productExceptSelf(int* nums, int numsSize, int* returnSize) {
    int *rs=(int *) malloc(numsSize*sizeof(int));
    if(!rs) {
        return 0;
    }
    *returnSize=numsSize;
    rs[0]=1;
    int mulL=1,mulR=nums[numsSize-1];
    for(int i=1; i<numsSize; i++) {
        mulL*=nums[i-1];
        rs[i]=mulL;
    }
    for(int i=numsSize-2; i>=0; i--) {
        rs[i]*=mulR;
        mulR*=nums[i];
    }
    return rs;
}
int main() {
    int s[4]= {1,2,3,4};
    int l;
    int *rs=productExceptSelf(s,4,&l);
    for(int i=0; i<l; i++) {
        printf("%d ",rs[i]);
    }
    return 0;
}
