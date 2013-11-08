package com.codekata.countingcodelines;

import org.springframework.context.ApplicationContext;

public class Main {

	private static final String SOURCE_FILE = "/Users/mdavis/Documents/Git Repos/Code-Katas/CountingCodeLines/src/main/java/com/codekata/countingcodelines/Main.java";
	
	public static void main(String[] args) {
		System.out.println("Counting code lines!");
		
		Bootstrap.init();
		
		// Get the application context
		ApplicationContext context = Bootstrap.getContext();

        // Get the code line counter
		ICountCodeLines codeLineCounter = context.getBean(ICountCodeLines.class);
		
		// Count the number of lines of code
		Class<?> clazz = Main.class;
		int numLinesOfCode = codeLineCounter.countCodeLines(SOURCE_FILE);
		
		// Give some output
		System.out.println("I found " + numLinesOfCode + " of code in " + clazz.getName());
	}
}
