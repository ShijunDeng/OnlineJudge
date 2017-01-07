package com.whitedew.algorithm.easy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.whitedew.algorithm.utils.PrintUtil;

public class Solution35 {
	public List<String> summaryRanges(int[] nums) {
		List<String> rs = new ArrayList<String>();
		int len = nums.length;
		if (len == 0) {
			return rs;
		}
		int i = 0;
		while (i < len) {
			int begin = nums[i];
			int index = begin;
			int tmp = begin;
			while (i < len && index == begin) {
				index++;
				i++;
				if (i < len) {
					begin = nums[i];
				}
			}
			if (tmp != (nums[i - 1])) {
				rs.add(tmp + "->" + nums[i - 1]);
			} else {
				rs.add(tmp + "");
			}
		}
		return rs;
	}

	@Test
	public void test() {
		int nums[] = new int[] { };
		List<String> rs = new Solution35().summaryRanges(nums);
		PrintUtil.printSL(rs);

	}
}
