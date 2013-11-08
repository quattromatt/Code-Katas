package com.codekata.countingcodelines.impl;

import org.springframework.stereotype.Component;

import com.codekata.countingcodelines.ITestCodeLines;

@Component
public class JavaCodeLineTester implements ITestCodeLines {

	@Override
	public boolean isCodeLine(String line) {
		// TODO Auto-generated method stub
		return true;
	}
}
