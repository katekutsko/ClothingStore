package by.epam.javatraining.kutsko.task1.model.exception;

public class ClothingStoreException extends Exception {

	public ClothingStoreException() {}

	public ClothingStoreException(String arg) {
		super(arg);
		}

	public ClothingStoreException(Throwable cause) {
		super(cause);
		}

	public ClothingStoreException(String arg, Throwable cause) {
		super(arg, cause);
	}
}
