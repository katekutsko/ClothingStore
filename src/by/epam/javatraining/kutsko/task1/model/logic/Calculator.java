package by.epam.javatraining.kutsko.task1.model.logic;

import by.epam.javatraining.kutsko.task1.model.container.ClothingStore;
import by.epam.javatraining.kutsko.task1.model.entity.Item;
import by.epam.javatraining.kutsko.task1.model.exception.CorruptContainerReferenceException;

public class Calculator {
	
	public static double calculatePriceOfItems(ClothingStore container) throws CorruptContainerReferenceException {
		if (container != null) {
			double totalCosts = 0;
			Item[] itemSet = container.getItemSet();
			int length = container.getCurrentAmountOfProducts();
			for (int i = 0; i < length; i++) {
				totalCosts += itemSet[i].getPrice();
			}
			return totalCosts;
		} else {
			throw new CorruptContainerReferenceException("Broken reference to storage");
		}
	}
	
	public static double calculatePriceOfSelectedItems(ClothingStore container) throws CorruptContainerReferenceException {
		if (container != null) {
			double totalCosts = 0;
			Item[] itemSet = container.getItemSet();
			int length = container.getCurrentAmountOfProducts();
			for (int i = 0; i < length; i++) {
				if (itemSet[i].isSelected()) {
					totalCosts += itemSet[i].getPrice();
				}
			}
			return totalCosts;
		} else {
			throw new CorruptContainerReferenceException("Broken reference to storage");
		}
	}
}
