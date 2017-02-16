package cn.sjdeng.demo;

import java.util.Arrays;

/**
 * 
 * @author ShijunDeng 数1-n的全排列
 */
public class FullPermutation {
	private int n;
	private int index;

	public FullPermutation(int n) {
		super();
		this.n = n;
		this.index = 0;
	}

	public void permutation() {
		int[] number = new int[n];
		boolean[] visited = new boolean[n];

		int k = 0;
		Arrays.fill(number, 0);
		Arrays.fill(visited, false);
		while (k >= 0) {
			number[k]++;
			while (number[k] <= n && visited[number[k] - 1] == true) {
				number[k]++;
			}
			if (number[k] <= n) {
				visited[number[k] - 1] = true;
				if (k == n - 1) {
					System.out.println((++index) + ":" + Arrays.toString(number));
				} else {
					k++;
					number[k] = 0;
				}
			} else {
				Arrays.fill(visited, false);
				k--;
				for (int i = 0; i < k; i++) {
					visited[number[i] - 1] = true;
				}
			}
		}
	}

	public void permutationBySwap() {
		int[] number = new int[n];
		for(int i=0;i<n;i++){
			number[i]=i+1;
		}
		permutationBySwap(0,number);
	}
	private void swap(int i,int j,int []number){
		int tmp=number[i];
		number[i]=number[j];
		number[j]=tmp;
	}
	/**
	 * 搜索排列树算法框架
	 * @param k
	 * @param number
	 */
	private void permutationBySwap(int k,int []number) {
		if(k>n-1){
			System.out.println((++index) + ":" + Arrays.toString(number));
			return;
		}
		for(int i=k;i<n;i++){
			swap(k,i,number);
			permutationBySwap(k+1,number);
			swap(i,k,number);
		}
	}
}
