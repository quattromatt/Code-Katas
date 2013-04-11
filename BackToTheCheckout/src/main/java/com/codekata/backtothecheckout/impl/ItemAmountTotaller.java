package com.codekata.backtothecheckout.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codekata.backtothecheckout.IPriceAnItem;
import com.codekata.backtothecheckout.IPriceItems;
import com.codekata.backtothecheckout.IReturnItemsPriced;
import com.codekata.backtothecheckout.ITotalItemAmounts;

@Component
public class ItemAmountTotaller implements ITotalItemAmounts {

	private IPriceItems m_itemsPricer;
	
	@Autowired
	public ItemAmountTotaller(IPriceItems itemsPricer) {
		m_itemsPricer = itemsPricer;
	}
	
	@Override
	public double totalItems(Map<String, Integer> items) {
		
		double totalPrice = 0;
		
		for (String sku : items.keySet()) {
			int quantity = items.get(sku);
			totalPrice += totalItem(sku, quantity);
		}
		
		return totalPrice;
	}

	private double totalItem(String sku, int quantity) {
		
		IPriceAnItem regularPrice = m_itemsPricer.getRegularPrice(sku);
		IPriceAnItem salesPrice = m_itemsPricer.getSalePrice(sku);
		
		double totalPrice = 0;
		
		// Check any sales price
		if (salesPrice != null) {
			IReturnItemsPriced itemsPricedOnSale = salesPrice.priceItems(quantity);
			quantity -= itemsPricedOnSale.getQuantity();
			totalPrice += itemsPricedOnSale.getPrice();
		}
		
		// Check the regular price
		IReturnItemsPriced itemsPriced = regularPrice.priceItems(quantity);
		quantity -= itemsPriced.getQuantity();
		totalPrice += itemsPriced.getPrice();
		
//		while (quantity > 0) {
//			
//			// Decide which price to use for this set of items
//			IPriceAnItem price = (salesPrice != null && salesPrice.getQuantity() <= quantity) ?
//				salesPrice : regularPrice;
//
//			// Now increment the total
//			totalPrice = totalPrice += price.getPrice();
//			
//			// ...and decrement the quantity we're totalling
//			quantity -= price.getQuantity();
//		}

		return totalPrice;
	}
}
