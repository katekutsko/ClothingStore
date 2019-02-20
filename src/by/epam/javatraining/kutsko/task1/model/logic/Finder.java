package by.epam.javatraining.kutsko.task1.model.logic;


import java.util.ArrayList;
import java.util.Comparator;

import by.epam.javatraining.kutsko.task1.model.container.Container;
import by.epam.javatraining.kutsko.task1.model.entity.Item;

public class Finder {
	
	public static Item[] findColor(Container container, Item.Color color) {
		Item[] itemSet = container.getItemSet();
		ArrayList<Item> discoveredMatches = new ArrayList<Item>();
		for (int i = 0; i < container.getCurrentAmountOfProducts(); i++) {
			if (itemSet[i].getColor() == color) {
				discoveredMatches.add(itemSet[i]);
			}
		}
		int newLength = discoveredMatches.size();
		return discoveredMatches.toArray(new Item[newLength]);
	}
	
	public static Item[] findAllOfType(Container container, String type) {
		Item[] itemSet = container.getItemSet();
		ArrayList<Item> discoveredMatches = new ArrayList<Item>();
		for (int i = 0; i < container.getCurrentAmountOfProducts(); i++) {
			if (itemSet[i].getClass().getSimpleName().equalsIgnoreCase(type)) {
				discoveredMatches.add(itemSet[i]);
			}
		}
		int newLength = discoveredMatches.size();
		return discoveredMatches.toArray(new Item[newLength]);
	}
	
	public static Item[] findAllInPriceRange(Container container, double minPrice, double maxPrice) {
		Item[] itemSet = container.getItemSet();
		ArrayList<Item> discoveredMatches = new ArrayList<Item>();
		for (int i = 0; i < container.getCurrentAmountOfProducts(); i++) {
			if (itemSet[i].getPrice() < maxPrice && itemSet[i].getPrice() > minPrice ) { 
				discoveredMatches.add(itemSet[i]);
			}
		}
		int newLength = discoveredMatches.size();
		return discoveredMatches.toArray(new Item[newLength]);
	}
	
}
