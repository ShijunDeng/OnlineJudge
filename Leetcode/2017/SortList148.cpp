/*Sort a linked list in O(n log n) time using constant space complexity.*/
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution
{
public:
public:
	ListNode *sortList(ListNode *head) {
		if(head == NULL || head->next == NULL) return head;
		ListNode *fast(head), *slow(head), *list2(NULL);
		fast = fast->next;
		while(fast && fast->next) {
			fast = fast->next->next;
			slow = slow->next;
		}
		list2 = slow->next;
		slow->next = NULL;
		head = sortList(head);
		list2 = sortList(list2);
		return mergeList(head, list2);
	}
private:
	ListNode *mergeList(ListNode *lhs, ListNode *rhs) {
		ListNode *list(NULL), *rear(NULL);
		while(lhs && rhs) {
			if(lhs->val <= rhs->val) {
				if(rear) {
					rear->next = lhs;
					rear = rear->next;
				} else {
					list = rear = lhs;
				}
				lhs = lhs->next;
			} else {
				if(rear) {
					rear->next = rhs;
					rear = rear->next;
				} else {
					list = rear = rhs;
				}
				rhs = rhs->next;
			}
		}
		if(lhs) {
			if(rear) rear->next = lhs;
			else list = lhs;
		}
		if(rhs) {
			if(rear) rear->next = rhs;
			else list = rhs;
		}
		return list;
	}
};