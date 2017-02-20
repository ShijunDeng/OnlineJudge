package cn.sjdeng.demo;

public class KnapsackL3 {
	private double weight;
	private int n;
	private double w[];
	private double[] p;
	private int[] x;
	private int[] xx;
	private double max;
	private double total;

	/**
	 * 
	 * @param weight
	 *            背包容量
	 * @param n
	 *            种类
	 * @param w
	 *            每种物品的数量
	 * @param p
	 *            利润表
	 * @return
	 */
	public KnapsackL3(double weight, double[] w, double[] p) {
		super();
		this.weight = weight;
		this.n = w.length;
		this.w = w;
		this.p = p;
		this.x = new int[n];
		this.xx = new int[n];
		this.max = 0.0;
		this.total = 0.0;
	}

	private double bound(double tw, int k, double sum) {
		for (int i = k; i < n; i++) {
			tw += w[i];
			if (tw <= weight) {
				sum += p[i];
			} else {
				return ((weight - tw) / w[i] + 1) * p[i] + sum;
			}
		}
		return sum;
	}

	/**
	 * 
	 * @param weight
	 *            背包容量
	 * @param n
	 *            种类
	 * @param w
	 *            每种物品的数量
	 * @param p
	 *            利润表
	 * @return
	 */
	public double knapsackL3() {
		sort();
		knapsackL3(0, 0);
		total = 0;
		for (int j = 0; j < this.x.length; j++) {
			System.out.printf("货物选择状态 %d  重量 %8.2f  利润 %8.2f\n", xx[j], w[j], p[j]);
			if (xx[j] != 0) {
				total += w[j];
			}
		}
		System.out.printf("总重 %8.2f   获利%8.2f\n", total, max);
		return total;
	}

	private void sort() {
		double[] rate = new double[n];
		for (int i = 0; i < n; i++) {
			rate[i] = p[i] / w[i];
		}
		boolean tag = true;
		for (int i = 0; i < n && tag; i++) {
			tag = false;
			for (int j = 0; j < n - i - 1; j++) {
				if (rate[j] < rate[j + 1]) {
					double tmp = w[j];
					w[j] = w[j + 1];
					w[j + 1] = tmp;
					tmp = p[j];
					p[j] = p[j + 1];
					p[j + 1] = tmp;
					tmp = rate[j];
					rate[j] = rate[j + 1];
					rate[j + 1] = tmp;
					tag = true;
				}
			}
		}
	}

	private void knapsackL3(int i, double sum) {
		if (i == n) {
			if (sum > max) {
				max = sum;
				for (int j = 0; j < this.x.length; j++) {
					xx[j] = x[j];
				}
			}
		} else {
			if (total + w[i] <= weight) {
				x[i] = 1;
				total += w[i];
				sum += p[i];
				knapsackL3(i + 1, sum);
				x[i] = 0;
				total -= w[i];
				sum -= p[i];
			}
			if (bound(total, i + 1, sum) > max) {
				x[i] = 0;
				knapsackL3(i + 1, sum);
			}
		}
	}
}
