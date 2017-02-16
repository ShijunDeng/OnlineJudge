package cn.sjdeng.demo;

import java.util.Arrays;

/**
 * 搜索排列树方法解决N皇后问题
 * 
 * @author ShijunDeng
 *
 */
public class QueenNPerTree {

	private int n;
	private int index;
	private int[] number;
	private boolean diag[][];// 标记主副对角线占用

	public QueenNPerTree(int n) {
		super();
		this.n = n;
		this.number = new int[n];
		this.diag = new boolean[2][2 * n];// 0主 1副
		this.index = 0;
		Arrays.fill(this.diag[0], false);// i-j+n
		Arrays.fill(this.diag[1], false);// i+j
		for (int i = 0; i < n; i++) {
			this.number[i] = i + 1;
		}
	}

	public void queenNbySearchPermutationTree() {
		queenNbySearchPermutationTree(0);
	}

	private void swap(int i, int j, int[] number) {
		int tmp = number[i];
		number[i] = number[j];
		number[j] = tmp;
	}

	private void queenNbySearchPermutationTree(int k) {
		if (k >n - 1) {//注意不能取等：能到n-1，并不一定合格，因为刚好n-1出有问题
			System.out.println((++index) + ":" + Arrays.toString(number));
			return;
		}
		for (int i = k; i < n; i++) {
			swap(k, i, number);
			if (!(diag[0][k - number[k] + n] || diag[1][k + number[k]])) {
				diag[0][k - number[k] + n] = true;
				diag[1][k + number[k]] = true;
				queenNbySearchPermutationTree(k + 1);
				diag[0][k - number[k] + n] = false;
				diag[1][k + number[k]] = false;
			}
			swap(i, k, number);
		}
	}

}
