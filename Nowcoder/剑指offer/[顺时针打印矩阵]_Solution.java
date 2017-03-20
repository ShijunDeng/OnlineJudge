/*
顺时针打印矩阵
时间限制：1秒 空间限制：32768K 热度指数：10734
本题知识点： 数组
 算法知识视频讲解
题目描述
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
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
