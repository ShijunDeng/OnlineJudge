package com.whitedew.algorithm.easy;

public class Solution24 {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode lc = null, lh = null;
		if (l1.val > l2.val) {
			lh = lc = l2;
			l2 = l2.next;
		} else {
			lh = lc = l1;
			l1 = l1.next;
		}
		while (l1 != null && l2 != null) {
			if (l1.val > l2.val) {
				lc.next = l2;
				l2 = l2.next;
			} else {
				lc.next = l1;
				l1 = l1.next;
			}
			lc = lc.next;
		}
		if (l1 != null) {
			lc.next = l1;
		}
		if (l2 != null) {
			lc.next = l2;
		}
		return lh;
	}
}