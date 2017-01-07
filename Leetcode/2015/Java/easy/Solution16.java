package com.whitedew.algorithm.easy;

import org.junit.Test;

public class Solution16{
	public String convert(String s, int numRows) {
		if (numRows == 1)
			return s;
		int len = s.length();
		if (len == 1)
			return s;
		StringBuffer sArray = new StringBuffer();
		int stepA = 2 * numRows - 2;
		int stepB = 2;
		int step = stepA;
		for (int j = 0; j < len; j += step) {
			sArray.append(s.charAt(j));
		}
		stepA -= 2;
		for (int i = 1; i < numRows - 1; i++) {
			step = stepB;
			for (int j = i; j < len; j += step) {
				sArray.append(s.charAt(j));
				if (step == stepA)
					step = stepB;
				else
					step = stepA;
			}
			stepA -= 2;
			stepB += 2;
		}
		step = stepB;
		for (int j = numRows - 1; j < len; j += step) {
			sArray.append(s.charAt(j));
		}
		return sArray.toString();
	}

	@Test
	public void test() {
		//System.out.println(new Solution().convert("ABCDEF", 4));
	}
}