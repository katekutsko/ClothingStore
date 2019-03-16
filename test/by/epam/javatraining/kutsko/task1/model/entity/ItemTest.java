package by.epam.javatraining.kutsko.task1.model.entity;

import java.util.Objects;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.BeforeClass;
import org.junit.Test;

import by.epam.javatraining.kutsko.task1.model.entity.Item;
import by.epam.javatraining.kutsko.task1.model.entity.type.*;
import by.epam.javatraining.kutsko.task1.model.exception.ClothingStoreLogicalException;

public class ItemTest {

	private static Item item;

	@BeforeClass
	public static void initItem() {
		item = new Scarf();
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
	public void setColorNullified() {
		Color expected = item.getColor();
		item.setColor(null);
		Color actual = item.getColor();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void setColorTest() {
		Color expected = Color.BLACK;
		item.setColor(Color.BLACK);
		Color actual = item.getColor();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void setMaterialNullified() {
		Material expected = item.getMaterial();
		item.setMaterial(null);
		Material actual = item.getMaterial();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void setMaterialTest() {
		Material expected = Material.LEATHER;
		item.setMaterial(Material.LEATHER);
		Material actual = item.getMaterial();
		Assert.assertEquals(expected, actual);
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
		Item item = new Item(49.99, Material.COTTON, false, Color.RED);
		Item anotherItem = new Item(48.99, Material.COTTON, false, Color.RED);
		boolean result = item.equals(anotherItem);
		Assert.assertFalse(result);
	}
	
	@Test
	public void equalsForEqualItemsTest() {
		Item item = new Item(49.99, Material.COTTON, false, Color.RED);
		Item anotherItem = new Item(49.99, Material.COTTON, false, Color.RED);
		boolean result = item.equals(anotherItem);
		Assert.assertTrue(result);
	}
	
	@Test
	public void equalsForNullifiedItemTest() {
		Item item = new Item(49.99, Material.COTTON, false, Color.RED);
		Item anotherItem = null;
		boolean result = item.equals(anotherItem);
		Assert.assertFalse(result);
		Assume.assumeNoException(new NullPointerException());
	}
}
