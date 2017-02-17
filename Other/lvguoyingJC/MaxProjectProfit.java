package cn.sjdeng.demo;

import java.util.Arrays;

/**
 * 资源分配问题 动态规划解决公司最大获利问题 假定每个项目投入的资金只为整数元
 * 
 * @author ShijunDeng
 *
 */
public class MaxProjectProfit {
	private double[][] profitTable;// 利润表
	private int money;// 投入资金

	public MaxProjectProfit(double[][] profitTable, int money) {
		super();
		this.profitTable = profitTable;
		this.money = money;
	}

	public void maxProfit() {
		double[] maxProfitTable = profitTable[1].clone();
		double[] tmp = new double[money + 1];
		int[] allocMoney = new int[profitTable.length + 1];

		Arrays.fill(tmp, 0.0);
		Arrays.fill(allocMoney, 0);
		for (int i = 2; i < profitTable.length; i++) {
			tmp = profitTable[i].clone();
			for (int j = 1; j <= money; j++) {
				for (int k = 0; k <= j; k++) {
					if (maxProfitTable[j - k] + profitTable[i][k] > tmp[j]) {
						tmp[j] = maxProfitTable[j - k] + profitTable[i][k];
						allocMoney[i] = k;
					}
					System.out.printf("%8.2f", maxProfitTable[j - k] + profitTable[i][k]);
				}
				System.out.println();
			}
			for (int j = 1; j <= money; j++) {
				maxProfitTable[j] = tmp[j];
			}
		}
		System.out.println("maxProfit:" + maxProfitTable[money]);
		int[] mt = new int[profitTable.length - 1];
		for (int i = mt.length - 1; i > 0; i--) {
			mt[i] = allocMoney[i + 1];
			money -= allocMoney[i + 1];
		}
		mt[0] = money;
		System.out.println(Arrays.toString(mt));
	}
}
