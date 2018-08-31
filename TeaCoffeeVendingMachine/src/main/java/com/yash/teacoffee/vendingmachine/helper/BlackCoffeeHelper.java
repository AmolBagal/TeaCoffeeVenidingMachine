package com.yash.teacoffee.vendingmachine.helper;

import com.yash.teacoffee.vendingmachine.Model.Container;
import com.yash.teacoffee.vendingmachine.Model.CupCost;
import com.yash.teacoffee.vendingmachine.Model.WasteMaterial;
import com.yash.teacoffee.vendingmachine.iItems.iTeaCoffeeItems;
import com.yash.teacoffee.vendingmachine.iutility.iUtility;
import com.yash.teacoffee.vendingmachine.utility.CheckTotalSale;
import com.yash.teacoffee.vendingmachine.utility.ContainerStatus;
import com.yash.teacoffee.vendingmachine.utility.WasteMaterialH;

public class BlackCoffeeHelper implements iTeaCoffeeItems, iUtility {
	ContainerStatus containerStatus1;
	private BlackCoffeeHelper blackCoffeeHelper;

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
			container.setWater(112 * count);
			container.setMilk(0);
			container.setSugar(17 * count);
			container.setCoffee(3 * count);

			cupCost.setCost(15 * count);
			cupCost.setCup(count);

			wasteMaterial.setCoffee(0);
			wasteMaterial.setTea(0);
			wasteMaterial.setMilk(0);
			wasteMaterial.setWater(12);
			wasteMaterial.setSugar(2);

			containerStatus.consumeContainer(container);
			checkTotalSale.addTotalSale(BLACKCOFFEE, cupCost);
			wasteMaterialH.addWasteMaterial(wasteMaterial);

			System.out.println("Order Delivered Successfully!");

			return true;

		}
		return false;
	}
 
	public Boolean isEnoughMaterial(int count) {

		Container containerStatus = containerStatus1.containerStatus();

		if ((containerStatus.getCoffee() > (3 * count) && containerStatus.getWater() > (112 * count)
				&& containerStatus.getSugar() > (17 * count))) {
			return true;
		} else {
			return false;
		}
 
	}

}
