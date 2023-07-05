package com.practice.JavaPracticeNew;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.IntStream;

public class FunctionalPrograming<R> {
	
	String[] dictionary(String s, String[] w) {
		
//		Object[] arr=Arrays.asList(w).stream().filter(i->i.startsWith(s)).toArray(); 

		return Arrays.asList(w).stream().filter(i->i.startsWith(s)).toArray(String[]::new);
		
	}
	
	boolean trianguilarNum(int n) {
		double result =  (Math.sqrt(n*8 +1 ));
		return   result == (int)result;
		
	}
	
	int[] noOdds(int[] nums) {
		
		List<Integer> intList = new ArrayList<>(); 
		for(int i = 0; i< nums.length ; i++) {
			if(nums[i]%2==0) intList.add(nums[i]);
		}
		return intList.stream().mapToInt(i->i).toArray();
		
//		return Arrays.asList(nums).stream().filter(i-> i % 2==0).forEach(System.out::println);
	}
	
	String reverseCase(String str) {
		
//		return Arrays.asList(str.toCharArray()).stream()
//				.map(c -> Character.isLowerCase(c)? (""+c).toUpperCase(): (""+c).toLowerCase()).toArray(String::new));
		String reversed = "";
		for(int i = 0; i<str.length(); i++) {
			if(Character.isLowerCase(str.charAt(i))) reversed += (str.charAt(i)+"").toUpperCase();
			else reversed += (str.charAt(i)+"").toLowerCase();
		}
		return reversed;
	}
	
	String move(String word) {
		String result = "";
		for(int i = 0; i< word.length(); i++) {
			result = result+(char)(word.charAt(i)+1);
		}
		return result;
//		String result = Arrays.toString(Arrays.asList(word.toCharArray()).stream().map(i -> Character.toString((int)i+1)).toArray(String[]::new));
		
	}
	
	String[] filterStateNames(String[] arr, String type) {
		
		if(type.equals("abb")) {
			return Arrays.asList(arr).stream().filter(abb -> abb.length()==2)
					.toArray(String[]::new);
		}
				
		return Arrays.asList(arr).stream().filter(ty -> ty.length()>2).toArray(String[]::new);
		
	}
	
	String[]  jazzify(String[] arr) {
		
//		List<String> list =(List<String>) Arrays.asList(arr).stream().filter(cord -> cord.endsWith("7")).map(cord->cord+"7"); 
//		return  Arrays.asList(arr).stream().filter(cord -> !cord.endsWith("7")).map(cord->cord+"7").toArray(String[]::new) ;
		return  Arrays.asList(arr).stream().map( cord->  cord.endsWith("7")?cord:cord+"7").toArray(String[]::new) ;
	}
	
	private void printStringList(List<String> strList) {
		// TODO Auto-generated method stub
//		strList.stream()
//		.filter(i->i.length()>4)
//		.forEach(System.out::println);
//		System.out.println("\n\nnew stream");
//		strList.stream()
//		.filter(i->i.toLowerCase().contains("spring"))
//		.forEach(System.out::println);
		
		strList.stream().map(i-> i+ " " +i.length()).forEach(System.out::println);
		
	}

	private void printList(List<Integer> list) {
		// TODO Auto-generated method stub
		 list.stream()
		.filter(i->i%2!=0)
		.map(i->Math.pow(i, 3))
		.forEach(System.out::println);
		
	}

	private static void print(int num) {
		// TODO Auto-generated method stub
		System.out.println(num);
	}
	
	
	
	public static void main(String[] args) {
		
		FunctionalPrograming  fp = new FunctionalPrograming();
		
//		fp.printList(List.of(11,20,30,15, 4));
		String[] arr = {"Montana", "FL"};
		int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8};
		
//		System.out.println(fp.trianguilarNum(15));
		
//		System.out.println(Arrays.toString(fp.noOdds(arr1)));
//		System.out.println(fp.reverseCase("NaMasTe"));
//		System.out.println(Arrays.toString(fp.filterStateNames(arr, "full")));
//		System.out.println(fp.move("welcome"));
//		fp.printStringList(List.of("ab","spring1","lovespring", "happy", "dhruv spring"));
//		System.out.println(Arrays.toString(fp.jazzify(arr)));
		System.out.println(Arrays.toString(fp.dictionary("cre", new String[] {"creating", "creature", "creed", "increasing"})));
		
	}

	

}
