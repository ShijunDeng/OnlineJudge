package com.whitedew.algorithm.medium;

 
public class Solution8 {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public class Solution {
	    public ListNode detectCycle(ListNode head) {
	        if(head==null){
	            return null;
	        }
	        ListNode fast=head;
	        ListNode slow=head;
	        while(slow!=null&&fast!=null&&fast.next!=null){ 
	            slow=slow.next;
	            fast=fast.next.next;
	            if(fast==slow){
	                fast=head;
	                while(fast!=slow){
	                    fast=fast.next;
	                    slow=slow.next;
	                }
	                return fast;
	            }
	        }
	      return null;
	    }
	}
}
