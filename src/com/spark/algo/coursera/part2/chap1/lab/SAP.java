package com.spark.algo.coursera.part2.chap1.lab;

import java.util.LinkedList;
import java.util.Queue;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SAP {
	private Digraph graph;
	private boolean marked[];
	
	// constructor takes a digraph (not necessarily a DAG)
	public SAP(Digraph G) {
		this.graph = G;
		marked = new boolean[G.E()];
	}

	// length of shortest ancestral path between v and w; -1 if no such path
	public int length(int v, int w) {
		return 0;
	}

	// a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path
	public int ancestor(int v, int w) {
		return 0;
	}

	// length of shortest ancestral path between any vertex in v and any vertex in w;-1 if no such path
	public int length(Iterable<Integer> v, Iterable<Integer> w) {
		return 0;
	}

	// a common ancestor that participates in shortest ancestral path; -1 if no such path
	public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
		return 0;
	}

	// do unit testing of this class
	public static void main(String[] args) {
		try {
			String txt = args[0];
			System.out.println("Text file:" + txt);
			In in = new In(txt);
			Digraph G = new Digraph(in);
			for(int v =0; v<G.V(); v++){
				for(int w: G.adj(v)) StdOut.println(v + "->" + w);
			}
			
			SAP sap = new SAP(G);
			sap.ancestor(3, 11);
			while (!StdIn.isEmpty()) {
				int v = StdIn.readInt();
				int w = StdIn.readInt();
				int length = sap.length(v, w);
				int ancestor = sap.ancestor(v, w);
				StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
			}
		} catch (IllegalArgumentException e) {

		}

	}
}
