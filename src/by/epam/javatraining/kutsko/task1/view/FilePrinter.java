package by.epam.javatraining.kutsko.task1.view;

import java.io.FileWriter;
import java.io.IOException;

import by.epam.javatraining.kutsko.task1.model.container.Container;

public class FilePrinter implements Printer {

	@Override
	public void print(Container container) throws IOException {
		FileWriter fw = new FileWriter("output.txt");
		fw.append(container.toString());
		fw.flush();
		fw.close();
	}

}
