package com.whitedew.algorithm.medium;

import org.junit.Test;

public class Solution1 {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode preNode = head;
		ListNode curNode = head.next;
		head.next = null;
		ListNode p = null;
		while (curNode != null) {
			p = curNode;
			curNode = curNode.next;
			p.next = null;
			if (p.val <= head.val) {
				p.next = head;
				head = p;
			} else {
				ListNode q = head;
				while (q != null && p.val > q.val) {
					preNode = q;
					q = q.next;
				}
				if (q == null) {
					preNode.next = p;
				} else {
					p.next = q;
					preNode.next = p;
				}
			}
		}
		return head;
	}

	@Test
	public void test() {
		ListNode p1 = new ListNode(1);
		ListNode p2 = new ListNode(1);
		ListNode p3 = new ListNode(1);
		ListNode p4 = new ListNode(1);
		p1.next = p2;
		p2.next = null;
		p3.next = p4;
		p4.next = null;
		ListNode pp = p1;
		while (pp != null) {
			System.out.println(pp.val);
			pp = pp.next;

		}
		insertionSortList(p1);
		while (p1 != null) {
			System.out.println(p1.val);
			p1 = p1.next;

		}
	}
}