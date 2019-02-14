package by.epam.javatraining.kutsko.task1.controller;

import by.epam.javatraining.kutsko.task1.model.container.ClothingStore;
import by.epam.javatraining.kutsko.task1.model.creator.*;
import by.epam.javatraining.kutsko.task1.model.entity.*;
import by.epam.javatraining.kutsko.task1.exception.*;

public class Controller {

	public static void main(String[] args) {
		ClothingStore store = new ClothingStore();
		Item item = Creator.getItem(new JumperCreator());
		Item item2 = Creator.getItem(new ScarfCreator());
		Item item3 = Creator.getItem(new HighHeelsCreator());
		try {
			store.addProduct(item);
			store.addProduct(item2);
			store.addProduct(item3);
		} catch (WarehouseFullException | NonexistentArgumentException e) {
			System.out.println(e);
		}
		System.out.println(store.getCurrentAmountOfProducts());
		System.out.println(store);
	}

}
