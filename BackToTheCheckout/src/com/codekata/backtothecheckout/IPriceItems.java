package com.codekata.backtothecheckout;

import com.codekata.backtothecheckout.impl.ItemPrice;

public interface IPriceItems {

	public void addRegularPrice(ItemPrice itemPrice);
	public void addSalePrice(ItemPrice itemPrice);
	public IPriceAnItem getRegularPrice(String sku);
	public IPriceAnItem getSalePrice(String sku);
}
