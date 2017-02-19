package cn.sjdeng.demo;

/**
 * 三个数的最小公倍数
 * 
 * @author ShijunDeng
 *
 */
public class GCM {

	private int gcd(int a, int b) {
		int c = a % b;
		while (c != 0) {
			a = b;
			b = c;
			c = a % b;
		}
		return b;
	}

	private int gcm(int a, int b) {
		return (int) a * b / gcd(a, b);
	}

	public int gcm(int... number) {
		if (number.length == 1) {
			return number[0];
		}
		for (int i = 1; i < number.length-1; i++) {
			number[i] = gcm(number[i], number[i + 1]);
		}
		return number[number.length - 2];
	}

}
