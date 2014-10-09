package com.codekata.quoteboxes.impl;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.codekata.quoteboxes.IOutputPuzzles;
import com.codekata.quoteboxes.IPuzzle;
import com.codekata.quoteboxes.PuzzleColumn;

public abstract class PuzzleOutputter implements IOutputPuzzles {

	private static final String OUTPUT_DIR = "./output/";
	
	@Override
	public void output(IPuzzle puzzle) {

		System.out.println("Outputting puzzle " + puzzle.getBaseFileName());
		
		Path outputFile = Paths.get(OUTPUT_DIR, puzzle.getDifficulty() + " - " + puzzle.getBaseFileName() + ".html");
		Charset charset = Charset.forName("utf-8");
		
		List<String> output = getPuzzleOutput(puzzle);
		
		try {
			Files.write(outputFile, output, charset);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected abstract List<String> getPuzzleOutput(IPuzzle puzzle);
	
}
