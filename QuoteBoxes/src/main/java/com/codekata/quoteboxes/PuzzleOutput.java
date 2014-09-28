package com.codekata.quoteboxes;

import java.util.List;

public class PuzzleOutput {

	private Quote m_quote;
	private List<PuzzleColumn> m_columns;
	private int m_numRows = 0;
	
	public PuzzleOutput(Quote quote, List<PuzzleColumn> columns) {
		m_quote = quote;
		m_columns = columns;
		m_numRows = m_columns.get(0).getSize();
	}
	
	public String getOutput() {
		// TODO - Formatted output
		return "TODO";
	}
	
	public String toString() {
		StringBuffer output = new StringBuffer();
		output.append("== " + m_quote.getPerson() + " ==\n");
		
		// Print the letter columns
		for (int rowNum = 0; rowNum < m_numRows; rowNum++) {
			StringBuffer rowOutput = new StringBuffer();
			
			for (PuzzleColumn column : m_columns) {
				rowOutput.append(column.getLetterAt(rowNum));
			}
			
			output.append(rowOutput.toString() + "\n");
		}
		
		output.append("A: " + m_quote.getQuote()+ "\n");
		
		return output.toString();
	}
}
