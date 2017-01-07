package com.whitedew.algorithm.easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Solution8 {
	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> rs = new LinkedList<List<Integer>>();
		List<Integer> re = new LinkedList<Integer>();
		if (root == null) {
			return rs;
		}
		TreeNode levelTag = new TreeNode(0);
		queue.offer(root);
		queue.offer(levelTag);
		while (queue.isEmpty() == false) {
			TreeNode e = queue.poll();
			if (e == levelTag) {
				if (queue.isEmpty() == false) {
					queue.offer(levelTag);
				}
				if (re.isEmpty() == false) {
					rs.add(re);
					re = new LinkedList<Integer>();
				}
			} else if (e != null) {
				if (e.left != null) {
					queue.offer(e.left);
				}
				if (e.right != null) {
					queue.offer(e.right);
				}
				re.add(e.val);
			}
		}
		return rs;
	}
}