package com.spark.algo.coursera.part1.chap5.lab;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

public class Lab {
	public static void main(String[] args) {
		runPointSET();
	}

	static void runPointSET(){
		// 1) create points
		Point2D p1 = new Point2D(0.4, 0.2);
		Point2D p2 = new Point2D(0.4, 0.7);
		Point2D p3 = new Point2D(0.6, 1.0);
		Point2D p4 = new Point2D(0.9, 0.5);
		Point2D q1 = new Point2D(0.8, 0.7);
		Point2D q2 = new Point2D(0.6, 0.6);
		Point2D q3 = new Point2D(0.1, 0.6);

		// 2) create rectangle
		double x0 = 0.5;
		double y0 = 0.2;
		double x1 = 0.8;
		double y1 = 0.9;
		RectHV rect = new RectHV(x0,y0,x1,y1);
		
		// 3) build PointSET
		PointSET brute = new PointSET();
		brute.insert(p1);
		brute.insert(p2);
		brute.insert(p3);
		brute.insert(p4);
		brute.insert(q1);
		brute.insert(q2);
		System.out.println(p1 + ">" + p2 + "=" +  p1.distanceTo(p2));
		System.out.println(brute.contains(p1));
		System.out.println(brute.contains(q3));
		System.out.println(rect.contains(p1));
		System.out.println(rect.contains(p2));
		System.out.println(rect.contains(p3));
		System.out.println(rect.contains(p4));
		System.out.println(rect.contains(q1));
		System.out.println(rect.contains(q2));
		
		// 4) test range()
		Iterable<Point2D> pts = brute.range(rect);
		for(Point2D p: pts){
			System.out.println("x=" + p.x() + ",y=" + p.y());
		}
		
		// 5) test nearest()
		Point2D n = brute.nearest(p1);
		System.out.println(n.x() + "," + n.y());
		
		// 6) test swing
        StdDraw.enableDoubleBuffering();
        while (true) {

            // the location (x, y) of the mouse
            double x = StdDraw.mouseX();
            double y = StdDraw.mouseY();
            Point2D query = new Point2D(x, y);

            // draw all of the points
            StdDraw.clear();
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.setPenRadius(0.01);
            brute.draw();

            // draw in red the nearest neighbor (using brute-force algorithm)
            StdDraw.setPenRadius(0.03);
            StdDraw.setPenColor(StdDraw.RED);
            brute.nearest(query).draw();
            StdDraw.setPenRadius(0.02);

            // draw in blue the nearest neighbor (using kd-tree algorithm)
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.show();
            StdDraw.pause(40);
        }     
		
	}
}
