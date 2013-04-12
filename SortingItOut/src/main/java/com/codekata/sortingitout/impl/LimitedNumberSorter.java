package com.codekata.sortingitout.impl;

import com.codekata.sortingitout.Sorter;

/**
 * This sorter takes advantage of the fact that there is a limited range
 * of numbers that will be sorted (for example, 0 - 59).  An array can
 * be used, and the numbers to sort are stored by setting a flag at that
 * index in the array.
 * 
 * @author mdavis
 *
 */
public class LimitedNumberSorter implements Sorter {
	
	private Boolean[] m_sortedNumbers;
	
	public LimitedNumberSorter(int maxNumber) {
		
		// Initialize the size of the array
		m_sortedNumbers = new Boolean[maxNumber + 1];
	}
	
	@Override
	public void addItemToSort(String item) {
		
		int number = 0;
		
		try {
			number = Integer.parseInt(item);
		} catch (NumberFormatException e) {
			throw new RuntimeException("I only sort numbers!");
		}
		
		m_sortedNumbers[number] = true;
	}
	
	@Override
	public String displaySorted() {
		
		StringBuilder display = new StringBuilder();
		
		boolean first = true;
		
		// Loop through the array and build the display
		for (int i = 0; i < m_sortedNumbers.length; i++) {
			if (m_sortedNumbers[i] == null || !m_sortedNumbers[i]) {
				continue;
			}
			
			if (first) {
				first = false;
			} else {
				display.append(", ");
			}
			
			display.append(i);
		}
		
		return display.toString();
	}
}
