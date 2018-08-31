package com.yash.teacoffee.vendingmachine.delegate;

import com.yash.teacoffee.vendingmachine.Vending.factory.TeaCoffeeVendingFactory;
import com.yash.teacoffee.vendingmachine.maintenance.factory.MaintenanceFactory;

public class Delegate {

	TeaCoffeeVendingFactory teaCoffeeVendingFactory;
	MaintenanceFactory maintenanceFactory;

	public Delegate() {
		teaCoffeeVendingFactory = new TeaCoffeeVendingFactory();
		maintenanceFactory = new MaintenanceFactory();
	}

	public void makeItem(String key, int count) {

		teaCoffeeVendingFactory.isItemDelivered(key).isDelivered(count);
 
	}

	public void ContainerAction(String action) {

		maintenanceFactory.takeContainerAction(action).checkContainerStatus();

	}

}
