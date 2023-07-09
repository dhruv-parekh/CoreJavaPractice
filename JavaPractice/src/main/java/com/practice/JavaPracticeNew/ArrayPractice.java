package com.practice.JavaPracticeNew;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Array;
import java.text.NumberFormat;
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
import java.util.Optional;
import java.util.TreeSet;

import com.practice.classes.Chapter;

public class ArrayPractice {
	
	
	boolean cannotCapture(int[][] b) {

		for (int i = 0; i < 8; i++) {

			for (int j = 0; j < 8; j++) {
				if(b[i][j] == 1) {
				if (i - 2 >= 0 && j + 1 < 8 && b[i - 2][j + 1] == 1) return false;
				if (i + 2 <8 && j + 1 < 8 && b[i + 2][j + 1] == 1) return false;
				if (i - 2 >= 0 && j -1 >=0 && b[i - 2][j - 1] == 1) return false;
				if (i + 2 <8 && j -1 >=0 && b[i + 2][j -1] == 1) return false;
				if (i - 1 >= 0 && j + 2 < 8 && b[i - 1][j + 2] == 1) return false;
				if (i - 1 >= 0 && j -2 >=0 && b[i - 1][j -2] == 1) return false;
				if (i +1 <8 && j + 2 < 8 && b[i +1][j + 2] == 1) return false;
				if (i + 1 <8 && j -2 >=0 && b[i +1][j -2] == 1) return false;
				}
			}
		}
		return true;
	}

	Object[] flatten(Object[] arr) {

		return flattenSideMethod(arr).toArray();

	}

	private List<Object> flattenSideMethod(Object[] arr) {
		List<Object> result = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] instanceof Object[]) {
				result.addAll(flattenSideMethod((Object[]) arr[i]));
			} else
				result.add(arr[i]);
		}

		return result;
	}

	int[] numSplit(int n) {
		int[] result = new int[Integer.toString(Math.abs(n)).length()];
		int i = result.length - 1;
		int pow = 0;
		while (n != 0) {
			result[i] = (n % 10) * ((int) Math.pow(10, pow));
			pow++;
			i--;
			n = n / 10;
		}
		return result;
	}

	String[] sortWithoutArticles(String[] bands) {

		HashMap<String, String> hm = new HashMap<>();
		String temp = "";
		for (int i = 0; i < bands.length; i++) {
			temp = bands[i].replaceAll("The ", "").replaceAll("An ", "").replaceAll("A ", "");
			hm.put(temp, bands[i]);
			bands[i] = temp;
		}
		Arrays.sort(bands);
		String[] result = new String[bands.length];
		for (int i = 0; i < bands.length; i++) {
			result[i] = hm.get(bands[i]);
		}
		return result;
	}

	int[] quadSequence(int... args) {
		List<Integer> list = new ArrayList<>();
		int len = args.length;
		for (int i = 0; i < len - 1; i++) {
			list.add(args[i + 1] - args[i]);
		}
		int baseDifference = list.get(0);
		int secondLevelDiff = list.get(1) - list.get(0);
		System.out.println("base:" + baseDifference + " second:" + secondLevelDiff);
		int multiplier = len - 1;
		int[] result = new int[len];
		int temp = args[len - 1];
		for (int i = 0; i < len; i++) {
			result[i] = temp + (baseDifference + (multiplier * secondLevelDiff));
			multiplier++;
			temp = result[i];
		}
		return result;
	}

	int[] twoProduct(Integer[] arr, int n) {
		int[] res = { 0, 0 };

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0)
				return new int[] {};
			int a = n / arr[i];
			double b = (double) n / arr[i];
			System.out.println(arr[i] + " " + n);
//			System.out.println(a+" "+b+" "+(a instanceof Integer));
			if (a == b) {
				res[0] = arr[i];
				for (int j = 0; j < arr.length; j++) {
					if (arr[j].equals(a)) {
						res[1] = arr[j];
						break;
					}
//					System.out.println(Arrays.toString(res));
				}
				if (res[1] != 0)
					break;

			}
		}
		if (res[1] == 0)
			return new int[] {};

		return res;
	}

	int[] inclusiveArrayNew(int startNum, int endNum) {
		int[] arr = new int[Math.max(0, endNum - startNum) + 1];

		return helperMethod(startNum, 0, endNum, arr);
	}

	int[] helperMethod(int startNum, int idx, int endNum, int[] arr) {
		arr[idx] = startNum;
		if (startNum >= endNum)
			return arr;
		return helperMethod(startNum + 1, idx + 1, endNum, arr);
	}

