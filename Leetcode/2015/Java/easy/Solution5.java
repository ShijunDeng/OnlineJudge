package com.whitedew.algorithm.easy;

public class Solution5 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
    	int count=0;
    	while(n!=0){
    		count+=(n%2);
    		n>>=1;
    	}
    	return count;
        
    }
}