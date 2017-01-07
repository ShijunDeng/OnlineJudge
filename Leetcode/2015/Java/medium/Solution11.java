package com.whitedew.algorithm.medium;

import org.junit.Test;

public class Solution11 {
	public int findKthLargest(int[] nums, int k) {
		int len = nums.length;
		return findKthLargest(nums, k, 0, len - 1);

	}

	private int findKthLargest(int[] nums, int k, int low, int high) {

		int piovt = nums[low];
		int tmpLow = low;
		int tmpHigh = high;
		while (low < high) {
			while (low < high && nums[high] >= piovt) {
				high--;
			}
			nums[low] = nums[high];
			while (low < high && nums[low] <= piovt) {
				low++;
			}
			nums[high] = nums[low];
		}
		nums[low]=piovt;
		if (low == nums.length - k) {
			return nums[low];
		} else if (low < nums.length - k) {
			return findKthLargest(nums, k, low + 1, tmpHigh);
		} else {
			return findKthLargest(nums, k, tmpLow, low - 1);
		}
	}

	@Test
	public void test() {
		int nums[]={4,4};
		System.out.println(new Solution11().findKthLargest(nums,1));
	}
}
