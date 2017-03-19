/**
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
Subscribe to see which companies asked this question.
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2) {
    struct ListNode head={0,0};
    struct ListNode *current=&head;
    while(l1&&l2){
        if(l1->val<l2->val){
            current->next=l1;
            l1=l1->next;
        }else{
            current->next=l2;
            l2=l2->next;
        }
        current=current->next;
    }
    if(l1){
        current->next=l1;
    }else if(l2){
        current->next=l2;
    }
    return head.next;
}