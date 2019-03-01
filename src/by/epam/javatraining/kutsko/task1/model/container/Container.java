package by.epam.javatraining.kutsko.task1.model.container;

import java.util.Arrays;

import by.epam.javatraining.kutsko.task1.model.entity.Item;
import by.epam.javatraining.kutsko.task1.model.exception.ContainerFullException;
import by.epam.javatraining.kutsko.task1.model.exception.NoSuchItemException;

public abstract class Container {

	public static final int DEFAULT_CAPACITY = 1;
	public final static String ERROR_MESSAGE = "A problem occured: no data is available";

	private int currentAmountOfProducts = 0;
	private Item[] itemSet;
	private boolean sorted;

	protected Container() {
		itemSet = new Item[DEFAULT_CAPACITY];
	}

	protected Container(int capacity) {
		itemSet = new Item[capacity];
	}

	public boolean isSorted() {
		return sorted;
	}

	public void setSorted(boolean sorted) {
		this.sorted = sorted;
	}

	public int getCurrentAmountOfProducts() {
		return currentAmountOfProducts;
	}

	protected void setCurrentAmountOfProducts(int newValue) {
		currentAmountOfProducts = newValue;
	}

	abstract public Item getItem(int index) throws NoSuchItemException;

	public Item[] getItemSet() {
		return itemSet;
	}

	abstract public void addProduct(Item item) throws ContainerFullException;

	public boolean removeProduct(int index) {
		if (index >= 0 && index < currentAmountOfProducts) {
			if (index != currentAmountOfProducts - 1) {
				for (int i = index; i < currentAmountOfProducts - 1; i++) {
					itemSet[i] = itemSet[i + 1];
				}
				itemSet[currentAmountOfProducts - 1] = null;
				currentAmountOfProducts--;
				return true;
			} else {
				itemSet[index] = null;
				currentAmountOfProducts--;
				return true;
			}
		} else {
			return false;
		}
	}

	protected void enlargeCapacity() {
		itemSet = Arrays.copyOf(itemSet, ++currentAmountOfProducts);
	}

	public void removeAll() {
		int limit = getCurrentAmountOfProducts();
		for (int i = limit - 1; i >= 0; i--) {
			itemSet[i] = null;
		}
		currentAmountOfProducts = 0;
		sorted = false;
	}

	@Override
	public String toString() {
		Item[] thisItemSet = getItemSet();
		if (thisItemSet != null) {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < getCurrentAmountOfProducts(); i++) {
				builder.append(thisItemSet[i].toString());
				builder.append("\n");
			}
			return builder.toString();
		} else {
			return ERROR_MESSAGE;
		}
	}
}
