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
    TreeNode(int x) : val(x), left(NULL), right(NULL) {
    }
};
class Solution {
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        int sizeIn=inorder.size();
        int sizePr=preorder.size();
        if(sizeIn==0||sizePr==0) {
            return NULL;
        }
        TreeNode *root;
        buildTree(root,inorder,0,sizeIn-1,preorder,0,sizePr-1);
        return root;
    }
private:
    void buildTree(TreeNode *&root,vector<int>& inorder,int beginIn,int endIn,vector<int>&preorder,int beginPr,int endPr) {
        if(beginIn>endIn||beginPr>endPr) {
            root=NULL;
            return ;
        }
        root=new TreeNode(preorder[beginPr]);
        for(int i=beginIn; i<=endIn; i++) {
            if(preorder[beginPr]==inorder[i]) {
                buildTree(root->left,inorder,beginIn,i-1,preorder,beginPr+1,beginPr+i-beginIn);
                buildTree(root->right,inorder,i+1,endIn,preorder,endPr-endIn+i+1,endPr);
                return ;
            }
        }
    }
};

int main() {

    return 0;
}
