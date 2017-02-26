package cn.sjdeng.leetcode;

import java.util.Stack;

/*
 * 
Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Notes:
You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 */
public class ImplementQueueusingStacks232 {
	private Stack<Integer> A;
	private Stack<Integer> B;

	/** Initialize your data structure here. */
	public ImplementQueueusingStacks232() {
		A = new Stack<Integer>();
		B = new Stack<Integer>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		A.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		if (B.empty() == true) {
			while (A.empty() == false) {
				B.push(A.peek());
				A.pop();
			}
		}
		return B.pop();
	}

	/** Get the front element. */
	public int peek() {
		if (B.empty() == true) {
			while (A.empty() == false) {
				B.push(A.peek());
				A.pop();
			}
		}
		return B.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return A.empty() && B.empty();
	}
}
