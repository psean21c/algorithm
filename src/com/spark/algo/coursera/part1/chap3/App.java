package com.spark.algo.coursera.part1.chap3;

import java.util.Scanner;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class App {

	public static void main(String[] args) {
    	In in = useConfig(args[0]);
//		In in = useConsole();
		run(in);
	}
	
    static void run(In in){
        int n = in.readInt();
        System.out.println("reading the file:" + in + ",n=" + n);
    	
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        collinear.segments();
//        for (LineSegment segment : collinear.segments()) {
//            segment.draw();
//        }
        StdDraw.show();
        
    }

    static In useConfig(String arg){
    	
        // read the n points from a file
        In in = new In(arg);      // input file
        return in;
    }

   
	static In useConsole() {
		Scanner scanner = new Scanner(System.in);
		String folder = ".\\resource\\java\\algo\\coursera\\part1\\chap3\\";
		String filename = scanner.nextLine();
		String file = folder + filename;
		System.out.println(file);
		scanner.close();
		
		In in = new In(file);
		return in;
	}

}
