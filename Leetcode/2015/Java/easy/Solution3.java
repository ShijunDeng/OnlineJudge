package com.whitedew.algorithm.easy;

import java.util.*;

public class Solution3 {
	private int factorPow(int x) {
		List<Integer> factors = new ArrayList<Integer>();
		while (x != 0) {
			factors.add(x % 10);
			x /= 10;
		}
		int sum = 0;
		for (int e : factors) {
			sum += (e * e);
		}
		return sum;
	}

	public boolean isHappy(int n) {
		HashSet<Integer> records = new HashSet<Integer>();
		if (n == 1) {
			return true;
		}
		records.add(n);
		while (n != 1) {

			n = factorPow(n);
			if (n == 1) {
				return true;
			}
			if (records.contains(n)) {
				return false;
			} else {
				records.add(n);
			}
		}
		return false;
	}
}