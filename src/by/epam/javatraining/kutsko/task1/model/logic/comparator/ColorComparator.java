package by.epam.javatraining.kutsko.task1.model.logic.comparator;

import java.util.Comparator;
import by.epam.javatraining.kutsko.task1.model.entity.Item;

public class ColorComparator implements Comparator<Item> {

	@Override
	public int compare(Item firstItem, Item secondItem) {
		int comparisonResult = firstItem.getColor().compareTo(secondItem.getColor());
		if (comparisonResult == 0) {
			comparisonResult = firstItem.compareTo(secondItem);
		}
		return comparisonResult;
	}

}
