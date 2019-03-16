package by.epam.javatraining.kutsko.task1.controller;

import java.util.List;

import org.apache.log4j.*;

import by.epam.javatraining.kutsko.task1.ioutil.dataconverter.StringCreator;
import by.epam.javatraining.kutsko.task1.ioutil.reader.DataReader;
import by.epam.javatraining.kutsko.task1.model.container.ClothingStore;
import by.epam.javatraining.kutsko.task1.model.entity.*;
import by.epam.javatraining.kutsko.task1.model.exception.CorruptContainerReferenceException;
import by.epam.javatraining.kutsko.task1.model.exception.CorruptItemReferenceException;
import by.epam.javatraining.kutsko.task1.model.exception.CorruptParameterReferenceException;
import by.epam.javatraining.kutsko.task1.model.exception.NoSuchItemException;
import by.epam.javatraining.kutsko.task1.model.exception.UnsortedItemSetException;
import by.epam.javatraining.kutsko.task1.model.exception.WarehouseFullException;
import by.epam.javatraining.kutsko.task1.model.logic.*;
import by.epam.javatraining.kutsko.task1.model.logic.comparator.ColorComparator;
import by.epam.javatraining.kutsko.task1.util.initializer.*;
import by.epam.javatraining.kutsko.task1.view.Printable;
import by.epam.javatraining.kutsko.task1.view.creator.*;
import by.epam.javatraining.kutsko.task3.serializator.ItemDeserializator;
import by.epam.javatraining.kutsko.task3.serializator.ItemSerializator;

public class Controller {

	private static final Logger LOGGER;

	static {
		LOGGER = Logger.getRootLogger();
		PropertyConfigurator.configure("log4j.properties");
	}

	public static void main(String[] args) {

		String filePath = "data.txt";

		List<String> rawData = null;
		try {
			rawData = DataReader.readFromTxtFile(filePath);
		} catch (CorruptParameterReferenceException e) {
			LOGGER.error(e.getMessage());
		}
		
    	Item[] itemSet = null;
		try {
			itemSet = ItemSetCreator.createItemSet(rawData);
		} catch (CorruptParameterReferenceException e) {
			LOGGER.error(e.getMessage());
		}
		
		ClothingStore store = new ClothingStore();
		try {
			Initializer.fillWarehouse(store, itemSet);
		} catch (WarehouseFullException | CorruptContainerReferenceException e) {
			LOGGER.error(e.getMessage());
		}

		PrinterFactory factory = PrinterFactory.getInstance();
		Printable consolePrinter = factory.getPrinter(new ConsolePrinterCreator());
		consolePrinter.print(StringCreator.convertToString(store));
			
		try {
			Sorter.insertionPriceSort(store);
			Sorter.sort(store, new ColorComparator());
		} catch (CorruptContainerReferenceException e) {
			LOGGER.error(e.getMessage());
		}

		consolePrinter.print(StringCreator.convertToString(store));

		try {
			Item found = Finder.binarySearchByPrice(store, 20.);
			consolePrinter.print(StringCreator.convertToString(found));
		} catch (UnsortedItemSetException | CorruptContainerReferenceException e) {
			LOGGER.error(e.getMessage());
		}

		try {
			double totalPrice = Calculator.calculatePriceOfItems(store);
			consolePrinter.print("Total price: " + StringCreator.convertToString(totalPrice) + "\n");
		} catch (CorruptContainerReferenceException e) {
			LOGGER.error(e.getMessage());
		}

		String itemSerializationFileName = "serialization.bin";
		try {
			ItemSerializator.write(itemSerializationFileName, store.getItem(1));
		} catch (NoSuchItemException e) {
			LOGGER.error(e.getMessage());
		}
		Item deserialized = ItemDeserializator.read(itemSerializationFileName);

		consolePrinter.print("Deserialized: " + StringCreator.convertToString(deserialized));

	}

}
