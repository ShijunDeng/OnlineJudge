//输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return reConstructBinaryTree(pre,in,0,pre.length-1,0,in.length-1);
    }
    private TreeNode reConstructBinaryTree(int [] pre,int [] in,int preStart,int preEnd,int inStart,int inEnd) {
        TreeNode root=new TreeNode(pre[preStart]);
        root.left=null;
        root.right=null;
        int mid=inStart;
        while(mid<=inEnd&&in[mid]!=pre[preStart]){
            mid++;
        }
        if(mid>inStart&&mid<=inEnd){
             root.left=reConstructBinaryTree(pre,in,preStart+1,preStart+mid-inStart,inStart,mid-1);  
        }
        if(mid>=inStart&&mid<inEnd){
             root.right=reConstructBinaryTree(pre,in,preStart+mid-inStart+1,preEnd,mid+1,inEnd);  
        }
        return root;
    }
    
}