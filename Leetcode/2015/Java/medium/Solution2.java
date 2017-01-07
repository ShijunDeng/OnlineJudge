package com.whitedew.algorithm.medium;

import java.util.Arrays;

import org.junit.Test;

public class Solution2 {
	public int lengthOfLongestSubstring(String s) {
	if (s == null) {
			return 0;
		}
		s = s.trim();
		int strLen = s.length();
		if (strLen < 2) {
			return strLen;
		}
		int longestLen = Integer.MIN_VALUE;
		int pos[] = new int[256];
		int lastPos = -1;
		Arrays.fill(pos, lastPos);
		for (int i = 0; i < strLen; i++) {
			if (pos[s.charAt(i)] > lastPos) {
				lastPos = pos[s.charAt(i)];
			}
			if (i - lastPos > longestLen) {
				longestLen = i - lastPos;
			}
			pos[s.charAt(i)] = i;

		}
		return longestLen;
	}

	@Test
	public void test() {
		System.out.println(new Solution2().lengthOfLongestSubstring("abcdea123"));
	}
}
