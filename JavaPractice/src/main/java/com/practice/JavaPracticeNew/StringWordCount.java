package com.practice.JavaPracticeNew;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.stream.events.Characters;

public class StringWordCount {
	
	String encryption(String s1) {
		String s = s1.replaceAll(" ", "");
		int len = s.length();
		System.out.println(len);
		int r = 0;
		int c=0;
		int t = 0;
		for(int i =1; i<len/2;i++) {
			t = (int)(len/(Math.pow(i, 2)));
			if(t<=0) {
				t = i;
				break;
			}
		}
		
		if(Math.pow(t, 2) > len) {
			c= t;
			r=t-1;
		}
		else {
			c=t;
			r=t;
		}
		if(c*r<len) {
			c=t;
			r=t;
		}
		System.out.println(" c:"+c+" r="+r);
		List<String> list = new ArrayList<>();
		
		int index = 0;
		for(int i =0; i<r;i++) {
			String res = "";
			for(int j = 0;j<c; j++) {
				
				if((i==r-1)) {
					if(index==(len-1)) {
						int temp = c-res.length();
						res = res+ s.charAt(index) +" ".repeat(temp);
						break;	
					}
					
				}
				System.out.println("index: "+index+" i:"+i+" j="+j);
				res = res+s.charAt(index);
				index++;
			}
			list.add(res);
		}
		System.out.println("list:"+list);
		
		String result = "";
		for(int j = 0; j<list.get(0).length(); j++) {
			for(int i =0; i<list.size();i++) {
				if(list.get(i).charAt(j)==' ') continue;
				result = result +list.get(i).charAt(j);
			}
			result = result +" ";
		}
		return result.trim();
	}
	
	String pilish_string(String s) {
		String result = "";
		String str = s;
		String pi = "314159265358979";
		int index = 0;
		int i =0;
		while(str.length()>0) {
			
			int temp = Integer.parseInt(pi.charAt(index)+"");
			if(index==pi.length()-1) break;
			if(temp < str.length()) {
				result  = result + " "+ str.substring(0,temp);
				str = str.substring(temp);
				index++;
				i=i+temp;
//				System.out.println(result);
				continue;
			}
			int diff = temp-str.length();
			String t = str+str.substring(str.length()-1).repeat(diff);
			result = result + " "+t;
			break;
		}
		return result.trim();
	}
	
	boolean ascending(String str) {
		String s = str;
		int counter = 0;
		for(int i =0; (i+3)<str.length(); i=i+3) {
			String temp =s.substring(i,i+3);
			int a = Integer.parseInt(temp.charAt(0)+"");
			int b = Integer.parseInt(temp.charAt(1)+"");
			int c = Integer.parseInt(temp.charAt(2)+"");
			if((a<b && b<c) || (a==b && b==c)) continue;
			else {
				counter++;
				break;
			}
			
		}
		if(counter!=0 && str.length()!=0) return false;
		if(counter != 0) {
			for(int i =0; (i+2)<str.length(); i=i+2) {
				String temp =s.substring(i,i+2);
				int a = Integer.parseInt(temp.charAt(0)+"");
				int b = Integer.parseInt(temp.charAt(1)+"");
				if(a==b || a<b) {
					s = temp;
					continue;
				}
				else {
					counter++;
					break;
				}
			}
			counter--;
		}
		
		return counter==0;
	}
	
	
	//https://edabit.com?a=1&b=2&a=2
	String stripUrlParams(String url) {
		
		String[] str = url.split("\\?");
		if(str.length==1) return str[0];
		
		Map<String, String> map =  new HashMap<>();
		String[] strAfter = str[1].split("&");
		for(int i =0;i<strAfter.length;i++) {
			map.put(strAfter[i].substring(0,1), strAfter[i].substring(2));
		}
		
		String res = "";
		for(var entry : map.entrySet()) {
			res = res + entry.getKey()+"="+entry.getValue()+"&";
		}
		
		return str[0]+"?"+res.substring(0,res.length()-1);
	}
	
	long repeatedString(String s, long n) {
		if(n<s.length()) return s.substring(0, (int)n).replaceAll("[^a]", "").length();
		long tLen = s.length();
		long len = s.replaceAll("[^a]", "").length();
		System.out.println(len+" "+tLen);
		long numRepratedS =  (long) n/tLen;
		
		if(numRepratedS*tLen != n ) {
			long rem = n-(numRepratedS*tLen);
			int val = s.substring(0,(int)rem).replaceAll("[^a]", "").length();
			return numRepratedS*len + val;
		}
		
		System.out.println(numRepratedS);
		return numRepratedS*len;
	}
	
	boolean isZygodrome(long num) {
		String n = Long.toString(num);
		if(n.length()<2) return false;
		for(int i =0; i<n.length();i++) {
			if(i == 0) {
				if(n.charAt(i)!=n.charAt(i+1))return false;
				continue;
			}
			if(i == n.length()-1) {
				System.out.println("here");
				 if(n.charAt(i)!=n.charAt(i-1))	return false;
				 continue;
			}
			if(n.charAt(i)!=n.charAt(i-1) && n.charAt(i)!=n.charAt(i+1)) return false;
		}
		return true;
	}

	String correctTitle(String str) {
		String result = "";
		List<String> list = List.of("and", "the","of","in");
		String[] s = str.toLowerCase().split(" ");
		
		for(int i =0; i<s.length; i++) {
			if(list.contains(s[i])) {
				result = result +" "+s[i];
				continue;
			}
			result = result +" "+ Character.toUpperCase(s[i].charAt(0))+s[i].substring(1);
		}
		return result.trim();
	}

	boolean validName(String str) {

		String[] s = str.split(" ");
		if (s.length == 1 || s.length > 3)
			return false;
		for (int i = 0; i < s.length; i++) {
			if (i == s.length - 1) {
				if (s[i].length() < 2 || s[i].contains(".") || !Character.isUpperCase(s[i].charAt(0)))
					return false;
				continue;
			}
			if (i == 0 && s[i].length() > 2) {
				if (s[i].contains(".") || !Character.isUpperCase(s[i].charAt(0)))
					return false;
				continue;
			}
			if (s[i].length() != 2 || !s[i].contains(".") || !Character.isUpperCase(s[i].charAt(0)))
				return false;

		}
		return true;
	}

	String mixedNumber(String frac) {
		String[] s = frac.split("/");
		int numerator = Integer.parseInt(s[0]);
		int denominator = Integer.parseInt(s[1]);
//		System.out.println(numerator+" "+denominator);
		int a = numerator / denominator;
		int b = numerator % denominator;
		int temp = b;
		b = Math.abs(b);
		if (b != 0) {
			td = new TriangleDots();
			int gcd = td.findGcd2(denominator, b);
//			System.out.println(gcd+" " +b);
			denominator = denominator / gcd;
			b = b / gcd;

		}
		String left = a == 0 ? " " : a + " ";
		String up = b == 0 ? a + "" : (temp < 0 && a == 0) ? "-" + b : b + "";
		String down = b == 0 ? " " : "/" + denominator;

		return b == 0 ? a + "" : (left + up + down).trim();

	}

	String generateWord(int n) {
		if (n < 2)
			return "invalid";
		List<String> list = new ArrayList<>();
		list.add("b");
		list.add("a");

		list = supportGenerateWord(list, n - 2);

		String result = "";
		for (String s : list)
			result = result + ", " + s;

		return result.substring(1).trim();
	}

	private List<String> supportGenerateWord(List<String> list, int n) {
		if (n > 0) {
			String str = list.get(list.size() - 1) + list.get(list.size() - 2);
			list.add(str);
			list = supportGenerateWord(list, n - 1);
		}
		return list;
	}

	TriangleDots td;

	String reverseLegoYoda(String text) {
		String result = "";

		String[] s1 = text.split("\\.");
		for (int i = 0; i < s1.length; i++) {
			String[] s2 = s1[i].split(",");
			for (int j = s2.length - 1; j >= 0; j--) {
				s2[j] = s2[j].trim();
				if (j == 0) {
					result = result + " " + s2[j].trim().substring(0, 1).toLowerCase().concat(s2[j].substring(1)) + ".";
					continue;
				}
				result = result + " " + s2[j].substring(0, 1).toUpperCase().concat(s2[j].substring(1));
			}
			result = result.trim();
		}

		return result.trim();
	}

	boolean validColor(String color) {

		String[] c = color.replaceAll(" ", "").split("\\(");
		if (c[0].length() == 4) {
			return validColorRgba(c[1]);
		}
		if (c[0].length() == 3) {
			System.out.println(c[1]);
			return validColorRgb(c[1]);
		}
		return false;
	}

	private boolean validColorRgba(String string) {

		String[] str = string.replaceAll("[^0-9,\\.-]", "").split(",");
		if (str.length != 4)
			return false;
		for (int i = 0; i < str.length; i++) {
			if (str[i].length() == 0)
				return false;
			if (i == 3) {
				if (Double.parseDouble(str[i]) > 1 || Double.parseDouble(str[i]) < 0) {
					return false;
				}
				continue;
			}
			int color = Integer.parseInt(str[i]);
			if (color < 0 || color > 255) {
				return false;
			}
		}
		return true;
	}

	private boolean validColorRgb(String string) {
//		System.out.println(string);
		String[] str = string.replaceAll("[^0-9,-]", "").split(",");

		for (int i = 0; i < str.length; i++) {
			if (str[i].length() == 0)
				return false;
			int color = Integer.parseInt(str[i]);
			if (color < 0 || color > 255)
				return false;
		}
		return true;
	}

	String numToEng(int n) {
		String result = "";

		String[] zeroToTwenty = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
				"eleven", "twelve", "thirteen", "forteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",
				"twenty" };
		String[] tens = { "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };
		if (n == 0)
			result = "zero";
		if (n <= 20)
			result = zeroToTwenty[n];
		if (n < 100 && n > 20)
			result = tens[(n / 10) - 1] + " " + zeroToTwenty[(n % 10)];
		if (n > 100) {
			int n1 = n / 100;
			int temp = (n % 100);
			if (temp < 20) {
				result = zeroToTwenty[n1] + " hundread " + " " + zeroToTwenty[temp];
			} else {
				int n2 = temp / 10;
				n2 = n2 == 0 || n2 == 1 ? ++n2 : n2;
				int n3 = (n % 10);
				result = zeroToTwenty[n1] + " hundread " + tens[n2 - 1] + " " + zeroToTwenty[n3];
			}
		}

		return result;
	}

