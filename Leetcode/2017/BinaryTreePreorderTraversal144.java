//144. Binary Tree Preorder Traversal
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
     public List<Integer> preorderTraversal(TreeNode root) {       
        ArrayList<Integer> rs = new ArrayList<Integer>();
        if (root == null) {
            return rs;
        }
       	Stack<TreeNode> S = new Stack<TreeNode>();  
        TreeNode p = root;
        while (S.isEmpty() ==  false || p != null) {
            if (p != null) {
                rs.add(p.val);
                S.push(p);
                p = p.left;
            }
            else {
                p = S.pop();
                p = p.right;
            }            
        } 
        return rs;
    }
}