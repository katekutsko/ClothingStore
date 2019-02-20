package by.epam.javatraining.kutsko.task1.model.container;

import by.epam.javatraining.kutsko.task1.exception.InvalidArgumentException;
import by.epam.javatraining.kutsko.task1.exception.NoSuchItemException;
import by.epam.javatraining.kutsko.task1.exception.NonexistentArgumentException;

import java.util.Arrays;
import by.epam.javatraining.kutsko.task1.exception.WarehouseFullException;
import by.epam.javatraining.kutsko.task1.model.entity.Item;

public class Container {

	public static final int DEFAULT_CAPACITY = 0;

	private int currentAmountOfProducts;

	private Item[] itemSet;

	private int capacity;

	private boolean sorted;

	public Container() {
		itemSet = new Item[DEFAULT_CAPACITY];
	}

	public Container(int capacity) {
		this.capacity = capacity;
		itemSet = new Item[capacity];
	}

	public void setCapacity(int capacity) {
		if (capacity > this.capacity) {
			this.capacity = capacity;
			itemSet = Arrays.copyOf(itemSet, capacity);
		} else if (capacity >= currentAmountOfProducts) {
			this.capacity = capacity;
			itemSet = Arrays.copyOf(itemSet, capacity);
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

	public Item getItem(int index) throws NoSuchItemException {
		if (index >= 0 && index < capacity) {
			return itemSet[index];
		} else {
			throw new NoSuchItemException("There is no item with such index");
		}
	}
	
	public Item[] getItemSet() {
		if (itemSet == null) {
			itemSet = new Item[DEFAULT_CAPACITY];
		}
		return itemSet;
	}

	protected void addProduct(Item item) {
		if (currentAmountOfProducts < capacity) {
			if (item != null) {
				itemSet[currentAmountOfProducts] = item;
				currentAmountOfProducts++;
			} else {
				throw new NullPointerException("Item is unidentified");
			}
		} else {
			setCapacity(capacity+1);
			itemSet[currentAmountOfProducts] = item;
		}
	}

	public boolean removeProduct(int index) throws NoSuchItemException {
		if (index >= 0 && index < capacity) {
			if (index >= 0 && index < currentAmountOfProducts) {
				if (index != currentAmountOfProducts - 1) {
					for (int i = index; i < currentAmountOfProducts - 1; i++) {
						itemSet[i] = itemSet[i + 1];
					}
					return true;
				} else {
					itemSet[index] = null;
					return true;
				}
			} else {
				return false;
			}
		} else {
			throw new NoSuchItemException("There is no item with such index");
		}
	}

	public int getCurrentAmountOfProducts() {
		return currentAmountOfProducts;
	}
}
