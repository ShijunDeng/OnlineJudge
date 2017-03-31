/*
二叉搜索树的第k个结点
时间限制：1秒 空间限制：32768K 热度指数：4713
 算法知识视频讲解
题目描述
给定一颗二叉搜索树，请找出其中的第k大的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4
*/
/*
struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
    TreeNode(int x) :
            val(x), left(NULL), right(NULL) {
    }
};
*/
class Solution
{
    public:
        TreeNode* KthNode(TreeNode* pRoot, unsigned int k)
        {
            if(pRoot==nullptr || k==0)
                return nullptr;
            return KthNodeCore(pRoot,k);
        }
        TreeNode *KthNodeCore(TreeNode *root, unsigned int& k)
        {
            TreeNode *target = nullptr;
 
            if(root->left!=nullptr)
                target = KthNodeCore(root->left,k);
 
            if(target==nullptr)
            {
                if(k==1)
                    target=root;
                k--;
            }
 
            if(target==nullptr && root->right!=nullptr)
                target = KthNodeCore(root->right,k);
 
            return target;
        }
};