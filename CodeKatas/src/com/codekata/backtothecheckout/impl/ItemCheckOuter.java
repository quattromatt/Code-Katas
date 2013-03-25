package com.codekata.backtothecheckout.impl;

import com.codekata.backtothecheckout.ICheckItemsOut;
import com.codekata.backtothecheckout.IPriceItems;

public class ItemCheckOuter implements ICheckItemsOut {

	private IPriceItems m_pricingRules;

	public ItemCheckOuter(IPriceItems pricingRules) {
		m_pricingRules = pricingRules;
	}
	
	@Override
	public void scan(char item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double total() {
		// TODO Auto-generated method stub
		return 0;
	}

}
