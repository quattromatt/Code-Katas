package com.codekata.backtothecheckout.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.codekata.backtothecheckout.IPriceAnItem;
import com.codekata.backtothecheckout.IPriceItems;

@Component
public class ItemsPricer implements IPriceItems {

	private Map<String, IPriceAnItem> m_regularPrices;
	private Map<String, IPriceAnItem> m_salePrices;
	
	@Override
	public IPriceAnItem getRegularPrice(String sku) {
		return m_regularPrices.get(sku);
	}

	@Override
	public IPriceAnItem getSalePrice(String sku) {
		return m_salePrices.get(sku);
	}
	
	/*
	 * We have to inject the price maps this way because Spring
	 * doesn't support autowiring in collections.  See:
	 * https://jira.springsource.org/browse/SPR-8519 
	 */
	@Resource
	public void setRegularPrices(Map<String, IPriceAnItem> regularPrices) {
		m_regularPrices = regularPrices;
	}
	
	@Resource
	public void setSalePrices(Map<String, IPriceAnItem> salePrices) {
		m_salePrices = salePrices;
	}
}
