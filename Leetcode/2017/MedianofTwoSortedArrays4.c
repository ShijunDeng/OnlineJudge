/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
*/

int findkth(int* a,int aSize,int*b,int bSize,int k) {
    int aPos,bPos;
    if(aSize>bSize){//保证a始终是较短序列
        return findkth(b,bSize,a,aSize,k);
    }
    if(aSize==0){//如果序列a空了，则直接返回
        return b[k-1];
    }
    if(k==1){
        return a[0]<b[0] ? a[0] : b[0];
    }
     
    aPos = k/2<aSize ? k/2 : aSize;//如果a太短，则直接取a的末尾元素比较
    bPos = k-aPos;
     
    if(a[aPos-1]==b[bPos-1]){
        return a[aPos-1];
    }else if(a[aPos-1]<b[bPos-1]){
        return findkth(a+aPos,aSize-aPos,b,bSize,k-aPos);
    }else{
        return findkth(a,aSize,b+bPos,bSize-bPos,k-bPos);
    }
     
}
 
double findMedianSortedArrays(int* nums1, int nums1Size, int* nums2, int nums2Size) {
     
    if((nums1Size+nums2Size)%2){
        return findkth(nums1,nums1Size,nums2,nums2Size,(nums1Size+nums2Size)/2+1)*1.0;
    }else{
        return (findkth(nums1,nums1Size,nums2,nums2Size,(nums1Size+nums2Size)/2)
            +findkth(nums1,nums1Size,nums2,nums2Size,(nums1Size+nums2Size)/2+1))/2.0;
    }
}