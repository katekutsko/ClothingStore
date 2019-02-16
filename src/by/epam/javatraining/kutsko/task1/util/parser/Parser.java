package by.epam.javatraining.kutsko.task1.util.parser;

import by.epam.javatraining.kutsko.task1.model.entity.Accessory;
import by.epam.javatraining.kutsko.task1.model.entity.Clothing;
import by.epam.javatraining.kutsko.task1.model.entity.Item;
import by.epam.javatraining.kutsko.task1.model.entity.Jumper;
import by.epam.javatraining.kutsko.task1.model.entity.Scarf;

public class Parser {

	public static String[] splitLine(String line) {
		String delimeter = " ";
		String[] splittedData = line.split(delimeter);
		return splittedData;
	}
	
	public static Object[] parseData(String[] splittedData) {
		Object[] parsedData = new Object[splittedData.length];
		parsedData[6] = Integer.parseInt(splittedData[0]);
		int itemId = (Integer) parsedData[6];
		parsedData[0] = Double.parseDouble(splittedData[1]);
		parsedData[1] = Item.Material.valueOf(splittedData[2]);
		parsedData[2] = Boolean.parseBoolean(splittedData[3]);
		parsedData[3] = Item.Color.valueOf(splittedData[4]);
		if (itemId == 1) {
			parsedData[4] = Integer.parseInt(splittedData[5]);
			parsedData[5] = Float.parseFloat(splittedData[6]);
		} else if (itemId == 2) {
			parsedData[4] = Accessory.Season.valueOf(splittedData[5]);
			parsedData[5] = Scarf.Type.valueOf(splittedData[6]);
		} else if (itemId == 3) {
			parsedData[4] = Clothing.Size.valueOf(splittedData[5]);
			parsedData[5] = Jumper.Type.valueOf(splittedData[6]);
		}
		return parsedData;
	}
}
