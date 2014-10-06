package com.codekata.quoteboxes;

import java.util.ArrayList;
import java.util.List;

public class Puzzle {

	private static final int NUM_COLUMNS = 26;
	private static final int NUM_ROWS = 5;
	
	private Quote m_quote;
	private List<PuzzleColumn> m_columns = new ArrayList<>();
	
	public Puzzle(Quote quote) {
		
		// Initialize the columns
		initColumns();
		
		// Store the quote
		m_quote = quote;
		
		// Process the sentence
		processSentence();
	}
	
	private void processSentence() {
		String sentence = m_quote.getQuote();
		
		for (int i = 0; i < sentence.length(); i++) {
			char c = sentence.charAt(i);
			m_columns.get(i % NUM_COLUMNS).addCharacter(c + "");
		}
	}

	public void output() {
		PuzzleOutput output = new PuzzleOutput(m_quote, m_columns);
		output.outputFile();
	}
	
	private void initColumns() {
		for (int i = 0; i < NUM_COLUMNS; i++) {
			m_columns.add(new PuzzleColumn());
		}
	}
}
