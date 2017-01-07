package com.whitedew.algorithm.easy;

public class Solution31 {
    public int removeDuplicates(int[] nums) {
       int i = 1, j = 0;
		int len = nums.length;
		if (len <2)
			return len;
		for (i = 1; i < len; i++) {
			if (nums[j] != nums[i]) {
				nums[++j]=nums[i];
			}
		}
		return j+1;
    }
}