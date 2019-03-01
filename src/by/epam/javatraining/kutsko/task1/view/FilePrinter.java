package by.epam.javatraining.kutsko.task1.view;

import java.io.FileWriter;
import java.io.IOException;

import by.epam.javatraining.kutsko.task1.model.container.Container;

public class FilePrinter implements Printer {

	public static final String FILE_PATH = "output.txt";
	
	@Override
	public void print(String data) {
		try {
			FileWriter fw = new FileWriter(FILE_PATH);
			fw.append(data);
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace(); //Как можно обработать исключения здесь, если само создание файла или FileWriter и провоцирует исключение
		}
	}

}
