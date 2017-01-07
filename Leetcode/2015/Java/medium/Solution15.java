package com.whitedew.algorithm.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

public class Solution15 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<List<Integer>> rs = new LinkedList<List<Integer>>();
		List<Integer> re = new LinkedList<Integer>();
		int count = 0;
		if (root == null) {
			return rs;
		}
		TreeNode levelTag = new TreeNode(0);

		stack.push(levelTag);
		stack.push(root);
		while (stack.isEmpty() == false) {
			TreeNode e = stack.pop();
			if (e == levelTag) {
				if (stack.isEmpty() == false) {
					stack.push(levelTag);
				}
				if (re.isEmpty() == false) {
					rs.add(re);
					count++;
					re = new LinkedList<Integer>();
				}
			} else if (e != null) {
				if (count % 2 == 0) {
					if (e.right != null) {
						stack.push(e.right);

					}
					if (e.left != null) {
						stack.push(e.left);
					}
				} else {
					if (e.left != null) {
						stack.push(e.left);
					}
					if (e.right != null) {
						stack.push(e.right);

					}
				}

				re.add(e.val);
			}
		}
		return rs;
	}

	@Test
	public void test() {
		TreeNode root = new TreeNode(1);
		root.left = root.right = null;
		zigzagLevelOrder(root);
	}
}
