#include <iostream>
#include<stack>
#include<vector>
using namespace std;
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    vector<vector<int> > pathSum(TreeNode* root, int sum) {
        vector<vector<int> >result;
        if(root==NULL) {
            return result;
        }
        TreeNode *p=root;
        TreeNode *lastVisited=NULL;
        vector<TreeNode*>V;
        while(p!=NULL||V.empty()==false) {
            if(p!=NULL) {
                V.push_back(p);
                p=p->left;
            } else {
                p=V.back();
                if(p->right!=NULL&&lastVisited!=p->right) {
                    p=p->right;
                    V.push_back(p);
                    p=p->left;
                } else {
                    p=V.back();
                    if(p->left==NULL&&p->right==NULL) {
                        int tmpSum=0;
                        vector<int>tmpPath;
                         vector<TreeNode*>::iterator iter;
                        for (iter=V.begin(); iter!=V.end(); iter++) {
                            tmpSum+=(*iter)->val;
                            tmpPath.push_back((*iter)->val);
                        }
                        if(tmpSum==sum){
                            result.push_back(tmpPath);
                        }
                    }
                    V.pop_back();
                    lastVisited=p;
                    p=NULL;
                }
            }//else
        }//end:while
        return result;
    }
};

int main() {
    Solution u;
    TreeNode root(-2);
    root.left=NULL;

    TreeNode r1(-3);
    r1.left=r1.right=NULL;

    root.right=&r1;
    u.pathSum(&root,-2);
    cout<<"end"<<endl;
    return 0;
}
