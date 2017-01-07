package com.whitedew.algorithm.medium;

import java.util.Arrays;

import org.junit.Test;

public class Solution16 {
	public int threeSumClosest(int[] nums, int target) {
		int sum = 0;
		int distance = Integer.MAX_VALUE;
		int len = nums.length;
		int closeSum = 0;
		Arrays.sort(nums);
		for (int i = 0; i < len - 2; i++) {
			int j = i + 1;
			int k = len - 1;
			while (j < k) {
				sum = nums[i] + nums[j] + nums[k];
				if (sum == target) {
					distance = 0;
					closeSum = sum;
					return closeSum;
				} else if (sum > target) {
					while (k > j && nums[k] == nums[k - 1]) {
						k--;
					}
					k--;
					if (sum - target < distance) {
						distance = sum - target;
						closeSum = sum;
					}
				} else {
					while (j < k && nums[j] == nums[j + 1]) {
						j++;
					}
					j++;
					if (target - sum < distance) {
						distance = target - sum;
						closeSum = sum;
					}
				}
			}// while
		}// for
		return closeSum;
	}

	@Test
	public void test() {
		int nums[] = { 1, 2, 4, 8, 16, 32, 64, 128 };
		System.out.println(new Solution16().threeSumClosest(nums, 82));

	}
}
