package by.epam.javatraining.kutsko.task1.controller;

import java.util.List;

import by.epam.javatraining.kutsko.task1.model.container.ClothingStore;
import by.epam.javatraining.kutsko.task1.model.container.ShoppingBasket;
import by.epam.javatraining.kutsko.task1.model.entity.Item;
import by.epam.javatraining.kutsko.task1.model.exception.ContainerFullException;
import by.epam.javatraining.kutsko.task1.model.exception.CorruptContainerReferenceException;
import by.epam.javatraining.kutsko.task1.model.exception.UnsortedItemSetException;
import by.epam.javatraining.kutsko.task1.model.logic.Calculator;
import by.epam.javatraining.kutsko.task1.model.logic.Finder;
import by.epam.javatraining.kutsko.task1.model.logic.Sorter;
import by.epam.javatraining.kutsko.task1.util.creator.BasketCreator;
import by.epam.javatraining.kutsko.task1.util.creator.StoreCreator;
import by.epam.javatraining.kutsko.task1.util.dataconverter.StringCreator;
import by.epam.javatraining.kutsko.task1.util.reader.DataReader;
import by.epam.javatraining.kutsko.task1.util.selector.ItemSelector;
import by.epam.javatraining.kutsko.task1.view.Printer;
import by.epam.javatraining.kutsko.task1.view.creator.ConsolePrinterCreator;
import by.epam.javatraining.kutsko.task1.view.creator.FilePrinterCreator;
import by.epam.javatraining.kutsko.task1.view.creator.PrinterFactory;

public class Controller {
	
	public static final String FILE_PATH = "data.txt"; 

	public static void main(String[] args)  {
		List<String> rawData = DataReader.readFromFile(FILE_PATH);
		
		StoreCreator storeCreator = StoreCreator.getInstance();
		ClothingStore store = null;
		try {
			store = storeCreator.fillWarehouse(rawData);
		} catch (ContainerFullException e) {
		}
		
		PrinterFactory creator = PrinterFactory.getInstance();
		Printer filePrinter = creator.getPrinter(new FilePrinterCreator());
		Printer consolePrinter = creator.getPrinter(new ConsolePrinterCreator());
		String contents = store.toString();
		filePrinter.print(contents); 
		
		try {
			Sorter.fastPriceSort(store);
		} catch (CorruptContainerReferenceException e1) {} 
		try {
			System.out.println(Finder.binarySearchByPrice(store, 20.00));
		} catch (UnsortedItemSetException e1) {
		}
		
		double totalPrice = 0;
		String totalPriceAsString =  "";
		try {
			totalPrice = Calculator.calculatePriceOfItems(store);
			totalPriceAsString = String.valueOf(totalPrice);
			consolePrinter.print(ClothingStore.STORE_TOTAL_HEADER + totalPriceAsString);
		} catch (CorruptContainerReferenceException e) {}
		
		ShoppingBasket basket = BasketCreator.createBasket();
		ItemSelector.selectItems(store, basket);
		//contents = basket.toString();
		//consolePrinter.print(contents);
		
		try {
			totalPrice = Calculator.calculatePriceOfItems(basket);
			totalPriceAsString = StringCreator.convertToString(totalPrice);
			consolePrinter.print(ShoppingBasket.BASKET_TOTAL_HEADER + totalPriceAsString);
		} catch (CorruptContainerReferenceException e) {}
		
		Item[] matchingItems;
		try {
			matchingItems = Finder.findAllOfColor(store, Item.Color.BLACK);
			contents = StringCreator.convertToString(matchingItems);
			consolePrinter.print(contents);
		} catch (CorruptContainerReferenceException e) {}
		
		
	}
	
}

