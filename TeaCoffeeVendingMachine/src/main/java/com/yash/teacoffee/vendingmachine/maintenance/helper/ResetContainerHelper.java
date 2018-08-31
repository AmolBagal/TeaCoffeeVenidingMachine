package com.yash.teacoffee.vendingmachine.maintenance.helper;

import com.yash.teacoffee.vendingmachine.Model.Container;
import com.yash.teacoffee.vendingmachine.imaintenance.iContainerStatus;
import com.yash.teacoffee.vendingmachine.utility.ResetContainer;

public class ResetContainerHelper implements iContainerStatus {

	@Override
	public boolean checkContainerStatus() {

		ResetContainerHelper resetContainerHelper = new ResetContainerHelper();

		// if (resetContainerHelper.resetContainer() != null) {
		System.out.println("Container Reset To IT'S  Defuult Value!");
		return true;
		// } else {
		// return false;
		// }
	}

	public Container resetContainer() {

		ResetContainer resetContainer = new ResetContainer();
		return resetContainer.resetContainer();
	}

}
