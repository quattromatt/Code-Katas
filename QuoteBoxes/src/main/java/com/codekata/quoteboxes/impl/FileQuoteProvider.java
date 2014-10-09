package com.codekata.quoteboxes.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.codekata.quoteboxes.IProvideQuotes;
import com.codekata.quoteboxes.Quote;

public class FileQuoteProvider implements IProvideQuotes {

	private static final String FILE_PATH = "/Users/mdavis/Documents/Git Repos/Code-Katas/QuoteBoxes/src/main/resources/quotes.txt";
	
	private List<Quote> m_quotes;
	
	public FileQuoteProvider() {
		m_quotes = new ArrayList<>();
		try {
			Stream<String> lines = Files.lines(Paths.get(FILE_PATH))
					.filter(s -> !s.isEmpty());
		    
		   Object[] filteredLines = lines.toArray();
		   
		   for (int i = 0; i < filteredLines.length; i += 2) {
			   if (i + 1 == filteredLines.length) {
				   continue;
			   }
			   
			   String line1 = (String)filteredLines[i + 1];
			   String line2 = (String)filteredLines[i];
			   
			   m_quotes.add(new Quote(line1, line2));
		   }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Quote> getQuotes() {
		return m_quotes;
	}
}
