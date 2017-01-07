package com.whitedew.algorithm.medium;

import java.util.Stack;

import org.junit.Test;

public class Solution25 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int sumNumbers(TreeNode root) {
		int sum = 0;
		if (root == null) {
			return sum;
		}
		Stack<TreeNode> S = new Stack<TreeNode>();
		TreeNode p = root;
		TreeNode lastVisited = null;
		while (p != null || S.isEmpty() == false) {
			if (p != null) {
				S.push(p);
				p = p.left;
			}// p!=null
			else {
				p = S.peek();
				if (p.left == null && p.right == null) {
					int pathSum = 0;
					for (TreeNode e : S) {
						pathSum = 10 * pathSum + e.val;
					}
					sum += pathSum;
				}
				if (p.right != null && p.right != lastVisited) {
					p = p.right;
					S.push(p);
					p = p.left;
				} else {
					p = S.pop();
					lastVisited = p;
					p = null;
				}
			}
		}// while
		return sum;
	}// sumNumbers

	@Test
	public void test() {
		TreeNode root = new TreeNode(1);
		TreeNode p1 = new TreeNode(2);
		TreeNode p2 = new TreeNode(3);
		TreeNode p3 = new TreeNode(4);
		p1.left = p1.right = null;
		p1.right = p3;
		p3.left = p3.right = null;
		root.left = p1;
		root.right = p2;
		System.out.println(new Solution25().sumNumbers(root));

	}
}
