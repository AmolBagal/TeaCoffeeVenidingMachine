package com.yash.teacoffee.vendingmachine.Vending.factory;

import com.yash.teacoffee.vendingmachine.helper.BlackTeaHelper;
import com.yash.teacoffee.vendingmachine.helper.BlackCoffeeHelper;
import com.yash.teacoffee.vendingmachine.helper.CoffeeHelper;
import com.yash.teacoffee.vendingmachine.helper.TeaHelper;
import com.yash.teacoffee.vendingmachine.iItems.iTeaCoffeeItems;
import com.yash.teacoffee.vendingmachine.iItems.iTeaCoffeeItemsNames;

public class TeaCoffeeVendingFactory implements iTeaCoffeeItemsNames {

	public iTeaCoffeeItems isItemDelivered(String name) {

		String key = name.toUpperCase();

		switch (key) {
		case TEA:
			return new TeaHelper();

		case COFFEE:
			return new CoffeeHelper();

		case BLACKTEA:
			return new BlackTeaHelper();

		case BLACKCOFFEE:
			return new BlackCoffeeHelper();
		default:
			return new TeaHelper();
		}

	}

}