	String longestNonrepeatingSubstring(String str) {
		String result = "";
		String temp = "";
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (temp.contains(c + "")) {
				result = result.length() >= temp.length() ? result : temp;
				temp = "" + c;
			} else
				temp += c;
		}
		result = result.length() >= temp.length() ? result : temp;
		return result;
	}

	String sentencePrimeness(String sentence) {
		td = new TriangleDots();
		String[] s = sentence.toLowerCase().replaceAll("[^0-9a-z ]", "").split(" ");
		int[] val = new int[s.length];
		int temp = 0;
		int result = 0;
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s[i].length(); j++) {
				char c = s[i].charAt(j);
				if (Character.isDigit(c)) {
					temp += Integer.parseInt(c + "");
					continue;
				}
				temp += ((int) c - 96);
			}
			val[i] = temp;
			temp = 0;
		}
		for (int i = 0; i < val.length; i++) {
			result += val[i];
		}
		System.out.println(result);
		if (td.isPrime(result)) {

			return "prime sentence";
		}
		return "composite sentence";
	}

	String caesarCipher(String s, int k) {
		String result = "";
		int temp = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (Character.isAlphabetic(c)) {
				temp = (int) c + k;

				if (Character.isUpperCase(c)) {
					temp = temp > 90 ? (temp - 90 + 64) : temp;
					result = result + (char) temp;
					continue;
				}

				temp = temp > 122 ? (temp - 122 + 96) : temp;
				result = result + (char) temp;
				continue;
			}
			result = result + c;
		}
		return result;
	}

	String alphabetIndexVeryHard(String s) {
		s = s.toLowerCase();
		int temp = 0;
		String str = "";
		for (int i = 0; i < s.length(); i++) {
			int a = (int) s.charAt(i) - 96;
			if (a > temp) {
				temp = a;
				str = s.charAt(i) + "";
			}
		}
		return temp + str;
	}

	String longestSubstring(String digits) {
		String result = digits.charAt(0) + "";
		String temp = "";
		for (int i = 0; i < digits.length(); i++) {
			if (temp.length() > 0 && i != digits.length() - 1) {
				System.out.println("in here");
				if ((Integer.parseInt(digits.charAt(i) + "") % 2 == 0
						&& Integer.parseInt(digits.charAt(i + 1) + "") % 2 == 0)) {
					if (Integer.parseInt(digits.charAt(i - 1) + "") % 2 != 0) {
						temp = temp + digits.charAt(i);
					}
					System.out.println("even :" + temp);
					result = result.length() >= temp.length() ? result : temp;
					temp = "";
					continue;
				}
				if ((Integer.parseInt(digits.charAt(i) + "") % 2 != 0
						&& Integer.parseInt(digits.charAt(i + 1) + "") % 2 != 0)) {
					if (Integer.parseInt(digits.charAt(i - 1) + "") % 2 == 0) {
						temp = temp + digits.charAt(i);
					}
//					|| (Integer.parseInt(digits.charAt(i) + "") % 2 != 0
//							&& Integer.parseInt(digits.charAt(i - 1) + "") % 2 != 0)
					System.out.println("odd :" + temp);
					result = result.length() >= temp.length() ? result : temp;
					temp = "";
					continue;
				}
			}

			temp = temp + digits.charAt(i);
			System.out.println("out :" + temp + " " + temp.length());
		}
//		String res="";
//		for(int i =0 ;i<result.length()-1;i++) {
//			if((Integer.parseInt(digits.charAt(i) + "") % 2 != 0
//						&& Integer.parseInt(digits.charAt(i + 1) + "") % 2 != 0)
//					||(Integer.parseInt(digits.charAt(i) + "") % 2 == 0
//					&& Integer.parseInt(digits.charAt(i + 1) + "") % 2 == 0)) {
//				continue;
//			}
//			res = res + result.charAt(i);
//		}
		return result;
	}

	String specialReverseString(String str) {
		List<String> list = new ArrayList<>();
		String s = str.replaceAll(" ", "");
		for (int i = s.length() - 1; i >= 0; i--) {
			list.add(s.charAt(i) + "");
		}
//		String s= new StringBuilder(str).reverse().toString().toLowerCase();

		String result = "";
		int index = 0;
		int i = 0;
		while (index < list.size()) {
			if (str.charAt(i) == ' ') {
				result = result + " ";
				i++;
			} else {
				String ch = Character.isUpperCase(str.charAt(i)) ? (list.get(index)).toUpperCase() : (list.get(index));
				result = result + ch;
				index++;
				i++;
			}

		}
		return result;

	}

	String pigLatin(String str) {
		String[] a = str.split(" ");
		String result = "";
		for (int i = 0; i < a.length; i++) {
			String c = a[i].charAt(0) + "";
			String temp = "";
			if (!Character.isAlphabetic(a[i].charAt(a[i].length() - 1))) {
				temp = a[i].charAt(a[i].length() - 1) + "";
				a[i] = a[i].substring(0, a[i].length() - 1);
			}
			if (c.matches("[aeiouAEIOU]")) {
				result = result + " " + a[i] + "way" + temp;
				continue;
			}
			result = result + " " + a[i].substring(1) + c.toLowerCase() + "ay" + temp;
		}
		result = result.trim();
		return (result.charAt(0) + "").toUpperCase() + result.substring(1);
	}

	long numbersNeedFriendsToo(int n) {
		String num = Integer.toString(n);
		String result = "";
		for (int i = 0; i < num.length(); i++) {
			char digit = num.charAt(i);
			if (i == 0) {
				String temp = digit != num.charAt(i + 1) ? (digit + "").repeat(3) : digit + "";
				result = result + temp;
				continue;
			}
			if (i == num.length() - 1) {
				String temp = digit != num.charAt(i - 1) ? (digit + "").repeat(3) : digit + "";
				result = result + temp;
				continue;
			}
			String temp = (digit == num.charAt(i - 1) || digit == num.charAt(i + 1)) ? (digit + "")
					: (digit + "").repeat(3);
			result = result + temp;
		}
		return Long.parseLong(result);
	}

	String[] removeLetters(String[] letters, String word) {

		List<String> list = new LinkedList<>();
		for (int i = 0; i < letters.length; i++) {
			list.add(letters[i]);
		}

//		List<String> res = new ArrayList<>();
		for (int i = 0; i < word.length(); i++) {

			int index = list.indexOf(word.charAt(i) + "");
			if (index != -1)
				list.remove(index);

		}
		return list.toArray(new String[list.size()]);
	}

	boolean strongPassword(String password) {
		if (password.length() >= 6) {
			if (password.matches(".*[0-9]+.*") && password.matches(".*[A-Z]+.*") && password.matches(".*[a-z]+.*")
					&& password.matches(".*[!@#$%//^//&//*//(//)-//+]+.*"))
				return true;
		}
		return false;
	}

	String reverseWords(String s) {
		String[] str = s.split(" ");
		String result = "";
		for (int i = str.length - 1; i >= 0; i--) {
			result = (result + " " + str[i]).trim();
		}
		return result.trim();
	}

	String cipher(String message, int nSlide) {
		if (message.length() == 0)
			return "";
		List<String> list = new ArrayList<>();
		String temp = "";
		int n = Math.ceilDiv(message.length(), nSlide);
		for (int i = 0; i < message.length(); i++) {
			if ((i + 1) % n == 0) {
				temp = temp + message.charAt(i);
				list.add(temp);
				temp = "";
				continue;
			}
			temp = temp + message.charAt(i);

		}
		list.add(temp);
		int last = list.size() - 1;
		if (list.get(last).length() < n)
			list.set(last, list.get(last) + " ".repeat(n - list.get(last).length()));
		if (list.size() < nSlide) {
			for (int j = 0; j < (nSlide - list.size()); j++) {
				list.add(" ".repeat(n));
			}
		}
		String result = "";
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < nSlide; j++) {
				result = result + list.get(j).charAt(i);
			}
		}
		return result.trim();
	}

	String addSpaceUpperCase(String s) {
		s = Character.isUpperCase(s.charAt(0)) ? s.charAt(0) + " " : s.charAt(0) + "";
		return s;
	}

	String recompose(String str) {
		String result = "";
		String temp = "";
		for (int i = 0; i < str.length(); i++) {
			String t = "";
			if (temp.length() == 0) {
				temp = temp + str.charAt(i);
			} else if ((str.charAt(i) + "").matches("[aeiouAEIOU]")
					&& (str.charAt(i - 1) + "").matches("[aeiouAEIOU]")) {
				t = addSpaceUpperCase(str.charAt(i) + "");
				temp = temp + t;
			} else if (!(str.charAt(i) + "").matches("[aeiouAEIOU]")
					&& !(str.charAt(i - 1) + "").matches("[aeiouAEIOU]")) {
				t = addSpaceUpperCase(str.charAt(i) + "");
				temp = temp + t;
			} else if ((str.charAt(i) + "").matches("[aeiouAEIOU]")
					&& !(str.charAt(i - 1) + "").matches("[aeiouAEIOU]")) {
				t = addSpaceUpperCase(str.charAt(i) + "");
				temp = new StringBuilder(temp).reverse().toString();
				result = result + temp;
				temp = "" + t;
			} else {
				t = addSpaceUpperCase(str.charAt(i) + "");
				temp = new StringBuilder(temp).reverse().toString();
				result = result + temp;
				temp = "" + t;
			}
		}
		result = result + new StringBuilder(temp).reverse().toString();
		return result.trim();
	}

	String expandedForm(double n) {
		String[] a = Double.toString(n).split("\\.");
		String result = "";
		for (int i = 0; i < a[0].length(); i++) {
			if (a[0].charAt(i) == '0')
				continue;
			result = result + a[0].charAt(i) + "0".repeat(a[0].substring(i + 1).length());
			result = result + " + ";
		}
		for (int i = 0; i < a[1].length(); i++) {
			if (a[1].charAt(i) == '0')
				continue;
			result = result + a[1].charAt(i) + "/1" + "0".repeat(i + 1);
			if (i != a[1].length() - 1)
				result = result + " + ";
		}
		return result;
	}

	String rearrange(String s) {
		if (s.replaceAll(" ", "").length() == 0)
			return "";
		HashMap<Integer, String> map = new HashMap<>();
		String[] str = s.split(" ");
		for (int i = 0; i < str.length; i++) {
			map.put(Integer.parseInt(str[i].replaceAll("[^0-9]", "")), str[i].replaceAll("[0-9]", ""));
		}
		String result = "";
		for (int i = 1; i <= map.size(); i++) {
			result = result + " " + map.get(i);
		}
		return result.trim();
	}

	String licensePlate(String code, int group) {
		code = new StringBuilder(code.replaceAll("-", "")).reverse().toString();
		String result = "";
		for (int i = 0; i < code.length(); i++) {
			if (i != code.length() - 1 && (i + 1) % group == 0) {
				result = result + code.charAt(i) + "-";
				continue;
			}
			result = result + code.charAt(i);
		}
		return new StringBuilder(result.toUpperCase()).reverse().toString();
	}

	boolean sameLetterPattern(String str1, String str2) {

		if (str1.length() != str2.length())
			return false;
		HashMap<Character, Character> map = new HashMap<>();
		for (int i = 0; i < str1.length(); i++) {
			if (map.containsKey(str1.charAt(i)) && map.get(str1.charAt(i)) != str2.charAt(i))
				return false;
			map.put(str1.charAt(i), str2.charAt(i));
		}
		return true;
	}

	String paulCipher(String txt) {
		int alpha = 0;
		txt = txt.toLowerCase();
		String result = "";
		for (int i = 0; i < txt.length(); i++) {
			char c = txt.charAt(i);
			if (Character.isAlphabetic(c)) {
				int val = alpha + ((int) c);
				val = val > 122 ? val - 26 : val;
				alpha = ((int) c) - 96;
				result += (char) val;
			} else
				result += c;
		}
		return result.toUpperCase();
	}

	char findTheDifference(String s, String t) {
//		String result = "";
		for (int i = 0; i < s.length(); i++) {
			t = t.replace(s.charAt(i) + "", "");
		}
		return t.charAt(0);
	}

	boolean validWordNest(String word, String nest) {
		int itr = nest.length() / word.length();
		for (int i = 0; i < itr; i++) {
			String temp = nest.replaceAll(word, "");
			if (temp.equals(""))
				return true;
			nest = temp;
		}
		return false;
	}

	String youtubeId(String link) {
		if (link.lastIndexOf("=") != -1) {
			if (link.indexOf("=") != link.lastIndexOf("=")
					&& Character.isDigit(link.charAt(link.lastIndexOf("=") + 1))) {
				String[] arr = link.substring(link.lastIndexOf("?") + 1).split("=");
				return arr[arr.length - 2];
			}
			return link.substring(link.lastIndexOf("=") + 1);
		} else
			return link.substring(link.lastIndexOf("/") + 1);
	}

	boolean isPalindromePossible(String str) {
		int totalLength = str.length();
		int c = 0;
		for (int i = 0; i < str.length(); i++) {
			String temp = str.replaceAll(str.charAt(i) + "", "");
			int finalLength = temp.length();
//			System.out.println(finalLength);
			if (totalLength % 2 == 0 && finalLength % 2 != 0)
				return false;

			if (totalLength % 2 != 0 && finalLength % 2 == 0) {
				c++;

			}

			if (c > 1)
				return false;
		}
		return true;
	}

	boolean canComplete(String initial, String word) {

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < initial.length(); i++) {
			char c = initial.charAt(i);
			if (word.contains(c + "")) {
				int temp = word.indexOf(c);
				list.add(temp);
				word = word.replaceFirst(c + "", "");
				if (!(Collections.max(list) <= temp))
					return false;
			} else
				return false;
		}
		return true;

	}

	int[] encrypt(String str) {
		int[] encrypted = new int[str.length()];
		int start = 0;
		for (int i = 0; i < str.length(); i++) {
			int a = str.charAt(i) - start;
			start = str.charAt(i);
			encrypted[i] = a;
		}
		return encrypted;
	}

	String decrypt(int[] arr) {
		String result = "";
		int start = 0;
		for (int i = 0; i < arr.length; i++) {
			result = result + (char) (arr[i] + start);
			start = start + arr[i];
//			System.out.println(result+ " "+start);
		}
		return result;
	}

	String atbash(String str) {
		String temp = str.toLowerCase();
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isAlphabetic(str.charAt(i))) {
				result += str.charAt(i);
				continue;
			}
			int val = (int) temp.charAt(i) - 96;
			val = 97 + (26 - val);
			if (Character.isUpperCase(str.charAt(i))) {
				result += Character.toUpperCase((char) val);
				continue;
			}
			result += (char) val;
		}
		return result;
	}

	String[] splitExample(String str) {
		List<String> list = new ArrayList<>();
		int c = 0;
		String temp = "";
		for (int i = 0; i < str.length(); i++) {
			temp += str.charAt(i);
			if (str.charAt(i) == '(')
				c++;
			if (str.charAt(i) == ')')
				c--;
			if (c == 0) {
				list.add(temp);
				temp = "";
			}
		}
		return list.toArray(new String[list.size()]);
//		List<String> list = new ArrayList<>();
//		int c = 0;
//		for(int i = 0; i<str.length();i++) {
//			String temp = "";
//			for(int j = i; j<str.length();j++) {
//				temp +=str.charAt(j);
//				if(str.charAt(j)=='(') c++;
//				if(str.charAt(j)==')') c--;
//				i=j;
//				if(c==0) break;
//			}
//			list.add(temp);
//		}
//		return list.toArray(new String[list.size()]);
	}

	String incrementString(String str) {
		String temp = str.replaceAll("/D", "");
		if (temp.length() == 0 || !Character.isDigit(str.charAt(str.length() - 1)))
			return str + "1";
		String t = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			if (!Character.isDigit(str.charAt(i)))
				break;
			t = t + str.charAt(i);
		}
		t = new StringBuilder(t).reverse().toString();
		int totalLen = t.length();
		int tval = Integer.parseInt(t);
		tval = tval + 1;
		int tvalLen = Integer.toString(tval).length();
		int zeros = totalLen - tvalLen;
//		if(totalLen==tvalLen) return str.substring(0, str.length()-totalLen)+Integer.toString(tval);
//		else 
		return str.substring(0, str.length() - totalLen) + "0".repeat(zeros) + Integer.toString(tval);

	}

	boolean possiblePalindrome(String str) {
		if (str.length() == 1)
			return true;
		int c = 0;
		for (int i = 0; i < str.length(); i++) {
			String temp = str.replaceAll(str.charAt(i) + "", "");
			if (temp.length() == 0)
				return true;
			if (str.length() % 2 == 0 && temp.length() % 2 != 0)
				c++;
			if (str.length() % 2 != 0 && temp.length() % 2 == 0)
				c++;
		}

		return c <= 1;

	}

	boolean anagram(String name, String[] words) {
		name = name.toLowerCase();
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				int index = name.indexOf(words[i].charAt(j));
				if (index != -1)
					name = name.replaceFirst(words[i].charAt(j) + "", "");
				else
					return false;
				System.out.println(name);
			}
		}
		if (name.trim().length() != 0)
			return false;
		return true;
	}

	String toBitString(String word) {

		return "0" + new BigInteger(word.getBytes()).toString(2);

	}

	Boolean[] toBoolArray(String bits) {
		Boolean[] b = new Boolean[bits.length() / 8];
		int index = 0;
		for (int i = 0; i < bits.length(); i += 8) {
			String temp = new String(new BigInteger(bits.substring(i, i + 8), 2).toByteArray());
			int a = temp.toLowerCase().charAt(0);
			b[index++] = (a - 96) % 2 == 0 ? false : true;
		}
		return b;
	}

	boolean validatePhoneNumber(String str) {

		if (str.startsWith("1") || str.startsWith("+1")) {
			String temp = str.replaceAll("[^0-9]", "");
			if (temp.length() != 11)
				return false;
			if (str.matches("[0-9]-[0-9][0-9][0-9]-[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]")
					|| str.matches(
							"[0-9] " + "\\(" + "[0-9][0-9][0-9]" + "\\) " + "[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]")
					|| str.matches("[0-9]\\.[0-9][0-9][0-9]\\.[0-9][0-9][0-9]\\.[0-9][0-9][0-9][0-9]")
					|| str.matches("[0-9] [0-9][0-9][0-9] [0-9][0-9][0-9] [0-9][0-9][0-9][0-9]")
					|| str.matches("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]")
					|| str.matches("[0-9]/[0-9][0-9][0-9]/[0-9][0-9][0-9]/[0-9][0-9][0-9][0-9]")) {
				return true;
			}
		}
		if (!str.startsWith("1") || !str.startsWith("+1")) {
			String temp = str.replaceAll("[^0-9]", "");
			if (temp.length() != 10)
				return false;
			if (str.matches("[0-9][0-9][0-9]-[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]")
					|| str.matches("\\(" + "[0-9][0-9][0-9]" + "\\)" + " [0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]")
					|| str.matches("[0-9][0-9][0-9]\\.[0-9][0-9][0-9]\\.[0-9][0-9][0-9][0-9]")
					|| str.matches("[0-9][0-9][0-9] [0-9][0-9][0-9] [0-9][0-9][0-9][0-9]")
					|| str.matches("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]")
					|| str.matches("[0-9][0-9][0-9]/[0-9][0-9][0-9]/[0-9][0-9][0-9][0-9]")) {
				return true;
			}
		}
		return false;

	}

	boolean[] validateSwaps(String[] arr, String str) {
		boolean[] isValid = new boolean[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (arr[1].equals(str)) {
				isValid[i] = true;
				continue;
			}
			String temp = arr[i];
			int c = 0;
			for (int j = 0; c < 2; j++) {
				if (arr[i].charAt(j) != str.charAt(j)) {
					temp = doubleSwap(temp, arr[i].charAt(j), str.charAt(j));
					if (temp.equals(str))
						break;
					c++;
				}
				System.out.println(j + " " + temp);
				if (j == arr[i].length() - 1)
					break;

			}

			if (temp.equals(str))
				isValid[i] = true;
			else
				isValid[i] = false;
		}
		return isValid;
	}

