#include<iostream>
#include<vector>
using namespace std;
/**
*  struct ListNode {
*        int val;
*        struct ListNode *next;
*        ListNode(int x) :
*              val(x), next(NULL) {
*        }
*  };
* 题目描述
* 输入一个链表，从尾到头打印链表每个节点的值。
*/
class Solution
{
public:
    vector<int> printListFromTailToHead(ListNode* head)
    {
        vector<int> ret;
        ListNode*p=head;
        while(p)
        {
            ret.push_back(p->val);
            p=p->next;
        }
        reverse(ret.begin(),ret.end());
        return ret;
    }
};
