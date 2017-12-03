package com.spark.algo.coursera.part1.chap3.ref2;

//import java.util.Stack;
import edu.princeton.cs.algs4.Stack; 
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

public class Solver {
	private class SearchNode { // SearchNode for A* algorithm tree
		public Board board;
		public int moves;
		public SearchNode parent;
		public boolean isTwin;

		public SearchNode(Board board, int moves, SearchNode parent, boolean isTwin) {
			this.board = board;
			this.moves = moves;
			this.parent = parent;
			this.isTwin = isTwin;
		}
	}

	private SearchNode sN;
	private int moves = 0;
	private boolean solvable = false;
	// use Comparator out of class, use Comparable in class
    private MinPQ<SearchNode> minPQ = new MinPQ<SearchNode>(); 	
//    private MinPQ<SearchNode> minPQ = new MinPQ<SearchNode>(new Comparator<SearchNode>(){  
//        public int compare(SearchNode s1, SearchNode s2){  
//            return s1.board.manhattan() + s1.moves - s2.board.manhattan() - s2.moves;  
//        }  
//    }); 	

	private Stack<Board> solutionStack = new Stack<>();

	public Solver(Board initial) { // find a solution to the initial board
									// (using the A* algorithm)
		minPQ.insert(new SearchNode(initial, 0, null, false));
		minPQ.insert(new SearchNode(initial.twin(), 0, null, true));
		while (true) {
			this.sN = minPQ.delMin();
			// terminate search when a goal searchNode dequeue
			if (sN.board.isGoal()) {
				if (sN.isTwin)
					this.moves = -1;
				else {
					this.solvable = true;
					this.moves = sN.moves;
					// trace back its parent boards as solution
					solutionStack.push(sN.board);
					while (sN.parent != null) {
						sN = sN.parent;
						solutionStack.push(sN.board);
					}
				}
				break;
			}
			for (Board neighbor : sN.board.neighbors()) {
				// Don't enqueue a visited board
				if (sN.parent == null || !neighbor.equals(sN.parent.board)) 
					minPQ.insert(new SearchNode(neighbor, sN.moves + 1, sN, sN.isTwin));
			}
		}
	}

	public boolean isSolvable() { // is the initial board solvable?
		return this.solvable;
	}

	public int moves() { // min number of moves to solve initial board; -1 if
							// unsolvable
		return this.moves;
	}

	public Iterable<Board> solution() { // sequence of boards in a shortest
										// solution; null if unsolvable
		if (this.solvable)
			return solutionStack;
		else
			return null;
	}

	public static void main(String[] args) {// solve a slider puzzle (given
											// below)
		// create initial board from file
		In in = new In(args[0]);
		int n = in.readInt();
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
}
