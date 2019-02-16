package by.epam.javatraining.kutsko.task1.controller;

import by.epam.javatraining.kutsko.task1.model.container.ClothingStore;
import by.epam.javatraining.kutsko.task1.model.creator.*;
import by.epam.javatraining.kutsko.task1.model.entity.*;
import by.epam.javatraining.kutsko.task1.model.logic.Finder;
import by.epam.javatraining.kutsko.task1.model.logic.Sorter;
import by.epam.javatraining.kutsko.task1.util.parser.Parser;
import by.epam.javatraining.kutsko.task1.util.reader.DataReader;
import by.epam.javatraining.kutsko.task1.util.validator.Validator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import by.epam.javatraining.kutsko.task1.exception.*;

public class Controller {

	public static void main(String[] args) {
		
		ClothingStore store = new ClothingStore();
		List<String> rawData = new ArrayList<String>();
		
		try {
			rawData = DataReader.readFromFile("data.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (String line : rawData) {
			if (!Validator.validateQuantity(line)) {
				rawData.remove(line);
			}
		}
		
		for (String line : rawData) {
			String[] splittedData = Parser.splitLine(line);
			if (Validator.validateData(splittedData)) {
				Object[] parsedData = Parser.parseData(splittedData);
				int itemId = (Integer) parsedData[6];
				parsedData = Arrays.copyOfRange(parsedData, 0, 6);
				AbstractCreator creator;
				
				switch(itemId) {
					case 1: {
						creator = new HighHeelsCreator();
					} break;
					case 2: {
						creator = new ScarfCreator();
					} break;
					case 3:  {
						creator = new JumperCreator();
					} break;
					default: {
						creator = null;
					}
				}
				
				if (creator != null) {
					Item item = Creator.getItem(creator, parsedData);
					store.addProduct(item);
				}
			}
		}
	}

}