//	 int[] inclusiveArrayNew(int startNum,int endNum) {
//		if(startNum >= endNum) return new int[] {startNum};
//		int[] temp = inclusiveArrayNew((startNum+=1), endNum);
//		int[] returnArr = new int[(temp.length + 1)];
//		returnArr[0] = startNum - 1;
//		for(int i=0;i<temp.length;i++) returnArr[i+1] = temp[i];
//		System.out.println(Arrays.toString(returnArr));
//		return returnArr;
//  }
//		

	int[][] increment(int r, int c, String[] arr) {
		int[][] a = new int[r][c];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				a[i][j] = 0;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			String s = arr[i];
			int fst = Integer.parseInt(s.substring(0, 1));
			String lst = s.substring(1);
			if (lst.equals("r")) {
				for (int p = 0; p < r; p++) {
					if (p == fst) {
						for (int j = 0; j < c; j++) {

							a[p][j] += 1;
						}
					}
				}
			} else {
				for (int p = 0; p < r; p++) {
					for (int j = 0; j < c; j++) {
						if (j == fst) {
							a[p][j] += 1;
						}
					}
				}
			}

		}

		return a;
	}

	int longestRun(int[] arr) {
		int result = 1;
		int inc = 1;
		int dec = 1;
		int inctemp = 1;
		int dectemp = 1;
//		int t=0;
		for (int i = 0; i < arr.length - 1; i++) {

			inc = ((arr[i] + 1) == arr[i + 1]) ? ++inc : 1;
			dec = ((arr[i] - 1) == arr[i + 1]) ? ++dec : 1;
			inctemp = inctemp > inc ? inctemp : inc;
			dectemp = dectemp > dec ? dectemp : dec;
			System.out.println(inctemp + " " + dectemp);
		}
		result = inctemp > dectemp ? inctemp : dectemp;
//		if(result<t)result=t;
		return result;
	}

	String[] sameVowelGroup(String[] words) {
		List<String> list = new ArrayList<>();
		String main = words[0].toLowerCase().replaceAll("[^aeiou]", "");
		list.add(words[0]);
		for (int i = 1; i < words.length; i++) {
			int c = 0;
			String temp = words[i].toLowerCase().replaceAll("[^aeiou]", "");
			for (int j = 0; j < temp.length(); j++) {
				if (!main.contains(temp.charAt(j) + ""))
					break;
				c++;
				if (c == temp.length())
					list.add(words[i]);
			}
		}
		return list.toArray(new String[list.size()]);
	}

	String wordprocessor(int n, int k, String e) {
		String[] a = e.split(" ");
		String result = "";
		String temp = "";
		for (int i = 0; i < a.length; i++) {
			if (temp.length() + a[i].length() <= k) {
				temp += " " + a[i];
				temp = temp.trim();
			} else {
				result = result + temp + "\n";
				temp = a[i];
			}
			if (i == a.length - 1 && temp.length() <= k)
				result = result + temp + "\n";
		}
		return result;
	}

	String nearestChapter(Chapter[] chapter, int page) {
		int index = 0;
		Map<Integer, String> map = new HashMap<>();
		for (int i = 0; i < chapter.length; i++) {
			map.put(chapter[i].getPage(), chapter[i].getName());
		}
		for (int i = page, j = page; i > 0; i++, j--) {
			if (map.containsKey(i))
				return map.get(i);
			if (j > 0 && map.containsKey(j))
				return map.get(j);
			index++;
		}
		return "invalid";
	}

	int[] selReverse(int[] lst, int length) {
		int[] a = new int[lst.length];
		if (lst.length < length) {
			for (int i = lst.length - 1, j = 0; i >= 0; i--, j++) {
				a[j] = lst[i];
			}
		} else {
			int i = 0;
			for (int n = 0; n < lst.length; n += length) {
				for (int j = n + length - 1; j >= n; j--) {
					if (j < lst.length) {
						a[i++] = lst[j];
					}
				}
			}
		}
		return a;
	}

	boolean allTruthy(Object... values) {
		List<Object> list = List.of("", Float.NaN, Float.POSITIVE_INFINITY, false, 0, Double.NaN,
				Double.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
		for (int i = 0; i < values.length; i++) {
			if (list.contains(values[i]))
				return false;
		}
		return true;
	}

	Object[] charAtPosNew(Object[] arr, String par) {
		List<Object> list = new ArrayList<>();
		for (int i = arr.length - 1; i >= 0; i--) {
			if (par.equals("odd") && (i + 1) % 2 == 0) {
				list.add(arr[i]);
				continue;
			}
			if (par.equals("even") && (i + 1) % 2 != 0) {
				list.add(arr[i]);
			}
		}
		Collections.reverse(list);
		return list.toArray();
	}

	String generateString(int n, String[] s) {
		if (n < 3)
			return "invalid input";
		String[] result = new String[n];
		result[0] = s[0];
		result[1] = s[1];
		for (int i = 2; i < n; i++) {
			result[i] = result[i - 1] + result[i - 2];

		}
		return String.join(" ", result);
	}

	String[] sortContacts(String[] arr, String sortBy) {

		if (arr == null || arr.length == 0)
			return new String[] {};

		if (sortBy.equalsIgnoreCase("asc")) {
			Arrays.sort(arr, new Comparator<String>() {
				public int compare(String str1, String Str2) {
					String s1 = str1.split(" ")[1];
					String s2 = Str2.split(" ")[1];
					return s1.compareTo(s2);
				}
			});
		} else {
			Arrays.sort(arr, new Comparator<String>() {
				public int compare(String str1, String Str2) {
					String s1 = str1.split(" ")[1];
					String s2 = Str2.split(" ")[1];
					return s2.compareTo(s1);
				}
			});
		}
		return arr;

	}

	int wrongNumber(int[][] m) {

		int[] row = new int[4];
		int[] col = new int[4];
		int cn = 0;
		// row
		for (int i = 0; i < m.length; i++) {
			int rsum = 0;
			for (int j = 0; j < m[i].length - 1; j++) {
				rsum += m[i][j];
			}
//			System.out.println(rsum + " " + m[i][3]);
			if (rsum != m[i][3]) {
				row = m[i];
				break;
			}
		}
//		System.out.println(Arrays.toString(row));
		// column
		for (int i = 0; i < m.length; i++) {
			int csum = 0;
			for (int j = 0; j < m[i].length; j++) {
				if (j != 3) {
					csum += m[j][i];
				}
				col[j] = m[j][i];
			}
//			System.out.println(csum + " col: " + col[3]);
			if (csum != col[3]) {
				cn = i;
				break;
			}
		}
//		System.out.println(Arrays.toString(col) + " and " + cn);

		int sum = 0;

		// if last number is wrong in row or column
		if (cn == 3) {
			for (int i = 0; i < row.length - 1; i++) {
				if (i != cn) {
					sum += row[i];
				}
			}
			return sum;
		}

		// for any other number wrong than last number in row or column
		for (int i = 0; i < row.length - 1; i++) {
			if (i != cn) {
				sum += row[i];
			}
		}
		return row[3] - sum;
	}

	String[] collect(String s, int n) {
		List<String> list = new ArrayList<>();
		int i = 0;
		while (i < s.length()) {
			if ((i + n) > s.length()) {
//				if(s.substring(i+n).length()==n)
//				list.add(s.substring(i+n));
				break;
			}
			list.add(s.substring(i, i + n));
			i = i + n;
		}
		Collections.sort(list);
		return list.toArray(new String[list.size()]);
	}

	int[] returnUnique(int[] n) {
		if (n.length == 0)
			return new int[] {};
		LinkedHashSet<Integer> set = new LinkedHashSet<>();
		int[] a = new int[2];
		LinkedHashMap<Integer, Integer> hm = new LinkedHashMap();
		for (int i = 0; i < n.length; i++) {

			if (hm.get(n[i]) == null)
				hm.put(n[i], 1);
			else {
				int c = hm.get(n[i]);
				hm.put(n[i], c + 1);
			}
			System.out.println(n[i] + " " + hm.get(n[i]));
			set.add(n[i]);
		}
		int i = 0;
		System.out.println(set);
		System.out.println(hm);
		for (Integer value : set) {
			Integer j = hm.get(value);
			if (j == 1) {
				a[i] = value;
				i++;
			}
		}
		return a;
	}

	Object[] charAtPos(Object[] arr, String par) {
		List<Object> list = new LinkedList<>();
		int start = par.equals("even") ? arr.length - 2 : arr.length - 1;

		for (int i = start; i >= 0; i = i - 2) {
			list.add(arr[i]);
		}
		Collections.reverse(list);
		return list.toArray();
	}

	Object[] flipArray(Object[] arr) {
		if (arr.length == 0)
			return new Object[] {};
		if (arr[0].getClass().isArray()) {
			Object[] a = new Object[arr.length];
			for (int i = 0; i < arr.length; i++) {
				a[i] = ((Object[]) arr[i])[0];
			}
			return a;
		}
		Object[][] b = new Object[arr.length][1];
		for (int i = 0; i < arr.length; i++) {
			b[i][0] = arr[i];
		}
		return b;
	}

	String highestPair(String[] arr) {
		List<String> s = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (s.contains(arr[i]))
				return arr[i];
			s.add(arr[i]);
		}
		return "";
	}

	String transpose(String[][] m) {
		String result = "";
		for (int i = 0; i < m[0].length; i++) {
			for (int j = 0; j < m.length; j++) {
				result = result + " " + m[j][i];
			}
		}
		return result.trim();
	}

	int findFulcrum(int[] arr) {
		List<Integer> list = new LinkedList<>();

		for (int i = 1; i < arr.length; i++) {
			int sumleft = 0;
			int sumright = 0;
			// left
			for (int j = 0; j < i; j++) {
				sumleft = sumleft + arr[j];
			}
			System.out.println("left:" + sumleft);
			// right
			for (int k = i + 1; k < arr.length; k++) {
				sumright = sumright + arr[k];
			}
			System.out.println("right:" + sumright);
			if (sumleft == sumright)
				list.add(arr[i]);
		}
		if (list.size() == 0)
			return -1;
		return list.get(0);
	}

	String sentenceSearcher(String s, String w) {
		String[] str = s.toLowerCase().split("\\.");
		for (int i = 0; i < str.length; i++) {
			if (str[i].contains(w.toLowerCase()))
				return str[i] + ".";
		}
		return "";
	}

	int[][] pairs(int[] arr) {
		if (arr.length == 0)
			return new int[][] {};
		int n = 0;
		if ((arr.length % 2 == 0))
			n = arr.length / 2;
		else
			n = arr.length / 2 + 1;
		System.out.println(n);
		int[][] p = new int[n][2];
		for (int i = 0, j = arr.length - 1; i < n; i++, j--) {
//			System.out.println(n+" "+arr.length);
//			System.out.println(i+" "+j); 
			p[i] = new int[] { arr[i], arr[j] };
//			System.out.println(Arrays.toString(p[i]));
		}
		return p;
	}

	int[] characterMapping(String str) {
		LinkedList<Character> list = new LinkedList<>();
		int[] res = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			if (!list.contains(str.charAt(i)))
				list.add(str.charAt(i));
			res[i] = list.indexOf(str.charAt(i));
		}
		return res;
	}

	boolean uniquely(String[] a, String[] w) {

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < w.length; j++) {
				if (i == j)
					continue;
				if (w[j].startsWith(a[i]))
					return false;
			}
		}
		return true;
	}

	Object[][] peelLayer(Object[][] arr) {

		Object[][] result = new Object[arr.length - 2][arr[0].length - 2];

		for (int i = 1; i < arr.length - 1; i++) {
			for (int j = 1; j < arr[i].length - 1; j++) {
				System.out.println(i + " " + j);
				result[i - 1][j - 1] = arr[i][j];
			}
		}

		return result;

	}

	String printGrid(int rows, int cols) {

		String result = "";
		int a = 0;
		for (int i = 1; i <= rows; i++) {
			int temp = i;
			for (int j = 0; j < cols; j++) {
				result = result + Integer.toString(temp) + " ";
				temp = temp + rows;
			}
			result += "\n";
		}
		return result;
	}

	boolean luckySeven(int[] r) {
		for (int i = 0; i < r.length; i++) {
			for (int j = 0; j < r.length; j++) {
				if (i == j)
					continue;
				for (int k = 0; k < r.length - 1; k++) {
					if (j == k || i == k)
						continue;
					System.out.println(r[i] + " " + r[j] + " " + r[k]);
					if (r[i] + r[j] + r[k] == 7)
						return true;
				}
			}
		}
		return false;
	}

	boolean canBuild(String[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			if (!(arr[i + 1].length() - arr[i].length() == 1) || !(arr[i + 1].contains(arr[i])))
				return false;

		}
		return true;
	}

	int getValuer(Object a) {

		if (a instanceof Integer) {
			return (int) a;

		} else
			return ((int[]) a)[0];
	}

	Object[] sortIt(Object[] arr) {

		for (int j = 0; j < arr.length - 1; j++) {
			for (int i = 0; i < arr.length - 1; i++) {

				if (getValuer(arr[i + 1]) < getValuer(arr[i])) {
					Object temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}

			}
		}
		return arr;

	}

	String[] filterArray(String[] str) {

		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < str.length; i++) {
			if (str[i].matches("[0-9]+"))
				set.add(str[i]);
		}
		String[] str1 = set.toArray(new String[set.size()]);
		return str1;
	}

	String mineralFormation(int[][] form) {
		int[] first = form[0];
		int[] last = form[form.length - 1];

		HashSet<Integer> setFirst = new HashSet<>();
		HashSet<Integer> setLast = new HashSet<>();

		for (Integer i : first)
			setFirst.add(i);
		for (Integer i : last)
			setLast.add(i);
		return setFirst.contains(1) && setLast.contains(1) ? "both"
				: setFirst.contains(1) && setLast.contains(0) ? "stalactites" : "stalagmites";
	}

	int[] reorderDigits(int[] arr, String orderBy) {

		int[] result = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			String[] s = Integer.toString(arr[i]).split("");
			for (int j = 0; j < s.length; j++) {
				if (orderBy.equalsIgnoreCase("asc"))
					Arrays.sort(s);
				if (orderBy.equalsIgnoreCase("desc"))
					Arrays.sort(s, Collections.reverseOrder());
			}
			result[i] = Integer.parseInt(String.join("", s));
		}
		return result;
	}

	int[] getCoinBalances(String[] r, String[] b) {
		int leftCoins = 3;
		int rightCoins = 3;
		for (int i = 0; i < r.length; i++) {
			if (r[i].equalsIgnoreCase("share") && b[i].equalsIgnoreCase("share")) {
				leftCoins = leftCoins - 1 + 3;
				rightCoins = rightCoins - 1 + 3;
			} else if (r[i].equalsIgnoreCase("share") && b[i].equalsIgnoreCase("steal")) {
				leftCoins = leftCoins - 1;
				rightCoins = rightCoins + 3;
			} else if (r[i].equalsIgnoreCase("steal") && b[i].equalsIgnoreCase("share")) {
				leftCoins = leftCoins + 3;
				rightCoins = rightCoins - 1;
			}
		}
		return new int[] { leftCoins, rightCoins };
	}

	boolean alternateSign(int[] arr) {
		if (arr.length == 1)
			return true;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] < 0 && arr[i + 1] < 0) {
				return false;
			}
			if (arr[i] >= 0 && arr[i + 1] >= 0) {
				return false;
			}
		}
		return true;
	}

	int largestGap(int[] numbers) {
		Arrays.sort(numbers);
		List<Integer> diff = new ArrayList<>();
		for (int i = 0; i < numbers.length - 1; i++) {
			diff.add(numbers[i + 1] - numbers[i]);
		}
		List<Integer> temp = diff;
		Collections.sort(temp);
		int res = temp.get(temp.size() - 1);
		return res;
	}

	boolean winRound(int[] you, int[] opp) {

		Arrays.sort(you);
		Arrays.sort(opp);
		int i = you[4] * 10 + you[3];
		int j = opp[4] * 10 + opp[3];

		return i > j;
	}

	Object[] millionsRounding(Object[] cities) {

		for (int i = 0; i < cities.length; i++) {
			Object[] obj = (Object[]) cities[i];
			obj[1] = (int) obj[1] < 5e5 ? 0 : Math.round((int) obj[1] / 1e6) * 1e6;
			cities[i] = new Object[] { obj[0], obj[1] };
		}

		return cities;
	}

	boolean cons(int[] arr) {
		if (arr.length == 0 || arr.length == 1)
			return false;
		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 1; i++) {
			if (1 + arr[i] != arr[i + 1])
				return false;
		}
		return true;
	}

	boolean isMagicSquare(int[][] square) {
		boolean flag = true;
		int[] hsum = new int[square.length];
		int[] vsum = new int[square.length];
		for (int i = 0; i < square.length; i++) {
			for (int j = 0; j < square.length; j++) {
				hsum[i] = hsum[i] + square[i][j];
			}
		}
		for (int i = 0; i < square.length; i++) {
			for (int j = 0; j < square.length; j++) {
				vsum[i] = vsum[i] + square[j][i];
			}
		}
		System.out.println(Arrays.toString(hsum));
		System.out.println(Arrays.toString(vsum));
		if (!Arrays.toString(hsum).equals(Arrays.toString(vsum)))
			return false;
		return flag;
	}

	Object[][] multiply(Object[] items) {
		int len = items.length;

		Object[][] arr = new Object[len][len];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				arr[i][j] = items[i];
			}
		}
		return arr;
	}

	boolean isFirstSuperior(Object[] a, Object[] b) {

		boolean flag = true;

		for (int i = 0; i < a.length; i++) {

			if (!a[i].equals(b[i])) {
				if (b[i].toString().length() > a[i].toString().length()) {
					return false;
				}
				if (Character.isDigit(a[i].toString().charAt(0))) {
					if (Integer.parseInt(a[i].toString()) < Integer.parseInt(b[i].toString())) {
						return false;
					}

				}

			}
		}
		return flag;
	}

	String[] makeRug(int m, int n, Optional<String> s) {

		String str = s == null ? "#" : s.get();
		str = str.repeat(n);
		String[] arr = new String[m];
		for (int i = 0; i < m; i++)
			arr[i] = str;

		return arr;

	}

	boolean binarySearch(int arr[], int left, int right, int elem) {

		boolean flag = false;
		for (int i = 0; i < arr.length; i++) {
			if (left > right)
				return false;
			int middle = Math.floorDiv(left + right, 2);
			if (arr[middle] == elem)
				return true;
			if (arr[middle] < elem)
				left = middle + 1;
			if (arr[middle] > elem)
				right = middle - 1;
		}
		return flag;
	}

	int[] timeSum(String[] s) {

		if (s.length == 0)
			return new int[] {};
		int[] resultSum = new int[3];
		for (int i = 0; i < s.length; i++) {
			String[] time = s[i].split(":");
			resultSum[0] += Integer.parseInt(time[0]);
			resultSum[1] += Integer.parseInt(time[1]);
			resultSum[2] += Integer.parseInt(time[2]);
		}
		int temp = resultSum[1] + resultSum[2] / 60;
		resultSum[2] %= 60;
		resultSum[1] = temp % 60;
		resultSum[0] += temp / 60;
		return resultSum;
	}

	String remix(String str, int[] arr) {
		String[] res = new String[arr.length];
		for (int i = 0; i < str.length(); i++) {
			res[arr[i]] = Character.toString(str.charAt(i));
		}
		return String.join("", res);
	}

	int[] miniPeaks(int arr[]) {

		List<Integer> list = new ArrayList<>();

		for (int i = 1; i < arr.length - 1; i++) {

			if (arr[i] > arr[i + 1] && arr[i] > arr[i - 1])
				list.add(arr[i]);

		}
		return list.stream().mapToInt(Integer::intValue).toArray();
	}

	String stringCycling(String a, String b) {
		String result = "";
		int aLen = a.length();
		int j = 0;

		for (int i = 0; i < b.length(); i++) {
			result = result + a.charAt(j);
			j++;
			if (j == aLen)
				j = 0;
		}
		return result;
	}

	int[] returnInts(Object[] arr) {

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] instanceof Integer)
				list.add((int) arr[i]);

		}
		return list.stream().mapToInt(Integer::intValue).toArray();
	}

	boolean sumOfTwo(int[] a, int[] b, int v) {

		for (int i = 0; i < a.length; i++) {

			for (int j = 0; j < b.length; j++) {
//				System.out.println(a[i]+"here"+b[j]);
				if (a[i] + b[j] == v) {
					return true;
				}
			}
		}
		return false;
	}

	String[] findBrokenKeys(String str1, String str2) {

		LinkedHashSet<String> list = new LinkedHashSet();
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i))
				list.add(Character.toString(str1.charAt(i)));
		}
