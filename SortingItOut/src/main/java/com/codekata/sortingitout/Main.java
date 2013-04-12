package com.codekata.sortingitout;

import com.codekata.sortingitout.impl.AlphabetLetterSorter;
import com.codekata.sortingitout.impl.LimitedNumberSorter;

public class Main {

	public static void main(String[] args) {
		
		// Limited number sorter
		Sorter limitedNumberSorter = new LimitedNumberSorter(59);
		
		limitedNumberSorter.addItemToSort("57");
		limitedNumberSorter.addItemToSort("13");
		limitedNumberSorter.addItemToSort("22");
		limitedNumberSorter.addItemToSort("5");
		limitedNumberSorter.addItemToSort("21");
		limitedNumberSorter.addItemToSort("20");
		
		System.out.println("Sorted = " + limitedNumberSorter.displaySorted());
		
		// Alphabet letter sorter
		Sorter alphabetLetterSorter = new AlphabetLetterSorter();
		
		alphabetLetterSorter.addItemToSort("When not studying nuclear physics, Bambi likes to play beach volleyball.");
		
		System.out.println("Sorted = " + alphabetLetterSorter.displaySorted());
	}
}
