package com.whitedew.algorithm.medium;

import org.junit.Test;

public class Solution18 {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas == null) {
			return -1;
		}
		int count = gas.length;
		int n = 0;
		int gasInCar = 0;
		int begin = 0;
		int end = 0;
		int i = 0;
		while (n < count - 1) {
			gasInCar += gas[i] - cost[i];
			if (gasInCar >= 0) {// forward
				end++;
				i = end;
			} else {
				begin--;
				if (begin < 0) {
					begin = count - 1;
				}
				i = begin;
			}

			n++;
		}
		gasInCar += gas[i] - cost[i];
		if (gasInCar >= 0) {
			return begin;
		} else {
			return -1;
		}

	}

	@Test
	public void test() {
		int gas[] = { 2, 3, 1, 4, 10, 1, 3, 3 };
		int cost[] = { 8, 4, 1, 1, 1, 4, 1, 1 };
		System.out.println(new Solution18().canCompleteCircuit(gas, cost));

	}
}
