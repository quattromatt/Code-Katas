package com.codekata.backtothecheckout.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.codekata.backtothecheckout.Config;
import com.codekata.backtothecheckout.ICheckItemsOut;
import com.codekata.backtothecheckout.ICreateItemCheckOuters;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=Config.class, loader=AnnotationConfigContextLoader.class)
public class CheckOutTest {

	@Autowired
	public ICreateItemCheckOuters itemCheckOuterFactory;
	
	@Test
	public void testTotals() throws Exception {
		
		Assert.assertEquals(0, price(""), 0);
		Assert.assertEquals(50, price("A"), 0);
		Assert.assertEquals(80, price("AB"), 0);
		Assert.assertEquals(115, price("CDBA"), 0);

		Assert.assertEquals(100, price("AA"), 0);
		Assert.assertEquals(130, price("AAA"), 0);
		Assert.assertEquals(180, price("AAAA"), 0);
		Assert.assertEquals(230, price("AAAAA"), 0);
		Assert.assertEquals(260, price("AAAAAA"), 0);

		Assert.assertEquals(160, price("AAAB"), 0);
		Assert.assertEquals(175, price("AAABB"), 0);
		Assert.assertEquals(190, price("AAABBD"), 0);
		Assert.assertEquals(190, price("DABABA"), 0);
	}
	
	@Test
	public void testIncremental() throws Exception {
		
		// Get a checkout
		ICheckItemsOut checkout = getCheckOut();
		
		Assert.assertEquals(0, checkout.total(), 0);
		
		checkout.scan("A");
		Assert.assertEquals(50, checkout.total(), 0);
		
		checkout.scan("B");
		Assert.assertEquals(80, checkout.total(), 0);
		
		checkout.scan("A");
		Assert.assertEquals(130, checkout.total(), 0);
		
		checkout.scan("A");
		Assert.assertEquals(160, checkout.total(), 0);
		
		checkout.scan("B");
		Assert.assertEquals(175, checkout.total(), 0);
	}
	
	private double price(String items) {
		
		// Get a checkout
		ICheckItemsOut checkout = getCheckOut();
		
		// Loop through the items and scan them
		for (int i = 0; i < items.length(); i++) {
			char item = items.charAt(i);
			checkout.scan("" + item);
		}
		
		// Return the total 
		return checkout.total();
	}
	
	/**
	 * Get an ICheckItemsOut from the factory
	 * @return
	 */
	private ICheckItemsOut getCheckOut() {
		return itemCheckOuterFactory.create();
	}
}
