package com.yash.teacoffee.vendingmachine.MainClass;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.yash.teacoffee.vendingmachine.Model.InputScanner;
import com.yash.teacoffee.vendingmachine.delegate.Delegate;

@RunWith(MockitoJUnitRunner.class)
public class SelectItemTest {
	
	@InjectMocks
	SelectItem selectItem;

	@Mock
	Delegate delegate;

	@Mock
	InputScanner scanner;

	@Test
	public void shouldCallMakeItemForTea() {

		// Mockito.doNothing().when(selectItem);
		Mockito.doNothing().when(delegate).makeItem("TEA", 1);
		Mockito.when(scanner.getString()).thenReturn("JI").thenReturn("n");
		selectItem.selectItem("TEA", 1);
		Mockito.verify(delegate).makeItem("TEA", 1);

	}

	@Test
	public void shouldCallMakeItemForCoffee() {

		// Mockito.doNothing().when(selectItem);
		Mockito.doNothing().when(delegate).makeItem("COFFEE", 1);
		Mockito.when(scanner.getString()).thenReturn("JI").thenReturn("n");
		selectItem.selectItem("COFFEE", 1);
		Mockito.verify(delegate).makeItem("COFFEE", 1);

	}

	@Test
	public void shouldCallMakeItemForBlackCoffee() {

		// Mockito.doNothing().when(selectItem);
		Mockito.doNothing().when(delegate).makeItem("BLACK COFFEE", 1);
		Mockito.when(scanner.getString()).thenReturn("JI").thenReturn("n");
		selectItem.selectItem("BLACK COFFEE", 1);
		Mockito.verify(delegate).makeItem("BLACK COFFEE", 1);

	}

	@Test
	public void shouldCallMakeItemForBlackTea() {

		// Mockito.doNothing().when(selectItem);
		Mockito.doNothing().when(delegate).makeItem("BLACK TEA", 1);
		Mockito.when(scanner.getString()).thenReturn("JI").thenReturn("n");
		selectItem.selectItem("BLACK TEA", 1);
		Mockito.verify(delegate).makeItem("BLACK TEA", 1);

	}

	@Test
	public void shouldCallMakeItemForRefillContainer() {

		// Mockito.doNothing().when(selectItem);
		Mockito.doNothing().when(delegate).ContainerAction("REFILL CONTAINER");
		Mockito.when(scanner.getString()).thenReturn("JI").thenReturn("n");
		selectItem.selectItem("REFILL CONTAINER", 1);
		Mockito.verify(delegate).ContainerAction("REFILL CONTAINER");

	}

	@Test
	public void shouldCallMakeItemForCheckTotalSale() {

		// Mockito.doNothing().when(selectItem);
		Mockito.doNothing().when(delegate).ContainerAction("CHECK TOTAL SALE");
		Mockito.when(scanner.getString()).thenReturn("JI").thenReturn("n");
		selectItem.selectItem("CHECK TOTAL SALE", 1);
		Mockito.verify(delegate).ContainerAction("CHECK TOTAL SALE");

	}

	@Test
	public void shouldCallMakeItemForContainerStatus() {

		// Mockito.doNothing().when(selectItem);
		Mockito.doNothing().when(delegate).ContainerAction("CONTAINER STATUS");
		Mockito.when(scanner.getString()).thenReturn("JI").thenReturn("n");
		selectItem.selectItem("CONTAINER STATUS", 1);
		Mockito.verify(delegate).ContainerAction("CONTAINER STATUS");

	}

	@Test
	public void shouldCallMakeItemForResetContainer() {

		// Mockito.doNothing().when(selectItem);
		Mockito.doNothing().when(delegate).ContainerAction("RESET CONTAINER");
		Mockito.when(scanner.getString()).thenReturn("JI").thenReturn("n");
		selectItem.selectItem("RESET CONTAINER", 1);
		Mockito.verify(delegate).ContainerAction("RESET CONTAINER");

	}

}
