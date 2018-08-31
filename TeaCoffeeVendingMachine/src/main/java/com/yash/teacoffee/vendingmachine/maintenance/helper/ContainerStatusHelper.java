package com.yash.teacoffee.vendingmachine.maintenance.helper;

import com.yash.teacoffee.vendingmachine.Model.Container;
import com.yash.teacoffee.vendingmachine.imaintenance.iContainerStatus;
import com.yash.teacoffee.vendingmachine.utility.ContainerStatus;

public class ContainerStatusHelper implements iContainerStatus {

	@Override
	public boolean checkContainerStatus() {

		ContainerStatusHelper containerStatusHelper = new ContainerStatusHelper();
		Container container = new Container();
		container = containerStatusHelper.getContainerStatus();

		// if (container != null) {
		System.out.println("Tea:        " + container.getTea());
		System.out.println("Coffee:     " + container.getCoffee());
		System.out.println("Water:      " + container.getWater());
		System.out.println("Sugar:      " + container.getSugar());
		System.out.println("Milk:       " + container.getMilk());
		return true;
		// }
		//
		// return false;
	}

	public Container getContainerStatus() {
		ContainerStatus containerStatus1 = new ContainerStatus();
		return containerStatus1.containerStatus();
	}

}
