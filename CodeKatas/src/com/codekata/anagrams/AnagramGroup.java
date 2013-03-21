package com.codekata.anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramGroup {

	private Map<Character, Integer> m_letters;
	private List<String> m_words = new ArrayList<String>();
	
	public AnagramGroup(String seedWord) {
		m_words.add(seedWord);
		m_letters = buildLettersMap(seedWord);
	}
	
	public boolean matchWord(String word) {
		
		// Is this word the correct length?
		if (word.length() != m_words.get(0).length()) {
			return false;
		}
		
		// Do all the letters match?
		Map<Character, Integer> letters = buildLettersMap(word);
		if (!letters.equals(m_letters)) {
			return false;
		}
		
		// Must be a match!
		m_words.add(word);
		
		
		return true;
	}
	
	private Map<Character, Integer> buildLettersMap(String word) {
		Map<Character, Integer> letters = new HashMap<Character, Integer>();
		
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			
			letters.put(c, letters.containsKey(c) ? letters.get(c) + 1 : 1);
		}
		
		return letters;
	}
	
	public int getNumberOfWords() {
		return m_words.size();
	}
	
	public void info() {
		StringBuffer info = new StringBuffer();
		info.append("I have " + m_words.size() + " words: ");
		
		boolean first = true;
		for (String word : m_words) {
			if (first) {
				first = false;
			} else {
				info.append(", ");
			}
			
			info.append(word);
		}
		
		System.out.println(info.toString());
	}
	
	public String getExampleWord() {
		return m_words.get(0);
	}
}
