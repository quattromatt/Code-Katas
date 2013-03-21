package com.codekata.anagrams;

import com.codekata.util.Dictionaries;

public class Main {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		AnagramFinder finder = new AnagramFinder(Dictionaries.SHORT_WORD_LIST_FILE_PATH);
		finder.processFile();
		
		long finish = System.currentTimeMillis();
		
		System.out.println("PROCESS TIME FOR " + finder.getNumberOfWordsProcessed() + " WORDS: " + (finish - start) + " ms");
		
		finder.info();
	}
}
