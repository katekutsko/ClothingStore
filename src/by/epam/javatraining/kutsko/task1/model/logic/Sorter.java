package by.epam.javatraining.kutsko.task1.model.logic;

import java.util.Comparator;

import by.epam.javatraining.kutsko.task1.model.container.Container;
import by.epam.javatraining.kutsko.task1.model.entity.Item;
import by.epam.javatraining.kutsko.task1.model.exception.CorruptContainerReferenceException;
import by.epam.javatraining.kutsko.task1.model.exception.ClothingStoreLogicalException;

public class Sorter {

	private static Comparator<Item> colorComparator = (firstItem, secondItem) -> {
		int comparisonResult = firstItem.getColor().compareTo(secondItem.getColor());
		if (comparisonResult == 0) {
			comparisonResult = firstItem.compareTo(secondItem);
		}
		return comparisonResult;
	};

	private static Comparator<Item> categoryComparator = (firstItem, secondItem) -> {
		int comparisonResult = firstItem.getClass().getSimpleName().compareTo(secondItem.getClass().getSimpleName());
		if (comparisonResult == 0) {
			comparisonResult = firstItem.compareTo(secondItem);
		}
		return comparisonResult;
	};

	public static void insertionPriceSort(Container container) throws CorruptContainerReferenceException {
		if (container == null) {
			throw new CorruptContainerReferenceException("Item set is unidentified");
		}
		Item[] itemSet = container.getItemSet();
		if (itemSet != null) {
			int length = container.getCurrentAmountOfProducts();
			int j = 0;
			Item temp = null;
			for (int i = 0; i < length - 1; i++) {
				if (itemSet[i].compareTo(itemSet[i + 1]) > 0) {
					temp = itemSet[i + 1];
					itemSet[i + 1] = itemSet[i];
					j = i;
				}
				while ((j > 0) && (itemSet[j - 1].compareTo(temp) > 0)) {
					itemSet[j] = itemSet[j - 1];
					j--;
				}
				itemSet[j] = temp;
			}
			container.setSorted(true);
		} else {
			throw new CorruptContainerReferenceException("Item set is unidentified");
		}
	}

	private static void swap(Item[] itemSet, int i, int j) {
		Item temp = itemSet[i];
		itemSet[i] = itemSet[j];
		itemSet[j] = temp;
	}

	public static void fastPriceSort(Container container) throws CorruptContainerReferenceException {
		Item[] itemSet;
		int length;
		try {
			itemSet = container.getItemSet();
			length = container.getCurrentAmountOfProducts();
		} catch (NullPointerException e) {
			throw new CorruptContainerReferenceException("Item set is unidentified", e);
		}
		doFastSort(itemSet, 0, length - 1);
		container.setSorted(true);
	}

	private static void doFastSort(Item[] itemSet, int start, int end) {
		if (start >= end) {
			return;
		}
		int i = start;
		int j = end;
		int mid = i - (i - j) / 2;
		while (i < j) {
			while ((i < mid) && (itemSet[i].compareTo(itemSet[mid]) <= 0)) {
				i++;
			}
			while ((j > mid) && (itemSet[j].compareTo(itemSet[mid]) >= 0)) {
				j--;
			}
			if (i < j) {
				swap(itemSet, i, j);
				if (i == mid) {
					mid = j;
				} else if (j == mid) {
					mid = i;
				}
			}
		}
		doFastSort(itemSet, start, mid);
		doFastSort(itemSet, mid + 1, end);
	}

	public static void colorSort(Container container) {
		sort(container, colorComparator);
	}

	public static void categorySort(Container container) {
		sort(container, categoryComparator);
	}

	private static void sort(Container container, Comparator<Item> comparator) {
		Item[] itemSet = container.getItemSet();
		int length = container.getCurrentAmountOfProducts();
		for (int i = 0; i < length - 1; i++) {
			for (int j = i + 1; j < length; j++) {
				if (comparator.compare(itemSet[i], itemSet[j]) > 0) {
					swap(itemSet, i, j);
				}
			}
		}
		container.setSorted(false);
	}
}