//	List<Fruit> splitBunches(List<Fruit> bunches) {
//		List<Fruit> result = new LinkedList<>();
//		for (Fruit f : bunches) {
//			int n = f.getQuantity();
//			if (n > 1) {
//				int c = 1;
//				for (int i = 1; i <= n; i++) {
//					result.add(new Fruit(f.getName(), c));
//				}
//			} else
//				result.add(f);
//		}
//		return result;
//
//	}
	// class Fruit {
//	private String name;
//	private int quantity;
//
//	public Fruit(String name, int quantity) {
//		this.name = name;
//		this.quantity = quantity;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}
//
//	public String getName() {
//		return this.name;
//	}
//
//	public int getQuantity() {
//		return this.quantity;
//	}
//
//	public String toString() {
//		return String.format("{name: %s, quantity: %d}", this.name, this.quantity);
//	}
//}

	String edabitInString(String s) {
		s = s.toLowerCase();
		List<String> list = new ArrayList<>();
		int j = 0;
		String sample = "edabit";
		for (int i = 0; i < s.length(); i++) {
			if (Character.toString(s.charAt(i)).matches("[edabit]") && !list.contains(Character.toString(s.charAt(i)))
					&& s.charAt(i) == sample.charAt(j)) {
				list.add(s.charAt(i) + "");
				j++;
			}
		}
		String res = String.join("", list.toArray(new String[list.size()]));
		System.out.println(res);
		return res.equals("edabit") ? "YES" : "NO";
	}

	String toStarShorthand(String str) {
		if (str.length() == 0)
			return "";
		List<Integer> list = new LinkedList<>();
		list.add(1);
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == str.charAt(i - 1)) {
				list.set(list.size() - 1, list.get(list.size() - 1) + 1);
				continue;
			}
			list.add(1);
		}
		System.out.println(list.size());
		String result = "";
		String temp = "";
		int j = 0;
		for (int i = 0; i < str.length(); i++) {
			if (!temp.contains(str.charAt(i) + "")) {
				if (list.get(j) != 1)
					result = result + str.charAt(i) + "*" + list.get(j);
				else
					result = result + str.charAt(i);
				j++;
				temp = temp + str.charAt(i);
			}
		}
		return result;
	}

	int minSwaps(String str) {
		int c = 0;
		int len = str.length();
		for (int i = 0; i < len; i++) {
			if (i % 2 == 0 && str.charAt(i) == '1') {
				c++;
			}
			if (i % 2 != 0 && str.charAt(i) == '0') {
				c++;
			}
		}
		return Math.min(c, len - c) / 2;
	}

	String kixCode(String addr) {
		String[] s = addr.split(",");
		String[] s2 = s[2].trim().split(" ");
		String[] s1 = s[1].trim().split(" ");
		String temp = "";
		for (int i = 0; i < s1[1].length(); i++) {

			char a = s1[1].charAt(i);
			if (!String.valueOf(a).matches("[0-9a-zA-Z]")) {
				temp = temp + "X";
				continue;
			}
			if (Character.isAlphabetic(a)) {
				temp = temp + Character.toUpperCase(a);
				continue;
			}
			temp = temp + a;

		}
		return s2[0] + s2[1].substring(0, 2) + temp;
	}

	boolean isValidIP(String str) {

		if (str.matches("[0-9]+\\.[0-9]+\\.[0-9]+\\.[0-9]+")) {
//			System.out.println("first if");
			String[] s = str.split("\\.");
			int c = 0;
			for (int i = 0; i < s.length; i++) {
				if (s[i].length() > 1 && s[i].matches("0.*")) {
					System.out.println("here");
					return false;
				}
				System.out.println(s[i]);
				if (Integer.parseInt(s[i]) >= 0 && Integer.parseInt(s[i]) <= 255) {
					c++;
				}
			}
			System.out.println("c" + c);
			if (c == 4) {
				return true;
			} else
				return false;
		}
		return false;

	}

	String abacabaPattern(int n) {
		if (n == 1)
			return "A";
		String result = "A";
		final int ascii = 64;
//		String first = "A";
		for (int i = 2; i <= n; i++) {
			result = result + (char) (ascii + i) + result;
		}
		return result;

	}

	String fiboWord(int n) {
		if (n < 2)
			return "invalid";

		String[] s = new String[n];
		s[0] = "b";
		s[1] = "a";
		for (int i = 2; i < n; i++) {
			s[i] = s[i - 1] + s[i - 2];
		}
		return String.join(", ", s);
	}

	String pluralizeWord(String s) {
		if (s.endsWith("s") || s.endsWith("ss") || s.endsWith("z") || s.endsWith("ch") || s.endsWith("sh")
				|| s.endsWith("x")) {
			s = s + "es";
		} else
			s = s + "s";
		return s;
	}

	String[] pluralizeWordsArray(String[] s) {
		LinkedHashSet<String> set = new LinkedHashSet();
		for (int i = 0; i < s.length; i++) {
			int c = 0;
			for (int j = i + 1; j < s.length; j++) {
				if (s[i].equals(s[j])) {
					c++;
					break;
				}
			}
			if (Arrays.asList(s).indexOf(s[i]) == i) {
				if (c > 0)
					set.add(pluralizeWord(s[i]));
				else
					set.add(s[i]);
			}
		}
		return set.toArray(new String[set.size()]);
	}

	String findLongest(String sentence) {
		String[] str = sentence.split(" ");
		String result = "";
		int c = 0;
		for (int i = 0; i < str.length; i++) {
			str[i] = str[i].replaceAll("[^a-zA-Z].'*", "");
			if (str[i].length() > c) {
				result = str[i];
				c = str[i].length();
			}
		}
		return result.toLowerCase();
	}

	// 111221 = 312211
	String lookAndSay(String term) {
		String result = "";
		for (int i = 0; i < term.length(); i++) {
			if (i == term.length() - 1 || term.charAt(i) != term.charAt(i + 1)) {
				result = result + "1" + term.charAt(i) + "";
				continue;
			}
			if (term.charAt(i) == term.charAt(i + 1)) {
				if ((i + 2) < term.length() && term.charAt(i) == term.charAt(i + 2)) {
					result = result + "3" + term.charAt(i) + "";
					i = i + 2;
					continue;
				}
				result = result + "2" + term.charAt(i) + "";
				i = i + 1;
				continue;
			}
		}

		return result;
	}

	boolean isIcecreamSandwich(String str) {
		if (str.length() == 0)
			return false;
		HashSet<Character> set = new HashSet(Arrays.asList(str.split("")));
		String start = str.charAt(0) + "";
		for (int i = 1; i < str.length(); i++) {
			if (!start.contains(str.charAt(i) + ""))
				break;
			start += str.charAt(i);
		}
		if (set.size() > 2 || start.equals(str) || !str.endsWith(start))
			return false;
		return true;
	}

	boolean commentsCorrect(String str) {
		int c = 0;
		char last = ' ';
		for (int i = 0; i < str.length(); i++) {
			char a = str.charAt(i);
			if ((a == '/' && last == '/' && c != 0) || (a == '*' && last == '*') || (a == '/' && last == '*' && c == 1))
				c--;
			else
				c++;
			System.out.println(c);
			last = a;
		}
		return c == 0;
	}

	String elasticize(String word) {
		int mid = word.length() / 2;
		if (word.length() % 2 != 0)
			mid = mid + 1;
		String right = "";
		String left = "";
		for (int i = 1, j = word.length() - 1; i <= mid; i++, j--) {

			left = left + String.valueOf(word.charAt(i - 1)).repeat(i);
			System.out.println("left: " + left);
			if (j + 1 != i)
				right = right + String.valueOf(word.charAt(j)).repeat(i);
			System.out.println("right:" + right);
		}
		return left + new StringBuilder(right).reverse().toString();
	}

	String truncate(String str, int length) {
		if (length >= str.length())
			return str;
		String[] s = str.split(" ");
		String res = "";
		int j = 0;
		for (int i = 0; i <= length; i++) {
			if (str.charAt(i) == ' ') {
				res = res + " " + s[j];
				j++;
			}
		}
		return res.trim();
	}

	boolean anaStrStr(String s1, String s2) {
		for (int i = 0; i < s2.length() - 1; i++) {
			int counter = 0;
			if (s2.matches(".*[" + s1 + "].*")) {
				for (int j = 0; j < s1.length(); j++) {
					if (i + j >= s2.length())
						break;
					System.out.println(counter);
					if (s1.contains(s2.charAt(i + j) + ""))
						counter++;
					else
						break;
				}
				System.out.println(counter);
				if (counter == s1.length())
					return true;
			}
		}
		return false;
	}

	String spoonerise(String phrase) {
		String[] p = phrase.split(" ");
		String result = "";
		String left = "";
		String right = "";
		for (int i = 0; i < p[0].length(); i++) {
			if ((p[0].charAt(i) + "").matches("[aeiouAEIOU]"))
				break;
			left = left + p[0].charAt(i);
		}
		for (int i = 0; i < p[1].length(); i++) {
			if ((p[1].charAt(i) + "").matches("[aeiouAEIOU]"))
				break;
			right = right + p[1].charAt(i);
		}
		result = right + p[0].substring(left.length()) + " " + left + p[1].substring(right.length());
		return result;
	}

	boolean isBalanced(String xp) {
		if (xp.length() == 0)
			return true;
		String temp = xp.replaceAll("[\\(\\)\\[\\]\\{\\}\\<\\>]", "");
		if (temp.length() == xp.length())
			return true;

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < xp.length(); i++) {
			char ch = xp.charAt(i);
			if (ch == '<' || ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			}
			if (ch == '>' || ch == ')' || ch == '}' || ch == ']') {
				if (stack.isEmpty())
					return false;
				char last = stack.lastElement();
				System.out.println("last:" + last);
				int a = (int) ch - (int) last;
				if (a > 2)
					return false;
				stack.pop();
			}
		}
		return stack.isEmpty();
	}

	boolean bracketLogic(String xp) {
		if (xp.length() == 0)
			return true;
		String temp = xp.replaceAll("[\\(\\)\\[\\]\\{\\}\\<\\>]", "");
		if (temp.length() == xp.length())
			return true;

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < xp.length(); i++) {
			char ch = xp.charAt(i);
			if (ch == '<' || ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			}
			if (ch == '>' || ch == ')' || ch == '}' || ch == ']') {
				if (stack.isEmpty())
					return false;
				char last = stack.lastElement();
				System.out.println("last:" + last);
				int a = (int) ch - (int) last;
				if (a > 2)
					return false;
				stack.pop();
			}
		}
		return stack.isEmpty();
	}

	int row(String str) {
		if (str.length() == 1)
			return (int) str.charAt(0) - 64;
//		return (str.length()-1)*26 + (int)str.charAt(0)-64;
		int sum = 0;
		for (int i = 0, j = str.length(); i < str.length() - 1; i++, j--) {
			sum = (int) (sum + Math.pow(26, j - 1) * ((int) str.charAt(i) - 64));
		}
		return sum + (int) str.charAt(str.length() - 1) - 64;
	}

	String invert(String s) {
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			char a = Character.isLowerCase(s.charAt(i)) ? Character.toUpperCase(s.charAt(i))
					: Character.toLowerCase(s.charAt(i));
			res = res + a;
		}
		return new StringBuilder(res).reverse().toString();
	}

	String afterPotion(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			if (i == str.length() - 1 && Character.isAlphabetic(str.charAt(i))) {
				break;
			}
			if (i == str.length() - 1 && Character.isDigit(str.charAt(i))) {
				result = result + str.charAt(i);
				break;
			}
			if (Character.isAlphabetic(str.charAt(i))) {
				continue;
			}
			if (Character.isDigit(str.charAt(i)) && Character.isAlphabetic(str.charAt(i + 1))) {
				if (str.charAt(i + 1) == 'A') {
					int b = Integer.parseInt(str.charAt(i) + "");
					result = result + (b + 1);
					continue;
				}
				if (str.charAt(i + 1) == 'B') {
					int b = Integer.parseInt(str.charAt(i) + "");
					result = result + (b - 1);
					continue;
				}
			}
			result = result + str.charAt(i);
		}
		return result;
	}

	int countWeightofWord(String word) {

		int sum = 0;
		word = word.toLowerCase();
		for (int i = 0; i < word.length(); i++) {
			sum = sum + ((int) word.charAt(i) - 96);
		}
		return sum;
	}

	String word_rank(String str) {

		String[] s = str.replaceAll("[^a-zA-Z ]", "").split(" ");
		int max = 0;
		int index = 0;
		for (int i = 0; i < s.length; i++) {

			int wow = countWeightofWord(s[i]);
			if (wow > max) {
				max = wow;
				index = i;
			}
		}
		return s[index];

	}

	String replace_nth(String txt, int nth, String old_char, String new_char) {
		if (nth == 0 || nth > txt.length())
			return txt;

		String result = "";
		int counter = 0;
		for (int i = 0; i < txt.length(); i++) {
			if (String.valueOf(txt.charAt(i)).equals(old_char))
				counter++;
			if (counter - nth == 0) {
				result = result + new_char;
				counter = 0;
				continue;
			}
			result = result + txt.charAt(i);
		}
		return result;
	}

	boolean instrumentRange(String instr, String note) {
//		Piccolo	D4-C7
//		Tuba	D1-F4
//		Guitar	E3-E6
//		Piano	A0-C8
//		Violin	G3-A7
		instr = instr.toLowerCase();
		int subNote = Integer.parseInt(note.substring(1));
		System.out.println(subNote);
		if (instr.equalsIgnoreCase("piccolo") && (subNote >= 4 && subNote <= 7))
			return true;
		if (instr.equalsIgnoreCase("Tuba") && (subNote >= 1 && subNote <= 4))
			return true;
		if (instr.equalsIgnoreCase("Guitar") && (subNote >= 3 && subNote <= 6))
			return true;
		if (instr.equalsIgnoreCase("Piano") && (subNote >= 0 && subNote <= 8))
			return true;
		if (instr.equalsIgnoreCase("Violin") && (subNote >= 3 && subNote <= 7))
			return true;
		return false;
	}

	boolean canBuildNew(String s1, String s2) {
		s2 = s2.replaceAll(" ", "");
		s1 = s1.replaceAll(" ", "");
		List<String> list = new LinkedList<>();
		for (int i = 0; i < s2.length(); i++) {
			list.add(String.valueOf(s2.charAt(i)));
		}

		for (int i = 0; i < s1.length(); i++) {
			String charA = String.valueOf(s1.charAt(i));
			if (list.contains(charA)) {
				int index = list.indexOf(charA);
				list.remove(index);
				continue;
			} else
				return false;
		}
		return true;
	}

	boolean overlap(String str1, String str2) {
		String bigger = "";
		String smaller = "";
		if (str1.length() >= str2.length()) {
			bigger = str1.toLowerCase();
			smaller = str2.toLowerCase();
		} else {
			bigger = str2.toLowerCase();
			smaller = str1.toLowerCase();
		}
		String star = "*".repeat(smaller.length());
		String temp = bigger.substring(bigger.length() - smaller.length());
		String resBigger = "";
		String resSmaller = "";
		for (int i = 0; i < smaller.length(); i++) {
			if (temp.charAt(i) == '*') {
				resBigger = resBigger + smaller.charAt(i);
				continue;
			}
			resBigger = resBigger + temp.charAt(i);
		}
		for (int i = 0; i < smaller.length(); i++) {
			if (smaller.charAt(i) == '*') {
				resSmaller = resSmaller + temp.charAt(i);
				continue;
			}
			resSmaller = resSmaller + smaller.charAt(i);
		}

		String finalBigger = bigger.substring(0, bigger.length() - smaller.length()) + resBigger;
		String finalSmaller = resSmaller;
		System.out.println(finalBigger + " " + resSmaller);

		return finalBigger.endsWith(finalSmaller) || finalBigger.endsWith(finalSmaller);
	}

	boolean plusSign(String str) {
		if (Character.isAlphabetic(str.charAt(0)) || Character.isAlphabetic(str.charAt(str.length() - 1)))
			return false;
		for (int i = 1; i < str.length() - 1; i++) {
			if (Character.isAlphabetic(str.charAt(i)) && (str.charAt(i - 1) != '+' || str.charAt(i + 1) != '+')) {
				return false;
			}
		}
		return true;
	}

	boolean doesRhyme(String str1, String str2) {
		str1 = str1.toLowerCase().replaceAll("[^a-z0-9]", "");
		str2 = str2.toLowerCase().replaceAll("[^a-z0-9]", "");
		return str2.endsWith(str1.substring(str1.length() - 2));
	}

	int countLoneOnes(long n) {
		String s = Long.toString(n);
		int counter = 0;
		if (s.length() == 1 && s.charAt(0) == '1')
			return 1;
		if (s.charAt(0) == '1' && s.charAt(1) != '1')
			counter++;
		if (s.charAt(s.length() - 1) == '1' && s.charAt(s.length() - 2) != '1')
			counter++;
		for (int i = 1; i < s.length() - 1; i++) {
			if (s.charAt(i) == '1' && s.charAt(i - 1) != '1' && s.charAt(i + 1) != '1') {
				counter++;
			}
		}
		return counter;
	}

	String reverseNotNumbers(String str) {
		String result = "";
		String noDigit = new StringBuilder(str.replaceAll("[0-9]", "")).reverse().toString();
		int j = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				result = result + str.charAt(i);
				continue;
			}
			result = result + noDigit.charAt(j);
			j++;
		}
		return result;
	}

	String[] threeLetterCollection(String s) {

		if (s.length() < 3)
			return new String[] {};
		List<String> list = new ArrayList<>();
		for (int i = 0; i < s.length() - 2; i++) {
			list.add(s.substring(i, i + 3));
		}
		Collections.sort(list);
		return list.toArray(new String[list.size()]);
	}

	String mangle(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (String.valueOf(c).matches("[^a-zA-z]")) {
				result = result + c;
				continue;
			}
			int nextAlpha = (int) c + 1;
			String a = String.valueOf((char) nextAlpha);
			if (a.matches("[aeiouAEIOU]")) {
				a = a.toUpperCase();
			}
			result = result + a;
		}
		return result;
	}

	String removeLastVowel(String str) {

		String[] words = str.split(" ");
		String sen = "";
		for (int i = 0; i < words.length; i++) {
			String res = "";
			for (int j = 0; j < words[i].length(); j++) {
				String ch = String.valueOf(words[i].charAt(j));
				if (ch.matches("[aeiouAEIOU]")) {
					if (!(words[i].substring(j + 1)).matches(".*[aeiouAEIOU].*|[aeiouAEIOU].*|.*[aeiouAEIOU]")) {
						continue;
					}
				}
				res = res + ch;
			}
			sen = sen + " " + res.trim();
		}
		return sen.trim();
	}

	String commonLastVowel(String str) {
		String[] words = str.toLowerCase().split(" ");
		String lv = "";
		for (int i = 0; i < words.length; i++) {
			if (Character.toString(words[i].charAt(words[i].length() - 1)).matches("[aeiou]")) {
				lv = lv + String.valueOf(words[i].charAt(words[i].length() - 1));
				continue;
			}

			for (int j = 0; j < words[i].length(); j++) {
				if (String.valueOf(words[i].charAt(j)).matches("[aeiou]")) {
					if (!words[i].substring(j + 1, words[i].length() - 1).matches("[aeiou]")) {
						lv = lv + words[i].charAt(j);
						break;

					}
				}
			}
		}
		String[] vowels = { "a", "e", "i", "o", "u" };
		String result = "";
		int n = 0;
		for (int i = 0; i < vowels.length; i++) {
			if (!lv.contains(vowels[i]))
				continue;
			int num = 0;
			num = lv.length() - lv.replaceAll(vowels[i], "").length();
			if (num > n) {
				n = num;
				System.out.println(vowels[i] + " " + num);
				result = vowels[i];
				System.out.println(result + " " + n);
			}
		}
		System.out.println(lv);
		System.out.println(n + " " + result);
		return result;
	}

	boolean isModest(int num) {
		String n = Integer.toString(num);

		for (int i = 0; i < n.length() - 1; i++) {
			int j = i + 1;
			int left = Integer.parseInt(n.substring(0, j));
			int right = Integer.parseInt(removeLeadingTrailing(n.substring(j)));
			System.out.println(left + " " + right);
			System.out.println(i + " " + j);
			if (num % right == left)
				return true;

		}
		return false;
	}

	String removeLeadingTrailing(String n) {
		if (n.length() == 2 && !n.endsWith("0"))
			return n.replace("0", "");
		if (!n.contains("."))
			return n.replaceFirst("^0*", "");
		if (n.contains(".")) {
			String[] a = n.split("\\.");
			System.out.println(Arrays.toString(a));
			if (Integer.parseInt(a[1]) == 0)
				return Integer.valueOf(a[0]).toString();
		}
		String ans = Double.valueOf(n).toString();
		return ans;
	}

	// "1 < 2 < 6 < 9 > 3"
	boolean correctSigns(String str) {

		String[] s = str.split(" ");
		for (int i = 0; i < s.length - 2; i = i + 2) {
			if (s[i + 1].equals(">") && !(Integer.parseInt(s[i]) > Integer.parseInt(s[i + 2])))
				return false;
			if (s[i + 1].equals("<") && !(Integer.parseInt(s[i]) < Integer.parseInt(s[i + 2])))
				return false;
		}
		return true;
	}

	String pyramid(int height) {
		String tLeft = "////";
		String tright = "\\\\\\\\";
		String base = "********";
		String result = "";
		for (int i = 0, j = height - 1; i < height; i++, j--) {

			result = result + tLeft.repeat(j) + base.repeat(i) + tright.repeat(j) + "\n";

//			System.out.println(result);

		}
		return result;
	}

	boolean isParselTongue(String sentence) {
		sentence = sentence.toLowerCase();
		String[] str = sentence.split(" ");
		for (String s : str) {
			if (s.contains("s") && !s.contains("ss"))
				return false;
			else
				continue;
		}
		return true;
	}

	boolean isDisarium(int n) {
		String str = new StringBuilder(Integer.toString(n)).reverse().toString();
		int num = Integer.parseInt(str);
		int res = 0;
		int i = 1;
		while (num > 0) {
			res = (int) (res + Math.pow(num % 10, i));
			num = num / 10;
			i++;
		}
		return res == n;
	}

	String toCamelCaseNew(String str) {

		String[] strs = str.split("_");
		String res = strs[0];
		for (int i = 1; i < strs.length; i++) {
			res = res + strs[i].substring(0, 1).toUpperCase() + strs[i].substring(1);
		}
		return res;
	}

	String toSnakeCase(String str) {
		String res = str.charAt(0) + "";
		for (int i = 1; i < str.length(); i++) {

			if (Character.isUpperCase(str.charAt(i)))
				res = res + "_" + Character.toString(str.charAt(i)).toLowerCase();
			else
				res = res + str.charAt(i);
		}
		return res;
	}

	String sigilize(String desire) {

		desire = desire.replaceAll("[aeiouAEIOU ]", "");
		for (int i = 0; i < desire.length(); i++) {
			String a = Character.toString(desire.charAt(i));
			if (a.matches("[a-zA-Z]")) {

				if (desire.indexOf(a.charAt(0)) != desire.lastIndexOf(a.charAt(0))) {
					System.out.println(desire.indexOf(a.charAt(0)) + " " + a + " " + desire.lastIndexOf(a.charAt(0)));
					desire = desire.replaceAll(a, "");
				}
			}
		}

		return desire.toUpperCase();
	}

	int firstIndex(String hex, String needle) {

		String result = "";
		String[] str = hex.split(" ");
		for (int i = 0; i < str.length; i++) {
			int j = Integer.parseInt(str[i], 16);
			result = result + (char) j;
		}
		System.out.println(result);
		return result.indexOf(needle);
	}

	boolean canBuild(String str1, String str2) {
//		List<String> list = Arrays.asList(str1.split(""));
		List<String> list = new ArrayList<>();
		for (int i = 0; i < str1.length(); i++) {
			list.add(String.valueOf(str1.charAt(i)));
		}
		for (int i = 0; i < str2.length(); i++) {
			System.out.println(list);
			int index = list.indexOf(String.valueOf(str2.charAt(i)));
			System.out.println(index);
			if (index == -1)
				return false;
			if (index != -1)
				list.remove(index);
		}
		return true;
	}

	String swapTwo(String str) {

		String result = "";
		int len = str.length();
		int rem = len % 4;
		if (rem != 0)
			len = len - rem;
		for (int i = 0; i < len; i = i + 4) {
			result = result + str.substring(i + 2, i + 4) + str.substring(i, i + 2);
		}
		return result + str.substring(len);
	}

	String sortString(String str) {
		String[] s = str.toLowerCase().split("");
		Arrays.sort(s);
		return String.join("", s);
	}

	boolean isAlphabeticallySorted(String sentence) {
		String[] s = sentence.split(" ");
		for (int i = 0; i < s.length; i++) {
			if (s[i].length() <= 2)
				continue;
//			System.out.println(s[i]+" "+sortString(s[i]));
			String temp = s[i].replaceAll("[^a-zA-Z0-9]", "");
			if (temp.equalsIgnoreCase(sortString(temp)))
				return true;
		}
		return false;
	}

	String removeWord(String sentence, String word) {

		return sentence.replaceAll(" " + word, "");
	}

	String noYelling(String phrase) {
		if (!(phrase.endsWith("!") || phrase.endsWith("?")))
			return phrase;
		String[] str = phrase.split(" ");
		String mark = str[str.length - 1].replaceAll("[a-zA-Z]", "");

		if (mark.length() == 1)
			return phrase;

		int len = str[str.length - 1].length() - mark.length();
		str[str.length - 1] = mark.contains("?") ? str[str.length - 1].substring(0, len) + "?"
				: str[str.length - 1].substring(0, len) + "!";
		return String.join(" ", str);
	}

	boolean isPositiveDominant(int[] n) {

		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < n.length; i++) {
			set.add(n[i]);
		}
		int num = (int) set.stream().filter(i -> i > 0).count();
		int neg = (int) set.stream().filter(i -> i < 0).count();

		return num > neg;
	}

	String selectLetters(String s1, String s2) {
		int len = s1.length() < s2.length() ? s1.length() : s2.length();
		String result = "";
		for (int i = 0; i < len; i++) {
			char c = s2.charAt(i);
			if (Character.isUpperCase(c) && Character.toString(c).matches("[a-zA-z]")) {
				result = result + s1.charAt(i);
			}
		}
		for (int i = 0; i < len; i++) {
			char c = s1.charAt(i);
			if (Character.isUpperCase(c) && Character.toString(c).matches("[a-zA-z]")) {
				result = result + s2.charAt(i);
			}
		}
		return result;
	}

	String missingLetter(String[] arr) {

		String str = String.join("", arr);
		String result = missingLetter(str);
		return result;
	}

	boolean almostPalindrome(String str) {

		StringBuilder sb = new StringBuilder(str);
		String reverse = sb.reverse().toString();
		if (str.equals(reverse))
			return false;
		int len = str.length();
		int middle = len / 2;
		String s = str.substring(0, middle);
		StringBuilder sb1 = new StringBuilder(s);

		String palin = len % 2 == 0 ? s + sb1.reverse().toString() : s + str.charAt(middle) + sb1.reverse().toString();
		System.out.println(palin);
		int counter = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != palin.charAt(i))
				counter++;
		}
		return counter == 1;

	}

	String xPronounce(String sentence) {

		String result = "";
		String[] str = sentence.split(" ");
		for (int i = 0; i < str.length; i++) {
			String word = str[i];
			if (word.length() == 1 && word.equals("x"))
				result = result + " " + word.replace("x", "ecks");
			else if (word.startsWith("x"))
				result = result + " " + word.substring(0, 1).replaceAll("x", "z")
						+ word.substring(1).replaceAll("x", "cks");
			else if (word.contains("x"))
				result = result + " " + word.replaceAll("x", "cks");
			else
				result = result + " " + word;
		}
		return result.trim();
	}

	int duplicateCount(String str) {

		int counter = 0;
		List<String> list = Arrays.asList(str.split(""));
//		System.out.println(list);
		for (String s : list) {
			if (list.indexOf(s) != list.lastIndexOf(s)) {
				counter++;
				list = list.stream().filter(i -> !i.equals(s)).toList();
			}
		}
		return counter;
	}

	String textToNum(String phone) {

		return phone.replaceAll("[ABCabc]", "2").replaceAll("[DEFdef]", "3").replaceAll("[GHIghi]", "4")
				.replaceAll("[JKLjkl]", "5").replaceAll("[MNOmno]", "6").replaceAll("[PQRSpqrs]", "7")
				.replaceAll("[TUVtuv]", "8").replaceAll("[WXYZwxyz]", "9");

	}

	boolean balanced(String word) {
		int len = word.length();
		int middle = len / 2;
		String left = word.substring(0, middle);
		String right = len % 2 != 0 ? word.substring(middle + 1) : word.substring(middle);

		int leftsum = 0;
		int rightsum = 0;
		for (int i = 0; i < left.length(); i++) {
			leftsum = leftsum + left.charAt(i);
			rightsum = rightsum + right.charAt(i);
		}

		return leftsum == rightsum;

	}

	String reverseOdd(String str) {
		String[] str1 = str.split(" ");
		String result = "";
		for (int i = 0; i < str1.length; i++) {
			StringBuilder sb = new StringBuilder(str1[i]);
			if (str1[i].length() % 2 != 0)
				str1[i] = sb.reverse().toString();
			result = result + " " + str1[i];
		}
		return result.trim();
	}

	String unmix(String str) {
		String result = "";
		String temp = str;
		if (str.length() % 2 != 0)
			temp = temp.substring(0, str.length() - 1);
		for (int i = 0; i < temp.length(); i = i + 2) {
			result = result + temp.charAt(i + 1) + temp.charAt(i);
//			System.out.println(result);
		}
		if (str.length() % 2 != 0)
			result = result + str.charAt(str.length() - 1);
		return result;
	}

	String subStringforPalin(String str) {

		if (str.length() == 0)
			return "";
		String res = "";

		res = res + str.charAt(str.length() - 1) + subStringforPalin(str.substring(0, str.length() - 1));
		System.out.println(res);
		return res;
	}

	boolean isPalindromeRecursion(String wrd) {

		String result = "";
		result = result + subStringforPalin(wrd.substring(0, wrd.length()));
		System.out.println("in method : " + result);
		if (result.equals(wrd))
			return true;
		return false;

	}

	boolean validate(String pin) {
		if (pin.matches("\\d{6}|\\d{4}"))
			return true;
		return false;
	}

	String sevenBoom(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			if (Integer.toString(arr[i]).contains("7"))
				return "Boom!";
		}
		return "no 7 here";
	}

	String singleOccurrence(String s) {
		String temp = s.toLowerCase();
		char[] c = temp.toCharArray();
		int res = 0;
		for (int i = 0; i < c.length; i++) {
			if (temp.indexOf(c[i]) == temp.lastIndexOf(c[i])) {
				res = temp.indexOf(c[i]);
				break;
			}
		}
		return Character.toString(s.charAt(res));
	}

	String likeOrDislike(String[] arr) {
		int len = arr.length;
		if (len == 1)
			return arr[0];
		if (len == 0)
			return "nothing";
		if (arr[len - 1] == arr[len - 2])
			return "nothing";
		else
			return arr[len - 1];
	}

	String lengthen(String str1, String str2) {
		int str1len = str1.length();
		int str2len = str2.length();
		if (str1len < str2len) {
			String t = str1;
			str1 = str2;
			str2 = t;
		}
		int n = Math.abs(str1len - str2len);
		n = n > 0 ? n : 1;
		String temp = str2.repeat(n);
		temp = temp.length() > str1.length() ? temp : temp.repeat(2);
		System.out.println(temp + " " + temp.length());
		String result = "";
		for (int i = 0; i < str1.length(); i++) {
			result = result + temp.charAt(i);
		}
		return result;
	}

	boolean isStretched(String str1, String str2) {

		if (str1.length() % str2.length() != 0)
			return false;
		int n = str1.length() / str2.length();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str2.length(); i++) {

			for (int j = 0; j < n; j++) {
				sb.append(str2.charAt(i));
			}
		}
		return sb.toString().equals(str1);

