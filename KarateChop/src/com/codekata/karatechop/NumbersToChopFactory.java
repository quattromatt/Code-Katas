package com.codekata.karatechop;

import com.codekata.karatechop.impl.NumbersToChopImpl;

public class NumbersToChopFactory {

	public static NumbersToChop createNumbersToChop(int target, int[] numbers) {
		return new NumbersToChopImpl(target, numbers);
	}
}
