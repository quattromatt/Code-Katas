package com.codekata.soduku;

import com.codekata.soduku.data.ILoadPuzzles;
import com.codekata.soduku.data.Puzzle;
import com.codekata.soduku.data.impl.FilePuzzleLoader;
import com.codekata.soduku.logic.ISolvePuzzles;
import com.codekata.soduku.logic.impl.BasicPuzzleSolver;

public class Main {

	public static void main(String[] args) {
		System.out.println("Let's play Soduku...");
		
		ILoadPuzzles puzzle_loader = new FilePuzzleLoader();
		Puzzle puzzle = puzzle_loader.load("foobar");
		
		ISolvePuzzles puzzle_solver = new BasicPuzzleSolver();
		puzzle_solver.solve(puzzle);
	}
}
