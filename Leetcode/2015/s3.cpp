#include<iostream>
using namespace std;
struct ListNode
{
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution{
public:
    bool isPalindrome(ListNode* head){
        if(head==NULL){
            return true;
        }
        if(head->next==NULL){
            return true;
        }

        if(head->next->next==NULL){
                if(head->next->val==head->val){
                    return true;
                }
            return false;
        }

        ListNode *fast=head;
        ListNode *slow=head;
        while(fast!=NULL&&fast->next!=NULL){
            slow=slow->next;
            fast=fast->next->next;
        }
        if(fast!=NULL){
            slow=slow->next;
        }
        ListNode *pre=slow;
        slow=slow->next;
        pre->next=NULL;
        while(slow!=NULL){
            ListNode *tmp=slow;
            slow=slow->next;
            tmp->next=pre;
            pre=tmp;
        }
        while(head!=NULL&&pre!=NULL){
            if(head->val!=pre->val){
                return false;
            }
            head=head->next;
            pre=pre->next;
        }

        return true;
    }
};
int main()
{
    ListNode *l1=new ListNode(1);
    ListNode *l2=new ListNode(2);
    ListNode *l3=new ListNode(3);
    ListNode *l4=new ListNode(2);
    ListNode *l5=new ListNode(21);
    //ListNode *l6=new ListNode(1);
    l1->next=l2;
    l2->next=l3;
    l3->next=l4;
    l4->next=l5;
   // l5->next=l6;
    l5->next=NULL;
    Solution s;
    cout<<s.isPalindrome(l1)<<endl;
    delete l1; delete l2; delete l3; delete l4; delete l5; //delete l6;
    return 0;
}
