package by.epam.javatraining.kutsko.task1.model.container;

import by.epam.javatraining.kutsko.task1.model.entity.Item;
import by.epam.javatraining.kutsko.task1.model.exception.NoSuchItemException;

public class ShoppingBasket extends Container {

	public final static int DEFAULT_CAPACITY = 4;
	public final static String HEADER = "Contents of shopping basket:\n";
	public final static String BASKET_TOTAL_HEADER = "Price of all selected items: ";

	private int capacity = DEFAULT_CAPACITY;

	public ShoppingBasket() {
		super(DEFAULT_CAPACITY);
	}

	public ShoppingBasket(int capacity) {
		super(capacity);
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}


	public Item[] getItemSet() {
		return super.getItemSet();
	}
	
	public void addProduct(Item item) throws ShoppingBasketFullException {
		if (item != null) {
			Item[] itemSet = super.getItemSet();
			int currentAmountOfProducts = super.getCurrentAmountOfProducts();
			if ((item != null) && (!item.isSelected())) {
				if (currentAmountOfProducts < capacity) {
					itemSet[currentAmountOfProducts] = item;
					item.setSelected(true);
					super.setCurrentAmountOfProducts(++currentAmountOfProducts);
				} else {
					throw new ShoppingBasketFullException("You can't add any more items to the basket");
				}
			}
		}
	}

	public void removeProductFromBasket(int index) {
		if (super.getCurrentAmountOfProducts() >= index) {
			super.getItemSet()[index].setSelected(false);
			super.removeProduct(index);
		}
	}

	@Override
	public Item getItem(int index) throws NoSuchItemException {
		if (index < capacity) {
			return super.getItemSet()[index];
		} else {
			throw new NoSuchItemException("There can not be element with index " + index);
		}
	}

	@Override
	public String toString() {
		return HEADER + super.toString();
	}
}
