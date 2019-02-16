package by.epam.javatraining.kutsko.task1.util.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.epam.javatraining.kutsko.task1.model.entity.Accessory;
import by.epam.javatraining.kutsko.task1.model.entity.Clothing;
import by.epam.javatraining.kutsko.task1.model.entity.Item;
import by.epam.javatraining.kutsko.task1.model.entity.Jumper;
import by.epam.javatraining.kutsko.task1.model.entity.Scarf;
import by.epam.javatraining.kutsko.task1.model.entity.Shoes;

public class Validator {
	
	 public static boolean validateQuantity(String line) {
		String regex ="(.+\\s){5}.+";
		return Pattern.matches(regex, line);
	 }
	 
	 public static boolean validateData(String[] data) {
		 int itemId = Integer.parseInt(data[0]);
		 String regex = "\\d+[.]\\d+";
		 if (!Pattern.matches(regex, data[1])) {
			 return false;
		 }
		 try {
			Item.Material.valueOf(data[2]);
		 } catch (IllegalArgumentException e) {
			 return false;
		 }
		 if (!(data[3].equalsIgnoreCase("true")) && !(data[3].equalsIgnoreCase("false"))) {
			 return false;
		 }
		 try {
				Item.Color.valueOf(data[4]);
			 } catch (IllegalArgumentException e) {
				 return false;
			 }
		 switch (itemId) {
		 case 1: {
			 regex = "[3-4]\\d\\d+([.]\\d)?";
			 return Pattern.matches(regex, data[5]+data[6]);
		 }
		 case 2:{
			 try {
					Accessory.Season.valueOf(data[5]);
					Scarf.Type.valueOf(data[6]);
				} catch (IllegalArgumentException e) {
					 return false;
				 }
			
		 } break;
		 case 3:{
			 try {
					Clothing.Size.valueOf(data[5]);
					Jumper.Type.valueOf(data[6]);
				 } catch (IllegalArgumentException e) {
					 return false;
				 }
		 } break;
		 }
		 return true;
	 }
}
