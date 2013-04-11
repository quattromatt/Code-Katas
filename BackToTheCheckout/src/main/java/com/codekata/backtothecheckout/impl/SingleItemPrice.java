package com.codekata.backtothecheckout.impl;

import com.codekata.backtothecheckout.IPriceAnItem;
import com.codekata.backtothecheckout.IReturnItemsPriced;

/**
 * Item price that will pricer items based on 1/$x.xx.
 * This price should be used as the regular price for any item.
 */
public class SingleItemPrice implements IPriceAnItem {

	private double m_price = 0;
	
	public SingleItemPrice(double price) {
		m_price = price;
	}

	@Override
	public IReturnItemsPriced priceItems(int quantity) {
		return quantity > 0 ?
				new ItemsPriced(quantity, (m_price * quantity)) :
				new ItemsPriced(0, 0);
	}
}
