package com.whitedew.algorithm.medium;

import org.junit.Test;

public class CopyOfSolution5 {

	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int min = 0, pos = 0, len = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			min += nums[i];
			while (min >= s) {
				if (len > i - pos + 1) {
					len = i - pos + 1;
				}
				min -= nums[pos];
				pos++;
			}
		}
		return len == Integer.MAX_VALUE ? 0 : len;
	}

	@Test
	public void test() {
		System.out.println(new CopyOfSolution5().minSubArrayLen(11, new int[] {
				1, 2, 3, 4, 5 }));

	}
}
