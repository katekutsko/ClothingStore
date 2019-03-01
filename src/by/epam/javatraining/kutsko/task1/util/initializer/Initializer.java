package by.epam.javatraining.kutsko.task1.util.initializer;

import java.util.List;

import by.epam.javatraining.kutsko.task1.model.container.ClothingStore;
import by.epam.javatraining.kutsko.task1.model.entity.Item;
import by.epam.javatraining.kutsko.task1.model.exception.CorruptContainerReferenceException;
import by.epam.javatraining.kutsko.task1.model.exception.WarehouseFullException;
import by.epam.javatraining.kutsko.task1.util.creator.*;
import by.epam.javatraining.kutsko.task1.util.parser.Parser;
import by.epam.javatraining.kutsko.task1.util.validator.Validator;

public class Initializer {

	private static List<String> prepareData(List<String> rawData) {
		String[] temporaryCopy = new String[rawData.size()];
		rawData.toArray(temporaryCopy);
		for (String line : temporaryCopy) {
			if (!Validator.validateQuantity(line)) {
				rawData.remove(line);
			}
		}
		return rawData;
	}

	public static ClothingStore fillWarehouse(ClothingStore store, List<String> rawData)
			throws WarehouseFullException, CorruptContainerReferenceException {
		if (store != null) {
			store.removeAll();
			if (rawData != null) {
				List<String> preparedData = prepareData(rawData);
				for (String line : preparedData) {
					String[] splittedData = Parser.splitLine(line);
					if (Validator.validateData(splittedData)) {
						Object[] parsedData = Parser.parseData(splittedData);
						Item newItem = getItem(parsedData);
						if (newItem != null) {
							store.addProduct(newItem);
						}
					}
				}
			}
			return store;
		} else {
			throw new CorruptContainerReferenceException("Corrupt reference to warehouse");
		}
	}

	public static Item getItem(Object... parameters) {
		int itemId = (int) parameters[0];
		AbstractCreator creator = null;
		switch (itemId) {
		case 1: {
			creator = new HighHeelsCreator();
		}
			break;
		case 2: {
			creator = new ScarfCreator();
		}
			break;
		case 3: {
			creator = new JumperCreator();
		}
			break;
		}
		if (creator != null) {
			return creator.create(parameters);
		} else {
			return null;
		}
	}

}
