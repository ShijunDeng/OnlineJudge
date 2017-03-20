/*
链表中倒数第k个结点
时间限制：1秒 空间限制：32768K 热度指数：16536
本题知识点： 链表
 算法知识视频讲解
题目描述
输入一个链表，输出该链表中倒数第k个结点
*/
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
		if(head==null){
            return null;
        }
        int count=0;
        ListNode p=head;
        while(p!=null&&count<k){
            p=p.next;
            count++;
        }
        if(p==null&&count==k){
            return head;
        }else if(p==null){
            return null;
        }
        while(p!=null){
            head=head.next;
            p=p.next;
        }
        return head;      
    }
}