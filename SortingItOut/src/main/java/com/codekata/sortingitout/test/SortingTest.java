package com.codekata.sortingitout.test;

import org.junit.Assert;
import org.junit.Test;

import com.codekata.sortingitout.Sorter;
import com.codekata.sortingitout.impl.AlphabetLetterSorter;
import com.codekata.sortingitout.impl.LimitedNumberSorter;

public class SortingTest {

	@Test
	public void testNumberSorter() throws Exception {

		// Limited number sorter
		Sorter limitedNumberSorter = new LimitedNumberSorter(59);

		limitedNumberSorter.addItemToSort("57");
		limitedNumberSorter.addItemToSort("13");
		limitedNumberSorter.addItemToSort("22");
		limitedNumberSorter.addItemToSort("5");
		limitedNumberSorter.addItemToSort("21");
		limitedNumberSorter.addItemToSort("20");
		limitedNumberSorter.addItemToSort("2");
		limitedNumberSorter.addItemToSort("33");

		Assert.assertEquals(limitedNumberSorter.displaySorted(), "2, 5, 13, 20, 21, 22, 33, 57");

	}

	@Test
	public void testAlphabetLetterSorter() throws Exception {

		// Alphabet letter sorter
		Sorter alphabetLetterSorter = new AlphabetLetterSorter();

		alphabetLetterSorter.addItemToSort("When not studying nuclear physics, Bambi likes to play beach volleyball.");

		Assert.assertEquals(alphabetLetterSorter.displaySorted(), "aaaaabbbbcccdeeeeeghhhiiiiklllllllmnnnnooopprsssstttuuvwyyyy");
	}
}
