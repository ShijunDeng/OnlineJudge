/*
平衡二叉树
时间限制：1秒 空间限制：32768K 热度指数：7212
 算法知识视频讲解
题目描述
输入一棵二叉树，判断该二叉树是否是平衡二叉树。
*/

public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        int []level = {0};
        return isBalance(root, level);
            
    }
    private boolean isBalance(TreeNode root, int[] level){
        if(root == null){
            level[0] = 0;
            return true;
        }
        int []levelL = {0};
        int []levelR = {0};
        if(isBalance(root.left, levelL) && isBalance(root.right, levelR) && Math.abs(levelL[0] - levelR[0]) < 2){
            level[0] = levelL[0] > levelR[0] ? levelL[0] + 1 : levelR[0] + 1;
            return true;
        }
        return false;
    }
}