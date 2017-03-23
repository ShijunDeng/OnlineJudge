/*
构建乘积数组
时间限制：1秒 空间限制：32768K 热度指数：5438
本题知识点： 数组
 算法知识视频讲解
题目描述
给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
*/

import java.util.ArrayList;
public class Solution {
    public int[] multiply(int[] A) {
		if (A == null || A.length < 2) {
            return null;
        }
        int[] B = new int[A.length];
        B[0] = 1;
        for (int i = 1; i < A.length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        int mul = 1;
        for (int i = A.length - 2; i >= 0; i--) {
        	mul *= A[i + 1];
            B[i] *= mul;
        }
        return B;
    }
}