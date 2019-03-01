package by.epam.javatraining.kutsko.task1.model.exception;

public class CorruptContainerReferenceException extends Exception {
	
	public CorruptContainerReferenceException() {
		super();
	}

	public CorruptContainerReferenceException(String arg0) {
		super(arg0);
	}

	public CorruptContainerReferenceException(Throwable arg0) {
		super(arg0);
	}

	public CorruptContainerReferenceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public CorruptContainerReferenceException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}
}
