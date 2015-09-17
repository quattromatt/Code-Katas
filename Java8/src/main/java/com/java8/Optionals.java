package com.java8;

import java.time.Instant;
import java.util.Optional;
import java.util.function.Supplier;

public class Optionals {

	public static void main(String[] args) {
		String foo = "bar";
		Optional<String> opt = Optional.of(foo);
		
		System.out.println("Before: Is present? " + opt.isPresent());
		opt = Optional.empty();
		System.out.println("After: Is present? " + opt.isPresent());
		
		Integer defaultValue = 100;
		Optional<Integer> value = Optional.empty();
		System.out.println("Value: " + value.orElse(defaultValue));
		
		Supplier<String> get_a_string = () -> {return "FooBar";};
		Optional<String> str = Optional.empty();
		System.out.println("Give me a string: " + str.orElseGet(get_a_string));
//		Optional<int> foo = Optional.empty();

	}
}
