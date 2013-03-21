package com.codekata.util;

public class Utils {
	public static String arrayToString(int [] numbers) {
    	StringBuilder str = new StringBuilder();
    	boolean first = true;
    	
    	str.append("[");
    	for (int i = 0; i < numbers.length; i++) {
    		if (first) {
    			first = false;
    		} else {
    			str.append(", ");
    		}
    		str.append(numbers[i]);
    	}
    	str.append("]");
    	return str.toString();
    }
}
