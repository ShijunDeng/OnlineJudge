package com.whitedew.algorithm.medium;

public class Solution33 {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			if (l1 == null)
				return l2;
			if (l2 == null)
				return l1;
			int c = 0;
			ListNode head = l1,preNode=null;
			while (l1 != null && l2 != null) {
				int add = l1.val + l2.val + c;
				l1.val = add % 10;
				c = add / 10;
				preNode=l1;
				l1 = l1.next;
				l2 = l2.next;
			}
		
			while (l1 != null) {
				int add = l1.val + c;
				l1.val = add % 10;
				c = add / 10;
				preNode.next=l1;
	            preNode=l1;
				l1 = l1.next;
			}
			while (l2 != null) {
				int add = l2.val + c;
				l2.val = add % 10;
				c = add / 10;
				preNode.next=l2;
	            preNode=l2;
				l2 = l2.next;
			}
			
			if(l1==null&&l2==null&&c!=0){
				l1=new ListNode(c);	
				preNode.next=l1;
			    l1.next=null;
			    l1=l1.next;
			}
			return head;
		}
}
