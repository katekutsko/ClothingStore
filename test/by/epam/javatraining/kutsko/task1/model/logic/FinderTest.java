package by.epam.javatraining.kutsko.task1.model.logic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import by.epam.javatraining.kutsko.task1.model.container.ClothingStore;
import by.epam.javatraining.kutsko.task1.model.entity.*;
import by.epam.javatraining.kutsko.task1.model.entity.type.*;
import by.epam.javatraining.kutsko.task1.model.exception.*;
import by.epam.javatraining.kutsko.task1.model.logic.Finder;

public class FinderTest {

	private static ClothingStore store;

	@Before
	public void fillStore() throws WarehouseFullException, CorruptItemReferenceException {
		if (store == null) {
			store = new ClothingStore();
			store.addProduct(
					new Jumper(23., Material.POLIESTER, false, Color.GREEN, Clothing.Size.XXL, Jumper.Type.TUNIC));
			store.addProduct(
					new Scarf(10.19, Material.COTTON, false, Color.PINK, Accessory.Season.WINTER, Scarf.Type.CHUNKY));
			store.addProduct(new HighHeels(19.99, Material.LEATHER, false, Color.MULTI, 39, 9));
			store.addProduct(new Scarf(9.19, Material.SILK, false, Color.GREEN, Accessory.Season.ANY, Scarf.Type.LOOP));
			store.addProduct(
					new Scarf(7.19, Material.WOOL, false, Color.RED, Accessory.Season.WINTER, Scarf.Type.CHUNKY));
		}
	}

	@Test
	public void colorFinderTest() throws CorruptContainerReferenceException {
		Item[] expected = {
				new Jumper(23., Material.POLIESTER, false, Color.GREEN, Clothing.Size.XXL, Jumper.Type.TUNIC),
				new Scarf(9.19, Material.SILK, false, Color.GREEN, Accessory.Season.ANY, Scarf.Type.LOOP) };
		Item[] actual = Finder.findAllOfColor(store, Color.GREEN);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void priceFinderTest() throws CorruptContainerReferenceException {
		Item[] expected = {
				new Scarf(10.19, Material.COTTON, false, Color.PINK, Accessory.Season.WINTER, Scarf.Type.CHUNKY),
				new HighHeels(19.99, Material.LEATHER, false, Color.MULTI, 39, 9) };
		Item[] actual = Finder.findAllInPriceRange(store, 10., 20.);
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void typeFinderTest() throws CorruptContainerReferenceException {
		Item[] expected = {
				new Scarf(10.19, Material.COTTON, false, Color.PINK, Accessory.Season.WINTER, Scarf.Type.CHUNKY),
				new Scarf(9.19, Material.SILK, false, Color.GREEN, Accessory.Season.ANY, Scarf.Type.LOOP),
				new Scarf(7.19, Material.WOOL, false, Color.RED, Accessory.Season.WINTER, Scarf.Type.CHUNKY) };
		Item[] actual = Finder.findAllOfType(store, "Scarf");
		Assert.assertArrayEquals(expected, actual);
	}

	@Test(expected = CorruptContainerReferenceException.class)
	public void typeFinderNullifiedContainerTest() throws CorruptContainerReferenceException {
		store.removeAll();
		store = null;
		Item[] expected = new Item[0];
		Item[] actual = Finder.findAllOfType(store, "Scarf");
		Assert.assertArrayEquals("CorruptContainerReferenceException wasn't thrown", expected, actual);
	}

	@Test(expected = CorruptContainerReferenceException.class)
	public void colorFinderNullifiedContainerTest() throws CorruptContainerReferenceException {
		store.removeAll();
		store = null;
		Item[] expected = new Item[0];
		Item[] actual = Finder.findAllOfColor(store, Color.GREEN);
		Assert.assertArrayEquals("CorruptContainerReferenceException wasn't thrown", expected, actual);
	}

	@Test(expected = CorruptContainerReferenceException.class)
	public void priceFinderNullifiedContainerTest() throws CorruptContainerReferenceException {
		store.removeAll();
		store = null;
		Item[] expected = new Item[0];
		Item[] actual = Finder.findAllInPriceRange(store, 10., 20.);
		Assert.assertArrayEquals("CorruptContainerReferenceException wasn't thrown", expected, actual);
	}

	@Test
	public void binaryPriceFinderTest() throws UnsortedItemSetException, CorruptContainerReferenceException {
		Item expected = new Scarf(10.19, Material.COTTON, false, Color.PINK, Accessory.Season.WINTER,
				Scarf.Type.CHUNKY);
		Sorter.fastPriceSort(store);
		Item actual = Finder.binarySearchByPrice(store, 10.19);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void binaryPriceFinderWithInvalidPriceTest()
			throws UnsortedItemSetException, CorruptContainerReferenceException {
		Sorter.fastPriceSort(store);
		Assert.assertNull(Finder.binarySearchByPrice(store, 0.19));
	}

	@Test(expected = UnsortedItemSetException.class)
	public void binaryPriceFinderUnsortedItemSetTest()
			throws UnsortedItemSetException, CorruptContainerReferenceException {
		Finder.binarySearchByPrice(store, 10.19);
		Assert.fail();
	}
}
