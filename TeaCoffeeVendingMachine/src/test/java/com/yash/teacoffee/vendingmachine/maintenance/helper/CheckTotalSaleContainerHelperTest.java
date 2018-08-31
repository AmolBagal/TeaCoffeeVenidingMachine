package com.yash.teacoffee.vendingmachine.maintenance.helper;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import org.mockito.runners.MockitoJUnitRunner;

import com.yash.teacoffee.vendingmachine.Model.Container;
import com.yash.teacoffee.vendingmachine.Model.CupCost;
import com.yash.teacoffee.vendingmachine.Model.TotalCost;
import com.yash.teacoffee.vendingmachine.utility.CheckTotalSale;
import static org.hamcrest.CoreMatchers.instanceOf;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class CheckTotalSaleContainerHelperTest {

	@InjectMocks
	CheckTotalSaleContainerHelper checkTotalSaleContainerHelper;

	@Mock
	CheckTotalSale checkTotalSale;

	@Test
	public void shouldReturnCheckTotalSaleObjectWhenReadTotalSaleCalled() {

		TotalCost totalCost = new TotalCost();

		Mockito.when(checkTotalSale.readTotalSale()).thenReturn(totalCost);

		org.junit.Assert.assertThat(totalCost, instanceOf(checkTotalSaleContainerHelper.readTotalSale().getClass()));
	}

	@Test
	public void shouldReturnTrueWhenTotalCostIsNotEmpty() {

		CupCost cupCost = new CupCost();
		cupCost.setCost(20);
		cupCost.setCup(5);

		TotalCost totalCost = new TotalCost();
		totalCost.addcostMap("Tea", cupCost);

		Mockito.when(checkTotalSale.readTotalSale()).thenReturn(totalCost);

		Assert.assertEquals(true, checkTotalSaleContainerHelper.checkContainerStatus());
	}

}
