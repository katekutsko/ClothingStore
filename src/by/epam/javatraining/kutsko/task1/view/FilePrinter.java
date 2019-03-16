package by.epam.javatraining.kutsko.task1.view;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class FilePrinter implements Printable {

	private static final Logger LOGGER;
	private String filePath;

	static {
		LOGGER = Logger.getRootLogger();
		PropertyConfigurator.configure("log4j.properties");
	}
	
	public FilePrinter() {
		filePath = "output.txt";
	}

	public FilePrinter(String filePath) {
		this();
		if (filePath != null) {
			this.filePath = filePath;
		}
		else {
			LOGGER.warn("File name was null, default output.txt file was created");
		}
	}

	@Override
	public void print(String data) {
		try {
			PrintStream stream = new PrintStream(new FileOutputStream(filePath));
			stream.append(data);
			stream.flush();
			stream.close();
		} catch (IOException e) {
			LOGGER.warn("Output was not successful");
		}
	}

}
