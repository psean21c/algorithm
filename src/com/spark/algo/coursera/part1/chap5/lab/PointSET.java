package com.spark.algo.coursera.part1.chap5.lab;

import java.util.TreeSet;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

public class PointSET {
	
	private TreeSet<Point2D> tree = null;
	
	
	// construct an empty set of points
	public PointSET() {
		tree = new TreeSet<Point2D>();
	}

	// is the set empty?
	public boolean isEmpty() {
		return (tree.size() ==0);
	}

	// number of points in the set
	public int size() {
		return tree.size();
	}

	// add the point to the set (if it is not already in the set)
	public void insert(Point2D p) {
		tree.add(p);
	}

	// does the set contain point p?
	public boolean contains(Point2D p) {
		return tree.contains(p);
	}

	// draw all points to standard draw
	public void draw() {
		for (Point2D leave : tree) {
//			leave.draw();
			StdDraw.point(leave.x(), leave.y());
		}
	}

	// all points that are inside the rectangle (or on the boundary)
	public Iterable<Point2D> range(RectHV rect) {
		TreeSet<Point2D> set = new TreeSet<Point2D>();
		for(Point2D p: tree){
			if(rect.contains(p)) set.add(p);
		}
		return set;
	}

	// a nearest neighbor in the set to point p; null if the set is empty
	public Point2D nearest(Point2D p) {
		Point2D nearest = null;
		double shortest = Double.MAX_VALUE;
		for(Point2D leave: tree){
			double distance = p.distanceTo(leave);
			//System.out.println(p + ">" + leave + ":" + distance);
			if( distance <= shortest && (p.x() != leave.x() && p.y() != leave.y())){
				shortest = distance;
				nearest = leave;
			}
		}
		return nearest;
	}

	// unit testing of the methods (optional)
	public static void main(String[] args) {

	}
}
