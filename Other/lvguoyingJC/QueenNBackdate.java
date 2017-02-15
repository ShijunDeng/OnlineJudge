package cn.sjdeng.demo;

import java.util.Arrays;

/**
 * 
 * @author ShijunDeng 回溯法解决N皇后问题
 */
public class QueenNBackdate {
	/**
	 * 检测第k个皇后和[0,k-1]个皇后是否冲突
	 * 
	 * @return
	 */
	private int[] pos;

	private boolean check(int k) {
		for (int i = 0; i < k; i++) {
			if (this.pos[k] == this.pos[i] || Math.abs(this.pos[k] - this.pos[i]) == Math.abs(k - i)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 非递归
	 * 
	 * @param n
	 */
	public void search(int n) {
		int solutionNum = 0;
		this.pos = new int[n];

		int k = 0;
		this.pos[k] = -1;
		while (k >= 0) {// while 1
			this.pos[k]++;
			while (this.pos[k] < n && this.check(k) == false) {
				this.pos[k]++;
			}
			if (this.pos[k] < n) {
				if (k == n - 1) {
					solutionNum++;
					System.out.println(solutionNum + ":" + Arrays.toString(this.pos));
				} else {
					k++;
					this.pos[k] = -1;
				}
			} else {
				k--;
			}
		} // while 1
	}
}
