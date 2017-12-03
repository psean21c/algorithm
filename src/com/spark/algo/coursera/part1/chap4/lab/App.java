package com.spark.algo.coursera.part1.chap4.lab;

import java.util.Iterator;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MaxPQ;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

public class App {

	public static void main(String[] args) {
//    	In in = useConfig(args[0]);
		In in = useConfig();
		
		run(in);
		
//		runPQ();
	}
	static void run(In in){
	    int n = in.readInt();
        System.out.println("reading the file:" + in + ",n=" + n);
	    
	    int[][] blocks = new int[n][n];
	    for (int i = 0; i < n; i++)
	        for (int j = 0; j < n; j++)
	            blocks[i][j] = in.readInt();
	    Board initial = new Board(blocks);

	    // solve the puzzle
	    Solver solver = new Solver(initial);

	    // print solution to standard output
	    if (!solver.isSolvable())
	        StdOut.println("No solution possible");
	    else {
	        StdOut.println("Minimum number of moves = " + solver.moves());
	        for (Board board : solver.solution())
	            StdOut.println(board);
	    }		
	}

    static In useConfig(String arg){
    	
        // read the n points from a file
        In in = new In(arg);      // input file
        return in;
    }
    static In useConfig(){
    	
        // read the n points from a file
    	String file = ".\\resource\\java\\algo\\coursera\\part1\\chap4\\puzzle04.txt";
        In in = new In(file);      // input file
        return in;
    }
	
	static void runPQ(){
		int min = 5;
		MinPQ<String> minPQ = new MinPQ<String>(min);
		
		minPQ.insert("e");
		minPQ.insert("d");
		minPQ.insert("c");
		minPQ.insert("b");
		minPQ.insert("a");
		System.out.println(minPQ.size());
		String str = minPQ.delMin();
		System.out.println(minPQ.delMin() + ":" + minPQ.size());
		System.out.println(minPQ.delMin() + ":" + minPQ.size());
		System.out.println(minPQ.delMin() + ":" + minPQ.size());
		System.out.println(minPQ.delMin() + ":" + minPQ.size());
		System.out.println(minPQ.delMin() + ":" + minPQ.size());
		System.out.println(minPQ.delMin() + ":" + minPQ.size());
		Iterator<String> iter = minPQ.iterator();
		
		int max = 5;
		MaxPQ<String> maxPQ = new MaxPQ<String>(max);
		maxPQ.insert("x");
		maxPQ.insert("y");
		maxPQ.insert("z");
		maxPQ.insert("v");
		maxPQ.insert("w");
		System.out.println(maxPQ.size());
		String str2 = maxPQ.delMax();
		System.out.println(str2 + ":" + maxPQ.size());
		
	}
	
    
}
