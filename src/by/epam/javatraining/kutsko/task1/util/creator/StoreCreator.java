package by.epam.javatraining.kutsko.task1.util.creator;

import by.epam.javatraining.kutsko.task1.model.container.ClothingStore;

public class StoreCreator {

	private StoreCreator instance;
	
	private StoreCreator() {}
	
	public StoreCreator getInstance() {
		if(instance == null) {
			instance = new StoreCreator();
		}
		return instance;
	}
	
	public ClothingStore getStore() {
		return new ClothingStore();
	}
}
