package com.codekata.backtothecheckout.impl;

import com.codekata.backtothecheckout.IReturnItemsPriced;

public class ItemsPriced implements IReturnItemsPriced {

	private int m_quantity;
	private double m_price;
	
	public ItemsPriced(int quantity, double price) {
		m_quantity = quantity;
		m_price = price;
	}
	
	@Override
	public int getQuantity() {
		return m_quantity;
	}

	@Override
	public double getPrice() {
		return m_price;
	}
}
