package com.whitedew.algorithm.easy;

public class Solution2 {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return null;
		}
		while (head != null && head.val == val) {
			head = head.next;
		}
		ListNode preNode = null;
		ListNode curNode = head;
		while (curNode != null) {
			if (curNode.val == val) {
				preNode.next = curNode.next;
			} else {
				preNode = curNode;
			}
			curNode = curNode.next;
		}
		return head;
	}
}