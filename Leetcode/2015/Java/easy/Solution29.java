package com.whitedew.algorithm.easy;



public class Solution29 {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int getMaxDepth(TreeNode root, int dep, Integer max) {
		if (root.left == null && root.right == null) {
			dep++;
			if (dep > max)
				max = dep;
			return max;
		} else if (root.left != null && root.right != null) {
			int lmax = getMaxDepth(root.left, dep + 1, max);
			int rmax = getMaxDepth(root.right, dep + 1, max);
			return lmax < rmax ? rmax : lmax;
		} else if (root.left != null) {
			return getMaxDepth(root.left, dep + 1, max);
		}
		return getMaxDepth(root.right, dep + 1, max);

	}

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return getMaxDepth(root, 0, new Integer(Integer.MIN_VALUE));

	}
}