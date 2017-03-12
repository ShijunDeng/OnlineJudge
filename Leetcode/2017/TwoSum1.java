package cn.sjdeng.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
Total Accepted: 447649
Total Submissions: 1420445
Difficulty: Easy
Contributors: Admin
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
Subscribe to see which companies asked this question.
 */
public class TwoSum1 {
	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(target - numbers[i])) {
				result[1] = i + 1;
				result[0] = map.get(target - numbers[i]);
				return result;
			}
			map.put(numbers[i], i + 1);
		}
		return result;
	}
}
