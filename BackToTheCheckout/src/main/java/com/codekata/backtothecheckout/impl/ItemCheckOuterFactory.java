package com.codekata.backtothecheckout.impl;

import com.codekata.backtothecheckout.ICheckItemsOut;
import com.codekata.backtothecheckout.ICreateItemCheckOuters;
import com.codekata.backtothecheckout.IPriceItems;

public class ItemCheckOuterFactory implements ICreateItemCheckOuters {

	@Override
	public ICheckItemsOut create(IPriceItems pricingRules) {
		return new ItemCheckOuter(pricingRules);
	}

}
