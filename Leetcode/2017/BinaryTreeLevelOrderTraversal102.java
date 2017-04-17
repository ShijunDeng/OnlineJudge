//102. Binary Tree Level Order Traversal
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rs = new ArrayList<List<Integer>>();
        if (root == null) {
            return rs;
        }
        List<Integer> tmp = new ArrayList<Integer>();
        TreeNode levelTag = new TreeNode(-1);
       	LinkedList<TreeNode> Q = new LinkedList<TreeNode>();  
        TreeNode p = root;
        Q.offer(p);
        Q.offer(levelTag);
        while (Q.isEmpty() ==  false) {
            p = Q.pop();            
            if (p != levelTag) {
                tmp.add(p.val);
                if (p.left != null) {
                    Q.offer(p.left);
                }
                if (p.right != null) {
                    Q.offer(p.right);
                }
            } else if(p == levelTag ){
                rs.add(tmp);
                if(Q.isEmpty() ==  false){
                    tmp = new ArrayList<Integer>();
                    Q.offer(p);
                }
            }
        } 
        return rs;
    }
}