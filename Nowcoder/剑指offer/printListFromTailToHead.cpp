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
* ��Ŀ����
* ����һ��������β��ͷ��ӡ����ÿ���ڵ��ֵ��
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
