package by.epam.javatraining.kutsko.task1.model.exception;

public class CorruptContainerReferenceException extends ClothingStoreTechnicalException {
	
	public CorruptContainerReferenceException() {
		super();
	}

	public CorruptContainerReferenceException(String arg) {
		super(arg);
	}

	public CorruptContainerReferenceException(Throwable arg) {
		super(arg);
	}

	public CorruptContainerReferenceException(String arg, Throwable cause) {
		super(arg, cause);
	}
}
