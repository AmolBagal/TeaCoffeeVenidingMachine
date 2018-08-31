package com.yash.teacoffee.vendingmachine.maintenance.helper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.yash.teacoffee.vendingmachine.Model.Container;
import com.yash.teacoffee.vendingmachine.utility.ResetContainer;

import junit.framework.Assert;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ResetContainerHelperTest {

	@InjectMocks
	private ResetContainerHelper resetContainerHelper;

	@Mock
	private ResetContainer resetContainer;

	@Test
	public void shouldReturnContainerObject() {

		Container container = new Container();

		when(resetContainer.resetContainer()).thenReturn(container);

		org.junit.Assert.assertThat(container, instanceOf(resetContainerHelper.resetContainer().getClass()));
	}

	@Test
	public void shouldReturnTrueIfResetContainer() {

		Container container = new Container();
		container.setCoffee(11000);
		container.setMilk(11000);
		container.setSugar(11000);
		container.setTea(11000);
		container.setWater(11000);

		when(resetContainer.resetContainer()).thenReturn(container);

		Assert.assertEquals(true, resetContainerHelper.checkContainerStatus());

	}
}
