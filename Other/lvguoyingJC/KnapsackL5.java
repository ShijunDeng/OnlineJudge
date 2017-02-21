package cn.sjdeng.demo;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 优先级队列搜索算法解0/1背包问题
 * 
 * @author ShijunDeng
 *
 */
public class KnapsackL5 {
	private class SearchNode {
		private int no;
		private int lrChild;// 选择左孩子还是右孩子
		private SearchNode parent;
		private double profit;
		private double weight;

		public SearchNode(int no, int lrChild, SearchNode parent, double profit, double weight) {
			super();
			this.no = no;
			this.lrChild = lrChild;
			this.parent = parent;
			this.profit = profit;
			this.weight = weight;
		}

		public void selfPrint() {
			System.out.println("no:" + no + " lrChild:" + lrChild + " profit:" + profit + " weight:" + weight);
		}
	}// 匿名Comparator实现

	public void knapsackL5(double capacity, double[] goodWeight, double[] goodProfit) {
		Comparator<SearchNode> profitComp = new Comparator<SearchNode>() {
			@Override
			public int compare(SearchNode s1, SearchNode s2) {
				if (s1.profit == s2.profit) {
					return 0;
				}
				return (s1.profit * 1000 > s2.profit * 1000) ? 1 : -1;
			}
		};
		Queue<SearchNode> Q = new PriorityQueue<SearchNode>(profitComp);
		int goodNum = goodWeight.length;
		SearchNode current = new SearchNode(0, 0, null, 0, 0);
		Q.add(current);
		double bestProfit = 0.0;

		while (Q.isEmpty() == false) {
			SearchNode newNode = new SearchNode(0, 0, null, 0, 0);
			current = Q.poll();
			while (current.no == goodNum && Q.isEmpty() == false) {
				current = Q.poll();
			}
			if (current.no == goodNum) {
				break;
			}
			newNode.weight = current.weight + goodWeight[current.no];
			if (newNode.weight <= capacity) {
				newNode.no = current.no + 1;
				newNode.lrChild = 1;
				newNode.profit = current.profit + goodProfit[current.no];
				if (newNode.profit > bestProfit) {
					bestProfit = newNode.profit;
				}
				newNode.parent = current;
				Q.add(newNode);
			}
			newNode = new SearchNode(0, 0, null, 0, 0);
			if (bound(current.weight, current.no + 1, current.profit, goodWeight, goodProfit, capacity) >= bestProfit) {

				newNode.weight = current.weight;
				newNode.lrChild = 0;
				newNode.no = current.no + 1;
				newNode.profit = current.profit;
				newNode.parent = current;
				Q.add(newNode);
			}
		} // while
		System.out.println("max:" + bestProfit);
		while (current != null) {
			if (current.lrChild == 1) {
				System.out.println("weight:" + goodWeight[current.no - 1] + "  profit:" + goodProfit[current.no - 1]);
			}
			current = current.parent;
		}
	}

	private double bound(double tw, int k, double sum, double[] w, double[] p, double weight) {
		for (int i = k; i < w.length; i++) {
			tw += w[i];
			if (tw <= weight) {
				sum += p[i];
			} else {
				return ((weight - tw) / w[i] + 1) * p[i] + sum;
			}
		}
		return sum;
	}
}
