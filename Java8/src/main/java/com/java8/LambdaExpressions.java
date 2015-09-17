package com.java8;

import com.java8.lambda.IDoThingsToADouble;
import com.java8.lambda.IDoThingsToIntegers;

public class LambdaExpressions {

	public static void main(String[] args) {
		System.out.println("Lambda expressions!!");
		
		IDoThingsToIntegers adder = (x, y) -> x + y;
		System.out.println("4 + 7 = " + adder.doSomething(4, 7));
		
		IDoThingsToIntegers multiplier = (x, y) -> x * y;
		System.out.println("4 * 7 = " + multiplier.doSomething(4, 7));
		
		IDoThingsToADouble squareRoot = (x) -> Math.sqrt(x);
		System.out.println("Square root of 4 = " + squareRoot.doIt(4));
		
		
	}
}
