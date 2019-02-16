package by.epam.javatraining.kutsko.task1.model.logic;

import by.epam.javatraining.kutsko.task1.exception.ContainerEmptyException;
import by.epam.javatraining.kutsko.task1.exception.InvalidArgumentException;
import by.epam.javatraining.kutsko.task1.model.container.Container;
import by.epam.javatraining.kutsko.task1.model.entity.Item;

public class Sorter {
	
	public static void insertionSort(Container container) throws ContainerEmptyException{
		Item[] itemSet;
		try {
			itemSet = container.getItemSet();
		} catch (NullPointerException e) {
			throw new ContainerEmptyException("Item set is unidentified", e);
		}
		int length = container.getCurrentAmountOfProducts();
		int j = 0;
		Item temp = null;
		for (int i = 0; i < length-1; i++) {
			if (itemSet[i].compareTo(itemSet[i+1]) > 0) {
				temp = itemSet[i+1];
				itemSet[i+1] = itemSet[i];
				j = i;
			}
			while ((j > 0)  && (itemSet[j-1].compareTo(temp) > 0)) {
				itemSet[j] = itemSet[j-1];
				j--;
			}
			itemSet[j] = temp;
		}
	}
	
	private static void swap(Item[] itemSet, int i, int j) {
		Item temp = itemSet[i];
		itemSet[i] = itemSet[j];
		itemSet[j] = temp;
	}

	public static void 	fastSort(Container container) throws ContainerEmptyException {
		Item[] itemSet;
		int length;
		try {
			itemSet = container.getItemSet();
			length = container.getCurrentAmountOfProducts();
		} catch (NullPointerException e) {
			throw new ContainerEmptyException("Item set is unidentified", e);
		}
		doSort(itemSet, 0, length-1);
	}
	
	private static void doSort(Item[] itemSet, int start, int end) {
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
		doSort(itemSet, start, mid);
		doSort(itemSet, mid+1, end);
	}
}
