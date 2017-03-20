/*
合并两个排序的链表
时间限制：1秒 空间限制：32768K 热度指数：14294
本题知识点： 链表
 算法知识视频讲解
题目描述
输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null || list2 == null){
            return list1 == null? list2 : list1;
        }
        
        ListNode mergeHead = new ListNode(-1);
        ListNode p=mergeHead;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                p.next = list1;
                list1 = list1.next;
            }else{
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        if(list1 != null){
           p.next = list1; 
        }else if(list2 != null){
           p.next = list2;
        }
        return mergeHead.next;
    }
}