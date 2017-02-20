package cn.sjdeng.demo;

/**
 * KnapsackL3的非递归实现：分支限界+回溯
 * 
 * @author ShijunDeng
 *
 */
public class KnapsackL4 {
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
	public KnapsackL4(double weight, double[] w, double[] p) {
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
	public double knapsackL4() {
		int i = 0;
		double sum = 0;
		sort();
		while (true) {
			while (i < n&&i>=0 && total + w[i] <= weight) {
				total += w[i];
				sum += p[i];
				x[i] = 1;
				i++;
			}
			if (i == n && sum > max) {
				max = sum;
				i = n - 1;
				for (int j = 0; j < n; j++) {
					xx[j] = x[j];
				}
			} else if (i < n&&i>=0) {
				x[i]=0;			
			}
			while (bound(total, i + 1, sum) <= max) {// 取等
				while (i >= 0 && x[i] != 1) {
					i--;
				}
				if (i == -1) {
					for (int j = 0; j < n; j++) {
						System.out.printf("货物选择状态 %d  重量 %8.2f  利润 %8.2f\n", xx[j], w[j], p[j]);
						if (xx[j] != 0) {
							total += w[j];
						}
					}
					System.out.printf("总重 %8.2f   获利%8.2f\n", total, max);
					return total;
				}
				x[i] = 0;
				total -= w[i];
				sum -= p[i];				
			}
			i++;
		}
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
}
