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
		person = person.trim();
		person = person.substring(person.startsWith("-") ? 1 : 0).trim();
		
		int index = person.indexOf('(');
		
		return index != -1 ?
				person.substring(0, index - 1) :
				person;
	}
	
	private String scrubQuote(String quote) {
		return quote.replaceAll("[^\\w\\s]", "");
	}
}
