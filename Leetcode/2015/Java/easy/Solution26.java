package com.whitedew.algorithm.easy;

import java.util.ArrayList;
import java.util.List;

public class Solution26 {
    public List<List<Integer>> generate(int numRows) {
      List<List<Integer>> rs = new ArrayList<List<Integer>>();
		int[] element = new int[numRows];
		if(numRows==0)
		    return rs;
		
		List<Integer> e = new ArrayList<Integer>();
		e.add(1);
	    rs.add(e);
	    if(numRows==1)
	        return rs;
		e = new ArrayList<Integer>();
	    e.add(1);
		e.add(1);
		rs.add(e);
		if(numRows==2)
		    return rs;
	
		element[0] = element[1] = 1;
		for (int i = 2; i < numRows; i++) {
			element[i] = 1;
			e = new ArrayList<Integer>();
			for (int j = i-1; j > 0; j--) {
				element[j] = element[j] + element[j - 1];
			}
			for(int k=0;k<=i;k++)
			    e.add(element[k]);
			rs.add(e);
		}
		return rs;  
    }
}