package com.whitedew.algorithm.medium;

import org.junit.Test;

public class Solution7 {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public class Solution {
		public void reorderList(ListNode head) {
			if (head == null || head.next == null || head.next.next == null) {
				return;
			}
			ListNode fast = head;
			ListNode slow = head;

			while (fast != null && fast.next != null && fast.next.next != null
					&& slow != null) {
				fast = fast.next.next;
				slow = slow.next;
			}

			fast = slow;
			slow = slow.next;
			fast.next = null;
			ListNode p = slow, headM = p;
			p = p.next;
			headM.next = null;
			while (p != null) {
				ListNode tmp = p;
				p = p.next;
				tmp.next = headM;
				headM = tmp;
			}
			p = head;
			ListNode q = new ListNode(1);
			while (p != null && headM != null) {
				q.next = p;
				ListNode tmp = p;
				p = p.next;
				tmp.next = headM;
				q = headM;
				headM = headM.next;
			}
			if (p != null) {
				q.next = p;
				p.next = null;
			}
		}

		@Test
		public void test() {
			ListNode l[] = new ListNode[5];
			l[0] = new ListNode(0);
			l[1] = new ListNode(1);
			l[2] = new ListNode(2);
			l[3] = new ListNode(3);
			l[4] = new ListNode(4);
			l[0].next = l[1];
			l[1].next = l[2];
			l[2].next = l[3];
			l[3].next = null;
			ListNode p = l[0];
			reorderList(p);
			while (p != null) {
				System.out.println(p.val);
				p = p.next;
			}
		}
	}
}