//		 String result =str1;
//		 String result2 =str2;
//		 for(int i =0;i<str2.length();i++) {
//			 result = result.replaceAll(Character.toString(str2.charAt(i)), "");
//		 }
//		 for(int i =0;i<str1.length();i++) {
//			 result2 = result2.replaceAll(Character.toString(str1.charAt(i)), "");
//		 }
//		 if(result.length()!=0 || result2.length()!=0) return false;
//		 
//		 return flag;
	}

	String hoursPassed(String t1, String t2) {
		if (t1.equals(t2))
			return "no time has passed.";
		String[] st1 = t1.replace(" ", "").split(":");
		String[] st2 = t2.replace(" ", "").split(":");
		int result = 0;
		if (st2[1].contains("PM") && st1[1].contains("AM")) {
			result = Integer.parseInt(st2[0]) + 12 - Integer.parseInt(st1[0]);
		} else {
			result = Integer.parseInt(st2[0]) - Integer.parseInt(st1[0]);
		}
		return Integer.toString(result) + " hours passed.";
	}

	String absolute(String s) {
		String[] str = s.split(" ");
		String res = "";
		for (int i = 0; i < str.length; i++) {

			if (str[i].toLowerCase().equals("a") && i == 0) {
				res = res + " " + str[i].replaceAll("[aA]", "An absolute");
				continue;
			}
			if (str[i].toLowerCase().equals("a")) {
				res = res + " " + str[i].replaceAll("[aA]", "an absolute");
				continue;
			}
			res = res + " " + str[i];
		}
		return res.trim();
	}

	boolean noDuplicateLetters(String phrase) {
		String[] str = phrase.toLowerCase().split(" ");
		for (int i = 0; i < str.length; i++) {
			for (int j = 0; j < str[i].length() - 1; j++) {
//				System.out.println("here");
				String s = str[i].replaceAll(str[i].charAt(j) + "", "");
				if (str[i].length() - 1 != s.length())
					return false;
			}
		}
		return true;
	}

	String longestCommonEnding(String str1, String str2) {

		if (str2.length() > str1.length()) {
			String temp = str1;
			str1 = str2;
			str2 = temp;
		}
		String result = "";
		for (int i = 0; i < str2.length(); i++) {
			if (str1.toLowerCase().endsWith(str2.toLowerCase().substring(i))) {
				result = str2.substring(i);
				break;
			}
		}
		return result;
	}

	String flip(String str, String spec) {
		String[] s = str.split(" ");
		String result = "";
		if (spec.equalsIgnoreCase("word")) {
			for (int i = 0; i < s.length; i++) {
				StringBuilder sb = new StringBuilder(s[i]);
				result = result + " " + sb.reverse();
			}
		}
		if (spec.equalsIgnoreCase("sentence")) {
			for (int i = s.length - 1; i >= 0; i--) {
				result = result + " " + s[i];
			}
		}
		return result.trim();
	}

	boolean isKaprekar(int n) {
		String nsquare = Long.toString(n * n);

		int len = nsquare.length();
		long first = 0;
		long last = 0;
		if (len == 1)
			last = len;
		if (len > 1 && len % 2 != 0) {
			first = Integer.parseInt(nsquare.substring(0, Math.floorDiv(len, 2)));
			last = Integer.parseInt(nsquare.substring(len / 2));
			System.out.println(first + " " + last);
		}
		if (len > 1 && len % 2 == 0) {
			String leftSubstring = nsquare.substring(0, (len / 2));
			first = Integer.parseInt(leftSubstring);
			String substring = nsquare.substring((len / 2));
			last = Integer.parseInt(substring);
			System.out.println(first + " " + last);
		}

		return first + last == n;

	}

	String swapXY(String str) {

		String newStr = str.replaceAll("[() ]", "");
		String[] arr = newStr.split(",");

		return "(" + arr[1] + ", " + arr[0] + "), (" + arr[3] + ", " + arr[2] + ")";

	}

	int countPalindromes(int num1, int num2) {
		int count = 0;
		for (int i = num1; i <= num2; i++) {
			if (isPalindrome(Integer.toString(i)))
				count++;
		}
		return count;
	}

	int countAdverbs(String sentence) {

		String sen = sentence.replaceAll("[^a-zA-Z ]", "");
		int counter = 0;
		String[] str = sen.split(" ");
		for (int i = 0; i < str.length; i++) {
			if (str[i].endsWith("ly") && str[i].length() > 2)
				counter++;
		}

		return counter;
	}

	boolean firstBeforeSecond(String t, String f, String s) {

		int lastOfFirst = t.lastIndexOf(f);
		int firstOfLast = t.indexOf(s);

		return lastOfFirst < firstOfLast;

	}

	boolean bestFriend(String s, String a, String b) {
		if (s.length() < 3)
			return false;
		boolean isFriend = true;
		for (int i = 0; i < s.length() - 1; i++) {
			if (Character.toString(s.charAt(i)).equals(a) && !Character.toString(s.charAt(i + 1)).equals(b))
				return false;
		}
		return isFriend;
	}

	String insertWhitespace(String s) {

		String result = "";
		for (int i = 0; i < s.length(); i++) {
			if (Character.isUpperCase(s.charAt(i))) {
				result = result + " " + s.charAt(i);
				continue;
			}
			result = result + s.charAt(i);
		}
		return result.trim();
	}

	boolean palindromicDate(String date) {
		String[] dates = date.split("/");

		String ddMMyyyy = date.replaceAll("/", "");
		boolean bool1 = isPalindrome(ddMMyyyy);

		String MMddyyyy = dates[1] + dates[0] + dates[2];
		boolean bool2 = isPalindrome(MMddyyyy);
		return bool1 && bool2;

	}

	String doubleSwap(String str, char c1, char c2) {
		String result = str.replaceAll(Character.toString(c1), "_q_")
				.replaceAll(Character.toString(c2), Character.toString(c1)).replaceAll("_q_", Character.toString(c2));
		return result;
	}

	String censor(String str) {
		String[] arr = str.split(" ");
		String result = "";
		for (int i = 0; i < arr.length; i++) {
			String temp = arr[i];
			if (temp.length() > 4)
				temp = "*".repeat(temp.length());
			result = result + " " + temp;
		}

		return result.trim();
	}

	String returnTheEndOfNumber(int num) {
		int n = num % 10;
		int n1 = num % 100;
		String end = "";
		if (n1 > 20)
			end = n == 1 ? "-ST" : n == 2 ? "-ND" : n == 3 ? "-RD" : "-TH";
		if (n1 < 20)
			end = "-TH";
		return Integer.toString(num) + end;
	}

	int mysteryFunc(int num) {

		String result = "2";
		int val = 0;
		int counter = 0;
		for (int i = 1; val <= num; i++) {
			val = (int) Math.pow(2, i);
			counter++;
		}
		result = result.repeat(counter - 1) + Integer.toString(num - ((int) Math.pow(2, counter - 1)));

		return Integer.parseInt(result);
	}

	String longestZero(String str) {
		if (!str.contains("0"))
			return "";
		int counter = 1;
		int zeros = 0;
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == '0' && str.charAt(i) == str.charAt(i + 1))
				counter++;
			if (str.charAt(i) != '0')
				counter = 1;
			zeros = zeros > counter ? zeros : counter;
		}
		String repeat = "0".repeat(zeros);
		return repeat;
	}

	String wordedMath(String expr) {

		String convert = expr.toLowerCase().replaceAll("zero", "0").replaceAll("one", "1").replaceAll("two", "2");
		String[] str = convert.split(" ");
		int result = convert.contains("plus") ? Integer.parseInt(str[0]) + Integer.parseInt(str[2])
				: Integer.parseInt(str[0]) - Integer.parseInt(str[2]);
		return result == 0 ? "Zero" : result == 1 ? "One" : result == 2 ? "Two" : "Three";

//		HashMap<String, Integer> hm = new HashMap<>();
//		HashMap<Integer, String> hm1 = new HashMap<>();
//		hm.put("zero", 0);
//		hm.put("one", 1);
//		hm.put("two", 2);
//		hm.put("three", 3);
//
//		hm1.put(0, "Zero");
//		hm1.put(1, "One");
//		hm1.put(2, "Two");
//		hm1.put(3, "Three");
//
//		
//		String[] arr = expr.split(" ");
//		int result = arr[1].toLowerCase().equals("plus")? hm.get(arr[0].toLowerCase())+hm.get(arr[2].toLowerCase())
//					:hm.get(arr[0].toLowerCase())-hm.get(arr[2].toLowerCase());
//		System.out.println(result);
//		return hm1.get(result);

	}

	String wormLength(String worm) {

//		char[] w = worm.toCharArray();
//		int len = w.length;
//		if(len==0) return "invalid";
//		if(worm.matches("[^-]") return "invalid";
//		
//		return Integer.toString(len*10)+"mm.";

		char[] w = worm.toCharArray();
		int len = w.length;
		if (len == 0)
			return "invalid";
		for (int i = 0; i < len; i++) {
			if (w[i] != '-')
				return "invalid";
		}
		return Integer.toString(len * 10) + "mm.";
	}

	String wurstIsBetter(String s) {
		String[] replace = { "Kielbasa", "Chorizo", "Moronga", "Salami", "Sausage", "Andouille", "Naem", "Merguez",
				"Gurka", "Snorkers", "Pepperoni" };
		for (int i = 0; i < replace.length; i++) {
			if (s.toLowerCase().contains(replace[i].toLowerCase()))
				s = s.replaceAll(replace[i].toLowerCase(), "Wurst").replaceAll(replace[i], "Wurst");

		}
		return s;
	}
