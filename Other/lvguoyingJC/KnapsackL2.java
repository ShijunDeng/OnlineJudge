package cn.sjdeng.demo;

public class KnapsackL2 {
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
	public KnapsackL2(double weight, double[] w, double[] p) {
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
	public double knapsackL2() {
		knapsackL2(0);
		total=0;
		for (int j = 0; j < this.x.length; j++) {
			System.out.printf("%d %8.2f %8.2f\n", xx[j],w[j], p[j]);
			if(xx[j]!=0){
				total += w[j];
			}
		}
		System.out.printf("%8.2f %8.2f\n",total,max);
		return total;
	}

	private void knapsackL2(int i) {
		double sum = 0;
		if (i == n) {
			for (int j = 0; j < this.x.length; j++) {
				sum += p[j] * x[j];
			}
			if (sum > max) {
				max = sum;
				for (int j = 0; j < this.x.length; j++) {
					xx[j] = x[j];
				}
			}
		} else {
			x[i] = 0;
			knapsackL2(i + 1);
			if (total + w[i] <= weight) {
				x[i] = 1;
				total += w[i];
				knapsackL2(i + 1);
				x[i] = 0;
				total -= w[i];
			}
		}
	}
}
