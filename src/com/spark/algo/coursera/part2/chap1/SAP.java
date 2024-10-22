package com.spark.algo.coursera.part2.chap1;

import java.util.LinkedList;
import java.util.Queue;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
//import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SAP {
	// constructor takes a digraph (not necessarily a DAG)
	Digraph graph;
	private boolean[] visited;
	
	Queue<Integer> queue = new LinkedList<Integer>();
	
	public SAP(Digraph G) {
		this.graph = G;
//		this.visited = new boolean[G.V()];

	}

	// length of shortest ancestral path between v and w; -1 if no such path
	public int length(int v, int w) {
		validateVertex(v);
		validateVertex(w);
		
		return 0;
	}

	// a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path
	public int ancestor(int v, int w) {
		validateVertex(v);
		validateVertex(w);
		
		
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

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        int V = visited.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
    
    
    // print boolean values for marked[]
	public void checkBooleanValue(boolean[] marked){
		for(int i=0;i < marked.length;i++){
			System.out.print(i + "[" + marked[i] + "] ");
		}
		System.out.println();
	}
	
	private void printQueue(Iterable<Integer> iter){
		for(Integer i: iter){
			System.out.println("" + i);
		}
	}
	

	//
	public void findAncestor(int v){
		 visited = new boolean[graph.V()];
		 dfs(graph, v);
	}
	
	//
	public int dfs(Digraph graph, int v){
		
		int ancestor = -1;
		visited[v] = true;
//		checkBooleanValue(visited);
//		Paths paths = new Paths(graph,1);
		
		int sum = 0;
		for(Integer g: graph.adj(v)){
			ancestor = g.intValue();
			System.out.println(v + "'s ancestor:" + ancestor);
			if(!visited[g]) dfs(graph,ancestor);
		}
//		System.out.println("sum=" + sum);
		return sum;
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
//			sap.checkBooleanValue();
			sap.findAncestor(1);
//			sap.ancestor(3, 11);
//			while (!StdIn.isEmpty()) {
//				int v = StdIn.readInt();
//				int w = StdIn.readInt();
//				int length = sap.length(v, w);
//				int ancestor = sap.ancestor(v, w);
//				StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
//			}
		} catch (IllegalArgumentException e) {

		}

	}
}
