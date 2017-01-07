#include<iostream>
#include<vector>
#include<string>
#include<set>
#include<stack>
#include<queue>
using namespace std;
struct TreeLinkNode {
    int val;
    TreeLinkNode *left, *right, *next;
    TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
};

class Solution {
public:
    void connect(TreeLinkNode *root) {
     if(root==NULL){
        return;
     }
     queue<TreeLinkNode*>levelTavelNodes;
     levelTavelNodes.push(root);
     TreeLinkNode *current=NULL;
     TreeLinkNode *next=NULL;
     int n=1;
     while(levelTavelNodes.empty()==false){
        for(int i=0;i<n;i++){
            current=levelTavelNodes.front();
            levelTavelNodes.pop();
            current->next=next;
            next=current;
            if(current->right!=NULL){
                 levelTavelNodes.push(current->right);
                 levelTavelNodes.push(current->left);
            }
        }
        n*=2;
        current=next=NULL;
     }
    }
};
int main() {
    Solution s;

    return 0;
}

