package by.epam.javatraining.kutsko.task1.model.container;

import by.epam.javatraining.kutsko.task1.model.entity.*;
import by.epam.javatraining.kutsko.task1.model.entity.type.*;
import by.epam.javatraining.kutsko.task1.model.exception.*;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;

public class ClothingStoreTest {

	private ClothingStore store;

	@BeforeClass
	public void beforeClass() throws WarehouseFullException {
		store = new ClothingStore();
	}

	@AfterMethod
	public void clearContainer() {
		store.removeAll();
	}

	@Test
	public void testAddingItemsWithinDefaultCapacity() throws WarehouseFullException, CorruptItemReferenceException {
		store.addProduct(new Scarf(24.19, Material.COTTON, false, Color.PINK, Accessory.Season.ANY, Scarf.Type.CHUNKY));
		Item[] expecteds = new Item[store.getItemSet().length];
		expecteds[0] = new Scarf(24.19, Material.COTTON, false, Color.PINK, Accessory.Season.ANY, Scarf.Type.CHUNKY);
		Item[] actuals = store.getItemSet();
		assertEquals(expecteds, actuals, "Item sets weren't equal");
	}

	@Test
	public void testAddingItemsWithinMaximumCapacity() throws WarehouseFullException, CorruptItemReferenceException {
		for (int i = 0; i < 20; i++) {
			store.addProduct(new Jumper(20., Material.WOOL, false, Color.RED, Clothing.Size.XS, Jumper.Type.SWEATER));
		}
		Item[] actuals = store.getItemSet();
		Item[] expecteds = new Item[20];
		for (int i = 0; i < 20; i++) {
			expecteds[i] = new Jumper(20., Material.WOOL, false, Color.RED, Clothing.Size.XS, Jumper.Type.SWEATER);
		}
		assertEquals(expecteds, actuals);
	}

	@Test(expectedExceptions = WarehouseFullException.class)
	public void testAddingItemsBeyondMaximumCapacity() throws WarehouseFullException, CorruptItemReferenceException {
		for (int i = 0; i < 200; i++) {
			store.addProduct(new Jumper(20., Material.WOOL, false, Color.RED, Clothing.Size.XS, Jumper.Type.SWEATER));
		}
	}

	@Test(expectedExceptions = CorruptItemReferenceException.class)
	public void testAddingNull() throws WarehouseFullException, CorruptItemReferenceException {
		store.addProduct(new Scarf(24.19, Material.COTTON, false, Color.PINK, Accessory.Season.ANY, Scarf.Type.CHUNKY));
		Item[] actuals = store.getItemSet();
		store.addProduct(null);
		Item[] expecteds = store.getItemSet();
		assertEquals(expecteds, actuals);
	}

	@Test
	public void testGettingItemWithValidIndex()
			throws NoSuchItemException, WarehouseFullException, CorruptItemReferenceException {
		store.addProduct(new Scarf(24.19, Material.COTTON, false, Color.PINK, Accessory.Season.ANY, Scarf.Type.CHUNKY));
		store.addProduct(new HighHeels(19.99, Material.POLIESTER, false, Color.BLACK, 39, 9));
		store.addProduct(new HighHeels(15.99, Material.LEATHER, false, Color.MULTI, 36, 15));
		Item expected = new HighHeels(19.99, Material.POLIESTER, false, Color.BLACK, 39, 9);
		Item actual = store.getItem(1);
		assertEquals(actual, expected);
	}

	@Test(expectedExceptions = NoSuchItemException.class)
	public void testGettingItemWithInvalidIndex() throws NoSuchItemException {
		store.getItem(100);
	}

	@Test
	public void testGettingNonexistentItemWithValidIndex() throws NoSuchItemException {
		Item actual = store.getItem(50);
		assertNull(actual);
	}

	@Test
	public void testRemovingOneItem() throws WarehouseFullException, CorruptItemReferenceException {
		store.addProduct(new Scarf(24.19, Material.COTTON, false, Color.PINK, Accessory.Season.ANY, Scarf.Type.CHUNKY));
		store.addProduct(new HighHeels(19.99, Material.POLIESTER, false, Color.BLACK, 39, 9));
		store.addProduct(new HighHeels(15.99, Material.LEATHER, false, Color.MULTI, 36, 15));
		store.removeProduct(2);
		Item[] actuals = store.getItemSet();
		Item[] expecteds = {
				new Scarf(24.19, Material.COTTON, false, Color.PINK, Accessory.Season.ANY, Scarf.Type.CHUNKY),
				new HighHeels(19.99, Material.POLIESTER, false, Color.BLACK, 39, 9) };
		assertEquals(actuals, expecteds);
	}

	@Test
	public void testRemovingAllItems() throws WarehouseFullException, CorruptItemReferenceException {
		store.addProduct(new Scarf(24.19, Material.COTTON, false, Color.PINK, Accessory.Season.ANY, Scarf.Type.CHUNKY));
		store.addProduct(new HighHeels(19.99, Material.POLIESTER, false, Color.BLACK, 39, 9));
		store.addProduct(new HighHeels(15.99, Material.LEATHER, false, Color.MULTI, 36, 15));
		store.removeAll();
		Item[] actuals = store.getItemSet();
		Item[] expecteds = {};
		assertEquals(actuals, expecteds);
	}
}
