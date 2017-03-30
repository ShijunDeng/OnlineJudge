/*
按之字形顺序打印二叉树
时间限制：1秒 空间限制：32768K 热度指数：4403
 算法知识视频讲解
题目描述
请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推
*/

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
   public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		int dir = 0;// 0 from left to right, 1 from right to left
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
				if (dir == 0) {
					for (TreeNode e : Q) {
						tmp.add(e.val);
					}
				} else {
					for (TreeNode e : Q) {
						tmp.add(0, e.val);
					}
				}
                rs.add(tmp);
				dir = 1 - dir;
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