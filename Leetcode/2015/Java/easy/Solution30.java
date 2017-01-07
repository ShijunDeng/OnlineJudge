package com.whitedew.algorithm.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution30 {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private boolean judge(List<TreeNode> levelNodes) {
		int low = 0;
		int high = levelNodes.size() - 1;
		while (low < high) {
			TreeNode a = levelNodes.get(low);
			TreeNode b = levelNodes.get(high);
			if ((a == null && b != null) || (a != null && b == null))
				return false;
			if ((a != null && b != null) && (a.val != b.val))
				return false;
			low++;
			high--;
		}
		return true;
	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		Queue<TreeNode> nodesQueue = new LinkedList<TreeNode>();
		List<TreeNode> levelNodes = new ArrayList<TreeNode>();
		TreeNode levelTag = new TreeNode(-1);
		//TreeNode nullTag = new TreeNode(-2);
		nodesQueue.add(root);
		nodesQueue.add(levelTag);
		while (nodesQueue.isEmpty() == false) {
			TreeNode e = nodesQueue.poll();
			if (e == levelTag) {
				if (nodesQueue.isEmpty() == false) {
					nodesQueue.add(levelTag);
				}
				if (levelNodes.isEmpty() == false) {
					if (false == judge(levelNodes))
						return false;
					levelNodes.clear();
				}

			} else {
				if (e != null && e.left != null) {
					nodesQueue.offer(e.left);
				}
				if (e != null && e.right != null) {
					nodesQueue.offer(e.right);
				}
				levelNodes.add(e.left);
				levelNodes.add(e.right);
			}
		}
		return true;
	}

}
