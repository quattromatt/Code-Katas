package com.codekata.datamunging;

import com.codekata.util.FileProcessor;

public abstract class FileDataMunger extends FileProcessor {

	public static final String CSV_CHAR = ",";
	
	public FileDataMunger(String filePath) {
		super(filePath);
	}
	
	@Override
	protected void processLine(String line) {
		if (isValidDataLine(line)) {
			processDataLine(line);
		}
	}
	
	private void processDataLine(String line) {
		String csvLine = line.replaceAll("\\s+", CSV_CHAR);
		String[] data = csvLine.split(CSV_CHAR);
		
		if (data.length < 3) {
			return;
		}

		processData(data);
	}
	
	private boolean isValidDataLine(String line) {
		return Character.isDigit(line.charAt(0));
	}
	
	protected abstract void processData(String[] data);
	public abstract void printOutput();
}
