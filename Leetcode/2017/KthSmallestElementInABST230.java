package cn.sjdeng.leetcode;

import java.util.Stack;

/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 */
public class KthSmallestElementInABST230 {
	public int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> S = new Stack<TreeNode>();
		int count = 0;
		int rs = 0;
		while (S.isEmpty() == false || root != null) {
			if (root != null) {
				S.add(root);
				root = root.left;
			} else {
				count++;
				root = S.pop();
				if (count == k) {
					rs = root.val;
					break;
				}
				root = root.right;
			}
		}
		return rs;
	}
}
