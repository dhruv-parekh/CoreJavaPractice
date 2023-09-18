package com.practice.classes;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.management.InvalidApplicationException;

public class A
{

	String graduatedValue(long value, int decimalPlaces,boolean addDecimalForSingleDigit ) {
		String result="";
		 String[] suffixes = {"", "K", "M", "B", "T", "Q"};
	        int suffixIndex = 0;
	        double formattedValue = value;

	        while (formattedValue >= 1000 && suffixIndex < suffixes.length - 1) {
	            formattedValue /= 1000.0;
	            suffixIndex++;
	        }
	        if (addDecimalForSingleDigit) {
	        	 decimalPlaces +=1;;
	 	        String format = "%." + decimalPlaces + "f%s";
	 	        result = String.format(format, formattedValue, suffixes[suffixIndex]);
	        } else {
	        	String format = "%." + decimalPlaces + "f%s";
	 	        result = String.format(format, formattedValue, suffixes[suffixIndex]);
	        }
	        	
		return result;
	}
	String graduatedValueNew(long value, int decimalPlaces,boolean addDecimalForSingleDigit ) {
		String result="";
		boolean negativeSign = false;
		if(value<0) {
			value = Math.abs(value);
			negativeSign = true;
		}
		 String[] suffixes = {"", "K", "M", "B", "T", "Q"};
	        int suffixIndex = 0;
	        double formattedValue = value;

	        while (formattedValue >= 1000 && suffixIndex < suffixes.length - 1) {
	            formattedValue /= 1000.0;
	            suffixIndex++;
	        }
//	       System.out.println(formattedValue);
	       if(negativeSign)formattedValue = formattedValue - 2*formattedValue;
	        if (addDecimalForSingleDigit) {
	        	 if(formattedValue%10!=0 || formattedValue <1000) decimalPlaces +=1;;
	 	        String format = "%." + decimalPlaces + "f%s";
	 	        result = String.format(format, formattedValue, suffixes[suffixIndex]);
	        } else {
	        	String format = "%." + decimalPlaces + "f%s";
	 	        result = String.format(format, formattedValue, suffixes[suffixIndex]);
	        }
	        	
		return result;
	}
	
	
	public void output() {
		System.out.println("a");
	}
	
	 String takeBetween(String input, String left, String right, Boolean takeUntilEndIfRightMissing) {
		 int indexLeft = input.indexOf(left);
		    int indexRight  = input.indexOf(right);
		    int startPosition=0;
		    System.out.println(indexRight);
		    if(left.length()==0 && right.length()==0) return null;

		    if(indexRight < indexLeft){
		    	if(takeUntilEndIfRightMissing) {
		    		startPosition = indexLeft+left.length();
		            return input.substring(startPosition);
		    	}
		    	return null; 
		    }
		    if(left.equals(right)){
		    	 startPosition = input.lastIndexOf(left) + left.length();
		    	return input.substring(startPosition);
		    }
		    
//		    if(input.length()==0) return null;
		    if(indexLeft != -1 && indexRight!=-1){
		        startPosition =  indexLeft+left.length();
		        int endPosition = indexRight;
		        return input.substring(startPosition,endPosition);
		    }
		    
		    if(indexLeft != -1 && indexRight == -1){
		        if(takeUntilEndIfRightMissing){
		            startPosition = indexLeft+left.length();
		            return input.substring(startPosition);
		        }
		    }
		    return null;
		}
    
	
	
	public static void main(String[] args) {
		
		A a =  new A();
		
		System.out.println(a.graduatedValue(0, 0, true));
		
		
		
//		System.out.println(a.takeBetween("+*a ajkbgja a+* works","a+*","+*a",true));
//		
////		int result =0;
////		for(int i=2; i<=14;i+=3) {
////			result++;
////			if(i>13) result +=100;
////		}
//		
	}
	
}
