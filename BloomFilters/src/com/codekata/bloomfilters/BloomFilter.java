package com.codekata.bloomfilters;

import java.util.BitSet;
import java.util.List;

public class BloomFilter {

	private BitSet m_bitmap = new BitSet();
	private List<HashFunction> m_hashFunctions;

	/**
	 * Load a list of hash functions
	 * @param hashFunctions
	 */
	public void loadHashFunctions(List<HashFunction> hashFunctions) {
		m_hashFunctions = hashFunctions;
	}
	
	/**
	 * Load an array of valid words
	 * @param validWords
	 */
	public void loadWords(String [] validWords) {
		for (String validWord : validWords) {
			loadWord(validWord);
		}
	}
	
	/**
	 * Load a valid word
	 * @param validWord
	 */
	private void loadWord(String validWord) {
		validWord = prepWord(validWord);
		for (HashFunction hashFunction : m_hashFunctions) {
			int index = hashFunction.hash(validWord);
//			System.out.println(validWord = " -> " + index);
			m_bitmap.set(index);
		}
	}
	
	/**
	 * Checks to see if a word is valid
	 * @param word
	 * @return
	 */
	public boolean isWordValid(String word) {
		word = prepWord(word);
		for (HashFunction hashFunction : m_hashFunctions) {
			int index = hashFunction.hash(word);
			
			if (!m_bitmap.get(index)) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Resets the bloom filter to having no hash functions and no stored valid words
	 */
	public void reset() {
		m_hashFunctions.clear();
		m_bitmap.clear();
	}
	
	private String prepWord(String word) {
		return word.toLowerCase();
	}
}
