package com.codekata.countingcodelines.impl;

import com.codekata.countingcodelines.ITestCodeLines;

public abstract class CodeLineTester implements ITestCodeLines {

	private boolean m_insideSingleLineComment = false;
	private boolean m_insideMultiLineComment = false;
	private boolean m_insideString = false;
	
	@Override
	public boolean isCodeLine(String line) {

		boolean isCodeLine = false;
		
		// Go ahead and do away with any spaces
		line = line.replace(" ", "");
		
		// Handle lines with one character
		if (line.length() == 1) {
			return !isInsideMultiLineComment();
		}
		
		// Loop through all the characters
		for (int i = 0; i < line.length() - 1; i++) {
			char char1 = line.charAt(i);
			char char2 = line.charAt(i + 1);
			
			if (startsSingleLineComment(char1, char2)) {
				return isCodeLine;
			}
			
			if (startsMultiLineComment(char1, char2)) {
				m_insideMultiLineComment = true;
			} else if (endsMultiLineComment(char1, char2)) {
				m_insideMultiLineComment = false;
			}
		}
		
		
		
		
		
		
		
		return isCodeLine;
	}
	
	protected abstract boolean startsSingleLineComment(char char1, char char2);
	
	protected abstract boolean startsMultiLineComment(char char1, char char2);
	
	protected abstract boolean endsMultiLineComment(char char1, char char2);
	
	protected boolean isInsideSingleLineComment() {
		return m_insideSingleLineComment;
	}
	
	protected boolean isInsideMultiLineComment() {
		return m_insideMultiLineComment;
	}
	
	protected boolean isInsideString() {
		return m_insideString;
	}
}
