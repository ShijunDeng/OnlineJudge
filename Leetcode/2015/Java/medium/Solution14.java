package com.whitedew.algorithm.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class Solution14 {
	private Map<Integer, String> basics = new HashMap<Integer, String>();
	private void initialize() {
		basics.put(0, "");
		basics.put(1, "");
		basics.put(2, "abc");
		basics.put(3, "def");
		basics.put(4, "ghi");
		basics.put(5, "jkl");
		basics.put(6, "mno");
		basics.put(7, "pqrs");
		basics.put(8, "tuv");
		basics.put(9, "wxyz");
	}

	public List<String> letterCombinations(String digits) {
		initialize();
		List<String> rs = new ArrayList<String>();
		if (digits == null || digits.trim().equals(""))
			return rs;
		String cur = "";
		match(digits.toCharArray(), rs, cur, 0);
		return rs;
	}

	private void match(char[] digits, List<String> rs, String cur, int index) {
		if (index == digits.length) {
			rs.add(cur);
			return;
		}
		char[] strArray = basics.get((digits[index] - '0')).toCharArray();
		for (int i = 0; i < strArray.length; i++) {
			match(digits, rs, cur + strArray[i], index + 1);
		}
	}

	@Test
	public void test() {
		String s = "2";
		List<String> rs = letterCombinations(s);
		for (String e : rs) {
			System.out.println(e);
		}
	}
}
