package com.whitedew.algorithm.easy;

public class Solution28 {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int getMinDepth(TreeNode root, int dep, Integer min) {
		if (root.left == null && root.right == null) {
			dep++;
			if (dep < min)
				min = dep;
			return min;
		} else if (root.left != null && root.right != null) {
			int lmin = getMinDepth(root.left, dep + 1, min);
			int rmin = getMinDepth(root.right, dep + 1, min);
			return lmin > rmin ? rmin : lmin;
		} else if (root.left != null) {
			return getMinDepth(root.left, dep + 1, min);
		}
		return getMinDepth(root.right, dep + 1, min);

	}

	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return getMinDepth(root, 0, new Integer(Integer.MAX_VALUE));

	}
}