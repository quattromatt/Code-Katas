package com.codekata.sortingitout.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import com.codekata.sortingitout.Sorter;

public class AlphabetLetterSorter implements Sorter {

	private Map<Character, Integer> m_alphabet = new LinkedHashMap<>();
	
	public AlphabetLetterSorter() {
		
		// Initialize the letter count
		m_alphabet.put('a', 0);
		m_alphabet.put('b', 0);
		m_alphabet.put('c', 0);
		m_alphabet.put('d', 0);
		m_alphabet.put('e', 0);
		m_alphabet.put('f', 0);
		m_alphabet.put('g', 0);
		m_alphabet.put('h', 0);
		m_alphabet.put('i', 0);
		m_alphabet.put('j', 0);
		m_alphabet.put('k', 0);
		m_alphabet.put('l', 0);
		m_alphabet.put('m', 0);
		m_alphabet.put('n', 0);
		m_alphabet.put('o', 0);
		m_alphabet.put('p', 0);
		m_alphabet.put('q', 0);
		m_alphabet.put('r', 0);
		m_alphabet.put('s', 0);
		m_alphabet.put('t', 0);
		m_alphabet.put('u', 0);
		m_alphabet.put('v', 0);
		m_alphabet.put('w', 0);
		m_alphabet.put('x', 0);
		m_alphabet.put('y', 0);
		m_alphabet.put('z', 0);
	}
	
	@Override
	public void addItemToSort(String item) {
		
		// First lowercase the whole string
		item = item.toLowerCase();
		
		// Loop through the characters
		for (int i = 0; i < item.length(); i++) {
			
			// Get the character
			char c = item.charAt(i);
			
			// Increment the count
			if (m_alphabet.containsKey(c)) {
				m_alphabet.put(c, m_alphabet.get(c) + 1);
			}
		}
	}

	@Override
	public String displaySorted() {
		
		StringBuilder display = new StringBuilder();
		
		for (Character c : m_alphabet.keySet()) {
			
			for (int i = 0; i < m_alphabet.get(c); i++) {
				display.append(c);
			}
		}
		
		return display.toString();
	}
}
