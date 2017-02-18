package cn.sjdeng.demo;

import java.util.Arrays;

public class CommSequence {
	private char[] strArray1;
	private char[] strArray2;

	public CommSequence() {
		super();
	}

	public int getLongestCommSequence(String str1, String str2) {
		int longest = 0;
		if (null == str1 || null == str2) {
			return longest;
		}
		this.strArray1 = str1.toCharArray();
		this.strArray2 = str2.toCharArray();
		int[][] commLenArray = new int[str1.length()][str2.length()];
		for (int[] e : commLenArray) {
			Arrays.fill(e, 0);
		}
		longest = lscLen(str1.length() - 1, str2.length() - 1, commLenArray);
		System.out.println(longest);
		for (int[] e : commLenArray) {
			System.out.println(Arrays.toString(e));

		}
		char[] comm = new char[longest];
		buildLcs(longest - 1, str1.length() - 1, str2.length() - 1, commLenArray, comm);
		System.out.println("comm:" + String.valueOf(comm));
		return longest;
	}

	private int lscLen(int length1, int length2, int[][] commLenArray) {
		int t1, t2;
		if (length1 == 0 || length2 == 0) {
			if (strArray1[length1] == strArray2[length2]) {
				commLenArray[length1][length2] = 1;
			} else {
				commLenArray[length1][length2] = 0;
			}
		} else {
			if (strArray1[length1] == strArray2[length2]) {
				commLenArray[length1][length2] = lscLen(length1 - 1, length2 - 1, commLenArray) + 1;
			} else {
				t1 = lscLen(length1, length2 - 1, commLenArray);
				t2 = lscLen(length1 - 1, length2, commLenArray);
				if (t1 > t2) {
					commLenArray[length1][length2] = t1;
				} else {
					commLenArray[length1][length2] = t2;
				}
			}
		}
		return commLenArray[length1][length2];
	}

	private void buildLcs(int k, int i, int j, int[][] commLenArray, char[] comm) {
		if (i == 0 || j == 0) {
			if (commLenArray[i][j] == 1) {
				comm[k] = strArray1[i];
			}
			return;
		}
		if (commLenArray[i][j] == commLenArray[i][j - 1]) {
			buildLcs(k, i, j - 1, commLenArray, comm);
		} else if (commLenArray[i][j] == commLenArray[i - 1][j]) {
			buildLcs(k, i - 1, j, commLenArray, comm);
		} else {
				comm[k] = strArray1[i];
				buildLcs(k - 1, i - 1, j - 1, commLenArray, comm);
		}
	}

}
