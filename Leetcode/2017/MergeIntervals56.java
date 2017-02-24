package cn.sjdeng.leetcode;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
 * 
 * @author ShijunDeng
 *
 */

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class MergeIntervals56 {
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals.size() < 2) {
			return intervals;
		}
		List<Interval> rs = new LinkedList<Interval>();
		intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
		Interval prev = intervals.get(0);
		for (Interval cur : intervals) {
			if (cur.start >= prev.start && cur.start <= prev.end) {
				prev.end = cur.end > prev.end ? cur.end : prev.end;
			} else {
				rs.add(prev);
				prev = cur;
			}
		}
		rs.add(prev);
		return rs;
	}

	@Test
	public void test() {
		List<Interval> rs = new LinkedList<Interval>();
		rs.add(new Interval(1, 2));
		rs.add(new Interval(3, 4));
		merge(rs);
		System.out.println(merge(rs).size());
	}
}
