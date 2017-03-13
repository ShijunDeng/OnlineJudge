/*You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

Subscribe to see which companies asked this question.*/
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2) {
    int ca=0;
    int sum=0;
    struct ListNode*head=l1;
    //ListNode *new_node=ListNode *(malloc(sizeof(ListNode)));
    struct ListNode *pre=NULL;
    while(l1&&l2){
        sum=l1->val+l2->val+ca;
        ca=sum/10;
        l1->val=sum%10;
        pre=l1;
        l1=l1->next;
        l2=l2->next;
    }
    if(l1){
        while(l1){
            sum=l1->val+ca;
            ca=sum/10;
            l1->val=sum%10;
            pre=l1;
            l1=l1->next;
        }
    }else if(l2){
        pre->next=l2;
        while(l2){
            sum=l2->val+ca;
            ca=sum/10;
            l2->val=sum%10;
            pre=l2;
            l2=l2->next;
        }
    }
    if(ca){
        pre->next=(struct ListNode *)malloc(sizeof(struct ListNode));
        pre->next->val=ca;
        pre->next->next=NULL;
    }
    return head;
    
}