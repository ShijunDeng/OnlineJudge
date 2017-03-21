/*
最小的K个数
时间限制：1秒 空间限制：32768K 热度指数：9333
本题知识点： 数组
 算法知识视频讲解
题目描述
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
*/

import java.util.ArrayList;
public class Solution {
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> rs = new ArrayList<Integer>();
		if (input == null || k > input.length) {
			return rs;
		}
		for (int i = 0; i < k; i++) {
			for (int j = i; j < input.length - 1; j++) {
				if (input[j] < input[j + 1]) {
					input[j] ^= input[j + 1];
					input[j + 1] ^= input[j];
					input[j] ^= input[j + 1];
				}
			}
			rs.add(input[input.length - 1 - i]);
		}

		return rs;
	}
}
