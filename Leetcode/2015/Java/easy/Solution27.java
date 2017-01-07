package com.whitedew.algorithm.easy;

public class Solution27 {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	boolean dfs(TreeNode root, int sum, int curSum) {
		if (root.left == null && root.right == null) {
			if (root.val + curSum == sum)
				return true;
		}
		if (root.left != null) {
			if (dfs(root.left, sum, root.val + curSum) == true)
				return true;
		}
		if (root.right != null) {
			if (dfs(root.right, sum, root.val + curSum) == true)
				return true;
		}
		return false;

	}

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		return dfs(root, sum, 0);
	}
}