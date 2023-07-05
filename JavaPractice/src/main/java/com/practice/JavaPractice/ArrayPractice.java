package com.practice.JavaPractice;

public class ArrayPractice {
	
	
	public int arrayExceptionTest(int a) throws ArrayIndexOutOfBoundsException{
		
		int[] aList = {0,1,2};
			
		int b = aList[a];
		
		return b;
		
	}
	

	public static void main(String[] args) {
		
		ArrayPractice ap = new ArrayPractice();
		
//		ap.arrayExceptionTest(5);
		
		
		int[] intList = {0,1,2};
		
		try {
			
			int a = intList[5];
			
		} catch (Exception e) {
			e.printStackTrace();
//			System.out.println(e.printStackTrace());
		}
		finally {
			System.out.println("no exceptions");
		}
		
	}
	
}
