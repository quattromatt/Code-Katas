package com.codekata.countingcodelines.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codekata.countingcodelines.ICountCodeLines;
import com.codekata.countingcodelines.ITestCodeLines;
import com.codekata.util.FileProcessor;

@Component
public class CodeLineCounter extends FileProcessor implements ICountCodeLines {
	
	private ITestCodeLines m_codeLineTester;
	private int m_numberCodeLines = 0;
	
	@Autowired
	public CodeLineCounter(ITestCodeLines codeLineTester) {
		m_codeLineTester = codeLineTester;
	}
	
	@Override
	public int countCodeLines(String sourceFilePath) {
		
		m_numberCodeLines = 0;
		
		processFile(sourceFilePath);

		return m_numberCodeLines;
	}

	@Override
	protected void processLine(String line) {
		if (m_codeLineTester.isCodeLine(line)) {
			m_numberCodeLines++;
		}
	}
}
