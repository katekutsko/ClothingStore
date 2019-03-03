package by.epam.javatraining.kutsko.task1.model.container;

import java.util.Arrays;

import by.epam.javatraining.kutsko.task1.model.entity.Item;
import by.epam.javatraining.kutsko.task1.model.exception.NoSuchItemException;
import by.epam.javatraining.kutsko.task1.model.exception.WarehouseFullException;

public class ClothingStore extends Container {

	public final static int MAX_CAPACITY = 100;
	public final static int DEFAULT_CAPACITY = 10;
	private final static String HEADER = "Contents of clothing store warehouse:\n";
	public final static String STORE_TOTAL_HEADER = "Price of all items in store: ";

	private static ClothingStore instance;

	private ClothingStore() {
		super(DEFAULT_CAPACITY);
	}

	public static ClothingStore getInstance() {
		if (instance == null) {
			instance = new ClothingStore();
		}
		return instance;
	}

	public Item[] getItemSet() {
		return Arrays.copyOf(super.getItemSet(), super.getCurrentAmountOfProducts());
	}

	@Override
	public void addProduct(Item item) throws WarehouseFullException {
		if (item != null) {
			int currentAmountOfProducts = super.getCurrentAmountOfProducts();
			Item[] itemSet = super.getItemSet();
			if (currentAmountOfProducts < MAX_CAPACITY) {
				if (currentAmountOfProducts >= DEFAULT_CAPACITY) {
					super.enlargeCapacity();
					itemSet = super.getItemSet();
				}
				itemSet[currentAmountOfProducts] = item;
				super.setCurrentAmountOfProducts(++currentAmountOfProducts);
			} else {
				throw new WarehouseFullException(
						"You can't add more than " + MAX_CAPACITY + " item into the warehouse");
			}
		} 
	}

	@Override
	public Item getItem(int index) throws NoSuchItemException {
		if ((index >= 0) && (index < MAX_CAPACITY)) {
			if (index >= super.getCurrentAmountOfProducts()) {
				return null;
			}
			return super.getItemSet()[index];
		} else {
			throw new NoSuchItemException("There is no element with index " + index);
		}

	}

	@Override
	public String toString() {
		return HEADER + super.toString();
	}

}
