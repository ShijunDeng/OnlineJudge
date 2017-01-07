package com.whitedew.algorithm.easy;

public class Solution1 {
	public boolean somorphic(String s, String t) {
		int sLen = s.length();
		int tLen = t.length();
		final char NULL = '\0';
		if (sLen != tLen) {
			return false;
		}
		char[] sArray = s.toCharArray();
		char[] tArray = t.toCharArray();
		for (int i = 0; i < sLen - 1; i++) {
			if (sArray[i] != NULL) {
				for (int j = i + 1; j < sLen; j++) {
					if (sArray[i] == sArray[j] && tArray[i] == tArray[j]) {
						sArray[j] = NULL;
					} else if (sArray[i] == sArray[j] && tArray[i] != tArray[j]) {
						return false;
					}
				}
			}
		}
		return true;
	}
	public boolean isIsomorphic(String s, String t) {
		return somorphic(s,t)&&somorphic(t,s);
	}
	public static void main(String[] args) {
		Solution1 sl = new Solution1();
		System.out.println(sl.isIsomorphic("ab", "aa"));
		System.out.println(sl.isIsomorphic("foo", "bar"));
		System.out.println(sl.isIsomorphic("paper", "title"));
	}
}