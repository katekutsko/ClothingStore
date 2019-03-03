package by.epam.javatraining.kutsko.task1.model.logic;

import by.epam.javatraining.kutsko.task1.model.container.*;
import by.epam.javatraining.kutsko.task1.model.entity.Accessory;
import by.epam.javatraining.kutsko.task1.model.entity.Clothing;
import by.epam.javatraining.kutsko.task1.model.entity.HighHeels;
import by.epam.javatraining.kutsko.task1.model.entity.Item;
import by.epam.javatraining.kutsko.task1.model.entity.Jumper;
import by.epam.javatraining.kutsko.task1.model.entity.Scarf;
import by.epam.javatraining.kutsko.task1.model.exception.ContainerFullException;
import by.epam.javatraining.kutsko.task1.model.exception.CorruptContainerReferenceException;
import by.epam.javatraining.kutsko.task1.model.logic.Calculator;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

	private static ClothingStore store;
	
	@Test
	public void calculateTotalOfContainerTest() throws CorruptContainerReferenceException, ContainerFullException {
		store = ClothingStore.getInstance();
		store.addProduct(new Scarf(24.19, Item.Material.COTTON, false, Item.Color.PINK, Accessory.Season.ANY,
				Scarf.Type.CHUNKY));
		store.addProduct(new HighHeels(19.99, Item.Material.POLIESTER, false, Item.Color.BLACK, 39, 9));
		store.addProduct(new HighHeels(15.99, Item.Material.LEATHER, false, Item.Color.MULTI, 36, 15));
		store.addProduct(
				new Jumper(20., Item.Material.WOOL, false, Item.Color.RED, Clothing.Size.XS, Jumper.Type.SWEATER));
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
		store = ClothingStore.getInstance();
		store.removeAll();
		double expected = 0;
		double delta = 0.1;
		double actual = Calculator.calculatePriceOfItems(store);
		Assert.assertEquals(expected, actual, delta);
	}

}
