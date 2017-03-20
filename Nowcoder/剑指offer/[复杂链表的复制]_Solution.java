/*复杂链表的复制
时间限制：1秒 空间限制：32768K 热度指数：7427
本题知识点： 链表
 算法知识视频讲解
题目描述
输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
*/
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
   public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return null;
		Map<RandomListNode, RandomListNode> record = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode node = head;
		while (node != null) {
			record.put(node, new RandomListNode(node.label));
			node = node.next;
		}

		node = head;
		while (node != null) {
			record.get(node).next = record.get(node.next);
			record.get(node).random = record.get(node.random);
			node = node.next;
		}

		return record.get(head);
	}
}

/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null){
            return null;
		}
        //1.复制原始链表的任意结点N并创建新结点N',再把N'链接到N的后面
        RandomListNode cpHead = pHead;
        while(cpHead != null){
            RandomListNode tmp = new RandomListNode(cpHead.label);
			tmp.next = cpHead.next;
            cpHead.next = tmp;
            cpHead = tmp.next;
        }
        
        //2.如果原始链表上的节点N的random指向S,则它对应的复制节点N'的random指向S的下一结点S'        
        cpHead = pHead;
        while(cpHead != null){
            if(cpHead.random != null){
                cpHead.next.random = cpHead.random.next;
			}else{
                cpHead.next.random = null;
            }
            cpHead = cpHead.next.next;
        }
        
        //3.拆分上一步得到的表为两个表，奇数位置上的结点组成原始链表,偶数位置的结点组成复制出来的链表
        cpHead = pHead.next;
        RandomListNode newHead = cpHead;
        pHead.next = cpHead.next;
        pHead = pHead.next;
        while(pHead != null){
            cpHead.next = pHead.next;
            pHead.next = pHead.next.next;
            pHead = pHead.next;
            cpHead = cpHead.next;
        }
        /*
        
        RandomListNode tmp, newHead = pHead.next;
        cpHead = pHead;
        while(cpHead.next != null){
            tmp = cpHead.next;
            cpHead.next =tmp.next;
            cpHead = tmp;
        }
        
        */
        return newHead;
    }
}