package cn.sjdeng.demo;

import java.util.Arrays;

/**
 * 
 * @author ShijunDeng 回溯法解决N皇后问题
 */
public class QueenNBackdateRecur {
	/**
	 * 检测第k个皇后和[0,k-1]个皇后是否冲突
	 * 
	 * @return
	 */
	private int[] pos;
	private static int solutionNum = 0;
	private int N=0;


	private boolean check(int k,int x) {
		for (int i = 0; i < k; i++) {
			if (this.pos[i] == x || Math.abs(this.pos[i] - x) == Math.abs(i - k)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 递归
	 * 
	 * @param n
	 */
	public void search(int n) {
		this.pos = new int[n];
		this.N=n;
		this.tryK(0);
	}
	
	private void tryK(int k){
		for(int i=0;i<this.N;i++){
			if(this.check(k,i)){
				this.pos[k] = i;
				if (k == this.N - 1) {
					solutionNum++;
					System.out.println(solutionNum + ":" + Arrays.toString(this.pos));
				} else {
					tryK(k + 1);
				}
			}
			
		}
	}
}
