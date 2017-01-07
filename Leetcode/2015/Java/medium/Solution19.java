package com.whitedew.algorithm.medium;

public class Solution19 {
	public int rangeBitwiseAnd(int m, int n) {
		int d = Integer.MAX_VALUE;
		while ((m & d) != (n & d)) {
			d <<= 1;
		}
		return m & d;
	}

}
