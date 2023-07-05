package com.practice.JavaPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ThreadTest tt = new ThreadTest();
    	
//    	Runnable r = new ThreadInterfaceTest();
//    	Thread task = new Thread(r);
    	Thread task = new Thread(new ThreadInterfaceTest());
    	
    	System.out.println("start");
    	
    	tt.start();
    	task.start();
    	for(int i =0; i<=10; i++) {
			System.out.println("***in main ***"+i);
		}
    	
    	System.out.println("finish");
//       List<String> duplicateList = new ArrayList<String>();
////       List<String> duplicateList = Arrays.asList("a","b","d","a","e","c");
//       
//       duplicateList.add("d");
//       duplicateList.add("b");
//       duplicateList.add("b");
//       duplicateList.add("A");
//       duplicateList.add("B");
//       duplicateList.add("a");
//       duplicateList.add("c");
//       
////       System.out.println(duplicateList);
////       Collections.sort(duplicateList, String.CASE_INSENSITIVE_ORDER);
////       System.out.println(duplicateList);
////       Collections.sort(duplicateList, Collections.reverseOrder());
//////       Collections.reverse(duplicateList);
////       System.out.println(duplicateList);
////       
////       Set<String> noDuplicateSet = new HashSet<String>(duplicateList);
////       System.out.println(noDuplicateSet);
//       String arrayToString = "";
//       for( String item: duplicateList) {
//    	   arrayToString = arrayToString.concat(item+", ");
//       }
//       
//       System.out.println(arrayToString);
    }
}

class ThreadInterfaceTest implements Runnable{

	public void run() {
		
		for(int i =0; i<=10; i++) {
			System.out.println("^^^in implemets test ^^"+i);
		}
		
	}
	
}