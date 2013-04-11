package com.codekata.backtothecheckout.impl;

import com.codekata.backtothecheckout.IPriceAnItem;
import com.codekata.backtothecheckout.IReturnItemsPriced;

/**
 * Item price that prices multiple items in a simple way.
 * Example: Pricing 4 items on sale 3/$1.00 will price only 3.
 */
public class SimpleMultipleItemPrice implements IPriceAnItem {

	private int m_quantity = 0;
	private double m_price = 0;
	
	public SimpleMultipleItemPrice(int quantity, double price) {
		m_quantity = quantity;
		m_price = price;
	}

	@Override
	public IReturnItemsPriced priceItems(int quantity) {
		
		int itemsPriced = 0;
		double price = 0;
		
		while (quantity >= m_quantity) {
			itemsPriced += m_quantity;
			quantity -= m_quantity;
			price += m_price;
		}
		
		return new ItemsPriced(itemsPriced, price);
	}
}
