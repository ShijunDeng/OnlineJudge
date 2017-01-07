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
        stack<TreeNode*>S;
        while(p!=NULL||S.empty()==false) {
            if(p!=NULL) {
                S.push(p);
                p=p->left;
            } else {
                p=S.top();
                if(p!=NULL) {
                    rs.push_back(p->val);
                }
                S.pop();
                p=p->right;
            }
        }//while
        return rs;
    }
};
int main() {

    return 0;
}
