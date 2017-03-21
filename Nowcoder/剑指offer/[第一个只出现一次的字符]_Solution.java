/*
第一个只出现一次的字符
时间限制：1秒 空间限制：32768K 热度指数：8025
本题知识点： 字符串
 算法知识视频讲解
题目描述
在一个字符串(1<=字符串长度<=10000，全部由大写字母组成)中找到第一个只出现一次的字符,并返回它的位置
*/
public class Solution {
  public int FirstNotRepeatingChar(String str) {
		if (str == null) {
			return -1;
		}
		int[] counter = new int[100];
		for (char c : str.toCharArray()) {
			counter[c - 65]++;
		}
		for (int i = 0; i < str.length(); i++) {
			if (counter[str.charAt(i) - 65] == 1) {
				return i;
			}
		}
		return -1;
	}
}