package com.yash.teacoffee.vendingmachine.Vending.factory;

import static org.hamcrest.CoreMatchers.instanceOf;

import org.junit.Test;

import com.yash.teacoffee.vendingmachine.helper.BlackCoffeeHelper;
import com.yash.teacoffee.vendingmachine.helper.BlackTeaHelper;
import com.yash.teacoffee.vendingmachine.helper.CoffeeHelper;
import com.yash.teacoffee.vendingmachine.helper.TeaHelper;

public class TeaCoffeeVendingFactoryTest {

	TeaCoffeeVendingFactory teaCoffeeVendingFactory;

	@Test
	public void shouldReturnteaCoffeeVendingFactoryObject() {

		teaCoffeeVendingFactory = new TeaCoffeeVendingFactory();

		org.junit.Assert.assertThat(teaCoffeeVendingFactory, instanceOf(teaCoffeeVendingFactory.getClass()));
	}

	@Test
	public void shouldReturnteaTeaHelperObject() {

		teaCoffeeVendingFactory = new TeaCoffeeVendingFactory();

		TeaHelper teaHelper = new TeaHelper();

		org.junit.Assert.assertThat(teaHelper,
				instanceOf(teaCoffeeVendingFactory/* .getInstance() */.isItemDelivered("Tea").getClass()));
	}

	@Test
	public void shouldReturnteaCoffeeHelperObject() {

		teaCoffeeVendingFactory = new TeaCoffeeVendingFactory();

		CoffeeHelper coffeeHelper = new CoffeeHelper();

		org.junit.Assert.assertThat(coffeeHelper,
				instanceOf(teaCoffeeVendingFactory/* .getInstance() */.isItemDelivered("COFFEE").getClass()));
	}

	@Test
	public void shouldRetunBlackTeaHelperObject() {

		teaCoffeeVendingFactory = new TeaCoffeeVendingFactory();

		BlackTeaHelper blackTeaHelper = new BlackTeaHelper();

		org.junit.Assert.assertThat(blackTeaHelper,
				instanceOf(teaCoffeeVendingFactory/* .getInstance() */.isItemDelivered("BLACK TEA").getClass()));
	}

	@Test
	public void shouldRetunBlackCoffeeHelperObject() {

		teaCoffeeVendingFactory = new TeaCoffeeVendingFactory();

		BlackCoffeeHelper blackCoffeeHelper = new BlackCoffeeHelper();

		org.junit.Assert.assertThat(blackCoffeeHelper,
				instanceOf(teaCoffeeVendingFactory/* .getInstance() */.isItemDelivered("BLACK COFFEE").getClass()));
	}

	@Test
	public void shouldRetunTeaCoffeeHelperObjectIfDefaultPass() {

		teaCoffeeVendingFactory = new TeaCoffeeVendingFactory(); 

		TeaHelper teaHelper = new TeaHelper();

		org.junit.Assert.assertThat(teaHelper,
				instanceOf(teaCoffeeVendingFactory/* .getInstance() */.isItemDelivered("T").getClass()));
	}
}
