package com.whitedew.algorithm.easy;

public class Solution4 {
	public int rob(int[] nums) {
		int numsLen = nums.length;
		int maxV[] = new int[numsLen];
		if (numsLen == 0) {
			return 0;
		}
		if (numsLen == 1) {
			return nums[0];
		}
		maxV[0] = nums[0];
		maxV[1] = Math.max(maxV[0], nums[1]);
		for (int i = 2; i < numsLen; i++) {
			maxV[i] = Math.max(maxV[i - 2] + nums[i], maxV[i - 1]);
		}
		return maxV[numsLen-1];
	}
}