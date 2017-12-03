package com.spark.algo.coursera.part1.chap3;

import java.util.Comparator;
import java.util.Scanner;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class Point implements Comparable<Point> {

	private final int x; // x-coordinate of this point
	private final int y; // y-coordinate of this point

	/**
	 * Initializes a new point.
	 *
	 * @param x :  the <em>x</em>-coordinate of the point
	 * @param y :  the <em>y</em>-coordinate of the point
	 * Q&A
	 * https://www.coursera.org/learn/algorithms-part1/programming/prXiW/collinear-points/discussions/threads/vUQCA58REeagbRJODex4yg
	 * 
	 */
	public Point(int x, int y) {
		/* DO NOT MODIFY */
		this.x = x;
		this.y = y;
	}

	/**
	 * Draws this point to standard draw.
	 */
	public void draw() {
		/* DO NOT MODIFY */
		StdDraw.point(x, y);
	}

	/**
	 * Draws the line segment between this point and the specified point to
	 * standard draw.
	 *
	 * @param that:  the other point
	 */
	public void drawTo(Point that) {
		/* DO NOT MODIFY */
		StdDraw.line(this.x, this.y, that.x, that.y);
	}

	/**
	 * Returns the slope between this point and the specified point. Formally,
	 * if the two points are (x0, y0) and (x1, y1), then the slope is (y1 - y0)
	 * / (x1 - x0). For completeness, the slope is defined to be +0.0 if the
	 * line segment connecting the two points is horizontal;
	 * Double.POSITIVE_INFINITY if the line segment is vertical; and
	 * Double.NEGATIVE_INFINITY if (x0, y0) and (x1, y1) are equal.
	 *
	 * @param that : the other point
	 * @return the slope between this point and the specified point
	 */
	public double slopeTo(Point that) {
		/* YOUR CODE HERE */
		if(this.x==10000 && this.y==0 && that.x == 6000 && that.y == 7000 ){
			System.out.println();
		}
		double slope = 0.0;
		if(this.x == that.x && this.y == that.y){ // equal
			slope = Double.NEGATIVE_INFINITY; 
		} else if(this.x == that.x) { // vertical
			slope = Double.POSITIVE_INFINITY;
		} else if(this.y == that.y) { // horizontal
			slope = (1.0 - 1.0) /  1.0;
		} else{
			slope = (double)(that.y - this.y) / (double)(that.x - this.x);
		}
		return slope;
	}

	/**
	 * Compares two points by y-coordinate, breaking ties by x-coordinate.
	 * Formally, the invoking point (x0, y0) is less than the argument point
	 * (x1, y1) if and only if either y0 < y1 or if y0 = y1 and x0 < x1.
	 *
	 * @param that : the other point
	 * @return the value <tt>0</tt> if this point is equal to the argument point
	 *         (x0 = x1 and y0 = y1); a negative integer if this point is less
	 *         than the argument point; and a positive integer if this point is
	 *         greater than the argument point
	 */
	public int compareTo(Point that) {
		/* YOUR CODE HERE */
		if(this.x == that.x && this.y == that.y){ // equal
			return 0; 
		} else if(this.y < that.y || (this.y == that.y && this.x < that.x)) { // vertical
			return -1;
		} else{
			return 1;
		}
	}

	/**
	 * Compares two points by the slope they make with this point. The slope is
	 * defined as in the slopeTo() method.
	 *
	 * @return the Comparator that defines this ordering on points
	 */
	public Comparator<Point> slopeOrder() {
		/* YOUR CODE HERE */
		return null;
	}

	/**
	 * Returns a string representation of this point. This method is provide for
	 * debugging; your program should not rely on the format of the string
	 * representation.
	 *
	 * @return a string representation of this point
	 */
	public String toString() {
		/* DO NOT MODIFY */
		return "(" + x + ", " + y + ")";
	}

}