package com.practice.JavaPractice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Random;

public class DateTimeTest {
	
	
	public static void main(String[] args) {
//		LocalDate dateObj = LocalDate.now();
//		LocalTime timeObj = LocalTime.now();
//		LocalDateTime dtObj = LocalDateTime.now();
//		
//		DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
//		System.out.println(formatObj.format(dtObj));
//		
//		System.out.println(dateObj);
//		System.out.println(timeObj);
//		System.out.println(dtObj);
		
//		ArrayList<Integer> intList =  new ArrayList<Integer>();
//		
//		for(int i = 0; i<15; i = i+2) {
//		
//		intList.add((int)(Math.random()*10));
//		
//		}
//		
//		System.out.println(intList);
//		//intList.remove(2);
//		System.out.println(intList.size());
//		System.out.println(intList.contains(2));
//		System.out.println("index of 2:"+intList.indexOf(2));
//		Collections.sort(intList);
//		for(int a: intList) {
//			
//			System.out.println(a);
//			
//		}
//		intList.clear();
//		System.out.println(intList);
		
		LinkedList<Integer> dList = new LinkedList<Integer>();
		
		dList.add(10);
		
		for(int i = 0; i<15; i = i+2) {
			
			dList.add((int) (Math.random()*10));
			
			}
//		System.out.println(dList);
//		dList.removeFirst();
//		dList.addLast(10.0);
//		System.out.println(dList.size());
//		for(double d: dList) System.out.println(d);
//		
//		System.out.println("index of 10:"+dList.indexOf(10.0));
//		
//		HashMap<String, String> hmap = new HashMap<String, String>();
//		
//		hmap.put("1", "1");
//		hmap.put("2", "2");
//		hmap.put("3", "3");
//		
//		for(String i: hmap.keySet()) {
//			System.out.println("keys:"+i+" values:"+hmap.get(i));
//		}
		
		HashSet<Integer> intSet  =  new HashSet<Integer>();
		
//		intSet.add(1);
//		intSet.add(2);
//		intSet.add(2);
//		intSet.add(3);
		
		
//		System.out.print(intSet);
		
		Iterator<Integer> it = dList.iterator();
		System.out.println(dList+"\n");
		while(it.hasNext()) {
			int i = it.next();
			if(i==2) {
				it.remove();
			}
			System.out.println("begins:"+i);
		}
		System.out.println(dList);
	}
	

}
