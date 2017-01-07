package com.whitedew.algorithm.easy;

public class Solution9 {
	private void reverse(int[] nums, int low, int high) {
		int tmp = 0;
		while (low < high) {
			tmp = nums[low];
			nums[low] = nums[high];
			nums[high] = tmp;
			high--;
			low++;
		}
	}

	public void rotate(int[] nums, int k) {
		int len=nums.length;
		if(len<2){
			return;
		}
		k%=len;
		k=len-k-1;
		reverse(nums, 0, k);
		reverse(nums, k + 1, len-1);
		reverse(nums, 0, len-1);
	}
}