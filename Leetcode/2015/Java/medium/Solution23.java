package com.whitedew.algorithm.medium;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

//�����ַ�������
//��̬�滮���ɻ����ַ�������
//��������������������ɻ����ַ����Ļ���

public class Solution23 {
	// ���ɱ�־�����ַ��������飬partitioning_map[i][j]=1�Ļ���
	//������string[i..j]��һ�������ַ���
	void dp(String s, char[][] palindrome_map) {
		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = i; j < s.length(); j++) {
				if (i == j) {
					palindrome_map[i][j] = 1;
				} else {
					if (s.charAt(i) == s.charAt(j)) {
						if (j == i + 1 || palindrome_map[i + 1][j - 1] == 1) {
							palindrome_map[i][j] = 1;
						}
					}
				}
			}
		}
	}

	// �������ɺõĻ��ı��������ַ������л���
	void dfs(String s, int begin, char[][] palindrome_map,
			List<String> array, List<List<String>> result) {
		if (begin == s.length()) {
			result.add(array);
			return;
		}

		for (int i = begin; i < s.length(); i++) {
			if (palindrome_map[begin][i] == 1) {
				ArrayList<String> tmp = new ArrayList<String>(array);
				tmp.add(s.substring(begin, i + 1));
				dfs(s, i + 1, palindrome_map, tmp, result);
			}
		}
	}

	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> array = new ArrayList<String>();

		if (s == null || s.length() == 0) {
			result.add(array);
			return result;
		}
		char[][] palindrome_map = new char[s.length()][s.length()];

		dp(s, palindrome_map);
		dfs(s, 0, palindrome_map, array, result);
		return result;
	}

	@Test
	public void test() {
		String str = "aaaaaaaaaaaaaaaaaaaaa";
		List<List<String>> rs = partition(str);
		for (List<String> rsE : rs) {
			for (String s : rsE) {
				System.out.println(s);
			}
		}

	}

}