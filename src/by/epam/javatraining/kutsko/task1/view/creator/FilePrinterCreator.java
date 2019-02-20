package by.epam.javatraining.kutsko.task1.view.creator;

import by.epam.javatraining.kutsko.task1.view.FilePrinter;
import by.epam.javatraining.kutsko.task1.view.Printer;

public class FilePrinterCreator implements AbstractViewerCreator {

	public Printer create() {
		return new FilePrinter();
	}

}
