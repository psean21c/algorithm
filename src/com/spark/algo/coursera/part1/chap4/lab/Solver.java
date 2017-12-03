package com.spark.algo.coursera.part1.chap4.lab;

public class Solver {
	private Board board;
    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial){
    	this.board = initial;
    }
    // is the initial board solvable?
    public boolean isSolvable(){
    	return true;
    }
    // min number of moves to solve initial board; -1 if unsolvable
    public int moves(){
    	return 0;
    }
    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution(){
    	return null;
    }
    // solve a slider puzzle (given below)
    public static void main(String[] args){
    	
    }
}