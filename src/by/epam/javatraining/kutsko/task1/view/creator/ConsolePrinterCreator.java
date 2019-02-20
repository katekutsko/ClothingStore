package by.epam.javatraining.kutsko.task1.view.creator;

import by.epam.javatraining.kutsko.task1.view.ConsolePrinter;
import by.epam.javatraining.kutsko.task1.view.Printer;

public class ConsolePrinterCreator implements AbstractViewerCreator {

	public Printer create() {
		return new ConsolePrinter();
	}

}
