package com.codekata.karatechop.impl;

import java.util.Arrays;

import com.codekata.karatechop.NumbersToChop;

public class NumbersToChopImpl implements NumbersToChop {
	
	private int m_target;
	private int[] m_numbers;
	private int m_currentIndex = 0;
	private int m_index = -1;
	
	public NumbersToChopImpl(int target, int[] numbers) {
		m_target = target;
		m_numbers = numbers;
		
		scan();
	}
	
	public int getIndex() {
		return m_index;
	}
	
	private void scan() {
		if (m_numbers.length == 0) {
			m_index = -1;
		} else if (m_numbers.length == 1) {
			m_index = m_numbers[0] == m_target ? 0 : -1;
		} else {
			int index = m_numbers.length / 2;
        	int valueAtIndex = m_numbers[index];
        	
        	if (valueAtIndex == m_target) {
        		m_index = m_currentIndex + index;
        	} else if (valueAtIndex < m_target) {
        		m_currentIndex += index;
        		m_numbers = Arrays.copyOfRange(m_numbers, index, m_numbers.length);
        		scan();
        	} else {
        		m_numbers = Arrays.copyOfRange(m_numbers, 0, index);
        		scan();
        	}
		}
	}
}
