package cn.sjdeng.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].
 */

public class BinaryTreePostorderTraversal145 {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> rs = new ArrayList<Integer>();
		TreeNode last = null;
		TreeNode p = root;
		Stack<TreeNode> S = new Stack<TreeNode>();
		while (S.empty() == false || p != null) {
			if (p != null) {
				S.push(p);
				p = p.left;
			} else {
				p = S.peek();
				if (p.right != null && last != p.right) {
					p = p.right;
				} else {
					p = S.pop();
					rs.add(p.val);
					last = p;
					p = null;
				}
			}
		}
		return rs;
	}
}
