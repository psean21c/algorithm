package com.spark.algo.coursera.part1.chap1.lab;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Solution {

	public void doPercolate(){
		int n = 20;
		WeightedQuickUnionUF unionPercolator = new WeightedQuickUnionUF(n);

		boolean isConnected = unionPercolator.connected(1, 2);
		System.out.println("" + isConnected);
		unionPercolator.union(1, 2);
		isConnected = unionPercolator.connected(1, 2);
		System.out.println("" + isConnected);
		
		unionPercolator.union(2, 3);
		unionPercolator.union(2, 4);
		unionPercolator.union(2, 5);
		
		unionPercolator.union(9, 10);
		unionPercolator.union(9, 11);
		unionPercolator.union(9, 12);
		
		unionPercolator.union(2, 9);
		
		isConnected = unionPercolator.connected(2, 10);
		System.out.println("" + isConnected);
//
// 
//		parent	[0, 1, 1, 1, 1, 1, 6, 7, 8, 1, 9, 9, 9, 13, 14, 15, 16, 17, 18, 19]
//		size	[1, 9, 1, 1, 1, 1, 1, 1, 1, 4, 1, 1, 1,  1,  1,  1,  1,  1,  1,  1]
	
//		
	}
}
