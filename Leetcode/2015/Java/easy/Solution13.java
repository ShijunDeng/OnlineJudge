package com.whitedew.algorithm.easy;

import org.junit.Test;

public class Solution13 {
	public int titleToNumber(String s) {
		int sum = 0;
		int step=1;
		int len = s.length() - 1;
		for (int i = len; i >= 0; i--) {
			sum += (s.charAt(i) - 64) * step;
			step*=26;
		}
		return sum;
	}

	@Test
	public void test() {
		System.out.println(new Solution13().titleToNumber("BA"));
		System.out.println(new Solution13().titleToNumber("AA"));
		System.out.println(new Solution13().titleToNumber("A"));
		System.out.println(new Solution13().titleToNumber("AAA"));
		System.out.println(new Solution13().titleToNumber("ABA"));

	}
}