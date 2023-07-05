package com.practice.JavaPractice;

public class OuterClass {

	String name  = "outer name";
	
	class Innerclass{
		String name = "inner name";
		public Innerclass() {
		System.out.println("this is inner class");
		}
		
	}
	public void sayName() {
		Innerclass ic = new Innerclass();
		System.out.println("print : "+name);
	}
	
}
