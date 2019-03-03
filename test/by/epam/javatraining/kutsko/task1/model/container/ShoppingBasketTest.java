package by.epam.javatraining.kutsko.task1.model.container;

import org.testng.annotations.Test;

import by.epam.javatraining.kutsko.task1.model.entity.*;
import by.epam.javatraining.kutsko.task1.model.exception.NoSuchItemException;
import by.epam.javatraining.kutsko.task1.model.exception.ShoppingBasketFullException;

import static org.testng.Assert.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class ShoppingBasketTest {
	
	private ShoppingBasket basket;
	
	@Test
	public void testGettingItemWithValidIndex() throws NoSuchItemException, ShoppingBasketFullException {
		basket.addProduct(new Jumper(20., Item.Material.WOOL, false, Item.Color.RED, Clothing.Size.XS, Jumper.Type.SWEATER));
		Item expected = new Jumper(20., Item.Material.WOOL, true, Item.Color.RED, Clothing.Size.XS, Jumper.Type.SWEATER);
		Item actual = basket.getItem(0);
		assertEquals(actual, expected);
	}
	
	@Test (expectedExceptions = NoSuchItemException.class)
	public void testGettingItemWithInvalidIndex() throws NoSuchItemException {
		basket.getItem(41);
	}
	
	@Test
	public void testAddingItemWithinCapacity() throws ShoppingBasketFullException {
		basket.addProduct(new Jumper(20., Item.Material.WOOL, false, Item.Color.RED, Clothing.Size.XS, Jumper.Type.SWEATER));
		Item[] actuals = basket.getItemSet();
		Item[] expecteds = new Item[4];
		expecteds[0] = new Jumper(20., Item.Material.WOOL, true, Item.Color.RED, Clothing.Size.XS, Jumper.Type.SWEATER);
		assertEquals(actuals, expecteds);
	}
	
	@Test (expectedExceptions = ShoppingBasketFullException.class)
	public void testAddingItemBeyondCapacity() throws ShoppingBasketFullException {
		for (int i = 0; i < 10; i++) {
			basket.addProduct(new Jumper(20., Item.Material.WOOL, false, Item.Color.RED, Clothing.Size.XS, Jumper.Type.SWEATER));
		}
	}
	
	@AfterMethod
	public void clear() {
		basket.removeAll();
	}


	@BeforeClass
	public void beforeClass() throws ShoppingBasketFullException {
		basket = new ShoppingBasket();
		basket.addProduct(new Scarf(24.19, Item.Material.COTTON, false, Item.Color.PINK, Accessory.Season.ANY,
				Scarf.Type.CHUNKY));
		basket.addProduct(new Jumper(20., Item.Material.WOOL, false, Item.Color.RED, Clothing.Size.XS, Jumper.Type.SWEATER));
	}

}
