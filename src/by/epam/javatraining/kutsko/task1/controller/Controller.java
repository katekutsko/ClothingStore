package by.epam.javatraining.kutsko.task1.controller;

import by.epam.javatraining.kutsko.task1.model.comparator.CategoryComparator;
import by.epam.javatraining.kutsko.task1.model.comparator.ColorComparator;
import by.epam.javatraining.kutsko.task1.model.container.ClothingStore;
import by.epam.javatraining.kutsko.task1.model.creator.*;
import by.epam.javatraining.kutsko.task1.model.entity.*;
import by.epam.javatraining.kutsko.task1.model.logic.Finder;
import by.epam.javatraining.kutsko.task1.model.logic.Sorter;
import by.epam.javatraining.kutsko.task1.util.parser.Parser;
import by.epam.javatraining.kutsko.task1.util.reader.DataReader;
import by.epam.javatraining.kutsko.task1.util.validator.Validator;
import by.epam.javatraining.kutsko.task1.view.*;
import by.epam.javatraining.kutsko.task1.view.creator.ConsolePrinterCreator;
import by.epam.javatraining.kutsko.task1.view.creator.FilePrinterCreator;
import by.epam.javatraining.kutsko.task1.view.creator.PrinterFactory;
import by.epam.javatraining.kutsko.task1.exception.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Controller {

	public static void main(String[] args) {
		
		List<String> rawData = new ArrayList<String>();
		
		try {
			rawData = DataReader.readFromFile("data.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] temporaryCopy = new String[rawData.size()];
		rawData.toArray(temporaryCopy);
		for (String line : temporaryCopy) {
			if (!Validator.validateQuantity(line)) {
				rawData.remove(line);
			}
		}
		
		ItemCreator itemCreator = ItemCreator.getInstance();
		ClothingStore store = (ClothingStore) itemCreator.fillWarehouse(rawData);
		PrinterFactory creator = PrinterFactory.getInstance();
		Printer filePrinter = creator.getPrinter(new FilePrinterCreator());
		Printer consolePrinter = creator.getPrinter(new ConsolePrinterCreator());
		try {
			consolePrinter.print(store);
			filePrinter.print(store);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sorter.sort(store, new CategoryComparator());
		try {
			consolePrinter.print(store);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
