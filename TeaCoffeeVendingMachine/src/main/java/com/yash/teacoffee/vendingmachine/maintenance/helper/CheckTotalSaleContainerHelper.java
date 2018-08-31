package com.yash.teacoffee.vendingmachine.maintenance.helper;

import com.yash.teacoffee.vendingmachine.Model.TotalCost;
import com.yash.teacoffee.vendingmachine.imaintenance.iContainerStatus;
import com.yash.teacoffee.vendingmachine.utility.CheckTotalSale;

public class CheckTotalSaleContainerHelper implements iContainerStatus {

	@Override
	public boolean checkContainerStatus() {

		CheckTotalSaleContainerHelper checkTotalSaleContainerHelper = new CheckTotalSaleContainerHelper();

		TotalCost totalCost = new TotalCost();

		totalCost = readTotalSale();

		System.out.println("              " + "Cup" + " " + "Cost");
		System.out.println(

				"Tea           " + totalCost.getMap().get("Tea").getCup() + " "
						+ totalCost.getMap().get("Tea").getCost());
		System.out.println("Coffee:        " + totalCost.getMap().get("Coffee").getCup() + " "
				+ totalCost.getMap().get("Coffee").getCost());

		System.out.println("Black Tea:     " + totalCost.getMap().get("Black Tea").getCup() + " "
				+ totalCost.getMap().get("Black Tea").getCost());
		System.out.println("Black Coffee:  " + totalCost.getMap().get("Black Coffee").getCup() + " "
				+ totalCost.getMap().get("Black Coffee").getCost());
		return true;
		// }
		// return false;
	}
 
	public TotalCost readTotalSale() {

		CheckTotalSale checkTotalSale = new CheckTotalSale();

		return checkTotalSale.readTotalSale();
	}

}
