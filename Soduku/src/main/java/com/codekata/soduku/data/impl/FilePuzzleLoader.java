package com.codekata.soduku.data.impl;

import com.codekata.soduku.data.ILoadPuzzles;
import com.codekata.soduku.data.Puzzle;
import com.codekata.util.output.IOutputInformation;
import com.codekata.util.output.impl.ConsoleOutputter;

public class FilePuzzleLoader implements ILoadPuzzles{

	private IOutputInformation m_output;
	
	public FilePuzzleLoader() {
		m_output = new ConsoleOutputter();
	}
	
	@Override
	public Puzzle load(String puzzle_name) {
		
		m_output.write("Loading puzzle '" + puzzle_name + "' from file");
		
		Puzzle puzzle = new Puzzle();
		
		return puzzle;
	}

}
