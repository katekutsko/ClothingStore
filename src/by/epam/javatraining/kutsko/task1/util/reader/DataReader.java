package by.epam.javatraining.kutsko.task1.util.reader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
	
	public static List<String> readFromFile(String path) {
		List<String> listOfStrings = new ArrayList<String>();
		BufferedReader fis;
		String line;
		try {
			fis = new BufferedReader(new FileReader(path));
			while ((line = fis.readLine()) != null) {
				listOfStrings.add(line);
			}
			fis.close();
		} catch (IOException e) {}
		return listOfStrings;
	}
}
