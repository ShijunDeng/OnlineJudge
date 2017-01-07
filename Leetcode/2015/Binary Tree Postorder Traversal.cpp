#include<iostream>
#include<vector>
#include<string>
#include<set>
#include<stack>
#include<queue>
using namespace std;



class Solution {
public:
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int>rs;
        TreeNode*p=root;
        TreeNode*last=NULL;
        stack<TreeNode*>S;
        while(p!=NULL||S.empty()==false) {
            if(p!=NULL) {
                S.push(p);
                p=p->left;
            } else {
                p=S.top();
                if(p->right!=NULL&&last!=p->right) {
                    p=p->right;
                    S.push(p);
                    p=p->left;
                } else {
                    S.pop();
                    rs.push_back(p->val);
                    last=p;
                    p=NULL;
                }
            }
        }//while
        return rs;
    }
};


int main() {

    return 0;
}
