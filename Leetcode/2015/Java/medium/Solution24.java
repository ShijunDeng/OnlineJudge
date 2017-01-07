package com.whitedew.algorithm.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import com.whitedew.algorithm.utils.PrintUtil;

public class Solution24 {
	private int r[] = { 0, 1, 0, -1 };
	private int c[] = { -1, 0, 1, 0 };

	public void solve(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}
		Queue<int[]> Q = new LinkedList<int[]>();// int[2]:0 x,1 y
		Queue<int[]> routes = new LinkedList<int[]>();// int[2]:0 x,1 y
		int row = board.length;
		int column = board[0].length;
		boolean[][] visited = new boolean[row][column];
		for (int i = 0; i < row; i++) {
			Arrays.fill(visited[i], false);
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				boolean surrounded = true;
				if (visited[i][j] == false && board[i][j] == 'O') {
					int[] beginPos = new int[] { i, j };
					Q.offer(beginPos);
					visited[beginPos[0]][beginPos[1]] = true;
					if (i == 0 || i == row - 1 || j == 0 || j == column - 1) {
						surrounded = false;
						routes.clear();
					}
					if (surrounded)
						routes.add(beginPos);
					while (Q.isEmpty() == false) {
						int[] pos = Q.poll();
						for (int k = 0; k < 4; k++) {
							int newRPos = pos[0] + r[k];
							int newCPos = pos[1] + c[k];
							if (newRPos >= 0 && newRPos < row && newCPos >= 0
									&& newCPos < column
									&& visited[newRPos][newCPos] == false) {
								visited[newRPos][newCPos] = true;
								if (board[newRPos][newCPos] == 'O') {
									int[] newPos = new int[] { newRPos, newCPos };
									Q.offer(newPos);
									if (newRPos == 0 || newRPos == row - 1
											|| newCPos == 0
											|| newCPos == column - 1) {
										surrounded = false;
										routes.clear();
									}
									if (surrounded)
										routes.add(newPos);
								}
							}
						}// for k
					}// while Q
					if (surrounded == true) {
						for (int[] pos : routes) {
							board[pos[0]][pos[1]] = 'X';
						}
						routes.clear();
					}
				}// if (board[i][j] == 'O')
			}// for j
		}// for i
	}

	@Test
	public void test() {

		//char[][] board = new char[][] { { 'X', 'X', 'X', 'X' },
				//{ 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				//{ 'X', 'O', 'X', 'X' } };
		//board = new char[][] { { 'O', 'X', 'O' }, { 'X', 'O', 'X' },
			//	{ 'O', 'X', 'O' } };
		char[][] board=new char[10][] ;
		String []S={"XOXOXOOOXO","XOOXXXOOOX","OOOOOOOOXX","OOOOOOXOOX","OOXXOXXOOO","XOOXXXOXXO","XOXOOXXOXO","XXOXXOXOOX","OOOOXOXOXO","XXOXXXXOOO"};
		int i=0;
		for(String s:S){
			board[i++]=s.toCharArray();
			
		}
		solve(board);
		PrintUtil.print2AR(board);

	}
}
