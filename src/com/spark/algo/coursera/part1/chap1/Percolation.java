package com.spark.algo.coursera.part1.chap1;

import edu.princeton.cs.algs4.In;
//import edu.princeton.cs.algs4.StdIn;
//import edu.princeton.cs.algs4.StdOut;
//import edu.princeton.cs.algs4.UF;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	
	private int total = 0;
	private int N = 0;
	private boolean[] open = null;
	private boolean[] vtop = null;
	private boolean[] vbottom = null;
	
	private WeightedQuickUnionUF unionPercolator = null;
	private int numberOpenSites = 0;
	private boolean percolated = false;
	
	// create n-by-n grid, with all sites blocked
	public Percolation(int n) {
		this.total = n;
		this.N = n * n;
		this.vtop = new boolean[n];
		this.vbottom = new boolean[n];
		
		this.open = new boolean[N];
		this.unionPercolator = new WeightedQuickUnionUF(N);
	}

	// open site (row, col) if it is not open already
	public void open(int row, int col) {
		int site = (row-1) * total +  (col - 1);
		open[site] = true;
		
		// skip when n =1
		if(total > 1) {
			doUnion(row,col);
		}
		numberOpenSites++;

	}

	// is site (row, col) open?
	public boolean isOpen(int row, int col) {
		int site = (row-1) * total +  (col - 1);
		return open[site];
	}

	// is site (row, col) full?
	public boolean isFull(int row, int col) {
		boolean isFull = false;
		int site = (row-1) * total +  (col - 1);
		
		if( (row == 1) && (vtop[col-1] == true)) {
			return true;
		}
		
		// when n =1
		if(total ==1 && open[site]){
			return true;
		}
		
		for(int i=0; i<total ;i++){
			if(vtop[i] && open[site]) {
				int top = unionPercolator.find(i);
				int parent = unionPercolator.find(site);
				if( top == parent){
					return true;
				}
			}
		}
		return isFull;
	}

	// number of open sites
	public int numberOfOpenSites() {
		return numberOpenSites;
	}

	// does the system percolate?
	public boolean percolates() {
		
		if(percolated) return true;

		// when n =1
		if(total ==1 && open[0]){
			return true;
		}
		
		for(int i=0;i<total;i++){
			
			int top = unionPercolator.find(i);

			for(int j=0;j<total;j++){
				// need to calculate the index of bottom
				int bottom = unionPercolator.find(N-j-1);
				System.out.println(top + "," + bottom);
				if(vtop[i] && top == bottom){
					percolated = true;
					return true;
				}
			}
		}

		return false;
	}
	

	
	public void doUnion(int p, int q){
		int site = (p-1) * total +  (q - 1);
		int up = site - total;
		int dw = site + total;
		int rt = site + 1;
		int lt = site - 1;

		// For debug
//		System.out.println("p=" + p + ",q=" + q + ",site=" + site + ",(q % total)=" + (q % total));
//		if(p==1 & q ==1) {
//			System.out.println("for debug");
//		}
		
		if(q==1 & p==1){ // left + top => rt, dw
			if(isOpen(p+1,q)) unionPercolator.union(site,dw);
			if(isOpen(p,q+1)) unionPercolator.union(site,rt);
			vtop[q-1] = true;
			
		} else if(q==1 & p ==total){ // left + bottom => right, up
			if(isOpen(p-1,q)) unionPercolator.union(site,up);
			if(isOpen(p,q+1)) unionPercolator.union(site,rt);
			vbottom[q-1] = true;
			
		} else if(q==1){ // left
			if(isOpen(p-1,q)) unionPercolator.union(site,up);
			if(isOpen(p,q+1)) unionPercolator.union(site,rt);
			if(isOpen(p+1,q)) unionPercolator.union(site,dw);

		} else if((q % total) ==0 & p==1){ // right + top >> lt, dw
			if(isOpen(p+1,q)) unionPercolator.union(site,dw);
			if(isOpen(p,q-1)) unionPercolator.union(site,lt);
			vtop[q-1] = true;

		} else if((q % total) ==0 & p==total){ // right + bottom >> lt, up
			if(isOpen(p-1,q)) unionPercolator.union(site,up);
			if(isOpen(p,q-1)) unionPercolator.union(site,lt);
			vbottom[q-1] = true;

		} else if((q % total) ==0){ // right
			if(isOpen(p-1,q)) unionPercolator.union(site,up);
			if(isOpen(p,q-1)) unionPercolator.union(site,lt);
			if(isOpen(p+1,q)) unionPercolator.union(site,dw);

		} else if(p==total){ // bottom
			if(isOpen(p,q-1)) unionPercolator.union(site,lt);
			if(isOpen(p-1,q)) unionPercolator.union(site,up);
			if(isOpen(p,q+1)) unionPercolator.union(site,rt);
			vbottom[q-1] = true;

		} else if(p==1){ // top
			if(isOpen(p,q-1)) unionPercolator.union(site,lt);
			if(isOpen(p+1,q)) unionPercolator.union(site,dw);
			if(isOpen(p,q+1)) unionPercolator.union(site,rt);
			vtop[q-1] = true;
		} else{
			if(isOpen(p-1,q)) unionPercolator.union(site,up);
			if(isOpen(p+1,q)) unionPercolator.union(site,dw);
			if(isOpen(p,q-1)) unionPercolator.union(site,lt);
			if(isOpen(p,q+1)) unionPercolator.union(site,rt);
		}
		
	}

	/// test client (optional)
	public static void main(String[] args) {

		String txt = args[0];
		In in = new In(txt);
		
//		percolate.doLoop();
		int n = in.readInt();
		Percolation percolate = new Percolation(n);
		System.out.println("Text file:" + txt);
		
		while(in.hasNextLine()){
			int p = in.readInt();
			int q = in.readInt();
			percolate.doUnion(p, q);
		}
		
//		int p = 3;
//		int q = 5;
//		int site = (p-1) * n +  (q - 1);
		
		System.out.println("site=");
		
//		int N = StdIn.readInt();
//		UF uf = new UF(N);
//		while(!StdIn.isEmpty()) {
//			int p = StdIn.readInt();
//			int q = StdIn.readInt();
//			if(!uf.connected(p, q)){
//				uf.union(p, q);
//				StdOut.println(p + " " + q);
//			}
//		}
//
	}
}
