/*
word-break-ii
时间限制：1秒 空间限制：32768K 热度指数：664
本题知识点： 动态规划 leetcode
 算法知识视频讲解
题目描述

Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
Return all such possible sentences.
For example, given
s ="catsanddog",
dict =["cat", "cats", "and", "sand", "dog"].
A solution is["cats and dog", "cat sand dog"].
*/
package cn.sjdeng.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Main {
	public static List<String> wordBreak1(String s, List<String> wordDict) {
	    return DFS1(s, wordDict, new HashMap<String, LinkedList<String>>());
	}       

	// DFS function returns an array including all substrings derived from s.
	static List<String> DFS1(String s, List<String> wordDict, HashMap<String, LinkedList<String>>map) {
	    if (map.containsKey(s)) 
	        return map.get(s);
	        
	    LinkedList<String>res = new LinkedList<String>();     
	    if (s.length() == 0) {
	        res.add("");
	        return res;
	    }               
	    for (String word : wordDict) {
	        if (s.startsWith(word)) {
	            List<String>sublist = DFS1(s.substring(word.length()), wordDict, map);
	            for (String sub : sublist) 
	                res.add(word + (sub.isEmpty() ? "" : " ") + sub);               
	        }
	    }       
	    map.put(s, res);
	    return res;
	}
	public static ArrayList<String> wordBreak(String s, List<String> dict) {
		ArrayList<String> rs = new ArrayList<String>();
		if (s == null || "".equals(s.trim()) || dict == null || dict.size() == 0) {
			return rs;
		}
		int minStep = s.length();
		int maxStep = 0;
		for (String e : dict) {
			if (minStep > e.length()) {
				minStep = e.length();
			}
			if (maxStep < e.length()) {
				maxStep = e.length();
			}
		}
		int[] rd = new int[s.length() + 1];
		int idx = 0;
		rd[idx++] = 0;
		while (idx > 0) {
			rd[idx] = Math.max(rd[idx - 1] + minStep, rd[idx] + 1);
			while (rd[idx] <= s.length() && false == dict.contains(s.substring(rd[idx - 1], rd[idx]))
					&& rd[idx] - rd[idx - 1] >= minStep && rd[idx] - rd[idx - 1] <= maxStep) {
				rd[idx]++;

			}
			if (rd[idx] <= s.length() && rd[idx] - rd[idx - 1] >= minStep && rd[idx] - rd[idx - 1] <= maxStep) {
				String sentence = "";
				sentence += s.substring(rd[0], rd[1]);
				if (rd[idx] == s.length()) {
					for (int i = 1; i < idx; i++) {
						sentence += (" " + s.substring(rd[i], rd[i + 1]));
					}
					rs.add(sentence);
				} else {
					idx++;
				}
			} else {
				rd[idx] = 0;
				idx--;
			}
		}
		return rs;
	}

	public static void main(String[] args) {
		List<String> set = new ArrayList<String>();
		set.add("a");
		set.add("aa");
		set.add("aaa");
		set.add("aaaa");
		set.add("aaaaa");
		set.add("aaaaaa");
		set.add("aaaaaaa");
		//set.add("aaaaaaaa");
		//set.add("aaaaaaaaa");
		//set.add("aaaaaaaaaa");
		for (String s : wordBreak(
				"aaaaaaaaaaaaaa",
				set)) {
			System.out.println(s);
		}
	}
}
