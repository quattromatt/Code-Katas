package com.codekata.quoteboxes;

import com.codekata.quoteboxes.impl.FileQuoteProvider;

public class Main {

	public static void main(String[] args) {
		System.out.println("-- Quote Boxes --");
		
		IProvideQuotes quoteProvider = new FileQuoteProvider();
		
		for (Quote quote : quoteProvider.getQuotes()) {
			Puzzle puzzle = new Puzzle(quote);
			puzzle.output();
//			puzzle.debug();
		}
	}
}
