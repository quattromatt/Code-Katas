package com.codekata.anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.codekata.util.FileProcessor;

public class AnagramFinder extends FileProcessor {

	private int m_wordIndex = 1;
	private List<AnagramGroup> m_anagramGroups = new ArrayList<AnagramGroup>();
	private Map<Character, List<AnagramGroup>> m_anagramGroupsByChar = new HashMap<Character, List<AnagramGroup>>();
	
	public AnagramFinder (String filePath) {
		super(filePath);
	}
	
	@Override
	protected void processLine(String line) {

		String word = line.trim().toLowerCase();
		List<AnagramGroup> groupsChecked = new ArrayList<AnagramGroup>();
		
		boolean matchFound = false;
		
		loopThroughAllLetters:
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			List<AnagramGroup> anagramGroups = m_anagramGroupsByChar.get(c);

			if (anagramGroups != null) {
				for (AnagramGroup groupToCheck : anagramGroups) {
					if (!groupsChecked.contains(groupToCheck)) {
						if (groupToCheck.matchWord(word)) {
							matchFound = true;
							break loopThroughAllLetters;
						}
					}
				}
			}
		}
		
		if (!matchFound) {
			saveAnagramGroup(word);
		}
		
		m_wordIndex++;
	}
	
//	@Override
	protected void processLine_v1(String line) {
		String word = line.trim().toLowerCase();
		
		if (m_anagramGroups.isEmpty()) {
			m_anagramGroups.add(new AnagramGroup(word));
		} else {
			
			// Check against the existing anagram groups
			for (AnagramGroup anagramGroup : m_anagramGroups) {
				if (anagramGroup.matchWord(word)) {
					break;
				}
			}
			
			m_anagramGroups.add(new AnagramGroup(word));
		}
		
		m_wordIndex++;
	}
	
	public int getNumberOfWordsProcessed() {
		return m_wordIndex - 1;
	}
	
	public void info_v1() {
		System.out.println("== THERE ARE " + m_anagramGroups.size() + " ANAGRAM GROUPS ==");
		for (AnagramGroup anagramGroup : m_anagramGroups) {
			if (anagramGroup.getNumberOfWords() > 1) {
				anagramGroup.info();
			}
		}
	}
	
	public void info() {

		List<AnagramGroup> groupsPrinted = new ArrayList<AnagramGroup>();
		int count = 0;
		
		for (List<AnagramGroup> groups : m_anagramGroupsByChar.values()) {
			for (AnagramGroup group : groups) {
				if (group.getNumberOfWords() > 1 && !groupsPrinted.contains(group)) {
					group.info();
					groupsPrinted.add(group);
					count++;
				}
			}
		}
		
		System.out.println("NUMBER OF GROUPS WITH MORE THAN ONE WORD: " + count);
	}
	
	private void saveAnagramGroup(String word) {
		AnagramGroup group = new AnagramGroup(word);
		char c = word.charAt(0);
		
		if (m_anagramGroupsByChar.get(c) == null) {
			m_anagramGroupsByChar.put(c, new ArrayList<AnagramGroup>());
		}
		
		if (!m_anagramGroupsByChar.get(c).contains(group)) {
			m_anagramGroupsByChar.get(c).add(group);
		}
	}
}
