package cn.sjdeng.leetcode;

import java.util.ArrayList;
import java.util.List;

/*Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/
public class SpiralMatrix54 {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> rs = new ArrayList<Integer>();
		if (matrix != null && matrix.length != 0) {
			int rowNum = matrix.length;
			int columnNum = matrix[0].length;
			int starti = 0, startj = 0, endi = rowNum - 1, endj = columnNum - 1;
			while (starti <= endi && startj <= endj) {
				for (int i = startj; i <= endj; i++) {
					rs.add(matrix[starti][i]);
				}
				for (int i = starti + 1; i <= endi; i++) {
					rs.add(matrix[i][endj]);
				}
				if (endi > starti) {
					for (int i = endj - 1; i >= startj; i--) {
						rs.add(matrix[endi][i]);
					}
				}
				if (endj > startj) {
					for (int i = endi - 1; i > starti; i--) {
						rs.add(matrix[i][startj]);
					}
				}
				starti++;
				endi--;
				startj++;
				endj--;
			}
		}
		return rs;
	}
}
