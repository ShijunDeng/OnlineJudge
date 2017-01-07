package com.whitedew.algorithm.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution6 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> traversals = new ArrayList<Integer>();
		if (root == null) {
			return traversals;
		}
		Stack<TreeNode> nodes = new Stack<TreeNode>();
		TreeNode p = root;
		while (p != null || nodes.empty() == false) {
			if (p != null) {
				nodes.push(p);
				traversals.add(p.val);
				p = p.left;
			} else {
				p = nodes.pop();
				p = p.right;
			}
		}
		return traversals;
	}

}