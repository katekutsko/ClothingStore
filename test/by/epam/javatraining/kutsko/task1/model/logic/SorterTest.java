package by.epam.javatraining.kutsko.task1.model.logic;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import by.epam.javatraining.kutsko.task1.model.container.ClothingStore;
import by.epam.javatraining.kutsko.task1.model.entity.*;
import by.epam.javatraining.kutsko.task1.model.entity.type.*;
import by.epam.javatraining.kutsko.task1.model.exception.CorruptContainerReferenceException;
import by.epam.javatraining.kutsko.task1.model.exception.CorruptItemReferenceException;
import by.epam.javatraining.kutsko.task1.model.exception.WarehouseFullException;
import by.epam.javatraining.kutsko.task1.model.logic.Sorter;
import by.epam.javatraining.kutsko.task1.model.logic.comparator.CategoryComparator;
import by.epam.javatraining.kutsko.task1.model.logic.comparator.ColorComparator;

public class SorterTest {

	private static ClothingStore store;

	@BeforeClass
	public static void initContainer() throws WarehouseFullException, CorruptItemReferenceException {
		store = new ClothingStore();
		
		store.addProduct(new Jumper(23., Material.POLIESTER, false, Color.GREEN, Clothing.Size.XXL, Jumper.Type.TUNIC));
		store.addProduct(new Scarf(10.19, Material.COTTON, false, Color.PINK, Accessory.Season.ANY, Scarf.Type.CHUNKY));
		store.addProduct(new HighHeels(19.99, Material.LEATHER, false, Color.MULTI, 37, 9));
		store.addProduct(new Jumper(20., Material.WOOL, false, Color.GREY, Clothing.Size.XXL, Jumper.Type.TUNIC));
		store.addProduct(new Scarf(17.19, Material.SILK, false, Color.BLUE, Accessory.Season.ANY, Scarf.Type.CHUNKY));
		store.addProduct(new HighHeels(28.99, Material.POLIESTER, false, Color.BROWN, 38, 13));
	}

	@Test
	public void colorSortTest() throws CorruptContainerReferenceException {
		ColorComparator comparator = new ColorComparator();
		Item[] expected = new Item[6];

		expected[0] = new Scarf(17.19, Material.SILK, false, Color.BLUE, Accessory.Season.ANY, Scarf.Type.CHUNKY);
		expected[1] = new Jumper(23., Material.POLIESTER, false, Color.GREEN, Clothing.Size.XXL, Jumper.Type.TUNIC);
		expected[2] = new HighHeels(28.99, Material.POLIESTER, false, Color.BROWN, 38, 13);
		expected[3] = new Scarf(10.19, Material.COTTON, false, Color.PINK, Accessory.Season.ANY, Scarf.Type.CHUNKY);
		expected[4] = new Jumper(20., Material.WOOL, false, Color.GREY, Clothing.Size.XXL, Jumper.Type.TUNIC);
		expected[5] = new HighHeels(19.99, Material.LEATHER, false, Color.MULTI, 37, 9);

		Sorter.sort(store, comparator);
		Item[] actual = store.getItemSet();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void insertionPriceSortTest() throws CorruptContainerReferenceException {
		Item[] expected = new Item[6];

		expected[0] = new Scarf(10.19, Material.COTTON, false, Color.PINK, Accessory.Season.ANY, Scarf.Type.CHUNKY);
		expected[2] = new HighHeels(19.99, Material.LEATHER, false, Color.MULTI, 37, 9);
		expected[4] = new Jumper(23., Material.POLIESTER, false, Color.GREEN, Clothing.Size.XXL, Jumper.Type.TUNIC);
		expected[1] = new Scarf(17.19, Material.SILK, false, Color.BLUE, Accessory.Season.ANY, Scarf.Type.CHUNKY);
		expected[5] = new HighHeels(28.99, Material.POLIESTER, false, Color.BROWN, 38, 13);
		expected[3] = new Jumper(20., Material.WOOL, false, Color.GREY, Clothing.Size.XXL, Jumper.Type.TUNIC);

		Sorter.insertionPriceSort(store);
		Item[] actual = store.getItemSet();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void typeSortTest() throws CorruptContainerReferenceException {
		CategoryComparator comparator = new CategoryComparator();
		Item[] expected = new Item[6];

		expected[4] = new Scarf(10.19, Material.COTTON, false, Color.PINK, Accessory.Season.ANY, Scarf.Type.CHUNKY);
		expected[0] = new HighHeels(19.99, Material.LEATHER, false, Color.MULTI, 37, 9);
		expected[3] = new Jumper(23., Material.POLIESTER, false, Color.GREEN, Clothing.Size.XXL, Jumper.Type.TUNIC);
		expected[5] = new Scarf(17.19, Material.SILK, false, Color.BLUE, Accessory.Season.ANY, Scarf.Type.CHUNKY);
		expected[1] = new HighHeels(28.99, Material.POLIESTER, false, Color.BROWN, 38, 13);
		expected[2] = new Jumper(20., Material.WOOL, false, Color.GREY, Clothing.Size.XXL, Jumper.Type.TUNIC);

		Sorter.sort(store, comparator);
		Item[] actual = store.getItemSet();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void fastPriceSortTest() throws CorruptContainerReferenceException {
		Item[] expected = new Item[6];

		expected[0] = new Scarf(10.19, Material.COTTON, false, Color.PINK, Accessory.Season.ANY, Scarf.Type.CHUNKY);
		expected[2] = new HighHeels(19.99, Material.LEATHER, false, Color.MULTI, 37, 9);
		expected[4] = new Jumper(23., Material.POLIESTER, false, Color.GREEN, Clothing.Size.XXL, Jumper.Type.TUNIC);
		expected[1] = new Scarf(17.19, Material.SILK, false, Color.BLUE, Accessory.Season.ANY, Scarf.Type.CHUNKY);
		expected[5] = new HighHeels(28.99, Material.POLIESTER, false, Color.BROWN, 38, 13);
		expected[3] = new Jumper(20., Material.WOOL, false, Color.GREY, Clothing.Size.XXL, Jumper.Type.TUNIC);

		Sorter.fastPriceSort(store);
		Item[] actual = store.getItemSet();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test(expected = CorruptContainerReferenceException.class)
	public void fastPriceSortWithNullifiedContainer() throws CorruptContainerReferenceException {
		ClothingStore store = null;
		Sorter.fastPriceSort(store);
		Assert.fail();
	}
}
