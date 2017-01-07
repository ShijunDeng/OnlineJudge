package com.whitedew.algorithm.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import org.junit.Test;

import com.whitedew.algorithm.utils.PrintUtil;

public class Solution17 {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> rs = new ArrayList<List<Integer>>();
		Set<List<Integer>>repeatRs=new HashSet<List<Integer>>();
		List<Integer> element;
		int sum = 0;
		int distance = Integer.MAX_VALUE;
		int len = nums.length;	
		Arrays.sort(nums);
		for (int i = 0, r = len - 1; i < len - 3; i++) {
			for (int j = i + 1; j < len - 2; j++) {
				distance = Integer.MAX_VALUE;
				r = len - 1;
				int k = j + 1;
				while (k < r) {
					sum = nums[i] + nums[j] + nums[k] + nums[r];
					if (sum == target) {
						element = new ArrayList<Integer>();
						element.add(nums[i]);
						element.add(nums[j]);
						element.add(nums[k]);
						element.add(nums[r]);
						repeatRs.add(element);
						k++;
						r--;
						distance = Integer.MAX_VALUE;
					} else if (sum > target) {
						while (r > k && nums[r] == nums[r - 1]) {
							r--;
						}
						r--;
						if (sum - target < distance) {
							distance = sum - target;
						}
					} else {
						while (k < r && nums[k] == nums[k + 1]) {
							k++;
						}
						k++;
						if (target - sum < distance) {
							distance = target - sum;
						}
					}
				}// while
			}// for...j
		}// for...i	
		for(List<Integer>e:repeatRs){
			rs.add(e);
		}
		return rs;
	}
	
	@Test
	public void test() {
		int nums[] = {-3,-2,-1,0,0,1,2,3};
		//new Solution17().fourSum(nums, 0);
		PrintUtil.printILL(new Solution17().fourSum(nums, 0));

	}
}
