package com.practice.JavaPractice;

public interface TestInterface {

	public int i = 0;
	void justCheck();
	default void testmethod() {
		System.out.println("default method");
	}
}
