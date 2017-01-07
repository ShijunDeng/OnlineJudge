package com.whitedew.algorithm.easy;

public class Solution7 {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return (int) Math.max(getHeight(root.left), getHeight(root.right)) + 1;

	}

	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		return ((int) Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1)
				&& isBalanced(root.left) && isBalanced(root.right) ? true
				: false;
	}
}