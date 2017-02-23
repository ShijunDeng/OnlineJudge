package cn.sjdeng.leetcode;

import org.junit.Test;

/**
 * You are playing the following Nim Game with your friend: There is a heap of
 * stones on the table, each time one of you take turns to remove 1 to 3 stones.
 * The one who removes the last stone will be the winner. You will take the
 * first turn to remove the stones.Both of you are very clever and have optimal
 * strategies for the game. Write a function to determine whether you can win
 * the game given the number of stones in the heap.For example, if there are 4
 * stones in the heap, then you will never win the game: no matter 1, 2, or 3
 * stones you remove, the last stone will always be removed by your friend.
 *
 * 当n∈[1,3]时，先手必胜。
 * 
 * 当n == 4时，无论先手第一轮如何选取，下一轮都会转化为n∈[1,3]的情形，此时先手必负。
 * 
 * 当n∈[5,7]时，先手必胜，先手分别通过取走[1,3]颗石头，可将状态转化为n == 4时的情形，此时后手必负。
 * 
 * 当n == 8时，无论先手第一轮如何选取，下一轮都会转化为n∈[5,7]的情形，此时先手必负。 ......
 * 
 * 以此类推，可以得出结论：
 * 
 * 当n % 4 != 0时，先手必胜；否则先手必负。
 */
public class NimGame292 {
	public boolean canWinNim(int n) {
		return n % 4 > 0;
	}

	@Test
	public void test() {
		for (int i = 1; i < 35; i++) {
			System.out.println(canWinNim(i));
		}
	}
}
