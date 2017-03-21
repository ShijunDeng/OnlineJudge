/*
连续子数组的最大和
时间限制：1秒 空间限制：32768K 热度指数：9099
本题知识点： 数组
 算法知识视频讲解
题目描述
HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,
常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含
某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第
3个为止)。你会不会被他忽悠住？(子向量的长度至少是1)
*/
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
       if(array == null || array.length == 0){
           return 0;
       } 
        int maxSum = 0x80000000, tmpSum = 0;
        for(int e : array){
            tmpSum += e;
            if(tmpSum > maxSum){
                maxSum = tmpSum;
            }else if(tmpSum < 0){
                tmpSum = 0;
            }
        }
        return maxSum;
    }
}
