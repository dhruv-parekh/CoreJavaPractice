package com.practice.JavaPracticeNew;

import java.awt.datatransfer.StringSelection;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TriangleDots {
	StringWordCount swc;
	
	double weighOnMars(double weight) {
		
		return new BigDecimal((weight*3.73)/9.81).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
		
	}

	String multiplyBy11WithTwist(String n) {

		String rev = new StringBuilder(n).reverse().toString();
		String result = rev.charAt(0) + "";
		int a = 0;
		int sum = 0;
		int r = 0;
		for (int i = 0; i < rev.length(); i++) {

			if (i == rev.length() - 1) {
				String temp = Integer.toString(Integer.parseInt(rev.charAt(rev.length() - 1) + "") + a);
				result = result + new StringBuilder(temp).reverse().toString();
				break;
			}
			sum = Integer.parseInt(rev.charAt(i) + "") + Integer.parseInt(rev.charAt(i + 1) + "") + a;

			a = sum / 10;
			r = sum % 10;
//			System.out.println(sum+" "+r);
			result = result + r;
		}

		return new StringBuilder(result).reverse().toString();
	}

	boolean cFuge(int n, int k) {
		return (k != 1 && n != 1) && (n == k || (n % 2 == 0 && k % 2 == 1) || n % (n - k) == 0);
	}

	boolean ascending(String str) {
		int len = str.length();
		int wordLen = 1;
		while (wordLen * 2 <= len) {
			int index = 0;
			int num = Integer.parseInt(str.substring(index, index + wordLen));
			while (index + 2 * wordLen <= len) {
				int nextNum = Integer.parseInt(str.substring(index + wordLen, index + 2 * wordLen));
				if (nextNum - num != 1) {
					index = len;
				} else if (index + 2 * wordLen == len) {
					return true;
				}
				num = nextNum;
				index = index + wordLen;
			}
			wordLen++;
		}
		return false;
	}

	boolean palindromeDescendant(int num) {
		String n = Integer.toString(num);
		if (n.length() % 2 != 0)
			return false;
		boolean flag = palindromeDescendantSupport(n);
		return flag;
	}

	boolean palindromeDescendantSupport(String n) {
		swc = new StringWordCount();
		if (n.length() % 2 != 0 || n.length() == 1)
			return false;
		if (swc.isPalindrome(n))
			return true;
		String num = "";
		for (int i = 0; i < n.length(); i = i + 2) {
			int sum = Integer.parseInt(n.charAt(i) + "") + Integer.parseInt(n.charAt(i + 1) + "");
			num = num + Integer.toString(sum);
		}
		return palindromeDescendantSupport(num);
	}

	int superDigit(String n, int k) {
		String num = n.repeat(k);
		return (int) superDigitSupport(num);

	}

	private long superDigitSupport(String num) {

		if (num.length() == 1)
			return Integer.parseInt(num);

		Long l = Long.parseLong(num);
		long sum = 0;
		while (l > 0) {
			sum = sum + l % 10;
			l = l / 10;
		}
		return superDigitSupport(Long.toString(sum));
	}

	int whoGoesFree(int n, int k) {
		List<Integer> list = new ArrayList<>();
		int index = 0;
		for (int i = 0; i < n; i++) {
			list.add(i);
		}
		return whoGoesFreeRecur(list, index, k);
	}

	private int whoGoesFreeRecur(List<Integer> list, int index, int k) {
		System.out.println(list);
		if (list.size() == 1)
			return list.get(0);

		index = ((index - 1) + k) % list.size();
		list.remove(index);
		return whoGoesFreeRecur(list, index, k);
	}

	int kaprekar(int num) {

		String n = Integer.toString(num);

		if (n.length() < 4) {
			n = addZeros(n);
		}

		int counter = 0;
		while (!n.equals("6174")) {
			int a = arrangeAsc(n);
			int b = arrangeDesc(n);
			System.out.println("a: " + a + " b: " + b);
			num = a > b ? a - b : b - a;
			n = Integer.toString(num);
			if (n.length() < 4) {
				n = addZeros(n);
			}
			System.out.println("n: " + n);
			counter++;
		}

		return counter;
	}

	private int arrangeDesc(String n) {
		String[] res = new String[4];
		for (int i = 0; i < n.length(); i++) {
//			res[i] = Integer.parseInt(n.charAt(i)+"");
			res[i] = n.charAt(i) + "";
		}
		Arrays.sort(res, Collections.reverseOrder());
		String result = String.join("", res);
		return Integer.parseInt(result);
	}

	private int arrangeAsc(String n) {
		String[] res = new String[4];
		for (int i = 0; i < n.length(); i++) {
//			res[i] = Integer.parseInt(n.charAt(i)+"");
			res[i] = n.charAt(i) + "";
		}
		Arrays.sort(res);
		String result = String.join("", res);
		return Integer.parseInt(result);
	}

	String addZeros(String n) {
		int c = 4 - n.length();
		return "0".repeat(c) + n;
	}

	boolean isDisarium(int n) {

		int sum = 0;
		int len = Integer.toString(n).length();
		int temp = n;
		while (n > 0) {
			sum = (int) (sum + Math.pow(n % 10, len));
			n = n / 10;
			len--;
		}
		System.out.println(sum);
		if (sum != temp)
			return false;
		return true;
	}

	boolean productOfPrimes(int num) {
		List<Integer> list = new ArrayList<>();
		for (int i = 2; i <= num / 2; i++) {
//			if(num%i==0 && !isPrime(i)) return false;
			if (num % i == 0)
				list.add(i);
		}
		if (list.size() == 0)
			return false;
		if (list.size() == 1 && num / list.get(0) == list.get(0)) {
			if (!isPrime(list.get(0)))
				return false;
		}
		for (Integer n : list) {
			if (isPrime(n)) {
				if (!isPrime(num / n))
					return false;
			} else {
				return false;
			}
		}
		return true;
	}

	boolean validateTheRelationships(String str) {
		String[] numbers = str.split("[>=<]");
		String[] operands = str.split("-?[0-9]+");
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i].length() == 0)
				continue;
			list.add(Integer.parseInt(numbers[i]));
		}
		System.out.println(list);
		System.out.println(Arrays.toString(operands));
		int index = 1;
		for (int i = 1; i < operands.length; i++) {
			if (operands[i].equals("<") && !(list.get(index - 1) < list.get(i)))
				return false;
			if (operands[i].equals(">") && !(list.get(index - 1) > list.get(i)))
				return false;
			if (operands[i].equals("=") && (list.get(index - 1) != list.get(i)))
				return false;
			if (operands[i].equals("<=") && (list.get(index - 1) > list.get(i)))
				return false;
			if (operands[i].equals(">=") && (list.get(index - 1) < list.get(i)))
				return false;
			index++;
		}

		return true;
	}

	int getLuckiest(int[] r) {
		if (r.length == 0)
			return 0;
		int result = 0;
		int freq = 0;
		for (int i = 0; i < r.length; i++) {
			int num = r[i];
			String n = Integer.toString(num);
			int tempFreq = frequencyOf5(n);
			if (tempFreq > freq) {
				freq = tempFreq;
				result = num;
			}
			if (freq == tempFreq) {
				if (n.contains("5")) {
					if (num > result)
						result = num;
				}
			}

		}
		return result == 0 ? r[0] : result;
	}

	private int frequencyOf5(String n) {
		int freq = 0;
		for (int i = 0; i < n.length(); i++) {
			if (n.charAt(i) == '5')
				freq++;
		}
		return freq;
	}

	boolean isHeteromecic(int n) {
		if (n == 0 || n == 2)
			return true;
		for (int i = 0; i <= n / 2; i++) {
			if (i * (i + 1) == n)
				return true;
		}
		return false;
	}

	int maxProduct(int[] r) {
		int result = 0;

		for (int i = 0; i < r.length; i++) {
			for (int j = 0; j < r.length; j++) {

				for (int k = 0; k < r.length; k++) {
					int product = 1;
					if (k == i || k == j || i == j)
						continue;
					product = r[k] * r[j] * r[i];
					if (product > result) {
//						System.out.println(r[i]+" "+r[j]+" "+r[k]);
						result = product;
					}
				}

			}
		}
		return result;
	}

	int minProduct(int[] r) {
		int result = r[0] * r[1] * r[2];
		for (int i = 0; i < r.length; i++) {
			for (int j = 0; j < r.length; j++) {

				for (int k = 0; k < r.length; k++) {
					int product = 1;
					if (k == i || k == j || i == j)
						continue;
					product = r[k] * r[j] * r[i];
					if (product < result)
						result = product;
				}

			}
		}
		return result;
	}

	int[] extractPrimes(int num) {
		String n = Integer.toString(num);
		Set<Integer> set = new HashSet();

		for (int i = 0; i < n.length(); i++) {
			for (int j = n.length(); j > i; j--) {
//				System.out.println(j);
				set.add(Integer.parseInt(n.substring(i, j)));
			}
		}
//		System.out.println(set);
		Set<Integer> setPrime = new HashSet<>();
		for (Integer i : set) {
			if (isPrime(i))
				setPrime.add(i);
		}
		return setPrime.stream().mapToInt(Integer::intValue).toArray();

	}

	boolean isHappyRecursion(int n) {
		int a = 0;
		int res = isHappySupport(n);
		System.out.println(res);
		return res == 1;

	}

	private int isHappySupport(int n) {
		int sum = 0;
		while (n > 0) {
//			int sum =0;
			sum = sum + (int) Math.pow((n % 10), 2);
			n /= 10;
		}
//		System.out.println(sum);
		if (sum == 1 || sum == 4) {
			return sum;
		}
		return isHappySupport(sum);

	}

	int split25(int num) {

		if (num >= 1 && num < 5)
			return num;
		int n3 = 0;
		int n2 = 0;
		int temp = num;
		while (temp > 0) {
			temp = temp - 3;
			n3++;

			if (temp != 0 && temp < 3) {
				if (temp == 2)
					n2 = 1;
				if (temp == 1) {
					n2 = 2;
					n3--;
				}
				temp = 0;
			}
		}
		return (int) (Math.pow(3, n3) * Math.pow(2, n2));
	}

	boolean isLeapYear(int y) {
		return Year.isLeap(y);
//		  int a = y%100;
//		  int b = y%400;
//		  int c = y%4;
//		  return b-400*a+100000*c <= 0;
	}

	String takeDownAveragBy5(String[] scores) {
		int sum = 0;
		int len = scores.length;
		for (int i = 0; i < len; i++) {
			int temp = Integer.parseInt(scores[i].replaceAll("[\\D]", ""));
			sum += temp;
		}
		double expectedAvg = ((double) sum / len) - 5;
		int result = (int) Math.round(((double) (expectedAvg * (len + 1))) - sum);
		return Integer.toString(result).concat("%");
	}

	int[] isbn13sidefFunction(String str) {

		int[] list13 = { 1, 3, 1, 3, 1, 3, 1, 3, 1, 3, 1, 3, 1 };
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			int n = Integer.parseInt(str.charAt(i) + "");
			sum += (n * list13[i]);
		}
		return sum % 10 == 0 ? new int[] { sum, 1 } : new int[] { sum, 0 };
	}

	int[] isbn10sidefFunction(String str) {
		int[] list10 = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			int n = Integer.parseInt(str.charAt(i) + "");
			sum += (n * list10[i]);
		}
		return sum % 11 == 0 ? new int[] { sum, 1 } : new int[] { sum, 0 };
	}

	String isbn13(String str) {
		str = str.replaceAll("[^0-9]", "");
		if (str.length() != 10 && str.length() != 13)
			return "invalid";
		if (str.length() == 13) {
			int[] result = isbn13sidefFunction(str);
			if (result[1] == 1)
				return "valid isbn13";
			return "invalid isbn13";
		}

		int[] result = isbn10sidefFunction(str);
		if (result[1] == 1) {
			str = "978" + str;
			int[] res = isbn13sidefFunction(str);
			int sum = res[0];
			if (sum % 10 == 0)
				return str;
			int last = Integer.parseInt(str.charAt(str.length() - 1) + "");

			for (int i = 0; i < 10; i++) {
				int a = i + last;
				int b = last - i;
				if (a < 10) {

					String temp = str.substring(0, str.length() - 1) + a;
					int[] t = isbn13sidefFunction(temp);
					if (t[1] == 1)
						return temp;
				}
				if (b >= 0) {
					String temp = str.substring(0, str.length() - 1) + b;
					int[] t = isbn13sidefFunction(temp);
					if (t[1] == 1)
						return temp;
				}

			}
		}
		return "invalid";
	}

	int dayOfYear(String date) throws ParseException {
//		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy",Locale.ENGLISH);
//		String[] d = date.split("/");
//		Date firstDate = sdf.parse("01/00/"+d[2]);
//		Date secondDate = sdf.parse(date); 
//		long daysInMili = Math.abs(secondDate.getTime()-firstDate.getTime());
//		long diff = TimeUnit.DAYS.convert(daysInMili, TimeUnit.MILLISECONDS);
//		
//		return (int)diff;
		String[] d = date.split("/");
		int year = Integer.parseInt(d[2]);
		int month = Integer.parseInt(d[0]) - 1;
		int day = Integer.parseInt(d[1]);
		int days = year % 4 != 0 && month > 2 ? (month * 30) - 2 : (month * 30);
		int misc = year % 4 == 0 ? (month / 2) : (int) Math.ceilDiv(month, 2);
		int totalDays = days + day + misc;

		return totalDays;
	}

	int titleToNumber(String s) {

		int ans = 0;
		for (int i = 0; i < s.length(); i++)
			ans = ans * 26 + s.charAt(i) - 'A' + 1;
		return ans;

	}

	int calcforPostfix(int a, int b, String sign) {
		int result = 0;
		if (sign.equals("+"))
			result = a + b;
		if (sign.equals("-"))
			result = a - b;
		if (sign.equals("*"))
			result = a * b;
		if (sign.equals("/")) {
			System.out.println(a + " " + b);
			result = a / b;
		}

		return result;
	}

	int postfix(String expr) {
		if (expr.length() == 1)
			return Integer.parseInt(expr);
		String[] a = expr.split(" ");
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			if (a[i].matches("[//*//+-//]")) {
				int result = 0;
				if (list.size() != 0) {

					if (!(a[i - 1].matches("[//*//+-//]")) && !(a[i - 2].matches("[//*//+-//]"))) {
						System.out.println("here");
						result = calcforPostfix(Integer.parseInt(a[i - 2]), Integer.parseInt(a[i - 1]), a[i]);
						list.add(result);
						continue;
					} else if (!a[i - 1].matches("[//*//+-//]")) {
						System.out.println("here");
						result = calcforPostfix(list.get(list.size() - 1), Integer.parseInt(a[i - 1]), a[i]);
						list.add(result);
						continue;
					} else {
						System.out.println("else");
						result = calcforPostfix(list.get(list.size() - 2), list.get(list.size() - 1), a[i]);
						list.add(result);
					}

				} else {
					System.out.println("out");
					result = calcforPostfix(Integer.parseInt(a[i - 2]), Integer.parseInt(a[i - 1]), a[i]);
					list.add(result);
				}

			}
		}
		System.out.println(list);
		return list.get(list.size() - 1);
	}

	int maxPossible(int n1, int n2) {
		List<Integer> list = new LinkedList<>();
		while (n2 > 0) {
			list.add(n2 % 10);
			n2 = n2 / 10;
		}
//		System.out.println(list);
		Collections.sort(list);
		String num1 = Integer.toString(n1);
		String result = "";
		for (int i = 0; i < num1.length(); i++) {
			int t = Integer.parseInt(num1.charAt(i) + "");
			int index = list.size() - 1;
			if (list.size() == 0 || (t >= list.get(list.size() - 1))) {
				result = result + t;
				continue;
			}
			result = result + list.get(index);
			list.remove(index);
		}
		return Integer.parseInt(result);
	}

	String actualMemorySize(String ms) {
		int t = ms.length() - 2;
		String sizeType = ms.substring(t);
		int gbFlag = 0;
		if (sizeType.equalsIgnoreCase("gb"))
			gbFlag = 1;
		double size = Double.parseDouble(ms.substring(0, t));
		double actualsize = (size * 93) / 100;

		if (gbFlag == 0)
			return Integer.toString((int) actualsize) + sizeType;
		if (gbFlag == 1 && actualsize < 1)
			return Integer.toString((int) (actualsize * 1000)) + "MB";
		return Double.toString(actualsize) + sizeType;
	}

	int bitRotate(int n, int m, boolean d) {
		if (d == true)
			return ((n << m) | n >> (16 - m)) & 0xFFFF;
		if (d != true)
			return ((n >> m) | n << (16 - m)) & 0xFFFF;
		return 0;
	}

	String sumwithTwist(String a, String b) {

		if (a.length() < b.length()) {
			a = "0".repeat(Math.abs(a.length() - b.length())) + a;
		} else {
			b = "0".repeat(Math.abs(a.length() - b.length())) + b;
		}

		String result = "";
		int c = 0;
		for (int i = a.length() - 1; i >= 0; i--) {

			int temp = c + Integer.parseInt(a.charAt(i) + "") + Integer.parseInt(b.charAt(i) + "");
			c = temp / 10;
			result = temp % 10 + result;
		}
		if (c > 0)
			result = c + result;
		return result;
	}

	String truncatablePrime(int num) {

		if (Integer.toString(num).contains("0"))
			return "none";

		int lflag = 1;
		int rflag = 1;

		lflag = lTruncatablePrime(num);
		rflag = rTruncatablePrime(num);

		String result = (lflag == 1 && rflag == 1) ? "both"
				: (lflag == 1 && rflag == 0) ? "left" : (lflag == 0 && rflag == 1) ? "right" : "none";

		return result;
	}

	int rTruncatablePrime(int num) {
		int rflag = 1;
		String n = Integer.toString(num);
		for (int i = 0; i < n.length(); i++) {
			String temp = n.substring(0, (n.length() - i));
			System.out.println("rtruncate: " + temp);
			if (!isPrime(Integer.parseInt(temp))) {
				rflag = 0;
				break;
			}
		}
		return rflag;
	}

	int lTruncatablePrime(int num) {
		int lflag = 1;
		String n = Integer.toString(num);
		for (int i = 0; i < n.length(); i++) {
			String temp = n.substring(i);
			System.out.println("ltruncate: " + temp);
			if (!isPrime(Integer.parseInt(temp))) {
				lflag = 0;
				break;
			}
		}
		return lflag;
	}

	BigInteger lookAndSay(long n) {
		String num = Long.toString(n);
		int len = num.length();
		if (len % 2 != 0)
			return new BigInteger("-1");
		String result = "";
		for (int i = 1; i < len; i += 2) {
			result = result + (num.charAt(i) + "").repeat(Integer.parseInt(num.charAt(i - 1) + ""));
		}

		return new BigInteger(result);
	}

	String addStrNums(String num1, String num2) {

		if (num1.matches(".*[a-zA-Z].*") || num2.matches(".*[a-zA-Z].*"))
			return "-1";
		num1 = num1.length() == 0 ? "0" : num1;
		num2 = num2.length() == 0 ? "0" : num2;
		BigInteger a = new BigInteger(num1);
		BigInteger b = new BigInteger(num2);
		BigInteger sum = a.add(b);
		return sum.toString();

	}

	int getLuckyNumber(int size, int nth) {
		LinkedList<Integer> arrList = new LinkedList<>();
		for (int i = 1; i <= size; i++)
			if (i % 2 != 0)
				arrList.add(i);
		for (int i = 2; i < nth - 1; i++) {
			for (int j = arrList.get(i - 1) - 1; j < arrList.size(); j += arrList.get(i - 1) - 1) {
				arrList.remove(j);
			}
		}
		return arrList.get(nth - 1);
	}

	boolean validateCard(long num) {
		String str = Long.toString(num);
		if (str.length() < 14 || str.length() > 19)
			return false;
		int checkDigit = Integer.parseInt(str.substring(str.length() - 1));
		str = str.substring(0, str.length() - 1);
		str = new StringBuilder(str).reverse().toString();
		String[] s = str.split("");
		int[] n = new int[s.length];
		int sum = 0;
		for (int i = 0; i < s.length; i++) {
			int temp = Integer.parseInt(s[i]);
			if (i % 2 == 0) {
				temp = temp * 2;
				String temp1 = Integer.toString(temp);
				n[i] = temp1.length() > 1
						? Integer.parseInt(temp1.charAt(0) + "") + Integer.parseInt(temp1.charAt(1) + "")
						: temp;
			} else {
				n[i] = temp;
			}
			sum += n[i];
		}
		int t = Integer.parseInt(Integer.toString(sum).charAt(Integer.toString(sum).length() - 1) + "");

		int res = 10 - t;
		System.out.println("res : " + res + " check: " + checkDigit);
		return checkDigit == res;
	}

	int lcmOfArray(int[] arr) {

		int lcm = lcmNew(arr[0], arr[1]);
		for (int i = 2; i < arr.length; i++) {
			lcm = lcmNew(arr[i], lcm);
		}
		return lcm;
	}

	boolean isHappy(int n) {
		int sum = 0;

		while (true) {
			sum = sumDigitSquare(n);
			System.out.println(sum);
			if (sum == 1)
				return true;
			if (sum == 4)
				return false;
			n = sum;
		}
	}

	int ecgSequenceIndex(int n) {

		ArrayList<Integer> sequence = new ArrayList<>(Arrays.asList(1, 2));
		for (int i = 3; true; i++) {
			if (!sequence.contains(i)) {
				for (int j = 2; j <= i; j++) {
					if (i % j == 0 && sequence.get(sequence.size() - 1) % j == 0) {
						sequence.add(i);
						i = 2;
						break;
					}
				}
			}
			if (sequence.get(sequence.size() - 1) == n)
				break;
		}
		System.out.println(sequence);
		return sequence.indexOf(n);

//		List<Integer> list = new ArrayList<>();
//		list.add(2);
//		for(int i =1;i>0;i++) {
//			for(int j=2;j>0;j++) {
//				System.out.println("here"+j);
//				int a = list.get(i-1);
//				boolean flag = false;
//				for(int k= 2;k<list.size();k++) {
//					if(j%k==0) flag = true;
//				}
//				if(!list.contains(j) && flag) {
//					list.add(j);
//					break;
//				}
//				System.out.println(list);
//			}
//			if(list.contains(n)) break;
//		}
//		System.out.println(list);
//		return list.indexOf(n);
	}

	int squares(int a, int b) {
		return ((int) Math.sqrt(b) - (int) Math.sqrt(a)) + 1;
//		int c = 0;
//		for(int i =a;  i <=b; i++) {
////			double d = Math.sqrt(i);
////			if(d == (int)d) c++;
//		}
//		return c;
	}

	int incDec(int n) {
		int loop = (int) Math.pow(10, n);
		int c = 0;
		for (int i = 1; i <= loop; i++) {
			String[] a = Integer.toString(i).split("");
			Arrays.sort(a);
			if (Integer.parseInt(String.join("", a)) == i) {
				c++;
				continue;
			}
			Arrays.sort(a, Collections.reverseOrder());
			if (Integer.parseInt(String.join("", a)) == i) {
				c++;
				continue;
			}
		}
		return c;
	}

	int countDigitsum(int n) {
		int sum = 0;
		while (n > 0) {
			sum = sum + (n % 10);
			n /= 10;
		}
		return sum;
	}

	int additivePersistence(int n) {
		if (Integer.toString(n).length() == 1)
			return 0;
		int c = 0;
		int sum = n;
		while (Integer.toString(sum).length() != 1) {
			sum = countDigitsum(sum);
			c++;
		}
		return c;
	}

	long multiplyDigitsUntillOneDigit(long n) {
		long mul = 1;
		while (n >= 1) {
			mul = mul * (n % 10);
			n = n / 10;
		}
		long m = Long.toString(mul).length();
		if (m != 1) {
			mul = multiplyDigitsUntillOneDigit(mul);
		}
		return mul;
	}

	long sumDigProd(int... a) {
		if (a.length == 1 && a[0] == 0)
			return 0;
		int sum = IntStream.of(a).sum();
//		System.out.println(sum);
		return multiplyDigitsUntillOneDigit(sum);
	}

	int NumberOfDays(int cost, int savings, int start) {

		int sum = savings;
		int n = 0;
		int day = 1;
		for (int i = start; sum <= cost; i++) {
			sum = sum + i;
			n++;

			if (day % 7 == 0)
				i = i - 7 + 1;
			day++;
		}
		return n;
//		int sum = savings;
//		int n = 0;
//		for(int i=start; sum<=cost;i++) {
//			int day = 1;
//			for(int j = i;day<=7;j++) {
//				sum  = sum+j;
//				n++;
//				day++;
//				if(sum>=cost) break;
//				
//			}
//		}
//		return n;
	}

	boolean isUndulating(int n) {
		String num = Integer.toString(n);
		if (num.length() < 3)
			return false;
		Set<Character> set = new LinkedHashSet<>();
		for (int i = 0; i < num.length(); i++) {
			set.add(num.charAt(i));
		}
		List<Character> list = new LinkedList<>(set);
		System.out.println(list);
		if (set.size() != 2)
			return false;
		if (set.size() == 2) {
			for (int i = 0; i < num.length(); i++) {
				if (i % 2 == 0 && num.charAt(i) != list.get(0))
					return false;
				if (i % 2 != 0 && num.charAt(i) != list.get(1))
					return false;
			}
		}
		return true;
	}

	int gapful(int n) {
		if (n < 100)
			return 100;

		for (int i = n, j = n; i != 0; i++, j--) {
			String[] si = Integer.toString(i).split("");
			String[] sj = Integer.toString(j).split("");
			int ai = Integer.parseInt(si[0] + si[si.length - 1]);
			int aj = Integer.parseInt(sj[0] + sj[sj.length - 1]);
			if (j % aj == 0) {
				return j;
			}
			if (i % ai == 0) {
				return i;
			}

		}
		return 0;
	}

	String easterDate(int y) {
		int a = y % 19;
		int b = y / 100;
		int c = y % 100;
		int d = b / 4;
		int e = b % 4;
		int f = (b + 8) / 25;
		int g = (b - f + 1) / 3;
		int h = ((19 * a) + b - d - g + 15) % 30;
		int i = c / 4;
		int k = c % 4;
		int l = (32 + (2 * e) + (2 * i) - h - k) % 7;
		int m = (a + (11 * h) + (22 * l)) / 451;
		int n = (h + l - (7 * m) + 114) / 31;
		int o = (h + l - (7 * m) + 114) % 31;
		int p = o + 1;
		return n == 3 ? Integer.toString(p) + " March" : Integer.toString(p) + " April";
	}

	boolean isAutobiographical(int n) {
		String num = Integer.toString(n);
		String[] a = num.split("");
		for (int i = 0; i < a.length; i++) {
			String temp = num.replaceAll("[^" + i + "]", "");
//			System.out.println("here"+temp);
			if (temp.length() != Integer.parseInt(a[i]))
				return false;
		}
		return true;
	}

	boolean swapCards(int x, int y) {
		int x1 = x / 10;
		int x2 = x % 10;
		int y1 = y / 10;
		int y2 = x % 10;
		String pos = "";
		int a = 0;
		if (x1 <= x2) {
			pos = "left";
			a = x1;
		} else {
			a = x2;
			pos = "right";
		}

		int temp = a;
		a = y1;
		y1 = temp;

		int xnew = 0;
		if (pos.equals("left"))
			xnew = Integer.parseInt(Integer.toString(a) + Integer.toString(x2));
		if (pos.equals("right"))
			xnew = Integer.parseInt(Integer.toString(x1) + Integer.toString(a));
		int ynew = Integer.parseInt(Integer.toString(y1) + Integer.toString(y2));

		return xnew > ynew;
	}

	int halveCount(double a, int b) {
		int c = 0;
		double h = a / 2;
		if (h < b)
			return 0;
		c = c + 1 + halveCount(h, b);
		return c;

	}

	int multiply(int x, int y) {
		if (y == 0)
			return 0;
		if (y < 0) {
			x = 0 - x;
			y = Math.abs(y);
		}
		int p = 0;
		p = p + x + multiply(x, y - 1);
		return p;
	}

	int secret(int i) {
		int a = i / 10;
		int b = i % 10;
		return (int) Math.pow(a, b) - (a * b);
	}

	String roundabout(int siz, int dgr) {
		int exit = 0;
		for (int i = 0; i <= dgr + 30; i += 360 / siz) {
			exit++;
			if (exit >= siz)
				exit = 0;
		}
		return "Exit " + exit;
	}

	long[] isExact(long n) {
		int p = 1;
		long[] ans = new long[2];
		for (int i = 1; i <= n / 2; i++) {
			p = p * i;
			if (p == n) {
				ans[0] = n;
				ans[1] = i;
			}
		}
		if (ans[0] == 0)
			return new long[] {};
		return ans;
	}

	int digitsCountRecursive(long n) {
		if (n < 1)
			return 1;
		int c = 0;
		long num = n / 10;
		if (num > 0)
			c++;
		c = c + digitsCountRecursive(num);
		return c;

	}

	int[] goldbachConjecture(int n) {
		if (n <= 2 || n % 2 != 0)
			return new int[] {};

		int[] a = new int[2];
		for (int i = 2, j = n - 2; i < n; i++, j--) {

			if (isPrime(i) && isPrime(j)) {
//				if(i+j ==n) {
				a[0] = i;
				a[1] = j;
				break;
//				}
			}
		}
		return a;
	}

	int lcmOfThree(int[] arr) {
		int lcm1 = lcmNew(arr[0], arr[1]);
		return lcmNew(lcm1, arr[2]);
	}

	int sumDigitSquare(int num) {
		int sum = 0;
		while (num > 0) {
			int a = num % 10;
			sum = (int) (sum + Math.pow(a, 2));
			num /= 10;
		}
		return sum;
	}

	String happyAlgorithm(int num) {
		List<Integer> list = new ArrayList<>();
		int counter = 0;
		if (num == 1)
			return "happy 1";
		list.add(num);
		while (num != 1) {
			int sum = 0;
			counter++;
			sum = sumDigitSquare(num);
			System.out.println(counter + " " + sum);
			if (list.contains(sum))
				break;
			list.add(sum);

			num = sum;
		}
		if (num != 1)
			return "sad " + counter;
		return "happy " + counter;
	}

	boolean isBrilliant(int n) {
		// sqrt;
		double a = Math.sqrt(n);
		if (a == (int) a && isPrime((int) Math.sqrt(n)))
			return true;
		List<Integer> list = new ArrayList<>();
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0 && isPrime(i))
				list.add(i);
		}
		if (list.size() != 2) {
			System.out.println("size " + list.size());
			return false;
		}
		if (String.valueOf(list.get(0)).length() != String.valueOf(list.get(1)).length())
			return false;
		return true;
	}

	boolean sharedDigits(int[] num) {

		for (int i = 0; i < num.length - 1; i++) {
			String a = Integer.toString(num[i]);
			String b = Integer.toString(num[i + 1]);
			int counter = 0;
			for (int j = 0; j < b.length(); j++) {

				if (a.contains(String.valueOf(b.charAt(j)))) {
					break;
				}
				counter++;
				System.out.println(counter);
				if (counter == b.length()) {
					return false;
				}
			}
		}
		return true;
	}

	int findHole(int n) {
		int sum = 0;
		while (n > 0) {
			int a = n % 10;
			if (a == 4 || a == 6 || a == 9 || a == 0) {
				sum++;
//				System.out.println(a);
			}
			if (a == 8) {
				sum += 2;
			}
			n = n / 10;
		}
		return sum;
	}

	int sumOfHoles(int N) {
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			sum = sum + findHole(i);
		}
		return sum;
	}

	Object logarithm(Object base, Object num) {
		int count = 0;
		while ((int) num > 1) {

			num = (int) num / (int) base;
			count++;
		}
		return count;
	}

	String simplify(String str) {
		String[] s = str.split("/");
		int a = Integer.parseInt(s[0]);
		int b = Integer.parseInt(s[1]);
		if (a % b == 0)
			return Integer.toString(a / b);

		int gcd = findGCD(a, b);
		return Integer.toString(a / gcd) + "/" + b / gcd;

	}

	boolean trouble(long num1, long num2) {
//		for (int n=0; n<10; n++)
//			if ((""+num1).matches(".*" + n + n + n + ".*") && (""+num2).matches(".*" + n + n + ".*"))
//				return true;
//		return false;

		String n1 = Long.toString(num1);
		String n2 = Long.toString(num2);
		for (int i = 0; i < n1.length(); i++) {
//			int c1 = Integer.parseInt(n1.charAt(i)+"");
			String c1 = n1.charAt(i) + "";
			System.out.println(c1 + " " + n1.matches(".*" + c1 + "{3,}.*"));
			if (n1.matches(".*" + c1 + "{3,}.*")) {
				if (n2.contains(c1) && n2.matches(".*" + c1 + "{2,}.*"))
					return true;
//				if(n2.contains(c1) && n2.matches(c1+"{2,}")) return true;
			}
		}
		return false;
	}

	int closingInSum(long num) {
		String strNum = Long.toString(num);
		int len = strNum.length();
		int mid = len / 2;
		int sum = 0;
		int limit = mid;
		if (len % 2 != 0)
			limit = mid + 1;
		System.out.println(len + " " + mid);
		for (int i = 0, j = len - 1; i < limit; i++, j--) {

			if (i == j) {
				sum += Integer.parseInt(strNum.charAt(i) + "");
				break;
			}
			int n = Integer.parseInt((strNum.charAt(i) + "").concat(strNum.charAt(j) + ""));
			sum += n;
		}
		return sum;
	}

	boolean sameLength(String str) {
		int a = 0;
		for (int i = 0; i < str.length(); i++) {
			if (i != 0 && str.charAt(i) == '1' && str.charAt(i - 1) == '0' && a != 0)
				return false;
			if (str.charAt(i) == '1')
				a++;
			if (str.charAt(i) == '0')
				a--;

		}
		return a == 0;
	}

	String photograph(int[] trees) {
		int left = 0;
		int right = 0;
		for (int i = 0; i < trees.length - 1; i++) {
			if (trees[i + 1] > trees[i])
				left++;
			if (trees[i] > trees[i + 1])
				right++;
		}
		if (left >= right)
			return "left";
		return "right";
	}

	int periodic(String str) {
		if (str.length() == 1)
			return 1;
		List<String> list = new LinkedList<>();
		list.add(str);
//		sumOfDigits(0);
		int counter = 0;
//		int len = str.length();
		for (int i = 0; i <= Integer.parseInt(str); i++) {
			String s = list.get(i);
			int num = (int) sumOfDigits(Integer.parseInt(s));
			String numStr = Integer.toString(num);
			int numStrLen = numStr.length();
			s = s.substring(numStrLen) + numStr;
			if (list.contains(s)) {
				counter++;
				break;
			}
			list.add(s);
			counter++;
		}
		return counter;
	}

	boolean isRightAngle(int[] arr, String desc) {
		if (arr.length > 3)
			return false;
		if (arr.length == 0)
			return true;
		if (desc.equalsIgnoreCase("angle")) {
			int sum = 0;
			int counter = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > 90 || arr[i] == 0)
					return false;
				if (arr[i] == 90)
					counter++;
				sum = sum + arr[i];
			}
			if (180 - sum < 0)
				return false;
			System.out.println(counter);
			if (counter > 1)
				return false;
			if (arr.length < 3 && 180 - sum < 90)
				return false;
			if (arr.length == 3 && counter == 0)
				return false;
			return true;
		} else if (desc.equalsIgnoreCase("side")) {
			if (arr.length == 3) {
				Arrays.sort(arr);
				int a = arr[0];
				int b = arr[1];
				int c = arr[2];
				if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2))
					return true;
				return false;
			}
			return true;
		} else
			return false;
	}

	boolean isPowerful(int num) {
		List<Integer> list = new ArrayList<>();
		for (int i = 2; i <= num / 2; i++) {
			if (isPrime(i) && num % i == 0) {
				list.add(i);
				int p = (int) Math.pow(i, 2);
				if (num % p != 0)
					return false;
			}
		}
		return true;
	}

	String convertTime(String time) {
		// 12 to 24
		if (time.endsWith("am") || time.endsWith("pm")) {
			String[] arr = time.split(" ");
			if (arr[1].equals("am")) {
				String[] hm = arr[0].split(":");
				if (hm[0].equals("12"))
					return Integer.parseInt(hm[0]) - 12 + ":" + hm[1];
				return arr[0];
			} else {
				String[] hm = arr[0].split(":");
				return Integer.parseInt(hm[0]) + 12 + ":" + hm[1];
			}
		}
		// 24 to 12
		String[] hm = time.split(":");
		if (Integer.parseInt(hm[0]) > 12)
			return Integer.parseInt(hm[0]) - 12 + ":" + hm[1] + " pm";
		else if (Integer.parseInt(hm[0]) == 12)
			return time + " pm";
		else
			return time + " am";

	}

	int rySeq(int n, String s) {

		if (n == 0)
			return 0;

		int red = 1 + (n - 1) * 2;
		System.out.println("red " + red);
		if (s.equalsIgnoreCase("red"))
			return red;

		int all = red * n - (n - 1);
		System.out.println("all " + all);
		if (s.equalsIgnoreCase("all"))
			return all;

		int yellow = all - red;
		System.out.println("yellow" + yellow);
		if (s.equalsIgnoreCase("yellow"))
			return yellow;

		return -1;
	}

	int memeSum(int a, int b) {// 122 81
		String a1 = Integer.toString(a);
		String a2 = Integer.toString(b);
		String res = "";
		int len = 0;
		len = a1.length() > a2.length() ? a2.length() : a1.length();
		int rem = Math.abs(a1.length() - a2.length());
		if (a1.length() > a2.length()) {
			a2 = "0".repeat(rem) + a2;
		}
		if (a2.length() > a1.length()) {
			a1 = "0".repeat(rem) + a1;
		}
		String[] s1 = a1.split("");
		String[] s2 = a2.split("");
		if (s1.length == s2.length) {
			len = s1.length;
			for (int i = len - 1; i >= 0; i--) {
//				System.out.println(res);
				System.out.println(s1[i] + " + " + s2[i]);
				int s = Integer.parseInt(s1[i]) + Integer.parseInt(s2[i]);
				res = Integer.toString(s) + res;

			}
		}

		return Integer.parseInt(res);
	}

	int waysToClimb(int num) {
		if (num == 0)
			return 1;
		int[] n = new int[num + 1];
		n[0] = 1;
		n[1] = 1;
		for (int i = 2; i < n.length; i++) {
			n[i] = n[i - 1] + n[i - 2];
		}
		return n[num];
	}

	String expand(long num) {

		int counter = 0;
		String res = "";

		while (num > 0) {
			res = res + " " + Long.toString((long) ((num % 10) * Math.pow(10, counter)));
			num = num / 10;
			counter++;
		}
		String[] s = res.trim().split(" ");
		String result = s[s.length - 1];
		for (int i = s.length - 2; i >= 0; i--) {

			if (!s[i].equals("0")) {
				result = result + "+" + s[i];
			}

		}
		return result;
	}

	String isOdd(int number) {

		if ((number ^ 1) == (number - 1))
			return "Odd";
		return "Even";
	}

	String binaryConversion(String bin) {

		String result = "";

		for (int i = 0; i < bin.length(); i += 8) {
			int a = Integer.parseInt(bin.substring(i, i + 8), 2);
			result = result + (char) a;
		}
		return result;
	}

	double poundsToKilos(double pounds) {
		return pounds / 2.2;
	}

	double inchesToMeters(double inches) {
		return inches / 39.37;
	}

	String BMI(String weight, String height) {
		String[] w = weight.split(" ");
		String[] h = height.split(" ");
		double finalWeight = w[1].equalsIgnoreCase("pounds") ? poundsToKilos(Double.parseDouble(w[0]))
				: Double.parseDouble(w[0]);
		double finalheight = h[1].equalsIgnoreCase("inches") ? inchesToMeters(Double.parseDouble(h[0]))
				: Double.parseDouble(h[0]);

		System.out.println(finalWeight + " " + finalheight);
		double bmi = finalWeight / Math.pow(finalheight, 2);
		System.out.println(bmi);
		if (bmi < 18.5)
			return "underweight";
		if (bmi >= 18.5 && bmi <= 24.9)
			return "normal weight";
		if (bmi >= 25 && bmi <= 29.9)
			return "over weight";
		return "obesity";
	}

	String battleOutcome(int num) {

		String nTemp = Integer.toString(num);
		String n = nTemp.length() % 2 != 0 ? nTemp.substring(0, nTemp.length() - 1) : nTemp;
		String result = "";
		for (int i = 0; i < n.length(); i += 2) {
			String res = Integer.parseInt(n.charAt(i) + "") > Integer.parseInt(n.charAt(i + 1) + "")
					? n.charAt(i) + " wins. "
					: Integer.parseInt(n.charAt(i) + "") < Integer.parseInt(n.charAt(i + 1) + "")
							? n.charAt(i + 1) + " wins."
							: "tie";
			result = result + res;
		}
		if (nTemp.length() % 2 != 0)
			result = result + nTemp.substring(nTemp.length() - 1);
		return result;
	}

	String dolladollaBills(double money) {

		double val = new BigDecimal(money).setScale(2, RoundingMode.HALF_UP).doubleValue();
		NumberFormat format = NumberFormat.getCurrencyInstance();
		String money1 = format.format(val);
		return money1;
	}

	long closestPalindrome(int num) {
		swc = new StringWordCount();

		for (int i = num, j = num; j > 0; i++, j--) {

			if (swc.isPalindrome(Integer.toString(j)))
				return j;
			if (swc.isPalindrome(Integer.toString(i)))
				return i;
		}
		return 0;
	}

	String overTime(double[] arr) {
//		 BigDecimal bd = new BigDecimal(null)
		double start = arr[0];
		double end = arr[1];
		double rate = arr[2];
		double multiplier = arr[3];
		double overtime = 0;
		double totalShift = end - start;
		double NoOvertimeShift = end - start;
		double overtimeShift = 0;
		if (end > 17) {
			overtime = end - 17;
			NoOvertimeShift = 17 - start;
			overtimeShift = overtime;
		}

//		 System.out.println("NoOvertimeShift:"+NoOvertimeShift+ " overtimeShift"+overtimeShift);

		double wage = NoOvertimeShift * rate + (multiplier * rate) * overtimeShift;

		return new BigDecimal(wage).setScale(2, RoundingMode.HALF_UP).toString();
	}

	boolean happy(int num) {
		int res = 0;
		while (num > 9) {
			System.out.println(num);
			int result = 0;
			while (num > 0) {
				int temp = (int) Math.pow(num % 10, 2);
				result = result + temp;
				System.out.println("res " + result);
				num = num / 10;
			}
			num = result;
			res = result;
		}
		return res == 1;
	}

	String convertTemperature(String deg) {
		if (!deg.contains("*"))
			return "invalid";
		String[] str = deg.split("\\*");

		String result = str[1].equalsIgnoreCase("c")
				? Double.toString(Double.parseDouble(str[0]) * 1.8 + 32).concat("F")
				: Double.toString((Double.parseDouble(str[0]) - 32) / 1.8).concat("C");
		return result;
	}

	String javelinThrow(double v, int a) {
		double radians = Math.toRadians(a);

		double hight = (Math.pow(v, 2) * Math.pow(Math.sin(radians), 2)) / (2 * 9.8);
		return Double.toString(hight);
	}

	int carryDigits(int n1, int n2) {
		String sn1 = Integer.toString(n1);
		String sn2 = Integer.toString(n2);
		int len1 = sn1.length();
		int len2 = sn2.length();
		int rep = Math.abs(len2 - len1);
		if (len1 > len2)
			sn2 = "0".repeat(rep) + sn2;
		else
			sn1 = "0".repeat(rep) + sn1;
		int counter = 0;
		int carry = 0;
		System.out.println(sn1 + " " + sn2);
		for (int i = sn1.length() - 1; i >= 0; i--) {

			int a = Integer.parseInt(sn1.charAt(i) + "");
			int b = Integer.parseInt(sn2.charAt(i) + "");

			System.out.println(a + b + carry);
			if ((a + b + carry) > 9) {
				counter++;
				carry = 1;
			} else
				carry = 0;
		}
		return counter;
	}

	long sumOfDigits(long num) {
		long product = 0;
		while (num > 0) {
			product = product + (num % 10);
			num = num / 10;
		}
		return product;
	}

	int digitRoot(long n) {

		while (n > 9) {
			n = sumOfDigits(n);
		}
		return (int) n;
	}

	int productOfDigits(int num) {
		int product = 1;
		while (num > 0) {
			product = product * (num % 10);
			num = num / 10;
		}
		return product;
	}

	int bugger(int num) {

		int counter = 0;
		if (num < 10)
			return 0;
		while (num > 9) {
			num = productOfDigits(num);
			counter++;
		}
		return counter;
	}

	int numberOfPrimeNumbers(int num) {

		int counter = 0;
		for (int i = 2; i <= num; i++) {

			if (isPrime(i))
				counter++;

		}
		return counter;
	}

	int extractDigitFromNumber(int num) {

		if (num < 1)
			return 0;
		int i = 0;
		i = i + (num % 10) + extractDigitFromNumber(num / 10);
		return i;
	}

	boolean isHarshadRecursion(int n) {

		int sum = 0;
		sum = sum + extractDigitFromNumber(n);
		System.out.println(sum);
		return n % sum == 0;

	}

	boolean isFactorial(int n) {

		int p = 1;
		for (int i = 1; i <= n; i++) {
			p = p * i;
			if (p == n)
				return true;
		}
		return false;
	}

	// ab = sqrt(x2-x1)^2+(y2-y10)^2;
	double perimeter(int[][] point) {
		double ab = Math.sqrt(Math.pow((point[1][0] - point[0][0]), 2) + Math.pow((point[1][1] - point[0][1]), 2));
		double bc = Math.sqrt(Math.pow((point[2][0] - point[1][0]), 2) + Math.pow((point[2][1] - point[1][1]), 2));
		double ac = Math.sqrt(Math.pow((point[2][0] - point[0][0]), 2) + Math.pow((point[2][1] - point[0][1]), 2));

		return ab + bc + ac;
	}

	public int count(int n) {
		int num = Math.abs(n);
		int counter = 0;
		if (num <= 0)
			return 0;
		num = num / 10;
		counter = 1 + count(num);
		return counter;

	}

	boolean isCurzon(int n) {
		return ((int) Math.pow(2, n) + 1) % ((2 * n) + 1) == 0;
	}

	int persistence(int num) {
		int p = num;
		int counter = 0;
		while (p >= 10) {
			num = p;
			int product = 1;
			System.out.println(num);
			while (num > 0) {
				product = product * (num % 10);
				num = num / 10;
				p = product;
			}
			counter++;
		}
		return counter;
	}

	String percentageChanged(String oldPrice, String newPrice) {
		double op = Double.parseDouble(oldPrice.replace("$", ""));
		double np = Double.parseDouble(newPrice.replace("$", ""));

		double diff = Math.abs(np - op);
		double percent = (diff * 100) / op;
		BigDecimal bd = new BigDecimal(percent);
		int per = bd.setScale(0, RoundingMode.HALF_UP).intValue();
		return op > np ? per + "% decrese" : per + "% incerease";

	}

	int gcdOfArray(int[] array) {
		int gcd = findGCD(array[0], array[1]);
		for (int i = 2; i < array.length; i++) {
			gcd = findGCD(gcd, array[i]);
		}
		return gcd;
	}

	String expandedForm(int n) {
		String result = "";
		for (int i = 0; n > 0; i++) {
			int j = (n % 10) * (int) Math.pow(10, i);
			result = result + " " + j;
			n = n / 10;
		}
		String[] str = result.trim().split(" ");
//		Arrays.sort(str,Collections.reverseOrder());
//		return String.join("+",str);
		result = str[str.length - 1];
		for (int i = str.length - 2; i >= 0; i--) {
			if (str[i].equals("0"))
				continue;
			result = result + "+" + str[i];
		}

		return result;
	}

	int phi(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (findGCD(i, n) == 1)
				count++;
		}
		return count;
	}

	String primalStrength(int n) {

		int before = 0;
		int after = 0;
		for (int i = 0; i < n; i++) {
			if (isPrime(i))
				before = i;
		}
		for (int i = n + 1; i > 0; i++) {
			if (isPrime(i)) {
				after = i;
				break;
			}
		}
		System.out.println(before + " " + after);
		if ((after - n) == (n - before))
			return "balanced";
		if ((after - n) < (n - before))
			return "Strong";
		return "weak";
	}

	double lineLength3D(int[][] point) {

		int[] arr1 = point[0];
		int[] arr2 = point[1];

		double d = Math
				.sqrt(Math.pow(arr1[0] - arr2[0], 2) + Math.pow(arr1[1] - arr2[1], 2) + Math.pow(arr1[2] - arr2[2], 2));
		return d;
	}

	boolean isCentered(String str) {
		if (str.length() == 1)
			return true;
		String arr = str.replaceAll(" ", "");
		String[] result = str.split(arr);

		return result[0].length() == result[1].length();
	}

	int lunarSum(int number1, int number2) {

		String num1 = Integer.toString(number1);
		String num2 = Integer.toString(number2);
		int def = num1.length() > num2.length() ? num1.length() - num2.length() : num2.length() - num1.length();
		if (num2.length() > num1.length())
			num1 = "0".repeat(def) + num1;
		if (num1.length() > num2.length())
			num2 = "0".repeat(def) + num2;

		String result = "";

		for (int i = 0; i < num1.length(); i++) {
			String value = (int) num1.charAt(i) > (int) num2.charAt(i) ? num1.charAt(i) + "" : num2.charAt(i) + "";
			result = result + value;
		}
		return Integer.parseInt(result);
	}

	Object calculate(Object v, Object r, Object i) {

		String valid = (v.toString() + r.toString() + i.toString());
		String[] arr = valid.split("\\.");
		System.out.println(valid + " " + Arrays.toString(arr));
		if (valid.length() == 0 || arr.length != 3)
			return "invalid";

		double result = v.equals("") ? (double) r * (double) i
				: r.equals("") ? (double) v / (double) i : (double) v / (double) r;
		BigDecimal bd = new BigDecimal(result);

		return bd.setScale(2, RoundingMode.HALF_UP).doubleValue();

	}

	boolean allPrime(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1)
				return false;
			if (!isPrime(arr[i]))
				return false;
		}
		return true;
	}

	int anotherQuadSeq(int n) {
		int term = (int) ((3) * Math.pow(n, 2) - (1) * n + 2) / 2;
		if (n % 2 != 0)
			term += 1;
		return term;
	}

	int digitOccurrences(int min, int max, int digit) {
		int min1 = Math.abs(min);
		int max1 = Math.abs(max);
		if (min1 > max1) {
			int temp = min1;
			min1 = max1;
			max1 = temp;
		}
		int count = 0;
		for (int i = min1; i <= max1; i++) {
			char[] num = Integer.toString(i).toCharArray();
//			System.out.println(Arrays.toString(num));
			for (int j = 0; j < num.length; j++) {
				if (num[j] == Integer.toString(digit).charAt(0))
					count++;
			}
		}
		return count;
	}

	String isApocalyptic(int number) {

		BigInteger num = BigDecimal.valueOf(Math.pow(2, number)).toBigInteger();

		String numStr = num.toString();
		System.out.println(numStr);
		String endStr = numStr.replaceAll("666", "");
		int n = numStr.length() - endStr.length();
		if (n == 0)
			return "safe";
		int result = n / 3;
		System.out.println(result + " " + n);
		return result == 1 ? "single" : result == 2 ? "double" : "triple";

	}

	int shiftToRight(int x, int y) {

		return (int) (Math.floorDiv(x, (int) Math.pow(2, y)));
//		return x>>y;
	}

	int letterDistance(String str1, String str2) {

		int len = str1.length() < str2.length() ? str1.length() : str2.length();
		int distance = 0;
		for (int i = 0; i < len; i++) {
			distance = distance + Math.abs(str1.charAt(i) - str2.charAt(i));
		}
		return distance + Math.abs(str1.length() - str2.length());
	}

	double lineLength(int[][] point) {
		int[] arr1 = point[0];
		int[] arr2 = point[1];
		double result = Math.sqrt(Math.pow(arr1[0] - arr2[0], 2) + Math.pow(arr1[1] - arr2[1], 2));
		BigDecimal bd = new BigDecimal(result);
		return bd.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
	}

	long sortDesc(int num) {

		int n = 0;
//		int[] arr = new int[Integer.toString(num).length()];
		String[] arr = new String[Integer.toString(num).length()];
		int i = 0;
		while (num > 0) {
			arr[i] = Integer.toString(num % 10);
			num = num / 10;
			i++;
		}
		Arrays.sort(arr, Collections.reverseOrder());
		String result = "";
		for (int j = 0; j < arr.length; j++) {
			result = result + arr[j];
		}
		return Long.parseLong(result);
//				Integer.parseInt(result);
	}

	int addNums(String nums) {
		String[] numArr = nums.replaceAll(" ", "").split(",");
		int sum = 0;
		for (int i = 0; i < numArr.length; i++) {
			sum = sum + Integer.parseInt(numArr[i]);
		}
		return sum;
	}

	String moran(int n) {
		boolean isHrashad = false;
		boolean isMoran = false;
		String result = "neither";
		if (isHarshad(n))
			result = isMoran(n) ? "Moran" : "Harshad";
		return result;
	}

	private boolean isMoran(int n) {
		// TODO Auto-generated method stub
		int sum = 0;
		int num = n;
		while (n > 0) {
			sum = sum + n % 10;
			n = n / 10;
		}
		int num2 = num / sum;
		return isPrime(num2);
	}

	double blocks(int step) {

		int blocks = (int) Math.ceil(Math.pow(step, 2) / 2 + (11 * step) / 2 - 1);
		return blocks;

	}

	int powerRanger(int power, int min, int max) {

		int counter = 0;

		for (int i = 0; i <= max; i++) {
			double value = Math.pow(i, power);
			if (value >= min && value <= max)
				counter++;
		}
		return counter;
	}

	int reversedBinaryInteger(int n) {
		String binary = Integer.toBinaryString(n);
		StringBuilder sb = new StringBuilder(binary);
		binary = sb.reverse().toString();
		int i = Integer.parseInt(binary, 2);
		return i;
	}

	boolean isNarcissistic(int num) {
		int n = num;
		List<Integer> list = new ArrayList<>();
		while (n > 0) {
			list.add(n % 10);
			n = n / 10;
		}
		int result = 0;
		for (int i : list) {
			result = (int) (result + Math.pow(i, list.size()));
		}
		return result == num;
//		System.out.println(list);
//		int power =list.size();
//		int result = list.stream().map(i -> (int)Math.pow(i, power)).mapToInt(Integer::intValue).sum();
////		int[] res = list.stream().mapToInt(Integer::intValue).toArray();
////		System.out.println(Arrays.toString(res));
//		System.out.println(result);
//		return result==num;
	}

	int towerHanoi(int discs) {

		if (discs == 0)
			return 0;
		return (int) Math.pow(2, discs) - 1;

	}

	int primorial(int n) {
		int product = 1;
		int counter = 0;
		for (int i = 2; i > 0; i++) {
			if (isPrime(i)) {
				product *= i;
				counter++;
				if (counter == n)
					break;

			}
		}
		return product;
	}

	long oppositeHouse(long houseNo, long streetLen) {
		// eq (2*streetLen - (houseNo-1))
		return (2 * streetLen - (houseNo - 1));
	}

	int lcmNew(int n1, int n2) {

		if (n1 > n2) {
			int temp = n1;
			n1 = n2;
			n2 = temp;
		}
		if (n2 % n1 == 0)
			return n2;
		int i = n2 + 1;
		int result = 0;
		while (true) {
			if (i % n1 == 0 && i % n2 == 0) {
				result = i;
				break;
			}
			i++;
		}
		return result;
	}

	boolean isHarshad(int n) {

		int num = n;
		int sum = 0;
		while (num > 0) {
			sum = sum + num % 10;
			num = num / 10;
		}
		return n % sum == 0;
	}

	int nextPrime(int num) {
		int n = num;
		int counter = 0;
		int flag = 0;
		while (!isPrime(n)) {
			n = n + 1;
		}
		return n;
	}

	String toHex(String str) {

		char[] cArr = str.toCharArray();
		String hexStr = "";
		for (int i = 0; i < cArr.length; i++) {
			hexStr = hexStr + " " + Integer.toHexString((int) cArr[i]);
		}
		return hexStr.trim();

	}

	boolean isTriplet(int a, int b, int c) {
		int[] arr = { a, b, c };
		Arrays.sort(arr);
		return Math.pow(arr[0], 2) + Math.pow(arr[1], 2) == Math.pow(arr[2], 2);
	}

	int smallest(int digits, int value) {

		int n = (int) Math.pow(10, digits - 1);
		for (int i = n; i <= n + value; i++) {
			if (i % value == 0)
				return i;
		}
		return 0;
	}

	String oddsVsEvens(int num) {

		if (num == 0)
			return "even";
		int oddSum = 0, evenSum = 0;
		System.out.println(oddSum + " and " + evenSum);
		while (num > 0) {
			System.out.println(num);
			int n = num % 10;
			if (n % 2 == 0) {
				evenSum += n;
				num = num / 10;
				continue;
			}
			oddSum += n;
			num = num / 10;
		}
		if (oddSum == evenSum)
			return "equal";
		return oddSum > evenSum ? "odd" : "even";
	}

	boolean isAutomorphic(int n) {

		long squaredN = (long) Math.pow(n, 2);
		System.out.println(squaredN);
		int len = Integer.toString(n).length();
		int bottom = (int) Math.pow(10, len);
		return n == squaredN % bottom;

	}

	int numOfDigits(int num) {
		if (num == 0)
			return 1;
		if (num < 0)
			num = Math.abs(num);
		int counter = 0;
		while (num > 0) {
			num = num / 10;
			counter++;
		}
		return counter;
	}

	double myPi(int num) {

		BigDecimal bd = new BigDecimal(Math.PI).setScale(num, RoundingMode.HALF_UP);

		return bd.doubleValue();
	}

	int findGcd2(int n1, int n2) {

		if (n1 > n2) {
			int temp = n1;
			n1 = n2;
			n2 = temp;
		}
		while (n1 % n2 != 0) {
			int temp = n1 % n2;
			n1 = n2;
			n2 = temp;
		}
//		System.out.println(n2);
		return n2;

	}

	String inatorInator(String str) {

		return str.matches(".*[aeiouAEIOU]$") ? str + "-inator " + str.length() + "000"
				: str + "inator " + str.length() + "000";
	}

	int findLcm(int n1, int n2) {

		int lcm = 0;
		lcm = n1 > n2 ? n1 : n2;
		while (true) {
			if (lcm % n1 == 0 && lcm % n2 == 0) {
				break;
			}
			lcm++;
		}
		return lcm;
	}

	int[] numberSplit(int n) {
		int[] halves = new int[2];
		if (n % 2 == 0)
			halves[0] = halves[1] = n / 2;
		if (n % 2 != 0 && n < 0) {
			double half = Math.ceil(n / 2);
			halves[1] = (int) half;
			halves[0] = (int) half - 1;

		} else {
			double half = Math.ceil(n / 2);
			halves[1] = (int) half + 1;
			halves[0] = (int) half;
		}
		return halves;
	}

	String oddishOrEvenish(int num) {

		int sum = 0;
		while (num > 0) {
			sum = sum + (num % 10);
			num = num / 10;
		}

		return sum % 2 == 0 ? "evenish" : "oddish";

	}

	boolean parityAnalysis(int num) {

		int sum = 0;
		int num1 = num;
		while (num1 > 0) {
			sum += (num1 % 10);
			num1 = num1 / 10;
		}
		System.out.println(sum);
		System.out.println(num);
		if ((num % 2 == 0) && sum % 2 == 0)
			return true;

		if ((num % 2 != 0) && sum % 2 != 0)
			return true;
		return false;

	}

	double maxDistance(double fuel, double fuelUsage, int passengers, boolean airConditioner) {

		double fuelUsage1 = fuelUsage * (1 + passengers * 0.05);
		if (airConditioner)
			fuelUsage1 = fuelUsage1 * 1.1;

		return (fuel * 100) / fuelUsage1;

	}

	int centeredPantagon(int num) {
		// eq: (5n^2-5n+2)/2

		return (5 * num * num - 5 * num + 2) / 2;

	}

	int totalVolume(int[][] part) {
		int volume = 0;

		for (int i = 0; i < part.length; i++) {
			int mul = 1;
			for (int j = 0; j < part[i].length; j++) {
				mul = mul * part[i][j];
			}
			volume = volume + mul;
		}
		return volume;
	}

	double mean(int[] nums) {

		double mean = (double) Arrays.stream(nums).sum() / nums.length;
//		return mean;
		BigDecimal bd = new BigDecimal(mean).setScale(2, RoundingMode.HALF_UP);
		return bd.doubleValue();

	}

	int minutesToSeconds(String tm) {
		String[] str = tm.split(":");
		if (Integer.parseInt(str[1]) >= 60)
			return -1;
		return Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
	}

	String splitVowels(String str) {
		return str.replaceAll("[^aeiou]", "") + str.replaceAll("[aeiou]", "");
	}

	String rev(int n) {

		String num1 = Integer.toString(n).replaceAll("[\\D]", "");
		StringBuffer num = new StringBuffer(num1);
		num = num.reverse();
		return num.toString();
	}

	int spinAround(String[] turns) {
		int leftCounter = 0;
		int rightCounter = 0;
		int rotation = 0;

		for (String str : turns) {
			if (str.equals("left"))
				leftCounter++;
			if (str.equals("right"))
				rightCounter++;
		}

		rotation = Math.abs((leftCounter - rightCounter) / 4);
		return rotation;
	}

	int digitsCount(long n) {

		int counter = 0;
		while (n > 0) {
			n = n / 10;
			counter++;
		}
		return counter;
	}

	int highestDigit(int n) {

		String str = Integer.toString(n);
		char[] arr = str.toCharArray();
		Arrays.sort(arr);
		return Integer.parseInt(arr[arr.length - 1] + "");
	}

	int findGCD(int num1, int num2) {

		if (num1 < num2) {
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}
		if (num1 % num2 == 0)
			return num2;
		int temp = num1;
		num1 = num2;
		num2 = findGCD(num2, temp % num2);
		return num2;
	}

	boolean doesBrickFit(int a, int b, int c, int w, int h) {

		return w * h >= a * b || w * h >= a * c || w * h >= c * b;
	}

	int emptySq(int steps) {

		int totalSteps = (int) Math.pow(steps * 2, 2);
		int occupiedSq = steps * 4;
		return totalSteps - occupiedSq;

	}

	int rootQuadEq(int a, int b, int c) {

		return (int) ((-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a));

	}

	Object basicCalculator(int a, String o, int b) {
		if (o == "+")
			return a + b;
		if (o == "-")
			return a - b;
		if (o == "/") {
			return b == 0 ? null : a / b;
		}
		if (o == "*")
			return a * b;
		return null;
	}

	int simpleCalc(int num1, int num2, String op) {

		if (op.equals("add"))
			return num1 + num2;
		if (op.equals("sub"))
			return num1 - num2;
		if (op.equals("multiply"))
			return num1 * num2;
		if (op.equals("devide")) {
			if (num2 == 0)
				return Integer.MIN_VALUE;
			return num1 / num2;
		}
		return 0;
	}

	int countDigits(int num) {
		int counter = 0;
		while (num != 0) {
			counter++;
			num = num / 10;

		}

		return counter;

	}

	String maskNums(String str) {
		if (str.length() <= 4)
			return str;

		String lastFour = str.substring(str.length() - 4);
		String pound = "";
		for (int i = 0; i < str.length() - 4; i++) {
			pound = pound + "#";
		}

		return pound + lastFour;
	}

	String formatNumbers(int num) {

		NumberFormat myFromat = NumberFormat.getInstance();
		myFromat.setGroupingUsed(true);

		return myFromat.format(num);
	}

	int halveCounter(int num, int num1) {
		int counter = 0;
		while (num > num1) {
			num = num / 2;
			if (num < num1)
				break;
			System.out.println(num);
			counter++;
		}
		return counter;
	}

	int findMean(int num) {
		int sum = 0;
		int counter = 0;
		while (num > 0) {
			sum += num % 10;
			num = num / 10;
			counter++;
		}
		return sum / counter;
	}

	String tpChecker(int people, int numOfTp) {

		int days = (numOfTp * 500) / (people * 57);
		if (days < 5)
			return "Your TP will only last " + days + " days, buy more!";
		return "Your TP will last " + days + " days, no need to panic!";
	}

	boolean isPower2(int num) {

		double power = Math.log(num) / Math.log(2);
		System.out.println(power);
		return power == (int) power;
	}

	boolean isSymmetrical(int num) {

		StringBuilder numStr = new StringBuilder(Integer.toString(num));

		return numStr.toString().equals(numStr.reverse().toString());
	}

	boolean isPrime(int num) {
		if (num == 0)
			return false;
		if (num == 1)
			return false;
		for (int i = 2; i < num; i++)
			if (num % i == 0)
				return false;
		return true;
	}

	int[] amplifier4(int num) {

		int[] arr = new int[num];
		for (int i = 1; i <= num; i++) {
			int n = i;
			if (i % 4 == 0)
				n = i * 10;
			arr[i - 1] = n;
		}
		return arr;
	}

	int oneButtonMachine(String str) {

		int sum = 0;
		int startingValue = 96;

		for (int i = 0; i < str.length(); i++) {
			int charValue = str.charAt(i) - startingValue;
			sum = sum + charValue;
		}

		return sum;
	}

	String evenOddFactors(int num) {

		if (Math.sqrt(num) % 1 == 0)
			return "odd";

		return "even";
	}

	int fibonacciNumber(int index) {

		int[] fiboArr = new int[index + 1];
		fiboArr[0] = 1;
		fiboArr[1] = 1;
		for (int i = 2; i <= index; i++) {
			fiboArr[i] = fiboArr[i - 1] + fiboArr[i - 2];
		}
		System.out.println(Arrays.toString(fiboArr));
		return fiboArr[index];
	}

	long findLog(long base, long result) {
		long power = 0;

		power = (long) (Math.log(result) / Math.log(base));

		return power;
	}

	boolean largestInNumSwap(int num) {

		return num >= ((num % 10) * 10) + (num / 10);
	}

	ArrayList<Integer> evenNumberGenerater(int num) {

		ArrayList<Integer> evenList = new ArrayList();
		for (int i = 2; i <= num; i++) {
			if (i % 2 == 0)
				evenList.add(i);

		}
		return evenList;

	}

	boolean greaterThanOne(String str) {

//		String[] strs = str.split("/");
//		double upper = Double.parseDouble(strs[0]);
//		double down = Double.parseDouble(strs[1]);
		double upper = Double.parseDouble(str.substring(0, 1));
		double down = Double.parseDouble(str.substring(2));
		if (down == 0.0)
			return true;
		return upper / down > 1;

	}

	boolean timeForMK(GregorianCalendar date) {

		return (date.get(GregorianCalendar.MONTH) == 11 && date.get(GregorianCalendar.DAY_OF_MONTH) == 24);

	}

	boolean checkFactorChain(int[] arr) {
		int counter = 0;
		for (int i = 0; i < arr.length - 1; i++) {

			if (arr[i + 1] % arr[i] != 0) {
				counter++;
			}
		}

		return counter == 0;
	}

	long endCorona(int recovers, int dailyCases, int activeCases) {
		if (recovers == dailyCases)
			return -1;
		return (long) Math.ceil((double) activeCases / (recovers - dailyCases));
	}

	int findNan(Double[] arr) {
		int a = -1;
		for (int i = 0; i < arr.length; i++) {
//			if(arr[i].isNaN()) {
			if (Double.isNaN(arr[i])) {
				a = i;
				break;
			}
		}
		return a;
	}

	String binary(int num) {

		return Integer.toBinaryString(num);
	}

	int[] countSharpPlus(String str) {

		String noPlusText = str.replaceAll("\\+", "");
		System.out.println(noPlusText.length());

		return new int[] { noPlusText.length(), str.length() - noPlusText.length() };
	}

	int countOneBits(int num) {

		String binaryString = Integer.toBinaryString(num);
		System.out.println(binaryString);

		int sumOneBit = Integer.bitCount(num);

		return sumOneBit;
	}

	boolean sameAscii(String str1, String str2) {
		int str1int = 0;
		int str2int = 0;

		for (int i = 0; i < str1.length(); i++) {
			str1int += str1.charAt(i);
		}
		for (int i = 0; i < str2.length(); i++) {
			str2int += str2.charAt(i);
		}

		if (str1int == str2int)
			return true;
		return false;
	}

	int collatzConjecture(int num) {
		int steps = 1;
		int temp = 0;
		while (num != 1) {
			temp = num;
			if (num % 2 == 0) {
				num = num / 2;
				System.out.println(steps + ". " + temp + " is even - " + temp + "/2=" + num);
			} else {
				num = num * 3 + 1;
				System.out.println(steps + ". " + temp + " is odd - " + temp + "*3+1=" + num);
			}
			if (num != 1)
				steps++;
		}
		return steps;
	}

	int programmers(int a, int b, int c) {

		int max = a > b ? Math.max(a, c) : Math.max(b, c);
		int min = a < b ? Math.min(a, c) : Math.min(b, c);

		return max - min;
	}

	int equal(int a, int b, int c) {
		int counter = 0;
		if (a == b)
			counter++;
		if (b == c)
			counter++;
		if (a == c)
			counter++;
		if (counter > 0 && counter < 3)
			counter++;
		return counter;
	}

	int triangle(int n) {
		int a = 0;
		for (int i = 1; i <= n; i++) {
			a = a + i;
		}
		return a;
	}
	// 1 3 6 10 15

	int discount(int price, int discount) {

		return (discount * price) / 100;

	}

	double calc(double a, char b, double c) {

		double i = 0;

		switch (b) {
		case '+':
			i = a + c;
			break;
		case '-':
			i = a - c;
			break;
		case '*':
			i = a * c;
			break;
		case '/':
			i = c == 0 ? 0 : a / c;
			break;
		default:
			break;
		}
		return i;
	}

	public static void main(String[] args) {
		TriangleDots td = new TriangleDots();
//		Double[] arr = {Double.NaN,  1.0, 2.0, 3.0, 4.0};
//		int[] arr = {3, 3, 3, 3, 3}; 
//		int[][] arr = { { 1, 1, 1 } };
		String[] str = { "left", "left", "left", "left", "left", "left" };

//		System.out.println(Arrays.toString(td.numberSplit(-11)));
//		System.out.println(td.oddishOrEvenish(4433));
//		System.out.println(td.parityAnalysis(131));
//		System.out.println(td.maxDistance(36.1, 8.6, 3, true));
//		System.out.println(td.centeredPantagon(10));
//		System.out.println(td.totalVolume(arr));
//		System.out.println(td.mean(arr));
//		System.out.println(td.splitVowels("What's the time?"));
//		System.out.println(td.minutesToSeconds("10:00"));
//		System.out.println(td.rev(-1234556));
//		System.out.println(td.spinAround(str));
//		System.out.println(td.digitsCount(121317));
//		System.out.println(td.highestDigit(377401));
//		System.out.println(td.findGCD(34, 51));
//		System.out.println(td.doesBrickFit(1, 2, 2, 1, 1));
//		System.out.println(td.emptySq(10));
//		System.out.println(td.rootQuadEq(1, -12, -28));

//		System.out.println(td.basicCalculator(10, "/", 0));

//		System.out.println(td.simpleCalc(100, 3, "devide"));
//		System.out.println(td.countDigits(-92563));

//		System.out.println(td.maskNums("1231234"));

//		System.out.println(td.formatNumbers(1000598965));
//		System.out.println(td.halveCounter(1000, 3));

//		System.out.println(td.tpChecker(4, 12));
//		System.out.println(td.findMean(666));
//		System.out.println(td.isPower2(20));
//		System.out.println(td.isPrime(9999991));
//		System.out.println(td.isSymmetrical(1112111));
//		System.out.println(Arrays.toString(td.amplifier4(25)));

//		System.out.println(td.oneButtonMachine("qudusayo"));
//		System.out.println(td.evenOddFactors(400));
//		System.out.println(td.fibonacciNumber(12));
//		GregorianCalendar date =new GregorianCalendar(3000, 11, 24);

//		System.out.println(td.findLog(9, 3486784401L));
//		System.out.println(td.largestInNumSwap(99));
//		System.out.println(td.evenNumberGenerater(0));
//		System.out.println(td.greaterThanOne("3/2"));
//		System.out.println(td.timeForMK(date));
//		System.out.println(td.endCorona(3000, 2000, 50699));
//		System.out.println(td.checkFactorChain(arr));
//		System.out.println(td.findNan(arr));
//		System.out.println(td.countOneBits(25531));

//		System.out.println(td.binary(123456787));
//		System.out.println(Arrays.toString(td.countSharpPlus("")));

//		System.out.println("steps: "+td.collatzConjecture(100));

//		System.out.println(td.sameAscii("a", ""));

//		td.triangle(6);

//		System.out.println(td.calc(20, '/', 10));

////		System.out.println(td.equal(4, 0, 1));
//		System.out.println(td.programmers(147, 33, 526));
//		System.out.println(td.programmers(33, 72, 74));
//		System.out.println(td.programmers(1, 5, 9));

//		System.out.println(td.findLcm(102, 2));
//		System.out.println(td.inatorInator("Shrek"));
//		System.out.println(td.findGcd2(6, 31));
//		System.out.println(td.myPi(15));
//		System.out.println(td.numOfDigits(-2147483647));
//		System.out.println(td.isAutomorphic(76));
//		System.out.println(td.oddsVsEvens(54870));
//		System.out.println(td.smallest(3,77));
//		System.out.println(td.isTriplet(80, 48, 64));

//		System.out.println(td.toHex("Marty Poppinson"));
//		System.out.println(td.isHarshad(200));
//		System.out.println(td.lcmNew(3, 12));
//		System.out.println(td.oppositeHouse(10, 22));
//		System.out.println(td.primorial(8));
//		System.out.println(td.towerHanoi(9));
//		System.out.println(td.isNarcissistic(92727));
//		System.out.println(td.reversedBinaryInteger(446));
//		System.out.println(td.powerRanger(4, 250, 1300));
//		System.out.println(td.blocks(46));
//		System.out.println(td.moran(20937));
//		System.out.println(td.addNums("10"));
//		System.out.println(td.sortDesc(289327560));
//		int[][] arrtemp = {{-11,-12},{-13,-14}};
//		System.out.println(td.lineLength(arrtemp));
//		System.out.println(td.letterDistance("abcde", "bcdef"));
//		System.out.println(td.shiftToRight(-512, 10));
//		System.out.println(td.isApocalyptic(931));
//		System.out.println(td.digitOccurrences(-500, -45, 4));
//		System.out.println(td.anotherQuadSeq(99));
//		System.out.println(td.allPrime(new int[] {1, 5, 3 }));
//		System.out.println(td.calculate(46.6, "", 54.4));
//		System.out.println(td.lunarSum(36602, 696));
//		System.out.println(td.isCentered("1"));
//		int[][] arrNew = new int[2][3];
//		arrNew[0][0] = 15;
//		arrNew[0][1] = 7;
//		arrNew[0][2] = 5;
//		arrNew[1][0] = 22;
//		arrNew[1][1] = 11;
//		arrNew[1][2] = 1;
//		System.out.println(td.lineLength3D(arrNew));

//		System.out.println(td.primalStrength(1493));
//		System.out.println(td.phi(33));
//		System.out.println(td.expandedForm(1010));
//		System.out.println(td.gcdOfArray(new int[]{20,20,40,100}));
//		System.out.println(td.percentageChanged("$100", "$950"));
//		System.out.println(td.persistence(6788));
//		System.out.println(td.isCurzon(41));
//		System.out.println(td.count(65432109));
//		int[][] arr = new int[3][2];
//		arr[0][0] = 7;
//		arr[0][1] = 6;
//		arr[1][0] = 0;
//		arr[1][1] = 11;
//		arr[2][0] = 0;
//		arr[2][1] = -3;
//		System.out.println(td.perimeter(arr));
//		System.out.println(td.isFactorial(120));
//		System.out.println(td.isHarshadRecursion(23));
//		System.out.println(td.numberOfPrimeNumbers(1000));
//		System.out.println(td.bugger(25));
//		System.out.println(td.digitRoot(3612376363612876636L));
//		System.out.println(td.carryDigits(696, 414));
//		System.out.println(td.javelinThrow(51.3, 20));
//		System.out.println(td.convertTemperature("19"));
//		System.out.println(td.happy(110));
//		System.out.println(td.overTime(new double[] {11.5, 19, 40, 1.8}));
//		System.out.println(td.closestPalindrome(27));
//		System.out.println(td.dolladollaBills(-56.99));
//		System.out.println(td.battleOutcome(78925));
//		System.out.println(td.BMI("154 pounds", "2 meters"));
//		System.out.println(td.binaryConversion("0010000101000000001000110010010000100101010111100010011000101010001010000010100101010001010101110100010101110010011101000111100101010101010010010100111101001100011001000110011001100111011000100110001001101000011011100110110101001001010010110100001001001010010010110100100001001001010101010100111100101000001111110011111000111111001111000111111001111110011111100111111001111110001010010010100000101010001001100010010101011110001110010011100000110111001100010011001100101111001011010010111100101010001011010010101000101111"));
//		System.out.println(td.isOdd(16));		
//		System.out.println(td.expand(50050));
//		System.out.println(td.waysToClimb(6));
//		System.out.println(td.memeSum(49999, 49999));
//		System.out.println(td.rySeq(28, "yellow"));
//		System.out.println(td.convertTime("12:00 am"));
//		System.out.println(td.isPowerful(674));
//		System.out.println(td.isRightAngle(new int[] {20, 20, 20, 20}, "angle"));
//		System.out.println(td.periodic("0000001"));
//		System.out.println(td.photograph(new int[] {3, 1, 4, 1, 5, 9, 2, 6}));
//		System.out.println(td.sameLength("1111000010101100"));
//		System.out.println(td.closingInSum(121));
//		System.out.println(td.trouble(444, 44));
//		System.out.println(td.simplify("300/200"));
//		System.out.println(td.logarithm(1, "Hi!".length() ));
//		System.out.println(td.sumOfHoles(12345));
//		System.out.println(td.sharedDigits(new int[] {5, 55, 665, 4444, 65, 66, 76, 78, 989}));
//		System.out.println(td.isBrilliant(768017));
//		System.out.println(td.happyAlgorithm(9331));
//		System.out.println(td.lcmOfThree(new int[] {19, 47, 43}));
//		System.out.println(Arrays.toString(td.goldbachConjecture(100000)));
//		System.out.println(td.digitsCountRecursive(3463463874638476L));
//		System.out.println(Arrays.toString(td.isExact(125)));
//		System.out.println(td.roundabout(6, 250));
//		System.out.println(td.secret(52));?
//		System.out.println(td.multiply(4,0));
//		System.out.println(td.halveCount(1000, 3));
//		System.out.println(td.swapCards(74, 81));
//		System.out.println(td.isAutobiographical(2100));
//		System.out.println(td.easterDate(3535));
//		System.out.println(td.gapful(103));
//		System.out.println(td.isUndulating(85856 ));
//		System.out.println(td.NumberOfDays(2050, 1200, 10));
//		System.out.println(td.sumDigProd(111111111));
//		System.out.println(td.additivePersistence(6788));
//		square a =  (x)->{ return Math.pow(x, 2);};
//		System.out.println(a.doSquare(2));
//		System.out.println(td.incDec(6));
//		System.out.println(td.gcdOfArray(new int[] {120, 300, 95, 425, 625}));
//		System.out.println(td.squares(1, 1000000000));
//		System.out.println(td.ecgSequenceIndex(7));
//		System.out.println(td.isHappy(3970));
//		System.out.println(td.lcmOfArray(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
//		System.out.println(td.validateCard(36717601781975L));
//		System.out.println(td.getLuckyNumber(350, 27));
//		System.out.println(td.addStrNums("1", "2"));
//		System.out.println(td.lookAndSay(231));
//		System.out.println(td.truncatablePrime(6043));
//		System.out.println(td.sumwithTwist("94", "16"));
//		System.out.println(td.bitRotate(17, 2, false));
//		System.out.println(td.actualMemorySize("8GB"));
//		System.out.println(td.maxPossible(12345, 4));
//		System.out.println(td.postfix("5"));
//		System.out.println(td.titleToNumber("KFC"));
//		try {
//			System.out.println(td.dayOfYear("02/29/1600"));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(td.isbn13("0316066524"));
//		System.out.println(td.takeDownAveragBy5(new String[] {"53%", "79%"}));
//		System.out.println(td.isLeapYear(2016));
//		System.out.println(td.split25(20));
//		System.out.println(td.isHappyRecursion(8888));
//		System.out.println(Arrays.toString(td.extractPrimes(10234)));
//		System.out.println(td.maxProduct(new int[] {-8, 1, 2, 7, 9}));
//		System.out.println(td.minProduct(new int[] {-5, -3, -1, 0, 4}));
//		System.out.println(td.isHeteromecic(156));
//		System.out.println(td.getLuckiest(new int[] {515, 1255, -55,  1}));
//		System.out.println(td.validateTheRelationships("3<19>-19>5>=-19"));
//		System.out.println(td.productOfPrimes(2059));
//		System.out.println(td.isDisarium(598));
//		System.out.println(td.kaprekar(101));
//		System.out.println(td.whoGoesFree(7, 3));
//		System.out.println(td.superDigit("9875", 4));
//		System.out.println(td.palindromeDescendant(1122332211));
//		System.out.println(td.ascending("444445"));
//		System.out.println(td.cFuge(21, 18));
//		System.out.println(td.multiplyBy11WithTwist("9473745364784876253253263723"));
		System.out.println(td.weighOnMars(100)+"kg");

	}

}
//interface square{
//	double doSquare(int x);
//}
