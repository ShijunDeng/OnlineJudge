package cn.sjdeng.demo;

import java.util.Arrays;

/**
 * 找出n个数中r个数的组合
 * 
 * @author ShijunDeng
 *
 */
public class Comb {
	private int n;
	private int r;
	private int index = 0;

	public Comb(int n, int r) {
		super();
		this.n = n;
		this.r = r;
	}

	private boolean check(int k, int[] rs) {
		if (k == 0) {
			return true;
		}
		return rs[k] > rs[k - 1];

	}

	public void comb() {
		int[] rs = new int[r];
		int k = 0;
		rs[k] = 1;
		k++;
		while (k >= 0) {
			rs[k]++;
			while ((rs[k] <= this.n - this.r + k + 1 && rs[k] >= k && check(k, rs) == false)) {
				rs[k]++;
			}
			if ((rs[k] <= this.n - this.r + k + 1 && rs[k] >= k + 1)) {
				if (k == this.r - 1) {
					System.out.println((++this.index)+":"+Arrays.toString(rs));
				} else {
					k++;
					rs[k] = rs[k - 1];
				}
			} else {
				k--;
			}
		}

	}

	public void combRecur() {
		int[] rs = new int[r];
		combRecur(n, r, rs);
	}

	private void combRecur(int an, int ar, int[] rs) {
		if (ar == 0) {
			System.out.println((++index) + ":" + Arrays.toString(rs));
			return;
		}
		for (int i = an; i >= ar; i--) {
			rs[ar - 1] = i;
			combRecur(i - 1, ar - 1, rs);
		}
	}

}
