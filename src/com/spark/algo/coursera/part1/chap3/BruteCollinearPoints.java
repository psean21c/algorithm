package com.spark.algo.coursera.part1.chap3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class BruteCollinearPoints {

	public static final Comparator<Point> BY_ANGLE = new ByAngle();
	
	private int n = 0; // number of points
	private int numberOfSegments = 0;
	private Point[] points;
	
	// finds all line segments containing 4 points
	public BruteCollinearPoints(Point[] points) {
		n = points.length;
		this.points = points;
	}

	// the number of line segments
	public int numberOfSegments() {
		return numberOfSegments;
	}

	static void printPoint(Point[] points) {
		for(Point point: points){
			System.out.println(point.toString());
		}
		System.out.println("=======================");
	}
	
	

	private static class ByAngle implements Comparator<Point>{

		@Override
		public int compare(Point p1, Point p2) {
			return p1.compareTo(p2);
		}
		
	}
	
	// the line segments ..  ArrayList / LinkedList allowed..
	public LineSegment[] segments() {

		ArrayList<LineSegment> segments = new ArrayList<LineSegment>();
		printPoint(points);
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				for(int k=j+1;k<n;k++){
					for(int l=k+1;l<n;l++){
//						System.out.println("" + points[i].toString() + "" + points[j].toString() + "" + points[k].toString() + "" + points[l].toString());
//						System.out.println(points[i].slopeTo(points[j]) + "," + points[i].slopeTo(points[k]) + "," + points[i].slopeTo(points[l])); 
//						System.out.println(points[i].slopeTo(points[j]) + "=" + points[i].slopeTo(points[k])); 
//						System.out.println(points[i].slopeTo(points[j]) + "=" + points[i].slopeTo(points[l])); 
						if(points[i].slopeTo(points[j]) == points[i].slopeTo(points[k]) && points[i].slopeTo(points[j]) == points[i].slopeTo(points[l])){
							System.out.println("" + points[i].toString() + "" + points[j].toString() + "" + points[k].toString() + "" + points[l].toString());
							System.out.println("on the line: [" + i + "]" + points[i].slopeTo(points[j]) + "\t [" + j + "]" + points[i].slopeTo(points[k]) + "\t [" + k + "]" + points[i].slopeTo(points[l])); 
							LineSegment segment = new LineSegment(points[i],points[l]);
							points[i].drawTo(points[l]);
							segments.add(segment);
							System.out.println();
						} else {
//							System.out.println("" + points[i].toString() + "" + points[j].toString() + "" + points[k].toString() + "" + points[l].toString());
//							System.out.println("diff>>" + points[i].slopeTo(points[j]) + "," + points[i].slopeTo(points[k]) + "," + points[i].slopeTo(points[l])); 
						}
					}
				}
			}
//			printPoint(points);
//			System.out.println("===============================================");
//			Arrays.sort(points, BruteCollinearPoints.BY_ANGLE);
//			printPoint(points);
		}
		
		LineSegment[] segmentArray = new LineSegment[segments.size()];
		for(int i=0;i<segments.size();i++){
			segmentArray[i] = segments.get(i);
		}
		
//		LineSegment[] segmentArray = (LineSegment[]) segments.toArray();
//		System.out.println("" + segmentArray.toString() + ",size=" + segmentArray.length);
		return segmentArray;
	}
}