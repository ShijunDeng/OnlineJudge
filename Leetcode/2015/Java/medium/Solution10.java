package com.whitedew.algorithm.medium;

import java.util.Arrays;
import java.util.Set;

import org.junit.Test;

public class Solution10 {
	public boolean wordBreak(String s, Set<String> wordDict) {
		if (s == null || wordDict == null || wordDict.size() == 0) {
			return false;
		}

		int len = s.length();
		boolean[] flags = new boolean[len];
		Arrays.fill(flags, false);

		for (int i = 1; i <= len; i++) {
			if (wordDict.contains(s.substring(0, i))) {
				flags[i - 1] = true;
			} else {
				for (int j = 0; j < i; j++) {
					if (flags[j] && wordDict.contains(s.substring(j + 1, i))) {
						flags[i - 1] = true;
						break;
					}
				}
			}
		}
		return flags[len - 1];
	}

	@Test
	public void test() {

	}
}
