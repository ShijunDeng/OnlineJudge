#include<iostream>
#include<vector>
#include<string>
#include<set>
#include<stack>
#include<queue>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode* rotateRight(ListNode* head, int k) {
        if(head==NULL){
            return head;
        }
        int listLen=0;
        ListNode *p=head;
        while(p!=NULL){
            listLen++;
            p=p->next;
        }
        p=head;
        k=k%listLen;
        int count=1;
        while(count<k){
            p=p->next;
            count++;
        }
        ListNode *q=head;
        while(p->next!=NULL){
            p=p->next;
            q=q->next;
        }
        p->next=head;
        head=q->next;
        q->next=NULL;
        return head;
    }
};

int main() {

    return 0;
}
