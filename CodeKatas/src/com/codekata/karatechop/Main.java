package com.codekata.karatechop;

import java.util.Arrays;

import com.codekata.util.Assertions;
import com.codekata.util.Utils;

public class Main {

    public static void main(String[] args) {
        runTests();
    }
    
    public static int chop_iterative(int target, int[] numbers) {

        boolean match = false;
        int actualIndex = 0;

        while (!match) {
        	int len = numbers.length;

        	if (len == 0) {
                return -1;
            } else if (len == 1) {
                return (numbers[0] == target) ? actualIndex : -1;
            }
        	
        	int index = len / 2;
        	int valueAtIndex = numbers[index];
        	
        	if (valueAtIndex == target) {
        		return actualIndex + index;
        	} else if (valueAtIndex < target) {
        		actualIndex += index;
        		numbers = Arrays.copyOfRange(numbers, index, len);
        	} else {
        		numbers = Arrays.copyOfRange(numbers, 0, index);
        	}
        }
        
        return -1;
    }
    
    public static int chop_recursive(int target, int[] numbers) {
    	return chop_recursive(target, numbers, 0);
    }
    
    private static int chop_recursive(int target, int[] numbers, int startIndex) {

    	int len = numbers.length;

    	if (len == 0) {
            return -1;
        } else if (len == 1) {
            return (numbers[0] == target) ? startIndex : -1;
        } else {
        	int index = len / 2;
        	int valueAtIndex = numbers[index];
        	
        	if (valueAtIndex == target) {
        		return startIndex + index;
        	} else if (valueAtIndex < target) {
        		return chop_recursive(target, Arrays.copyOfRange(numbers, index, len), startIndex + index);
        	} else {
        		return chop_recursive(target, Arrays.copyOfRange(numbers, 0, index), startIndex);
        	}
        }
    }
    
    public static int chop_using_object(int target, int[] numbers) {
    	return NumbersToChopFactory.createNumbersToChop(target, numbers).getIndex();
    }
    
    public static int chop_with_resposibilities(int target, int[] numbers) {
    	return chop_with_resposibilities_recursive(target, numbers, 0);
    }
    
    public static int chop_with_resposibilities_recursive(int target, int[] numbers, int startIndex) {
    	int len = numbers.length;

    	if (len == 0) {
            return -1;
        } else if (len == 1) {
            return (numbers[0] == target) ? startIndex : -1;
        } else {
        	int index = len / 2;
        	int valueAtIndex = numbers[index];
        	
        	if (valueAtIndex == target) {
        		return startIndex + index;
        	}  else {
        		int offset = ChopMyArray.chop_it(numbers, (valueAtIndex < target));
        		return chop_with_resposibilities_recursive(target, numbers, startIndex + offset);
        	}
        }
    }
    
    public static void runTests() {
        runTest(3, new int[] {}, -1);
        runTest(3, new int[] {1}, -1);
        runTest(1, new int[] {1}, 0);

        runTest(1, new int[] {1, 3, 5}, 0);
        runTest(3, new int[] {1, 3, 5}, 1);
        runTest(5, new int[] {1, 3, 5}, 2);
        runTest(0, new int[] {1, 3, 5}, -1);
        runTest(2, new int[] {1, 3, 5}, -1);
        runTest(4, new int[] {1, 3, 5}, -1);
        runTest(6, new int[] {1, 3, 5}, -1);

        runTest(1, new int[] {1, 3, 5, 7}, 0);
        runTest(3, new int[] {1, 3, 5, 7}, 1);
        runTest(5, new int[] {1, 3, 5, 7}, 2);
        runTest(7, new int[] {1, 3, 5, 7}, 3);
        runTest(0, new int[] {1, 3, 5, 7}, -1);
        runTest(2, new int[] {1, 3, 5, 7}, -1);
        runTest(4, new int[] {1, 3, 5, 7}, -1);
        runTest(6, new int[] {1, 3, 5, 7}, -1);
        runTest(8, new int[] {1, 3, 5, 7}, -1);
        
        runTest(8, new int[] {1, 3, 5, 7, 11, 33, 44, 55, 66, 68, 90, 101, 102, 103}, -1);
        runTest(1, new int[] {1, 3, 5, 7, 11, 33, 44, 55, 66, 68, 90, 101, 102, 103}, 0);
        runTest(44, new int[] {1, 3, 5, 7, 11, 33, 44, 55, 66, 68, 90, 101, 102, 103}, 6);
        runTest(70, new int[] {1, 3, 5, 7, 11, 33, 44, 55, 66, 68, 90, 101, 102, 103}, -1);
        runTest(103, new int[] {1, 3, 5, 7, 11, 33, 44, 55, 66, 68, 90, 101, 102, 103}, 13);
    }
    
    public static void runTest(int target, int[] numbers, int expected) {
    	
    	// Iterative chop
//    	System.out.println("Searching for " + target + " in " + Utils.arrayToString(numbers) + "... should be at index " + expected + " : " + (Assertions.assertEquals(expected, chop_iterative(target, numbers)) ? "PASS" : "FAIL"));
    	
    	// Recursive chop
//    	System.out.println("Searching for " + target + " in " + Utils.arrayToString(numbers) + "... should be at index " + expected + " : " + (Assertions.assertEquals(expected, chop_recursive(target, numbers)) ? "PASS" : "FAIL"));
    	
    	// Object chop
//    	System.out.println("Searching for " + target + " in " + Utils.arrayToString(numbers) + "... should be at index " + expected + " : " + (Assertions.assertEquals(expected, chop_using_object(target, numbers)) ? "PASS" : "FAIL"));
    	
    	// Responsibility chop
    	System.out.println("Searching for " + target + " in " + Utils.arrayToString(numbers) + "... should be at index " + expected + " : " + (Assertions.assertEquals(expected, chop_with_resposibilities(target, numbers)) ? "PASS" : "FAIL"));
    }
}
