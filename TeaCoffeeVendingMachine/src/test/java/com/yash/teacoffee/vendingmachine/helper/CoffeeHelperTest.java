package com.yash.teacoffee.vendingmachine.helper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.yash.teacoffee.vendingmachine.Model.Container;
import com.yash.teacoffee.vendingmachine.Model.CupCost;
import com.yash.teacoffee.vendingmachine.Model.TotalCost;
import com.yash.teacoffee.vendingmachine.Model.WasteMaterial;
import com.yash.teacoffee.vendingmachine.utility.CheckTotalSale;
import com.yash.teacoffee.vendingmachine.utility.ContainerStatus;
import com.yash.teacoffee.vendingmachine.utility.WasteMaterialH;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class CoffeeHelperTest {

	@InjectMocks
	CoffeeHelper coffeeHelper;

	@Mock
	ContainerStatus containerStatus; 

	@Mock
	WasteMaterialH wasteMaterialH;

	@Mock
	CheckTotalSale checkTotalSale;

	@Test
	public void shouldReturnTrueIfMaterialIsEnough() {

		Container container = new Container();
		container.setCoffee(1110);
		container.setMilk(1110);
		container.setSugar(1110);
		container.setTea(1110);
		container.setWater(1110);

		Mockito.when(containerStatus.containerStatus()).thenReturn(container);

		org.junit.Assert.assertEquals(true, coffeeHelper.isEnoughMaterial(1));
	}

	@Test
	public void shouldReturnFalseIfMaterialIsNotEnough() {

		Container container = new Container();
		container.setCoffee(10);
		container.setMilk(10);
		container.setSugar(10);
		container.setTea(10);
		container.setWater(10);

		Mockito.when(containerStatus.containerStatus()).thenReturn(container);

		org.junit.Assert.assertEquals(false, coffeeHelper.isEnoughMaterial(1000));
	}

	@Test
	public void shouldReturnTrueIfOrderDeliveredSuccessfully() {

		Container container = new Container();
		container.setCoffee(1110);
		container.setMilk(1110);
		container.setSugar(1110);
		container.setTea(1110);
		container.setWater(1110);

		CupCost cupCost = new CupCost();

		WasteMaterial wasteMaterial = new WasteMaterial();

		Mockito.when(containerStatus.containerStatus()).thenReturn(container);

		Mockito.doNothing().when(containerStatus).consumeContainer(container);
		Mockito.doNothing().when(checkTotalSale).addTotalSale("Tea", cupCost);
		Mockito.doNothing().when(wasteMaterialH).addWasteMaterial(wasteMaterial);

		org.junit.Assert.assertEquals(true, coffeeHelper.isDelivered(1));
	}

	@Test
	public void shouldReturnFalseIfOrderNotDeliveredSuccessfully() {

		Container container = new Container();
		container.setCoffee(10);
		container.setMilk(10);
		container.setSugar(10);
		container.setTea(10);
		container.setWater(10);

		CupCost cupCost = new CupCost();

		WasteMaterial wasteMaterial = new WasteMaterial();

		Mockito.when(containerStatus.containerStatus()).thenReturn(container);

		Mockito.doNothing().when(containerStatus).consumeContainer(container);
		Mockito.doNothing().when(checkTotalSale).addTotalSale("Tea", cupCost);
		Mockito.doNothing().when(wasteMaterialH).addWasteMaterial(wasteMaterial);

		org.junit.Assert.assertEquals(false, coffeeHelper.isDelivered(10000));
	}
}
