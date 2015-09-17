package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaces {

	public static void main(String[] args) {
		
		final List<String> words = Arrays.asList("foo", "bar", "something");
		final List<Integer> numbers = Arrays.asList(1, 7, 11);
		
		// Functional interfaces are interfaces with exactly one abstract method
		
		System.out.println("-- FUNCTION --");
		
		// Function takes an object and returns an object
		Function<String, String> make_tag = (name) -> {return "<" + name + "/>";};
		for (String s : words) {
			System.out.println(make_tag.apply(s));
		}
		
		System.out.println("-- SUPPLIER --");
		
		// Supplier returns an object
		Supplier<Long> give_me_a_number = () -> {return System.currentTimeMillis();};
		System.out.println(give_me_a_number.get());
		
		System.out.println("-- PREDICATE --");
		
		// Predicate returns a boolean based on an object input
		Predicate<Integer> greater_than_ten = (num) -> {return num > 10;};
		for (int i : numbers) {
			System.out.println(i + " greater than ten? " + greater_than_ten.test(i));
		}
		
		System.out.println("-- CONSUMER --");
		
		// Consumer performs an action based on an input
		Consumer<String> yell_at_me = (sentence) -> {System.out.println(sentence.toUpperCase() + "!!!1");};
		yell_at_me.accept("Java is awesome");
	}
}
