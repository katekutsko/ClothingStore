package by.epam.javatraining.kutsko.task1.model.container;

import by.epam.javatraining.kutsko.task1.model.exception.ContainerFullException;

public class ShoppingBasketFullException extends ContainerFullException {

	public ShoppingBasketFullException() {
		super();
	}

	public ShoppingBasketFullException(String message) {
		super(message);
	}

}
