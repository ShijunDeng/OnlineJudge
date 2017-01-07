package com.whitedew.algorithm.easy;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution17 {
	public int getLength(ListNode head) {
		int length = 0;
		while (head != null) {
			head = head.next;
			length++;
		}
		return length;
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lenA = getLength(headA);
		int lenB = getLength(headB);
		ListNode longList, shortList;
		if (lenA > lenB) {
			longList = headA;
			shortList = headB;
		} else {
			longList = headB;
			shortList = headA;
		}
		int diff = Math.abs(lenA - lenB);
		while (diff > 0) {
			longList = longList.next;
			diff--;
		}
		while (longList != null && longList != shortList) {
			longList = longList.next;
			shortList = shortList.next;
		}
		return longList;

	}
}