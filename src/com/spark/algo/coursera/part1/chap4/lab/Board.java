package com.spark.algo.coursera.part1.chap4.lab;

import java.util.Iterator;
import java.util.LinkedList;

public class Board {
    // construct a board from an n-by-n array of blocks
    // (where blocks[i][j] = block in row i, column j)
	private int[][] matrix;
	private int n = 0;
	
    public Board(int[][] blocks){
    	this.n = blocks.length;
	    this.matrix = new int[n][n];
    	this.matrix = blocks;
    }
    
    // board dimension n
    public int dimension(){
    	return n;
    }
    
    // number of blocks out of place
    public int hamming(){
    	return 0;
    }
    
    // sum of Manhattan distances between blocks and goal
    public int manhattan(){
    	return 0;
    }
    // is this board the goal board?
    public boolean isGoal(){
    	return true;
    }
    // a board that is obtained by exchanging any pair of blocks
    public Board twin(){
    	return null;
    }
    // does this board equal y?
    public boolean equals(Object y){
    	return true;
    }
    

    public Iterable<Board> neighbors(){
        LinkedList<Board> neighbors = new LinkedList<Board>();
        return neighbors;
    }
    

    // string representation of this board (in the output format specified below)
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(n + "\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s.append(String.format("%2d ", matrix[i][j]));
            }
            s.append("\n");
        }
        return s.toString();    	
    }

    // unit tests (not graded)
    public static void main(String[] args) {
    	
    }
}
