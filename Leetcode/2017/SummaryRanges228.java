package cn.sjdeng.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 *
 */
public class SummaryRanges228 {
	public List<String> summaryRanges(int[] nums) {
		List<String> rs = new ArrayList<String>();
		if (nums == null) {
			return rs;
		}
		if (nums.length == 1) {
			rs.add(nums[0] + "");
			return rs;
		}
		for (int i = 0; i < nums.length; i++) {
			int j = i + 1;
			while (j < nums.length && nums[j] == nums[j - 1] + 1) {
				j++;
			}
			if (j == i + 1) {
				rs.add(nums[i] + "");
			} else {
				rs.add(nums[i] + "->" + nums[j - 1]);
				i = j - 1;
			}
		}
		return rs;
	}
}