//		s.repla

	String whichIsLarger(int j, int k, Function<Integer, Integer> f, Function<Integer, Integer> g) {
		int fvalue = f.apply(j);
		int gvalue = g.apply(k);
		String result = fvalue > gvalue ? Integer.toString(fvalue)
				: fvalue < gvalue ? Integer.toString(gvalue) : "neither";
		return result;

	}

	boolean isAnagram(String s1, String s2) {
		s1 = s1.toLowerCase().replaceAll("[^a-z]", "");
		s2 = s2.toLowerCase().replaceAll("[^a-z]", "");
		if (s1.length() != s2.length())
			return false;
		for (int i = 0; i < s1.length(); i++) {
			if (!s2.contains(Character.toString(s1.charAt(i))))
				return false;
		}
		return true;
	}

	String alphabetIndex(String str) {
		str = str.toLowerCase();
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			if (Character.toString(str.charAt(i)).matches("[a-z]"))
				result = result + " " + (str.charAt(i) - 96);
		}
		return result.trim();
	}

	String karacaEncrypt(String word) {

		StringBuilder sb = new StringBuilder(word);

		String result = sb.reverse().toString().replaceAll("a", "0").replaceAll("e", "1").replaceAll("i", "2")
				.replaceAll("o", "3").replaceAll("u", "4") + "aca";
		return result;

	}

	String emphasize(String str) {

		String[] s = str.split(" ");
		List<String> list = Arrays.asList(s);
		list = list.stream()
				.map(value -> Character.toUpperCase(value.charAt(0)) + "" + value.substring(1).toLowerCase()).toList();
		String result = "";
		for (String st : list) {
			result = result + " " + st;
		}
		return result.trim();

	}

	String missingLetter(String str) {

		String missingLetters = "";
		int first = str.charAt(0);
		for (int i = 1; i < str.length(); i++) {
			first++;
			if (first != (int) str.charAt(i)) {
				missingLetters = missingLetters + (char) first;
				first++;
			}
		}
		if (missingLetters.length() == 0)
			return "no missing";
		return missingLetters;
	}

	String dashed(String s) {
//		char[] schars = s.toCharArray();
		String result = s.replaceAll("[aeiouAEIOU]", "-$0-");
//		for(int i =0; i<schars.length; i++) {
//			if(Character.toString(schars[i]).matches("[aeiouAEIOU]")) {
//				result = result+"-"+schars[i]+"-";
//				continue;
//			}
//			result = result+schars[i];
//		}
		return result;
	}

	boolean validateBinary(String bits) {
		int counter = 0;
		for (int i = 0; i < bits.length() - 1; i++) {
			if (bits.charAt(i) == '1')
				counter++;
		}
//		System.out.println(counter);
//		System.out.println(bits.charAt(bits.length()-1));
		boolean flag = (counter % 2 == 0 && bits.charAt(bits.length() - 1) == '0')
				|| (counter % 2 != 0 && bits.charAt(bits.length() - 1) == '1');
		return flag;
	}

	String uncensor(String str, String vowels) {

		StringBuilder sb = new StringBuilder();
		int index = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '*') {
				sb.append(vowels.charAt(index));
				index++;
				continue;
			}
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}

	String alternatingCaps(String s) {

		char[] arr = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		boolean uppercase = true;
		String result = "";
		for (int i = 0; i < arr.length; i++) {
			char ch = arr[i];
			if (arr[i] != ' ') {
				ch = uppercase ? Character.toUpperCase(arr[i]) : Character.toLowerCase(arr[i]);
				sb.append(ch);
				uppercase = !uppercase;
//				if(uppercase)	{
//					result = result+Character.toUpperCase(arr[i]);
//					uppercase=!uppercase;
//				}
//				else {
//					result = result+arr[i];
//					uppercase= !uppercase;
//				}
			} else
				sb.append(ch);
//			else result = result+arr[i];
		}
		return sb.toString();

//		String im = "";
//		String temp = "";
//
//		String[] str = s.split(" ");
//		int[] strLen = new int[str.length];
//		for (int i = 0; i < str.length; i++) {
//			strLen[i] = str[i].length();
//			temp = temp + str[i];
//		}
//		for (int i = 0; i < temp.length(); i++) {
//			String a = i % 2 == 0 ? Character.toString(temp.charAt(i)).toUpperCase() : temp.charAt(i) + "";
//			im = im + a;
//		}
//		String result = im.substring(0, strLen[0]);
//		System.out.println(im);
//		int pre = strLen[0];
//		for (int i = 0; i < str.length - 1; i++) {
//			int post = pre + strLen[i + 1];
//			result = result + " " + im.substring(pre, post);
//			pre = post;
//		}
//		return result;

	}

	boolean isSmooth(String sentence) {
		if (sentence.length() == 0)
			return false;
		String[] str = sentence.split(" ");
		boolean isSmooth = true;
		for (int i = 0; i < str.length - 1; i++) {
			char last = str[i].charAt(str[i].length() - 1);
			char first = str[i + 1].charAt(0);
			if (last != first)
				return false;
		}
		return isSmooth;
	}

	String toCamelCase(String str) {
		if (str.length() == 0)
			return "";
		String[] strArr = str.split("[-_]");
		String result = strArr[0];
		for (int i = 1; i < strArr.length; i++) {
			result = result + Character.toString(strArr[i].charAt(0)).toUpperCase() + strArr[i].substring(1);
		}
		return result;
	}

	String extendVowels(String w, int n) {

		String result = "";
		for (int i = 0; i < w.length(); i++) {
			String temp = Character.toString(w.charAt(i)).matches("[aeiouAEIOU]")
					? Character.toString(w.charAt(i)).repeat(n + 1)
					: w.charAt(i) + "";
			result = result + temp;
		}
		return result;
	}

	int solveEquation(String equation) {
		// x + 6 = 12
		String[] str = equation.split(" ");
		return str[1].equals("+") ? Integer.parseInt("" + str[4]) - Integer.parseInt("" + str[2])
				: Integer.parseInt("" + str[4]) + Integer.parseInt("" + str[2]);
	}

	String replaceThe(String str) {
		String[] strArr = str.split(" ");
		String result = "";
		for (int i = 0; i < strArr.length; i++) {
			if (strArr[i].equals("the") && Character.toString(strArr[i + 1].charAt(0)).matches("[aeiou]")) {
				result = result + " " + strArr[i].replace("the", "an");
			} else if (strArr[i].equals("the")) {
				result = result + " " + strArr[i].replace("the", "a");
			} else
				result = result + " " + strArr[i];
		}
		return result;
	}

	String histogram(int[] arr, String chr) {
		String result = "";

		for (int i = 0; i < arr.length; i++) {
			result = result + chr.repeat(arr[i]) + "\n";
		}
		return result;
	}

	String decimator(String s) {
		int len = s.length();
		int decimated = Math.ceilDiv(len, 10);
		return s.substring(0, len - decimated);
	}

	String reverse5OrMore(String s) {
		String[] str = s.split(" ");
		String result = "";
		for (int i = 0; i < str.length; i++) {
			if (str[i].length() >= 5) {
				StringBuilder sb = new StringBuilder(str[i]);

				str[i] = sb.reverse().toString();
			}
			result = result + " " + str[i];
		}
		return result;
	}

	String accum(String str) {

		String result = Character.toUpperCase(str.charAt(0)) + "";
		for (int i = 1; i < str.length(); i++) {
			result = result + "-" + Character.toUpperCase(str.charAt(i)) + Character.toString(str.charAt(i)).repeat(i);
		}
		return result;
	}

	String capSpace(String txt) {

		char[] ch = txt.toCharArray();
		String result = "";

		for (int i = 0; i < ch.length; i++) {
			if (Character.isUpperCase(ch[i])) {
				result = result + " " + Character.toString(ch[i]).toLowerCase();
				continue;
			}

			result += ch[i];
		}
		return result;
	}

	int sumOfVowels(String str) {
		str = str.toLowerCase();
		str = str.replaceAll("[a]", "4");
		str = str.replaceAll("[e]", "3");
		str = str.replaceAll("[i]", "1");
		str = str.replaceAll("[\\D]", "");
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {

			sum = sum + Integer.parseInt(str.charAt(i) + "");
		}
		return sum;
	}

	boolean magic(String str) {
		String[] strArr = str.split(" ");
		int test = Integer.parseInt(strArr[0]) * Integer.parseInt(strArr[1]);

		return str.endsWith(Integer.toString(test));
	}

	int wordNest(String word, String nest) {
		int depth = -1;
		while (nest.length() > 0) {
			nest = nest.replace(word, "");
			depth++;
		}
		return depth;
	}

	String capLast(String str) {

		String[] words = str.split(" ");
		String result = "";
		for (int i = 0; i < words.length; i++) {

			words[i] = words[i].substring(0, words[i].length() - 1)
					+ words[i].substring(words[i].length() - 1).toUpperCase();
			result = result + " " + words[i];
		}
		return result.trim();

	}

	boolean isValidHexCode(String str) {
		if (str.length() == 7 && str.startsWith("#") && str.substring(1, str.length()).matches("[0-9a-fA-F]*")) {
			return true;
		}
		return false;
	}

	String firstNVowels(String str, int n) {

		String vow = "";
		int counter = 0;
		for (int i = 0; i < str.length(); i++) {
//			System.out.println("yo"+str.charAt(i));
			if (("" + str.charAt(i)).matches("[aeiouAEIOU]") && counter < n) {
				counter++;
				vow = vow + str.charAt(i);
			}
		}
//		System.out.println(vow+" "+counter);
		if (counter < n)
			return "invalid";
		return vow;
	}

	int findZip(String str) {
		String zip = "zip";
		return str.indexOf(zip, str.indexOf(zip) + 1);
	}

	boolean validateEmail(String s) {

		if (s.matches(".+@.+\\.com"))
			return true;
		return false;
//		if(s.length() <7) return false; 
//		
//		if(s.endsWith(".com")) {
//			if(s.contains("@")) {
//				if(s.indexOf("@")>0) {
//					if(s.substring(s.indexOf("@"), s.indexOf(".")).length() >1 ) return true;
//				}
//			}
//		}
//		return false;

	}

	String highLow(String s) {

		if (!s.contains(" "))
			return s + " " + s;
		String[] noSpaceStr = s.split(" ");
		int[] arr = new int[noSpaceStr.length];

		for (int i = 0; i < noSpaceStr.length; i++)
			arr[i] = Integer.parseInt(noSpaceStr[i]);
		Arrays.sort(arr);
		return arr[arr.length - 1] + " " + arr[0];
	}

	String reverseStrRec(String str) {
		int len = str.length();
		if (len == 0)
			return "invalid";
		if (len == 1)
			return str.charAt(0) + "";
		String result = "";
		result = result + str.charAt(len - 1) + reverseStrRec(str.substring(0, len - 1));

		return result;
	}

	String dnaToRna(String strand) {
		if (strand.length() == 0)
			return "invalid strand";
//		String result = "";
//		for(int i = 0; i<strand.length(); i++) {
//			String character = "";
//			char ch = strand.charAt(i);
//			if(ch == 'A') character = "U";
//			if(ch == 'T') character = "A";
//			if(ch == 'G') character = "C";
//			if(ch == 'C') character = "G";
//			result+=character;
//		}
		String result = strand.replace("A", "U").replace("T", "A").replace("G", "temp").replace("C", "G")
				.replace("temp", "C");
		return result;
	}

	String flipEndChars(String str) {
		if (str.length() < 2)
			return "incomatible";
		if (str.charAt(0) == str.charAt(str.length() - 1))
			return "same chars";
		return str.charAt(str.length() - 1) + str.substring(1, str.length() - 1) + str.charAt(0);
	}

	String addStrings(String a, String b) {

		if (a.length() == 0 || b.length() == 0)
			return null;
		if (a == null || b == null)
			return null;

		return Integer.toString(Integer.parseInt(a) + Integer.parseInt(b));
	}

	String rps(String str1, String str2) {
		if (str1.equals(str2))
			return "tie";
		if (str1.equalsIgnoreCase("rock") && str2.equalsIgnoreCase("paper"))
			return "player 2 wins";
		if (str1.equalsIgnoreCase("paper") && str2.equalsIgnoreCase("scissors"))
			return "player 2 wins";
		if (str1.equalsIgnoreCase("scissors") && str2.equalsIgnoreCase("rock"))
			return "player 2 wins";

		return "player 1 wins";
	}

	boolean isBetween(String first, String last, String word) {

		return word.compareToIgnoreCase(first) >= 0 && word.compareToIgnoreCase(last) <= 0;
	}

	int countVowelsRecursive(String str) {

		if (str.equals(""))
			return 0;
		int count = "aeiouAEIOU".contains("" + str.charAt(0)) ? 1 : 0;
		count = count + countVowelsRecursive(str.substring(1));
		return count;
	}

	boolean check2Strings(String[] strArr) {

		String str1 = strArr[0].toLowerCase();
		String str2 = strArr[1].toLowerCase();
		for (int i = 0; i < str1.length(); i++) {
			str2 = str2.replaceAll(str1.charAt(i) + "", "");
		}
		return str2.length() == 0;
	}

	String removeSpecialCharacters(String str) {

		return str.replaceAll("[^a-zA-z-_0-9 ]", "");
	}

	int countUniqueChars(String str1, String str2) {

		HashSet<Character> uniqueSet = new HashSet<>();
		String str = str1.concat(str2);
		int i = 0;
		while (i < str.length()) {
			uniqueSet.add(str.charAt(i));
			i++;
		}
		System.out.println(uniqueSet);
		return uniqueSet.size();
	}

	String lettersOnly(String str) {

		return str.replaceAll("[^a-zA-Z]", "");

	}

	boolean isIsogram(String str) {

		str = str.toLowerCase();
		char[] strChar = str.toCharArray();

		for (int i = 0; i < strChar.length - 1; i++) {

			for (int j = i + 1; j < strChar.length; j++) {

				if (strChar[i] == strChar[j])
					return false;

			}

		}

		return true;
	}

	String leftmostnum(String str) {

		String a = str.replaceAll("\\d+", "");
		System.out.println(a);
		return a;
//		return Integer.parseInt(a.substring(0,1));
//		String str1 = str.replaceAll("[0-9]", " ");
////		System.out.println(str);
//		String num = Character.toString(str.charAt(str1.indexOf(" ")));

//		char[] charArray = str.toCharArray();
//		Arrays.sort(charArray);
//		String str1 = new String(charArray);
//		System.out.println(str1);
//		return Integer.parseInt(num);
	}

	boolean validString(String str) {

		String a = Character.toString(str.charAt(0));
		return a.replaceAll("[a-zA-Z]", "").length() == 0;
	}

	String nameOfCity(String str) {

		return str.substring(str.lastIndexOf("[")).replaceAll("[\\[\\]]", "");

//		StringBuilder sb = new StringBuilder(str);
//		sb =sb.reverse();
//		StringBuilder sb1 = new StringBuilder(sb.substring(sb.indexOf("]")+1,sb.indexOf("[")));
//		return  sb1.reverse().toString();
	}

	String fakeBinary(String str) {
		str = str.toLowerCase();
		str = str.replaceAll("[a-m]", "0").replaceAll("[m-z]", "1");
		return str;
	}

	boolean isPalindrome(String str) {

		StringBuilder reversedStr = new StringBuilder(str);

		reversedStr.reverse();

		return reversedStr.toString().equals(str);

	}

	int firstVowel(String str) {
		String vowels = "aeiouAEIOU";
		str = str.replaceAll("[aeiouAEIOU]", " ");

		return str.indexOf(" ");
//		int i =0;
//		while(i<str.length()) {
////			if(vowels.contains( Character.toString(str.charAt(i)))) break;
//			if(vowels.contains( String.valueOf((str.charAt(i))))) break;
//			i++;
//		}
//		return i;
	}

	int timeToFinish(String fullStr, String halfStr) {

		int startPoint = halfStr.length();
		String remainingString = fullStr.substring(startPoint).trim();
		int counter = 0;
		for (int i = 0; i < remainingString.length(); i++) {

			if (remainingString.charAt(i) != ' ')
				counter++;

		}

		return counter / 2;
	}

	boolean canAlternate(String str) {

//		nt zeroes = (int) str.chars().filter(ch -> ch == '0').count(); 
//		int ones = (int) str.chars().filter(ch ->ch=='1').count();
		int zeroes = 0;
		int ones = 0;

		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) == '0')
				zeroes++;
			if (str.charAt(i) == '1')
				ones++;

		}

		if (ones == zeroes || ones == zeroes - 1 || zeroes == ones - 1)
			return true;

		return false;
	}

	boolean isStrangePair(String str1, String str2) {

		if (str1.equals(str2))
			return true;
		if (str1.subSequence(0, 1).equals(str2.subSequence(0, 1)) || str2.endsWith(str1.substring(0, 1))) {
			return true;
		}
		return false;
	}

	String[] firstLetterCapital(String[] str) {

		for (int i = 0; i < str.length; i++) {
			String string = str[i].toLowerCase();
			string = string.substring(0, 1).toUpperCase() + string.substring(1);
			str[i] = string;
			System.out.println(string);
		}

		return str;
	}

	int findNthSmallest(int[] arr, int checkIndex) {

		int len = arr.length;
		if (checkIndex > len || checkIndex <= 0)
			return -1;
		Arrays.sort(arr);
		return arr[checkIndex - 1];
	}

	boolean atmPinValidation(String str) {

		if (str.length() == 4 || str.length() == 6) {
			if (str.matches("[0-9]*"))
				return true;
		}
		return false;
	}

	boolean validateZipCode(String zipCode) {

		if (zipCode.length() == 5 && zipCode.matches("[0-9]+")) {
			return true;
		}
		return false;
	}

	String societyName(String[] strArr) {
		String[] star;
		ArrayList<String> strList = new ArrayList<String>();
		for (String str : strArr) {
			if (str.length() == 0)
				continue;
			strList.add(str.substring(0, 1));
		}

		Collections.sort(strList);

		String result = strList.toString().replaceAll("[\\[\\],\\s]", "").toUpperCase();

		return result;

	}

	String middleCharacter(String str) {
		int len = str.length();
		if (len == 0)
			return "empty string";
		if (len == 1 || len == 2)
			return str;
		int mid = len / 2;
		if (len % 2 == 0)
			return str.substring(mid - 1, mid + 1);
		return String.valueOf(str.charAt(mid));

	}

	String removeABC(String str) {
		if (str.length() == 0)
			return null;
		if (!(str.matches(".*[abcABC].*")))
			return null;
		return str.replaceAll("[abcABC]", "");
	}

	int spotLightSum(int n) {
		return n * 9;
	}

	String sortStringChars(String str) {

		char[] chArray = str.toCharArray();
		Arrays.sort(chArray);

		str = String.valueOf(chArray);
//		String strNew = new String(chArray);

//		 str = Arrays.toString(chArray);

		return str;
	}

	boolean isSpecialArray(int[] arr) {

		ArrayList<Integer> evenList = new ArrayList<Integer>();
		ArrayList<Integer> oddList = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] % 2 == 0) {
				evenList.add(arr[i]);
				continue;
			}
			oddList.add(arr[i]);
		}
		if (evenList.size() == arr.length || oddList.size() == arr.length)
			return true;
		return false;

	}

	String indexShuffle(String str) {

		char[] chArray = str.toCharArray();
		String evenStr = "" + chArray[0];
		String oddStr = "";
		for (int i = 1; i < chArray.length; i++) {

			if (i % 2 == 0)
				evenStr += chArray[i];
			else
				oddStr += chArray[i];
		}
		System.out.println(oddStr);
		return evenStr.concat(oddStr);
	}

	boolean isPreffix(String str, String prefix) {

		return str.startsWith(prefix.substring(0, prefix.indexOf('-')));
	}

	boolean isSuffix(String str, String suffix) {

		return str.endsWith(suffix.substring(1));
	}

	boolean matchLast(String[] str) {
//		String result = "";
		int len = str.length;
//		for(int i=0; i<len-1; i++) {
//			result = result.concat(str[i]);
////			System.out.println(result);
//		}
//		System.out.println("this : "+str[len-1]);
//		System.out.println (String.join(",", str[0],  str[len-1]));
//		return result.equals(str[len-1]);
		String joinedStr = String.join("", str);
		String result = joinedStr.replace(str[len - 1], "");
		System.out.println(result);
		return result.equals(str[len - 1]);

	}

	String charRepeat(String str, int n) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
