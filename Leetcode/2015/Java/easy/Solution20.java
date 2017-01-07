package com.whitedew.algorithm.easy;

public class Solution20 {
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		int cx = x;
		int reverseNum = 0;
		int tmp = 0;
		while (x > 0) {
			tmp = x % 10;
			reverseNum = (reverseNum << 3) + (reverseNum << 1) + tmp;
			x /= 10;
		}
		return reverseNum == cx;
	}
}