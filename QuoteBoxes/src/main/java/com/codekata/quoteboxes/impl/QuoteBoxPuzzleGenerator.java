package com.codekata.quoteboxes.impl;

import com.codekata.quoteboxes.IGeneratePuzzles;
import com.codekata.quoteboxes.IOutputPuzzles;
import com.codekata.quoteboxes.IProvideQuotes;
import com.codekata.quoteboxes.IPuzzle;
import com.codekata.quoteboxes.Quote;

public class QuoteBoxPuzzleGenerator implements IGeneratePuzzles {

	@Override
	public void generatePuzzles() {
		
		// Get some quotes
		IProvideQuotes quoteProvider = new FileQuoteProvider();
		
		// Get a puzzle outputter
		IOutputPuzzles puzzleOutputter = new QuoteBoxPuzzleOutputter();

		// Generate the puzzles and output them
		for (Quote quote : quoteProvider.getQuotes()) {
			IPuzzle puzzle = new QuoteBoxPuzzle(quote);
			puzzleOutputter.output(puzzle);
		}
	}
}
