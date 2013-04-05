package com.codekata.karatechop;

import java.util.Arrays;

public class ChopMyArray {

	public static int chop_it(int[] numbers, boolean compareResults) {
		int len = numbers.length;
		int index = len / 2;
		
		if (compareResults) {
			numbers = Arrays.copyOfRange(numbers, index, len);
			return index;
    	} else {
    		numbers = Arrays.copyOfRange(numbers, 0, index);
    		return 0;
    	}
	}
}
