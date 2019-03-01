package by.epam.javatraining.kutsko.task1.model.entity;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.BeforeClass;
import org.junit.Test;

import by.epam.javatraining.kutsko.task1.model.entity.Item;
import by.epam.javatraining.kutsko.task1.model.exception.ClothingStoreLogicalException;

public class ItemTest {

	private static Item item;

	@BeforeClass
	public static void initItem() {
		item = new Item();
	}
	
	@Test (expected = ClothingStoreLogicalException.class)
	public void setNegativePriceTest() throws ClothingStoreLogicalException {
		double expected = -3.0;
		item.setPrice(-3.0);
		double actual = item.getPrice();
		double delta = 0.01;
		Assert.assertEquals("No exception was thrown", expected, actual, delta);
	}

	@Test
	public void setProperPriceTest() throws ClothingStoreLogicalException {
		double expected = 23.0;
		item.setPrice(23.0);
		double actual = item.getPrice();
		double delta = 0.01;
		Assert.assertEquals("Price was not set properly", expected, actual, delta);
	}
	
	@Test
	public void equalsForDifferentItemsTest() {
		Item item = new Item(49.99, Item.Material.COTTON, false, Item.Color.RED);
		Item anotherItem = new Item(48.99, Item.Material.COTTON, false, Item.Color.RED);
		boolean result = item.equals(anotherItem);
		Assert.assertFalse(result);
	}
	
	@Test
	public void equalsForEqualItemsTest() {
		Item item = new Item(49.99, Item.Material.COTTON, false, Item.Color.RED);
		Item anotherItem = new Item(49.99, Item.Material.COTTON, false, Item.Color.RED);
		boolean result = item.equals(anotherItem);
		Assert.assertTrue(result);
	}
	
	@Test
	public void equalsForNullifiedItemTest() {
		Item item = new Item(49.99, Item.Material.COTTON, false, Item.Color.RED);
		Item anotherItem = null;
		boolean result = item.equals(anotherItem);
		Assert.assertFalse(result);
		Assume.assumeNoException(new NullPointerException());
	}
}
