package com.yash.teacoffee.vendingmachine.helper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.yash.teacoffee.vendingmachine.Model.Container;
import com.yash.teacoffee.vendingmachine.Model.CupCost;
import com.yash.teacoffee.vendingmachine.Model.WasteMaterial;
import com.yash.teacoffee.vendingmachine.utility.CheckTotalSale;
import com.yash.teacoffee.vendingmachine.utility.ContainerStatus; 
import com.yash.teacoffee.vendingmachine.utility.WasteMaterialH;

@RunWith(MockitoJUnitRunner.class)
public class BlackTeaHelperTest {

	@InjectMocks
	BlackTeaHelper blackTeaHelper;

	@Mock
	ContainerStatus containerStatus;

	@Mock
	WasteMaterialH wasteMaterialH; 

	@Mock
	CheckTotalSale checkTotalSale;

	@Test
	public void shouldReturnTrueIfEnoughMaterialIsThere() {

		Container container = new Container();
		container.setCoffee(1110);
		container.setMilk(1110);
		container.setSugar(1110);
		container.setTea(1110);
		container.setWater(1110);

		Mockito.when(containerStatus.containerStatus()).thenReturn(container);

		org.junit.Assert.assertEquals(true, blackTeaHelper.isEnoughMaterial(1));

	}

	@Test
	public void shouldReturnFalseIfMaterialIsNotEnough() {

		Container container = new Container();
		container.setCoffee(110);
		container.setMilk(110);
		container.setSugar(110);
		container.setTea(110);
		container.setWater(110);

		Mockito.when(containerStatus.containerStatus()).thenReturn(container);

		org.junit.Assert.assertEquals(false, blackTeaHelper.isEnoughMaterial(10000));
	}

	@Test
	public void shouldReturnTrueIfOrderIsDelievered() {
		Container container = new Container();
		CupCost cupCost = new CupCost();
		WasteMaterial wasteMaterial = new WasteMaterial();

		container.setTea(3);
		container.setWater(112);
		container.setMilk(0);
		container.setSugar(17);
		container.setCoffee(0);

		cupCost.setCost(5);
		cupCost.setCup(1);

		wasteMaterial.setCoffee(0);
		wasteMaterial.setTea(0);
		wasteMaterial.setMilk(0);
		wasteMaterial.setWater(12);
		wasteMaterial.setSugar(2);

		Mockito.when(containerStatus.containerStatus()).thenReturn(container);
		Mockito.doNothing().when(containerStatus).consumeContainer(container);
		Mockito.doNothing().when(wasteMaterialH).addWasteMaterial(wasteMaterial);
		Mockito.doNothing().when(checkTotalSale).addTotalSale("", cupCost);

		org.junit.Assert.assertEquals(true, blackTeaHelper.isDelivered(1));
	}

	@Test
	public void shouldReturnFalseIfOrderIsNotDelievered() {
		Container container = new Container();
		CupCost cupCost = new CupCost();
		WasteMaterial wasteMaterial = new WasteMaterial();

		container.setTea(3);
		container.setWater(112);
		container.setMilk(0);
		container.setSugar(17);
		container.setCoffee(0);

		cupCost.setCost(5);
		cupCost.setCup(1);

		wasteMaterial.setCoffee(0);
		wasteMaterial.setTea(0);
		wasteMaterial.setMilk(0);
		wasteMaterial.setWater(12);
		wasteMaterial.setSugar(2);

		Mockito.when(containerStatus.containerStatus()).thenReturn(container);
		Mockito.doNothing().when(containerStatus).consumeContainer(container);
		Mockito.doNothing().when(wasteMaterialH).addWasteMaterial(wasteMaterial);
		Mockito.doNothing().when(checkTotalSale).addTotalSale("", cupCost);

		org.junit.Assert.assertEquals(false, blackTeaHelper.isDelivered(10000));
	}

}
