#include<iostream>
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
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root==NULL) {
            return NULL;
        }
        bool pVisited=false;
        bool qVisited=false;
        vector<TreeNode*>V;
        TreeNode *curNode=p;
        TreeNode *last=NULL;
        while(curNode!=NULL||V.empty()==false) {
            if(curNode!=NULL) {
                V.push_back(curNode);
                curNode=curNode->left;
            } else {
                curNode=V.front();
                if(curNode->right!=NULL&&last!=curNode->right) {
                    curNode=curNode->right;
                    V.push_back(curNode);
                    curNode=curNode->left;
                } else {
                    V.pop_back();
                    if(curNode==p) {
                        pVisited=true;
                    }
                    if(curNode==q) {
                        qVisited=true;
                    }
                    if(qVisited==true&&qVisited==true) {
                        return V[0];
                    }
                    last=curNode;
                    curNode=NULL;
                }
            }//else
        }//while
    }
};

int main() {
    Solution s;

    return 0;
}
