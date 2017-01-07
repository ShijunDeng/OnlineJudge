package com.whitedew.algorithm.easy;

import org.junit.Test;

public class Solution33 {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G,
			int H) {
		int area = (C - A) * (D - B) + (G - E) * (H - F);
		if (A >= G || B >= H || C <= E || D <= F) {
			return area;
		}

		int top = Math.min(D, H);
		int bottom = Math.max(B, F);
		int left = Math.max(A, E);
		int right = Math.min(C, G);

		return area - (top - bottom) * (right - left);
	}

	@Test
	public void test() {
		System.out.println(new Solution33().computeArea(-2, -2, 2, 2, 3, 3, 4,
				4));

	}

}
