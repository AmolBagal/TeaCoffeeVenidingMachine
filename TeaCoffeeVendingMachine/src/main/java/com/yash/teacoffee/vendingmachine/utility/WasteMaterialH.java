package com.yash.teacoffee.vendingmachine.utility;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.yash.teacoffee.vendingmachine.Model.Container;
import com.yash.teacoffee.vendingmachine.Model.WasteMaterial;
import com.yash.teacoffee.vendingmachine.iutility.iUtility;

public class WasteMaterialH implements iUtility {

	ObjectMapper objectMapper;

	public WasteMaterialH() {
		objectMapper = new ObjectMapper();
	}

	// public WasteMaterial getWasteMaterial() {
	//
	// WasteMaterial wasteMaterial = null;
	//
	// ObjectMapper objectMapper = new ObjectMapper();
	//
	// try {
	//
	// wasteMaterial = objectMapper.readValue(new File(wasteFilePath),
	// WasteMaterial.class);
	//
	// return wasteMaterial;
	// } catch (JsonGenerationException e) {
	// e.printStackTrace();
	// } catch (JsonMappingException e) {
	// e.printStackTrace();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	//
	// return null;
	//
	// }

	public WasteMaterialH(ObjectMapper objectMapper) {
		super();
		this.objectMapper = objectMapper;
	}

	public void addWasteMaterial(WasteMaterial wasteMaterial) {
		WasteMaterial wasteMaterial1 = null;

		try {
			wasteMaterial1 = objectMapper.readValue(new File(wasteFilePath), WasteMaterial.class);
			updateWasteMaterial(wasteMaterial1, wasteMaterial);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateWasteMaterial(WasteMaterial previousValue, WasteMaterial wasteMaterial) {

		WasteMaterial wasteMaterial1 = new WasteMaterial();

		wasteMaterial1.setTea(previousValue.getTea() + wasteMaterial.getTea());
		wasteMaterial1.setCoffee(previousValue.getCoffee() + wasteMaterial.getCoffee());
		wasteMaterial1.setMilk(previousValue.getMilk() + wasteMaterial.getMilk());
		wasteMaterial1.setSugar(previousValue.getSugar() + wasteMaterial.getSugar());
		wasteMaterial1.setWater(previousValue.getWater() + wasteMaterial.getWater());

		writeContainer(wasteMaterial1);
	}

	public void writeContainer(WasteMaterial wasteMaterial) {
		ObjectMapper objectMapper = new ObjectMapper();

		try {

			objectMapper.writeValue(new File(wasteFilePath), wasteMaterial);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void resetContainer() {
		WasteMaterial wasteMaterial = new WasteMaterial();
		wasteMaterial.setCoffee(0);
		wasteMaterial.setTea(0);
		wasteMaterial.setMilk(0);
		wasteMaterial.setSugar(0);
		wasteMaterial.setWater(0);

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			objectMapper.writeValue(new File(wasteFilePath), wasteMaterial);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
