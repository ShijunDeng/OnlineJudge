package com.whitedew.algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class Solution13 {
	Set<String> rsStr = new HashSet<String>();
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> rs = new ArrayList<List<Integer>>();
		int[] data = new int[3];
		Arrays.sort(nums);
		threeSum(nums, 0, 0, 0, data, rs);
		return rs;
	}
	private void threeSum(int[] nums, int index, int cur, int k, int[] data,
			List<List<Integer>> rs) {
		if (cur == 0 && k == 3) {
			List<Integer> eRs = new ArrayList<Integer>();
			String s = "";
			for (int e : data) {
				eRs.add(e);
				s += e;
			}
			if (rsStr.contains(s) == false) {
				rs.add(eRs);
				rsStr.add(s);
			}
		}
		if (index >= nums.length)
			return;
		if (k <= 3)
			threeSum(nums, index + 1, cur, k, data, rs);
		if (k + 1 <= 3) {
			data[k] = nums[index];
			threeSum(nums, index + 1, cur + nums[index], k + 1, data, rs);
		}
	}

	@Test
	public void test() {
		int[] data = { 12,5,-12,4,-11,11,2,7,2,-5,-14,-3,-3,3,2,-10,9,-15,2,14,-3,-15,-3,-14,-1,-7,11,-4,-11,12,-15,-14,2,10,-2,-1,6,7,13,-15,-13,6,-10,-9,-14,7,-12,3,-1,5,2,11,6,14,12,-10,14,0,-7,11,-10,-7,4,-1,-12,-13,13,1,9,3,1,3,-5,6,9,-4,-2,5,14,12,-5,-6,1,8,-15,-10,5,-15,-2,5,3,3,13,-8,-13,8,-5,8,-6,11,-12,3,0,-2,-6,-14,2,0,6,1,-11,9,2,-3,-6,3,3,-15,-5,-14,5,13,-4,-4,-10,-10,11 };
		List<List<Integer>> rs = threeSum(data);
		for (List<Integer> ea : rs) {
			for (int e : ea) {
				System.out.printf("%d ", e);
			}
			System.out.println();
		}

	}
}