//		Collections.reverse(list);
		return list.toArray(new String[list.size()]);
	}

	String getMissing(String strLetters) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		for (int i = 0; i < strLetters.length(); i++) {
			alphabet = alphabet.replace(Character.toString(strLetters.charAt(i)), "");
		}
		return alphabet;
	}

	String cupSwapping(String[] cups) {

		String position = "B";
		for (int i = 0; i < cups.length; i++) {
			if (cups[i].contains(position))
				position = cups[i].replace(position, "");
		}
		return position;
	}

	int returnSum(int n1, int n2) {

		int sum = 0;
		for (int i = n1 + 1; i < n2; i++) {
			sum = sum + i;
		}
		return sum;
	}

	int sumMissing(int[] arr) {
		Arrays.sort(arr);
		int sum = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] + 1 != arr[i + 1]) {
				sum = sum + returnSum(arr[i], arr[i + 1]);
			}
		}
		return sum;
	}

	int countBoomerangs(int[] arr) {
		int boomCounter = 0;
		for (int i = 0; i < arr.length - 2; i++) {
			if (arr[i] == arr[i + 2]) {
				if (arr[i] != arr[i + 1]) {
					boomCounter++;
//					i=i+2;
				}
			}
		}
		return boomCounter;
	}

	boolean possiblePath(Object[] t) {
		boolean result = true;
		for (int i = 0; i < t.length - 1; i++) {
			if (!t[i].equals("H")) {
				if (!t[i + 1].equals("H"))
					return false;
			}
			if (t[i].equals("H")) {
				if (t[i + 1].equals("H"))
					return false;
			}
		}
		return result;
	}

	double[] convertToTemps(double celcius) {
		double[] temps = new double[2];
		temps[0] = (celcius * 9) / 5 + 32;
		BigDecimal fahrenheit = new BigDecimal(temps[0]);
		temps[0] = fahrenheit.setScale(2, RoundingMode.HALF_UP).doubleValue();
		temps[1] = celcius + 273.15;
		return temps;

	}

	int combinations(int... num) {

		int result = 1;
		for (int i : num) {
			if (i == 0)
				continue;
			result = result * i;
		}
		return result;
	}

	int littleBig(int n) {

		ArrayList<Integer> list = new ArrayList<>();
		int indexOdd = 5;
		int IndexEven = 100;
		list.add(IndexEven);
		list.add(100);
		for (int i = 3; i <= n; i++) {
			if (i % 2 == 0) {
				IndexEven = IndexEven * 2;
				list.add(IndexEven);
				continue;
			}
			indexOdd++;
			list.add(indexOdd);
		}
		int result = list.get(n - 1);
		System.out.println(list);
		return result;
	}

	int minSwaps(String s1, String s2) {
		int counter = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i))
				counter++;
		}
		return counter / 2;
	}

	boolean hasNum(String str) {
		String n = str.replaceAll("[0-9]+", "");
		return n.length() != str.length();
	}

	String[] numInStr(String[] arr) {

		List<String> str = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
			if (hasNum(arr[i])) {
				str.add(arr[i]);
			}
		}

		return str.toArray(new String[str.size()]);
	}

	int sumDigits(int num1, int num2) {

		List<Integer> list = new LinkedList<>();
		int i = num1;
		while (i <= num2) {
			list.add(i);
			i++;
		}
		int sum = 0;
		for (int a : list) {
			while (a > 0) {
				sum = sum + a % 10;
				a = a / 10;
			}
		}
		return sum;
	}

	boolean mathExpr(String expr) {

		String str = expr;
		str = str.replaceAll(" ", "");
		str = str.replaceAll("[0-9\\+|-|\\*|\\/\\|%|]", "");

		return str.length() == 0;

	}

	boolean omnipresent(int[][] arr, int val) {
		boolean flag = true;
		for (int i = 0; i < arr.length; i++) {
			if (!isPresent(arr[i], val))
				return false;
		}
		return true;
	}

	boolean isPresent(int[] arr, int n) {
		List<Integer> list = Arrays.stream(arr).boxed().toList();
		return list.indexOf(n) != -1;

	}

	int[] removeDups(int[] str) {
		HashSet<Integer> ts = new HashSet();
		for (int i = 0; i < str.length; i++) {
			ts.add(str[i]);

		}
		return ts.stream().mapToInt(Integer::intValue).toArray();
	}

	String[] removeDups(String[] str) {
		TreeSet<String> ts = new TreeSet<>(Arrays.asList(str));
		return ts.toArray(new String[ts.size()]);
	}

	double averageIndex(String[] arr) {
		int sum = 0;
		if (arr.length <= 0)
			return 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + ((int) arr[i].charAt(0) - 96);
		}
		// BigDecimal bd = new BigDecimal((double)sum/arr.length);
		return new BigDecimal((double) sum / arr.length).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}

	int WeeklySalary(int[] hours) {

		int ts = 0;
		for (int i = 0; i < hours.length; i++) {
			int daySal = 0;
			if ((i == hours.length - 1) || (i == hours.length - 2)) {
				if (hours[i] > 8)
					daySal = 8 * 20 + (hours[i] - 8) * 30;
				else
					daySal = hours[i] * 20;
			} else if (hours[i] > 8)
				daySal = 8 * 10 + (hours[i] - 8) * 15;
			else
				daySal = hours[i] * 10;
			ts = ts + daySal;
		}
		return ts;
	}

	String indexFilter(int[] idx, String str) {
		int len = idx.length;
		String result = "";
		for (int i = 0; i < len; i++) {
			if (idx[i] < 0)
				result = result + str.charAt(str.length() + idx[i]);
			else
				result = result + str.charAt(idx[i]);

		}
		return result.toLowerCase();
	}

	Object[] clone(Object[] arr) {

		Object[] newArr = new Object[3];
		newArr[0] = arr[0];
		newArr[1] = arr[1];
		newArr[2] = Arrays.copyOf(arr, 2);

		return newArr;
	}

	int[] last(int[] r, int n) {

		if (n > r.length)
			return null;
		if (n == 0)
			return new int[] {};

		int[] result = new int[n];
		int a = 0;
		for (int i = r.length - n; i < r.length; i++) {
			result[a] = r[i];
			a++;
		}
		return result;
	}

	int counterpartCharCode(char ch) {
		int result = 0;

		if (Character.isUpperCase(ch)) {
			result = (int) Character.toLowerCase(ch);
		} else
			result = (int) Character.toUpperCase(ch);
		return result;
	}

	int duplicates(String str) {

		int sum = 0;
//		int i = 0;
		while (str.length() > 0) {
			int temp = str.length();
			str = str.replaceAll(str.charAt(0) + "", "");
			int res = str.length();
			int duplicate = temp - res;
			if (duplicate > 1)
				sum = sum + duplicate - 1;
//			System.out.println(sum+" "+str);
		}
		return sum;
	}

	boolean isCircleCollision(int[] c1, int[] c2) {

		double d = Math.sqrt(Math.pow(c1[1] - c2[1], 2) + Math.pow(c1[2] - c2[2], 2));

		if (d < (c1[0] + c2[0]))
			return true;
		return false;

	}

	int[] inclusiveArray(int startNum, int endNum) {

		if (startNum > endNum)
			return new int[] { startNum };

		int[] resultArr = new int[endNum - startNum + 1];
		int first = startNum;
		for (int i = 0; i <= (endNum - startNum); i++) {

			resultArr[i] = first;
			first++;
		}
		return resultArr;
	}

	String[] identicalFilter(String[] arr) {

		if (arr.length == 0)
			return new String[0];

		ArrayList<String> al = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].matches("(.)\\1*"))
				al.add(arr[i]);
		}

		return al.toArray(new String[al.size()]);

