package com.codekata.quoteboxes;

import com.codekata.quoteboxes.impl.QuoteBoxPuzzleGenerator;

public class Main {

	public static void main(String[] args) {
		IGeneratePuzzles puzzleGenerator = new QuoteBoxPuzzleGenerator();
		puzzleGenerator.generatePuzzles();
	}
}
