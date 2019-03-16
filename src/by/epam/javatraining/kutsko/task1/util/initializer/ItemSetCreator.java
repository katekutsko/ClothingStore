package by.epam.javatraining.kutsko.task1.util.initializer;

import java.util.ArrayList;
import java.util.List;

import by.epam.javatraining.kutsko.task1.ioutil.parser.Parser;
import by.epam.javatraining.kutsko.task1.ioutil.validator.Validator;
import by.epam.javatraining.kutsko.task1.model.entity.Accessory;
import by.epam.javatraining.kutsko.task1.model.entity.Clothing;
import by.epam.javatraining.kutsko.task1.model.entity.Item;
import by.epam.javatraining.kutsko.task1.model.entity.Jumper;
import by.epam.javatraining.kutsko.task1.model.entity.Scarf;
import by.epam.javatraining.kutsko.task1.model.entity.type.Color;
import by.epam.javatraining.kutsko.task1.model.entity.type.Material;
import by.epam.javatraining.kutsko.task1.model.exception.CorruptParameterReferenceException;
import by.epam.javatraining.kutsko.task1.util.creator.*;

public class ItemSetCreator {

	private static class Parser {

		private static String[] splitLine(String line) {

			String delimeter = "\\s+";
			String[] splittedString = line.split(delimeter);

			return splittedString;
		}

		private static Object[] parseData(String[] splittedData) throws CorruptParameterReferenceException {

			Object[] parsedData = new Object[splittedData.length];
			parsedData[0] = CreatorFactory.valueOf(splittedData[0]);
			CreatorFactory itemId = (CreatorFactory) parsedData[0];
			parsedData[1] = Double.parseDouble(splittedData[1]);
			parsedData[2] = Material.valueOf(splittedData[2]);
			parsedData[3] = Boolean.parseBoolean(splittedData[3]);
			parsedData[4] = Color.valueOf(splittedData[4]);

			switch (itemId ) {
			case HIGHHEELS:{
				parsedData[5] = Integer.parseInt(splittedData[5]);
				parsedData[6] = Float.parseFloat(splittedData[6]);
			} break;
			case SCARF: {
				parsedData[5] = Accessory.Season.valueOf(splittedData[5]);
				parsedData[6] = Scarf.Type.valueOf(splittedData[6]);
			} break;
			case JUMPER: {
				parsedData[5] = Clothing.Size.valueOf(splittedData[5]);
				parsedData[6] = Jumper.Type.valueOf(splittedData[6]);
			} break;
		}
			return parsedData;
	}
	}

		public static Item[] createItemSet(List<String> rawData) throws CorruptParameterReferenceException {

			if (rawData != null) {

				ArrayList<Item> itemSet = new ArrayList<>();

				for (String rawDataString : rawData) {
					if (rawDataString != null) {
						String[] splittedDataString = Parser.splitLine(rawDataString);
						if (Validator.validateData(splittedDataString)) {
							Object[] parsedData = Parser.parseData(splittedDataString);
							Item newItem = getItem(parsedData);
							itemSet.add(newItem);
						}
					}
				}

				Item[] newItemSet = new Item[itemSet.size()];

				return itemSet.toArray(newItemSet);
			}
			throw new CorruptParameterReferenceException("List of data strings was null");
		}

		private static Item getItem(Object... parameters) {

			// int itemId = (int) parameters[0];
			// AbstractCreator creator = getCreator(itemId);

			CreatorFactory factory = (CreatorFactory) parameters[0];
			AbstractCreator creator = factory.getCreator();
			System.out.println(creator.getClass().getSimpleName());
			return creator.create(parameters);
		}

	}
