package com.practice.JavaPracticeNew;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionPractice {
	
	LinkedList<Integer> reverseLinkedList(LinkedList<Integer> list){
		Collections.reverse(list);
		return list;
		
	}
	
	
	boolean containsOdds(List<Integer> list) {
		for(Integer a : list) {
			if(a%2==0) {
				return false;
			}
		}
		return true;
	}
	
	Map<Object, Integer> countRepititions(Object[] e) {
		Map<Object, Integer> map = new LinkedHashMap<>();
		
		for(int i =0 ; i< e.length;i++) {
			if(map.containsKey(e[i])) {
				int temp = map.get(e[i]);
				temp++;
				System.out.println(temp);
				map.put(e[i], temp);
			}
			else map.put(e[i], 1);
		}
		return map;
		
	}
	
	String listToString(List<String> list) {
		
		String result= "";
		
		result = String.join(",", list);
		
		return result;
	}
	
	String[] collect(String s, int n) {
		List<String> list = new ArrayList<>();
		
		list = collectSupport(s,list, n);
		Collections.sort(list);
		
		return list.toArray(new String[list.size()]);
		
	}
	
	private List<String> collectSupport(String s, List<String> list, int n) {
		if(s.length()>n) {
			list.add(s.substring(0,n));
			list = collectSupport(s.substring(n), list, n);
			return list;
		}
		list.add(s);
		return list;
	}

	int singleNumber(int[] n) {
		
		List<Integer> list = Arrays.stream(n).boxed().toList();
		for(Integer i:list) {
			if(list.indexOf(i)==list.lastIndexOf(i)) return i;
		}
		return 0;
	}

	
	 int bonacci(int n, int k) {
		
		List<Integer> list = new ArrayList<>();
		
		for(int i =0; i<n; i++) {
			if(i==n-1) {
				list.add(1);
				continue;
			}
			list.add(0);
		}
		System.out.println("before :"+list);
		int index =n;
		
		while(list.size()<k) {
			int sum = 0;
			int in = index-n;
			while(in<index) {
				sum+=list.get(in);
				in++;
			}
			list.add(sum);
			index++;
		}
		System.out.println("after :"+list);
		return list.get(k-1);
	}
	boolean oddOneOut(String[] arr) {

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i].length());
		}
		HashSet<Integer> set = new HashSet<>(list);
		if(set.size()==2) {
			int flag = 0;
			for(Integer i :set) {
				if(Collections.frequency(list, i)>1) {
					flag++;
				}
			}	
			return flag==1?true:false;
		}
		else return false;

	}

	
	int shuffleCount(int num) {
		List<Integer> list = new LinkedList<>();
		List<Integer> list1 = list;
		int a = 0;
		int b = num / 2;
		for (int i = 1; i <= num; i++) {
			list.add(i);
		}
		int step = 0;
		List<Integer> temp = new LinkedList<>();
		for (int i = 0; i >= 0; i++) {

			if (i % 2 == 0) {
				temp.add(list1.get(a));
				a++;
			}
			if (i % 2 != 0) {
				temp.add(list1.get(b));
				b++;
			}
			if (a == (num / 2) && b == ((num / 2) + a)) {
				if (temp.equals(list)) {
					step++;
					break;
				}
				step++;
				a = 0;
				b = num / 2;
				list1 = temp;
				System.out.println("this is list 1: " + list1);
				temp = new LinkedList<>();
			}
		}
		return step;
	}

	// AZYWABBCATTTA
	int countUniqueBooks(String str, char bookend) {
		Set<Character> set = new LinkedHashSet<>();
		int flag = 0;
		for (int i = 0; i < str.length(); i++) {
			if ((flag == 0) && str.charAt(i) == bookend) {
				i++;
				flag = 1;
			}
			if (flag == 1) {
				if (str.charAt(i) == bookend) {
					flag = 0;
					continue;
				}
				set.add(str.charAt(i));
			}
		}
		System.out.println(set);
		return set.size();
	}

	int blockPlayer(int n1, int n2) {

		int row1 = n1 / 3;
		int col1 = n1 % 3;
		int row2 = n2 / 3;
		int col2 = n2 % 3;
		if (row1 == row2)
			return (3 + 9 * row1) - (n1 + n2);
		if (col1 == col2)
			return (9 + 3 * col1) - (n1 + n2);
		return 12 - (n1 + n2);

//		List<Integer> top = List.of(0,1,2);
//		List<Integer> mid = List.of(3,4,5);
//		List<Integer> bot = List.of(6,7,8);
//		int t= 0, m=0, b=0;
//		if(top.contains(n1))t++;
//		if(top.contains(n2))t++;
//		if(mid.contains(n1))m++;
//		if(mid.contains(n2))m++;
//		if(bot.contains(n1))b++;
//		if(bot.contains(n2))b++;
//		List<Integer> list = new ArrayList<>();
//		if(t==2 || m==2 || b==2) {
//			if(t==2)list = top;
//			if(m==2)list = mid;
//			if(b==2)list = bot;
//		}
//		else {
//			if(t==1 && m==1)list = bot;
//			if(b==1 && m==1)list = top;
//			if(t==1 && b==1)list = mid;	
//		}
//		
//		int result= 0;
//		for(int i =0; i<list.size();i++) {
//			if((n1+n2+list.get(i))%3==0) {
//				result = list.get(i);
//				break;
//			}
//		}
//		return result;
	}

	String[] mostFrequentChar(String[] arr) {
		Map<String, Integer> map = new TreeMap<>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length(); j++) {

				String c = arr[i].charAt(j) + "";
				if (map.containsKey(c))
					map.put(c, map.get(c) + 1);
				else
					map.put(c, 1);
			}
		}
		List<String> list = new ArrayList<>();

		for (String key : map.keySet()) {
			if (map.get(key) >= 4)
				list.add(key);
		}
		return list.toArray(new String[list.size()]);

	}

	int countLayers(String[] rug) {
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < rug.length; i++) {
			set.add(rug[i]);
		}
		return set.size();
	}

	int[] reversibleInclusiveList(int start, int end) {
//		int[] a = new int[Math.abs(start-end)];
		if (start < end)
			return IntStream.range(start, end + 1).toArray();
		return IntStream.range(end - 1, start).map(i -> end - i + (start - 1)).toArray();
	}

	boolean consecutiveCombo(int[] r, int[] s) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < r.length; i++) {
			list.add(r[i]);
		}
		for (int i = 0; i < s.length; i++) {
			list.add(s[i]);
		}
		Collections.sort(list);
		for (int i = 0; i < list.size() - 1; i++) {
			int j = list.get(i);

			if (j + 1 != list.get(i + 1))
				return false;
		}
		return true;
	}

	Map<String, String> parseCode(String s) {
		String[] str = s.split("[0]+");
		HashMap<String, String> hm = new HashMap<>();
		hm.put("firstName", str[0].replaceAll("0", ""));
		hm.put("lastName", str[1].replaceAll("0", ""));
		hm.put("id", str[2].replaceAll("0", ""));
		return hm;
	}

	String erase(String str) {

		List<String> stack = new ArrayList<String>();
		for (int i = 0; i < str.length(); i++) {
			System.out.println(stack);
			if (!stack.isEmpty() && str.charAt(i) == '#') {
				stack.remove(stack.size() - 1);
			} else if (stack.isEmpty() && str.charAt(i) == '#')
				continue;
			else
				stack.add(String.valueOf(str.charAt(i)));
		}
		return String.join("", stack);

//		Stack<String> stack = new Stack<>();
//		for(int i =0; i<str.length();i++) {
//			if(!stack.isEmpty() && str.charAt(i)=='#') {
//				stack.pop();
//			}
//			else if(stack.isEmpty() && str.charAt(i)=='#') continue;
//			else stack.push(String.valueOf(str.charAt(i)));
//		}
//		return String.join("", stack);
	}

	Map<String, Integer> convertToNumber(Map<String, String> list) {
		HashMap<String, Integer> hm = new HashMap<>();
		Set<String> set = list.keySet();
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			String s = itr.next();
			hm.put(s, Integer.parseInt(list.get(s)));
		}
		return hm;

	}

	int findOdd(int[] arr) {
		HashMap<Integer, Integer> hm = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			if (hm.get(arr[i]) == null)
				hm.put(arr[i], arr[i]);
			else
				hm.remove(arr[i]);
		}
		int firstKey = hm.keySet().stream().findFirst().get();
		return hm.get(firstKey);
	}

	public List<Integer> test() {
		List<Integer> list = new ArrayList();
		allocate(list);
		return list;
	}

	private void allocate(List<Integer> list) {
		list = List.of(1, 2, 3, 4);

	}

	String unrepeated(String str) {
//		 str= str.replaceAll(" ", "~");
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			if (result.contains(str.charAt(i) + "") && str.charAt(i) != ' ')
				continue;
			result = result + str.charAt(i);
		}
		return result;
	}

	String sortByLength(String str) {
		String[] s = str.split(" ");
		Arrays.sort(s, Comparator.comparingInt(String::length));
//		int[] arr = new int[s.length];
//		for(int i =0; i<s.length;i++) {
//			arr[i]=s[i].length();
//		}
//		Arrays.sort(arr);
//		String[] s1 = new String[arr.length];
//		for(int i =0; i<arr.length;i++) {
////			String temp = "";
//			for(int j =0;j<s.length;j++) {
//				if(s[j].length()==arr[i]) {
//					s1[i]=s[j];
//					break;
//				}
//			}
//		}
		return String.join(" ", s);
	}

	Map<String, String> mapping(String[] letters) {

		LinkedHashMap<String, String> map = new LinkedHashMap();
		for (int i = 0; i < letters.length; i++) {
			map.put(letters[i].toLowerCase(), letters[i].toUpperCase());
		}
		return map;
	}

	String fruitSalad(String[] fruits) {
		List<String> list = new LinkedList<String>();

		for (int i = 0; i < fruits.length; i++) {
			String str = fruits[i];
			if (str.length() % 2 == 0) {
				list.add(str.substring(0, (str.length() / 2)));
				list.add(str.substring(str.length() / 2));
				continue;
			}
			list.add(str.substring(0, (str.length() / 2)));
			list.add(str.substring(str.length() / 2));
		}
		Collections.sort(list);
		String result = String.join("", list);
		return result;
	}

	boolean isPotentialFriend(String[] y, String[] o) {
		if (y.length == 1 && o.length == 1 && y[0].equalsIgnoreCase(o[0]))
			return true;
		List<String> list1 = Arrays.asList(y);
		List<String> list2 = Arrays.asList(o);
		int count = 0;
		for (String str : list2) {
			if (list1.contains(str))
				count++;
		}
		return count >= 2;
	}

	int recamanIndex(int n) {
		List<Integer> list = new ArrayList<>();
		list.add(0);
		int num = 0;
		int i = 0;
		while (num != n) {
			int first = 0;
			first = list.get(i) - list.size();
			int last = 0;
			last = list.get(i) + list.size();
			if (list.contains(first) || first <= 0)
				list.add(last);
			else {
				list.add(first);
			}
			num = list.get(i + 1);
//			System.out.println(num);
			i++;
		}
		return list.indexOf(n);
	}

	String[] cmsSelector(String[] cms, String re) {

		List<String> list = new ArrayList<>();
		for (int i = 0; i < cms.length; i++) {
			if (cms[i].toLowerCase().contains(re))
				list.add(cms[i]);
		}
		Collections.sort(list);
		return list.toArray(new String[list.size()]);
	}

	int[] uniqueSort(int[] nums) {
		TreeSet<Integer> ts = new TreeSet<>();
		for (int i = 0; i < nums.length; i++)
			ts.add(nums[i]);
//		TreeSet<Integer> ts = new TreeSet(Arrays.asList(nums));
		return ts.stream().mapToInt(Integer::intValue).toArray();

	}

	int sumTwoSmallestNums(int[] arr) {

		ArrayList<Integer> ts = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 0)
				ts.add(arr[i]);
		}
		Collections.sort(ts);
		return ts.get(0) + ts.get(1);
	}

	boolean isPandigital(long num) {
		ArrayList<Integer> al = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

		while (num > 0) {
			int temp = (int) (num % 10);
			al.remove(Integer.valueOf(temp));
			num = num / 10;
		}
		return al.size() == 0;
	}

	int[] factorize(int num) {

		int[] arr = IntStream.range(1, num + 1).filter(i -> num % i == 0).toArray();
		return arr;

	}

	boolean same(int[] a1, int[] a2) {

		HashSet<Integer> a1Set = new HashSet<>();
		HashSet<Integer> a2Set = new HashSet<>();
		a1Set = (HashSet<Integer>) Arrays.stream(a1).boxed().collect(Collectors.toSet());
		a2Set = (HashSet<Integer>) Arrays.stream(a2).boxed().collect(Collectors.toSet());
//		for(int a : a1) {
//			a1Set.add(a);
//		}
//		TreeSet<Integer> a2Set = new TreeSet<>();
//		
//		for(int a : a2) {
//			a2Set.add(a);
//		}

//		Collections.addAll(a1Set, a1);
//		Set a2Set = Set.of(a2);

		System.out.println(a1Set.size());
		System.out.println(a1Set);

		return a1Set.size() == a2Set.size();

	}

	boolean isInOrder(String str) {

		char[] strChars = str.toCharArray();
		Arrays.sort(strChars);

		return new String(strChars).equals(str);
	}

	boolean isPerfectNumber(int num) {

		if (num == 0)
			return false;
		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 1; i < num; i++) {
			if (num % i == 0)
				al.add(i);
		}

		int sum = 0;
		for (int i : al) {
			sum += i;
		}
		if (sum == num)
			return true;
		return false;
	}

	String getmapValues(HashMap<String, String> map) {

		Set<String> keySet = new TreeSet<>();
		keySet = map.keySet();
		String[] valArr = new String[keySet.size()];

		Iterator<String> itr = keySet.iterator();
		int i = 0;
		while (itr.hasNext()) {
			valArr[i] = map.get(itr.next());
			i++;
		}
		return Arrays.toString(valArr);
	}

