package com.yash.teacoffee.vendingmachine.Model;

import java.util.Scanner;

public class InputScanner {
	private final Scanner scanner;

	public InputScanner() {
		this.scanner = new Scanner(System.in);
	}

	// public InputScanner(Scanner scanner) {
	// super();
	// this.scanner = scanner;
	// }

	public String getString() {
		return scanner.nextLine();
	}

	// public String nextLine() {
	// return scanner.nextLine();
	// }

	// public double nextDouble() {
	// // TODO Auto-generated method stub
	// return scanner.nextDouble();
	// }

	public int nextInt() {
		// TODO Auto-generated method stub
		return scanner.nextInt();

	}

}
