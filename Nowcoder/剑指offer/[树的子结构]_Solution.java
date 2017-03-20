/*
树的子结构
时间限制：1秒 空间限制：32768K 热度指数：12053
 算法知识视频讲解
题目描述
输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
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
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2 == null){
            return false;
        }
        return dfs(root1, root2);    
    }
    
    private boolean dfs(TreeNode root1, TreeNode root2){
        if(false == comp(root1, root2)){
            if(root1 != null && false == comp(root1.left, root2)){
                return comp(root1.right, root2);
            }
            return root1 != null;
        }
        return true;
    }
    
    private boolean comp(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 != null){
            if(root2 == null){
                return true;
            }else{
                if(root1.val == root2.val){
                    return comp(root1.left, root2.left) && comp(root1.right, root2.right);
                }else{
                    return false;
                }
            }
            
        }
        return false;
    }
}