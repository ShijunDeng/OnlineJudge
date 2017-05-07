/*
113. Path Sum II 
DescriptionHintsSubmissionsSolutions
Total Accepted: 121930
Total Submissions: 373158
Difficulty: Medium
Contributor: LeetCode
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> rs = new ArrayList<List<Integer>>();
        if (root == null) {
            return rs;
        }
        searchPathSum(root, sum, 0, new ArrayList<Integer>(), rs); 
        return rs;
    }
    
    public void searchPathSum(TreeNode root, int sum, int curSum, List<Integer> cur, List<List<Integer>> rs) {
        cur.add(root.val);
        if (root.left == null && root.right == null && curSum + root.val == sum){
            rs.add(new ArrayList<Integer>(cur));
        } else {
            if(root.left != null){
                searchPathSum(root.left, sum, curSum + root.val, new ArrayList<Integer>(cur), rs); 
            } 
            if(root.right != null){
                searchPathSum(root.right, sum, curSum + root.val, new ArrayList<Integer>(cur), rs); 
            }
        }
    }
}