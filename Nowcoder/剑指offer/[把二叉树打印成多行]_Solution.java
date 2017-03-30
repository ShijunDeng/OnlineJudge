/*把二叉树打印成多行
时间限制：1秒 空间限制：32768K 热度指数：5011
 算法知识视频讲解
题目描述
从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行*/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/*
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
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
    	ArrayList<ArrayList<Integer>> rs = new ArrayList<ArrayList<Integer>>();
		if (pRoot == null) {
			return rs;
		}
		TreeNode levelTag = new TreeNode(-1);
		TreeNode p = pRoot;
		Queue<TreeNode> Q = new LinkedList<TreeNode>();
		Q.offer(levelTag);
		Q.offer(p);
		while (Q.isEmpty() == false) {
			p = Q.poll();
			if (p == levelTag && Q.isEmpty() == false) {
				ArrayList<Integer> tmp = new ArrayList<Integer>();
				for (TreeNode e : Q) {
					tmp.add(e.val);
				}				
                rs.add(tmp);
				Q.offer(levelTag);
			} else {
				if (p.left != null) {
					Q.offer(p.left);
				}
				if (p.right != null) {
					Q.offer(p.right);
				}
			}
		} // while
		return rs;
    }
    
}