//		ArrayList<String> al = new ArrayList<>();
//		if(arr.length == 0) return new String[0];
//		for(int i =0; i<arr.length; i++) {
//			if(arr[i].length() == 1) {
//				al.add(arr[i]);
//				continue;
//			}
//			int  flag = 0;
//			for(int j =1; j<arr[i].length(); j++) {
//				
//				if(arr[i].charAt(0)!= arr[i].charAt(j)) flag++;
//			}
//			if(flag==0) al.add(arr[i]);
//		}
//		return al.toArray(new String[al.size()]) ;
	}

	String longestWord(String phrase) {

		String[] str = phrase.split(" ");
		int[] len = new int[str.length];
		String result = "";
		for (int i = 0; i < str.length; i++) {
			len[i] = str[i].length();
		}
		Arrays.sort(len);
		for (int i = 0; i < str.length; i++) {
			if (str[i].length() == len[len.length - 1]) {
				result = str[i];
				break;
			}
		}
		return result;
	}

	int[] countPositivesSumNegatives(int[] input) {

		if (input.length == 0)
			return new int[0];

		int[] result = new int[2];

		result[0] = (int) Arrays.stream(input).filter(i -> i > 0).count();
		result[1] = Arrays.stream(input).filter(i -> i < 0).sum();
		System.out.println(result[0] + " " + result[1]);
		return result;
	}

	double[] findLargestNums(double[][] arr) {

		double[] result = new double[arr.length];

		for (int i = 0; i < arr.length; i++) {
			Arrays.sort(arr[i]);
			result[i] = arr[i][arr[i].length - 1];
		}
		return result;
	}

	String[][] zipIt(String[] women, String[] men) {
		if (women.length != men.length)
			return null;
		String[][] pairs = new String[women.length][2];

		for (int i = 0; i < women.length; i++) {
			for (int j = 0; j < 1; j++) {
				pairs[i][j] = women[i];
				pairs[i][j + 1] = men[i];
			}
		}
		return pairs;
	}

	String[] getBirthdayCake(String name, int age) {

		String template = " Happy Birthday ";
		String age1 = Integer.toString(age);
		int totalChars = ("# " + age + template + name + " " + age + "! #").length();
		String ch = age % 2 == 0 ? "#" : "*";
		String chars = age % 2 == 0 ? "#".repeat(totalChars) : "*".repeat(totalChars);

		String[] message = { chars, ch + " " + age + template + name + " " + age + "! " + ch, chars };
		return message;
	}

	boolean puzzlePieces(int[][] n) {
		if (n[0].length != n[1].length)
			return false;
		int arr1[] = n[0];
		int arr2[] = n[1];
		int sum = arr1[0] + arr2[0];

		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] + arr2[i] != sum) {
				return false;
			}
		}
		return true;
	}

	boolean rightTriangle(int x, int y, int z) {
		int[] sides = { x, y, z };
		if (x <= 0 || y <= 0 || z <= 0)
			return false;
		Arrays.sort(sides);
		return Math.pow(sides[0], 2) + Math.pow(sides[1], 2) == Math.pow(sides[2], 2);
	}

	int missingNum(int[] nums) {

//		List< Integer>intlist = List.of(1,2,3,4,5,6,7,8,9,10);
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
		return 55 - sum;
	}

	int findSeat(int n, int[] arr) {

		int numOfCars = arr.length;
		int lessCapacity = n / (numOfCars * 2);
		for (int i = 0; i < numOfCars; i++) {
			if (arr[i] <= lessCapacity)
				return i;
		}

		return -1;
	}

	int sumOfArray(int[] arr) {

		if (arr.length == 0)
			return 0;

		int sum = 0;
		return sum + arr[0] + sumOfArray(Arrays.copyOfRange(arr, 1, arr.length));

	}

	int letterCounter(String[][] arrOut, String ch) {

		int counter = 0;

		for (String[] arr : arrOut) {
			for (String str : arr) {
				if (str.equals(ch))
					counter++;
			}
		}
		return counter;
	}

	int[][] squarePatch(int num) {

//		int[] arrIn = new int[num];
		int[][] arrOut = new int[num][num];

		for (int[] arr : arrOut) {
			Arrays.fill(arr, num);
		}
		return arrOut;

//		if(num==0) return arrOut;
//		
//		for(int i = 0; i<num; i++) {
//			arrIn[i]=num;
//		}
//		for(int i = 0; i<num; i++) {
//			arrOut[i]=arrIn;
//		}

//		return arrOut;
	}

	int warOfNumbers(int[] arr) {

		int evenSum = 0;
		int oddSum = 0;
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] % 2 == 0) {
				evenSum += arr[i];
				continue;
			}
			oddSum += arr[i];
		}

		return oddSum > evenSum ? oddSum - evenSum : evenSum - oddSum;

	}

	double[] otherSides(int shortSide) {

		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		double[] sidesArr = new double[2];
		sidesArr[0] = 2 * shortSide;
		sidesArr[1] = Double.parseDouble(nf.format(Math.sqrt(3) * shortSide));
		return sidesArr;
	}

	int[] arrayOfMultiples(int num, int length) {

		int[] arr = new int[length];
		arr[0] = num;

		for (int i = 1; i < length; i++) {
			arr[i] = num * (i + 1);
		}

		return arr;
	}

	Integer[] filterByLength(int[] arr, int length) {

		if (arr.length == 0)
			return null;
		ArrayList<Integer> intList = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {

			if (Integer.toString(arr[i]).length() == length)
				intList.add(arr[i]);

		}

//		int[] intArr = new int[intList.size()];
//		Integer[] intArr = intList.toArray(new Integer[intList.size()]);

		return intList.toArray(new Integer[intList.size()]);
	}

	String getExtention(String[] strArray) {
		String[] extArray = new String[strArray.length];

		int i = 0;
		while (i < strArray.length) {
//			extArray[i]=strArray[i].substring(strArray[i].indexOf(".")+1);
			extArray[i] = strArray[i].replaceAll(".*[.]", "");
			i++;
		}

		return Arrays.toString(extArray);

	}

	String cumulativeSum(int[] arr) {

		if (arr.length == 0)
			return Arrays.toString(arr);
		int[] cumulativeSumArray = new int[arr.length];
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			cumulativeSumArray[i] = sum;
		}

		return Arrays.toString(cumulativeSumArray);
	}

	int trimmedAverage(int[] arr) {

		Arrays.sort(arr);
		int sum = 0;
		for (int i = 1; i < arr.length - 1; i++) {
			sum += arr[i];
		}

		return sum / (arr.length - 2);
	}

	int maxPossible(int[] arr) {

		int counter = 0;

		if (arr.length < 5) {
			for (int i = 0; i < arr.length; i++) {
				counter += arr[i];
			}
			return counter;
		}

		Arrays.sort(arr);
		int len = arr.length;
		for (int i = len - 5; i < len; i++) {
			counter += arr[i];
		}

		return counter;

	}

	int[] minMax(int[] arr) {

		int len = arr.length;

		if (len == 1)
			return new int[] { arr[0], arr[0] };

		Arrays.sort(arr);

		return new int[] { arr[0], arr[len - 1] };

	}

	int secondLargestNumberInArray(int[] arr) {
		int i = 0, len = arr.length;

		if (len < 2)
			return 0;

		Arrays.sort(arr);

		return arr[len - 2];
	}

	int[] bubbleSortArray(int[] arr) {

		int len = arr.length;
		int temp = 0;
		for (int i = 0; i < len; i++) {
			for (int j = 1; j < len - i; j++) {

				if (arr[j - 1] > arr[j]) {
					temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}

			}

		}
		return arr;

	}

	int[] sortArray(int[] arr) {

		Arrays.sort(arr);
		return arr;

	}

	boolean orthogonalVectors(int[] v1, int[] v2) {

		int sum = 0;
		int len = v1.length;

		for (int i = 0; i < len; i++) {
			sum = sum + v1[i] * v2[i];
		}

		return sum == 0 ? true : false;
	}

