package com.yash.teacoffee.vendingmachine.utility;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.yash.teacoffee.vendingmachine.Model.Container;
import com.yash.teacoffee.vendingmachine.iutility.iUtility;

public class ContainerStatus implements iUtility {

	public Container containerStatus() {

		Container container = null;

		ObjectMapper objectMapper = new ObjectMapper();

		try {

			container = objectMapper.readValue(new File(containerFilePath), Container.class);

			return container;
		} catch (Exception e) { 
			e.printStackTrace();
		}

		return container;
	}

	public void consumeContainer(Container container) {

		Container container1 = null;

		ObjectMapper objectMapper = new ObjectMapper();

		try {

			container1 = objectMapper.readValue(new File(containerFilePath), Container.class);

			updateConatiner(container, container1);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateConatiner(Container updateValue, Container container) {

		Container container1 = new Container();

		container1.setTea(container.getTea() - updateValue.getTea());
		container1.setCoffee(container.getCoffee() - updateValue.getCoffee());
		container1.setMilk(container.getMilk() - updateValue.getMilk());
		container1.setSugar(container.getSugar() - updateValue.getSugar());
		container1.setWater(container.getWater() - updateValue.getWater());

		writeContainer(container1);
	}

	public void writeContainer(Container container) {
		ObjectMapper objectMapper = new ObjectMapper();

		try {

			objectMapper.writeValue(new File(containerFilePath), container);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
