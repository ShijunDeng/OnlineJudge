package com.whitedew.algorithm.easy;

public class Solution23 {
	private boolean pair(char c1, char c2) {
		return (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']')
				|| (c1 == '{' && c2 == '}');
	}

	private boolean isLeft(char c) {
		return c == '(' || c == '{' || c == '[';
	}

	private boolean isRight(char c) {
		return c == ')' || c == ']' || c == '}';
	}

	public boolean isValid(String s) {
		int len = s.length();
		if (len == 0)
			return true;
		char[] stack = new char[len];
		int count = 0;
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (isLeft(c)) {
				stack[count++] = c;
			} else if (isRight(c)) {
				if (count > 0 && pair(stack[count - 1], c)) {
					count--;
				} else {
					return false;
				}
			}
		}
		return count==0;

	}
}