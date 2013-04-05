package com.codekata.backtothecheckout;

import java.util.Map;

public interface ITotalItemAmounts {

	public double totalItems(Map<String, Integer> items, IPriceItems pricingRules);
}
