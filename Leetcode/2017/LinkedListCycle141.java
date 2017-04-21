/*
141. Linked List Cycle Add to List
Given a linked list, determine if it has a cycle in it.
Follow up:
Can you solve it without using extra space?
Subscribe to see which companies asked this question.
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                 fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return true;
            }
        }
        return false; 
    }
}