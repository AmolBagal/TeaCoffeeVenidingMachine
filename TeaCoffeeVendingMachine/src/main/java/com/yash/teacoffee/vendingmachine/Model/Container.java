package com.yash.teacoffee.vendingmachine.Model;

public class Container {
	private int tea;
	private int coffee;
	private int sugar;
	private int water;
	private int milk;

	public int getTea() {
		return tea;
	}

	public void setTea(int tea) {
		this.tea = tea;
	}

	public int getCoffee() {
		return coffee;
	}

	public void setCoffee(int coffee) {
		this.coffee = coffee;
	}

	public int getSugar() {
		return sugar;
	}

	public void setSugar(int sugar) {
		this.sugar = sugar;
	}

	public int getWater() {
		return water;
	}

	public void setWater(int water) {
		this.water = water;
	}

	public int getMilk() {
		return milk;
	}

	public void setMilk(int milk) {
		this.milk = milk;
	}

	// @Override
	// public boolean equals(Object obj) {
	//
	// if (obj == this)
	// return true;
	// if (!(obj instanceof Container)) {
	// return false;
	// }
	//
	// Container container = (Container) obj;
	//
	// return (container.tea == tea && container.milk == milk &&
	// container.coffee == coffee && container.sugar == sugar
	// && container.water == water);
	// }
	//
	// @Override
	// public int hashCode() {
	//
	// int result = 17;
	// result = 31 * result + tea;
	// result = 31 * result + milk;
	// result = 31 * result + coffee;
	// result = 31 * result + sugar;
	// result = 31 * result + water;
	//
	// return result;
	// }
}
