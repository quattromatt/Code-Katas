package com.codekata.bloomfilters;

import java.util.ArrayList;
import java.util.List;

import com.codekata.bloomfilters.impl.MD5HashFunction;

public class Main {

	public static void main(String[] args) {
		System.out.println("-- Bloom Filters --");
		
		BloomFilter bloomFilter = BloomFilterFactory.getBloomFilter();
		
		// Load some hash functions
		List<HashFunction> hashFunctions = new ArrayList<HashFunction>();

		for (int i = 0; i < 20; i++) {
			hashFunctions.add(new MD5HashFunction(i));
		}

		bloomFilter.loadHashFunctions(hashFunctions);
		
		// Load some valid words
		String[] validWords = {"The", "dog", "is", "awesome"};
		bloomFilter.loadWords(validWords);
		
		// Now check some words
		String word = "the";
		boolean isValid = bloomFilter.isWordValid(word);
		System.out.println("--> " + word + (isValid ? "" : " : MISSPELLED!"));
		
		word = "cat";
		isValid = bloomFilter.isWordValid(word);
		System.out.println("--> " + word + (isValid ? "" : " : MISSPELLED!"));
		
		word = "is";
		isValid = bloomFilter.isWordValid(word);
		System.out.println("--> " + word + (isValid ? "" : " : MISSPELLED!"));
		
		word = "AwEsOmE";
		isValid = bloomFilter.isWordValid(word);
		System.out.println("--> " + word + (isValid ? "" : " : MISSPELLED!"));
	}
}
