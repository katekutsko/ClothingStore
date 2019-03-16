package by.epam.javatraining.kutsko.task1.model.logic;

import by.epam.javatraining.kutsko.task1.model.container.*;
import by.epam.javatraining.kutsko.task1.model.entity.*;
import by.epam.javatraining.kutsko.task1.model.entity.type.*;
import by.epam.javatraining.kutsko.task1.model.exception.*;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

	private static ClothingStore store;
	
	@Test
	public void calculateTotalOfContainerTest() throws CorruptContainerReferenceException, WarehouseFullException, CorruptItemReferenceException {
		
		store = new ClothingStore();
		
		store.addProduct(new Scarf(24.19, Material.COTTON, false, Color.PINK, Accessory.Season.ANY,
				Scarf.Type.CHUNKY));
		store.addProduct(new HighHeels(19.99, Material.POLIESTER, false, Color.BLACK, 39, 9));
		store.addProduct(new HighHeels(15.99, Material.LEATHER, false, Color.MULTI, 36, 15));
		store.addProduct(
				new Jumper(20., Material.WOOL, false, Color.RED, Clothing.Size.XS, Jumper.Type.SWEATER));
		
		double expected = 80.17;
		double delta = 0.1;
		double actual = Calculator.calculatePriceOfItems(store);
		
		Assert.assertEquals("Calculations were incorrect", expected, actual, delta);
	}

	@Test(expected = CorruptContainerReferenceException.class)
	public void calculateTotalOfNonexistentContainerTest() throws CorruptContainerReferenceException {
		store = null;
		Calculator.calculatePriceOfItems(store);
	}

	@Test
	public void calculateTotalOfEmptyContainerTest() throws CorruptContainerReferenceException {
		
		store = new ClothingStore();
		
		double expected = 0;
		double delta = 0.1;
		double actual = Calculator.calculatePriceOfItems(store);
		
		Assert.assertEquals(expected, actual, delta);
	}

}
