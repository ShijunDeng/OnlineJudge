package cn.sjdeng.demo;

import java.util.Arrays;

/**
 * n个矩阵连乘最少的相乘次数
 * 
 * @author ShijunDeng
 *
 */
public class MinMatrixMultiply {
	private int[] rcTable;// 各个矩阵的行列信息
	private int[][] comb;
	private int[][] m;

	public MinMatrixMultiply(int[] rcTable) {
		super();
		this.rcTable = rcTable;
	}

	public void minMatrixMutiplyRecur() {
		if (rcTable == null) {
			return;
		}
		comb = new int[rcTable.length][rcTable.length];
		m = new int[rcTable.length][rcTable.length];
		for (int[] e : m) {
			Arrays.fill(e, -1);
		}
		System.out.println(courseL2(0, rcTable.length - 2));
	}

	/**
	 * 非递归解决
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	public int minMatrixMutiply() {
		if (rcTable == null) {
			return -1;
		}
		comb = new int[rcTable.length][rcTable.length];
		m = new int[rcTable.length][rcTable.length];
		for (int[] e : m) {
			Arrays.fill(e, -1);
		}
		for (int i = 0; i < rcTable.length - 2; i++) {
			m[i][i] = 0;
			m[i][i + 1] = rcTable[i] * rcTable[i + 1] * rcTable[i + 2];
			comb[i][i + 1] = i;
		}
		m[rcTable.length - 2][rcTable.length - 2] = 0;

		for (int step = 2; step < rcTable.length - 1; step++) {
			for (int startIndex = 0; startIndex < rcTable.length - step - 1; startIndex++) {
				int endIndex = startIndex + step;
				m[startIndex][endIndex] = m[startIndex][startIndex] + m[startIndex + 1][endIndex]
						+ rcTable[startIndex] * rcTable[startIndex + 1] * rcTable[endIndex + 1];
				comb[startIndex][endIndex] = startIndex;
				for (int k = startIndex + 1; k < endIndex; k++) {
					int t = m[startIndex][k] + m[k + 1][endIndex]
							+ rcTable[startIndex] * rcTable[k + 1] * rcTable[endIndex + 1];
					if (t < m[startIndex][endIndex]) {
						m[startIndex][endIndex] = t;
						comb[startIndex][endIndex] = k;
					}
				}
			}
		}
		comb(0,rcTable.length-2);
		return m[0][rcTable.length - 2];
	}
	private void comb(int i,int j){
		if(i==j){
			return;
		}
		comb(i,comb[i][j]);
		comb(comb[i][j]+1,j);
		int a,b;
		if (comb[i][j]==i){
			a=i+1;
		}else{
			a=comb[i][j];
		}
		if(comb[i][j]+1==j){
			b=comb[i][j];
		}else{
			b=comb[i][j]+1;
		}
		System.out.printf("M%d * M%d and M%d * M%d\n",i,a,b,j);
		
	}
	private int courseL2(int i, int j) {
		if (m[i][j] > -1) {
			return m[i][j];
		}
		if (i == j) {
			comb[i][j] = 0;
			m[i][j] = 0;
			return 0;
		} else if (i == j - 1) {
			comb[i][j] = j;
			m[i][j] = rcTable[i] * rcTable[i + 1] * rcTable[i + 2];
			return m[i][j];
		} else {
			m[i][j] = courseL1(i, i) + courseL1(i + 1, j) + rcTable[i] * rcTable[i + 1] * rcTable[j + 1];
			for (int k = i + 1; k < j; k++) {
				int t = courseL1(i, k) + courseL1(k + 1, j) + rcTable[i] * rcTable[k + 1] * rcTable[j + 1];
				if (t < m[i][j]) {
					comb[i][j] = k;
					m[i][j] = t;
				}
			}
			return m[i][j];
		}
	}

	/**
	 * 递归版本
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	private int courseL1(int i, int j) {
		if (i == j) {
			comb[i][j] = 0;
			return 0;
		} else if (i == j - 1) {
			comb[i][j] = j;
			return rcTable[i] * rcTable[i + 1] * rcTable[i + 2];
		} else {
			int u = courseL1(i, i) + courseL1(i + 1, j) + rcTable[i] * rcTable[i + 1] * rcTable[j + 1];
			for (int k = i + 1; k < j; k++) {
				int t = courseL1(i, k) + courseL1(k + 1, j) + rcTable[i] * rcTable[k + 1] * rcTable[j + 1];
				if (t < u) {
					u = t;
					comb[i][j] = k;
				}
			}
			return u;
		}
	}

}
