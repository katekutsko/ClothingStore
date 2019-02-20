package by.epam.javatraining.kutsko.task1.model.container;

import by.epam.javatraining.kutsko.task1.exception.InvalidArgumentException;
import by.epam.javatraining.kutsko.task1.exception.NoSuchItemException;
import by.epam.javatraining.kutsko.task1.exception.NonexistentArgumentException;
import by.epam.javatraining.kutsko.task1.exception.WarehouseFullException;
import by.epam.javatraining.kutsko.task1.model.entity.Item;

public class ShoppingBasket extends Container {
	
	public final static int DEFAULT_CAPACITY = 5;
	
	public ShoppingBasket() {
		super(DEFAULT_CAPACITY);
	}
	
	public ShoppingBasket(int capacity) {
		super(capacity);
	}
	
	//нужно ли все-таки здесь выбрасывать исключение?
	public boolean addProductToBasket(Item item) {
		if ((item != null) && (!item.isSelected())) {
				super.addProduct(item);
				item.setSelected(true);
				return true;
		} else {
			return false;
		} 
	}
	
	public void removeProductFromBasket(int index) 
			 throws NonexistentArgumentException, NoSuchItemException, InvalidArgumentException {
		super.removeProduct(index);
		super.getItemSet()[index].setSelected(false);
	} 
	
	public Item[] getItemSet() {
		return super.getItemSet();
	}
	
	@Override
	public String toString() {
		Item[] thisItemSet = super.getItemSet();
		if (thisItemSet != null) {
			StringBuilder builder = new StringBuilder("Contents of shopping basket:\n");
			for (int i = 0; i < super.getCurrentAmountOfProducts(); i++) {
				builder.append(thisItemSet[i].toString());
				builder.append("\n");
			}
			return builder.toString();
		} else {
			return "A problem occured with this shopping basket";
		}
	}
}