//			result = result+String.valueOf(str.charAt(i)).repeat(n);
		}
		return result.replaceAll("\\s+", " ");
	}

	String addSpace(String str) {
//		String result = "";
//		for(int i = 0; i<str.length(); i++) {
//			
//			result = result+str.charAt(i)+" ";
//			}
//		
//		return result;

		return str.replaceAll("", " ").trim();
	}

	String joinPortions(String str1, String str2) {
		str1 = str1.endsWith("/") ? str1.replace("/", "") : str1;
		return str1 + "/" + str2;
	}

	boolean checkAvgIsInt(double[] arr) {

		int sum = 0;
		int length = arr.length;
		for (int i = 0; i < length; i++) {
			sum = (int) (sum + arr[i]);
		}
		double avg = (double) sum / length;
		return avg % 1 == 0;
	}

	String removeExtraSpace(String str) {

//		String[] test =str.split("\\s+");
//		System.out.println(Arrays.toString(test));

		return str.replaceAll("\\s+", " ");
	}

	String replaceChar(String str, char ch) {

//		String str1 = "";
//		String Vowels = "aeiouAEIOU";
//		
//		for(int i = 0; i<str.length(); i++) {
//			
//			if(Vowels.indexOf(str.charAt(i)) > -1) str1 = str1+ch;
//			else str1 = str1+str.charAt(i);
//		}
//		

		return str.replaceAll("[aeiouAEIOU]", "#");

	}

	int decimalPlaces(String str) {

		if (!str.contains("."))
			return 0;
		return str.length() - (str.indexOf('.') + 1);

//		if(!str.contains(".")) return 0;
//		
//		return  str.split("\\.")[1].length();
	}

	boolean findMulOccur(String str) {
		// bee
		int len = str.length();
		boolean match = false;
		for (int i = 0; i < len; i++) {
			if (i == len - 1)
				break;
			if (str.charAt(i) == str.charAt(i + 1)) {
				match = true;
				break;
			}
		}

		return match;

	}

	String removeVowel(String str) {

		String vowels = "aeiouAEIOU";

		String lstr = "";

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);
			if (vowels.indexOf(ch) < 0) {
				lstr = lstr + ch;
			}
		}
		return lstr;
	}

	int[] calculateScores(String str) {

		int[] scoresArray = { 0, 0, 0 };
		int a = 0;
		int b = 0;
		int c = 0;
		String lstr = str.toLowerCase();
		if (str.length() == 0)
			return scoresArray;

		for (int i = 0; i < lstr.length(); i++) {
			char ch = lstr.charAt(i);
			if (ch == 'a')
				a++;
			if (ch == 'b')
				b++;
			if (ch == 'c')
				c++;

		}

		scoresArray = new int[] { a, b, c };
		return scoresArray;

	}
