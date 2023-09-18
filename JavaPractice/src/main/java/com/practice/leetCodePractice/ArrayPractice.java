package com.practice.leetCodePractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ArrayPractice {
	HashSet<Integer> randomizedSet = new HashSet<>();

	boolean containsNearbyDuplicate(int[] nums, int k) {
		HashMap<Integer, Integer> map  = new HashMap<>();
		for(int i =0; i<nums.length;i++) {
			if(map.containsKey(nums[i])) {
				if((int)Math.abs(map.get(nums[i])-i)<=k) return true;
			}
			map.put(nums[i], i);
		}
		
		return false;
	}
		
	 boolean isHappy(int n) {
		 
		 HashSet<Integer> set = new HashSet<>();
		 set.add(n);
		 while(true) {
			 n = squareAndSumAlDigits(n);
			 if(n==1)return true;
			 if(set.contains(n))return false;
			 set.add(n);
		 }
		
	 }
	
	private int squareAndSumAlDigits(int n) {
		int result = 0;
		while(n>0) {
			int digit  = n%10;
			result+=digit*digit;
			n/=10;
			
		}
		return result;
	}

	int[] twoSum(int[] nums, int target) {

		int[] result = new int[2];

		// solution 1
//		
//		int temp = 0;
//		for(int i=0; i<nums.length;i++) {
//			 temp = target-nums[i];
//			 
//			 for(int j =0; j<nums.length;j++) {
//				 if(i==j)continue;
//				 if(nums[j]==temp) {
//					 result[0]=i;
//					 result[1]=j; 
//				 }
//				 
//			 }
//			 
//		}
//		return result;

		// solution 2
//		HashMap<Integer, Integer> map =  new HashMap<>();
//		int n =nums.length;
//		for(int i=0; i<n; i++) {
//			map.put(nums[i], i);
//		}
//		
//		for(int i=0; i<n;i++) {
//			int temp = target-nums[i];
//			 if(map.containsKey(temp) && i!=map.get(temp)) return new int[] {i, map.get(temp)};
//		}
//		return new int[] {};

		// solution 3
		HashMap<Integer, Integer> map = new HashMap<>();
		int n = nums.length;
		for (int i = 0; i < n; i++) {

			int temp = target - nums[i];
			if (map.containsKey(temp) && i != map.get(temp))
				return new int[] { map.get(temp), i };
			map.put(nums[i], i);
		}
		return new int[] {};

	}

	boolean isAnagram(String s, String t) {
		// Solution 1
//		if(s.length()!=t.length()) return false;
//		for(int i =0; i<s.length();i++) {
//			if(!t.contains(s.charAt(i)+""))return false;
//			t= t.replaceFirst(s.charAt(i)+"", "");
//		}
//		return true;

		// solution 2
//		if(s.length()!=t.length()) return false;
//		for(int i =0; i<s.length();i++) {
//			if(!t.contains(s.charAt(i)+""))return false;
//			int index = t.indexOf(s.charAt(i));
//			t=t.substring(0,index)+t.substring(index+1);
//		}
//		return true;

		// solution 3
		if (s.length() != t.length())
			return false;
		char[] sc = s.toCharArray();
		char[] tc = t.toCharArray();
		Arrays.sort(sc);
		Arrays.sort(tc);
		for (int i = 0; i < sc.length; i++) {
			if (sc[i] != tc[i])
				return false;
		}
		return true;
	}

	boolean wordPattern(String pattern, String s) {
		String[] str = s.split(" ");
		if (pattern.length() != str.length)
			return false;
		HashMap<Character, String> map = new HashMap<>();

		for (int i = 0; i < pattern.length(); i++) {
			if (!map.containsKey(pattern.charAt(i))) {
				if (map.containsValue(str[i]))
					return false;
				map.put(pattern.charAt(i), str[i]);
			} else {
				if (!map.get(pattern.charAt(i)).equals(str[i]))
					return false;
			}
		}
		return true;
	}

	boolean isIsomorphic(String s, String t) {
		// solution 1
//		if(s.length()!=t.length()) return false;
//		String stemp = "";
//		String ttemp = "";
//		HashMap<String, String> map = new HashMap<>();
//		HashMap<String, String> map1 = new HashMap<>();
//		for(int i = 0; i<s.length();i++) {
//			map.put(s.charAt(i)+"", t.charAt(i)+"");
//			map1.put(t.charAt(i)+"", s.charAt(i)+"");
//		}
//		for(int i = 0; i<s.length();i++) {
//			stemp =stemp+map.get(s.charAt(i)+"");
//			ttemp =ttemp+map1.get(t.charAt(i)+"");
//		}
//		return stemp.equals(t) && ttemp.equals(s);

		// soultion 2
//		Map map = new HashMap();
//		
//		for(int i =0; i<s.length();i++) {
//			System.out.println("s:"+s.charAt(i)+ " t:"+t.charAt(i));
//			if(map.put(s.charAt(i), i) != map.put(t.charAt(i)+"", i)) return false;
//			}
//		return true;

		// solution 3
		if (s.length() != t.length())
			return false;
		HashMap<Character, Character> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i))) {
				if (map.containsValue(t.charAt(i))) {
					return false;
				}
				map.put(s.charAt(i), t.charAt(i));
			} else {
				if (map.get(s.charAt(i)) != t.charAt(i))
					return false;
			}
		}
		return true;

	}

	boolean canConstruct(String ransomNote, String magazine) {
		// solution 1
		if (ransomNote.length() > magazine.length())
			return false;
		char[] ch = ransomNote.toCharArray();
		for (char c : ch) {
			if (magazine.contains(c + "")) {
				magazine = magazine.replaceFirst(c + "", "");

			} else
				return false;
		}
		return true;

		// solution 2
//		 char[] ch = ransomNote.toCharArray();
//		    for (char c : ch) {
//		        int i = magazine.indexOf(c);
//		        if (i == -1) return false;
//		        magazine = magazine.substring(0, i) + magazine.substring(i + 1);
//		    }
//		    return true;

	}

	boolean isSubsequence(String s, String t) {
		// solution 1
		// if(s.length()==0)return true;
//	       t = t.replaceAll("[^"+s+"]", t);
//			if(t.length()==1 && !s.equals(t)) return false;
//			for(int i =0; i<s.length()-1;i++) {
//				if(! (t.contains(s.charAt(i+1)+"")||t.contains(s.charAt(i)+""))) return false;
//				if(!(t.indexOf(s.charAt(i+1)) > t.indexOf(s.charAt(i)))) return false;
//			}
//			
//			return true;

		// solution 2
		if (s.length() == 0)
			return true;
		int j = 0;
		for (int i = 0; i < t.length(); i++) {
			if (s.charAt(j) == t.charAt(i)) {
				j++;
			}
			if (j == s.length())
				return true;
		}
		return false;

	}

	boolean isValidPalindrome(String s) {
//		Solution 1
//		s= s.toLowerCase().replaceAll("[^a-z0-9]", "");
//		if(s.length()<=1) return false;
//		String reversed = new StringBuilder(s).reverse().toString();
//		return s.equals(reversed);

		// Solution 2
//		s= s.toLowerCase().replaceAll("[^a-z0-9]", "");
//		
//		String reversed = "";
//		for(int i =s.length()-1; i>=0;i--) {
//			reversed += s.charAt(i);
//		}
//		return s.equals(reversed);

		// Solution 3
		s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
		for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
			if (s.charAt(i) != s.charAt(j))
				return false;
		}
		return true;
	}

	int strStr(String haystack, String needle) {

		int index = 0;
		if (haystack.contains(needle))
			return haystack.indexOf(needle);

		return -1;
	}

	String longestCommonPrefix(String[] strs) {

		// SOLUTION 1
//		Arrays.sort(strs, Comparator.comparing(s->s.length()));
//		System.out.println(Arrays.toString(strs));
//		String result = strs[0];
//		String temp = "";
//		
//		for(int i =1; i<strs.length;i++){
//			if(result.length()==0) break;
//			temp="";
//			System.out.println(i);
//			for(int j=0; j<result.length();j++) {
//				if(result.charAt(j)!=strs[i].charAt(j)) {
//					result = temp;
//					temp="";
//					break;
//				}
//				
//				temp +=result.charAt(j); 
//			}
//			
//		}
//		return result;

		// SOLUTION 2
		Arrays.sort(strs);

		String s1 = strs[0];
		String s2 = strs[strs.length - 1];
		int i = 0;
		if (s1.length() == 0)
			return s1;
		while (i < s1.length() && i < s2.length()) {
			if (s1.charAt(i) != s2.charAt(i)) {
				break;
			}
			i++;
		}
		return s1.substring(0, i + 1);

	}

	int lengthOfLastWord(String s) {

		// sol 1
		// s=s.trim();
//		String[] arr= s.split("\\s");
//		return arr[arr.length-1].length();

		// sol 2
		s = s.trim();
		int counter = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ')
				break;
			counter++;
		}
		return counter;
	}

	int canCompleteCircuit(int[] gas, int[] cost) {
		int n = gas.length;
		int start = 0;
		int balance = 0;
		int deficieny = 0;
		for (int i = 0; i < n; i++) {
			balance += gas[i] - cost[i];

			if (balance < 0) {
				deficieny += balance;
				start++;
				balance = 0;
			}
		}
		if (deficieny + balance >= 0)
			return start;
		else
			return -1;
	}

	public int[] productExceptSelf(int[] nums) {

//	solution 3:
		int[] left = new int[nums.length];
		int[] right = new int[nums.length];

		left[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			left[i] = left[i - 1] * nums[i - 1];
		}

		right[nums.length - 1] = 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			right[i] = right[i + 1] * nums[i + 1];
		}

		for (int i = 0; i < nums.length; i++)
			nums[i] = left[i] * right[i];
		return nums;

		// solution 2:
