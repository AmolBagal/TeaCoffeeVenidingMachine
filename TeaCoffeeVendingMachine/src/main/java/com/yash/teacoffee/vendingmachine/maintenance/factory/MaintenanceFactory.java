package com.yash.teacoffee.vendingmachine.maintenance.factory;

import com.yash.teacoffee.vendingmachine.imaintenance.iContainerStatus;
import com.yash.teacoffee.vendingmachine.imaintenance.iMaintenanceName;
import com.yash.teacoffee.vendingmachine.maintenance.helper.CheckTotalSaleContainerHelper;
import com.yash.teacoffee.vendingmachine.maintenance.helper.ContainerStatusHelper;
import com.yash.teacoffee.vendingmachine.maintenance.helper.RefillContainerHelper;
import com.yash.teacoffee.vendingmachine.maintenance.helper.ResetContainerHelper;

public class MaintenanceFactory implements iMaintenanceName {

	/*
	 * private MaintenanceFactory instance;
	 * 
	 * public MaintenanceFactory getInstance() { if (instance == null) {
	 * synchronized (MaintenanceFactory.class) { instance = new
	 * MaintenanceFactory(); } } return instance; }
	 */

	public iContainerStatus takeContainerAction(String action) {

		String key = action.toUpperCase();
		switch (key) {

		case REFILLCONTAINER:
			return new RefillContainerHelper();
 
		case CHECKTOTALSALE:
			return new CheckTotalSaleContainerHelper();

		case CONTAINERSTATUS:
			return new ContainerStatusHelper();

		case RESETCONTAINER:
			return new ResetContainerHelper();
		default:
			return new RefillContainerHelper();
		}

	}
}
