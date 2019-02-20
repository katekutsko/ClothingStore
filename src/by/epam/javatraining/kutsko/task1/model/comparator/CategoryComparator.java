package by.epam.javatraining.kutsko.task1.model.comparator;

import java.util.Comparator;

import by.epam.javatraining.kutsko.task1.model.entity.Item;

public class CategoryComparator implements Comparator<Item> {
	public int compare(Item firstItem, Item secondItem) {
		String firstItemCategory = firstItem.getClass().getSimpleName();
		String secondItemCategory = secondItem.getClass().getSimpleName();
		return firstItemCategory.compareTo(secondItemCategory);
	}
}
