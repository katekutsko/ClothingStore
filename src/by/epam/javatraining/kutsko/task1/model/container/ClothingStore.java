package by.epam.javatraining.kutsko.task1.model.container;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import by.epam.javatraining.kutsko.task1.model.entity.Item;
import by.epam.javatraining.kutsko.task1.model.exception.CorruptItemReferenceException;
import by.epam.javatraining.kutsko.task1.model.exception.NoSuchItemException;
import by.epam.javatraining.kutsko.task1.model.exception.WarehouseFullException;
/**
 * Container class representing a clothing store. 
 * 
 * @author Екатерина
 *
 */
public class ClothingStore {

	private static final Logger LOGGER;

	static {
		LOGGER = Logger.getRootLogger();
		PropertyConfigurator.configure("log4j.properties");
	}

	public final static int MAX_CAPACITY = 100;
	public final static int DEFAULT_CAPACITY = 10;
	private final static String HEADER = "Contents of clothing store warehouse:\n";
		
	private int currentAmountOfProducts = 0;
	private Item[] itemSet;
	private boolean sorted;
	/**
	 * Default constructor. Initializes item set as an array of default capacity
	 */
	public ClothingStore() {
		itemSet = new Item[DEFAULT_CAPACITY];
	}

	/**
	 * Parameterized constructor. Initializes item set as an array of specified capacity
	 * @param capacity size of an item set array
	 */
	public ClothingStore(int capacity) {
		itemSet = new Item[capacity];
	}

	/**
	 * Copying constructor. Copies item set from a template container if latter is not null, otherwise
	 * calls for default constructor
	 * @param store template to copy
	 */
	public ClothingStore(ClothingStore store) {
		this();
		if ((store != null) && (store.itemSet != null)) {
			itemSet = Arrays.copyOf(store.itemSet, store.itemSet.length);
		}
		else {
			LOGGER.warn("Reference to a template object was null");
		}
	}
	
	/**
	 * 
	 * @param index index of a item to get
	 * @return item under specified index or null if such index is not occupied, but allowed
	 * @throws NoSuchItemException when index surpasses allowed values
	 */
	public Item getItem(int index) throws NoSuchItemException {
		if ((index >= 0) && (index < MAX_CAPACITY)) {
			if (index >= currentAmountOfProducts) {
				return null;
			}
			return itemSet[index];
		} else {
			throw new NoSuchItemException("There is no element with index " + index);
		}
	}
	
	/**
	 * @return current item set
	 */
	public Item[] getItemSet() {
		itemSet = Arrays.copyOf(itemSet, currentAmountOfProducts);
		return itemSet;
	}

	
	/**
	 * 
	 * @return indicator which shows if item set is sorted by price. Useful for binary search by price
	 */
	public boolean isSorted() {
		return sorted;
	}

	/**
	 * 
	 * @param sorted indicator which shows if item set is sorted by price
	 */
	public void setSorted(boolean sorted) {
		this.sorted = sorted;
	}

	/**
	 * 
	 * @return current amount of items in storage
	 */
	public int getCurrentAmountOfProducts() {
		return currentAmountOfProducts;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + currentAmountOfProducts;
		result = prime * result + Arrays.hashCode(itemSet);
		result = prime * result + (sorted ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		ClothingStore other = (ClothingStore) obj;
		
		if (currentAmountOfProducts != other.currentAmountOfProducts)
			return false;
		if (!Arrays.equals(itemSet, other.itemSet))
			return false;
		if (sorted != other.sorted)
			return false;
		return true;
	}
	
	/**
	 * 
	 * @param item item to add to the storage
	 * @throws WarehouseFullException when maximum capacity of the storage is reached
	 * @throws CorruptItemReferenceException  when item reference is null
	 */
	public void addProduct(Item item) throws WarehouseFullException, CorruptItemReferenceException {
		if (item != null) {
			if (currentAmountOfProducts < MAX_CAPACITY) {
				if (currentAmountOfProducts >= itemSet.length) {
					enlargeCapacity();
				}
				itemSet[currentAmountOfProducts++] = item;
			} else {
				throw new WarehouseFullException(
						"You can't add more than " + MAX_CAPACITY + " item into the warehouse");
			}
		} 
		throw new CorruptItemReferenceException("Item reference was null");
	}

	/**
	 * enlarges capacity by one
	 */
	private void enlargeCapacity() {
		itemSet = Arrays.copyOf(itemSet, currentAmountOfProducts + 1);
	}

	
	/**
	 * removes item under specified index
	 * @param index index of the product to be removed
	 * @return true if item was deleted, false if index pointed beyond the boundaries of item set
	 */
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
	/**
	 * removes all items from item set
	 */
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
		if (itemSet != null) {
			StringBuilder builder = new StringBuilder();
			builder.append(HEADER);
			for (int i = 0; i < getCurrentAmountOfProducts(); i++) {
				builder.append(itemSet[i].toString());
				builder.append("\n");
			}
			return builder.toString();
		} else {
			return "";
		}
	}
}
