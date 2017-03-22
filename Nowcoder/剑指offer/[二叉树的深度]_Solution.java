/*
二叉树的深度
时间限制：1秒 空间限制：32768K 热度指数：9428
 算法知识视频讲解
题目描述
输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
*/

/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    public int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int ld = TreeDepth(root.left);
        int rd = TreeDepth(root.right);
        return ld > rd ? ld + 1 : rd + 1;
    }
}