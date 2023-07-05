package com.practice.JavaPractice;

public class NestedClassesPractice {
	
	
	private class innerClass{
		
		
		public void printInner() {
			System.out.println("this is inner class");
		}
		
		
	}
	
	public void printInnerClass() {
		
		innerClass ic =  new innerClass();
		ic.printInner();
		
	}
	
	//method nested class
	public int returnInt() {
		
		 class innerMethodClass{
			
			int a =30;
			
		}
		
		innerMethodClass imc = new innerMethodClass();
		return imc.a;
	}

}
