package com.yash.teacoffee.vendingmachine.MainClass;

import java.util.Scanner;

import com.yash.teacoffee.vendingmachine.Model.InputScanner;
import com.yash.teacoffee.vendingmachine.delegate.Delegate;
import com.yash.teacoffee.vendingmachine.iItems.iTeaCoffeeItemsNames;
import com.yash.teacoffee.vendingmachine.imaintenance.iMaintenanceName;

public class SelectItem implements iTeaCoffeeItemsNames, iMaintenanceName {
	Delegate delegate;
	InputScanner scanner;

	// public SelectItem() {
	// // TODO Auto-generated constructor stub
	// }

	public SelectItem() {
		this.delegate = new Delegate();
		this.scanner = new InputScanner();
	}

	public SelectItem(Delegate delegate, InputScanner scanner) {
		super();
		this.delegate = delegate;
		this.scanner = scanner;
	}

	public void showMenu() {

		System.out.println(
				"1.TEA\n2.COFFEE\n3.BLACK COFFEE\n4.BLACK TEA\n5.REFILL CONTAINER\n6.CHECK TOTAL SALE\n7.CONTAINER STATUS\n8.RESET CONTAINER\n9.Exit");

		// Scanner scanner = new Scanner(System.in);

		System.out.println("Enter Item: ");

		String item = scanner.getString();
		String key = item.toUpperCase();

		if (key.equals(TEA) || key.equals(COFFEE) || key.equals(BLACKTEA) || key.equals(BLACKCOFFEE)) {
			System.out.println("Enter No of Element: ");

			int count = scanner.nextInt();
			selectItem(key, count);
		}

		System.out.println("Do you want to Proceed(y/n) ?");
		String res = scanner.getString();
		if (res.equals("y")) {
			selectItem(key, 0);

		}

	}

	public void selectItem(String key, int count) {

		switch (key) {

		case TEA:
			delegate.makeItem(TEA, count);
			showMenu();
			break;
		case COFFEE:
			delegate.makeItem(COFFEE, count);
			showMenu();
			break;
		case BLACKTEA:
			delegate.makeItem(BLACKTEA, count);
			showMenu();
			break;
		case BLACKCOFFEE:
			delegate.makeItem(BLACKCOFFEE, count);
			showMenu();
			break;
		case REFILLCONTAINER:
			delegate.ContainerAction(REFILLCONTAINER);
			showMenu();
			break;
		case CHECKTOTALSALE:
			delegate.ContainerAction(CHECKTOTALSALE);
			showMenu();
		case CONTAINERSTATUS:
			delegate.ContainerAction(CONTAINERSTATUS);
			showMenu();
			break;
		case RESETCONTAINER:
			delegate.ContainerAction(RESETCONTAINER);
			showMenu();
			break;
		default:
			System.exit(0);

		}

	}

}
