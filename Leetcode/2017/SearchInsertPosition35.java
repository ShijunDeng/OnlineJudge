package cn.sjdeng.leetcode;

/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0

Subscribe to see which companies asked this question.
 */
public class SearchInsertPosition35 {
	public int searchInsert(int[] nums, int target) {
		int length = nums.length;
		if (nums == null || length == 0) {
			return 0;
		}
		int low = 0;
		int high = length - 1;
		int mid = 0;
		while (low < high) {
			mid = (low + high) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				high = mid-1;
			} else {
				low = mid+1;
			}
		}
		return high+1;
	}
}