//	String doubleWord(String str) {
//		
//		String strFinal = "";
////		String strFinal1 = str.repeat(3);
//		System.out.println(strFinal1);
//		for(int i =0; i< str.length(); i++) {
//			
//			
//			strFinal = strFinal + str.charAt(i)+ str.charAt(i);
//			
//		}
//		
//		return strFinal;
//	}

	boolean checkXOXO(String str) {
		int countX = 0;
		int countO = 0;
		String strLower = str.toLowerCase();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == 'x')
				countX++;
			if (ch == 'o')
				countO++;
		}
		return countX == countO;
	}

	String findBomb(String str) {
		return str.toLowerCase().contains("bomb") ? "Duck!!" : "relax there is no bomb";
	}

	int stepSequence(int step) {
		return step % 2 == 0 ? step : step + 2;
	}

	int numOfVowels(String str) {

		String vowels = "aeiouAEIOU";
		int counter = 0;

		for (int i = 0; i < str.length(); i++) {
			if (vowels.indexOf(str.charAt(i)) > -1)
				counter = counter + 1;
		}
		return counter;

	}

	String returnNumber(int[] arr) {

//		String phoneNumber = "(";
//		
//		for(int i = 0; i< arr.length; i++) {
//			if(i == 3) phoneNumber = phoneNumber+") ";
//			if(i == 6) phoneNumber = phoneNumber+"-";
//			phoneNumber = phoneNumber+ Integer.toString(arr[i]);
//		}
//		
//		return phoneNumber;

		String phoneNumber = String.format("(%d%d%d) %d%d%d-%d%d%d%d", arr[0], arr[1], arr[2], arr[3], arr[4], arr[5],
				arr[6], arr[7], arr[8], arr[9]);

		return phoneNumber;

	}

	String reform(String left, String right) {

		String str = left.substring(0, 1).toUpperCase() + left.substring(1) + right;

		return str;

	}

	String reverse(String str) {

		char ch;
		String rstr = "";
		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			rstr = ch + rstr;
		}
