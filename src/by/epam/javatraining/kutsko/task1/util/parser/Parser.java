package by.epam.javatraining.kutsko.task1.util.parser;

import by.epam.javatraining.kutsko.task1.model.entity.Accessory;
import by.epam.javatraining.kutsko.task1.model.entity.Clothing;
import by.epam.javatraining.kutsko.task1.model.entity.Item;
import by.epam.javatraining.kutsko.task1.model.entity.Jumper;
import by.epam.javatraining.kutsko.task1.model.entity.Scarf;

public class Parser {

	public static String[] splitLine(String line) {
		String delimeter = "\\s+";
		String[] splittedData = line.split(delimeter);
		return splittedData;
	}
	
	public static Object[] parseData(String[] splittedData) {
		Object[] parsedData = new Object[splittedData.length];
		parsedData[0] = Integer.parseInt(splittedData[0]);
		int itemId = (Integer) parsedData[0];
		parsedData[1] = Double.parseDouble(splittedData[1]);
		parsedData[2] = Item.Material.valueOf(splittedData[2]);
		parsedData[3] = Boolean.parseBoolean(splittedData[3]);
		parsedData[4] = Item.Color.valueOf(splittedData[4]);
		if (itemId == 1) {
			parsedData[5] = Integer.parseInt(splittedData[5]);
			parsedData[6] = Float.parseFloat(splittedData[6]);
		} else if (itemId == 2) {
			parsedData[5] = Accessory.Season.valueOf(splittedData[5]);
			parsedData[6] = Scarf.Type.valueOf(splittedData[6]);
		} else if (itemId == 3) {
			parsedData[5] = Clothing.Size.valueOf(splittedData[5]);
			parsedData[6] = Jumper.Type.valueOf(splittedData[6]);
		}
		return parsedData;
	}
}
