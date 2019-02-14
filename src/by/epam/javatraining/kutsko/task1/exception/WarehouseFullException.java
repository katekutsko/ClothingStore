package by.epam.javatraining.kutsko.task1.exception;

public class WarehouseFullException extends Exception {

	public WarehouseFullException() {
		super();
	}

	public WarehouseFullException(String message) {
		super(message);
	}

	public WarehouseFullException(Throwable cause) {
		super(cause);
	}

	public WarehouseFullException(String message, Throwable cause) {
		super(message, cause);
	}
}
