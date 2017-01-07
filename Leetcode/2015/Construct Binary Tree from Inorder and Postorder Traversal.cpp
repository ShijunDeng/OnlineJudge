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
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        int sizeIn=inorder.size();
        int sizePo=postorder.size();
        if(sizeIn==0||sizePo==0) {
            return NULL;
        }
        TreeNode *root;
        buildTree(root,inorder,0,sizeIn-1,postorder,0,sizePo-1);
        return root;
    }
private:
    void buildTree(TreeNode *&root,vector<int>& inorder,int beginIn,int endIn,vector<int>&postorder,int beginPo,int endPo) {
        if(beginIn>endIn||beginPo>endPo) {
            root=NULL;
            return ;
        }
        root=new TreeNode(postorder[endPo]);
        for(int i=beginIn; i<=endIn; i++) {
            if(postorder[endPo]==inorder[i]) {
                buildTree(root->left,inorder,beginIn,i-1,postorder,beginPo,beginPo+i-1-beginIn);
                buildTree(root->right,inorder,i+1,endIn,postorder,endPo-endIn+i,endPo-1);
                return ;
            }
        }
    }
};

int main() {

    return 0;
}
