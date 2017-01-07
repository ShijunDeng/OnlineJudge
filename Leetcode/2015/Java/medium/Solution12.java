package com.whitedew.algorithm.medium;

import java.util.Arrays;
import java.util.Stack;

import org.junit.Test;

public class Solution12 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		if (numCourses == 0 || prerequisites == null) {
			return new int[0];
		}
		int[] findOrder = new int[numCourses];
		int[] indegree = new int[numCourses];
		Arrays.fill(indegree, 0);
		Stack<Integer> s = new Stack<Integer>();
		for (int[] e : prerequisites) {
			indegree[e[0]]++;
		}
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0) {
				s.push(i);
			}
		}
		int count = 0;
		while (s.isEmpty() == false) {// while:1#
			int i = s.pop();
			findOrder[count] = i;
			count++;
			for (int[] e : prerequisites) {
				if (e[1] == i) {
					indegree[e[0]]--;
					if (indegree[e[0]] == 0) {
						s.push(e[0]);
					}
				}
			}
		}// while 1#
		if (count < numCourses) {
			return new int[0];
		}
		return findOrder;
	}

	@Test
	public void test() {
		int prerequisites[][] = { { 0, 1 },{1,0}};
		int[] rs = new Solution12().findOrder(2, prerequisites);
		for (int e : rs) {
			System.out.print(e + " ");
		}
	}
}