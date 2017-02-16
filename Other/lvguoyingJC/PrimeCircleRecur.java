package cn.sjdeng.demo;

import java.util.Arrays;

/**
 * 质数环问题：输入正整数n,把整数1,2,3……,n组成一个环,使得相邻两个整数之和均为素数。输出所有可能的排列方案。这里n<=20。
 */
public class PrimeCircleRecur {
	private int N;
	private int[] number;
	private boolean visited[];

	/**
	 * 判断是否是素数
	 */
	private boolean isPrime(int n) {

		if (n < 2) {
			return false;
		}
		if (n == 2 || n == 3) {
			return true;
		}
		if (n % 6 != 1 && n % 6 != 5) {
			return false;
		}
		for (int i = 5; i * i <= n; i += 6) {
			if (n % i == 0 || n % (i + 2) == 0) {
				return false;
			}
		}
		return true;
	}

	private boolean check(int[] number, int k) {
		if (k == 19)
			return this.isPrime(number[19] + number[0]) && this.isPrime(number[k] + number[k - 1]);
		return this.isPrime(number[k] + number[k - 1]);
	}

	public void primeCircle(int n) {
		this.number = new int[n];
		this.N = n;
		this.visited = new boolean[n];
		this.number[0] = 1;
		this.tryK(1);
		Arrays.fill(visited, false);
		Arrays.fill(number, 0);
	}

	private void tryK(int k) {
		if (k >= this.N) {
			System.out.println(Arrays.toString(this.number));
			return;
		}
		for (int i = 2; i < this.N + 1; i++) {
			this.number[k] = i;
			if (this.check(this.number, k) && this.visited[i - 1] == false) {
				this.visited[i - 1] = true;
				tryK(k + 1);
				Arrays.fill(this.visited, false);
				for (int j = 0; j < k; j++) {
					visited[number[j] - 1] = true;
				}
			}
		}
	}
}
