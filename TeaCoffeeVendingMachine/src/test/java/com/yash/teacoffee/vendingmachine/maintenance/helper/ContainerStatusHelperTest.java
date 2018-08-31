package com.yash.teacoffee.vendingmachine.maintenance.helper;

import static org.hamcrest.CoreMatchers.instanceOf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.yash.teacoffee.vendingmachine.Model.Container;
import com.yash.teacoffee.vendingmachine.utility.ContainerStatus;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class ContainerStatusHelperTest {

	@InjectMocks
	ContainerStatusHelper containerStatusHelper;
	@Mock
	ContainerStatus containerStatus;

	@Test
	public void shouldReturnContainerObject() { 

		Container container = new Container();

		Mockito.when(containerStatus.containerStatus()).thenReturn(container);

		org.junit.Assert.assertThat(container, instanceOf(containerStatusHelper.getContainerStatus().getClass()));

	}

	@Test
	public void shouldReturnTrueWhenContainerStatusReturn() {
		Container container = new Container();
		container.setCoffee(11000);
		container.setMilk(11000);
		container.setSugar(11000); 
		container.setTea(11000);
		container.setWater(11000);

		Mockito.when(containerStatus.containerStatus()).thenReturn(container);

		Assert.assertEquals(true, containerStatusHelper.checkContainerStatus());

	}
}
