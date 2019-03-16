package by.epam.javatraining.kutsko.task1.ioutil.validator;

import java.util.Arrays;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import by.epam.javatraining.kutsko.task1.model.entity.*;
import by.epam.javatraining.kutsko.task1.model.entity.type.*;
import by.epam.javatraining.kutsko.task1.util.creator.CreatorFactory;

public class Validator {

	private static final Logger LOGGER;

	static {
		LOGGER = Logger.getRootLogger();
		PropertyConfigurator.configure("log4j.properties");
	}
	
	private static boolean validateType(String type) {
		
		int counter = 0;

		for (CreatorFactory value : CreatorFactory.values()) {
			if (type.equalsIgnoreCase(value.toString())) {
				break;
			} else {
				counter++;
			}
		}

		if (counter == CreatorFactory.values().length) {
			return false;
		}
		return true;
	}
	
	private static boolean validatePrice(String price) {
		String regex = "\\d+[.]\\d+";

		if (!Pattern.matches(regex, price)) {
			return false;
		}

		return true;
	}
	
	private static boolean validateColor(String color) {
		int counter = 0;

		for (Color value : Color.values()) {
			if (color.equalsIgnoreCase(value.toString())) {
				break;
			} else {
				counter++;
			}
		}

		if (counter == Color.values().length) {
			return false;
		}
		return true;
	}
	
	private static boolean validateMaterial(String material) {
		
		int counter = 0;

		for (Material value : Material.values()) {
			if (material.equalsIgnoreCase(value.toString())) {
				break;
			} else {
				counter++;
			}
		}

		if (counter == Material.values().length) {
			return false;
		}
		return true;
	}
	
	private static boolean validateClothingSize(String size) {
		int counter = 0;

		for (Clothing.Size value : Clothing.Size.values()) {
			if (size.equalsIgnoreCase(value.toString())) {
				break;
			} else {
				counter++;
			}
		}

		if (counter == Clothing.Size.values().length) {
			return false;
		}
		return true;
	}
	
	private static boolean validateShoesSize(String size) {
		return false;
	}
	
	private static boolean validateJumperType(String type) {
		int counter = 0;

		for (Jumper.Type value : Jumper.Type.values()) {
			if (type.equalsIgnoreCase(value.toString())) {
				break;
			} else {
				counter++;
			}
		}

		if (counter == Jumper.Type.values().length) {
			return false;
		}
		return true;
	}
	
	private static boolean validateHeelHeight(String heelHeight) {
		return false;
	}
	
	private static boolean validateSelected(String selected) {
		if (!((selected.equalsIgnoreCase("true")) || (selected.equalsIgnoreCase("false")))) {
			return false;
		}
		return true;
	}
	
	private static boolean validateScarfType(String type) {
		int counter = 0;
		for (Scarf.Type value : Scarf.Type.values()) {
			if (type.equalsIgnoreCase(value.toString())) {
				break;
			} else {
				counter++;
			}
		}

		if (counter == Accessory.Season.values().length) {
			return false;
		}
		return true;
	}
	
	private static boolean validateAccessorySeason(String season) {
		int counter = 0;

		for (Accessory.Season value : Accessory.Season.values()) {
			if (season.equalsIgnoreCase(value.toString())) {
				break;
			} else {
				counter++;
			}
		}

		if (counter == Accessory.Season.values().length) {
			return false;
		}
		return true;
	}
	
	public static boolean validateData(String[] data) {

		if (data == null || data.length < 6) {
			LOGGER.info("Line " + Arrays.deepToString(data) + "is not valid");
			return false;
		}

		for (String string : data) {
			if (string == null) {
				LOGGER.info("Line " + Arrays.deepToString(data) + "is not valid");
				return false;
			}
		}
		
		if (!(validateType(data[0]) && validateMaterial(data[2]) && validatePrice(data[1]) && validateSelected(data[3]) && validateColor(data[4]))) {
			LOGGER.info("Line " + Arrays.deepToString(data) + " is not valid");
			return false;
		}
		
		CreatorFactory itemId = CreatorFactory.valueOf(data[0]);

		switch (itemId) {
		case HIGHHEELS: {
			String regex = "[3-4]\\d\\d+([.]\\d)?";
			if (!Pattern.matches(regex, data[5] + data[6])) {
				LOGGER.info("Line " + Arrays.deepToString(data) + "is not valid");
				return false;
			}
			return true;
		}

		case SCARF: {
			if (!(validateAccessorySeason(data[5]) && validateScarfType(data[6]))) {
				LOGGER.info("Line " + Arrays.deepToString(data) + "is not valid");
				return false;
			}
			return true;
		}
		
		case JUMPER: {
			if (!(validateClothingSize(data[5]) && validateJumperType(data[6]))) {
				LOGGER.info("Line " + Arrays.deepToString(data) + "is not valid");
				return false;
			} 
			return true;
		}
		default: {
			LOGGER.info("Line " + Arrays.deepToString(data) + "is not valid");
			return false;
		}
		}
	}
		
}
