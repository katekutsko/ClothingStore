package by.epam.javatraining.kutsko.task1.model.entity;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import by.epam.javatraining.kutsko.task1.model.entity.HighHeels;
import by.epam.javatraining.kutsko.task1.model.exception.ClothingStoreLogicalException;

public class HighHeelsTest {
	
	private static HighHeels item;

	@BeforeClass
	public static void initItem() {
		item = new HighHeels();
	}

	@Test (expected = ClothingStoreLogicalException.class)
	public void setInvalidHeelHeightTest() throws ClothingStoreLogicalException {
		item.setHeelHeight(-3f);
		float expected = -3f;
		float actual = item.getHeelHeight();
		double delta = 0.01;
		Assert.assertEquals("No exception was thrown", expected, actual, delta);
	}

	@Test
	public void setProperHeelHeightTest() throws ClothingStoreLogicalException {
		item.setHeelHeight(13f);
		float expected = 13f;
		float actual = item.getHeelHeight();
		double delta = 0.01;
		Assert.assertEquals("Price was not set properly", expected, actual, delta);
	}
}
