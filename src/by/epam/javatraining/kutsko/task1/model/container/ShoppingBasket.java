package by.epam.javatraining.kutsko.task1.model.container;

import by.epam.javatraining.kutsko.task1.exception.InvalidArgumentException;
import by.epam.javatraining.kutsko.task1.exception.NoSuchItemException;
import by.epam.javatraining.kutsko.task1.exception.NonexistentArgumentException;
import by.epam.javatraining.kutsko.task1.exception.WarehouseFullException;
import by.epam.javatraining.kutsko.task1.model.entity.Item;

public class ShoppingBasket extends Container {
	
	public final static int MAX_CAPACITY = 5;
	
	public ShoppingBasket() {
		super(MAX_CAPACITY);
	}
	
	public ShoppingBasket(int capacity) {
		super(capacity);
	}
	
	public void addProductToBasket(Item item) 
			throws WarehouseFullException, NonexistentArgumentException, InvalidArgumentException {
		if (!item.isSelected()) {
		/* try { */
			super.addProduct(item);
			item.setSelected(true);
		/* } catch (WarehouseFullException | NonexistentArgumentException e) {
			throw e;
			}
		} else {
			throw new InvalidArgumentException("The item has already been selected");*/
		} 
	}
	
	public void removeProductFromBasket(Item item) 
			/* throws NonexistentArgumentException, NoSuchItemException, InvalidArgumentException */ {
		if (item.isSelected()) {
		/* try { */
			super.removeProduct(item);
			item.setSelected(false);
		/* } catch (NoSuchItemException | NonexistentArgumentException e) {
			throw e;
		}
		} else {
			throw new InvalidArgumentException("The item was not selected"); */
		}
	}
}
