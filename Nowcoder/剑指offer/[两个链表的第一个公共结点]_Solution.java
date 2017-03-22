/*
两个链表的第一个公共结点
时间限制：1秒 空间限制：32768K 热度指数：7674
本题知识点： 链表
 算法知识视频讲解
题目描述
输入两个链表，找出它们的第一个公共结点。
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
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
 		if(pHead1 == null || pHead2 == null){
            return null;
        }
        if(pHead1 == pHead2){
			return pHead1;
        }
        int len1 = 0, len2 = 0;
        ListNode p1 = pHead1, p2 = pHead2;
        while(p1 != null){
            len1 ++;
            p1 = p1.next;
		}
        while(p2 != null){
            len2 ++;
            p2 = p2.next;
		}
        p1 = pHead1;
        p2 = pHead2;
        if(len1 > len2){
            while(len1 != len2){
                p1 = p1.next;
                len1--;
            }
        }else{
             while(len1 != len2){
                p2 = p2.next;
                len2--;
            }            
        }
        
        while(p1 != null && p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;       
    }
}