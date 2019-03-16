package by.epam.javatraining.kutsko.task1.model.logic.comparator;

import java.util.Comparator;
import by.epam.javatraining.kutsko.task1.model.entity.Item;

public class CategoryComparator implements Comparator<Item> {

	@Override
	public int compare(Item firstItem, Item secondItem) {
		
		String first = firstItem.getClass().getSimpleName();
		String second = secondItem.getClass().getSimpleName();
		
		int comparisonResult = first.compareTo(second);
		
		if (comparisonResult == 0) {
			comparisonResult = firstItem.compareTo(secondItem);
		}
		
		return comparisonResult;
	}

}
