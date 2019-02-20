package by.epam.javatraining.kutsko.task1.model.comparator;

import java.util.Comparator;

import by.epam.javatraining.kutsko.task1.model.entity.Item;

public class ColorComparator implements Comparator<Item> {
	public int compare(Item firstItem, Item secondItem) {
		Item.Color firstItemColor = firstItem.getColor();
		Item.Color secondItemColor = secondItem.getColor();
		return firstItemColor.compareTo(secondItemColor);
	}
}
