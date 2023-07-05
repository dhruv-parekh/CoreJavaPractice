package com.practice.JavaPractice;

import java.util.Scanner;

public class ExceptionPractice {
	
	public static void main(String[] args) {
		
//		try {
//			Scanner ss = new Scanner(System.in);
//			System.out.println("Enter an integer:\n");
//			int i = ss.nextInt();
//			System.out.println("int: "+i);
//			
//		}
//		catch(Exception e) {
//			System.out.println("Exception occured.\n"+e);
//		}
//		finally {
//		System.out.println("this block will be executed no matter what!!");	
//		}
		
		
		Scanner ss = new Scanner(System.in);
		System.out.println("Enter an integer:\n");
		int i = ss.nextInt();
		System.out.println("int: "+i);
		
		if(i>10) {
			System.out.println("this will throw an exception");
			throw new ArithmeticException("int should not be greater then 10");
			}
		else {
			System.out.println("int : "+i);
		}
		
		
	}
	
	

}
