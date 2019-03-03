package by.epam.javatraining.kutsko.task1.model.container;

import org.testng.annotations.Test;

import by.epam.javatraining.kutsko.task1.model.entity.*;
import by.epam.javatraining.kutsko.task1.model.exception.NoSuchItemException;
import by.epam.javatraining.kutsko.task1.model.exception.WarehouseFullException;

import org.testng.annotations.BeforeClass;
import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;

public class ClothingStoreTest {
	
	private ClothingStore store;

	@BeforeClass
	public void beforeClass() throws WarehouseFullException {
		store = ClothingStore.getInstance();
	}
	
	@AfterMethod
	public void clearContainer() {
		store.removeAll();
	}
	
	@Test
	public void testAddingItemsWithinDefaultCapacity() throws WarehouseFullException {
		store.addProduct(new Scarf(24.19, Item.Material.COTTON, false, Item.Color.PINK, Accessory.Season.ANY,
				Scarf.Type.CHUNKY));
		Item[] expecteds = new Item[store.getItemSet().length];
		expecteds[0] = new Scarf(24.19, Item.Material.COTTON, false, Item.Color.PINK, Accessory.Season.ANY, Scarf.Type.CHUNKY);
		Item[] actuals = store.getItemSet();
		assertEquals(expecteds, actuals, "Item sets weren't equal");
	}
	
	@Test
	public void testAddingItemsWithinMaximumCapacity() throws WarehouseFullException {
		for (int i = 0; i < 20; i++) {
			store.addProduct(new Jumper(20., Item.Material.WOOL, false, Item.Color.RED, Clothing.Size.XS, Jumper.Type.SWEATER));
		}
		Item[] actuals = store.getItemSet();
		Item[] expecteds = new Item[20];
		for (int i = 0; i < 20; i++) {
			expecteds[i] = new Jumper(20., Item.Material.WOOL, false, Item.Color.RED, Clothing.Size.XS, Jumper.Type.SWEATER);
		}
		assertEquals(expecteds, actuals);
	}
	
	@Test ( expectedExceptions = WarehouseFullException.class)
	public void testAddingItemsBeyondMaximumCapacity() throws WarehouseFullException {
		for (int i = 0; i < 200; i++) {
			store.addProduct(new Jumper(20., Item.Material.WOOL, false, Item.Color.RED, Clothing.Size.XS, Jumper.Type.SWEATER));
		}
	}
	
	@Test 
	public void testAddingNull() throws WarehouseFullException {
		store.addProduct(new Scarf(24.19, Item.Material.COTTON, false, Item.Color.PINK, Accessory.Season.ANY,
				Scarf.Type.CHUNKY));
		Item[] actuals = store.getItemSet();
		store.addProduct(null);
		Item[] expecteds = store.getItemSet();
		assertEquals(expecteds, actuals);
	}
	
	@Test 
	public void testGettingItemWithValidIndex() throws NoSuchItemException, WarehouseFullException {
		store.addProduct(new Scarf(24.19, Item.Material.COTTON, false, Item.Color.PINK, Accessory.Season.ANY,
				Scarf.Type.CHUNKY));
		store.addProduct(new HighHeels(19.99, Item.Material.POLIESTER, false, Item.Color.BLACK, 39, 9));
		store.addProduct(new HighHeels(15.99, Item.Material.LEATHER, false, Item.Color.MULTI, 36, 15));
		Item expected = new HighHeels(19.99, Item.Material.POLIESTER, false, Item.Color.BLACK, 39, 9);
		Item actual = store.getItem(1);
		assertEquals(actual,expected);
	}
	
	@Test (expectedExceptions = NoSuchItemException.class)
	public void testGettingItemWithInvalidIndex() throws NoSuchItemException {
		store.getItem(100);
	}
	
	@Test
	public void testGettingNonexistentItemWithValidIndex() throws NoSuchItemException {
		Item actual = store.getItem(50);
		assertNull(actual);
	}
	
	@Test 
	public void testRemovingOneItem() throws WarehouseFullException {
		store.addProduct(new Scarf(24.19, Item.Material.COTTON, false, Item.Color.PINK, Accessory.Season.ANY,
				Scarf.Type.CHUNKY));
		store.addProduct(new HighHeels(19.99, Item.Material.POLIESTER, false, Item.Color.BLACK, 39, 9));
		store.addProduct(new HighHeels(15.99, Item.Material.LEATHER, false, Item.Color.MULTI, 36, 15));
		store.removeProduct(2);
		Item[] actuals = store.getItemSet();
		Item[] expecteds = {new Scarf(24.19, Item.Material.COTTON, false, Item.Color.PINK, Accessory.Season.ANY,
				Scarf.Type.CHUNKY),
				new HighHeels(19.99, Item.Material.POLIESTER, false, Item.Color.BLACK, 39, 9)
		};
		assertEquals(actuals,expecteds);
	}
	
	@Test 
	public void testRemovingAllItems() throws WarehouseFullException {
		store.addProduct(new Scarf(24.19, Item.Material.COTTON, false, Item.Color.PINK, Accessory.Season.ANY,
				Scarf.Type.CHUNKY));
		store.addProduct(new HighHeels(19.99, Item.Material.POLIESTER, false, Item.Color.BLACK, 39, 9));
		store.addProduct(new HighHeels(15.99, Item.Material.LEATHER, false, Item.Color.MULTI, 36, 15));
		store.removeAll();
		Item[] actuals = store.getItemSet();
		Item[] expecteds = {};
		assertEquals(actuals, expecteds);
	}
}
