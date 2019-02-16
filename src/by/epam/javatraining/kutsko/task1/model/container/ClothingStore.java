package by.epam.javatraining.kutsko.task1.model.container;

import by.epam.javatraining.kutsko.task1.model.entity.Item;

public class ClothingStore extends Container {
	
	public final static int MAX_CAPACITY = 100;
	
	public ClothingStore() {
		super(MAX_CAPACITY);
	}
	
	public ClothingStore(int capacity) {
		super(capacity);
	}
	
	public Item[] getItemSet() {
		return super.getItemSet();
	}
}
