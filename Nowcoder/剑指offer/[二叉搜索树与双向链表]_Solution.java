/*
二叉搜索树与双向链表
时间限制：1秒 空间限制：32768K 热度指数：6862
 算法知识视频讲解
题目描述
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向
*/
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
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
			return null;
        }
        TreeNode last = null;
        TreeNode p = pRootOfTree;
        TreeNode tmp = null;
        Stack<TreeNode> S = new Stack<TreeNode>();
        while(S.isEmpty() == false || p!=null){
            if(p != null){
                S.push(p);
                p = p.left;
            }else{
                p = S.pop();
                if(last != null){
                    last.right = p;
                    p.left = last;                   
                }
                last = p;
                if(tmp == null){                   
                    tmp = p;
                }
                p = p.right;
            }
		}       
        return tmp;        
    }
}