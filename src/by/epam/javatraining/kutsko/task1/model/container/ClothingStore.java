package by.epam.javatraining.kutsko.task1.model.container;

import by.epam.javatraining.kutsko.task1.exception.NonexistentArgumentException;
import by.epam.javatraining.kutsko.task1.exception.WarehouseFullException;
import by.epam.javatraining.kutsko.task1.model.entity.Item;

public class ClothingStore extends Container {
	
	public final static int MAX_CAPACITY = 10;
	
	public ClothingStore() {
		super(MAX_CAPACITY);
	}
	
	public ClothingStore(int capacity) {
		super(capacity);
	}
	
	public Item[] getItemSet() {
		return super.getItemSet();
	}
	
	public void addProductToWarehouse(Item item) {
		super.addProduct(item);
	}
	
	@Override
	public String toString() {
		Item[] thisItemSet = getItemSet();
		if (thisItemSet != null) {
			StringBuilder builder = new StringBuilder("Contents of clothing store warehouse:\n");
			for (int i = 0; i < super.getCurrentAmountOfProducts(); i++) {
				builder.append(thisItemSet[i].toString());
				builder.append("\n");
			}
		return builder.toString();
		} else {
			return "A problem occured: no data is available";
		}
	}
}
