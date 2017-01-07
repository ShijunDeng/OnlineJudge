package com.whitedew.algorithm.easy;

import org.junit.Test;

public class Solution22 {
	public boolean isValid(char c) {
		return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')
				|| (c >= '0' && c <= '9');
	}

	public boolean eq(char c1, char c2) {

		return Character.toLowerCase(c1) == Character.toLowerCase(c2);
	}

	public boolean isPalindrome(String s) {
		int high = s.length() - 1;
		int low = 0;
		while (low < high) {
			while (low < high && isValid(s.charAt(low)) == false)
				low++;
			while (low < high && isValid(s.charAt(high)) == false)
				high--;
			if (eq(s.charAt(low), s.charAt(high)) == false) {
				System.out.println(s.charAt(low));
				System.out.println(s.charAt(high));
				return false;
			}else{
				low++;
				high--;
			}
			
		}
		return true;
	}

	@Test
	public void test() {
		System.out.println(new Solution22().isPalindrome("ab"));

	}
}