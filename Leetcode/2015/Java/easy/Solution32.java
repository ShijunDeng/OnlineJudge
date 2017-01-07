package com.whitedew.algorithm.easy;

public class Solution32 {
	public int removeElement(int[] nums, int val) {
		int k = 0, i = 0;
		while (i < nums.length) {
			if (val == nums[i]) {
				k++;
			} else {
				nums[i - k] = nums[i];
			}
			i++;
		}
		return nums.length - k;
	}
}
