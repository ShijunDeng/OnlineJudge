package cn.sjdeng.demo;

import java.util.Arrays;

/**
 * 动态规划0/1背包问题 局限性：只适用整数部门
 * 
 * @author ShijunDeng
 *
 */
public class KnapsackL6 {
	public KnapsackL6() {
	}

	/**
	 * 暂时不处理：1.背包无法容纳的;2.背包可以装下所有的;
	 * 
	 * @param capacity
	 * @param goodWeight
	 * @param goodProfit
	 */
	public void knapsackL6(int capacity, int[] goodWeight, double[] goodProfit) {
		double[][] dynamic = new double[goodWeight.length][capacity + 1];
		for (double[] e : dynamic) {
			Arrays.fill(e, 0);
		}
		int goodNum = goodWeight.length;

		for (int j = capacity; j >= goodWeight[goodNum - 1]; j--) {
			dynamic[goodNum - 1][j] = goodProfit[goodNum - 1];
		}

		for (int i = goodNum - 2; i >= 0; i--) {
			for (int j = capacity; j >= goodWeight[i]; j--) {
				dynamic[i][j] = Math.max(dynamic[i + 1][j], dynamic[i + 1][j - goodWeight[i]] + goodProfit[i]);
			}
			for (int j = goodWeight[i] - 1; j >= 0; j--) {
				dynamic[i][j] = dynamic[i + 1][j];
			}
		}
		System.out.println("max profit:" + dynamic[0][capacity]);
		
		//那些被选中
		int []choose=new int[goodNum];
		Arrays.fill(choose, 0);
		
		for(int i=0;i<goodNum-1;i++){
			if(dynamic[i][capacity]==dynamic[i+1][capacity]){
				choose[i]=0;
			}else{
				choose[i]=1;
				capacity-=goodWeight[i];
			}
		}
		if(dynamic[goodNum-1][capacity]!=0){
			choose[goodNum-1]=1;
		}
		for(int i=0;i<goodNum;i++){
			if(choose[i]!=0){
				System.out.println("weight:" + goodWeight[i]+" profit:"+goodProfit[i]);
			}
		}
	}
}