//	int[] ans =  new int[nums.length];
//	
//	for(int i =0;i<nums.length;i++) ans[i] = nums[i];
//	
//	for(int i =0;i<nums.length;i++) {
//		int product =1;
//		for(int j=0; j<nums.length;j++) {
//			if(i==j)continue;
//			product *=ans[j];
//		}
//		nums[i]=product;
//	}
//	
//	return nums;

//	solution 1:
		// int[] ans = new int[nums.length];
//    int product =1, c=0;
//    for(int i : nums) {
//    	if(i!=0) product *=i;
//    	else c++;
//    }
//    if(c==nums.length)product =0;
//    for(int i = 0; i<nums.length;i++) {
//    	if(nums[i]==0)nums[i]=product;
//    	else if(c>0) nums[i]=0;
//    	else nums[i]=product/nums[i];
//    }
//	return nums;
	}

	public boolean insert(int val) {

		if (randomizedSet.contains(val))
			return false;
		randomizedSet.add(val);

		return true;
	}

	public boolean remove(int val) {

		if (randomizedSet.contains(val)) {
			randomizedSet.remove(val);
			return true;
		}
		return false;
	}

	public int getRandom(int val) {

		List<Integer> list = new ArrayList<>(randomizedSet);

		Random rn = new Random();
		int ans = rn.nextInt(list.size());
//		int ans = (int)Math.random()*(randomizedSet.size());
		return list.get(ans);
	}

	int romanToInt(String s) {
		HashMap<Character, Integer> romanToIntMap = new HashMap<>();
		romanToIntMap.put('I', 1);
		romanToIntMap.put('V', 5);
		romanToIntMap.put('X', 10);
		romanToIntMap.put('L', 50);
		romanToIntMap.put('C', 100);
		romanToIntMap.put('D', 500);
		romanToIntMap.put('M', 1000);

		int total = 0;

		for (int i = 0; i < s.length(); i++) {
			if (i != s.length() - 1 && (romanToIntMap.get(s.charAt(i)) < romanToIntMap.get(s.charAt(i + 1)))) {
				total = total + romanToIntMap.get(s.charAt(i + 1)) - romanToIntMap.get(s.charAt(i));
				i++;
			} else
				total = total + romanToIntMap.get(s.charAt(i));

		}

		return total;

	}

	int hIndex(int[] citations) {
		int temp = 0;

		for (int i = citations.length; i >= 0; i--) {
			temp = 0;
			for (int j : citations) {
				if (j >= i) {
					temp++;
				}
			}
			if (temp >= i) {
				return i;
			}
		}

		return 0;
	}

	int canJumpMinJumps(int[] nums) {
		int jump = 0, curEnd = 0, curFarthest = 0;

		for (int i = 0; i < nums.length - 1; i++) {
			curFarthest = Math.max(curFarthest, i + nums[i]);
			if (i == curEnd) {
				curEnd = curFarthest;
				jump++;
			}
		}

		return jump;

	}

	public boolean canJump(int[] nums) {
		int reach = 0;
		for (int i = 0; i < nums.length; i++) {
			if (reach < i)
				return false;
			reach = Math.max(reach, i + nums[i]);
		}
		return true;
	}

	// 7 1 5 3 6 4, 1 2 3 4 5
	public int maxProfitTwiked(int[] prices) {

		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				profit = profit + prices[i] - prices[i - 1];
			}
		}
		return profit;
	}

	public int maxProfit(int[] prices) {

		// second solution

		int leastSoFar = Integer.MAX_VALUE;
		int priceIfSoldToday = 0;
		int maxProfit = 0;

		for (int i = 0; i < prices.length; i++) {

			if (prices[i] < leastSoFar) {
				leastSoFar = prices[i];
			}
			priceIfSoldToday = prices[i] - leastSoFar;
			if (maxProfit < priceIfSoldToday) {
				maxProfit = priceIfSoldToday;
			}

		}
		return maxProfit;

		// 1st solution
//		int minPrice = prices[0];
//		int minPriceDay = 0;
//
//		
//
//		for (int i = 0; i < prices.length; i++) {
//			if (minPrice >= prices[i]) {
//				minPrice = prices[i];
//				minPriceDay = i;
//			}
//		}
//		
//		int maxPrice = prices[minPriceDay];
//		int maxPriceDay = minPriceDay;
//		for (int j = minPriceDay; j < prices.length; j++) {
//			if (maxPrice <= prices[j]) {
//				maxPrice = prices[j];
//				maxPriceDay = j;
//			}
//		}
//		System.out.println("minprice: "+minPrice+" maxprice:"+maxPrice);
//		if(maxPriceDay > minPriceDay) return maxPrice - minPrice;
//		return 0;

	}

	void reverseNum(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

	void rotate(int[] nums, int k) {

		k %= nums.length;
		int n = nums.length;
		reverseNum(nums, 0, n - 1);
		reverseNum(nums, 0, k - 1);
		reverseNum(nums, k, n - 1);

//		following is the correct answer but the answer given above is better.
//		int len = nums.length;
//		k = (k < len) ? k : k - len;
//
//		int[] ans = new int[len];
//		k = len - k;
//		for (int i = 0; i < nums.length; i++) {
//			if (k >= len)
//				k = k - len;
//			if (k < 0) {
//				k = 1;
//			}
//
//			ans[i] = nums[k];
//			k++;
//		}
//
//		for (
//
//				int i = 0; i < len; i++) {
//			nums[i] = ans[i];
//		}
		System.out.println(Arrays.toString(nums));
	}

	int majorityElement(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		Arrays.sort(nums);
		double counter = 1;
		double result = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1]) {
				counter++;
			} else if (nums[i] != nums[i + 1]) {
				counter = 1;
			}
			if (counter >= ((double) nums.length / 2))
				result = nums[i];
		}
		return (int) result;
	}

	public int removeDuplicatesSameElementTwice(int[] nums) {
//commented code is correct but uncomented code is more efficient solution

		int index = 2;
		if (nums.length <= 2)
			return nums.length;
		for (int i = 2; i < nums.length; i++) {
			if (nums[i] != nums[index - 2]) {
				nums[index] = nums[i];
				index++;
			}
		}
		return index;
		// int index = 2;
//        int[] temp =  new int[nums.length];
//        for(int i =0; i<temp.length;i++) {
//        	temp[i]=nums[i];
//        }
//        for(int i =2;i<temp.length;i++) {
//        	if(nums[i]!=temp[i-1]) {
//        		nums[index] = temp[i];
//        		index++;
//        	}
//        	else if(nums[i]==temp[i-1]) {
//        		if(nums[i]==temp[i-2]) continue;
//        		nums[index]= temp[i];
//        		index++;
//        	}
//        }
//        System.out.println(Arrays.toString(nums)+" "+index);
//        return index;
	}

	public int removeDuplicates(int[] nums) {

		int index = 1;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				nums[index] = nums[i];
				index++;
			}
		}
		System.out.println(Arrays.toString(nums));
		return index;
	}

	public int removeElement(int[] nums, int val) {

		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[index] = nums[i];
				index++;
			}

		}
		System.out.println(Arrays.toString(nums));
		return index;

		// following is right answer but the code above is more efficient
		// int outputValueCounter = 0;
