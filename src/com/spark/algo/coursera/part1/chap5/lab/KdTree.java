package com.spark.algo.coursera.part1.chap5.lab;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

public class KdTree {

	
	public void insert(Point2D p){
		
	}
	
	public PointSET nearest(Point2D p){
		return null;
	}
	
	public void draw(){
		
	}
	
	public Iterable<Point2D> range(RectHV rect) {
		return null;
	}

	@SuppressWarnings("unused")
	private static class Node {
		private Point2D p; // the point
		private RectHV rect; // the axis-aligned rectangle corresponding to this node
		private Node lb; // the left/bottom subtree
		private Node rt; // the right/top subtree
		
		public Point2D getP() {
			return p;
		}
		public void setP(Point2D p) {
			this.p = p;
		}
		public RectHV getRect() {
			return rect;
		}
		public void setRect(RectHV rect) {
			this.rect = rect;
		}
		public Node getLb() {
			return lb;
		}
		public void setLb(Node lb) {
			this.lb = lb;
		}
		public Node getRt() {
			return rt;
		}
		public void setRt(Node rt) {
			this.rt = rt;
		}
	}
	
}
