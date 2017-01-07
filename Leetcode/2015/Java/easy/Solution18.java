package com.whitedew.algorithm.easy;

import org.junit.Test;

public class Solution18 {
	public int reverse(int x) {
		int reverseNum = 0;
		int tmp = 0;
		int mark = 1;
		if (x < 0) {
			mark = -1;
			x = -x;
		}
		while (x > 0) {
			tmp = x % 10;
			if (Math.abs(reverseNum) > Integer.MAX_VALUE / 10)
				return 0;
			reverseNum = (reverseNum << 3) + (reverseNum << 1) + tmp;
			x /= 10;
		}
		return reverseNum * mark;
	}

	@Test
	public void test() {
		//System.out.println(new Solution().reverse(1534236469));
	}
}