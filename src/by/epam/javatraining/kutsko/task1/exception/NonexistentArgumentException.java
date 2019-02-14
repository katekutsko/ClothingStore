package by.epam.javatraining.kutsko.task1.exception;

public class NonexistentArgumentException extends Exception {

	public NonexistentArgumentException() {
		super("Parameter must not be a negative number");
	}

	public NonexistentArgumentException(String message) {
		super(message);
	}

	public NonexistentArgumentException(Throwable cause) {
		super(cause);
	}

	public NonexistentArgumentException(String message, Throwable cause) {
		super(message, cause);
	}

	public NonexistentArgumentException(double discount) {
		super("Number " + discount + "is negative. Parameter must not be a negative number");
	}

	public NonexistentArgumentException( String message, double discount) {
		super("Number " + discount + "is negative. " + message);
	}
}
