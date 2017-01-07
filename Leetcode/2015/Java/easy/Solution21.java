package com.whitedew.algorithm.easy;


public class Solution21 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {
			return head;
		}
		if (head == null) {
			return null;
		}
		if(head.next==null&&n==1)
		    return null;
		int cn = n;
		ListNode preNode = head, curNode = head;
		while (cn > 0) {
			curNode = curNode.next;
			cn--;
		}
		if(curNode==null)
		    return head.next;
		while (curNode.next != null) {
			preNode = preNode.next;
			curNode = curNode.next;
		}
		if (preNode != null && preNode.next != null)
			preNode.next = preNode.next.next;
		else
			preNode.next = null;
		return head;
    }
}