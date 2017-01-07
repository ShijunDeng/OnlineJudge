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

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    TreeNode* sortedListToBST(ListNode* head) {
        vector<int>nums;
        TreeNode *root;
        if(head==NULL) {
            return NULL;
        }
        while(head!=NULL) {
            nums.push_back(head->val);
            head=head->next;
        }
        sortedListToBST(nums,root,0,nums.size()-1);
        return root;
    }
private:
    void sortedListToBST(vector<int>&nums,TreeNode *&root,int beginIndex,int endIndex) {
        if(beginIndex>endIndex) {
            root=NULL;
            return ;
        }
        int mid=(beginIndex+endIndex)/2;
        root=new TreeNode(nums[mid]);
        sortedListToBST(nums,root->left,beginIndex,mid-1);
        sortedListToBST(nums,root->right,mid+1,endIndex);
    }
};
int main() {
    Solution s;

    return 0;
}
