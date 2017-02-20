package cn.sjdeng.demo;

/**
 * 背包问题
 * 
 * @author ShijunDeng
 *
 */
public class KnapsackL1 {
	private boolean check(int k, int[] rs) {
		if (k == 0) {
			return true;
		}
		return rs[k] > rs[k - 1];

	}
	
	/**
	 * 思想：回溯搜索所有可能性组合 
	 * @param goods
	 *            货物重量数组
	 * @param weight
	 *            背包上限
	 * @param n
	 *            装物件数量
	 * @return
	 */
	public int knapsackL1(int[] goods, int weight, int n) {
		int[] tmp = new int[n];
		int maxW = 0;
		int k = 0;
		tmp[k] = -1;
		while (k >= 0) {
			tmp[k]++;
			while (tmp[k]>=k&&tmp[k] < goods.length-n+k+1&& check(k,tmp)== false) {
				tmp[k]++;
			}				 
			if (tmp[k]>=k&&tmp[k] < goods.length-n+k+1) {
				if (k == n - 1) {
					int sum = 0;
					for (int e : tmp) {
						sum += goods[e];
					}
					if (sum <= weight && weight > maxW) {
						maxW = sum;
					}
				} else {
					k++;
					tmp[k] = tmp[k-1];
				}
			} else {
				k--;
			}
		}
		System.out.println(maxW);
		return maxW;
	}
}