//		StringBuilder sb = new StringBuilder();
//		sb.append(str);
////		String s = sb.reverse().toString();
//		return sb.reverse().toString();
		return rstr;
	}

	public String fizzBuzz(int n) {

		if (n % 3 == 0 && n % 5 == 0)
			return "FizzBuzz";
		if (n % 3 == 0)
			return "Fizz";
		if (n % 5 == 0)
			return "Buzz";
		return Integer.toString(n);

	}

	public String stutter(String str) {
		String substr = str.substring(0, 2);
		String result = substr.concat("... " + substr + "... " + str + "?");
		return result;
	}

	int countStringWords(String str) {
		int a = 0;
		String[] strArray = str.split(" ");
		a = strArray.length;
//		for(String strg: strArray) a++; 
		return a;
	}

	boolean StringEnding(String str1, String str2) {

		return str1.endsWith(str2);

	}

	public boolean existsHigher(int[] arr, int n) {

		for (int i : arr)
			if (i > n)
				return true;

		return false;
	}

	String swapName(String str) throws IndexOutOfBoundsException {

		String[] strArray = str.split(" ");

		return strArray[1] + " " + strArray[0];
	}

	public static void main(String[] args) throws IndexOutOfBoundsException {

		StringWordCount swc = new StringWordCount();
		Scanner ss = new Scanner(System.in);
		System.out.println("Enter string:");
		String[] str = { "parses", "par1" };
		int[] arr = { 7, 3, 5, 1 };

		char ch = 'a';
		char ch1 = 'b';

//		System.out.println(swc.validateEmail("dhruv@a.c"));
//		System.out.println(swc.highLow("1 2 -3 4 5"));
//		System.out.println(swc.reverseStrRec(""));

//		System.out.println(swc.dnaToRna("CGATATA"));

//		System.out.println(swc.flipEndChars("Ada"));
//		System.out.println(swc.addStrings("a", ""));
//		System.out.println(swc.rps("scissors", "paper"));
//		System.out.println(swc.isBetween("boost", "boost", "boost"));
//		System.out.println(swc.countVowelsRecursive(""));

//		System.out.println(swc.check2Strings(str));

//		System.out.println(swc.removeSpecialCharacters("D0n$c sed 0di0_du1"));

//		System.out.println(swc.countUniqueChars("dhruv", "nirali"));

//		System.out.println(swc.lettersOnly("@!d[h]``r12u84758458v[]"));

//		System.out.println(swc.isIsogram("abcda"));
//		System.out.println(swc.leftmostnum("J@v@5cR1PT"));
//		System.out.println(swc.validString("TimesN"));
//		System.out.println(swc.nameOfCity("Cheese Factory Tour [Portland]"));

//		System.out.println(swc.fakeBinary("moon"));
//		System.out.println(swc.isPalindrome("mom"));
//		System.out.println(swc.firstVowel("pknvEaPPLe"));

//		System.out.println(swc.timeToFinish("As a result, my point is still valid.",
//				  "As a result, my"));
//		System.out.println(swc.canAlternate("01001"));
//		System.out.println(swc.isStrangePair("", ""));
//		System.out.println(Arrays.toString(swc.firstLetterCapital(str)));
//		System.out.println(swc.findNthSmallest(arr, 4));
//		System.out.println(swc.atmPinValidation(""));

//		System.out.println("team name: "+swc.validateZipCode("39ab0"));
//		System.out.println("team name: "+swc.societyName(str));

//		System.out.println(swc.middleCharacter("tom"));

//		System.out.println(swc.removeABC(""));

//		System.out.println(swc.spotLightSum(88));
//		System.out.println(swc.sortStringChars("javascript"));

//		int i = ch1 +  ch;
//		System.out.println(i);
//		
//		System.out.println(swc.isSpecialArray(arr));
//		System.out.println("output:"+swc.indexShuffle("holiday"));
//		System.out.println(swc.isPreffix("automation", "auto-"));
//		System.out.println(swc.isPreffix("retrospect", "sub-"));
//		System.out.println(swc.isSuffix("arachnophobia", "-phobia"));
//		
//		System.out.println(swc.isSuffix("vocation", "-logy"));

//		String input = ss.nextLine();
//		System.out.println("result: "+swc.matchLast(str));
//		System.out.println("result: "+swc.charRepeat(input, 5));

//		System.out.println(swc.addSpace("Suno gaur se duniya walo"));
//		System.out.println(swc.joinPortions("namaste/", "namaste2"));
//		System.out.println(swc.removeExtraSpace(input));

//		System.out.println(swc.checkAvgIsInt(arr));

//		System.out.println(swc.replaceChar(input,'*'));
//		System.out.println(swc.decimalPlaces(input));
//		System.out.println(swc.findMulOccur(input));

//		System.out.println(swc.removeVowel(input));
//		System.out.println(Arrays.toString(swc.calculateScores(input)));
//		System.out.println(swc.doubleWord(input));

//		int[] arr = {5, 1, 9, 5, 5, 5, 4, 4, 6, 8};

//		System.out.println(swc.checkXOXO(""));	
//		System.out.println(swc.findBomb("there "));
//		System.out.println("Number of boxes:"+swc.stepSequence(9));
//		System.out.println(swc.numOfVowels("AnimalAlanEt"));
//		System.out.println(swc.returnNumber(arr));
//		String left = ss.nextLine();
//		String right = ss.nextLine();
//		System.out.println(swc.reverse("Nayan!!"));
//		System.out.println(swc.reform(left, right));
//		String str = ss.next();
//		System.out.println(swc.swapName(str));
//		System.out.println(swc.fizzBuzz(2));
		// String str = "Hello Dhruv , You Rock!";
//		String str1 = "Hello Dhruv , You Rock!";
//		String str2= "!";
//		System.out.println(swc.StringEnding(str1, str2));
//		System.out.println("total words:"+swc.countStringWords(str));
//		int[] arr = {};
//		System.out.println(swc.existsHigher(arr, 10));

//		System.out.println(swc.findZip("Zip is a file format used for data compression and archiving. A zip file contains one or more files that have been compressed, to reduce file size, or stored as is. The zip file format permits a number of compression algorithms."));
//		System.out.println(swc.firstNVowels("shrimpy", 2));

//		System.out.println(swc.isValidHexCode("#CD5CMC"));
//		System.out.println(swc.capLast("hahA I aM alreadY capitaliseD"));
//		System.out.println(swc.wordNest("home", "hohohohhohohhhohhomeomemeomeomememeomemememe"));

//		System.out.println(swc.magic("3 3 2009"));
//		System.out.println(swc.sumOfVowels("I love edabit!"));
//		System.err.println(swc.capSpace("stayIndoors"));
//		System.out.println(swc.accum("nRBSdNOsMl"));
//		System.out.println(swc.reverse5OrMore	("Lets all be unique together until we realise we are all the same."));
//		System.out.println(swc.decimator("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"));
		int[] arr1 = { 1, 10 };
//		System.out.println(swc.histogram(arr1, "+"));
//		System.out.println(swc.replaceThe("the egg, the spoon and the espionag"));
//		System.out.println(swc.solveEquation("x + 300 = 100"));
//		System.out.println(swc.extendVowels("Tesha", 5));
//		System.out.println(swc.toCamelCase("The_Stealth_Warrior"));
//		System.out.println(swc.isSmooth(""));
//		System.out.println(swc.alternatingCaps("OMG this website is awesome!"));
//		System.out.println(swc.uncensor("*PP*RC*S*", "UEAE"));
//		System.out.println(swc.validateBinary("11000000"));
//		System.out.println(swc.dashed("Carpe Diem"));
//		System.out.println(swc.missingLetter("abcdefgijlmop"));
//		System.out.println(swc.emphasize("99 red balloons!"));
//		System.out.println(swc.karacaEncrypt("alpaca"));
//		System.out.println(swc.alphabetIndex("The river stole the gods."));
//		System.out.println(swc.isAnagram("apple", "appeal"));
		int j = 10;
		int k = 15;
		Function<Integer, Integer> fFun = i -> i;
		Function<Integer, Integer> gFun = n -> n;
//		System.out.println(swc.whichIsLarger(10, 1, fFun, gFun));
//		System.out.println(swc.wurstIsBetter("The chipper group over at Orangatang recently dropped another wheel sensation; the Moronga"));
//		System.out.println(swc.wormLength("---_-___---_"));
//		System.out.println(swc.wordedMath("two minus one"));
//		System.out.println(swc.longestZero("1000000000011101"));
//		System.out.println(swc.mysteryFunc(24));
//		System.out.println(swc.returnTheEndOfNumber(213));
//		System.out.println(swc.censor("aaaa aaaaa 1234 12345"));
//		System.out.println(swc.doubleSwap("128 895 556 788 999", '8', '9'));
//		System.out.println(swc.palindromicDate("07/07/7070"));
//		System.out.println(swc.insertWhitespace("TheGreatestUpsetInHistory"));
//		System.out.println(swc.bestFriend("tesh loves my messages", "e", "s"));
//		System.out.println(swc.firstBeforeSecond("moody muggles", "m", "g"));\
//		System.out.println(swc.countAdverbs("She forgot where to buy the lysol."));
//		System.out.println(swc.countPalindromes(8, 34));
//		System.out.println(swc.swapXY("(-5, -3), (7, 4)"));
//		System.out.println(swc.isKaprekar(533170));
		String str1 = "There's never enough time to do all the nothing you want";
//		System.out.println(swc.flip(str1, "sentence"));
//		System.out.println(swc.longestCommonEnding("vote", "asymptote"));
//		System.out.println(swc.noDuplicateLetters("Always be closing."));
//		System.out.println(swc.absolute("An apple for a day keeps a doctor away."));
//		System.out.println(swc.hoursPassed("1:00 AM", "1:00 AM"));
//		System.out.println(swc.isStretched("magneto", "magnet"));
//		System.out.println(swc.lengthen("DUH", "champagne"));
//		System.out.println(swc.likeOrDislike(new String[] {}));
//		System.out.println(swc.singleOccurrence("iSs"));
//		System.out.println(swc.sevenBoom(new int[] {}));
//		System.out.println(swc.validate(" 4983"));
//		System.out.println(swc.isPalindromeRecursion("abacus"));
//		System.out.println(swc.unmix("badce"));
//		System.out.println(swc.reverseOdd("Ddo ddo ddo ddo"));
//		System.out.println(swc.balanced("nama"));
//		System.out.println(swc.textToNum("435-224-7613"));
//		System.out.println(swc.duplicateCount("aa1112"));
//		System.out.println(swc.xPronounce("OMG xylem unboxing video x D"));
//		System.out.println(swc.almostPalindrome("gggfgig"));
//		System.out.println(swc.missingLetter(new String[] {"m", "o"}));
//		System.out.println(swc.selectLetters("nothing", "nothing"));
//		System.out.println(swc.isPositiveDominant(new int[] {5, 4, 3, 0, 0,-1,-1,-2,-2}));
//		System.out.println(swc.noYelling("I just cannot believe it."));
//		System.out.println(swc.removeWord("Sally sells seashells by the seashore","the"));
//		System.out.println(swc.isAlphabeticallySorted("She almost reached the top of Mt. Everest."));
//		System.out.println(swc.swapTwo("FFG"));
//		System.out.println(swc.canBuild("topsh", "shop"));
//		System.out.println(swc.firstIndex("a3 24 25 2d 2d 2d a3 24 20 77 6f 72 6c 64 2d 2d 2d", "world"));
//		System.out.println(swc.sigilize("I have a job I enjoy and it pays well"));
//		System.out.println(swc.toCamelCaseNew("is_modal_open"));
//		System.out.println(swc.toSnakeCase("isModalOpen"));
//		System.out.println(swc.isDisarium(518));
//		System.out.println(swc.isParselTongue("You ssseldom sssspeak sso boldly, ssso messmerizingly."));
//		System.out.println(swc.pyramid(3));
//		System.out.println(swc.correctSigns("1 < 2 < 6 < 9 > 12"));
//		System.out.println(swc.removeLeadingTrailing("30"));
//		System.out.println(swc.removeLeadingTrailing("00200.1900001"));
//		System.out.println(swc.isModest(2037));
//		System.out.println(swc.commonLastVowel("Hello World!"));
//		System.out.println(swc.removeLastVowel("Love is a serious mental disease."));
//		System.out.println(swc.mangle("I will never be this young again. Ever. Oh damn… I just got older."));
//		System.out.println(Arrays.toString(swc.threeLetterCollection("programming")));
//		System.out.println(swc.reverseNotNumbers("a1b1c"));
//		System.out.println(swc.countLoneOnes(101010101));
//		System.out.println(swc.doesRhyme("with an unpleasant bump", "in a slump"));
//		System.out.println(swc.plusSign("+d+i+#+c+"));
//		System.out.println(swc.overlap("hello world", "hello"));
//		System.out.println(swc.canBuildNew("gate im in", "magnetizing"));
//		System.out.println(swc.instrumentRange("Tuba", "F6"));
//		System.out.println(swc.replace_nth("Writing a list of random sentences is harder than I initially thought it would be.", 2, "i", "3"));
//		System.out.println(swc.word_rank("The memory we used to share is no longer coherent."));
//		System.out.println(swc.afterPotion("1A2A3A4A"));
//		System.out.println(swc.invert("XeLPMoC YTiReTXeD"));
//		System.out.println(swc.row("ABC"));
//		System.out.println(swc.bracketLogic("{{[[([())]]]}}"));
//		System.out.println(swc.isBalanced("{{[[([())]]]}}"));
//		System.out.println(swc.spoonerise("bocolate chiscuits"));
//		System.out.println(swc.anaStrStr("altar", "pastoral"));
//		System.out.println(swc.truncate("Lorem ipsum dolor sit amet.", 11));
//		System.out.println(swc.truncate("Lorem ipsum", 4));
//		System.out.println(swc.elasticize("REDDER"));
//		System.out.println(swc.commentsCorrect("/**/////**/"));
//		System.out.println(swc.isIcecreamSandwich("AABAA"));
//		System.out.println(swc.lookAndSay("132113213221133112132113311211131221121321131211132221123113112221131112311332111213211322211312113211"));
//		System.out.println(swc.findLongest("Yourself is your soul's captain and fate's master."));
//		System.out.println(Arrays.toString(swc.pluralizeWordsArray(new String[] {"set","set","tuple","tuple","string","string","string","string","integer"})));
//		System.out.println(swc.fiboWord(10));
//		System.out.println(swc.abacabaPattern(9));
//		System.out.println(swc.isValidIP("1.232.0.227"));
//		System.out.println(swc.kixCode("Dijk, Antwoordnummer 80430, 2130 VA Hoofddorp"));
//		System.out.println(swc.minSwaps("101000000"));
//		System.out.println(swc.toStarShorthand("11223344"));
//		System.out.println(swc.edabitInString("abecdfghijklmnopqrstuvwxyz"));
//		List<Fruit> list = new LinkedList<>();
//		list.add(new Fruit("grapes", 1));
//		list.add(new Fruit("Bananas", 2));
//		list.add(new Fruit("apple", 5));
//		list.add(new Fruit("wallnut", 1));
//		System.out.println(swc.splitBunches(list));

//		System.out.println(Arrays.toString(swc.validateSwaps(new String[] {"9786", "9788", "97865", "7689"}, "9768")));
//		System.out.println(swc.validatePhoneNumber("894 445 766"));
//		System.out.println(Arrays.toString(swc.toBoolArray(swc.toBitString("exotic"))));
//		System.out.println(swc.anagram("Jeff Goldblum", new String[] {"jog", "meld", "bluffs"}));
//		System.out.println(swc.possiblePalindrome("aabbccddef"));
//		System.out.println(swc.incrementString("fo120ooo000999"));
//		System.out.println(Arrays.toString(swc.splitExample("((()))(())()()(()())")));
//		System.out.println(swc.atbash("Christmas is the 25th of December"));
//		System.out.println(Arrays.toString(swc.encrypt("Hi there!")));
//		System.out.println(swc.decrypt(new int[] {72, 33, -73, 84, -12, -3, 13, -13, -68 }));
//		System.out.println(swc.canComplete("sg", "something"));
//		System.out.println(swc.isPalindromePossible("orort"));
//		System.out.println(swc.youtubeId("https://youtube.com/watch?t=4m40s&v=vxP3bY-XxY4"));
//		System.out.println(swc.validWordNest("pioneer", "pionpippipioppionpiopipioneeroneerneereerioneerneeroneerioneeroneereer"));
//		System.out.println(swc.findTheDifference("mnoqrst", "mnopqrst"));
//		System.out.println(swc.paulCipher("MATT"));
//		System.out.println(swc.sameLetterPattern("FFFG", "GGGI"));
//		System.out.println(swc.licensePlate("nlj-206-fv", 3));
//		System.out.println(swc.rearrange("h1appy y3all! coding2"));
//		System.out.println(swc.expandedForm(0.1234));
//		System.out.println(swc.recompose("DeosItOffeYdnuoYaeh"));
//		System.out.println(swc.cipher("TheQuickBrownFoxJumpsOverTheLazyDog.", 6));
//		System.out.println(swc.reverseWords("man! the are You"));
//		System.out.println(swc.strongPassword("D.123com"));
//		System.out.println(Arrays.toString(swc.removeLetters(new String[]{"t", "t", "e", "s", "t", "u"}, "testing")));
//		System.out.println(swc.numbersNeedFriendsToo(616));
//		System.out.println(swc.pigLatin("He told us a very exciting tale."));
//		System.out.println(swc.specialReverseString("It's known that CSS means Cascading Style Sheets"));
//		System.out.println(swc.longestSubstring("721449827599186159274227324466"));
//		System.out.println(swc.alphabetIndexVeryHard("Hello"));
//		System.out.println(swc.caesarCipher("A Fool and His Money Are Soon Parted.", 27));
//		System.out.println(swc.minSwaps("100100100111"));
//		System.out.println(swc.sentencePrimeness("Help me!"));
//		System.out.println(swc.longestNonrepeatingSubstring("abddefgh"));
//		System.out.println(swc.numToEng(26));
//		System.out.println(swc.validColor("rgba(0,0,0,1.1)"));
//		System.out.println(swc.reverseLegoYoda("An alien, I am. Holding me captive in Area 51, the government is."));
//		System.out.println(swc.generateWord(21));
//		System.out.println(swc.mixedNumber("-5/4"));
//		System.out.println(swc.validName("Herbert W. G. Wells"));
//		System.out.println(swc.correctTitle("jon SNOw, the King in THE NoRtH"));
//		System.out.println(swc.isZygodrome(0));
//		System.out.println(swc.repeatedString("aab",882787));
//		System.out.println(swc.stripUrlParams("https://edabit.com?a=1&b=2&c=3&d=4&c=5"));
//		System.out.println(swc.ascending("666667"));
//		System.out.println(swc.pilish_string("33314444155555999999999226666665555533355555888888889999999997777777999999999"));
		System.out.println(swc.encryption("One should not worry over things that have already happened and that cannot be changed."));
	}

}
