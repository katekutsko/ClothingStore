package by.epam.javatraining.kutsko.task1.exception;

public class NoSuchItemException extends Exception {

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
