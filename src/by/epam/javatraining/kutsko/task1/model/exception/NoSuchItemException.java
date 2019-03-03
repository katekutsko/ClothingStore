package by.epam.javatraining.kutsko.task1.model.exception;

public class NoSuchItemException extends ClothingStoreTechnicalException {

	public NoSuchItemException() {
		super();
	}

	public NoSuchItemException(String message) {
		super(message);
	}

	public NoSuchItemException(Throwable cause) {
		super(cause);
	}

	public NoSuchItemException(String message, Throwable cause) {
		super(message, cause);
	}
}
