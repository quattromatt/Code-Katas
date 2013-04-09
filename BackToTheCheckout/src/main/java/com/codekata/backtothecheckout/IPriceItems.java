package com.codekata.backtothecheckout;

public interface IPriceItems {

	public IPriceAnItem getRegularPrice(String sku);
	public IPriceAnItem getSalePrice(String sku);
}
