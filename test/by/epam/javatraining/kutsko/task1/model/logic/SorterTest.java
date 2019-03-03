package by.epam.javatraining.kutsko.task1.model.logic;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import by.epam.javatraining.kutsko.task1.model.comparator.*;
import by.epam.javatraining.kutsko.task1.model.container.ClothingStore;
import by.epam.javatraining.kutsko.task1.model.entity.*;
import by.epam.javatraining.kutsko.task1.model.exception.ContainerFullException;
import by.epam.javatraining.kutsko.task1.model.exception.CorruptContainerReferenceException;
import by.epam.javatraining.kutsko.task1.model.exception.NoSuchItemException;
import by.epam.javatraining.kutsko.task1.model.logic.Sorter;
import by.epam.javatraining.kutsko.task1.util.creator.StoreCreator;
import by.epam.javatraining.kutsko.task1.util.initializer.Initializer;

public class SorterTest {

	private static ClothingStore store;

	@BeforeClass
	public static void initContainer() {
		store = StoreCreator.getStore();
		List<String> rawData = new ArrayList<String>();
		rawData.add("2 10.19 COTTON false PINK ANY CHUNKY");
		rawData.add("1 19.99 LEATHER false MULTI 39 9");
		rawData.add("3 23.00 POLIESTER false GREEN XXL TUNIC");
		try {
			store = Initializer.fillWarehouse(store, rawData);
		} catch (ContainerFullException | CorruptContainerReferenceException e) {
		}
	}

	@Test
	public void colorSortTest() throws CorruptContainerReferenceException {
		Item[] expected = new Item[10];
		expected[0] = new Jumper(23., Item.Material.POLIESTER, false, Item.Color.GREEN, Clothing.Size.XXL,
				Jumper.Type.TUNIC);
		expected[1] = new Scarf(10.19, Item.Material.COTTON, false, Item.Color.PINK, Accessory.Season.ANY,
				Scarf.Type.CHUNKY);
		expected[2] = new HighHeels(19.99, Item.Material.LEATHER, false, Item.Color.MULTI, 39, 9);
		Sorter.colorSort(store);
		Item[] actual = store.getItemSet();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void insertionPriceSortTest() throws CorruptContainerReferenceException {
		Item[] expected = new Item[10];
		expected[0] = new Scarf(10.19, Item.Material.COTTON, false, Item.Color.PINK, Accessory.Season.ANY,
				Scarf.Type.CHUNKY);
		expected[1] = new HighHeels(19.99, Item.Material.LEATHER, false, Item.Color.MULTI, 39, 9);
		expected[2] = new Jumper(23., Item.Material.POLIESTER, false, Item.Color.GREEN, Clothing.Size.XXL,
				Jumper.Type.TUNIC);
		Sorter.insertionPriceSort(store);
		Item[] actual = store.getItemSet();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void typeSortTest() throws CorruptContainerReferenceException {
		Item[] expected = new Item[10];
		expected[2] = new Scarf(10.19, Item.Material.COTTON, false, Item.Color.PINK, Accessory.Season.ANY,
				Scarf.Type.CHUNKY);
		expected[0] = new HighHeels(19.99, Item.Material.LEATHER, false, Item.Color.MULTI, 39, 9);
		expected[1] = new Jumper(23., Item.Material.POLIESTER, false, Item.Color.GREEN, Clothing.Size.XXL,
				Jumper.Type.TUNIC);
		Sorter.categorySort(store);
		Item[] actual = store.getItemSet();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void fastPriceSortTest() throws CorruptContainerReferenceException {
		Item[] expected = new Item[10];
		expected[0] = new Scarf(10.19, Item.Material.COTTON, false, Item.Color.PINK, Accessory.Season.ANY,
				Scarf.Type.CHUNKY);
		expected[1] = new HighHeels(19.99, Item.Material.LEATHER, false, Item.Color.MULTI, 39, 9);
		expected[2] = new Jumper(23., Item.Material.POLIESTER, false, Item.Color.GREEN, Clothing.Size.XXL,
				Jumper.Type.TUNIC);
		Sorter.fastPriceSort(store);
		Item[] actual = store.getItemSet();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test(expected = CorruptContainerReferenceException.class)
	public void fastPriceSortWithNullifiedContainer() throws CorruptContainerReferenceException {
		store = null;
		Sorter.fastPriceSort(store);
		Assert.fail();
	}
}
