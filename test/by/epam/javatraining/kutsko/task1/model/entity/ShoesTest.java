package by.epam.javatraining.kutsko.task1.model.entity;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import by.epam.javatraining.kutsko.task1.model.entity.Shoes;
import by.epam.javatraining.kutsko.task1.model.exception.ClothingStoreLogicalException;

public class ShoesTest {
	
	private static Shoes item;

	@BeforeClass
	public static void initItem() {
		item = new Shoes();
	}
	
	@Test 
	public void setProperSizeTest() throws ClothingStoreLogicalException {
		item.setSize(36);
		int expected = 36;
		int actual = item.getSize();
		double delta = 0.01;
		Assert.assertEquals("No exception was thrown", expected, actual, delta);
	}
	
	@Test (expected = ClothingStoreLogicalException.class)
	public void setInvalidSizeTest() throws ClothingStoreLogicalException {
		item.setSize(5);
		int expected = 5;
		int actual = item.getSize();
		double delta = 0.01;
		Assert.assertEquals("No exception was thrown", expected, actual, delta);
	}

	@Test (expected = ClothingStoreLogicalException.class)
	public void setInvalidPriceTest() throws ClothingStoreLogicalException {
		item.setPrice(-39.);
		double expected = -39.;
		double actual = item.getPrice();
		double delta = 0.01;
		Assert.assertEquals("No exception was thrown", expected, actual, delta);
	}
	
	@Test 
	public void setProperPriceTest() throws ClothingStoreLogicalException {
		item.setPrice(39.);
		double expected = 39.;
		double actual = item.getPrice();
		double delta = 0.01;
		Assert.assertEquals("Price was not set properly", expected, actual, delta);
	}
}
