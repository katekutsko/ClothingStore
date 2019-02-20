package by.epam.javatraining.kutsko.task1.view;

import by.epam.javatraining.kutsko.task1.model.container.Container;

public class ConsolePrinter implements Printer {

	@Override
	public void print(Container container) {
		System.out.println(container);
	}

}
