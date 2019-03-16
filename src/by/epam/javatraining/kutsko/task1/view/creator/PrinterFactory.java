package by.epam.javatraining.kutsko.task1.view.creator;

import by.epam.javatraining.kutsko.task1.view.Printable;

public class PrinterFactory {
	
	private static PrinterFactory creator;
	
	private PrinterFactory() {}
	
	public Printable getPrinter(AbstractViewerCreator creator) {
		return creator.create();
	}
	
	public static PrinterFactory getInstance() {
		if (creator == null) {
			creator = new PrinterFactory();
		}
		return creator;
	}
}
