package com.whitedew.algorithm.easy;

import org.junit.Test;

public class Solution19 {
	public int myAtoi(String str) {
		if (str == null || str.trim().equals(""))
			return 0;
		long res = 0;
		int len = str.length();
		int mark = 1;
		boolean np = false;
		boolean space = false;
		for (int i = 0; i < len; i++) {
			if (str.charAt(i) == ' ') {
				if (space)
					return 0;

				continue;
			} else if (Character.isDigit(str.charAt(i)) == true) {
				space = true;
				int beginIndex = i;
				while (i < len && Character.isDigit(str.charAt(i)) == true) {
					i++;
				}
				int endIndex = i;
				str = str.substring(beginIndex, endIndex);
				break;
			} else if (str.charAt(i) == '+') {
				space = true;
				if (np)
					return 0;
				np = true;
				continue;
			} else if (str.charAt(i) == '-') {
				space = true;
				if (np)
					return 0;
				np = true;
				mark = -1;
			} else {// 在遇到数字之前就遇到其他的不合法字符
				return 0;
			}
		}
		try {
			res = mark * Long.parseLong(str);
		} catch (RuntimeException e) {
			if (mark > 0)
				return Integer.MAX_VALUE;
			return Integer.MIN_VALUE;
		}
		if (res > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		} else if (res < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		return (int) res;
	}

	@Test
	public void test() {
		//System.out.println(new Solution().myAtoi("2147483648"));
	}
}