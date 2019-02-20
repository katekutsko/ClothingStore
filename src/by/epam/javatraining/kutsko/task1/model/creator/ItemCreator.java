package by.epam.javatraining.kutsko.task1.model.creator;

import java.util.List;

import by.epam.javatraining.kutsko.task1.model.container.ClothingStore;
import by.epam.javatraining.kutsko.task1.model.container.Container;
import by.epam.javatraining.kutsko.task1.model.entity.Item;
import by.epam.javatraining.kutsko.task1.util.parser.Parser;
import by.epam.javatraining.kutsko.task1.util.validator.Validator;

public class ItemCreator {
	
	private static ClothingStore store;
	
	private static ItemCreator itemCreator;
	
	private ItemCreator() {}
	
	public static ItemCreator getInstance() {
		if (itemCreator == null) {
			itemCreator = new ItemCreator();
		}
		return itemCreator;
	}
	
	public Container fillWarehouse(List<String> rawData) {
		if (store == null) {
			store = new ClothingStore();
			for (String line : rawData) {
				String[] splittedData = Parser.splitLine(line);
				if (Validator.validateData(splittedData)) {
					Object[] parsedData = Parser.parseData(splittedData);
					Item newItem = getItem(parsedData);
					if (newItem != null) {
						store.addProductToWarehouse(newItem);
					}
				}
			}
		}
		return store;
	}
	
	public Item getItem(Object... parameters) {
		int itemId = (int) parameters[0];
		AbstractCreator creator = null;
		switch (itemId) {
			case 1:{
				creator = new HighHeelsCreator();
			} break;
			case 2: {
				creator = new ScarfCreator();
			} break;
			case 3:{
				creator = new JumperCreator();
			} break;
		}
		return creator.create(parameters);
	}
}
