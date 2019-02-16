package by.epam.javatraining.kutsko.task1.model.container;

import by.epam.javatraining.kutsko.task1.exception.InvalidArgumentException;
import by.epam.javatraining.kutsko.task1.exception.NoSuchItemException;
import by.epam.javatraining.kutsko.task1.exception.NonexistentArgumentException;
import by.epam.javatraining.kutsko.task1.exception.ContainerEmptyException;
import by.epam.javatraining.kutsko.task1.exception.WarehouseFullException;
import by.epam.javatraining.kutsko.task1.model.entity.Item;

public class Container {
	
	private int currentAmountOfProducts = 0;
	
	private Item[] itemSet;
	
	private int capacity;
	
	private boolean sorted = false;
	
	public Container() {
		capacity = 10;
		itemSet = new Item[capacity];
	}
	
	public Container(int capacity) {
		this.capacity = capacity;
		itemSet = new Item[capacity];
	}
	
	public void setCapacity(int capacity) {
		if (capacity > 0) {
			this.capacity = capacity;
		} else {
			this.capacity = 10;
		}
	}
	
	public boolean isSorted() {
		return sorted;
	}

	public void setSorted(boolean sorted) {
		this.sorted = sorted;
	}

	public int getCapacity() {
		return capacity;
	}
	
	public Item[] getItemSet() {
		if (itemSet == null) {
			itemSet = new Item[10];
		}
		return itemSet;
	}
	
	/* Без исключений непонятно, почему элемент не добавился */
	public boolean addProduct(Item item) /* throws WarehouseFullException */ {
		if (currentAmountOfProducts < (capacity - 1)) {
			if (item != null) {
				itemSet[currentAmountOfProducts] = item;
			currentAmountOfProducts++;
			return true;
			} else {
				/* throw new NonexistentArgumentException("Item is unidentified"); */
				return false;
			}
		} else {
			return false;
		}
	}
	
	/* То же, что и в предыдущем */
	public boolean removeProduct(Item item) /* throws NoSuchItemException, NonexistentArgumentException */ {
		int counter = 0;
		if (item != null) {
			/* throw new NonexistentArgumentException("Item is unidentified"); */
			for (Item i : itemSet) {
			if (i == item) {
				break;
			} else {
				counter++;
			}
		}
		if (counter == currentAmountOfProducts) {
			/* throw new NoSuchItemException("There is no such item in the warehouse"); */
			return false;
		} else {
			for (int i = counter; i < currentAmountOfProducts - 1; i++)
				itemSet[i] = itemSet[i + 1];
		}
		currentAmountOfProducts--;
		return true;
		}
		return false;
	}
	
	public int getCurrentAmountOfProducts() {
		return currentAmountOfProducts;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("Contents of warehouse:\n");
		for (int i = 0; i < currentAmountOfProducts; i++) {
			builder.append(itemSet[i].toString());
			builder.append("\n");
		}
		return builder.toString();
	}
}
