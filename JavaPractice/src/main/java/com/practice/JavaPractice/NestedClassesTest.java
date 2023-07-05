package com.practice.JavaPractice;

public class NestedClassesTest {

	
	public static void main(String[] args) {
		
		NestedClassesPractice  np = new NestedClassesPractice();
		
		np.printInnerClass();
		
		int b = np.returnInt();
		System.out.println("from method inner class:"+b);
	}
	
}
