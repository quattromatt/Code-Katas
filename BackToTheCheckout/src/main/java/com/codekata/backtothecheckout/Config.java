package com.codekata.backtothecheckout;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.codekata.backtothecheckout.impl.ItemPrice;

@Configuration
@ComponentScan("com.codekata.backtothecheckout")
public class Config {

	public static final String REGULAR_PRICES = "regularPrices";
	public static final String SALE_PRICES = "salePrices";

	@Bean(name = REGULAR_PRICES)
	public Map<String, IPriceAnItem> regularPrices() {
		
		Map<String, IPriceAnItem> regularPrices = new HashMap<>();
		
		regularPrices.put("A", new ItemPrice("A", 1, 50.00));
		regularPrices.put("B", new ItemPrice("B", 1, 30.00));
		regularPrices.put("C", new ItemPrice("C", 1, 20.00));
		regularPrices.put("D", new ItemPrice("D", 1, 15.00));
		
		return regularPrices;
	}
	
	@Bean(name = SALE_PRICES)
	public Map<String, IPriceAnItem> salePrices() {
		
		Map<String, IPriceAnItem> salePrices = new HashMap<>();
		
		salePrices.put("A", new ItemPrice("A", 3, 130.00));
		salePrices.put("B", new ItemPrice("B", 2, 45.00));
		
		return salePrices;
	}
}
