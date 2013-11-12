package com.codekata.countingcodelines.impl;

import org.springframework.stereotype.Component;

import com.codekata.countingcodelines.ITestCodeLines;

@Component
public class JavaCodeLineTester extends CodeLineTester implements ITestCodeLines {

	@Override
	protected boolean startsSingleLineComment(char char1, char char2) {
		return '/' == char1 && '/' == char2;
	}

	@Override
	protected boolean startsMultiLineComment(char char1, char char2) {
		return '/' == char1 && '*' == char2;
	}

	@Override
	protected boolean endsMultiLineComment(char char1, char char2) {
		return '*' == char1 && '/' == char2;
	}
}
