package com.whitedew.algorithm.medium;

import org.junit.Test;

public class Solution3 {
	private int max(int a, int b) {
		return a > b ? a : b;
	}

	private int min(int a, int b) {
		return a > b ? b : a;
	}

	public int maxProduct(int[] nums) {
		if (nums == null) {
			return 0;
		}
		int len = nums.length;
		int lastMax = nums[0];
		int lastMin = nums[0];
		int curMax = nums[0];
		int curMin = nums[0];
		int maxProduct = nums[0];
		for (int i = 1; i < len; i++) {
			int minTmp = lastMin * nums[i];
			int maxTmp = lastMax * nums[i];
			curMax = max(nums[i], max(minTmp, maxTmp));
			curMin = min(nums[i], min(minTmp, maxTmp));
			lastMax = curMax;
			lastMin = curMin;
			maxProduct = max(maxProduct, curMax);
		}
		return maxProduct;
	}
	@Test
	public void test(){
		System.out.println(new Solution3().maxProduct(new int[]{2,3,-4,3}));
		
	}
}
