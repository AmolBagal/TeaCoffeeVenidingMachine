package com.yash.teacoffee.vendingmachine.utility;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.yash.teacoffee.vendingmachine.Model.CupCost;
import com.yash.teacoffee.vendingmachine.Model.TotalCost;
import com.yash.teacoffee.vendingmachine.iutility.iUtility;

public class CheckTotalSale implements iUtility {

	public void addTotalSale(String name, CupCost cupCost) {
//		if (new File(totalCostFilepath).exists()) {

			TotalCost totalCost = null;

			ObjectMapper objectMapper = new ObjectMapper();

			try {

				totalCost = objectMapper.readValue(new File(totalCostFilepath), TotalCost.class);

				updateTotalCost(name, cupCost, totalCost);

			} catch (Exception e) {
				e.printStackTrace(); 
			}

		// } else {
		// createTotalCost();
		// }
	}

	public void updateTotalCost(String name, CupCost cupCost, TotalCost totalCost) {

		TotalCost totalCost1 = new TotalCost();

		for (Map.Entry<String, CupCost> entry : totalCost.getMap().entrySet()) {

			CupCost cupCost1 = new CupCost();

			if (name.equals(entry.getKey())) {
				cupCost1.setCup(totalCost.getMap().get(name).getCup() + cupCost.getCup());
				cupCost1.setCost(totalCost.getMap().get(name).getCost() + cupCost.getCost());
			} else {
				cupCost1.setCup(totalCost.getMap().get(entry.getKey()).getCup());
				cupCost1.setCost(totalCost.getMap().get(entry.getKey()).getCost());
			}

			totalCost1.addcostMap(entry.getKey(), cupCost1);
		}

		writeTotalCost(totalCost1);

	}

	public void writeTotalCost(TotalCost totalCost) {
		ObjectMapper objectMapper = new ObjectMapper();

		try {

			objectMapper.writeValue(new File(totalCostFilepath), totalCost);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// public void createTotalCost() {
	// CupCost cupCost = new CupCost();
	// cupCost.setCost(0);
	// cupCost.setCup(0);
	//
	// TotalCost totalCost = new TotalCost();
	// totalCost.addcostMap(TEA, cupCost);
	// totalCost.addcostMap(COFFEE, cupCost);
	// totalCost.addcostMap(BLACKCOFFEE, cupCost);
	// totalCost.addcostMap(BLACKTEA, cupCost); 
	//
	// ObjectMapper objectMapper = new ObjectMapper();
	// try {
	// objectMapper.writeValue(new File(totalCostFilepath), totalCost);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	public TotalCost readTotalSale() {

		// if (new File(totalCostFilepath).exists()) {

		TotalCost totalCost = null;

		ObjectMapper objectMapper = new ObjectMapper();

		try {

			totalCost = objectMapper.readValue(new File(totalCostFilepath), TotalCost.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalCost;

		// } else {
		// createTotalCost();
		// }
		//
		// return null;
	}

}
