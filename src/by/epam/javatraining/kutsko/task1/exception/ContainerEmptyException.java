package by.epam.javatraining.kutsko.task1.exception;

public class ContainerEmptyException extends Exception {
	
	public ContainerEmptyException() {
		super();
	}

	public ContainerEmptyException(String arg0) {
		super(arg0);
	}

	public ContainerEmptyException(Throwable arg0) {
		super(arg0);
	}

	public ContainerEmptyException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ContainerEmptyException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}
}
