package by.epam.javatraining.kutsko.task1.util.initializer;

import org.apache.log4j.Logger;

import by.epam.javatraining.kutsko.task1.model.container.ClothingStore;
import by.epam.javatraining.kutsko.task1.model.entity.Item;
import by.epam.javatraining.kutsko.task1.model.exception.CorruptContainerReferenceException;
import by.epam.javatraining.kutsko.task1.model.exception.CorruptItemReferenceException;
import by.epam.javatraining.kutsko.task1.model.exception.WarehouseFullException;

public class Initializer {

	public static ClothingStore fillWarehouse(ClothingStore store, Item[] itemSet)
			throws WarehouseFullException, CorruptContainerReferenceException {
		
		if (store != null) {
			
			store.removeAll();
			
			if (itemSet != null) {
				
				for (Item item : itemSet) {
					try {
						store.addProduct(item);
					} catch (CorruptItemReferenceException e) {
						Logger logger = Logger.getRootLogger();
						logger.warn("Item reference was null");
					}
				}
				
			} else {
				throw new CorruptContainerReferenceException("Corrupt reference to item set");
			}
			
		} else {
			throw new CorruptContainerReferenceException("Corrupt reference to the store");
		}
		
		return store;
	}

}
