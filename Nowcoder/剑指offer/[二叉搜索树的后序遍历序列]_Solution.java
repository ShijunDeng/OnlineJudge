/*
二叉搜索树的后序遍历序列
时间限制：1秒 空间限制：32768K 热度指数：9802
 算法知识视频讲解
题目描述
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
*/
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
       return sequence != null && sequence.length != 0 && VerifySquenceOfBST(sequence, 0, sequence.length-1);
    }
    private boolean VerifySquenceOfBST(int [] sequence, int startIndex, int endIndex){
        if(startIndex == endIndex || startIndex == endIndex - 1 || startIndex - 1 == endIndex){//startIndex - 1 == endIndex 这种情形5 4 3 2 1 
            return true;
        }
       	int i = startIndex,j;
        while(i < endIndex && sequence[i] < sequence[endIndex]){
           i++;
        }
        if(i == endIndex){
            return true;
        }
        j = i;
        while(i < endIndex && sequence[i] > sequence[endIndex]){
            i++;
        }
        if(i != endIndex){
            return false;
        }
        return VerifySquenceOfBST(sequence, startIndex, j-1) && VerifySquenceOfBST(sequence, j, i-1);
    }
}