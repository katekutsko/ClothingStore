package by.epam.javatraining.kutsko.task1.model.entity;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import by.epam.javatraining.kutsko.task1.model.entity.Shoes;
import by.epam.javatraining.kutsko.task1.model.exception.ClothingStoreLogicalException;
import by.epam.javatraining.kutsko.task1.model.exception.InvalidShoeSizeException;

public class ShoesTest {
	
	private static Shoes item;

	@BeforeClass
	public static void initItem() {
		item = new Shoes();
	}
	
	@Test 
	public void setProperSizeTest() throws InvalidShoeSizeException {
		item.setSize(36);
		int expected = 36;
		int actual = item.getSize();
		double delta = 0.01;
		Assert.assertEquals("No exception was thrown", expected, actual, delta);
	}
	
	@Test (expected = InvalidShoeSizeException.class)
	public void setInvalidSizeTest() throws InvalidShoeSizeException {
		item.setSize(5);
		int expected = 5;
		int actual = item.getSize();
		double delta = 0.01;
		Assert.assertEquals("No exception was thrown", expected, actual, delta);
	}
}
