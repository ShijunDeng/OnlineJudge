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