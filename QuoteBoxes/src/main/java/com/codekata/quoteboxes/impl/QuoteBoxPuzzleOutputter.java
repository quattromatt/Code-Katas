package com.codekata.quoteboxes.impl;

import java.util.ArrayList;
import java.util.List;

import com.codekata.quoteboxes.IPuzzle;
import com.codekata.quoteboxes.PuzzleColumn;

public class QuoteBoxPuzzleOutputter extends PuzzleOutputter {

	private QuoteBoxPuzzle m_puzzle;
	
	@Override
	protected List<String> getPuzzleOutput(IPuzzle puzzle) {
		
		m_puzzle = (QuoteBoxPuzzle)puzzle;
		
		List<String> output = new ArrayList<>();
		
		addFileHeader(output);
		addPuzzle(output);		
		addFileFooter(output);
		
		return output;
	}
	
	private void addFileHeader(List<String> output) {
		output.add("<html>");
		output.add("<head>");
		output.add("<style>");
		
		output.add("#puzzle_cells");
		output.add("{");
		output.add("font-family:\"Trebuchet MS\", Arial, Helvetica, sans-serif;");
		output.add("margin-right: 20px;");
		output.add("border-collapse:collapse;");
		output.add("float: left;");
		output.add("}");
		output.add("#puzzle_cells td, #puzzle_cells th"); 
		output.add("{");
		output.add("font-size:1.2em;");
		output.add("border:1px solid #000000;");
		output.add("}");
		output.add("#puzzle_cells td.inactive");
		output.add("{");
		output.add("background-color:#000000;");
		output.add("}");
		output.add("#puzzle_cells td.shaded");
		output.add("{");
		output.add("background-color:#888888;");
		output.add("}");
		
		output.add("</style>");
		output.add("</head>");
		output.add("<body>");
	}
	
	private void addPuzzle(List<String> output) {
		List<String> letters = new ArrayList<>();
		List<String> cells = new ArrayList<>();
		
		output.add("<div>" + m_puzzle.getQuote().getPerson() + "</div><div><table id=\"puzzle_cells\" cellspacing=\"0\" cellpadding=\"0\">");
		
		// Print the letter columns
		for (int rowNum = 0; rowNum < m_puzzle.getNumRows(); rowNum++) {
			
			// Add the letters
			letters.add("<tr>");
			for (PuzzleColumn column : m_puzzle.getColumns()) {
				String letter = column.getLetterAt(rowNum);
				addPuzzleSquare(letters, " ".equals(letter) ? "shaded" : "white", " ".equals(letter) ? "&nbsp;" : letter);
			}
			letters.add("</tr>");
			
			// Add the cells
			cells.add("<tr>");
			for (PuzzleColumn column : m_puzzle.getColumns()) {
				addPuzzleSquare(cells, column.isLetterAt(rowNum) ? "white" : "inactive", "&nbsp;");
			}
			cells.add("</tr>");
		}
		
		output.addAll(letters);
		output.addAll(cells);
		
		output.add("</table></div>");
	}
	
	private void addPuzzleSquare(List<String> squares, String imageName, String contents) {
		squares.add("<td><div style=\"position: relative\">");
		squares.add("<img src=\"../src/main/resources/images/" + imageName + ".png\" style=\"width:2em; height:2em; border: 0; padding: 0\" />");
		squares.add("<span style=\"position: absolute; top: 50%; left: 50%; margin-top: -0.6em; margin-left: -0.3em\">" + contents + "</span>");
		squares.add("</div></td>");
	}
	
	private void addFileFooter(List<String> output) {
		output.add("</body>");
		output.add("</html>");
	}
}
