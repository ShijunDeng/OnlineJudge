package com.whitedew.algorithm.easy;

import java.util.Arrays;

class MinStack {
	private int stackSize = 512;
	private int size = 0;
	private int[] elements = new int[size];

	public void push(int x) {
		if (size == stackSize) {
			stackSize *= 2;
			elements = Arrays.copyOf(elements, stackSize);
		}
		elements[size++] = x;
	}

	public void pop() {
		if (size > 0)
			size--;

	}

	public int top() {
		return elements[size - 1];
	}

	public int getMin() {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < size; i++) {
			if (elements[i] < min) {
				min = elements[i];
			}
		}
		return min;
	}
}
