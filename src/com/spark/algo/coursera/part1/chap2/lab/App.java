package com.spark.algo.coursera.part1.chap2.lab;

import java.util.Scanner;

import com.spark.algo.coursera.part1.chap2.lab.Solution;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class App {
	private static Solution sol = new Solution();

	/***
	 * 
	 * > javac -cp ".\algs4.jar" -Xlint:unchecked ResizingArrayStack.java
	 * 
	 */
	public static void main(String[] args) {

		useConsole();
//		useConfig(args[0]);
	}
	
	static void useConsole(){

		LinkedStackOfStrings stack = new LinkedStackOfStrings();

		while(!StdIn.isEmpty()){
			String s = StdIn.readString();
			if(s.equals("-")) StdOut.print(stack.pop());
			else stack.push(s);
		}
	}
	
	
	static void useConfig(String arg){
	      In in = new In(arg);      // input file

		LinkedStackOfStrings stack = new LinkedStackOfStrings();
		while(!in.isEmpty()){
			String s = in.readString();
			if(s.equals("-")) StdOut.print(stack.pop());
			else stack.push(s);
		}

	}
	

	
}
