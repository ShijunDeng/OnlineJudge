package cn.sjdeng.demo;

import java.util.ArrayDeque;
import java.util.Queue;
/**
 * 
 * @author ShijunDeng
 * 走迷宫问题  广度优先
 */
public class MazeBFS {
	private int[][] maze;
	private int fromIndexX;
	private int fromIndexY;
	private int toIndexX;
	private int toIndexY;
	/**
	 * move <0,0> 
	 * -------->
	 * | |0| | 
	 * --------
	 * |1|x|3|
	 * --------
	 * | |2| | 
	 * --------<7,7>
	 */
	private int move[][] = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
	private class PathNode {
		private int x;
		private int y;
		private PathNode last;

		public PathNode(int ax, int ay, PathNode alast) {
			this.x = ax;
			this.y = ay;
			this.last = alast;
		}
	}

	public MazeBFS(int[][] amaze, int afromIndexX, int afromIndexY, int atoIndexX, int atoIndexY) {
		this.maze = amaze.clone();
		this.fromIndexX = afromIndexX;
		this.fromIndexY = afromIndexY;
		this.toIndexX = atoIndexX;
		this.toIndexY = atoIndexY;
	}

	private boolean checkWay(int x, int y, int moveDir) {
		x += this.move[moveDir][0];
		y += this.move[moveDir][1];
		// 在迷宫内且有路可走
		return x > -1 && x < 8 && y > -1 && y < 8 && (this.maze[x][y] == 0);
	}

	public void searchPathByBFS() {
		if (this.maze == null) {
			System.out.println("No solution");
			return;
		}
		Queue<PathNode> Q = new ArrayDeque<PathNode>();
		Q.offer(new PathNode(this.fromIndexX, this.fromIndexY, null));
		while (false == Q.isEmpty()) {
			PathNode currentNode = Q.poll();
			if (currentNode.x == this.toIndexX && currentNode.y == this.toIndexY) {
				System.out.println("Find path:");
				while (null != currentNode) {
					System.out.printf("<%d,%d> ", currentNode.x, currentNode.y);
					currentNode = currentNode.last;
				}
				System.out.println();
				return;
			}
			boolean isDeadNode = true;
			for (int i = 0; i < this.move.length; i++) {
				if (this.checkWay(currentNode.x, currentNode.y, i)) {
					this.maze[currentNode.x][currentNode.y] = 1;// 已走过
					Q.offer(new PathNode(currentNode.x + move[i][0], currentNode.y + move[i][1], currentNode));
					isDeadNode = false;
				}
			}
			if (isDeadNode) {
				this.maze[currentNode.x][currentNode.y] = 2;// 死路
			}
		}
		System.out.println("No path!");
	}
}
