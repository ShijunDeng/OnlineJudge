/**从上往下打印二叉树
时间限制：1秒 空间限制：32768K 热度指数：11460
 算法知识视频讲解
题目描述
从上往下打印出二叉树的每个节点，同层节点从左至右打印。

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
//我更考虑了层序遍历得到每一层，原题不必要如此写，不需要设置层标记
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> rs = new ArrayList<Integer>();
        if(root == null){
            return rs;
        }
        TreeNode levelTag = new TreeNode(0);
        TreeNode p = root;
        Queue<TreeNode> Q = new LinkedList<TreeNode>(); 
        Q.offer(levelTag);
        Q.offer(p);
        while(Q.isEmpty() == false){
            p = Q.poll();
            if(p != levelTag){
                rs.add(p.val);
                if(p.left != null){
                    Q.offer(p.left);
                } 
            	if(p.right != null){
                    Q.offer(p.right);
                }
            }else if(Q.isEmpty() == false){
                Q.offer(levelTag);                          
            }
        }
        
        return rs;
    }
}