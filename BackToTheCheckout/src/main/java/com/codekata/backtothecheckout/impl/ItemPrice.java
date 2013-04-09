package com.codekata.backtothecheckout.impl;

import com.codekata.backtothecheckout.IPriceAnItem;

public class ItemPrice implements IPriceAnItem {

	private String m_sku;
	private int m_quantity = 0;
	private double m_price = 0;
	
	public ItemPrice(String sku, int quantity, double price) {
		m_sku = sku;
		m_quantity = quantity;
		m_price = price;
	}
	
	@Override
	public String getSku() {
		return m_sku;
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
