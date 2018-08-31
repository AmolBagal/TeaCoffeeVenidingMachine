package com.yash.teacoffee.vendingmachine.maintenance.factory;

import static org.hamcrest.CoreMatchers.instanceOf;

import org.junit.Test;

import com.yash.teacoffee.vendingmachine.maintenance.helper.CheckTotalSaleContainerHelper;
import com.yash.teacoffee.vendingmachine.maintenance.helper.ContainerStatusHelper;
import com.yash.teacoffee.vendingmachine.maintenance.helper.RefillContainerHelper;
import com.yash.teacoffee.vendingmachine.maintenance.helper.ResetContainerHelper;

import junit.framework.Assert;

public class MaintenanceFactoryTest {

	private MaintenanceFactory maintenanceFactory;

	@Test
	public void shouldReturnMaintenanceFactoryObjectIfInstanceIsNotCreated() {

		maintenanceFactory = new MaintenanceFactory();
 
		org.junit.Assert.assertThat(maintenanceFactory,
				instanceOf(maintenanceFactory/* .getInstance() */.getClass()));

	}

	@Test
	public void shouldReturnRefillContainerHelperObjectWhenRefillContainerPassed() {

		maintenanceFactory = new MaintenanceFactory();
		RefillContainerHelper refillContainerHelper = new RefillContainerHelper();

		org.junit.Assert.assertThat(refillContainerHelper,
				instanceOf(maintenanceFactory/* .getInstance() */.takeContainerAction("REFILL CONTAINER").getClass()));
	}

	@Test
	public void shouldReturnCheckTotalSaleContainerHelperObjectWhenCheckTotalSalePassed() {

		maintenanceFactory = new MaintenanceFactory();
		CheckTotalSaleContainerHelper checkTotalSaleContainerHelper = new CheckTotalSaleContainerHelper();

		org.junit.Assert.assertThat(new CheckTotalSaleContainerHelper(),
				instanceOf(maintenanceFactory/* .getInstance() */.takeContainerAction("CHECK TOTAL SALE").getClass()));
	}

	@Test
	public void shouldReturnContainerStatusHelperObjectWhenContainerStatusHelperPassed() {

		maintenanceFactory = new MaintenanceFactory();

		ContainerStatusHelper containerStatusHelper = new ContainerStatusHelper();

		org.junit.Assert.assertThat(new ContainerStatusHelper(),
				instanceOf(maintenanceFactory/* .getInstance() */.takeContainerAction("CONTAINER STATUS").getClass()));

	}

	@Test
	public void shouldReturnResetContainerObjectWhenResetContainerPassed() {

		maintenanceFactory = new MaintenanceFactory();

		org.junit.Assert.assertThat(new ResetContainerHelper(),
				instanceOf(maintenanceFactory/* .getInstance() */.takeContainerAction("RESET CONTAINER").getClass()));

	}

	@Test
	public void shouldReturnRefillContainerHelperObjectWhenDefaultCasePassed() {

		maintenanceFactory = new MaintenanceFactory();
		RefillContainerHelper refillContainerHelper = new RefillContainerHelper();

		org.junit.Assert.assertThat(refillContainerHelper,
				instanceOf(maintenanceFactory/* .getInstance() */.takeContainerAction("r").getClass()));
	}
	// @Test(expected = NullPointerException.class)

}
