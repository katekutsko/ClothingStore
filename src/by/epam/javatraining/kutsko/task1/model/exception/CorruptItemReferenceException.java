package by.epam.javatraining.kutsko.task1.model.exception;

public class CorruptItemReferenceException extends ClothingStoreTechnicalException {

	public CorruptItemReferenceException() {
		super();
	}

	public CorruptItemReferenceException(String message) {
		super(message);
	}

	public CorruptItemReferenceException(Throwable cause) {
		super(cause);
	}

	public CorruptItemReferenceException(String message, Throwable cause) {
		super(message, cause);
	}

}
