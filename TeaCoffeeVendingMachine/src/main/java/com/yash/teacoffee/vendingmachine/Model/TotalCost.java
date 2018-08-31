package com.yash.teacoffee.vendingmachine.Model;

import java.util.LinkedHashMap;

public class TotalCost {
	LinkedHashMap<String, CupCost> costMap;

	public TotalCost() {
		costMap = new LinkedHashMap<String, CupCost>();
	}

	public LinkedHashMap<String, CupCost> getMap() { 
		return costMap;
	}

	public void setMap(LinkedHashMap<String, CupCost> costMap) {
		this.costMap = costMap;
	}

	public void addcostMap(String key, CupCost cupCost) {
		costMap.put(key, cupCost);
	}
	
	// @Override
	// public boolean equals(Object obj) {
	// // TODO Auto-generated method stub
	// return super.equals(obj);
	// }
}