//	Integer[] mergeArrays(Integer[] arr1, Integer[] arr2) {
	int[] mergeArrays(int[] arr1, int[] arr2) {

		return IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).toArray();

//		ArrayList arr1List = new ArrayList(Arrays.asList(arr1));
//		
//		arr1List.addAll(Arrays.asList(arr2));
//		System.out.println(arr1List);
//		Integer[] mergedArrays = (Integer[]) arr1List.toArray(new Integer[arr1List.size()]);
//		
//		return mergedArrays;

	}

	ArrayList<String> getFourWordsList(String[] arr) {
		ArrayList<String> fourWordsList = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i].length() == 4)
				fourWordsList.add(arr[i]);
		}
		return fourWordsList;
	}

	public static void main(String[] args) {

		CollectionPractice cp = new CollectionPractice();

		String[] arr = { "Ryan", "Kieran", "Jason", "Matt" };

//		Integer[] arr1 = {1, 3, 5};
//		Integer[] arr2 = {2,6,8};
//		int[] arr1 = {3, 5,5,5};
		int[] arr2 = { 4, 5 };
		HashMap<String, String> map = new HashMap<>();
		map.put("key6", "true");
		map.put("key2", "false");
		map.put("key1", "undefined");

//		System.out.println(cp.isInOrder("dhruv"));
//		System.out.println(cp.same(arr1, arr2));

//		System.out.println(cp.isPerfectNumber(8128));

//		System.out.println(cp.getmapValues(map));
//		System.out.println(Arrays.toString(cp.mergeArrays(arr1, arr2)));

//		System.out.println(cp.getFourWordsList(arr));

//		List<Integer> intList = new ArrayList<>();
//		Map<String, String> strMap =  new HashMap<>();
//		
//		strMap.put("1", "value 1");
//		strMap.put("2", "value 2");
//		strMap.put("1", "value 2");
//		System.out.println("map: "+strMap);
//		
//		intList.add(1);
//		intList.add(10);
//		intList.add(3);
//		intList.add(4);
//		intList.add(5);
//		
//		intList.add(2, 4);
////		intList.remove(1);
//		
//		System.out.println(intList.get(2));
//		System.out.println(Arrays.toString(cp.factorize(1)));
//		System.out.println(cp.isPandigital(10282343456789L));
//		String[] arr1 = {6, 7, 3, 2, 1};
//		System.out.println(cp.sumTwoSmallestNums(arr1));
//		System.out.println(Arrays.toString(cp.uniqueSort(arr1)));

//		System.out.println(Arrays.toString(cp.cmsSelector(new String[]{"WordPress", "Joomla", "Drupal", "Magento"}, "")));
//		System.out.println(cp.recamanIndex(10000));
//		System.out.println(cp.isPotentialFriend(new String[] {"cycling", "technology", "reading"}, new String[] {"dancing", "planes", "politics"}));
//		System.out.println(cp.fruitSalad(new String[] {"banana"}));
//		System.out.println(cp.mapping(new String[] {"d", "x", "t", "s"}));
//		System.out.println(cp.sortByLength("Three can keep a secret, if two of them are dead"));
//		System.out.println(cp.unrepeated("stratus nimbus"));
//		System.out.println(cp.test());
//		System.out.println(cp.findOdd(new int[] {20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5}));
//		Map<String, String> map1 = new HashMap<>();
//		map1.put("piano", "200");
//		map1.put("tv","300");
//		map1.put("sterio","700");
//		
//		System.out.println(cp.convertToNumber(map1));

//		System.out.println(cp.erase("si###t boy 	"));
//		System.out.println(cp.parseCode("Madsy0Jupiter0321"));
//		System.out.println(cp.consecutiveCombo(new int[] {4, 3, 1}, new int[] {0, 7, 6, 5}));
//		System.out.println(Arrays.toString(cp.reversibleInclusiveList(21, 11)));
//		System.out.println(cp.countLayers(new String[] {"AAAAAAAAAAA",
//				  "AABBBBBBBAA",
//				  "AABCCCCCBAA",
//				  "AABCAAACBAA",
//				  "AABCADACBAA",
//				  "AABCAAACBAA",
//				  "AABCCCCCBAA",
//				  "AABBBBBBBAA",
//				  "AAAAAAAAAAA"}));

//		System.out.println(Arrays.toString(cp.mostFrequentChar(new String[] {"potion", "master", "professor", "snape"})));
//		System.out.println(cp.blockPlayer(6,4));
//		System.out.println(cp.countUniqueBooks("&4&3&3&", '&'));
//		System.out.println(cp.shuffleCount(14));
//		System.out.println(cp.oddOneOut(new String[] {"very", "to", "then", "some","me","he"}));
//		System.out.println(cp.bonacci(5, 10));
//		System.out.println(cp.singleNumber(new int[] {-1, 2, -4, 20, -1, 2, -4, -4, 2, -1}));
//		System.out.println(Arrays.toString(cp.collect("pneumonoultramicroscopicsilicovolcanoconiosis", 22)));
//		List<String> list = new ArrayList<>();
//		list.add("dhruv");
//		list.add("you");
//		list.add("rock");
//		System.out.println(cp.listToString(list));
		
//		System.out.println(cp.countRepititions(new Object[] {"Infinity", "null", "Infinity", "null", "null"}));
		List<Integer> list =  new ArrayList<>();
		System.out.println(cp.containsOdds(List.of(11,13,15,23,21)));
		
		LinkedList<Integer> list1 = new LinkedList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		System.out.println(cp.reverseLinkedList(list1));
	
	}

}
