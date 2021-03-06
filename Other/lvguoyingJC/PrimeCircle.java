package cn.sjdeng.demo;

import java.util.Arrays;

/**
 * 质数环问题：输入正整数n,把整数1,2,3……,n组成一个环,使得相邻两个整数之和均为素数。输出所有可能的排列方案。这里n<=20。
 */
public class PrimeCircle {
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
		int[] number = new int[n];
		boolean[] visited = new boolean[n];
		int k = 0;
		Arrays.fill(visited, false);
		Arrays.fill(number, 0);
		number[k] = 1;
		visited[k] = true;
		k++;
		while (k > 0) {
			number[k]++;
			while (number[k] <= n && (this.check(number, k) == false || visited[number[k] - 1])) {
				number[k]++;
			}
			if (number[k] <= n) {
				visited[number[k] - 1] = true;
				if (k == n - 1) {
					System.out.println(Arrays.toString(number));
				} else {
					k++;
					number[k] = 0;
				}
			} else {
				Arrays.fill(visited, false);	
				k--;
				for(int i=0;i<k;i++){
					visited[number[i]-1]=true;
				}
							
			}
		}
	}
}
