/*
reorder-list
时间限制：1秒 空间限制：32768K 热度指数：1262
本题知识点： 链表 leetcode
 算法知识视频讲解
题目描述

Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
You must do this in-place without altering the nodes' values.
For example,
Given{1,2,3,4}, reorder it to{1,4,2,3}.

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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return ;
        }
        
        ListNode hh = new ListNode(-1);
        hh.next = head;
        ListNode slow = hh;
        ListNode fast = head;
        ListNode nh = null;
        ListNode p = null;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == null) {
            nh = slow.next;
            slow.next = null;
        } else {
            nh = slow.next.next;    
            slow.next.next = null;
        }
        p = nh.next;
        nh.next = null;
        ListNode tmp = null;
        while (p != null) {
            tmp = p.next;
            p.next = nh;
            nh = p;
            p = tmp;
        }
        
        fast = head;
        slow = nh;
        while (slow != null) {
            tmp = slow.next;
            slow.next = fast.next;
            fast.next = slow;
            slow = tmp;
            fast = fast.next.next;
        }
    }
}