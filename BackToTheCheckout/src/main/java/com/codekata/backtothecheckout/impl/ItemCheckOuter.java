package com.codekata.backtothecheckout.impl;

import java.util.HashMap;
import java.util.Map;

import com.codekata.backtothecheckout.ICheckItemsOut;
import com.codekata.backtothecheckout.IPriceItems;

public class ItemCheckOuter implements ICheckItemsOut {

	private Map<String, Integer> m_items;
	private IPriceItems m_pricingRules;

	public ItemCheckOuter(IPriceItems pricingRules) {
		m_items = new HashMap<>();
		m_pricingRules = pricingRules;
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
		
		// TODO - Inject this
		ItemAmountTotaller itemAmountTotaller = new ItemAmountTotaller();
		return itemAmountTotaller.totalItems(m_items, m_pricingRules);
	}

}
