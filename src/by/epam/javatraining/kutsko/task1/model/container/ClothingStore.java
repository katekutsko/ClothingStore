package by.epam.javatraining.kutsko.task1.model.container;

import by.epam.javatraining.kutsko.task1.exception.*;
import by.epam.javatraining.kutsko.task1.model.entity.Item;

public class ClothingStore {
	
	public final int MAX_CAPACITY = 1000;
	
	private Item[] productsInStock = new Item[MAX_CAPACITY];
	
	private int currentAmountOfProducts = 0;
	
	public void addProduct(Item item) throws WarehouseFullException, NonexistentArgumentException {
		if (currentAmountOfProducts < (MAX_CAPACITY - 1)) {
			if (item != null) {
			productsInStock[currentAmountOfProducts] = item;
			currentAmountOfProducts++;
			} else {
				throw new NonexistentArgumentException("Item is unidentified");
			}
		} else {
			throw new WarehouseFullException("Maximum capacity reached");
		}
	}
	
	public void removeProduct(Item item) throws NoSuchItemException {
		int counter = 0;
		for (Item i : productsInStock) {
			if (i == item) {
				break;
			} else {
				counter++;
			}
		}
		if (counter == currentAmountOfProducts) {
			throw new NoSuchItemException("There is no such item in the warehouse");
		} else {
			for (int i = counter; i < currentAmountOfProducts - 2; i++)
			productsInStock[i] = productsInStock[i + 1];
		}
		currentAmountOfProducts--;
	}
	
	public int getCurrentAmountOfProducts() {
		return currentAmountOfProducts;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("Contents of warehouse:\n");
		for (int i = 0; i < currentAmountOfProducts; i++) {
			builder.append(productsInStock[i].toString());
			builder.append("\n");			
		}
		return builder.toString();
	}
}
