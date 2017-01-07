package com.whitedew.algorithm.medium;

import java.util.Stack;

import org.junit.Test;

public class Solution4 {
	final String ADD = "+";
	final String SUBTRACT = "-";
	final String MULTIPLY = "*";
	final String DIVIDE = "/";

	private int calculate(int a, int b, String operator) {
		switch (operator) {
		case ADD:
			return a + b;
		case SUBTRACT:
			return b - a;
		case MULTIPLY:
			return a * b;
		case DIVIDE:
			return b / a;
		}
		return 0;
	}

	private boolean isOperator(String c) {
		return c.equals(ADD) || c.equals(SUBTRACT) || c.equals(MULTIPLY)
				|| c.equals(DIVIDE);
	}

	public int evalRPN(String[] tokens) {
		if (tokens == null)
			return 0;
		int len = tokens.length;
		if (len < 2)
			return Integer.parseInt(tokens[0]);
		Stack<Integer> numsStack = new Stack<Integer>();
		for (int i = 0; i < len; i++) {
			if (isOperator(tokens[i])) {
				numsStack.push(calculate(numsStack.pop(), numsStack.pop(),
						tokens[i]));
			} else {
				numsStack.push(Integer.parseInt(tokens[i]));
			}
		}
		return numsStack.pop();
	}
	@Test
	public void test(){
		System.out.println(new Solution4().evalRPN(new String[]{"4", "13", "5", "/", "+"}));
		
	}
}