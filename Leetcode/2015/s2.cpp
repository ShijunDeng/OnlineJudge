#include<iostream>
#include<stack>
using namespace std;
class TreeNode
{
    public:
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
class Solution
{
public:
    int kthSmallest(TreeNode* root, int k)
    {
        stack<TreeNode*> S;
        TreeNode *p=root;
        int count=0;
        while(p!=NULL||S.empty()==false){
            if(p!=NULL){
                S.push(p);
                p=p->left;
            }else{
                p=S.top();
                S.pop();
                count++;
                if(count==k){
                    return p->val;
                }
                p=p->right;
            }
        }
    }
};
int main()
{
    cout<<"XXXX"<<endl;
    return 0;
}
