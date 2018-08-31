package com.yash.teacoffee.vendingmachine.delegate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.yash.teacoffee.vendingmachine.Vending.factory.TeaCoffeeVendingFactory;
import com.yash.teacoffee.vendingmachine.helper.TeaHelper;
import com.yash.teacoffee.vendingmachine.maintenance.factory.MaintenanceFactory;
import com.yash.teacoffee.vendingmachine.maintenance.helper.RefillContainerHelper;

@RunWith(MockitoJUnitRunner.class)
public class DelegateTest {

	@InjectMocks
	private Delegate delegate;

	@Mock
	private TeaCoffeeVendingFactory teaCoffeeVendingFactory;

	@Mock
	private MaintenanceFactory maintenanceFactory;

	@Mock
	private TeaHelper teaHelper;

	@Mock
	private RefillContainerHelper refillContainerHelper;

	@Test
	public void shouldCallMakeItemOnce() {

		Mockito.when(teaCoffeeVendingFactory.isItemDelivered("Tea")).thenReturn(teaHelper);
		Mockito.when(teaHelper.isDelivered(1)).thenReturn(true);

		delegate.makeItem("Tea", 1);

		Mockito.verify(teaCoffeeVendingFactory).isItemDelivered("Tea");
		Mockito.verify(teaHelper).isDelivered(1);
	}

	@Test
	public void shouldCallContainerAction() {

		Mockito.when(maintenanceFactory.takeContainerAction("REFILL CONTAINER")).thenReturn(refillContainerHelper);
		Mockito.when(refillContainerHelper.checkContainerStatus()).thenReturn(true);

		delegate.ContainerAction("REFILL CONTAINER");

		Mockito.verify(maintenanceFactory).takeContainerAction("REFILL CONTAINER");
		Mockito.verify(refillContainerHelper).checkContainerStatus();

	}
}
