package com.whitedew.algorithm.easy;

public class Solution6 {
	public int majorityElement(int[] nums) {
		int count = 0;
		int mainElement = nums[0];
		for (int i = 0, len = nums.length; i < len; i++) {
			if (nums[i] == mainElement) {
				count++;
			} else {
				if (count > 0) {
					count--;
				} else {
					mainElement = nums[i];
					count = 1;
				}
			}
		}
		return mainElement;
	}
}