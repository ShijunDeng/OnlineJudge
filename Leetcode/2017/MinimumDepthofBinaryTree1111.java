/*
Given a binary tree, find its minimum depth.The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
*/

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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null || root.right == null) {
            return 1 + (root.left == null ? minDepth(root.right) : minDepth(root.left));
        }
        int hLeft = minDepth(root.left);
        int hRight = minDepth(root.right);
        return 1 + ( hLeft > hRight ? hRight : hLeft );
    }
}