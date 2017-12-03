package com.spark.algo.coursera.part1.chap2;

import java.util.Scanner;

import edu.princeton.cs.algs4.In;

public class Permutation {

	// You may assume that 0 <= k <= n, 
	// where n is the number of string on standard input.
	public static void main(String[] args) {
//		useTerminal();
		String arg = args[0];
		int k = Integer.valueOf(arg);
		useConsole(k);
	}
	
	/***
	 * Run this program in the terminal
	 * - Need to comment out package for Permutation / Deque
	 * - Make sure that distinct.txt is in the same folder
	 * $ javac Permutation.java
	 * $ java Permutation < distinct.txt
	 */
	static void useTerminal() {
		Deque<String> deque = new Deque<String>();
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String str = scanner.next();
			deque.addFirst(str);
			//System.out.println(scanner.next());
		}
		for(String s: deque){
			System.out.println(s + " ");
		}
		scanner.close();
	}
		
	
	/***
	 * You can only provide the console with the file name without its path.
	 * distinct.txt
	 * which is in the path [.\resource\java\algo\coursera\part1\chap2\distinct.txt]
	 */
	static void useConsole(int k) {
		RandomizedQueue<String> queue = new RandomizedQueue<String>();
		Scanner scanner = new Scanner(System.in);
		String folder = ".\\resource\\java\\algo\\coursera\\part1\\chap2\\";
		String filename = scanner.nextLine();
		String file = folder + filename;
		System.out.println(file + " is being opened!!");
		In in = new In(file);

		while (!in.isEmpty()) {
			String str = in.readString();
			queue.enqueue(str);
		}
		
		//0 <= k <= n
		System.out.println(k + ":" + queue.size());		
//		for(String s: queue) System.out.println(s + " ");

		for(int i=0;i<k;i++){
			String pop = queue.dequeue();
			System.out.println(pop);
		}
		
		scanner.close();
	}
	
}
