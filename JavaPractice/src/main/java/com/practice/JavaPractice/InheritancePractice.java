package com.practice.JavaPractice;

public class InheritancePractice extends AbClass {

	int age=0;
	
	public InheritancePractice(int age) {
		this.age = age;
	}

	@Override
	public void getMessage() {
		System.out.println("this is message from abstract method");
		
	}

	public void justCheck() {
		System.out.println("just check method");
		
	}
	
	
}
