package by.epam.javatraining.kutsko.task1.util.reader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
	
	public static List<String> readFromFile(String path) throws IOException {
		BufferedReader fis = new BufferedReader(new FileReader(path));
		List<String> listOfStrings = new ArrayList<String>();
		String line;
		while ((line = fis.readLine()) != null) {
			listOfStrings.add(line);
		}
		return listOfStrings;
	}
}
