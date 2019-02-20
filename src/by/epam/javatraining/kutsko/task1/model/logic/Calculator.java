package by.epam.javatraining.kutsko.task1.model.logic;

import by.epam.javatraining.kutsko.task1.exception.ContainerEmptyException;
import by.epam.javatraining.kutsko.task1.model.container.Container;
import by.epam.javatraining.kutsko.task1.model.entity.Item;

public class Calculator {
	
	public static double calculatePriceOfItems(Container container) throws ContainerEmptyException {
		if (container != null) {
			double totalCosts = 0;
			for (Item item : container.getItemSet()) {
				totalCosts += item.getPrice();
			}
			return totalCosts;
		} else {
			throw new ContainerEmptyException("Broken reference to storage");
		}
	}
}
