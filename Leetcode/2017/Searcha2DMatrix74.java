/*
74. Search a 2D Matrix Add
DescriptionHintsSubmissionsSolutions
Total Accepted: 119174
Total Submissions: 338048
Difficulty: Medium
Contributor: LeetCode
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length ==0) {
            return false;
        }
        
        int row = matrix.length;
        int columns = matrix[0].length;
        int low = 0, high = columns - 1;
        while (low < row && high >= 0) {
            if (matrix[low][high] < target) {
                low++;
            } else if(matrix[low][high] > target){
                high--;
            } else {
                return true;
            }
        }
        return false;
        
    }
}