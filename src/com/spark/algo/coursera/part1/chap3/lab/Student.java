package com.spark.algo.coursera.part1.chap3.lab;

import java.util.Arrays;
import java.util.Comparator;

public class Student {

	public static final Comparator<Student> BY_NAME = new ByName();
	public static final Comparator<Student> BY_SECTION = new BySection();
	
	private String name;
	private int section;
	
	public Student(String name, int section){
		this.name = name;
		this.section = section;
	}
	
	public String toString(){
		return "name[" + this.name + "], section=[" + this.section + "]";
	}
	
	private static class ByName implements Comparator<Student>{

		@Override
		public int compare(Student s1, Student s2) {
			return s1.name.compareTo(s2.name);
		}
	}
	
	private static class BySection implements Comparator<Student>{

		@Override
		public int compare(Student s1, Student s2) {
			return s1.section - s2.section;
		}
	}

	public static void main(String[] args) {
		Student[] students = new Student[5];
		Student s0 = new Student("Sam",5);
		students[0] = s0;
		Student s1 = new Student("John",2);
		students[1] = s1;
		Student s2 = new Student("Tom",1);
		students[2] = s2;
		Student s3 = new Student("Adam",4);
		students[3] = s3;
		Student s4 = new Student("April",3);
		students[4] = s4;
		
		printStudent(students);
		Arrays.sort(students, Student.BY_NAME);
		printStudent(students);
		Arrays.sort(students, Student.BY_SECTION);
		printStudent(students);
		
	}
	static void printStudent(Student[] students) {
		for(Student student: students){
			System.out.println(student.toString());
		}
		System.out.println("=======================");
	}
	
}