//		
//		for(int i=0; i<nums.length;i++) {
//			if(nums[i]!=val)outputValueCounter++;
//			else nums[i]=51;
//		}
//		Arrays.sort(nums);
//		return outputValueCounter;
	}

	int[] mergeTwoArraysAscendingOrder(int[] nums1, int m, int[] nums2, int n) {

		int i = m - 1;
		int j = n - 1;
		int merge = m + n - 1;

		while (j >= 0) {
			if (i >= 0 && nums1[i] > nums2[j]) {
				nums1[merge] = nums1[i];
				i--;
				merge--;
			} else {
				nums1[merge] = nums2[j];
				merge--;
				j--;
			}
			System.out.println("i: " + i + " j:" + j + " k :" + merge);
		}

		return nums1;
		// following is the right answer but the answer given above is more efficient
		// int len = m+n;
//		 int[] result = new int[len];
//		 int i=0,j=0,k=0;
//		 
//		 if(m==0) return nums2;
//		 if(n==0) return nums1;
//		 System.out.println();
//		 
//		 int[] n1 = new int[m];
//		 int[] n2 = new int[n];
//		 if(m!=nums1.length) {
//			 for(int a =0; a<nums1.length;a++) {
//				 if(nums1[a]!=0) n1[a] = nums1[a]; 
//			 }
//		 }
//		 else n1 = nums1;
//
//		 System.out.println(Arrays.toString(n1));
//		 
//		 if(n!=nums2.length) {
//			 for(int a =0; a<nums2.length;a++) {
//				 if(nums2[a]!=0) n2[a] = nums2[a]; 
//			 }
//		 }
//		 else n2 = nums2;
//		 System.out.println(Arrays.toString(n2));
//		 
//		 while(k<len) {
//			 
//			 if(i!=m && (j == n || n1[i]<=n2[j])) {
//				 result[k]=n1[i];
//				 i++;
//				 k++;
//			 }
//			 else if(j !=n && (i == m || n1[i]>n2[j])) {
//				 result[k]=n2[j];
//				 j++;
//				 k++;
//			 }
//			 
//		 }
//		 
//		 return result;

	}

	public static void main(String[] args) {
		ArrayPractice ap = new ArrayPractice();

//		System.out.println(Arrays.toString(ap.mergeTwoArraysAscendingOrder(new int[] {1,2,3,0,0,0}, 3, new int[] {2,5,6}, 3)));
//		System.out.println(ap.removeElement(new int[] { 0, 1, 2, 2, 3, 0, 4, 2 }, 2));
//		System.out.println(ap.removeDuplicatesSameElementTwice(new int[] { 1, 1, 1, 2, 2, 3 }));
//		ap.rotate(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 3);
//		ap.maxProfitTwiked(new int[] { 1, 2, 3, 4, 5 });
//		System.out.println(ap.canJump(new int[] { 0 }));
		System.out.println(ap.longestCommonPrefix(new String[] { "flower", "flow", "flight", "" }));
		System.out.println(ap.canConstruct("aa", "ab"));

	}

}
