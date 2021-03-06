package com.codekata.quoteboxes.impl;

import java.util.ArrayList;
import java.util.List;

import com.codekata.quoteboxes.IPuzzle;
import com.codekata.quoteboxes.PuzzleColumn;
import com.codekata.quoteboxes.Quote;

public class QuoteBoxPuzzle implements IPuzzle {
private static final int NUM_COLUMNS = 26;
	
	private Quote m_quote;
	private List<PuzzleColumn> m_columns = new ArrayList<>();
	
	public QuoteBoxPuzzle(Quote quote) {
		
		// Initialize the columns
		initColumns();
		
		// Store the quote
		m_quote = quote;
		
		// Process the sentence
		processSentence();
	}
	
	@Override
	public String getBaseFileName() {
		return getQuote().getPerson().replace(" ", "");
	}
	
	public Quote getQuote() {
		return m_quote;
	}
	
	public List<PuzzleColumn> getColumns() {
		return m_columns;
	}
	
	public int getNumRows() {
		return m_columns.get(0).getSize();
	}
	
	private void processSentence() {
		String sentence = m_quote.getQuote();
		
		for (int i = 0; i < sentence.length(); i++) {
			char c = sentence.charAt(i);
			m_columns.get(i % NUM_COLUMNS).addCharacter(c + "");
		}
	}
	
	public int getDifficulty() {
		int numRows = getNumRows();
		
		int difficulty = 0;
		
		switch (numRows) {
			case 7 :
				difficulty = 4;
				break;
			case 6 :
				difficulty = 3;
				break;
			case 5:
			case 4:
				difficulty = 2;
				break;
			case 3 :
				difficulty = 1;
				break;
		}
		
		return difficulty;
	}
	
	private void initColumns() {
		for (int i = 0; i < NUM_COLUMNS; i++) {
			m_columns.add(new PuzzleColumn());
		}
	}
}
