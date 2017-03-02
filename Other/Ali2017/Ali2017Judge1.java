package cn.sjdeng.ali;

import java.util.ArrayList;
import java.util.Scanner;
/*
 * 
对于一个长度为N的整型数组A， 数组里所有的数都是正整数，对于两个满足0<=X <= Y <N的整数，A[X], A[X+1] … A[Y]构成A的一个切片，记作(X, Y)。
用三个下标 m1, m2, m3下标满足条件 0 < m1, m1 + 1 < m2, m2 +1 < m3 < N – 1。
可以把这个整型数组分成(0, m1-1), (m1+1, m2-1), (m2+1, m3-1), (m3+1, N-1) 四个切片。如果这四个切片中的整数求和相等，称作“四等分”。
编写一个函数，求一个给定的整型数组是否可以四等分，如果可以，返回一个布尔类型的true，如果不可以返回一个布尔类型的false。
限制条件： 数组A最多有1,000,000项，数组中的整数取值范围介于-1,000,000到1,000,000之间。
要求： 函数的计算复杂度为O(N)，使用的额外存储空间（除了输入的数组之外）最多为O(N)。
例子：
对于数组A=[2, 5, 1, 1, 1, 1, 4, 1, 7, 3, 7] 存在下标 2, 7, 9使得数组分成四个分片[2, 5], [1, 1, 1, 4], [7], [7]，这三个分片内整数之和相等，所以对于这个数组，函数应该返回true。
对于数组 A=[10, 2, 11, 13, 1, 1, 1, 1, 1]， 找不到能把数组四等分的下标，所以函数应该返回false。
 *
 */
public class Ali2017Judge1 {

	/** 请完成下面这个函数，实现题目要求的功能 **/
	/** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^ **/
	static boolean resolve(int[] A) {
		if (A == null || A.length < 8) {
			return false;
		}
		int[] sum = new int[4];
		for (int i = 1; i < A.length - 5; i++) {
			sum[0] = 0;
			for (int t = 0; t < i; t++) {
				sum[0] += A[t];
			}
			for (int j = i + 2; j < A.length - 3; j++) {
				sum[1] = 0;
				for (int t = i + 1; t < j; t++) {
					sum[1] += A[t];
				}
				if (sum[0] != sum[1]) {
					continue;
				}
				for (int k = j + 2; k < A.length - 1; k++) {
					sum[2] = sum[3] = 0;
					for (int t = j + 1; t < k; t++) {
						sum[2] += A[t];
					}
					if (sum[1] != sum[2]) {
						continue;
					}
					for (int t = k + 1; t < A.length; t++) {
						sum[3] += A[t];
					}
					if (sum[2] == sum[3]) {
						return true;
					}
				}
			}
		}
		return false;

	}

	public static void main(String[] args) {
		ArrayList<Integer> inputs = new ArrayList<Integer>();
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		while (line != null && !line.isEmpty()) {
			int value = Integer.parseInt(line.trim());
			if (value == 0)
				break;
			inputs.add(value);
			line = in.nextLine();
		}
		int[] A = new int[inputs.size()];
		for (int i = 0; i < inputs.size(); i++) {
			A[i] = inputs.get(i).intValue();
		}
		Boolean res = resolve(A);

		System.out.println(String.valueOf(res));
	}
}