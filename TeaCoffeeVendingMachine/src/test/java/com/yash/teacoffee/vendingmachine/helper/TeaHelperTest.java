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
public class TeaHelperTest {

	@InjectMocks
	TeaHelper teaHelper;

	@Mock
	ContainerStatus containerStatus;

	@Mock
	CheckTotalSale checkTotalSale;

	@Mock
	WasteMaterialH wasteMaterialH;

	@Test
	public void shouldReturnTrueIfMaterialIsEnough() {

		Container container = new Container();
		container.setCoffee(1110);
		container.setMilk(1110);
		container.setSugar(1110);
		container.setTea(1110); 
		container.setWater(1110);

		Mockito.when(containerStatus.containerStatus()).thenReturn(container);

		org.junit.Assert.assertEquals(true, teaHelper.isEnoughMaterial(1));
	}

	@Test
	public void shouldReturnFalseIfMaterialIsNotEnough() {

		Container container = new Container();
		container.setCoffee(1110);
		container.setMilk(1110);
		container.setSugar(1110);
		container.setTea(1110);
		container.setWater(1110);

		Mockito.when(containerStatus.containerStatus()).thenReturn(container);

		org.junit.Assert.assertEquals(false, teaHelper.isEnoughMaterial(10000));
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
		Mockito.doNothing().when(checkTotalSale).addTotalSale("tea", cupCost);
		Mockito.doNothing().when(wasteMaterialH).addWasteMaterial(wasteMaterial);

		org.junit.Assert.assertEquals(true, teaHelper.isDelivered(1));
	}

	@Test
	public void shouldReturnFalseIfOrderNotDelievered() {

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
		Mockito.doNothing().when(checkTotalSale).addTotalSale("tea", cupCost);
		Mockito.doNothing().when(wasteMaterialH).addWasteMaterial(wasteMaterial);

		org.junit.Assert.assertEquals(false, teaHelper.isDelivered(10000));

	}
}
