package com.codekata.backtothecheckout.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codekata.backtothecheckout.ICheckItemsOut;
import com.codekata.backtothecheckout.ICreateItemCheckOuters;
import com.codekata.backtothecheckout.IPriceItems;
import com.codekata.backtothecheckout.ITotalItemAmounts;

@Component("itemCheckOuterFactory")
public class ItemCheckOuterFactory implements ICreateItemCheckOuters {

	private ITotalItemAmounts m_itemAmountTotaller;
	
	@Autowired
	public ItemCheckOuterFactory(ITotalItemAmounts itemAmountTotaller) {
		m_itemAmountTotaller = itemAmountTotaller;
	}
	
	@Override
	public ICheckItemsOut create() {
		return new ItemCheckOuter(m_itemAmountTotaller);
	}

}
