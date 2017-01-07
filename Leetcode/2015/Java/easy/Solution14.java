package com.whitedew.algorithm.easy;

import org.junit.Test;

public class Solution14 {
	public String convertToTitle(int n) {
		StringBuffer str = new StringBuffer();
		while (n > 0) {
			char c = (char) ((n-1 )% 26 + 65);
			str.insert(0, c);
			n=(n-1) /26;
		}
		return str.toString();
	}

	@Test
	public void test() {
		System.out.println(Double.doubleToLongBits(1));
		System.out.println(Integer.toHexString(-8));
	}
}