package com.whitedew.algorithm.easy;

import org.junit.Test;

public class Solution11 {
	public String longestCommonPrefix(String[] strs) {
		int strsLen = strs.length;
		if (strsLen == 0) {
			return "";
		}
		int len0 = strs[0].length();
		int longestComm = len0;
		for (int i = 1; i < strsLen; i++) {
			longestComm = (int) Math.min(longestComm, strs[i].length());
			for (int j = 0; j < longestComm; j++) {
				if (strs[0].charAt(j) != strs[i].charAt(j)) {
					longestComm = j;
					break;
				}
			}
		}

		return strs[0].substring(0, longestComm);

	}

	@Test
	public void test() {
		//System.out.println(new Solution().longestCommonPrefix(new String[] {"aaa","aa","aaa" }));
	}
}