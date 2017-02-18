package cn.sjdeng.demo;

/**
 * 
 * @author ShijunDeng
 *
 */

public class MaxAscend {
	public void maxAscend(int[] number) {
		if (number == null) {
			return;
		}
		int numLen = number.length;
		int[] max = new int[numLen];
		int[] next = new int[numLen];
		int totalMax = 1;
		int startIndex = 0;
		for (int i = 0; i < numLen; i++) {
			max[i] = 1;
			next[i] = -1;
		}
		for (int i = numLen - 2; i >= 0; i--) {
			int tMax = 0;
			int tNext = -1;
			for (int j = i + 1; j < numLen; j++) {
				if (number[j] > number[i] && max[j] > tMax) {
					tNext = j;
					tMax = max[j];

				}
			}
			if (tNext != -1) {
				next[i] = tNext;
				max[i] = tMax + 1;
				if (max[i] > totalMax) {
					totalMax = max[i];
					startIndex = i;
				}
			}
		}
		System.out.println("max:" + totalMax);
		for (int i = startIndex; i < numLen && i >=0; i = next[i]) {
			System.out.printf("%d ", number[i]);
		}
		System.out.println();
	}

}
