package cn.sjdeng.demo;

/**
 * 最大子段和问题
 * 
 * @author ShijunDeng
 *
 */
public class MaxSum {
	public int maxSum(int[] number) {
		int max = 0;
		int thisSum = 0;
		int besti = 0, bestj = 0;
		int i = 0;
		for (int j = 0; j < number.length; j++) {
			thisSum += number[j];
			if (thisSum > max) {
				max = thisSum;
				besti = i;
				bestj = j;
			} else if (thisSum < 0) {
				thisSum = 0;
				i = j;
			}
		}
		System.out.println("start:" + besti + " end:" + bestj + " max:" + max);
		return max;
	}
}
