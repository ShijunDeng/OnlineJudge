/*
反转链表
时间限制：1秒 空间限制：32768K 热度指数：16220
本题知识点： 链表
 算法知识视频讲解
题目描述
输入一个链表，反转链表后，输出链表的所有元素
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode ReverseList(ListNode head) {
		if(null == head){
            return head;
        }
        ListNode tail = head, p=null;
        head = head.next;//容易漏掉,且要注意顺序
        tail.next = null;
        
        while(head != null){
            p = head;
            head = head.next;
            p.next = tail;
            tail = p;
        }
        p = tail;
        while(tail != null){
            System.out.print(tail.val+" ");
            tail = tail.next;
		}
        return p;
    }
}