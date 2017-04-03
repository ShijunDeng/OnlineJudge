package cn.sjdeng.ds;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	private static int index = 0;

	public BiTNode createByPreOder(char[] datas) {
		index = 0;
		return createByPreOder(datas, datas.length);

	}

	private BiTNode createByPreOder(char[] datas, int length) {
		BiTNode root = null;
		if (index < length) {
			if (datas[index] == '^') {
				index++;
				return root;
			} else {
				root = new BiTNode(datas[index]);
				index++;
				root.left = createByPreOder(datas, length);
				root.right = createByPreOder(datas, length);
			}
		}
		return root;
	}

	// 根左右
	public void preOderTraverseRecur(BiTNode root) {
		if (root != null) {
			root.selfPrint();
			preOderTraverseRecur(root.left);
			preOderTraverseRecur(root.right);
		}
	}

	// 根左右
	public void preOderTraverse(BiTNode root) {
		if (root == null) {
			return;
		}
		Stack<BiTNode> S = new Stack<BiTNode>();
		BiTNode p = root;
		while (S.isEmpty() == false || p != null) {
			if (p != null) {
				p.selfPrint();
				S.push(p);
				p = p.left;
			} else {
				p = S.pop();
				p = p.right;
			}
		}
		System.out.println();
	}

	// 左根右
	public void inOderTraverse(BiTNode root) {
		if (root == null) {
			return;
		}
		Stack<BiTNode> S = new Stack<BiTNode>();
		BiTNode p = root;
		while (S.isEmpty() == false || p != null) {
			if (p != null) {
				S.push(p);
				p = p.left;
			} else {
				p = S.pop();
				p.selfPrint();
				p = p.right;
			}
		}
		System.out.println();
	}

	// 左右根
	public void postOderTraverse(BiTNode root) {
		if (root == null) {
			return;
		}
		Stack<BiTNode> S = new Stack<BiTNode>();
		BiTNode p = root;
		BiTNode visited = null;
		while (S.isEmpty() == false || p != null) {
			if (p != null) {
				S.push(p);
				p = p.left;
			} else {
				p = S.peek();
				if (p.right != null && visited != p.right) {
					p = p.right;
				} else {
					p = S.pop();
					p.selfPrint();
					visited = p;
					p = null;
				}
			}
		}
		System.out.println();
	}

	public void levelTraverse(BiTNode root) {
		if (root == null) {
			return;
		}
		Queue<BiTNode> Q = new ArrayDeque<BiTNode>();
		BiTNode p = root;
		Q.add(p);
		while (Q.isEmpty() == false) {
			p = Q.poll();
			p.selfPrint();
			if (p.left != null) {
				Q.add(p.left);
			}
			if (p.right != null) {
				Q.add(p.right);
			}
		}
		System.out.println();
	}
}
