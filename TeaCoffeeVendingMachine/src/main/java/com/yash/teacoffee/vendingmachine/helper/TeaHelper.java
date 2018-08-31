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

public class TeaHelper implements iTeaCoffeeItems, iUtility {

	@Override
	public boolean isDelivered(int count) {
 
		Container container = new Container();
		WasteMaterial wasteMaterial = new WasteMaterial();
		CupCost cupCost = new CupCost();
		CheckTotalSale checkTotalSale = new CheckTotalSale();
		ContainerStatus containerStatus = new ContainerStatus();
		WasteMaterialH wasteMaterialH = new WasteMaterialH();

		if (isEnoughMaterial(count)) {

			container.setTea(6 * count);
			container.setWater(65 * count);
			container.setMilk(45 * count);
			container.setSugar(17 * count);
			container.setCoffee(0);

			cupCost.setCost(10 * count);
			cupCost.setCup(count);

			wasteMaterial.setCoffee(0);
			wasteMaterial.setTea(1);
			wasteMaterial.setMilk(4);
			wasteMaterial.setWater(5);
			wasteMaterial.setSugar(2);

			containerStatus.consumeContainer(container);
			checkTotalSale.addTotalSale(TEA, cupCost);
			wasteMaterialH.addWasteMaterial(wasteMaterial);
			System.out.println("Order Delivered Successfully!");
			return true;
		}

		return false;
	}

	public Boolean isEnoughMaterial(int count) {

		ContainerStatus containerStatus1 = new ContainerStatus();
		Container containerStatus = containerStatus1.containerStatus();

		return (containerStatus.getTea() > (6 * count) && containerStatus.getWater() > (65 * count)
				&& containerStatus.getMilk() > (45 * count) && containerStatus.getSugar() > (17 * count)) ? true
						: false;

	}

}
