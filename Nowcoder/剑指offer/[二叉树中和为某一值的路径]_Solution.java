/*
二叉树中和为某一值的路径
时间限制：1秒 空间限制：32768K 热度指数：9063
 算法知识视频讲解
题目描述
输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
*/
import java.util.ArrayList;
import java.util.Stack;
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
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> rs =new ArrayList<ArrayList<Integer>>();
        if(root == null){
            return rs;
        }
        Stack<TreeNode> S =new Stack<TreeNode>();
        TreeNode p = root,last = null;
        int sum=0;
        while(S.isEmpty() == false || p != null){
            if(p != null){
                S.push(p);
                sum += p.val;
                               
                if(sum == target && p.left == null && p.right == null){
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    for(TreeNode e : S){
                        tmp.add(e.val);
                    }
                    rs.add(tmp);
                } 
                p = p.left;
            }else{
                p = S.peek();
                if(p.right != null && last != p.right){
                    p = p.right;
                }else{
                    last = S.pop();
                    sum -= last.val;
                    p = null;
                }
            }
        }//while
        return rs;
    }
}