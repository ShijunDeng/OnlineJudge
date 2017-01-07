package com.whitedew.algorithm.medium;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class Solution26 {
	public int ladderLength(String beginWord, String endWord,
			Set<String> wordDict) {
		Set<String> setA = new HashSet<String>();
		Set<String> setB = new HashSet<String>();
		setA.add(beginWord);
		setB.add(endWord);
		wordDict.remove(beginWord);
		wordDict.remove(endWord);
		return getLadderLength(setA, setB, wordDict, 1);
	}

	private int getLadderLength(Set<String> setA, Set<String> setB,
			Set<String> wordDict, int stepNum) {
		// TODO Auto-generated method stub
		if (setA.isEmpty()) {
			return 0;
		}
		Set<String> setC = new HashSet<String>();
		for (String str : setA) {
			StringBuilder strBuilder = new StringBuilder(str);
			for (int i = 0; i < strBuilder.length(); i++) {
				char cTmp = strBuilder.charAt(i);
				for (char c = 'a'; c < 'z'; c++) {
					if (c != cTmp) {
						strBuilder.setCharAt(i, c);
						if (setB.contains(strBuilder.toString())) {
							return stepNum + 1;
						}
						if (wordDict.contains(strBuilder.toString())) {
							setC.add(strBuilder.toString());
							wordDict.remove(strBuilder.toString());
						}
					}
				}
				strBuilder.setCharAt(i, cTmp);
			}
		}
		return setB.size() < setC.size() ? getLadderLength(setB, setC,
				wordDict, stepNum + 1) : getLadderLength(setC, setB, wordDict,
				stepNum + 1);
	}

	@Test
	public void test() {
		String beginWord = "hit";
		String endWord = "cog";
		Integer ii=12;
		System.out.println(12==ii);
		ii=3000;
		System.out.println(3000==ii);
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("hot");
		wordDict.add("dot");
		wordDict.add("dog");
		wordDict.add("lot");
		wordDict.add("log");
		//System.out.println(new Solution26().ladderLength(beginWord, endWord,
			//	wordDict));

	}
}
