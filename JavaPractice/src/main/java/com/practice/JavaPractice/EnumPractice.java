package com.practice.JavaPractice;

import java.util.Arrays;

public class EnumPractice {
	
	int a1 =2;
	
	enum cofeeSize{small, medium, large} cofeeSize size;
	
	enum lovedAnimal{Dog, Cat, Pig} lovedAnimal animal;
	
	public static String dogName = "jay";
	public static String CATNAME="ramesh";
	
	protected void finalize() {
		System.out.println("this is finalise method");
	}
	
	public static void main(String[] args) {
		
		EnumPractice ep = new EnumPractice();
		
		System.out.println(ep.a1);
		System.gc();
		
		Integer i = 3;
		double j = 5;
		String s = "444";
		double d = 101.25;
		String str1 = "dhruv";
		String str2= "dhruv";
		
//		int[] ary1 = new int[4];
		int[] ary1 = {1,50,0,4,152,20};
		int[] ary2 = {1,2,3};
		
//		System.out.println(Arrays.equals(ary1, ary2));
//		System.out.println(Arrays.mismatch(ary1, ary2));
		Arrays.sort(ary1,1,6);
//		ary1[0]=1; 
//		ary1[1] = 2;
//		ary1[2] = 3;
//		ary1[3] = 4;
		
		
		for(int ilist:ary1) 
			System.out.println(ilist);
//		
//		
//		
//		System.out.println(str1 == str2);
//		System.out.println(i == j);
//		int n = (int) Math.floor(d);
//		Integer a = Integer.valueOf(s);
//
//		Integer b = Integer.parseInt(s);
//		
//		System.out.println(i.compareTo(2));
//		System.out.println(i.equals(3));
//		
//		System.out.println(Integer.valueOf(i));
//		System.out.println(Double.valueOf(s));
//		
//		System.out.println(b.equals(444));
//		
//		System.out.println("radhe"+i.toString());
//		System.out.println("dru"+Integer.toString(12));
//		
//		System.out.println((int)(Math.random()*100));
//		
//		String c = Character.toString('4');
		
		//System.out.println(n);
		
		//System.out.println(Integer.valueOf(s,16));
		
		
		
		
//		String name = "dhruv";
//		char c  = name.charAt(1);
//		
//		System.out.println(c);
//		
//		switch (c) {
//		case 'a':
//			System.out.println("case 1");
//			break;
//		case 'b':
//			System.out.println("case 2");
//			break;
//		case 'h':
//			System.out.println("case correct");
//			break;
//		default:
//			System.out.println("no case");
//			break;
//		}
		
//		String g = 15>20?"15 is greated than 20":"20 is greater than 15";
//		System.out.println(g);
//		
//		EnumPractice ep = new EnumPractice();
//		
//		System.out.println("dog name:"+dogName+"\n cat name:"+CATNAME);
//		
//		ep.animal=lovedAnimal.Dog;
//		ep.size = cofeeSize.large;
//		
//		System.out.println("cofee size="+ep.size);
//		System.out.println("animal: "+ ep.animal);
	}

}
