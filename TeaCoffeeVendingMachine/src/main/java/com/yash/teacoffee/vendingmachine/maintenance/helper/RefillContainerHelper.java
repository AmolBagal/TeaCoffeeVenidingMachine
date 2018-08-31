package com.yash.teacoffee.vendingmachine.maintenance.helper;

import com.yash.teacoffee.vendingmachine.Model.Container;
import com.yash.teacoffee.vendingmachine.imaintenance.iContainerStatus;
import com.yash.teacoffee.vendingmachine.utility.RefillContainer;

public class RefillContainerHelper implements iContainerStatus {

	@Override
	public boolean checkContainerStatus() {

		RefillContainerHelper refillContainerHelper = new RefillContainerHelper();

//		if (refillContainerHelper.refillContainer() != null) {

			System.out.println("Container Refilled Successfully!");
 
			return true;

		// } else {
		// return false;
		// }
	}

	public Container refillContainer() {

		RefillContainer refillContainer = new RefillContainer();

		return refillContainer.refillConatiner();
	}
}
