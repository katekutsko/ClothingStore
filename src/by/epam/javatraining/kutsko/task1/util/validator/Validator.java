package by.epam.javatraining.kutsko.task1.util.validator;

import java.util.regex.Pattern;
import by.epam.javatraining.kutsko.task1.model.entity.*;

public class Validator {
	
	 public static boolean validateQuantity(String line) {
		String regex ="(.+\\s){5}.+";
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
		 try {  
			int itemId = Integer.parseInt(data[0]);
			Item.Material.valueOf(data[2]);
			Item.Color.valueOf(data[4]);
			 switch (itemId) {
				 case 1: {
					 regex = "[3-4]\\d\\d+([.]\\d)?";
					 return Pattern.matches(regex, data[5]+data[6]);
				 }
				 case 2: {
//					 int counter = 0;
//					for (Accessory.Season value : Accessory.Season.values()) {
//						if (data[5] == value.toString()) {
//							break;
//						} else {
//							counter++;
//						}
//					}
//					if (counter == Accessory.Season.values().length) {
//						return false;
//					}
					Accessory.Season.valueOf(data[5]);
					Scarf.Type.valueOf(data[6]);
				 } break;
				 case 3: {
					Clothing.Size.valueOf(data[5]);
					Jumper.Type.valueOf(data[6]);
				 }
			 } 
		 } catch (IllegalArgumentException e) {
				return false;
		 }
		 return true;
	 }
}
