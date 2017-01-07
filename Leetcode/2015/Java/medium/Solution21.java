package com.whitedew.algorithm.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution21 {

	public class Solution {
		public class TreeNode {
			int val;
			TreeNode left;
			TreeNode right;

			TreeNode(int x) {
				val = x;
			}
		}

		public List<Integer> rightSideView(TreeNode root) {
			List<Integer>rs=new LinkedList<Integer>();
			if(root==null){
				return rs;
			}
			Queue<TreeNode> Q=new LinkedList<TreeNode>();
			TreeNode levelTag=new TreeNode(0);
			TreeNode lastNode=root;
			Q.offer(root);
			Q.offer(levelTag);
			while(Q.isEmpty()==false){
				TreeNode q=Q.poll();
				if(q==levelTag){
					rs.add(lastNode.val);
					if(Q.isEmpty()==false){
						Q.offer(levelTag);
					}
				}else{
					lastNode=q;
					if(q.left!=null){
						Q.offer(q.left);
					}if(q.right!=null){
						Q.offer(q.right);
					}
				}
				
			}
			return rs;
		}
	}
}
