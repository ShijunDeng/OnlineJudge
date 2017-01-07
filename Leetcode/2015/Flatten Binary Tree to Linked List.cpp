#include<iostream>
#include<vector>
#include<string>
#include<set>
#include<stack>
#include<queue>
using namespace std;
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    void flatten(TreeNode* root) {
        if(root==NULL) {
            return ;
        }
        stack<TreeNode*>Q;
        TreeNode*p=NULL;
        TreeNode*pre=NULL;
        Q.push(root);
        while(p||Q.empty()==false) {
            if(p==NULL) {
                p=Q.top();
                if(pre!=NULL) {
                    pre->right=p;
                }
                Q.pop();
            }
            if(p!=NULL) {
                if(p->right!=NULL) {
                    Q.push(p->right);
                }
                p->right=p->left;
                pre=p;
                p=p->left;
                pre->left=NULL;
            }
        }//end of while
    }
};

int main() {
    Solution s;
    TreeNode p1(1);
    TreeNode p2(2);
    p1.left=&p2;
    p1.right=NULL;
    p2.left=p2.right=NULL;
    s.flatten(&p1);
    cout<<p1.left<<endl;
    cout<<p1.right<<endl;
    return 0;
}
