package com.whitedew.algorithm.easy;

public class Solution34 {
	 class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int x) {
			val = x;
		}
	}

	private void invertTreeT(TreeNode root) {
		if (root != null) {
			TreeNode tmp = root.left;
			root.left = root.right;
			root.right = tmp;
			invertTree(root.left);
			invertTree(root.right);
		}

	}

	public TreeNode invertTree(TreeNode root) {

		invertTreeT(root);
		return root;
	}
}
