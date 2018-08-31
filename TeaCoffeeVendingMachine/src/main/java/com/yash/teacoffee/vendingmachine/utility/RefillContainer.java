package com.yash.teacoffee.vendingmachine.utility;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.yash.teacoffee.vendingmachine.Model.Container;
import com.yash.teacoffee.vendingmachine.iutility.iUtility;

public class RefillContainer implements iUtility {

	public Container refillConatiner() {
		Container container = new Container();
		container.setCoffee(2000);
		container.setTea(2000);
		container.setMilk(10000);
		container.setSugar(8000);
		container.setWater(15000);

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			objectMapper.writeValue(new File(containerFilePath), container);
			return container;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return container;
	}

}
