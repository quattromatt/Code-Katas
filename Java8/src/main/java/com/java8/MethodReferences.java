package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MethodReferences {

	public static void main(String[] args) {
		
		final List<String> keywords = Arrays.asList("Apple", "ios", "iphone", "mac", "iWatch");
		final String text = "Here comes the iWatch: First Apple wearable computer reportedly set for September 9th reveal";
		
//		System.out.println(keywords.stream().anyMatch(x -> text.contains(x)) ? "YES" : "NO");
		
//		boolean bool = keywords.stream().anyMatch(text::contains);
//		System.out.println("Result = " + bool);
		
		// text::contains is the method reference
		keywords.stream().filter(text::contains).forEach(System.out::println);
	}
}
