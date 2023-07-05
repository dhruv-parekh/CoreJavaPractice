package com.practice.JavaPractice;

public class ThreadTest extends Thread{

	public void run() {
		for(int i =0; i<=10; i++) {
			System.out.println("@@@in thread test @@"+i);
		}
	}
	
}
