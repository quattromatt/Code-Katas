package com.codekata.quoteboxes;

public class Quote {

	private String m_person;
	private String m_quote;
	
	public Quote(String person, String quote) {
		m_person = scrubPerson(person);
		m_quote = scrubQuote(quote);
	}
	
	public String getPerson() {
		return m_person;
	}
	
	public String getQuote() {
		return m_quote;
	}
	
	public String toString() {
		return m_quote + " (" + m_person + ")";
	}
	
	private String scrubPerson(String person) {
		return person.substring(person.startsWith("-") ? 1 : 0).trim();
	}
	
	private String scrubQuote(String quote) {
		return quote.replaceAll("[^\\w\\s]", "");
	}
}
