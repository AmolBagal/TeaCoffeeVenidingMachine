package com.yash.teacoffee.vendingmachine.helper;

import com.yash.teacoffee.vendingmachine.Model.Container;
import com.yash.teacoffee.vendingmachine.Model.CupCost;
import com.yash.teacoffee.vendingmachine.Model.TotalCost;
import com.yash.teacoffee.vendingmachine.Model.WasteMaterial;
import com.yash.teacoffee.vendingmachine.iItems.iTeaCoffeeItems;
import com.yash.teacoffee.vendingmachine.iutility.iUtility;
import com.yash.teacoffee.vendingmachine.utility.CheckTotalSale;
import com.yash.teacoffee.vendingmachine.utility.ContainerStatus;
import com.yash.teacoffee.vendingmachine.utility.WasteMaterialH;

public class CoffeeHelper implements iTeaCoffeeItems, iUtility {

	@Override
	public boolean isDelivered(int count) {

		Container container = new Container();
		WasteMaterial wasteMaterial = new WasteMaterial();
		CupCost cupCost = new CupCost();
		CheckTotalSale checkTotalSale = new CheckTotalSale();
		ContainerStatus containerStatus = new ContainerStatus();
		WasteMaterialH wasteMaterialH = new WasteMaterialH();
 
		if (isEnoughMaterial(count)) {

			container.setTea(0);
			container.setWater(23 * count);
			container.setMilk(88 * count);
			container.setSugar(17 * count);
			container.setCoffee(5 * count);

			cupCost.setCost(15 * count);
			cupCost.setCup(count);

			wasteMaterial.setCoffee(1);
			wasteMaterial.setTea(0);
			wasteMaterial.setMilk(8);
			wasteMaterial.setWater(3); 
			wasteMaterial.setSugar(2);

			containerStatus.consumeContainer(container);
			checkTotalSale.addTotalSale(COFFEE, cupCost);
			wasteMaterialH.addWasteMaterial(wasteMaterial);

			System.out.println("Order Delivered Successfully!");
			return true;

		}
		return false;
	}

	public Boolean isEnoughMaterial(int count) {

		ContainerStatus containerStatus1 = new ContainerStatus();
		Container containerStatus = containerStatus1.containerStatus();

		return (containerStatus.getCoffee() > (5 * count) && containerStatus.getWater() > (23 * count)
				&& containerStatus.getMilk() > (88 * count) && containerStatus.getSugar() > (17 * count)) ? true
						: false;

	}

}