//	int sumBudget(Object[] arr) {
//		
//		int sum=0;
//		for(Object obj:arr) {
//			sum = sum + obj.budget;
//		}
//		
//		return 0;
//	}
	public boolean changeEnough(int[] change, double amountDue) {

		double totalChange = 0;
		totalChange = change[0] * 0.25 + change[1] * 0.10 + change[2] * 0.05 + change[3] * 0.01;
		System.out.println(totalChange);
		return totalChange >= amountDue ? true : false;

	}

	int arrayTrueCount(boolean[] arr) {

		int a = 0;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i])
				a++;
		}

		return a;
	}

	public int minMaxArray(int[] arr) {

		int min = arr[0];
		int max = 0;
		// for max
		for (int i = 0; i < arr.length; i++) {
			max = max > arr[i] ? max : arr[i];
		}
//		for min
		for (int i = 0; i < arr.length; i++) {
			min = min < arr[i] ? min : arr[i];
		}
		return max - min;

	}

	public static void main(String[] args) {

		ArrayPractice ap = new ArrayPractice();

		int[] v1 = { 1, 2, 0 };
		int[] v2 = { 1, 7, 2, 4, 8, 10, 5, 6, 9 };
		String[] strArray = { "ruby.rb", "cplusplus.cpp", "python.py", "javascript.js" };

//		System.out.println(ap.missingNum(v2));
//		System.out.println(ap.rightTriangle(915, 1748, 1973));

//		System.out.println(ap.findSeat(200, v2));
//		System.out.println(ap.sumOfArray(v2));
//		String[][] arrOut = {{"D", "E", "Y", "H", "A", "D"},
//				{"C", "B", "Z", "Y", "J", "K"},
//				{"D", "B", "C", "A", "M", "N"},
//				{"F", "G", "G", "R", "S", "R"},
//				{"V", "X", "H", "A", "S", "S"}};
//		
//		System.out.println(ap.letterCounter(arrOut, "S"));

//		System.out.println(Arrays.deepToString(ap.squarePatch(5)));
//		System.out.println(ap.warOfNumbers(v2));
//		System.out.println(Arrays.toString(ap.otherSides(1)));
//		System.out.println(Arrays.toString(ap.filterByLength(v2, 2)));
//		System.out.println(Arrays.toString(ap.arrayOfMultiples(17,6 )));
//		System.out.println(ap.getExtention(strArray));
//		System.out.println(ap.cumulativeSum(v2));
//		System.out.println(ap.trimmedAverage(v2));
//		System.out.println("Maximum Possible total of 5 elements: "+ap.maxPossible(v2));

//		System.out.println(Arrays.toString(ap.minMax(v2)));
//		System.out.println("second largest number in the array is: "+ap.secondLargestNumberInArray(v2) );

//		System.out.println("Orthogonal: "+ap.orthogonalVectors(v1, v2));
//		
//		for(int i:ap.bubbleSortArray(v2)) {
//			System.out.println(i);
//		}

//		boolean[] arr = {true, false, true, false, true,true,true,true};
//		
////		System.out.println("total true values:"+ap.arrayTrueCount(arr));
//		
//		int[] change = {100, 0, 5, 219};
//		double due = 19.99;
//		
//		System.out.println(ap.changeEnough(change, due));

//		int[][] arr = {{0, 0, 0, 0, 0}, {1, 1, 1, 1, 1}};
		double[][] arr = { { 0.4321, 0.7634, 0.652 }, { 1.324, 9.32, 2.5423, 6.4314 }, { 9, 3, 6, 3 } };
//		System.out.println(ap.puzzlePieces(arr));
//		Arrays.asList(ap.getBirthdayCake("Dhruv", 30)).stream().forEach(System.out::println);
//		String[] women = {"Ana", "Amy", "Lisa"};
//		String[] men = {"Bob", "Josh", "Tim"};
//		System.out.println(Arrays.deepToString(ap.zipIt(women, men)));
//		
//		System.out.println(Arrays.toString(ap.findLargestNums(arr)));

		int[] arr1 = {};
		String[] str = { "aaaaaa", "bc", "d", "eeee", "xyz" };
//		System.out.println(Arrays.toString(ap.countPositivesSumNegatives(arr1)));
//		System.out.println(ap.longestWord("Forgetfulness is by all means powerless!"));
//		System.out.println(Arrays.toString(ap.identicalFilter(str)));
		int[] c1 = {};
		int[] c2 = { 0, 0, 0, 0, 0, 16, 0 };
//		System.out.println(Arrays.toString(ap.inclusiveArray(17, 5)));
//		System.out.println(ap.isCircleCollision(c1, c2));
//		System.out.println(ap.duplicates("The Quick Brown Fox Jumps Over the Lazy Dog`"));
//		System.out.println(ap.counterpartCharCode('L'));
//		System.out.println(Arrays.toString(ap.last(c1, 0)));
//		System.out.println(Arrays.toString(objArr));
		String[] objArr = { "this IS", "10xYZ", "xy2K77", "Z1K2W0", "xYz" };
//		System.out.println(ap.indexFilter(c2, "That's life, I've got you under my skin"));
//		System.out.println(ap.WeeklySalary(c2));
//		System.out.println(ap.averageIndex(objArr));
//		System.out.println(Arrays.toString(ap.removeDups(new String[] {"#", "#", "%", "&", "#", "$", "&"})));
//		System.out.println(Arrays.toString(ap.removeDups(new int[] {1, 2, 2, 2, 3, 2, 5, 2, 6, 6, 3, 7, 1, 2, 5})));
//		System.out.println(ap.omnipresent(new int[][] { { 5 }, { 5 }, { 5 }, { 6, 5 } }, 6));
//		System.out.println(ap.mathExpr("nope"));
//		System.out.println(ap.sumDigits(66, 789));
//		System.out.println(Arrays.toString(ap.numInStr(objArr)));
//		System.out.println(ap.minSwaps ("11111000001100", "10110010100110"));
//		System.out.println(ap.littleBig(5));
//		System.out.println(ap.combinations(6, 7, 0));
//		System.out.println(Arrays.toString(ap.convertToTemps(300.4)));
//		System.out.println(ap.possiblePath(new Object[] {"H", 2, "H", 3, 4, "H", 1, "H", 2, "H"}));
//		System.out.println(ap.countBoomerangs(new int[] {4, 4, 4, 8, 4, 8, 4}));
//		System.out.println(ap.sumMissing(new int[] {7, 8, 9, 10}));
//		System.out.println(ap.cupSwapping(new String[] {}));
//		System.out.println(ap.getMissing("abcdefghijklmnopqrstuvwxyz"));
//		System.out.println(Arrays.toString(ap.findBrokenKeys("!!??$$", "$$!!??")));
//		System.out.println(ap.sumOfTwo(new int[] {1, 2}, new int[] {4, 5, 6}, 8));
//		System.out.println(Arrays.toString(ap.returnInts(new Object[]{"String",  true,  3.3,  1})));
//		System.out.println(ap.stringCycling("to", ""));
//		System.out.println(Arrays.toString(ap.miniPeaks(new int[] { 1, 2, 3, 4, 5, 6 })));
//		System.out.println(ap.remix("responsibility", new int[] { 0, 6, 8, 11, 10, 7, 13, 5, 3, 2, 4, 12, 1, 9 }));
//		System.out.println(Arrays.toString(ap.timeSum(new String[]{"18:54:02", "0:26:28", "11:48:22", "22:26:16", "7:17:05", "8:01:44", "0:35:24", "16:25:11", "9:11:24", "18:30:46", "3:31:51", "16:55:32", "17:59:00", "11:29:30", "3:19:58", "9:12:27", "22:03:34", "1:06:12", "0:44:07", "4:47:46", "10:38:00", "14:26:51", "10:09:07", "5:08:29", "5:29:57", "22:15:03", "20:52:28", "8:42:20", "17:36:32", "9:36:17"})));
//		System.out.println(ap.binarySearch(
//				new int[] { 20, 1067, 5032, 10005, 20333, 36798, 45234, 55555, 64123, 99999 }, 0, 9, 6123));
//		System.out.println(Arrays.toString(ap.makeRug(4, 5, Optional.ofNullable("lodu "))));
//		System.out.println(ap.isFirstSuperior(new Object[] {true, 10, "ant"}, new Object[] {true, 10, "zebra"}));
//		System.out.println(Arrays.deepToString(ap.multiply(new Object[] {4, 5})));
//		System.out.println(ap.isMagicSquare(new int[][] {
//			new int[] {16, 3, 2, 13},
//			new int[] {5, 10, 11, 8},
//			new int[] {9, 6, 7, 12},
//			new int[] {4, 15, 14, 1}
//		}));
//	}
//		System.out.println(ap.cons(new int[] {-3, -2, -1, 1, 0}));
//		System.out.println(Arrays.deepToString(ap.millionsRounding(new Object[] {new Object[] {"Tokyo", 37435191}, new Object[] {"Delhi", 29399141}, new Object[] {"Shanghai", 26317104}})));
//		System.out.println(5e6);
//		System.out.println(ap.winRound(new int[] {3, 2, 8, 9, 4}, new int[] {0, 7, 9, 3, 1}));
//		System.out.println(ap.largestGap(new int[] {13, 3, 8, 5, 5, 2, 13, 6, 14, 2, 11, 4, 10, 8, 1, 9}));
//		System.out.println(ap.alternateSign(new int[] { -7, 15, -18}));
//		System.out.println(Arrays.toString(ap.getCoinBalances(new String[] {"share", "steal", "steal", "steal"}, new String[] {"share", "share", "steal", "share"})));
//		System.out.println(Arrays.toString(ap.reorderDigits(new int[]{12, 21, 15, 51}, "asc")));

//		System.out.println(ap.mineralFormation(new int[][] {
//			{0, 1, 0, 1},
//			{0, 1, 0, 1},
//			{0, 0, 0, 1},
//			{0, 0, 0, 0}}));
//		System.out.println(Arrays.toString(ap.filterArray(new String[] {"w", "r", "u", "43", "s", "a", "76", "d", "88"})));
//		System.out.println(Arrays.deepToString(ap.sortIt(new Object[] {new int[] {4}, 1, new int[] {3}})));
//		System.out.println(ap.canBuild(new String[]{"i", "it", "bit", "bite", "biters"}));
//		System.out.println(ap.luckySeven(new int[] {-5, -4, 6, 8, 9, 8, 8}));
//		System.out.println(ap.printGrid(10,3));
//		System.out.println(Arrays.deepToString(ap.peelLayer(new Object[][]{
//			{true, false, true, 1, 2, 3, 4},
//			{false, false, true, 5, 6, 7, 8},
//			{true, true, true, 9, 10, 11, 12}
//		})));
//		System.out.println(ap.uniquely(new String[] {"to", "too", "t"}, new String[] {"topology", "took", "torrent"}));
//		System.out.println(Arrays.toString(ap.characterMapping("canine")));
//		System.out.println(Arrays.deepToString(ap.pairs(new int[] {1, 9, 8, 7, 6})));
//		String str1 = "For the love of Tesh. She is the love of my life. I am all hers.";
//		String str2 = "I have a cat. I have a mat. Things are going swell.";
//		System.out.println(ap.sentenceSearcher(str2, "flat"));
//		System.out.println(ap.findFulcrum(new int[]{4, 6, 6, 1, 5, 4}));
//		System.out.println(ap.transpose(new String[][] {{"I", "Tesh"}, {"so", "very"}, {"love", "much!"}} ));
//		System.out.println(ap.highestPair(new String[] { "J", "6", "3", "10", "8" }));
//		System.out.println(Arrays.toString(ap.flipArray(new Object[] {})));
//		System.out.println(Arrays.deepToString(ap.flipArray(new Object[] {"dabang", 3.5,5, 4, 4})));
//		System.out.println(Arrays.toString(ap.charAtPos(new String[] {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")"}, "odd")));
//		System.out.println(Arrays.toString(ap.returnUnique(new int[] {-9,-9,-9, 7,-9,-9, 1})));
//		System.out.println(Arrays.toString(ap.collect("recollection", 3)));
//		System.out.println(
//				ap.wrongNumber(new int[][] { { 1, 2, 3, 6 }, { 4, 5, 6, 115 }, { 7, 8, 9, 24 }, { 12, 15, 18, 46 } }));
//		System.out.println(Arrays.toString(ap.sortContacts(new String[] {},"asc")));
//		System.out.println(ap.generateString(6, new String[] {"n", "k"}));
//		System.out.println(Arrays.toString(ap.charAtPosNew(new Object[] {"A","S","D","F","G","H","J","K","L","Z"}, "even")));
//		System.out.println(ap.allTruthy(true, 0.1f, "", true, true));
//		System.out.println(Arrays.toString(ap.selReverse(new int[] {5,7,2,6,0,4,6},4)));
//		System.out.println(ap.nearestChapter(new Chapter[] {
//				new Chapter("Chapter 1a", 1), new Chapter("Chapter 1b", 5), new Chapter("Chapter 1c", 50), new Chapter("Chapter 1d", 100), new Chapter("Chapter 1e", 200), new Chapter("Chapter 1f", 400)
//		}, 300));
//		System.out.println(ap.wordprocessor(11,16,"college students in the USA are eligible for selection as finalists"));
//		System.out.println(Arrays.toString(ap.sameVowelGroup(new String[] {"a", "aa", "ab", "abc", "aaac", "abe"})));
//		System.out.println(ap.longestRun(new int[] { 1, 2, 3, 5, 6, 7, 8, 9 }));
//		System.out.println(Arrays.deepToString(ap.increment(3, 3, new String[] {"0c", "1c", "1c", "2c", "2c", "2c"})));
//		System.out.println(Arrays.toString(ap.inclusiveArrayNew( 2,8)));
//		System.out.println(Arrays.toString(ap.twoProduct(new Integer[] { 3, 4, 5,  6, 7, 8, 9, 10}, 10)));
//		System.out.println(Arrays.toString(ap.quadSequence(0,12,10)));
//		System.out.println(Arrays.toString(ap.sortWithoutArticles(new String[] {"The Old American Rejects", "The Cure", "The Who", "Goo Goo Dolls", "The Bee Gees"})));
//		System.out.println(Arrays.toString(ap.numSplit(121317)));'
//		System.out.println(Arrays.toString(ap.flatten(new Object[][] {
//			{new Object[] {17.2, 500, "code"}, "generate"}})));
		System.out.println(ap.cannotCapture(new int[][] {{1, 0, 1, 0, 1, 0, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 1}, {0, 0, 0, 0, 1, 0, 1, 0}, {0, 0, 0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 0, 1, 0}, {0, 0, 0, 0, 0, 1, 0, 1}, {1, 0, 0, 0, 1, 0, 1, 0}, {0, 0, 1, 1, 0, 1, 0, 1}}));
		
		
	}

}
