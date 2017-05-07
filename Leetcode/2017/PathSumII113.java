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
        //searchPathSumRecur(root, sum, 0, new ArrayList<Integer>(), rs); 
        
        TreeNode p = root;
        Stack<TreeNode> S = new Stack<TreeNode>();
        int curSum = 0;
        Map<TreeNode,List<Integer>> map1 = new HashMap<TreeNode,List<Integer>>();
        Map<TreeNode,Integer> map2 = new HashMap<TreeNode,Integer>();
        List<Integer> tmp = new ArrayList<Integer>();
        while (S.isEmpty() == false || p != null) {
            if (p != null) {
                curSum += p.val;
                S.push(p);
                tmp.add(p.val);
                map1.put(p, new ArrayList<Integer>(tmp));
                map2.put(p, curSum);
                if (p.left == null && p.right == null && curSum == sum){
                    rs.add(map1.get(p));
                } 
                p = p.left;
            } else{
                p = S.pop();
                tmp = map1.get(p);
                curSum = map2.get(p);
                p = p.right;
            }
        }
        return rs;
    }
    
    public void searchPathSumRecur(TreeNode root, int sum, int curSum, List<Integer> cur, List<List<Integer>> rs) {
        cur.add(root.val);
        if (root.left == null && root.right == null && curSum + root.val == sum){
            rs.add(new ArrayList<Integer>(cur));
        } else {
            if(root.left != null){
                searchPathSumRecur(root.left, sum, curSum + root.val, new ArrayList<Integer>(cur), rs); 
            } 
            if(root.right != null){
                searchPathSumRecur(root.right, sum, curSum + root.val, new ArrayList<Integer>(cur), rs); 
            }
        }
    }
}