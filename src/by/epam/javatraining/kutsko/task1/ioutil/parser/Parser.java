package by.epam.javatraining.kutsko.task1.ioutil.parser;

import by.epam.javatraining.kutsko.task1.model.entity.Accessory;
import by.epam.javatraining.kutsko.task1.model.entity.Clothing;
import by.epam.javatraining.kutsko.task1.model.entity.Jumper;
import by.epam.javatraining.kutsko.task1.model.entity.Scarf;
import by.epam.javatraining.kutsko.task1.model.entity.type.*;
import by.epam.javatraining.kutsko.task1.model.exception.CorruptParameterReferenceException;
import by.epam.javatraining.kutsko.task1.util.creator.CreatorFactory;

public class Parser {

	public static String[] splitLine(String line) throws CorruptParameterReferenceException {
		
		if (line != null) {
			
			String delimeter = "\\s+";
			String[] splittedString = line.split(delimeter);
			
			return splittedString;
		}
		throw new CorruptParameterReferenceException("Data string was null");
	}

	public static Object[] parseData(String[] splittedData) throws CorruptParameterReferenceException {
		
		if (splittedData != null) {
			
			Object[] parsedData = new Object[splittedData.length];
			
			int itemId = (Integer) parsedData[0];
			parsedData[1] = Double.parseDouble(splittedData[1]);
			parsedData[2] = Material.valueOf(splittedData[2]);
			parsedData[3] = Boolean.parseBoolean(splittedData[3]);
			parsedData[4] = Color.valueOf(splittedData[4]);

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
		throw new CorruptParameterReferenceException("Data string was null");
	}
}
