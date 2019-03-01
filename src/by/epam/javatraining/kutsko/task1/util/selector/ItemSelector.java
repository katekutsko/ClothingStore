package by.epam.javatraining.kutsko.task1.util.selector;

import java.util.Random;

import by.epam.javatraining.kutsko.task1.model.container.*;
import by.epam.javatraining.kutsko.task1.model.exception.ContainerFullException;
import by.epam.javatraining.kutsko.task1.model.exception.NoSuchItemException;

public class ItemSelector {
	public static void selectItems(ClothingStore store, ShoppingBasket basket) {
		Random random = new Random();
		int basketCapacity = basket.getCapacity();
		int storeSupply = store.getCurrentAmountOfProducts();
		for (int i = 0; i < basketCapacity; i++) {
			int index = random.nextInt(storeSupply);
			try {
				basket.addProduct(store.getItem(index));
			} catch (NoSuchItemException e) {} 
			catch (ContainerFullException e) {
				break;
			}
		}
	}
}
