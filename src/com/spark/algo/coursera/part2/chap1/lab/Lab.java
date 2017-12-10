package com.spark.algo.coursera.part2.chap1.lab;

import edu.princeton.cs.algs4.Digraph;

public class Lab {

	public static void main(String[] args) {
		int V = 11;
		Digraph graph = new Digraph(V);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(4, 3);
		graph.addEdge(5, 6);
		graph.addEdge(10, 9);
		
		graph.E();
		
		Iterable<Integer> g1 = graph.adj(0);
		Iterable<Integer> g2 = graph.adj(2);
		System.out.println(g1.toString());
		for(int g: g1){
			System.out.println("g:" + g);
		}
		for(int g: g2){
			System.out.println("g:" + g);
		}

	}

}
