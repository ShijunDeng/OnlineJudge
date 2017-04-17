//147. Insertion Sort List
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode p = head.next;
        head.next = null;
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode q = null;
        ListNode tmp = null;
        while (p != null) {
            q = h;
            while (q.next != null && q.next.val < p.val) {
                q = q.next;
            }
            tmp = p.next;
            
            p.next = q.next;
            q.next = p;
            p = tmp;
        }
        
        return h.next;
        
    }
}