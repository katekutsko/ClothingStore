package by.epam.javatraining.kutsko.task1.model.logic;

import java.util.ArrayList;

import by.epam.javatraining.kutsko.task1.model.container.ClothingStore;
import by.epam.javatraining.kutsko.task1.model.entity.Item;
import by.epam.javatraining.kutsko.task1.model.entity.type.Color;
import by.epam.javatraining.kutsko.task1.model.exception.CorruptContainerReferenceException;
import by.epam.javatraining.kutsko.task1.model.exception.UnsortedItemSetException;

public class Finder {

	public static Item[] findAllOfColor(ClothingStore container, Color color)
			throws CorruptContainerReferenceException {
		if (container != null) {
			Item[] itemSet = container.getItemSet();
			if (itemSet != null) {
				ArrayList<Item> discoveredMatches = new ArrayList<Item>();
				for (int i = 0; i < container.getCurrentAmountOfProducts(); i++) {
					if (itemSet[i].getColor() == color) {
						discoveredMatches.add(itemSet[i]);
					}
				}
				int newLength = discoveredMatches.size();
				return discoveredMatches.toArray(new Item[newLength]);
			} else {
				throw new CorruptContainerReferenceException();
			}
		} else {
			throw new CorruptContainerReferenceException();
		}
	}

	public static Item[] findAllOfType(ClothingStore container, String type) throws CorruptContainerReferenceException {
		if (container != null) {
			Item[] itemSet = container.getItemSet();
			if (itemSet != null) {
				ArrayList<Item> discoveredMatches = new ArrayList<Item>();
				for (int i = 0; i < container.getCurrentAmountOfProducts(); i++) {
					if (itemSet[i].getClass().getSimpleName().equalsIgnoreCase(type)) {
						discoveredMatches.add(itemSet[i]);
					}
				}
				int newLength = discoveredMatches.size();
				return discoveredMatches.toArray(new Item[newLength]);
			} else {
				throw new CorruptContainerReferenceException();
			}
		} else {
			throw new CorruptContainerReferenceException();
		}
	}

	public static Item[] findAllInPriceRange(ClothingStore container, double minPrice, double maxPrice)
			throws CorruptContainerReferenceException {
		if (container != null) {
			Item[] itemSet = container.getItemSet();
			if (itemSet != null) {
				ArrayList<Item> discoveredMatches = new ArrayList<Item>();
				for (int i = 0; i < container.getCurrentAmountOfProducts(); i++) {
					if (itemSet[i].getPrice() < maxPrice && itemSet[i].getPrice() > minPrice) {
						discoveredMatches.add(itemSet[i]);
					}
				}
				int newLength = discoveredMatches.size();
				return discoveredMatches.toArray(new Item[newLength]);
			} else {
				throw new CorruptContainerReferenceException();
			}
		} else {
			throw new CorruptContainerReferenceException();
		}
	}

	public static Item binarySearchByPrice(ClothingStore container, double price)
			throws UnsortedItemSetException, CorruptContainerReferenceException {
		if (container != null) {
			if (container.isSorted()) {
				int index = binary(container, 0, container.getCurrentAmountOfProducts() - 1, price);
				if (index != -1) {
					return container.getItemSet()[index];
				} else {
					return null;
				}
			} else {
				throw new UnsortedItemSetException("Item set in the container wasn't sorted by price");
			}
		} 
		throw new CorruptContainerReferenceException("Reference to the store was null");

	}

	private static int binary(ClothingStore container, int start, int end, double price)
			throws CorruptContainerReferenceException {
		if (container != null) {
			if (start == end) {
				if (price != container.getItemSet()[end].getPrice()) {
					return -1;
				} else {
					return end;
				}
			}
			int mid = start + (end - start) / 2;
			Item midItem = container.getItemSet()[mid];
			if (midItem != null) {
				if (price > midItem.getPrice()) {
					return binary(container, mid + 1, end, price);
				} else if (price < container.getItemSet()[mid].getPrice()) {
					return binary(container, start, mid, price);
				} else {
					return mid;
				}
			} else {
				return -1;
			}
		} else {
			throw new CorruptContainerReferenceException();
		}
	}
}
