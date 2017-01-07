package com.whitedew.algorithm.easy;

import java.util.ArrayList;
import java.util.List;

public class Solution25 {
	public List<Integer> getRow(int rowIndex) {
		int[] elements = new int[rowIndex + 1];
		if (rowIndex == 0)
			elements[0] = 1;
		else if (rowIndex == 1)
			elements[0] = elements[rowIndex] = 1;
		else {
			for (int i = 0; i < rowIndex; i++) {
				elements[0] = elements[rowIndex] = 1;
				for (int j = rowIndex-1; j > 0; j--) {
					elements[j] = elements[j] + elements[j - 1];
				}
			}
		}
		List<Integer> rs = new ArrayList<Integer>();
		for (int i = 0; i < rowIndex + 1; i++) {
			rs.add(elements[i]);
		}
		return rs;
	}
}