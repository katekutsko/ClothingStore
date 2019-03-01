package by.epam.javatraining.kutsko.task1.util.validator;

import java.util.regex.Pattern;
import by.epam.javatraining.kutsko.task1.model.entity.*;

public class Validator {

	public static boolean validateQuantity(String line) {
		String regex = "(.+\\s){5}.+";
		return Pattern.matches(regex, line);
	}

	public static boolean validateData(String[] data) {
		String regex = "\\d+[.]\\d+";
		if (!Pattern.matches(regex, data[1])) {
			return false;
		}
		if (!(data[3].equalsIgnoreCase("true")) && !(data[3].equalsIgnoreCase("false"))) {
			return false;
		}
		int counter = 0;
		int itemId = Integer.parseInt(data[0]);
		Item.Material.valueOf(data[2]);
		Item.Color.valueOf(data[4]);
		for (Item.Material value : Item.Material.values()) {
			if (data[2].equalsIgnoreCase(value.toString())) {
				break;
			} else {
				counter++;
			}
		}
		if (counter == Item.Material.values().length) {
			return false;
		}
		counter = 0;
		for (Item.Color value : Item.Color.values()) {
			if (data[4].equalsIgnoreCase(value.toString())) {
				break;
			} else {
				counter++;
			}
		}
		if (counter == Item.Color.values().length) {
			return false;
		}
		switch (itemId) {
		case 1: {
			regex = "[3-4]\\d\\d+([.]\\d)?";
			return Pattern.matches(regex, data[5] + data[6]);
		}
		case 2: {
			counter = 0;
			for (Accessory.Season value : Accessory.Season.values()) {
				if (data[5].equalsIgnoreCase(value.toString())) {
					break;
				} else {
					counter++;
				}
			}
			if (counter == Accessory.Season.values().length) {
				return false;
			}
			counter = 0;
			for (Scarf.Type value : Scarf.Type.values()) {
				if (data[6].equalsIgnoreCase(value.toString())) {
					break;
				} else {
					counter++;
				}
			}
			if (counter == Accessory.Season.values().length) {
				return false;
			}
//					Accessory.Season.valueOf(data[5]);
//					Scarf.Type.valueOf(data[6]); 
		}
			break;
		case 3: {
			counter = 0;
			for (Clothing.Size value : Clothing.Size.values()) {
				if (data[5].equalsIgnoreCase(value.toString())) {
					break;
				} else {
					counter++;
				}
			}
			if (counter == Clothing.Size.values().length) {
				return false;
			}
			counter = 0;
			for (Jumper.Type value : Jumper.Type.values()) {
				if (data[6].equalsIgnoreCase(value.toString())) {
					break;
				} else {
					counter++;
				}
			}
			if (counter == Jumper.Type.values().length) {
				return false;
			}
//					Clothing.Size.valueOf(data[5]);
//					Jumper.Type.valueOf(data[6]);
		}
			break;
		default: {
			return false;
		}
		}
		return true;
	}
}
