#include<iostream>
#include<stack>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode* swapPairs(ListNode* head) {

        if(head==NULL||head->next==NULL) {
            return head;
        }

        ListNode *pre=head;
        ListNode *cur=head->next;
        pre->next=cur->next;
        cur->next=pre;
        ListNode *lastPre=pre;
        ListNode *cpHead=cur;
        while(pre->next!=NULL&&pre->next->next!=NULL) {
            pre=pre->next;
            cur=pre->next;
            pre->next=cur->next;
            cur->next=pre;
            lastPre->next=cur;
            lastPre=pre;
        }
        return cpHead;
    }
};
int main() {

    Solution s;
    ListNode l1(1);
    ListNode l2(2);
    ListNode l3(3);
    ListNode l4(4);
    l1.next=&l2;
    l2.next=&l3;
    l3.next=&l4;
    l4.next=NULL;
    ListNode *head=&l1;
    while(head!=NULL) {
        cout<<head->val<<" ";
        head=head->next;
    }
    cout<<endl;

    head=s.swapPairs(&l1);
    while(head!=NULL) {
        cout<<head->val<<" ";
         head=head->next;
    }
    cout<<endl;
    return 0;
}
