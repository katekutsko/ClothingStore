package by.epam.javatraining.kutsko.task1.model.exception;

public class ClothingStoreTechnicalException extends ClothingStoreException {

	public ClothingStoreTechnicalException() {
		super();
	}
	
	public ClothingStoreTechnicalException(String message) {
		super(message);
	}
	
	public ClothingStoreTechnicalException(Throwable cause) {
		super(cause);
	}
	
	public ClothingStoreTechnicalException(String message, Throwable cause) {
		super(message, cause);
	}
}
