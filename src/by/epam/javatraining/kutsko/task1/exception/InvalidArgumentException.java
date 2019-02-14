package by.epam.javatraining.kutsko.task1.exception;

public class InvalidArgumentException extends Exception {

	public InvalidArgumentException() {
		super();
	}

	public InvalidArgumentException(String message) {
		super(message);
	}

	public InvalidArgumentException(Throwable cause) {
		super(cause);
	}

	public InvalidArgumentException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidArgumentException(Number parameter) {
		super("Parameter " + parameter + " is not appropriate");
	}

	public InvalidArgumentException(String message, Number parameter) {
		super("Number " + parameter + "is not appropriate. " + message);
	}
}
