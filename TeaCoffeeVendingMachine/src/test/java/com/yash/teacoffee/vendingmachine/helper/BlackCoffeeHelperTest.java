package com.yash.teacoffee.vendingmachine.helper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnit44Runner;
import org.mockito.runners.MockitoJUnitRunner;

import com.yash.teacoffee.vendingmachine.Model.Container;
import com.yash.teacoffee.vendingmachine.Model.CupCost;
import com.yash.teacoffee.vendingmachine.Model.WasteMaterial;
import com.yash.teacoffee.vendingmachine.utility.CheckTotalSale;
import com.yash.teacoffee.vendingmachine.utility.ContainerStatus;
import com.yash.teacoffee.vendingmachine.utility.WasteMaterialH;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class BlackCoffeeHelperTest { 

	@InjectMocks
	BlackCoffeeHelper blackCoffeeHelper; 

	@Mock
	ContainerStatus containerStatus1;  
 
	@Mock
	CheckTotalSale checkTotalSale; 

	@Mock
	WasteMaterialH wasteMaterialH;

	@Test
	public void shouldReturnTrueIfOrderNotDelivered1() {

		// BlackCoffeeHelper blackCoffeeHelper = new BlackCoffeeHelper();
		Container container = new Container();
		container.setCoffee(1110);
		container.setMilk(1110);
		container.setSugar(1110); 
		container.setTea(1110);
		container.setWater(1110);
		Mockito.when(containerStatus1.containerStatus()).thenReturn(container);
		org.junit.Assert.assertEquals(true, blackCoffeeHelper.isEnoughMaterial(1));
		// Mockito.verify(containerStatus1).containerStatus();
	}

	@Test
	public void shouldReturnFalseIfOrderNotDelivered1() {

		// BlackCoffeeHelper blackCoffeeHelper = new BlackCoffeeHelper();
		Container container = new Container();
		container.setCoffee(110);
		container.setMilk(110);
		container.setSugar(110);
		container.setTea(110);
		container.setWater(110);
		Mockito.when(containerStatus1.containerStatus()).thenReturn(container);
		org.junit.Assert.assertEquals(false, blackCoffeeHelper.isEnoughMaterial(100));
		// Mockito.verify(containerStatus1).containerStatus();
	}

	@Test
	public void shouldReturnTrueIfBlackCoffeeDelivered() {
		Container container = new Container();
		CupCost cupCost = new CupCost();
		WasteMaterial wasteMaterial = new WasteMaterial();

		containerStatus1.containerStatus();

		container.setTea(1110);
		container.setWater(1110);
		container.setMilk(1110);
		container.setSugar(1110);
		container.setCoffee(1110);

		Mockito.when(containerStatus1.containerStatus()).thenReturn(container);
		Mockito.doNothing().when(containerStatus1).consumeContainer(container);
		Mockito.doNothing().when(checkTotalSale).addTotalSale("", cupCost);
		Mockito.doNothing().when(wasteMaterialH).addWasteMaterial(wasteMaterial);

		Assert.assertEquals(true, blackCoffeeHelper.isDelivered(1));

	}

	@Test
	public void shoouldReturnFalseIfBlackCoffeeNotDelivered() {

		Container container = new Container();
		CupCost cupCost = new CupCost();
		WasteMaterial wasteMaterial = new WasteMaterial();

		containerStatus1.containerStatus();

		container.setTea(10); 
		container.setWater(10);
		container.setMilk(10);
		container.setSugar(10); 
		container.setCoffee(10);

		Mockito.when(containerStatus1.containerStatus()).thenReturn(container);
		Mockito.doNothing().when(containerStatus1).consumeContainer(container);
		Mockito.doNothing().when(checkTotalSale).addTotalSale("", cupCost);
		Mockito.doNothing().when(wasteMaterialH).addWasteMaterial(wasteMaterial);

		Assert.assertEquals(false, blackCoffeeHelper.isDelivered(1));

	}
}
