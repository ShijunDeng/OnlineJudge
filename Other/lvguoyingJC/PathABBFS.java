package cn.sjdeng.demo;

/**
 * 求从A到B的路径，要求经过的城市数目最少
 */
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class PathABBFS {
	private class PathPoint {
		private int now;
		private PathPoint last;
	}

	public void search(int[][] adjMatrix, int fromIndex, int toIndex) {
		if (adjMatrix == null) {
			System.out.println("No solution");
			return;
		}
		boolean[] visited = new boolean[adjMatrix[0].length];
		Queue<PathPoint> Q = new LinkedList<PathPoint>();
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
		PathPoint q = new PathPoint();
		q.now = fromIndex;
		q.last = null;
		Q.offer(q);
		visited[fromIndex] = true;
		while (Q.isEmpty() == false) {
			PathPoint p = Q.poll();
			if (p.now == toIndex) {
				System.out.println("path from " + fromIndex + " to " + toIndex + ":");
				while (null != p) {
					System.out.print(p.now + " ");
					p = p.last;
				}
				System.out.println();
				return;
			}
			for (int i = 0; i < visited.length; i++) {
				if (adjMatrix[p.now][i] == 1 && visited[i] == false) {
					PathPoint e = new PathPoint();
					e.now = i;
					e.last = p;
					Q.offer(e);
					visited[i] = true;
				}
			}
		}
		System.out.println("path from " + fromIndex + " to " + toIndex + ":No solution");
	}
	@Test
	public void test() {
		int[][] adjMatrix = { { 0, 1, 1, 1, 0, 1, 0, 0, 0 }, { 1, 0, 0, 0, 0, 1, 0, 0, 0 },
				{ 1, 0, 0, 1, 1, 0, 0, 0, 0 }, { 1, 0, 1, 0, 0, 0, 1, 0, 0 }, { 0, 0, 1, 0, 0, 0, 1, 1, 0 },
				{ 1, 1, 0, 0, 0, 0, 0, 1, 0 }, { 0, 0, 0, 1, 1, 0, 0, 1, 0 }, { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0 } };
		this.search(adjMatrix, 0, 7);
		this.search(adjMatrix, 1, 1);
		this.search(adjMatrix, 1, 8);
	}
}
