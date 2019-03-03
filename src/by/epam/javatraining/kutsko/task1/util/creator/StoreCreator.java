package by.epam.javatraining.kutsko.task1.util.creator;

import by.epam.javatraining.kutsko.task1.model.container.ClothingStore;

public class StoreCreator {

	
	public static ClothingStore getStore() {
		return ClothingStore.getInstance();
	}
}
