package by.epam.javatraining.kutsko.task1.view;

import java.io.IOException;

import by.epam.javatraining.kutsko.task1.model.container.Container;

public interface Printer {
	public void print(Container container) throws IOException;
}
