package com.whitedew.algorithm.medium;

import org.junit.Test;

public class Solution20 {
	private int x[] = { 0, 1, 0, -1 };
	private int y[] = { 1, 0, -1, 0 };

	private int gridRowSize = 0;
	private int gridColSize = 0;
	private int total = 0;

	int dfs(int beginX, int beginY, char[][] grid) {
		int k = 0;

		if ((beginX >= gridRowSize) || (beginX < 0) || (beginY >= gridColSize)
				|| (beginY < 0)) {
			return 1;
		}
		for (k = 0; k < 4; k++) {
			if ((beginX + x[k] < gridRowSize) && (beginX + x[k] >= 0)
					&& (beginY + y[k] < gridColSize) && (beginY + y[k] >= 0)
					&& (grid[beginX + x[k]][beginY + y[k]] == '1')) {
				grid[beginX + x[k]][beginY + y[k]] = '0';
				total++;
				dfs(beginX + x[k], beginY + y[k], grid);
			}
		}
		return 1;
	}

	public int numIslands(char[][] grid) {
		if (grid == null) {
			return 0;
		}
		gridRowSize = grid.length;
		if(gridRowSize==0){
		    return 0;
		}
		gridColSize = grid[0].length;
		total = 0;
		int count = 0;
		int nums = gridRowSize * gridColSize;
		for (int i = 0; i < gridRowSize && total < nums; i++) {
			for (int j = 0; j < gridColSize && total < nums; j++) {
				if (grid[i][j] != '1')
					continue;
				dfs(i, j, grid);
				count++;
			}
		}
		return count;
	}

	@Test
	public void test() {

		char[][] grid = { { '1', '1', '0', '0', '0' },
				{ '1', '1', '0', '0', '0', }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };
		System.out.println(new Solution20().numIslands(grid));

	}
}
