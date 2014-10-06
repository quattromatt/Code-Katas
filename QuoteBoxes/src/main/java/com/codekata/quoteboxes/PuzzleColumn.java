package com.codekata.quoteboxes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PuzzleColumn {

	private List<Boolean> m_cells;
	private List<String> m_letters;
	
	public PuzzleColumn() {
		m_cells = new ArrayList<>();
		m_letters = new ArrayList<>();
	}
	
	public void addCharacter(String character) {
		character = character.toUpperCase();
		m_cells.add(!" ".equals(character));
		if (!" ".equals(character)) {
			m_letters.add(character);
			
			Collections.sort(m_letters);
		}
	}
	
	public boolean isLetterAt(int rowIndex) {
		return m_cells.size() > rowIndex && m_cells.get(rowIndex);
	}
	
	public String getLetterAt(int rowIndex) {
		return m_letters.size() <= rowIndex ? " " : m_letters.get(rowIndex);
	}
	
	public int getSize() {
		return m_cells.size();
	}
}
