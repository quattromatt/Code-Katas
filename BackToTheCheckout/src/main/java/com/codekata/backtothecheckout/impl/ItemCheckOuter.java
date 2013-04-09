package com.codekata.backtothecheckout.impl;

import java.util.HashMap;
import java.util.Map;

import com.codekata.backtothecheckout.ICheckItemsOut;
import com.codekata.backtothecheckout.ITotalItemAmounts;

public class ItemCheckOuter implements ICheckItemsOut {

	private Map<String, Integer> m_items = new HashMap<>();
	private ITotalItemAmounts m_itemAmountTotaller;

	public ItemCheckOuter(ITotalItemAmounts itemAmountTotaller) {
		m_itemAmountTotaller = itemAmountTotaller;
	}
	
	@Override
	public void scan(String sku) {
		
		// See if we need to initialize the item in the item map
		if (!m_items.containsKey(sku)) {
			m_items.put(sku, 0);
		}
		
		// ...and increment the item count
		m_items.put(sku, m_items.get(sku) + 1);
	}

	@Override
	public double total() {
		return m_itemAmountTotaller.totalItems(m_items);
	}
}
